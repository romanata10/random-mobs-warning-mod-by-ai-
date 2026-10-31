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
}

BLOCKS = {
    "red_roots": ("Red Roots", "Красные корни", "cross"),
    "root_liana": ("Root Liana", "Корневая лиана", "cross"),
    "mockery_bloom": ("Nature's Mockery", "Насмешка природы", "cross"),
    "red_root_block": ("Red Root Block", "Блок красных корней", "cube"),
    "alien_metal_block": ("Alien Metal Block", "Блок чужого металла", "cube"),
    "bloop_flesh_block": ("Bloop Flesh", "Плоть блупа", "cube"),
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


def block_model(name, kind):
    if kind == "cross":
        write(os.path.join(ASSETS, "models/block", name + ".json"),
              {"parent": "minecraft:block/cross",
               "textures": {"cross": "randommobs:block/" + name}})
    else:
        write(os.path.join(ASSETS, "models/block", name + ".json"),
              {"parent": "minecraft:block/cube_all",
               "textures": {"all": "randommobs:block/" + name}})
    write(os.path.join(ASSETS, "blockstates", name + ".json"),
          {"variants": {"": {"model": "randommobs:block/" + name}}})
    write(os.path.join(ASSETS, "models/item", name + ".json"),
          {"parent": "randommobs:block/" + name})


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
            "result": result, "experience": 0.35, "cookingtime": 200,
        })
        write(os.path.join(DATA, "recipes", result + "_from_smoking.json"), {
            "type": "minecraft:smoking", "ingredient": {"item": ingredient},
            "result": result, "experience": 0.35, "cookingtime": 100,
        })
        write(os.path.join(DATA, "recipes", result + "_from_campfire_cooking.json"), {
            "type": "minecraft:campfire_cooking", "ingredient": {"item": ingredient},
            "result": result, "experience": 0.35, "cookingtime": 600,
        })


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
    for key, value in (("en_us", en), ("ru_ru", ru)):
        write(os.path.join(ASSETS, "lang", key + ".json"), value)
    print("resources generated")


if __name__ == "__main__":
    main()
