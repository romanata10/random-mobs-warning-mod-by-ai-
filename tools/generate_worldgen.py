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

    build_city_structure()
    build_military_structure()
    build_oil_rig_structure()

    # tripod crash json last (needs the nbt first)
    structure_json("tripod_crash", ["minecraft:desert", "minecraft:plains", "minecraft:forest",
                                    "minecraft:savanna", "randommobs:scorched_plains"], 38, 14, 9107)



def build_city_structure():
    """A small city block: roads, sidewalks, three buildings and furniture inside."""
    s = Structure("city_block/main", (29, 18, 29))
    for x in range(29):
        for z in range(29):
            on_road_x = z in (12, 13, 14, 15, 16)
            on_road_z = x in (12, 13, 14, 15, 16)
            if on_road_x or on_road_z:
                s.put(x, 0, z, "randommobs:road_block")
                if (x * 7 + z * 3) % 11 == 0:
                    s.put(x, 0, z, "minecraft:yellow_concrete")
            else:
                s.put(x, 0, z, "randommobs:sidewalk_block")
            for y in range(1, 18):
                s.put(x, y, z, "minecraft:air")

    def building(x0, z0, w, d, height, floor_block, wall_block, accent):
        for x in range(x0, x0 + w):
            for z in range(z0, z0 + d):
                s.put(x, 1, z, floor_block)
                for y in range(2, 2 + height):
                    s.put(x, y, z, "minecraft:air")
        for x in range(x0, x0 + w):
            for z in range(z0, z0 + d):
                edge = x in (x0, x0 + w - 1) or z in (z0, z0 + d - 1)
                if not edge:
                    continue
                for y in range(2, 2 + height):
                    s.put(x, y, z, wall_block)
        for x in range(x0, x0 + w):
            for z in range(z0, z0 + d):
                s.put(x, 2 + height, z, accent)
        # windows
        for y in range(3, 2 + height, 2):
            for x in range(x0 + 1, x0 + w - 1, 2):
                s.put(x, y, z0, "randommobs:reinforced_glass")
                s.put(x, y, z0 + d - 1, "randommobs:reinforced_glass")
            for z in range(z0 + 1, z0 + d - 1, 2):
                s.put(x0, y, z, "randommobs:reinforced_glass")
                s.put(x0 + w - 1, y, z, "randommobs:reinforced_glass")
        # locked door in the middle of the south wall
        door_x = x0 + w // 2
        door_z = z0 + d - 1
        s.put(door_x, 2, door_z, "randommobs:locked_door",
              {"facing": "south", "half": "lower", "hinge": "left", "open": "false", "powered": "false"})
        s.put(door_x, 1, door_z, "randommobs:locked_door",
              {"facing": "south", "half": "upper", "hinge": "left", "open": "false", "powered": "false"})
        return door_x, door_z

    def table(x, z):
        s.put(x, 2, z, "minecraft:oak_fence")
        s.put(x, 3, z, "minecraft:oak_pressure_plate")

    def chair(x, z, facing):
        s.put(x, 2, z, "minecraft:oak_stairs", {"facing": facing, "half": "bottom", "shape": "straight",
                                                "waterlogged": "false"})

    def bed(x, z, facing):
        s.put(x, 2, z, "minecraft:red_bed", {"facing": facing, "part": "foot", "occupied": "false"})
        s.put(x, 2, z - 1 if facing == "north" else z + 1, "minecraft:red_bed",
              {"facing": facing, "part": "head", "occupied": "false"})

    # ---- building A: house with furniture ---------------------------------
    dx, dz = building(2, 2, 9, 9, 4, "minecraft:oak_planks", "randommobs:reinforced_planks",
                      "minecraft:dark_oak_slab")
    bed(4, 3, "south")
    table(7, 4)
    chair(7, 5, "north")
    chair(8, 4, "west")
    s.put(3, 2, 7, "minecraft:bookshelf")
    s.put(4, 2, 7, "minecraft:bookshelf")
    s.put(3, 3, 7, "randommobs:tv")
    s.put(9, 2, 3, "randommobs:casino")
    s.put(6, 2, 3, "minecraft:chest")
    s.put(5, 2, 3, "minecraft:crafting_table")
    s.put(8, 2, 8, "randommobs:cheese_block")
    s.put(2, 2, 3, "minecraft:glowstone")
    s.entity(dx - 1, 2, dz - 1, "randommobs:hollow_neighbor")

    # ---- building B: shop --------------------------------------------------
    building(18, 2, 9, 9, 5, "minecraft:smooth_stone", "minecraft:stone_bricks", "minecraft:stone_brick_slab")
    for x in range(19, 26):
        s.put(x, 2, 9, "minecraft:stone_brick_wall")
        s.put(x, 3, 9, "minecraft:barrel")
    s.put(20, 2, 4, "minecraft:furnace")
    s.put(21, 2, 4, "minecraft:smoker")
    s.put(22, 2, 4, "minecraft:blast_furnace")
    s.put(24, 2, 4, "randommobs:storm_siren")
    s.put(19, 2, 6, "minecraft:chest")
    s.put(25, 2, 6, "randommobs:glow_orb")
    table(22, 6)
    s.put(19, 5, 5, "minecraft:lantern")

    # ---- building C: bunker ------------------------------------------------
    building(2, 18, 9, 9, 4, "minecraft:polished_deepslate", "randommobs:tornado_bunker",
             "minecraft:deepslate_tiles")
    for x in range(3, 10):
        for z in range(19, 26):
            s.put(x, 2, z, "minecraft:polished_deepslate")
    s.put(4, 3, 20, "minecraft:bed", {"facing": "south", "part": "foot", "occupied": "false"})
    s.put(4, 3, 19, "minecraft:bed", {"facing": "south", "part": "head", "occupied": "false"})
    s.put(8, 3, 23, "randommobs:storm_siren")
    s.put(6, 3, 23, "minecraft:chest")
    s.put(9, 3, 21, "minecraft:barrel")
    s.put(3, 3, 24, "minecraft:lantern")

    # ---- street lamps + trees ----------------------------------------------
    for x, z in ((1, 1), (27, 1), (1, 27), (27, 27), (17, 17), (11, 11)):
        s.put(x, 1, z, "minecraft:stone_brick_wall")
        s.put(x, 2, z, "minecraft:stone_brick_wall")
        s.put(x, 3, z, "randommobs:glow_orb")
    for x, z in ((17, 3), (3, 17), (25, 17), (17, 25)):
        s.put(x, 1, z, "minecraft:dirt")
        s.put(x, 2, z, "minecraft:oak_log")
        s.put(x, 3, z, "minecraft:oak_leaves")
        s.put(x, 4, z, "minecraft:oak_leaves")

    s.entity(14, 1, 6, "randommobs:chest_mimic")
    s.entity(24, 1, 20, "randommobs:lights")
    s.save()
    structure_json("city_block", ["minecraft:plains", "minecraft:sunflower_plains", "minecraft:savanna"],
                   110, 40, 74113)


