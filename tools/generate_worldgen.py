#!/usr/bin/env python3
"""Generates biomes, dimensions, placed/configured features, structures and their JSON."""
import json
import os

import nbtlib
from nbtlib import Byte, Compound, Double, Int, List, String

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
DATA = os.path.join(ROOT, "src/main/resources/data/randommobs")
DATA_VERSION = 3465


def write(path, obj):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as fh:
        json.dump(obj, fh, ensure_ascii=False, indent=2)
        fh.write("\n")


# --------------------------------------------------------------------------- biomes
def spawn(kind, weight, min_count, max_count):
    return {"type": kind, "weight": weight, "minCount": min_count, "maxCount": max_count}


BIOMES = {
    "rooted_forest": {
        "temperature": 0.8,
        "downfall": 0.9,
        "effects": {
            "sky_color": 0x2A0F0A,
            "fog_color": 0x3A1A12,
            "water_color": 0x8F2B14,
            "water_fog_color": 0x4A1508,
            "grass_color": 0x6B3A1B,
            "foliage_color": 0x8F4A28,
            "mood_sound": {
                "sound": "minecraft:ambient.cave",
                "tick_delay": 6000,
                "block_search_extent": 8,
                "offset": 2.0,
            },
        },
        "spawners": {
            "monster": [
                spawn("randommobs:woodcrawler", 40, 1, 3),
                spawn("randommobs:gardener", 25, 1, 2),
                spawn("randommobs:evil_watermelon", 20, 1, 2),
                spawn("randommobs:alive_tree", 12, 1, 1),
                spawn("randommobs:giant_spider", 4, 1, 1),
                spawn("randommobs:tripod", 2, 1, 1),
            ],
            "creature": [spawn("randommobs:woodcock", 12, 1, 3)],
            "water_creature": [spawn("randommobs:kraken", 2, 1, 1)],
        },
        "features": {
            "9": ["randommobs:red_roots_patch", "randommobs:mockery_bloom_patch", "minecraft:trees_plains",
                  "minecraft:patch_grass_plain"],
            "7": ["minecraft:glow_lichen"],
        },
    },
    "bloop_trench": {
        "temperature": 0.4,
        "downfall": 0.5,
        "effects": {
            "sky_color": 0x050F18,
            "fog_color": 0x04101A,
            "water_color": 0x0A2A3C,
            "water_fog_color": 0x04121C,
            "mood_sound": {
                "sound": "minecraft:ambient.cave",
                "tick_delay": 4000,
                "block_search_extent": 8,
                "offset": 2.0,
            },
        },
        "spawners": {
            "monster": [
                spawn("randommobs:bloop", 8, 1, 1),
                spawn("randommobs:kraken", 12, 1, 1),
                spawn("randommobs:gardener", 18, 1, 2),
            ],
            "creature": [],
            "water_creature": [spawn("minecraft:squid", 10, 1, 3)],
        },
        "features": {
            "9": ["minecraft:seagrass_normal", "minecraft:kelp_cold"],
        },
    },
    "scorched_plains": {
        "temperature": 2.0,
        "downfall": 0.0,
        "effects": {
            "sky_color": 0x6B3A1B,
            "fog_color": 0x5A2A12,
            "water_color": 0x3A2A1A,
            "water_fog_color": 0x2A1A10,
            "grass_color": 0x8A6A3A,
            "foliage_color": 0x7A5A2A,
        },
        "spawners": {
            "monster": [
                spawn("randommobs:sand_worm", 25, 1, 2),
                spawn("randommobs:tripod", 10, 1, 1),
                spawn("randommobs:ufo", 6, 1, 1),
            ],
            "creature": [],
            "water_creature": [],
        },
        "features": {
            "9": ["minecraft:patch_dead_bush", "randommobs:red_roots_patch"],
        },
    },
}


def build_biome(data):
    features = [[] for _ in range(11)]
    for index, entries in data["features"].items():
        features[int(index)] = entries
    return {
        "has_precipitation": data["downfall"] > 0.0,
        "temperature": data["temperature"],
        "downfall": data["downfall"],
        "effects": data["effects"],
        "spawners": data["spawners"],
        "spawn_costs": {},
        "carvers": {
            "air": ["minecraft:cave", "minecraft:cave_extra_underground", "minecraft:canyon"],
        },
        "features": features,
    }


