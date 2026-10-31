#!/usr/bin/env python3
"""Generates item/block models, blockstates, loot tables, advancements and lang files."""
import json
import os

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ASSETS = os.path.join(ROOT, "src/main/resources/assets/randommobs")
DATA = os.path.join(ROOT, "src/main/resources/data/randommobs")

ITEMS = {
    "tripod_core": ("Tripod Core", "Ядро триноги", "generated"),
    "alien_metal_ingot": ("Alien Metal Ingot", "Слиток чужого металла", "generated"),
    "crawler_claw": ("Woodcrawler Claw", "Коготь древолаза", "generated"),
    "mockery_pod": ("Mockery Pod", "Стручок насмешки", "generated"),
    "bloop_eye": ("Bloop Eye", "Глаз блупа", "generated"),
    "ufo_scrap": ("UFO Scrap", "Обломок НЛО", "generated"),
    "giant_spider_silk": ("Giant Spider Silk", "Шелк гигантского паука", "generated"),
    "meep_feather": ("Meep Feather", "Перо мип", "generated"),
    "heat_ray": ("Heat Ray", "Тепловой луч", "handheld"),
    "root_blade": ("Root Blade", "Корневой клинок", "handheld"),
    "sand_worm_fang": ("Sand Worm Fang", "Клык песчаного червя", "handheld"),
    "root_serum": ("Root Serum", "Сыворотка от корней", "generated"),
    "bear_meat": ("Raw Bear Meat", "Сырое медвежье мясо", "generated"),
    "cooked_bear_meat": ("Cooked Bear Meat", "Жареное медвежье мясо", "generated"),
    "kraken_tentacle": ("Raw Kraken Tentacle", "Сырое щупальце кракена", "generated"),
    "cooked_kraken_tentacle": ("Cooked Kraken Tentacle", "Жареное щупальце кракена", "generated"),
    "root_fruit": ("Root Fruit", "Корневой плод", "generated"),
    "root_seed": ("Root Seed", "Семя корней", "generated"),
    "root_shard": ("Root Shard", "Осколок корня", "generated"),
    "lock_key": ("Lock Key", "Ключ от двери", "generated"),
    "storm_radio": ("Storm Radio", "Штормовое радио", "generated"),
    "weather_map": ("Weather Map", "Карта погоды", "generated"),
    "time_clock": ("World Clock", "Часы мира", "generated"),
    "chips": ("Chips", "Чипсы", "generated"),
    "kirieshki": ("Kirieshki", "Кириешки", "generated"),
    "cheese_slice": ("Cheese Slice", "Ломтик сыра", "generated"),
    "bolt_lance": ("Bolt Lance", "Громовое копьё", "handheld"),
    "tank_track": ("Tank Track", "Траковая лента танка", "generated"),
    "circuit_fragment": ("Circuit Fragment", "Фрагмент схемы", "generated"),
    "storm_scale": ("Storm Scale", "Чешуя шторма", "generated"),
    "siren_bulb": ("Siren Bulb", "Лампа сирены", "generated"),
}

BLOCKS = {
    "red_roots": ("Red Roots", "Красные корни", "cross"),
    "root_liana": ("Root Liana", "Корневая лиана", "cross"),
    "mockery_bloom": ("Nature's Mockery", "Насмешка природы", "cross"),
    "red_root_block": ("Red Root Block", "Блок красных корней", "cube"),
    "alien_metal_block": ("Alien Metal Block", "Блок чужого металла", "cube"),
    "bloop_flesh_block": ("Bloop Flesh", "Плоть блупа", "cube"),
    "reinforced_planks": ("Reinforced Planks", "Усиленные доски", "cube"),
    "reinforced_glass": ("Reinforced Glass", "Усиленное стекло", "glass"),
    "fast_stairs": ("Fast Stairs", "Быстрая лестница", "stairs"),
    "road_block": ("Road Block", "Блок дороги", "cube"),
    "sidewalk_block": ("Sidewalk Block", "Блок тротуара", "cube"),
    "locked_door": ("Locked Door", "Дверь с замком", "door"),
    "cheese_block": ("Cheese Block", "Блок сыра", "cube"),
    "storm_siren": ("Storm Siren", "Сирена штормов", "cube"),
    "glow_orb": ("Glowing White Orb", "Светящаяся белая сфера", "orb"),
    "tornado_bunker": ("Bunker Plating", "Броня бункера", "cube"),
    "casino": ("Casino", "Казино", "cube"),
    "tv": ("Television", "Телевизор", "tv"),
}