def build_military_structure():
    s = Structure("military_base/main", (25, 12, 25))
    for x in range(25):
        for z in range(25):
            s.put(x, 0, z, "randommobs:road_block" if (x // 4 + z // 4) % 2 else "minecraft:gray_concrete")
            for y in range(1, 12):
                s.put(x, y, z, "minecraft:air")
    # perimeter fence
    for x in range(25):
        for z in range(25):
            if x in (0, 24) or z in (0, 24):
                s.put(x, 1, z, "minecraft:iron_bars")
                s.put(x, 2, z, "minecraft:iron_bars")
    # gate
    for z in (12, 13):
        s.put(12, 1, 24, "minecraft:air")
        s.put(13, 1, 24, "minecraft:air")
        s.put(12, 2, 24, "minecraft:air")
        s.put(13, 2, 24, "minecraft:air")
    # command post
    for x in range(3, 11):
        for z in range(3, 10):
            s.put(x, 1, z, "minecraft:smooth_stone")
            for y in range(2, 6):
                s.put(x, y, z, "minecraft:air")
            edge = x in (3, 10) or z in (3, 9)
            for y in range(2, 5):
                if edge:
                    s.put(x, y, z, "minecraft:light_gray_concrete")
            s.put(x, 5, z, "minecraft:gray_concrete")
    s.put(6, 2, 9, "minecraft:iron_door", {"facing": "south", "half": "lower", "hinge": "left",
                                           "open": "false", "powered": "false"})
    s.put(6, 3, 9, "minecraft:iron_door", {"facing": "south", "half": "upper", "hinge": "left",
                                           "open": "false", "powered": "false"})
    s.put(4, 2, 4, "randommobs:storm_siren")
    s.put(8, 2, 4, "minecraft:barrel")
    s.put(9, 2, 4, "minecraft:chest")
    s.put(5, 2, 5, "minecraft:crafting_table")
    s.put(5, 3, 5, "minecraft:lantern")
    # helipad
    for x in range(16, 23):
        for z in range(16, 23):
            s.put(x, 1, z, "minecraft:gray_concrete")
    s.put(19, 2, 19, "minecraft:white_concrete")
    for dx, dz in ((-2, 0), (2, 0), (0, -2), (0, 2)):
        s.put(19 + dx, 2, 19 + dz, "minecraft:white_concrete")
    # fuel tanks
    for x, z in ((18, 5), (21, 5)):
        for y in range(1, 5):
            s.put(x, y, z, "minecraft:iron_block")
        s.put(x, 5, z, "minecraft:cauldron")
    # crates
    for x, z in ((16, 10), (17, 10), (18, 10), (16, 11)):
        s.put(x, 1, z, "minecraft:barrel")
    s.entity(20, 1, 12, "randommobs:tank")
    s.entity(6, 2, 6, "randommobs:lights")
    s.save()
    structure_json("military_base", ["minecraft:plains", "minecraft:sunflower_plains",
                                     "randommobs:scorched_plains", "minecraft:desert"], 90, 30, 52301)


def build_oil_rig_structure():
    s = Structure("oil_rig/main", (21, 22, 21))
    for x in range(21):
        for z in range(21):
            for y in range(22):
                s.put(x, y, z, "minecraft:air")
    # stilts
    for x in (1, 19):
        for z in (1, 19):
            for y in range(0, 12):
                s.put(x, y, z, "minecraft:iron_block")
    # main deck
    for x in range(0, 21):
        for z in range(0, 21):
            s.put(x, 12, z, "minecraft:iron_block" if (x + z) % 5 else "minecraft:iron_bars")
    # upper platform
    for x in range(4, 17):
        for z in range(4, 17):
            s.put(x, 16, z, "minecraft:gray_concrete")
    for x in range(4, 17):
        for z in range(4, 17):
            if x in (4, 16) or z in (4, 16):
                s.put(x, 17, z, "minecraft:iron_bars")
    # derrick
    for y in range(17, 21):
        s.put(10, y, 10, "minecraft:iron_bars")
        s.put(10, y, 10, "minecraft:iron_block")
    # cargo + machinery
    for x, z in ((2, 2), (3, 2), (2, 3), (17, 2), (18, 3)):
        s.put(x, 13, z, "minecraft:barrel")
    s.put(9, 13, 3, "minecraft:furnace")
    s.put(10, 13, 3, "minecraft:blast_furnace")
    s.put(11, 13, 3, "minecraft:smoker")
    s.put(17, 13, 17, "randommobs:storm_siren")
    s.put(3, 13, 17, "randommobs:glow_orb")
    s.put(13, 13, 9, "minecraft:lantern")
    s.put(9, 17, 9, "minecraft:lantern")
    for x in range(2, 6):
        s.put(x, 13, 10, "minecraft:iron_bars")
    s.entity(10, 17, 12, "randommobs:tank")
    s.entity(10, 6, -4, "randommobs:warship")
    s.save()
    structure_json("oil_rig", ["minecraft:ocean", "minecraft:cold_ocean", "minecraft:lukewarm_ocean",
                               "minecraft:warm_ocean", "minecraft:deep_ocean"], 120, 40, 33647,
                   heightmap="OCEAN_FLOOR_WG", terrain="none")


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
    add_spawns("spawns_storm_creatures", "#minecraft:is_overworld", [
        spawn("randommobs:lights", 6, 1, 2),
        spawn("randommobs:chest_mimic", 3, 1, 1),
        spawn("randommobs:circuit", 3, 1, 1),
        spawn("randommobs:lantern_wraith", 5, 1, 2),
        spawn("randommobs:bog_wretch", 6, 1, 1),
        spawn("randommobs:ash_hound", 6, 1, 2),
        spawn("randommobs:cloud_ray", 4, 1, 1),
        spawn("randommobs:hollow_neighbor", 3, 1, 1),
        spawn("randommobs:siren_head", 1, 1, 1),
    ])
    add_spawns("spawns_water_grabber", "#minecraft:is_ocean", [
        spawn("randommobs:water_grabber", 8, 1, 1),
    ])
    add_spawns("spawns_warship", ["minecraft:deep_ocean", "minecraft:deep_cold_ocean"], [
        spawn("randommobs:warship", 1, 1, 1),
    ])
    add_spawns("spawns_tank", ["randommobs:scorched_plains", "minecraft:desert"], [
        spawn("randommobs:tank", 2, 1, 1),
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
