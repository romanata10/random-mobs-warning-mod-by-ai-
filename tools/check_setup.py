#!/usr/bin/env python3
"""Offline sanity checks for the Random Mobs mod.

Run from the repo root:  python3 tools/check_setup.py

Checks the things that most often break a Forge mod before you even open
the IDE: JSON syntax, langs consistency, texture sizes vs. model UVs,
advancement/biome-modifier wiring and sounds.json entries.
"""
import json
import os
import struct
import sys

ROOT = os.path.normpath(os.path.join(os.path.dirname(__file__), ".."))
RES = os.path.join(ROOT, "src", "main", "resources")
ASSETS = os.path.join(RES, "assets", "randommobs")
DATA = os.path.join(RES, "data", "randommobs")

errors = []
warnings = []


def check_json(path):
    try:
        with open(path, encoding="utf-8") as f:
            return json.load(f)
    except Exception as e:
        errors.append(f"{path}: {e}")
        return None


def png_size(path):
    with open(path, "rb") as f:
        head = f.read(24)
    if head[:8] != b"\x89PNG\r\n\x1a\n":
        errors.append(f"{path}: not a PNG")
        return None
    w, h = struct.unpack(">II", head[16:24])
    return w, h


def main():
    # ---- JSON files parse ----
    json_files = []
    for base in (RES,):
        for dirpath, _, filenames in os.walk(base):
            for name in filenames:
                if name.endswith(".json"):
                    json_files.append(os.path.join(dirpath, name))
    for path in json_files:
        check_json(path)
    print(f"[ok] {len(json_files)} JSON files parsed")

    # ---- Language keys are consistent between en_us and ru_ru ----
    en = check_json(os.path.join(ASSETS, "lang", "en_us.json")) or {}
    ru = check_json(os.path.join(ASSETS, "lang", "ru_ru.json")) or {}
    if set(en) != set(ru):
        warnings.append(
            "lang key mismatch: only in en_us: %s | only in ru_ru: %s"
            % (sorted(set(en) - set(ru)), sorted(set(ru) - set(en)))
        )
    else:
        print(f"[ok] en_us/ru_ru languages match ({len(en)} keys)")

    # ---- Entity texture sizes match the model UVs ----
    expected = {
        "tripod.png": (128, 256),
        "woodcrawler.png": (64, 64),
    }
    for name, size in expected.items():
        path = os.path.join(ASSETS, "textures", "entity", name)
        if not os.path.exists(path):
            errors.append(f"missing entity texture: {name}")
            continue
        actual = png_size(path)
        if actual != size:
            errors.append(f"{name}: expected {size}, got {actual}")
        else:
            print(f"[ok] {name} is {actual[0]}x{actual[1]} (matches model UV)")

    # ---- Advancements referenced from code exist on disk ----
    for adv in ("oh_thats_just_fish", "root_virus"):
        path = os.path.join(DATA, "advancements", f"{adv}.json")
        if os.path.exists(path):
            print(f"[ok] advancement {adv}.json exists")
        else:
            errors.append(f"missing advancement {adv}.json")

    # ---- Biome modifiers exist ----
    for bm in ("tripod_spawns", "woodcrawler_spawns"):
        path = os.path.join(DATA, "forge", "biome_modifier", f"{bm}.json")
        if os.path.exists(path):
            print(f"[ok] biome modifier {bm}.json exists")
        else:
            errors.append(f"missing biome modifier {bm}.json")

    # ---- sounds.json entries referenced by subtitles ----
    sounds = check_json(os.path.join(ASSETS, "sounds.json")) or {}
    for key in sounds:
        sub = sounds[key].get("subtitle")
        if sub and sub not in en:
            warnings.append(f"subtitle key {sub} missing from en_us.json")
    if sounds:
        print(f"[ok] sounds.json has {len(sounds)} entries")

    # ---- mods.toml placeholders use the ${...} syntax ----
    mods_toml = os.path.join(RES, "META-INF", "mods.toml")
    with open(mods_toml, encoding="utf-8") as f:
        text = f.read()
    for token in ("${mod_id}", "${mod_version}", "${loader_version_range}"):
        if token not in text:
            errors.append(f"mods.toml is missing the {token} placeholder")
    print("[ok] mods.toml placeholders present")

    print()
    for w in warnings:
        print("WARN:", w)
    for e in errors:
        print("ERROR:", e)
    if errors:
        sys.exit(1)
    print("All checks passed.")


if __name__ == "__main__":
    main()