def features():
    write(os.path.join(DATA, "worldgen/configured_feature/red_roots_patch.json"), {
        "type": "minecraft:simple_block",
        "config": {"to_place": {"type": "minecraft:simple_state_provider",
                                "state": {"Name": "randommobs:red_roots"}}},
    })
    write(os.path.join(DATA, "worldgen/placed_feature/red_roots_patch.json"), {
        "feature": "randommobs:red_roots_patch",
        "placement": [
            {"type": "minecraft:count", "count": {"type": "minecraft:uniform",
                                                  "value": {"min_inclusive": 8, "max_inclusive": 18}}},
            {"type": "minecraft:in_square"},
            {"type": "minecraft:heightmap", "heightmap": "WORLD_SURFACE_WG"},
            {"type": "minecraft:biome"},
        ],
    })
    write(os.path.join(DATA, "worldgen/configured_feature/mockery_bloom_patch.json"), {
        "type": "minecraft:simple_block",
        "config": {"to_place": {"type": "minecraft:simple_state_provider",
                                "state": {"Name": "randommobs:mockery_bloom"}}},
    })
    write(os.path.join(DATA, "worldgen/placed_feature/mockery_bloom_patch.json"), {
        "feature": "randommobs:mockery_bloom_patch",
        "placement": [
            {"type": "minecraft:count", "count": 2},
            {"type": "minecraft:in_square"},
            {"type": "minecraft:heightmap", "heightmap": "WORLD_SURFACE_WG"},
            {"type": "minecraft:biome"},
        ],
    })


# --------------------------------------------------------------------------- dimensions
def dimensions():
    def dim_type(name, fixed_time=None, ambient=0.1):
        data = {
            "ultrawarm": False,
            "natural": True,
            "coordinate_scale": 1.0,
            "has_skylight": True,
            "has_ceiling": False,
            "ambient_light": ambient,
            "monster_spawn_light_level": {"type": "minecraft:uniform",
                                          "value": {"min_inclusive": 0, "max_inclusive": 15}},
            "monster_spawn_block_light_limit": 15,
            "piglin_safe": False,
            "bed_works": True,
            "respawn_anchor_works": False,
            "has_raids": False,
            "logical_height": 384,
            "min_y": -64,
            "height": 384,
            "infiniburn": "#minecraft:infiniburn_overworld",
            "effects": "minecraft:overworld",
        }
        if fixed_time is not None:
            data["fixed_time"] = fixed_time
        write(os.path.join(DATA, "dimension_type", name + ".json"), data)

    dim_type("rooted_world", fixed_time=18000, ambient=0.18)
    dim_type("bloop_trench", fixed_time=18000, ambient=0.05)
    dim_type("scorched_world", fixed_time=6000, ambient=0.25)

    for dimension, biome, dim_type_name in (
            ("rooted_world", "rooted_forest", "rooted_world"),
            ("trench_world", "bloop_trench", "bloop_trench"),
            ("scorched_world", "scorched_plains", "scorched_world")):
        write(os.path.join(DATA, "dimension", dimension + ".json"), {
            "type": "randommobs:" + dim_type_name,
            "generator": {
                "type": "minecraft:noise",
                "settings": "minecraft:overworld",
                "biome_source": {"type": "minecraft:fixed", "biome": "randommobs:" + biome},
            },
        })