ENTITIES = {
    "tripod": ("Tripod", "Тринога", (0x3D4450, 0xF2D15A)),
    "woodcrawler": ("Woodcrawler", "Древолаз", (0x5D4227, 0xB8D86A)),
    "bloop": ("Bloop", "Блуп", (0x0D2B3A, 0x2FD6C9)),
    "alive_house": ("Living House", "Живой дом", (0x7A6350, 0x2B2118)),
    "giant_spider": ("Giant Harvestman", "Гигантский сенокосец", (0x3B3324, 0x8B2D1C)),
    "gardener": ("Gardener", "Садовник", (0xB8A48E, 0xFFF39A)),
    "sand_worm": ("Sand Worm", "Песчаный червь", (0xC8B07A, 0x6D2B23)),
    "ufo": ("UFO", "НЛО", (0x878F96, 0x7CF2A8)),
    "bear": ("Bear", "Медведь", (0x5B3A24, 0x2A1A10)),
    "kraken": ("Kraken", "Кракен", (0x2A1A3A, 0xA37DD6)),
    "evil_watermelon": ("Evil Watermelon", "Злой арбуз", (0x2F5C1F, 0xD43A3A)),
    "alive_tree": ("Living Tree", "Живое дерево", (0x5A3F22, 0x3F7A2E)),
    "woodcock": ("American Woodcock", "Американский вальдшнеп", (0x6B5540, 0xD8C3A2)),
    "lights": ("Lights", "Огоньки", (0x8A8F95, 0xFFFFFF)),
    "chest_mimic": ("Chest Mimic", "Мимик сундука", (0x7A5A2E, 0xD8B46A)),
    "water_grabber": ("Water Grabber", "Водный захватчик", (0x8C2F45, 0xE0A3B5)),
    "tank": ("Tank", "Танк", (0x4A5232, 0x2B2F1C)),
    "siren_head": ("Siren Head", "Сиренаголовый", (0x8E8471, 0xC4463A)),
    "warship": ("Ghost Warship", "Корабль-призрак", (0x3D4650, 0x8F2F2A)),
    "circuit": ("Circuit", "Схема", (0x1D2B2B, 0x59FFD0)),
    "ash_hound": ("Ash Hound", "Пепельный пёс", (0x3B332D, 0xD9713A)),
    "cloud_ray": ("Cloud Ray", "Облачный скат", (0xD7DDE2, 0x6FA8C9)),
    "bog_wretch": ("Bog Wretch", "Болотный утопленник", (0x38442C, 0x7F8F52)),
    "lantern_wraith": ("Lantern Wraith", "Фонарный призрак", (0x2A2F3C, 0x74C9FF)),
    "hollow_neighbor": ("Hollow Neighbour", "Пустой сосед", (0x6A5A48, 0x1B1712)),
    "tornado": ("Tornado", "Торнадо", (0x8C99A6, 0xDDE6EE)),
}

ADVANCEMENTS = {
    "root": {
        "en": ("Random Mobs", "Something very strange moved into the world."),
        "ru": ("Случайные монстры", "В мир переехало нечто очень странное."),
        "icon": "randommobs:tripod_core", "frame": "task", "parent": None, "background": True,
    },
    "oh_that_just_fish": {
        "en": ("oh that just fish", "Drown a Tripod. It is just a fish now."),
        "ru": ("О, это просто рыба", "Утопите триногу. Теперь это просто рыба."),
        "icon": "minecraft:water_bucket", "frame": "goal", "parent": "root",
    },
    "its_not_iceberg": {
        "en": ("its not iceberg", "Find the Bloop in the deep ocean."),
        "ru": ("Это не айсберг", "Найдите блупа в глубинах океана."),
        "icon": "randommobs:bloop_eye", "frame": "goal", "parent": "root",
    },
    "omg_its_ufo_in_trash_camera_from_2004": {
        "en": ("omg its ufo in trash camera from 2004", "Look directly at the UFO. It looks back."),
        "ru": ("ОМГ это НЛО в мусорной камере 2004", "Посмотрите прямо на НЛО. Оно посмотрит в ответ."),
        "icon": "randommobs:ufo_scrap", "frame": "goal", "parent": "root",
    },
    "meep": {
        "en": ("meep", "Tame an American Woodcock with seeds."),
        "ru": ("meep", "Приручите американского вальдшнепа семечками."),
        "icon": "randommobs:meep_feather", "frame": "task", "parent": "root",
    },
    "natures_mockery": {
        "en": ("Nature's Mockery", "Die to the root virus and become a plant."),
        "ru": ("Насмешка природы", "Умрите от вируса корней и станьте растением."),
        "icon": "randommobs:mockery_pod", "frame": "challenge", "parent": "root",
    },
    "root_cure": {
        "en": ("Rooted Out", "Cure the root infection with Root Serum."),
        "ru": ("Исцеление", "Вылечите заражение корней сывороткой."),
        "icon": "randommobs:root_serum", "frame": "task", "parent": "root",
    },
    "kill_tripod": {
        "en": ("War of the Worlds", "Destroy a Tripod."),
        "ru": ("Война миров", "Уничтожьте триногу."),
        "icon": "randommobs:tripod_core", "frame": "challenge", "parent": "root",
    },
    "kill_bloop": {
        "en": ("Deep Trouble", "Kill the Bloop."),
        "ru": ("Глубинная проблема", "Убейте блупа."),
        "icon": "randommobs:bloop_eye", "frame": "challenge", "parent": "root",
    },
    "kill_kraken": {
        "en": ("Release the Kraken", "Then kill it."),
        "ru": ("Освободите кракена", "А потом убейте его."),
        "icon": "randommobs:kraken_tentacle", "frame": "challenge", "parent": "root",
    },
    "watermelon_slayer": {
        "en": ("Fruit Ninja", "Chop an evil watermelon into 15 slices."),
        "ru": ("Фруктовый ниндзя", "Разрубите злой арбуз на 15 долек."),
        "icon": "minecraft:melon_slice", "frame": "task", "parent": "root",
    },
    "spider_silk": {
        "en": ("Eight Legs Too Many", "Kill a giant harvestman."),
        "ru": ("На восемь ног больше, чем надо", "Убейте гигантского сенокосца."),
        "icon": "randommobs:giant_spider_silk", "frame": "challenge", "parent": "root",
    },
    "saw_gardener": {
        "en": ("The Gardeners", "Meet a Gardener. Mind the red roots."),
        "ru": ("Садовники", "Встретьте садовника. Берегитесь красных корней."),
        "icon": "randommobs:root_liana", "frame": "task", "parent": "root",
    },
    "tree_breaker": {
        "en": ("The Tree Remembers", "Break a log in front of a Living Tree."),
        "ru": ("Дерево помнит", "Сломайте бревно на глазах у живого дерева."),
        "icon": "minecraft:oak_log", "frame": "goal", "parent": "root",
    },
    "storm_survivor": {
        "en": ("Storm Survivor", "Live through a tornado warning and the storm that follows."),
        "ru": ("Пережил шторм", "Переживите предупреждение о торнадо и сам шторм."),
        "icon": "randommobs:storm_scale", "frame": "challenge", "parent": "root",
    },
    "mimic_bite": {
        "en": ("It Was A Mouth", "Try to open a chest that is not a chest."),
        "ru": ("Это был рот", "Попробуйте открыть сундук, который не сундук."),
        "icon": "randommobs:lock_key", "frame": "task", "parent": "root",
    },
    "casino_jackpot": {
        "en": ("The House Always Loses", "Hit the jackpot at the casino block."),
        "ru": ("Казино всегда проигрывает", "Сорвите джекпот в блоке казино."),
        "icon": "minecraft:diamond", "frame": "challenge", "parent": "root",
    },
}


