#!/usr/bin/env python3
"""Sanity checks: registry names vs JSON references, textures, lang coverage."""
import json
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RES = os.path.join(ROOT, "src/main/resources")
JAVA = os.path.join(ROOT, "src/main/java/com/arena/randommobs")
problems = []


def java_names(path, field):
    src = open(os.path.join(JAVA, path)).read()
    return re.findall(field + r'\("([a-z0-9_]+)"', src)


items = set(java_names("registry/ModItems.java", r'register')) | set(java_names("registry/ModItems.java", r'spawnEgg'))
blocks = set(java_names("registry/ModBlocks.java", r'registerWithItem'))
entities = set(java_names("registry/ModEntities.java", r'ENTITIES\.register'))
# spawn eggs are registered through spawnEgg("x_spawn_egg", ...)
eggs = set(re.findall(r'spawnEgg\("([a-z0-9_]+)"', open(os.path.join(JAVA, "registry/ModItems.java")).read()))
items |= eggs

advancements = {os.path.splitext(f)[0] for f in os.listdir(os.path.join(RES, "data/randommobs/advancements"))}
biomes = {os.path.splitext(f)[0] for f in os.listdir(os.path.join(RES, "data/randommobs/worldgen/biome"))}
structures = {os.path.splitext(f)[0] for f in os.listdir(os.path.join(RES, "data/randommobs/worldgen/structure"))}

known = {
    "item": items,
    "block": blocks,
    "entity_type": entities,
    "advancement": advancements,
    "biome": biomes,
}

texture_dirs = {
    "item": os.path.join(RES, "assets/randommobs/textures/item"),
    "block": os.path.join(RES, "assets/randommobs/textures/block"),
}


def walk_json():
    for root, dirs, files in os.walk(RES):
        for f in files:
            if f.endswith(".json"):
                yield os.path.join(root, f)


namespaces = ("randommobs",)
referenced = {}
for path in walk_json():
    text = open(path, encoding="utf-8").read()
    try:
        json.loads(text)
    except Exception as exc:
        problems.append("invalid json %s: %s" % (path, exc))
        continue
    for m in re.finditer(r'"randommobs:([a-z0-9_./]+)"', text):
        referenced.setdefault(m.group(1), set()).add(os.path.relpath(path, RES))

worldgen = set()
for folder in ("worldgen/configured_feature", "worldgen/placed_feature", "worldgen/template_pool",
               "worldgen/structure", "worldgen/biome", "dimension", "dimension_type"):
    worldgen |= {os.path.splitext(f)[0] for f in os.listdir(os.path.join(RES, "data/randommobs", folder))}
all_names = items | blocks | entities | advancements | worldgen | {"touch"}
for name, where in sorted(referenced.items()):
    rel = name.split("/")[0]
    plain = name.split("/")[-1]
    if rel in ("item", "block"):
        if not os.path.exists(os.path.join(texture_dirs[rel], name[len(rel) + 1:] + ".png")):
            problems.append("missing texture randommobs:%s (%s)" % (name, ", ".join(sorted(where))))
        continue
    if os.path.exists(os.path.join(RES, "data/randommobs/structures", name + ".nbt")):
        continue
    if rel == "textures":
        if not os.path.exists(os.path.join(RES, "assets/randommobs", name + ".png")):
            problems.append("missing texture randommobs:%s" % name)
        continue
    if plain not in all_names and plain not in items and name not in all_names:
        problems.append("unknown reference randommobs:%s in %s" % (name, ", ".join(sorted(where))))

# missing models for items / block items
models = os.path.join(RES, "assets/randommobs/models/item")
for name in sorted(items | blocks):
    if not os.path.exists(os.path.join(models, name + ".json")):
        problems.append("missing item model for " + name)
for name in sorted(blocks):
    if not os.path.exists(os.path.join(RES, "assets/randommobs/blockstates", name + ".json")):
        problems.append("missing blockstate for " + name)
    if not os.path.exists(os.path.join(RES, "data/randommobs/loot_tables/blocks", name + ".json")):
        problems.append("missing block loot table for " + name)
for name in sorted(entities):
    if not os.path.exists(os.path.join(RES, "data/randommobs/loot_tables/entities", name + ".json")):
        problems.append("missing entity loot table for " + name)
    if not os.path.exists(os.path.join(RES, "assets/randommobs/textures/entity", name + ".png")):
        problems.append("missing entity texture for " + name)

# lang coverage
for lang in ("en_us", "ru_ru"):
    data = json.load(open(os.path.join(RES, "assets/randommobs/lang", lang + ".json"), encoding="utf-8"))
    for name in sorted(items | blocks):
        if "item.randommobs." + name not in data and "block.randommobs." + name not in data:
            problems.append("%s missing name for %s" % (lang, name))
    for name in sorted(entities):
        if "entity.randommobs." + name not in data:
            problems.append("%s missing entity name for %s" % (lang, name))
    for name in sorted(advancements):
        for suffix in ("title", "description"):
            key = "advancement.randommobs.%s.%s" % (name, suffix)
            if key not in data:
                problems.append("%s missing %s" % (lang, key))

# advancement parents must exist
for name in sorted(advancements):
    data = json.load(open(os.path.join(RES, "data/randommobs/advancements", name + ".json"), encoding="utf-8"))
    parent = data.get("parent")
    if parent and parent.split(":")[1] not in advancements:
        problems.append("advancement %s has unknown parent %s" % (name, parent))

# structures referenced by structure sets must exist
for f in os.listdir(os.path.join(RES, "data/randommobs/worldgen/structure_set")):
    data = json.load(open(os.path.join(RES, "data/randommobs/worldgen/structure_set", f), encoding="utf-8"))
    for entry in data["structures"]:
        sid = entry["structure"].split(":")[1]
        if sid not in structures:
            problems.append("structure set %s references missing structure %s" % (f, sid))
        if not os.path.exists(os.path.join(RES, "data/randommobs/tags/worldgen/biome/has_structure", sid + ".json")):
            problems.append("missing biome tag for structure " + sid)

print("\n".join(problems) if problems else "ALL CHECKS PASSED")
print("\nitems:", len(items), "blocks:", len(blocks), "entities:", len(entities), "advancements:", len(advancements))