# --------------------------------------------------------------------------- structures
class Structure:
    def __init__(self, name, size):
        self.name = name
        self.size = size
        self.blocks = {}
        self.entities = []

    def put(self, x, y, z, name, props=None):
        if 0 <= x < self.size[0] and 0 <= y < self.size[1] and 0 <= z < self.size[2]:
            self.blocks[(x, y, z)] = (name, props or {})

    def fill(self, x0, y0, z0, x1, y1, z1, name, props=None):
        for x in range(min(x0, x1), max(x0, x1) + 1):
            for y in range(min(y0, y1), max(y0, y1) + 1):
                for z in range(min(z0, z1), max(z0, z1) + 1):
                    self.put(x, y, z, name, props)

    def entity(self, x, y, z, entity_id, persistent=True):
        self.entities.append({"pos": [x + 0.5, y, z + 0.5], "id": entity_id,
                              "persistent": persistent})

    def save(self):
        palette = []
        lookup = {}
        blocks = []
        for pos in sorted(self.blocks):
            name, props = self.blocks[pos]
            key = ( name, tuple(sorted(props.items())))
            if key not in lookup:
                entry = {"Name": name}
                if props:
                    entry["Properties"] = dict(props)
                lookup[key] = len(palette)
                palette.append(entry)
            blocks.append({"pos": list(pos), "state": lookup[key]})

        entities = []
        for e in self.entities:
            tag = Compound({"id": String(e["id"])})
            if e.get("persistent"):
                tag["PersistenceRequired"] = Byte(1)
            entities.append({
                "pos": List[Double]([Double(v) for v in e["pos"]]),
                "blockPos": List[Int]([Int(int(v)) for v in e["pos"]]),
                "nbt": tag,
            })

        palette_tags = []
        for p in palette:
            entry = {"Name": String(p["Name"])}
            if "Properties" in p:
                entry["Properties"] = Compound({k: String(v) for k, v in p["Properties"].items()})
            palette_tags.append(Compound(entry))

        block_tags = []
        for b in blocks:
            block_tags.append(Compound({
                "pos": List[Int]([Int(v) for v in b["pos"]]),
                "state": Int(b["state"]),
            }))

        root = Compound({
            "DataVersion": Int(DATA_VERSION),
            "size": List[Int]([Int(v) for v in self.size]),
            "palette": List[Compound](palette_tags),
            "blocks": List[Compound](block_tags),
            "entities": List[Compound](entities),
        })
        path = os.path.join(DATA, "structures", self.name + ".nbt")
        os.makedirs(os.path.dirname(path), exist_ok=True)
        nbtlib.File(root, gzipped=True).save(path)


def structure_json(name, biomes, spacing, separation, salt, step="surface_structures",
                   heightmap="WORLD_SURFACE_WG", terrain="beard_thin"):
    write(os.path.join(DATA, "worldgen/structure", name + ".json"), {
        "type": "minecraft:jigsaw",
        "biomes": "#randommobs:has_structure/" + name,
        "step": step,
        "spawn_overrides": {},
        "terrain_adaptation": terrain,
        "start_pool": "randommobs:" + name,
        "size": 1,
        "start_height": {"absolute": 0},
        "project_start_to_heightmap": heightmap,
        "max_distance_from_center": 80,
        "use_expansion_hack": False,
    })
    write(os.path.join(DATA, "worldgen/template_pool", name + ".json"), {
        "fallback": "minecraft:empty",
        "elements": [{
            "weight": 1,
            "element": {
                "element_type": "minecraft:single_pool_element",
                "location": "randommobs:" + name + "/main",
                "processors": "minecraft:empty",
                "projection": "rigid",
            },
        }],
    })
    write(os.path.join(DATA, "worldgen/structure_set", name + ".json"), {
        "structures": [{"structure": "randommobs:" + name, "weight": 1}],
        "placement": {
            "type": "minecraft:random_spread",
            "spacing": spacing,
            "separation": separation,
            "salt": salt,
        },
    })
    write(os.path.join(DATA, "tags/worldgen/biome/has_structure", name + ".json"),
          {"values": biomes})