def write(path, obj):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as fh:
        json.dump(obj, fh, ensure_ascii=False, indent=2)
        fh.write("\n")


def item_model(name, kind):
    parent = "minecraft:item/handheld" if kind == "handheld" else "minecraft:item/generated"
    write(os.path.join(ASSETS, "models/item", name + ".json"),
          {"parent": parent, "textures": {"layer0": "randommobs:item/" + name}})


def spawn_egg_model(name):
    write(os.path.join(ASSETS, "models/item", name + "_spawn_egg.json"),
          {"parent": "minecraft:item/template_spawn_egg"})


def _template(name):
    with open(os.path.join(ROOT, "tools/templates", name), encoding="utf-8") as fh:
        return json.load(fh)


DOOR_PARTS = ("bottom_left", "bottom_left_open", "bottom_right", "bottom_right_open",
              "top_left", "top_left_open", "top_right", "top_right_open")


def block_model(name, kind):
    item_parent = "randommobs:block/" + name
    if kind == "cross":
        write(os.path.join(ASSETS, "models/block", name + ".json"),
              {"parent": "minecraft:block/cross",
               "textures": {"cross": "randommobs:block/" + name}})
    elif kind == "glass":
        write(os.path.join(ASSETS, "models/block", name + ".json"),
              {"parent": "minecraft:block/cube_all", "render_type": "minecraft:translucent",
               "textures": {"all": "randommobs:block/" + name}})
    elif kind == "stairs":
        for suffix, parent in (("", "minecraft:block/stairs"),
                               ("_inner", "minecraft:block/inner_stairs"),
                               ("_outer", "minecraft:block/outer_stairs")):
            write(os.path.join(ASSETS, "models/block", name + suffix + ".json"), {
                "parent": parent,
                "textures": {"bottom": "randommobs:block/" + name + "_bottom",
                             "top": "randommobs:block/" + name + "_top",
                             "side": "randommobs:block/" + name + "_side"},
            })
        variants = json.loads(json.dumps(_template("oak_stairs.json")["variants"]))
        for key, value in variants.items():
            model = value["model"]
            if model == "minecraft:block/oak_stairs":
                value["model"] = "randommobs:block/" + name
            elif model == "minecraft:block/inner_stairs":
                value["model"] = "randommobs:block/" + name + "_inner"
            else:
                value["model"] = "randommobs:block/" + name + "_outer"
        write(os.path.join(ASSETS, "blockstates", name + ".json"), {"variants": variants})
    elif kind == "door":
        for part in DOOR_PARTS:
            write(os.path.join(ASSETS, "models/block", name + "_" + part + ".json"), {
                "parent": "minecraft:block/door_" + part,
                "textures": {"bottom": "randommobs:block/" + name + "_bottom",
                             "top": "randommobs:block/" + name + "_top"},
            })
        variants = json.loads(json.dumps(_template("oak_door.json")["variants"]))
        for value in variants.values():
            value["model"] = value["model"].replace("minecraft:block/oak_door_",
                                                    "randommobs:block/" + name + "_")
        write(os.path.join(ASSETS, "blockstates", name + ".json"), {"variants": variants})
        item_parent = "minecraft:item/generated"
    elif kind == "orb":
        faces = {side: {"texture": "#shell", "uv": [3, 3, 13, 13]}
                 for side in ("down", "up", "north", "south", "west", "east")}
        write(os.path.join(ASSETS, "models/block", name + ".json"), {
            "textures": {"particle": "randommobs:block/" + name,
                         "shell": "randommobs:block/" + name},
            "elements": [{"from": [3, 3, 3], "to": [13, 13, 13], "faces": faces}],
        })
        write(os.path.join(ASSETS, "blockstates", name + ".json"),
              {"variants": {"": {"model": "randommobs:block/" + name}}})
    elif kind == "tv":
        write(os.path.join(ASSETS, "models/block", name + ".json"), {
            "textures": {"particle": "randommobs:block/tv_side",
                         "body": "randommobs:block/tv_side",
                         "screen": "randommobs:block/tv_screen"},
            "elements": [
                {"from": [0, 0, 1], "to": [16, 11, 15],
                 "faces": {side: {"texture": "#body"} for side in ("down", "up", "west", "east", "north", "south")}},
                {"from": [2, 2, 0.9], "to": [14, 9, 1.1],
                 "faces": {"north": {"texture": "#screen"}, "south": {"texture": "#screen"}}},
            ],
        })
        write(os.path.join(ASSETS, "blockstates", name + ".json"),
              {"variants": {"": {"model": "randommobs:block/" + name}}})
    else:
        write(os.path.join(ASSETS, "models/block", name + ".json"),
              {"parent": "minecraft:block/cube_all",
               "textures": {"all": "randommobs:block/" + name}})
    if kind not in ("stairs", "door", "orb", "tv"):
        write(os.path.join(ASSETS, "blockstates", name + ".json"),
              {"variants": {"": {"model": "randommobs:block/" + name}}})
    if item_parent == "minecraft:item/generated":
        write(os.path.join(ASSETS, "models/item", name + ".json"),
              {"parent": item_parent, "textures": {"layer0": "randommobs:item/" + name}})
    else:
        write(os.path.join(ASSETS, "models/item", name + ".json"), {"parent": item_parent})


