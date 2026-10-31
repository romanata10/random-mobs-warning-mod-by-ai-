#!/usr/bin/env python3
"""Rough fit check: how tall is each generated model, and does it match its hitbox?"""
import os
import re
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from models import MOBS  # noqa: E402
from generate_assets import model_bounds  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ENT = os.path.join(ROOT, "src/main/java/com/arena/randommobs/registry/ModEntities.java")
src = open(ENT).read()
found = re.findall(r'ENTITIES\.register\("([a-z_]+)"[\s\S]{0,260}?\.sized\(([\d.]+)F, ([\d.]+)F\)', src)
sizes = {n: (float(w), float(h)) for n, w, h in found}


print("%-16s %7s %7s %7s" % ("mob", "model", "hitbox", "bottom"))
for name, spec in MOBS.items():
    low, high = model_bounds(spec)
    shift = -low if low < 0 else 0.0
    scale = spec["height"] / ((high + shift) / 16.0)
    box = sizes.get(name)
    print("%-16s %6.2fb %6s %7.2fb %s" % (
        name, (high + shift) / 16.0 * scale, ("%.2fb" % box[1]) if box else "?", 0.0,
        "OK" if box and abs((high + shift) / 16.0 * scale - box[1]) < 0.05 else "MISMATCH"))