def build_structures():
    # --- crashed tripod -----------------------------------------------------
    s = Structure("tripod_crash/main", (17, 11, 17))
    for x in range(17):
        for z in range(17):
            dx, dz = x - 8, z - 8
            dist = (dx * dx + dz * dz) ** 0.5
            if dist <= 8:
                s.put(x, 0, z, "minecraft:coarse_dirt")
            if dist <= 5:
                s.put(x, 0, z, "minecraft:gravel")
                s.put(x, 1, z, "minecraft:air")
            if dist <= 2:
                s.put(x, 0, z, "minecraft:magma_block")
    for x in range(3, 14):
        for z in range(3, 14):
            for y in range(1, 9):
                s.put(x, y, z, "minecraft:air")
    # three broken legs
    for i, (bx, bz, dy) in enumerate(((5, 5, 1), (11, 6, 0), (8, 12, 1))):
        for y in range(1, 7):
            s.put(bx + (y // 3), y, bz, "randommobs:alien_metal_block")
        s.put(bx + 2, 6, bz, "randommobs:alien_metal_block")
        s.put(bx + 1, 7, bz, "minecraft:magma_block")
    s.put(8, 2, 8, "randommobs:alien_metal_block")
    s.put(8, 3, 8, "randommobs:alien_metal_block")
    s.put(7, 3, 8, "minecraft:magma_block")
    s.put(9, 3, 8, "minecraft:fire")
    s.save()

    # --- root shrine --------------------------------------------------------
    s = Structure("root_shrine/main", (13, 10, 13))
    for x in range(13):
        for z in range(13):
            s.put(x, 0, z, "randommobs:red_root_block")
    for x in range(13):
        for z in range(13):
            for y in range(1, 10):
                if 2 <= x <= 10 and 2 <= z <= 10:
                    s.put(x, y, z, "minecraft:air")
    for px, pz in ((3, 3), (9, 3), (3, 9), (9, 9)):
        for y in range(1, 5):
            s.put(px, y, pz, "randommobs:red_root_block")
        s.put(px, 5, pz, "randommobs:mockery_bloom")
    s.put(6, 1, 6, "randommobs:mockery_bloom")
    s.put(5, 1, 6, "randommobs:red_roots")
    s.put(7, 1, 6, "randommobs:red_roots")
    s.put(6, 1, 5, "randommobs:root_liana")
    s.put(6, 2, 5, "randommobs:root_liana")
    s.put(6, 6, 6, "minecraft:lantern", {"hanging": "true"})
    s.entity(6, 1, 6, "randommobs:gardener")
    s.save()
    structure_json("root_shrine", ["#minecraft:is_jungle", "minecraft:dark_forest",
                                   "randommobs:rooted_forest"], 34, 12, 7311)

    # --- sunken grove -------------------------------------------------------
    s = Structure("sunken_grove/main", (21, 12, 21))
    for x in range(21):
        for z in range(21):
            dx, dz = x - 10, z - 10
            dist = (dx * dx + dz * dz) ** 0.5
            if dist <= 10:
                s.put(x, 0, z, "randommobs:bloop_flesh_block")
            if dist <= 6:
                s.put(x, 0, z, "randommobs:red_root_block")
            for y in range(1, 8):
                s.put(x, y, z, "minecraft:water")
    for px, pz in ((4, 10), (16, 10), (10, 4), (10, 16)):
        for y in range(1, 5):
            s.put(px, y, pz, "randommobs:red_root_block")
        s.put(px, 5, pz, "randommobs:mockery_bloom")
    for y in range(1, 4):
        s.put(10, y, 10, "randommobs:red_root_block")
    s.put(10, 4, 10, "randommobs:mockery_bloom")
    s.entity(10, 1, 12, "randommobs:gardener")
    s.save()
    structure_json("sunken_grove", ["minecraft:deep_ocean", "minecraft:deep_cold_ocean",
                                    "minecraft:deep_lukewarm_ocean", "minecraft:deep_frozen_ocean",
                                    "randommobs:bloop_trench"], 40, 14, 4412,
                   step="surface_structures", heightmap="OCEAN_FLOOR_WG", terrain="none")

    # --- ruined living house -----------------------------------------------
    s = Structure("living_house/main", (11, 7, 11))
    for x in range(11):
        for z in range(11):
            s.put(x, 0, z, "minecraft:oak_planks" if (x + z) % 3 else "minecraft:cobblestone")
            for y in range(1, 7):
                s.put(x, y, z, "minecraft:air")
    # broken walls, only one or two blocks high
    for x in range(11):
        for z in range(11):
            if (x in (1, 9) or z in (1, 9)) and (x + z) % 4 != 0:
                s.put(x, 1, z, "minecraft:oak_planks")
                if (x + z) % 3 == 0:
                    s.put(x, 2, z, "minecraft:oak_planks")
    s.put(5, 1, 1, "minecraft:oak_door", {"facing": "north", "half": "lower", "hinge": "left", "open": "false", "powered": "false"})
    s.put(5, 2, 1, "minecraft:oak_door", {"facing": "north", "half": "upper", "hinge": "left", "open": "false", "powered": "false"})
    # leftover roof beams
    for x in range(2, 9, 2):
        s.put(x, 3, 2, "minecraft:oak_fence")
        s.put(x, 3, 8, "minecraft:oak_fence")
    s.put(3, 1, 3, "randommobs:red_roots")
    s.put(7, 1, 7, "randommobs:red_roots")
    s.put(4, 1, 8, "minecraft:cobweb")
    s.entity(4, 1, 4, "randommobs:alive_house")
    s.save()
    structure_json("living_house", ["minecraft:plains", "minecraft:sunflower_plains", "minecraft:savanna",
                                    "minecraft:taiga", "minecraft:forest", "randommobs:scorched_plains"],
                   64, 24, 61893)

    # tripod crash json last (needs the nbt first)
    structure_json("tripod_crash", ["minecraft:desert", "minecraft:plains", "minecraft:forest",
                                    "minecraft:savanna", "randommobs:scorched_plains"], 38, 14, 9107)


# --------------------------------------------------------------------------- biome modifiers
def biome_modifiers():
    def add_spawns(name, biomes, spawners):
        write(os.path.join(DATA, "forge/biome_modifier", name + ".json"), {
            "type": "forge:add_spawns",
            "biomes": biomes,
            "spawners": spawners,
        })

    add_spawns("spawns_overworld", "#minecraft:is_overworld", [
        spawn("randommobs:tripod", 2, 1, 1),
        spawn("randommobs:alive_house", 3, 1, 1),
        spawn("randommobs:ufo", 3, 1, 1),
        spawn("randommobs:alive_tree", 4, 1, 1),
        spawn("randommobs:woodcrawler", 14, 1, 2),
        spawn("randommobs:gardener", 8, 1, 1),
    ])
    add_spawns("spawns_jungle", "#minecraft:is_jungle", [
        spawn("randommobs:evil_watermelon", 50, 1, 3),
        spawn("randommobs:woodcrawler", 20, 1, 2),
        spawn("randommobs:giant_spider", 2, 1, 1),
        spawn("randommobs:gardener", 6, 1, 1),
        spawn("randommobs:alive_tree", 8, 1, 1),
        spawn("randommobs:woodcock", 10, 1, 2),
    ])
    add_spawns("spawns_ocean", "#minecraft:is_ocean", [
        spawn("randommobs:bloop", 1, 1, 1),
        spawn("randommobs:kraken", 3, 1, 1),
        spawn("randommobs:gardener", 6, 1, 1),
    ])
    add_spawns("spawns_desert", ["minecraft:desert"], [
        spawn("randommobs:sand_worm", 12, 1, 2),
    ])
    add_spawns("spawns_bear", ["#minecraft:is_taiga", "#minecraft:is_forest"], [
        spawn("randommobs:bear", 14, 1, 2),
        spawn("randommobs:woodcock", 8, 1, 2),
    ])
    add_spawns("spawns_swamp", ["minecraft:swamp", "minecraft:mangrove_swamp", "#minecraft:is_river"], [
        spawn("randommobs:woodcock", 12, 1, 3),
        spawn("randommobs:gardener", 5, 1, 1),
    ])
    write(os.path.join(DATA, "forge/biome_modifier/red_roots_jungle.json"), {
        "type": "forge:add_features",
        "biomes": "#minecraft:is_jungle",
        "features": "randommobs:red_roots_patch",
        "step": "vegetal_decoration",
    })
    write(os.path.join(DATA, "forge/biome_modifier/red_roots_swamp.json"), {
        "type": "forge:add_features",
        "biomes": ["minecraft:swamp", "minecraft:mangrove_swamp"],
        "features": "randommobs:red_roots_patch",
        "step": "vegetal_decoration",
    })


def main():
    for name, data in BIOMES.items():
        write(os.path.join(DATA, "worldgen/biome", name + ".json"), build_biome(data))
    features()
    dimensions()
    build_structures()
    biome_modifiers()
    print("worldgen generated")


if __name__ == "__main__":
    main()