def block_loot(name):
    write(os.path.join(DATA, "loot_tables/blocks", name + ".json"), {
        "type": "minecraft:block",
        "pools": [{
            "rolls": 1,
            "bonus_rolls": 0,
            "entries": [{"type": "minecraft:item", "name": "randommobs:" + name}],
            "conditions": [{"condition": "minecraft:survives_explosion"}]
        }]
    })


def entity_loot(name, pools):
    write(os.path.join(DATA, "loot_tables/entities", name + ".json"),
          {"type": "minecraft:entity", "pools": pools})


def item_pool(item, min_count=1, max_count=1, chance=None, looting=None):
    entry = {"type": "minecraft:item", "name": item}
    functions = []
    if min_count != 1 or max_count != 1:
        functions.append({"function": "minecraft:set_count", "count": {
            "type": "minecraft:uniform", "min": min_count, "max": max_count}})
    if looting:
        functions.append({"function": "minecraft:looting_enchant", "count": {
            "type": "minecraft:uniform", "min": 0, "max": looting}})
    if functions:
        entry["functions"] = functions
    pool = {"rolls": 1, "entries": [entry]}
    if chance is not None:
        pool["conditions"] = [{"condition": "minecraft:random_chance", "chance": chance}]
    return pool


def advancement(name, data):
    display = {
        "icon": {"item": data["icon"]},
        "title": {"translate": "advancement.randommobs." + name + ".title"},
        "description": {"translate": "advancement.randommobs." + name + ".description"},
        "frame": data["frame"],
        "show_toast": True,
        "announce_to_chat": True,
        "hidden": False,
    }
    if data.get("background"):
        display["background"] = "minecraft:textures/block/red_nether_bricks.png"
    adv = {
        "display": display,
        "criteria": {"code": {"trigger": "minecraft:impossible"}},
    }
    if data["parent"]:
        adv["parent"] = "randommobs:" + data["parent"]
    write(os.path.join(DATA, "advancements", name + ".json"), adv)


RECIPES = {
    "heat_ray": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "randommobs:tripod_core"},
                        {"item": "randommobs:alien_metal_ingot"},
                        {"item": "randommobs:alien_metal_ingot"},
                        {"item": "minecraft:blaze_rod"}],
        "result": {"item": "randommobs:heat_ray"},
    },
    "root_blade": {
        "type": "minecraft:crafting_shaped",
        "pattern": [" P ", " M ", " S "],
        "key": {"P": {"item": "randommobs:mockery_pod"},
                "M": {"item": "randommobs:alien_metal_ingot"},
                "S": {"item": "minecraft:stick"}},
        "result": {"item": "randommobs:root_blade"},
    },
    "root_serum": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:glass_bottle"},
                        {"item": "randommobs:root_seed"},
                        {"item": "minecraft:glow_berries"}],
        "result": {"item": "randommobs:root_serum"},
    },
    "root_shard": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "randommobs:mockery_pod"},
                        {"item": "minecraft:ender_pearl"},
                        {"item": "randommobs:red_root_block"}],
        "result": {"item": "randommobs:root_shard"},
    },
    "alien_metal_block": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["###", "###", "###"],
        "key": {"#": {"item": "randommobs:alien_metal_ingot"}},
        "result": {"item": "randommobs:alien_metal_block"},
    },
    "alien_metal_ingot_from_block": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "randommobs:alien_metal_block"}],
        "result": {"item": "randommobs:alien_metal_ingot", "count": 9},
    },
    "red_root_block": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["##", "##"],
        "key": {"#": {"item": "randommobs:root_seed"}},
        "result": {"item": "randommobs:red_root_block"},
    },
    "string_from_silk": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "randommobs:giant_spider_silk"}],
        "result": {"item": "minecraft:string", "count": 2},
    },
    "bloop_flesh_block": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["##", "##"],
        "key": {"#": {"item": "randommobs:bloop_eye"}},
        "result": {"item": "randommobs:bloop_flesh_block"},
    },
    "reinforced_planks": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:oak_planks"}, {"item": "minecraft:oak_planks"},
                        {"item": "minecraft:oak_planks"}, {"item": "minecraft:iron_ingot"}],
        "result": {"item": "randommobs:reinforced_planks", "count": 4},
    },
    "reinforced_glass": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:glass"}, {"item": "minecraft:glass"},
                        {"item": "minecraft:glass"}, {"item": "minecraft:glass"},
                        {"item": "minecraft:iron_ingot"}],
        "result": {"item": "randommobs:reinforced_glass", "count": 4},
    },
    "fast_stairs": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["#  ", "## ", "###"],
        "key": {"#": {"item": "randommobs:reinforced_planks"}},
        "result": {"item": "randommobs:fast_stairs", "count": 4},
    },
    "road_block": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:gravel"}, {"item": "minecraft:gravel"},
                        {"item": "minecraft:gravel"}, {"item": "minecraft:gravel"},
                        {"item": "minecraft:coal"}],
        "result": {"item": "randommobs:road_block", "count": 8},
    },
    "sidewalk_block": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:stone"}, {"item": "minecraft:stone"},
                        {"item": "minecraft:stone"}, {"item": "minecraft:stone"},
                        {"item": "minecraft:quartz"}],
        "result": {"item": "randommobs:sidewalk_block", "count": 8},
    },
    "locked_door": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["##", "##", "##"],
        "key": {"#": {"item": "randommobs:reinforced_planks"}},
        "result": {"item": "randommobs:locked_door", "count": 3},
    },
    "lock_key": {
        "type": "minecraft:crafting_shaped",
        "pattern": [" I ", "IGI", " I "],
        "key": {"I": {"item": "minecraft:iron_ingot"}, "G": {"item": "minecraft:gold_nugget"}},
        "result": {"item": "randommobs:lock_key"},
    },
    "cheese_block": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["##", "##"],
        "key": {"#": {"item": "randommobs:cheese_slice"}},
        "result": {"item": "randommobs:cheese_block"},
    },
    "cheese_slice": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:milk_bucket"}, {"item": "minecraft:sugar"},
                        {"item": "minecraft:egg"}],
        "result": {"item": "randommobs:cheese_slice", "count": 3},
    },
    "cheese_slice_from_block": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "randommobs:cheese_block"}],
        "result": {"item": "randommobs:cheese_slice", "count": 4},
    },
    "storm_siren": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["III", "INI", "IRI"],
        "key": {"I": {"item": "minecraft:iron_ingot"}, "N": {"item": "minecraft:note_block"},
                "R": {"item": "minecraft:redstone"}},
        "result": {"item": "randommobs:storm_siren"},
    },
    "glow_orb": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:glowstone_dust"}, {"item": "minecraft:glowstone_dust"},
                        {"item": "minecraft:glowstone_dust"}, {"item": "minecraft:glowstone_dust"},
                        {"item": "minecraft:glass"}, {"item": "minecraft:ender_pearl"}],
        "result": {"item": "randommobs:glow_orb", "count": 2},
    },
    "tornado_bunker": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["III", "IOI", "III"],
        "key": {"I": {"item": "minecraft:iron_block"}, "O": {"item": "minecraft:obsidian"}},
        "result": {"item": "randommobs:tornado_bunker", "count": 4},
    },
    "casino": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["GPG", "PRP", "GPG"],
        "key": {"G": {"item": "minecraft:gold_ingot"}, "P": {"item": "minecraft:oak_planks"},
                "R": {"item": "minecraft:redstone_block"}},
        "result": {"item": "randommobs:casino"},
    },
    "tv": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["III", "IGI", "IRI"],
        "key": {"I": {"item": "minecraft:iron_ingot"}, "G": {"item": "minecraft:glass"},
                "R": {"item": "minecraft:redstone"}},
        "result": {"item": "randommobs:tv"},
    },
    "storm_radio": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["ICI", "IRI", "III"],
        "key": {"I": {"item": "minecraft:iron_ingot"}, "C": {"item": "minecraft:copper_ingot"},
                "R": {"item": "minecraft:redstone"}},
        "result": {"item": "randommobs:storm_radio"},
    },
    "weather_map": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:paper"}, {"item": "minecraft:paper"},
                        {"item": "minecraft:paper"}, {"item": "minecraft:blue_dye"}],
        "result": {"item": "randommobs:weather_map"},
    },
    "time_clock": {
        "type": "minecraft:crafting_shaped",
        "pattern": [" G ", "GRG", " Q "],
        "key": {"G": {"item": "minecraft:gold_ingot"}, "R": {"item": "minecraft:redstone"},
                "Q": {"item": "minecraft:quartz"}},
        "result": {"item": "randommobs:time_clock"},
    },
    "chips": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:wheat"}, {"item": "minecraft:wheat"},
                        {"item": "minecraft:baked_potato"}],
        "result": {"item": "randommobs:chips", "count": 3},
    },
    "kirieshki": {
        "type": "minecraft:crafting_shapeless",
        "ingredients": [{"item": "minecraft:wheat"}, {"item": "minecraft:wheat"},
                        {"item": "minecraft:wheat"}, {"item": "minecraft:bread"}],
        "result": {"item": "randommobs:kirieshki", "count": 3},
    },
    "bolt_lance": {
        "type": "minecraft:crafting_shaped",
        "pattern": ["  I", " L ", "S  "],
        "key": {"I": {"item": "minecraft:iron_ingot"}, "L": {"item": "minecraft:lightning_rod"},
                "S": {"item": "minecraft:stick"}},
        "result": {"item": "randommobs:bolt_lance"},
    },
}

SMELTING = {
    "cooked_bear_meat": "randommobs:bear_meat",
    "cooked_kraken_tentacle": "randommobs:kraken_tentacle",
}


def recipes():
    for name, data in RECIPES.items():
        write(os.path.join(DATA, "recipes", name + ".json"), data)
    for result, ingredient in SMELTING.items():
        write(os.path.join(DATA, "recipes", result + "_from_smelting.json"), {
            "type": "minecraft:smelting", "ingredient": {"item": ingredient},
            "result": "randommobs:" + result, "experience": 0.35, "cookingtime": 200,
        })
        write(os.path.join(DATA, "recipes", result + "_from_smoking.json"), {
            "type": "minecraft:smoking", "ingredient": {"item": ingredient},
            "result": "randommobs:" + result, "experience": 0.35, "cookingtime": 100,
        })
        write(os.path.join(DATA, "recipes", result + "_from_campfire_cooking.json"), {
            "type": "minecraft:campfire_cooking", "ingredient": {"item": ingredient},
            "result": "randommobs:" + result, "experience": 0.35, "cookingtime": 600,
        })


def block_tags():
    mc = os.path.join(ROOT, "src/main/resources/data/minecraft/tags/blocks")

    def tag(path, values):
        write(os.path.join(mc, path), {"replace": False, "values": values})

    tag("mineable/pickaxe.json", [
        "randommobs:alien_metal_block", "randommobs:reinforced_glass", "randommobs:fast_stairs",
        "randommobs:road_block", "randommobs:sidewalk_block", "randommobs:storm_siren",
        "randommobs:tornado_bunker", "randommobs:glow_orb",
    ])
    tag("mineable/axe.json", [
        "randommobs:reinforced_planks", "randommobs:locked_door", "randommobs:tv", "randommobs:casino",
    ])
    tag("mineable/shovel.json", ["randommobs:road_block", "randommobs:sidewalk_block"])
    tag("needs_iron_tool.json", [
        "randommobs:alien_metal_block", "randommobs:reinforced_glass", "randommobs:storm_siren",
        "randommobs:reinforced_planks", "randommobs:fast_stairs",
    ])
    tag("needs_diamond_tool.json", ["randommobs:tornado_bunker"])


def main():
    for name, (_, _, kind) in ITEMS.items():
        item_model(name, kind)
    for name in ENTITIES:
        spawn_egg_model(name)
    for name, (_, _, kind) in BLOCKS.items():
        block_model(name, kind)
        block_loot(name)
    for name, data in ADVANCEMENTS.items():
        advancement(name, data)
    recipes()
    block_tags()

    entity_loot("tripod", [
        item_pool("randommobs:tripod_core", 1, 2),
        item_pool("randommobs:alien_metal_ingot", 2, 5),
        item_pool("randommobs:ufo_scrap", 1, 1, chance=0.35),
    ])
    entity_loot("woodcrawler", [
        item_pool("randommobs:crawler_claw", 0, 2, looting=1),
        item_pool("randommobs:root_seed", 1, 1, chance=0.3),
    ])
    entity_loot("bloop", [
        item_pool("randommobs:bloop_eye", 1, 2),
        item_pool("randommobs:bloop_flesh_block", 3, 6),
        item_pool("minecraft:cod", 2, 5),
    ])
    entity_loot("alive_house", [
        item_pool("minecraft:oak_planks", 8, 16),
        item_pool("minecraft:emerald", 0, 3, chance=0.6),
    ])
    entity_loot("giant_spider", [
        item_pool("randommobs:giant_spider_silk", 2, 4),
        item_pool("minecraft:string", 3, 6),
    ])
    entity_loot("gardener", [
        item_pool("randommobs:root_seed", 0, 2, looting=1),
        item_pool("randommobs:mockery_pod", 1, 1, chance=0.25),
        item_pool("randommobs:red_roots", 1, 3),
    ])
    entity_loot("sand_worm", [
        item_pool("randommobs:sand_worm_fang", 1, 2),
        item_pool("minecraft:sand", 4, 8),
    ])
    entity_loot("ufo", [
        item_pool("randommobs:ufo_scrap", 1, 3),
        item_pool("randommobs:alien_metal_ingot", 0, 2, looting=1),
    ])
    entity_loot("bear", [
        item_pool("randommobs:bear_meat", 1, 3, looting=1),
        item_pool("minecraft:leather", 0, 2, looting=1),
    ])
    entity_loot("kraken", [
        item_pool("randommobs:kraken_tentacle", 2, 4),
        item_pool("minecraft:ink_sac", 1, 3),
    ])
    entity_loot("evil_watermelon", [
        {"rolls": 1, "entries": [{"type": "minecraft:item", "name": "minecraft:melon_slice",
                                  "functions": [{"function": "minecraft:set_count", "count": 15}]}]},
        {"rolls": 1, "entries": [{"type": "minecraft:item", "name": "minecraft:melon_seeds",
                                  "functions": [{"function": "minecraft:set_count", "count": 3}]}]},
    ])
    entity_loot("alive_tree", [
        item_pool("minecraft:oak_log", 3, 6),
        item_pool("minecraft:oak_sapling", 0, 2, looting=1),
    ])
    entity_loot("woodcock", [
        item_pool("randommobs:meep_feather", 1, 2),
        item_pool("minecraft:feather", 0, 1),
    ])
    entity_loot("tornado", [])
    entity_loot("lights", [
        item_pool("randommobs:storm_scale", 0, 1, looting=1),
        item_pool("minecraft:glowstone_dust", 0, 2),
    ])
    entity_loot("chest_mimic", [
        item_pool("minecraft:oak_planks", 2, 6),
        item_pool("randommobs:lock_key", 0, 1, chance=0.2),
        item_pool("minecraft:emerald", 0, 2, looting=1),
    ])
    entity_loot("water_grabber", [
        item_pool("minecraft:nautilus_shell", 0, 2, looting=1),
        item_pool("minecraft:tropical_fish", 1, 3),
        item_pool("randommobs:storm_scale", 1, 2),
    ])
    entity_loot("tank", [
        item_pool("randommobs:tank_track", 1, 2),
        item_pool("minecraft:iron_ingot", 3, 7),
        item_pool("minecraft:gunpowder", 2, 5),
    ])
    entity_loot("siren_head", [
        item_pool("randommobs:siren_bulb", 1, 2),
        item_pool("minecraft:iron_ingot", 2, 5),
        item_pool("randommobs:storm_scale", 1, 3),
    ])
    entity_loot("warship", [
        item_pool("minecraft:iron_block", 2, 4),
        item_pool("randommobs:siren_bulb", 1, 2),
        item_pool("minecraft:tnt", 2, 6),
    ])
    entity_loot("circuit", [
        item_pool("randommobs:circuit_fragment", 1, 2),
        item_pool("minecraft:redstone", 2, 6),
    ])
    entity_loot("ash_hound", [
        item_pool("minecraft:charcoal", 1, 3),
        item_pool("minecraft:bone", 0, 2, looting=1),
    ])
    entity_loot("cloud_ray", [
        item_pool("minecraft:phantom_membrane", 0, 2, looting=1),
        item_pool("randommobs:storm_scale", 1, 2),
    ])
    entity_loot("bog_wretch", [
        item_pool("minecraft:slime_ball", 1, 3),
        item_pool("minecraft:lily_pad", 0, 2),
    ])
    entity_loot("lantern_wraith", [
        item_pool("minecraft:glowstone_dust", 1, 3),
        item_pool("minecraft:soul_torch", 0, 2),
    ])
    entity_loot("hollow_neighbor", [
        item_pool("minecraft:emerald", 0, 2, looting=1),
        item_pool("randommobs:lock_key", 0, 1, chance=0.25),
    ])


    # ------------------------------------------------------------------ lang
    en = {"itemGroup.randommobs.main": "Random Mobs"}
    ru = {"itemGroup.randommobs.main": "Random Mobs"}
    for name, (english, russian, _) in ITEMS.items():
        en["item.randommobs." + name] = english
        ru["item.randommobs." + name] = russian
    for name, (english, russian, _) in BLOCKS.items():
        en["block.randommobs." + name] = english
        ru["block.randommobs." + name] = russian
    for name, (english, russian, _) in ENTITIES.items():
        en["entity.randommobs." + name] = english
        ru["entity.randommobs." + name] = russian
        en["item.randommobs." + name + "_spawn_egg"] = english + " Spawn Egg"
        ru["item.randommobs." + name + "_spawn_egg"] = "Яйцо призыва: " + russian
    en["item.randommobs.root_shard.travel"] = "The roots pull you somewhere else..."
    ru["item.randommobs.root_shard.travel"] = "Корни утягивают вас куда-то ещё..."
    en["item.randommobs.root_shard.no_dimension"] = "This world does not exist."
    ru["item.randommobs.root_shard.no_dimension"] = "Этого мира не существует."
    en["effect.randommobs.root_infection"] = "Root Infection"
    ru["effect.randommobs.root_infection"] = "Заражение корней"
    for name, data in ADVANCEMENTS.items():
        en["advancement.randommobs." + name + ".title"] = data["en"][0]
        en["advancement.randommobs." + name + ".description"] = data["en"][1]
        ru["advancement.randommobs." + name + ".title"] = data["ru"][0]
        ru["advancement.randommobs." + name + ".description"] = data["ru"][1]
    en["biome.randommobs.rooted_forest"] = "Rooted Forest"
    ru["biome.randommobs.rooted_forest"] = "Корневой лес"
    en["biome.randommobs.bloop_trench"] = "Bloop Trench"
    ru["biome.randommobs.bloop_trench"] = "Впадина блупа"
    en["biome.randommobs.scorched_plains"] = "Scorched Plains"
    ru["biome.randommobs.scorched_plains"] = "Выжженные равнины"
    en["storm.randommobs.calm"] = "calm"
    ru["storm.randommobs.calm"] = "спокойно"
    en["storm.randommobs.warning"] = "A storm is coming. A big one."
    ru["storm.randommobs.warning"] = "Идёт шторм. Большой."
    en["storm.randommobs.raging"] = "The storm is here. Stay inside."
    ru["storm.randommobs.raging"] = "Шторм пришёл. Не выходите наружу."
    en["storm.randommobs.aftermath"] = "The storm has passed... mostly."
    ru["storm.randommobs.aftermath"] = "Шторм прошёл... в основном."
    en["storm.randommobs.tornado"] = "A tornado touched down nearby!"
    ru["storm.randommobs.tornado"] = "Рядом коснулся земли торнадо!"
    en["storm.randommobs.rain_yes"] = "raining"
    ru["storm.randommobs.rain_yes"] = "дождь"
    en["storm.randommobs.rain_no"] = "dry"
    ru["storm.randommobs.rain_no"] = "сухо"
    en["item.randommobs.storm_radio.report"] = "Radio: %s, about %s seconds left."
    ru["item.randommobs.storm_radio.report"] = "Радио: %s, осталось около %s секунд."
    en["item.randommobs.weather_map.report"] = "Weather map: %s (%s s), sky is %s."
    ru["item.randommobs.weather_map.report"] = "Карта погоды: %s (%s с), на небе %s."
    en["item.randommobs.time_clock.report"] = "Day %s. %s in %s."
    ru["item.randommobs.time_clock.report"] = "День %s. %s через %s."
    en["item.randommobs.time_clock.night"] = "Night"
    ru["item.randommobs.time_clock.night"] = "Ночь"
    en["item.randommobs.time_clock.day"] = "Day"
    ru["item.randommobs.time_clock.day"] = "День"
    en["block.randommobs.locked_door.locked"] = "Locked. You need a key."
    ru["block.randommobs.locked_door.locked"] = "Заперто. Нужен ключ."
    en["block.randommobs.casino.need_ingot"] = "The casino wants a gold ingot in your hand."
    ru["block.randommobs.casino.need_ingot"] = "Казино хочет золотой слиток в руке."
    en["block.randommobs.casino.jackpot"] = "JACKPOT!"
    ru["block.randommobs.casino.jackpot"] = "ДЖЕКПОТ!"
    en["block.randommobs.casino.win"] = "You win an emerald."
    ru["block.randommobs.casino.win"] = "Вы выиграли изумруд."
    en["block.randommobs.casino.small_win"] = "A few gold nuggets. Barely worth it."
    ru["block.randommobs.casino.small_win"] = "Пара золотых самородков. Почти ничего."
    en["block.randommobs.casino.lose"] = "You lose."
    ru["block.randommobs.casino.lose"] = "Вы проиграли."
    en["block.randommobs.tv.boot"] = "The television hums to life..."
    ru["block.randommobs.tv.boot"] = "Телевизор с тихим гудением включается..."
    en["block.randommobs.tv.title"] = "Television"
    ru["block.randommobs.tv.title"] = "Телевизор"
    en["block.randommobs.tv.status"] = "connecting at 56k..."
    ru["block.randommobs.tv.status"] = "подключение на 56k..."
    for key, value in (("en_us", en), ("ru_ru", ru)):
        write(os.path.join(ASSETS, "lang", key + ".json"), value)
    print("resources generated")


if __name__ == "__main__":
    main()
