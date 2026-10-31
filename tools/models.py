"""Model specifications for every Random Mobs creature (v2).

Coordinate system matches vanilla entity models: 16 units = 1 block, +Y points DOWN,
the model origin sits 1.5 blocks above the ground (feet end up around y = +24),
and -Z is the direction the mob is looking at.

Pivots of root-level parts are absolute; pivots of nested parts are relative to
their parent (vanilla behaviour).

Every box carries a texture spec: ``color`` + ``style`` for the base material and an
optional ``face`` decoration that is painted on the front (north) face of the box.
"""


def box(x, y, z, w, h, d, color, style="noise", face=None, glow=False):
    return {"x": x, "y": y, "z": z, "w": w, "h": h, "d": d,
            "color": color, "style": style, "face": face, "glow": glow}


def part(name, pivot, boxes, parent=None, rot=None, anim=None):
    return {"name": name, "pivot": pivot, "boxes": boxes, "parent": parent,
            "rot": rot, "anim": anim}


def leg(name, x, y, z, upper, lower, thick, upper_color, lower_color, style="chitin",
        out=0.0, spread=0.0, anim="leg"):
    """Two segment leg; returns two parts (thigh + shin) with the shin nested."""
    thigh = part(name, (x, y, z), [
        box(-thick // 2, 0, -thick // 2, thick, upper, thick, upper_color, style),
    ], rot=(0, 0, out), anim=anim)
    shin = part(name + "_low", (0, upper, 0), [
        box(-thick // 2, 0, -thick // 2, thick, lower, thick, lower_color, style),
    ], parent=name, rot=(0, 0, spread), anim=anim + "_low")
    return [thigh, shin]


def spider_legs(prefix, pivot_y, radius_x, radius_z, upper, lower, thick,
                upper_color, lower_color, style="chitin", anim="leg"):
    """Eight angular spider legs (4 per side), like the creature on the reference photo."""
    parts = []
    for side, sx in (("l", -1), ("r", 1)):
        for i, (ang, zoff) in enumerate(((-38, -5), (-16, -2), (16, 2), (38, 5))):
            x = sx * radius_x
            z = zoff * (radius_z / 5.0)
            name = "%s_%s%d" % (prefix, side, i)
            thigh = part(name, (x, pivot_y, z), [
                box(-thick // 2, -2, -thick // 2, thick, upper, thick, upper_color, style),
            ], rot=(-ang * 0.55, 0, -sx * (18 + abs(ang) * 0.35)), anim=anim)
            shin = part(name + "_low", (0, upper, 0), [
                box(-thick // 2, 0, -thick // 2, thick - 1, lower, thick - 1,
                    lower_color, style),
            ], parent=name, rot=(0, 0, sx * (52 + abs(ang) * 0.5)), anim=anim + "_low")
            parts += [thigh, shin]
    return parts


MOBS = {}

# ---------------------------------------------------------------- 1. Tripod
MOBS["tripod"] = {
    "class": "TripodModel", "shadow": 2.2, "scale": 1.13, "height": 6.4,
    "parts": [
        part("body", (0, -18, 0), [
            box(-12, -13, -12, 24, 26, 24, "#565d68", "metal", face="panel"),
            box(-14, -4, -8, 28, 7, 16, "#3d434c", "metal"),
            box(-6, -16, -13, 12, 8, 2, "#2f343b", "metal", face="vent"),
        ], anim="bob"),
        part("head", (0, -30, 0), [
            box(-9, -10, -9, 18, 12, 18, "#666e79", "metal", face="panel"),
            box(-5, -7, -10, 10, 6, 2, "#1d2127", "metal", face="visor"),
        ], anim="head"),
        part("eye", (0, -33, -8), [
            box(-4, -4, -3, 8, 8, 3, "#ffe98a", "lens", glow=True),
        ], parent="head", anim="eye"),
        part("leg_a", (12, -8, 9), [
            box(-3, 0, -3, 6, 22, 6, "#3a4049", "metal"),
        ], rot=(-12, 0, -9), anim="leg"),
        part("leg_a_low", (0, 22, 0), [
            box(-2, 0, -2, 4, 20, 4, "#2e333a", "metal"),
        ], parent="leg_a", rot=(14, 0, 4), anim="leg_low"),
        part("leg_b", (-12, -8, 9), [
            box(-3, 0, -3, 6, 22, 6, "#3a4049", "metal"),
        ], rot=(-12, 0, 9), anim="leg"),
        part("leg_b_low", (0, 22, 0), [
            box(-2, 0, -2, 4, 20, 4, "#2e333a", "metal"),
        ], parent="leg_b", rot=(14, 0, -4), anim="leg_low"),
        part("leg_c", (0, -8, -13), [
            box(-3, 0, -3, 6, 22, 6, "#3a4049", "metal"),
        ], rot=(14, 0, 0), anim="leg"),
        part("leg_c_low", (0, 22, 0), [
            box(-2, 0, -2, 4, 20, 4, "#2e333a", "metal"),
        ], parent="leg_c", rot=(-16, 0, 0), anim="leg_low"),
    ],
}

# ---------------------------------------------------------------- 2. Woodcrawler
# Tall angular spider-thing: segmented hanging body, long bent legs, glowing eyes.
MOBS["woodcrawler"] = {
    "class": "WoodcrawlerModel", "shadow": 0.9, "scale": 0.76, "height": 2.0,
    "parts": [
        # vertical segmented abdomen hanging between the legs
        part("body", (0, -2, 0), [
            box(-4, -6, -4, 8, 7, 8, "#4a3a2a", "chitin", face="plates"),
            box(-3, 1, -3, 6, 6, 6, "#41321f", "chitin", face="plates"),
            box(-3, 7, -3, 6, 6, 6, "#382b1a", "chitin", face="plates"),
            box(-2, 13, -2, 4, 5, 4, "#302417", "chitin", face="plates"),
        ], anim="bob"),
        part("head", (0, -10, -1), [
            box(-5, -6, -5, 10, 9, 10, "#584430", "chitin", face="skull"),
            box(-4, 2, -4, 8, 3, 8, "#2b2116", "chitin", face="jaw"),
        ], parent="body", anim="head"),
        part("eye_l", (-2, -3, -5), [
            box(-1, -1, -1, 2, 2, 1, "#c9ff8a", "lens", glow=True),
        ], parent="head", anim="eye"),
        part("eye_r", (1, -3, -5), [
            box(-1, -1, -1, 2, 2, 1, "#c9ff8a", "lens", glow=True),
        ], parent="head", anim="eye"),
        *spider_legs("leg", -6, 5, 5, 26, 30, 3, "#4f3d29", "#332718", "chitin"),
    ],
}

# ---------------------------------------------------------------- 3. Bloop
MOBS["bloop"] = {
    "class": "BloopModel", "shadow": 3.4, "scale": 1.02, "height": 4.2,
    "parts": [
        part("body", (0, -10, 0), [
            box(-26, -16, -24, 52, 34, 48, "#243c4a", "flesh", face="mouth"),
            box(-20, -26, -18, 40, 12, 36, "#2d4a59", "flesh"),
            box(-32, -2, -28, 64, 8, 56, "#1c2f3a", "flesh"),
        ], anim="bob"),
        part("head", (0, -26, -20), [
            box(-10, -6, -8, 20, 12, 10, "#2f505f", "flesh", face="eye"),
        ], parent="body", anim="head"),
        *[part("tentacle_%d" % i, (-18 + i * 12, 6, 0), [
            box(-3, 0, -3, 6, 26, 6, "#1e333d", "flesh"),
        ], parent="body", rot=(0, 0, (i - 2) * 8), anim="tentacle") for i in range(5)],
    ],
}

# ---------------------------------------------------------------- 4. Alive House
MOBS["alive_house"] = {
    "class": "AliveHouseModel", "shadow": 1.8, "scale": 0.84, "height": 4.5,
    "parts": [
        part("body", (0, -4, 0), [
            box(-30, -30, -30, 60, 34, 60, "#8a7a63", "planks", face="window"),
            box(-34, -34, -34, 68, 6, 68, "#5c4b3a", "planks"),
            box(-26, -44, -26, 52, 12, 52, "#4a3a2c", "planks", face="door"),
        ], anim="bob"),
        part("head", (0, -44, -28), [
            box(-8, -14, -4, 16, 16, 8, "#8a7a63", "planks", face="window"),
        ], parent="body", anim="head"),
        part("leg_a", (18, -2, 18), [
            box(-3, 0, -3, 6, 20, 6, "#3f3227", "planks"),
        ], rot=(-8, 0, -6), anim="leg"),
        part("leg_b", (-18, -2, 18), [
            box(-3, 0, -3, 6, 20, 6, "#3f3227", "planks"),
        ], rot=(-8, 0, 6), anim="leg"),
        part("leg_c", (18, -2, -18), [
            box(-3, 0, -3, 6, 20, 6, "#3f3227", "planks"),
        ], rot=(8, 0, -6), anim="leg"),
        part("leg_d", (-18, -2, -18), [
            box(-3, 0, -3, 6, 20, 6, "#3f3227", "planks"),
        ], rot=(8, 0, 6), anim="leg"),
    ],
}

# ---------------------------------------------------------------- 5. Giant Spider
MOBS["giant_spider"] = {
    "class": "GiantSpiderModel", "shadow": 1.8, "scale": 1.01, "height": 2.2,
    "parts": [
        part("body", (0, 2, 6), [
            box(-10, -9, -8, 20, 16, 22, "#2c2119", "chitin", face="plates"),
            box(-7, -13, -20, 14, 12, 14, "#392b20", "chitin", face="spider"),
        ], anim="bob"),
        part("head", (0, -2, -14), [
            box(-7, -6, -8, 14, 11, 12, "#3a2c21", "chitin", face="spider"),
            *[box(-2 + i * 4, -4, -9, 2, 2, 1, "#ff4d4d", "lens", glow=True) for i in range(3)],
        ], parent="body", anim="head"),
        *spider_legs("leg", -2, 9, 4, 22, 24, 3, "#332619", "#241a11", "chitin"),
    ],
}

# ---------------------------------------------------------------- 6. Gardener
MOBS["gardener"] = {
    "class": "GardenerModel", "shadow": 1.2, "scale": 0.54, "height": 3.2,
    "parts": [
        part("body", (0, -14, 0), [
            box(-12, -12, -12, 24, 24, 24, "#b7a794", "jelly", face="ridge"),
            box(-16, 8, -8, 32, 8, 16, "#a2917c", "jelly"),
        ], anim="bob"),
        part("head", (0, -22, 0), [
            box(-9, -9, -9, 18, 9, 18, "#c9bbaa", "jelly", face="ridge"),
        ], parent="body", anim="head"),
        part("orb", (0, -30, 0), [
            box(-5, -5, -5, 10, 10, 10, "#fff2a8", "lens", glow=True),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-9 + i * 4.5, 12, -9 + (i % 2) * 18), [
            box(-2, 0, -2, 4, 30 + i * 2, 4, "#b0a08d", "jelly"),
        ], parent="body", rot=(0, 0, (i - 2) * 5), anim="tentacle") for i in range(5)],
    ],
}

# ---------------------------------------------------------------- 7. Sand Worm
MOBS["sand_worm"] = {
    "class": "SandWormModel", "shadow": 2.0, "scale": 1.04, "height": 2.2,
    "parts": [
        part("body", (0, 6, 10), [
            box(-16, -16, -10, 32, 30, 22, "#b79b6d", "sand", face="segments"),
            box(-13, -13, -24, 26, 24, 16, "#c2a97b", "sand", face="segments"),
        ], anim="bob"),
        part("head", (0, -2, -24), [
            box(-11, -11, -8, 22, 22, 10, "#c9b184", "sand", face="teeth"),
            box(-8, -8, -10, 16, 16, 3, "#3a2318", "wet", face="throat"),
        ], parent="body", anim="head"),
        part("jaw", (0, 8, -30), [
            box(-10, 0, -3, 20, 4, 6, "#e2d3ae", "bone", face="teeth"),
        ], parent="head", anim="jaw"),
    ],
}

# ---------------------------------------------------------------- 8. UFO
MOBS["ufo"] = {
    "class": "UfoModel", "shadow": 1.4, "scale": 0.76, "height": 2.0,
    "parts": [
        part("body", (0, -6, 0), [
            box(-22, -6, -22, 44, 8, 44, "#8d979e", "metal", face="panel"),
            box(-14, -12, -14, 28, 6, 28, "#a6b0b7", "metal"),
            box(-26, 2, -26, 52, 4, 52, "#6d767c", "metal"),
        ], anim="bob"),
        part("head", (0, 4, 0), [
            box(-10, 0, -10, 20, 5, 20, "#3a4a52", "metal", face="lights"),
        ], parent="body", anim="eye"),
        *[part("lamp_%d" % i, (-16 + i * 11, 4, -16 + (i % 2) * 32), [
            box(-2, 0, -2, 4, 3, 4, "#8ef7c8", "lens", glow=True),
        ], parent="body", anim="rotor") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 9. Bear
MOBS["bear"] = {
    "class": "BearModel", "shadow": 1.0, "scale": 0.70, "height": 1.8,
    "parts": [
        part("body", (0, 2, 2), [
            box(-9, -10, -14, 18, 18, 30, "#4b3524", "fur", face="fur"),
            box(-7, -14, -16, 14, 6, 18, "#59402c", "fur"),
        ], anim="bob"),
        part("head", (0, -12, -16), [
            box(-7, -7, -8, 14, 13, 12, "#513a27", "fur", face="bear"),
            box(-3, -2, -11, 6, 5, 4, "#b09a7c", "fur", face="snout"),
        ], parent="body", anim="head"),
        *[part("leg_%d" % i, (-6 + (i % 2) * 12, 8, -8 + (i // 2) * 18), [
            box(-3, 0, -3, 6, 16, 6, "#3f2c1e", "fur"),
        ], parent="body", anim="leg") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 10. Kraken
MOBS["kraken"] = {
    "class": "KrakenModel", "shadow": 2.6, "scale": 0.99, "height": 4.2,
    "parts": [
        part("body", (0, -12, 0), [
            box(-18, -18, -18, 36, 34, 36, "#3d2a55", "flesh", face="suckers"),
            box(-13, -26, -13, 26, 10, 26, "#4a3466", "flesh"),
        ], anim="bob"),
        part("head", (0, -24, -14), [
            box(-9, -8, -8, 18, 13, 14, "#503a70", "flesh", face="eye"),
        ], parent="body", anim="head"),
        *[part("tentacle_%d" % i, (-14 + i * 7, 14, -14 + (i % 2) * 28), [
            box(-3, 0, -3, 6, 34 + (i % 3) * 6, 6, "#38264e", "flesh"),
        ], parent="body", rot=(0, 0, (i - 3) * 7), anim="tentacle") for i in range(7)],
    ],
}

# ---------------------------------------------------------------- 11. Evil Watermelon
MOBS["evil_watermelon"] = {
    "class": "EvilWatermelonModel", "shadow": 0.6, "scale": 0.50, "height": 1.0,
    "parts": [
        part("body", (0, 6, 0), [
            box(-8, -14, -8, 16, 16, 16, "#2f6b24", "melon", face="melon"),
        ], anim="bob"),
        part("head", (0, 10, -8), [
            box(-6, -3, -2, 12, 6, 3, "#e8f0c0", "bone", face="teeth"),
        ], parent="body", anim="jaw"),
        *[part("leg_%d" % i, (-4 + (i % 2) * 8, 12, -3 + (i // 2) * 6), [
            box(-1, 0, -1, 3, 8, 3, "#264d1c", "chitin"),
        ], parent="body", anim="leg") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 12. Alive Tree
MOBS["alive_tree"] = {
    "class": "AliveTreeModel", "shadow": 1.6, "scale": 0.99, "height": 4.6,
    "parts": [
        part("body", (0, -8, 0), [
            box(-7, -26, -7, 14, 34, 14, "#5a4128", "bark", face="bark"),
            box(-16, -34, -16, 32, 12, 32, "#2f5c26", "leaves", face="leaves"),
            box(-12, -42, -12, 24, 9, 24, "#376a2c", "leaves"),
        ], anim="bob"),
        part("head", (0, -24, -8), [
            box(-5, -6, -3, 10, 8, 5, "#6a4d2f", "bark", face="knots"),
        ], parent="body", anim="head"),
        *[part("leg_%d" % i, (-6 + (i % 2) * 12, 8, -6 + (i // 2) * 12), [
            box(-2, 0, -2, 4, 18, 4, "#4a3420", "bark"),
        ], parent="body", anim="leg") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 13. Woodcock
MOBS["woodcock"] = {
    "class": "WoodcockModel", "shadow": 0.3, "scale": 0.80, "height": 0.9,
    "parts": [
        part("body", (0, 12, 0), [
            box(-4, -6, -6, 8, 8, 12, "#6b5335", "feather", face="feather"),
        ], anim="bob"),
        part("head", (0, 9, -6), [
            box(-3, -3, -3, 6, 6, 6, "#7b6140", "feather", face="bird"),
            box(-1, -3, -10, 2, 2, 7, "#c8a86a", "bone"),
        ], parent="body", anim="head"),
        part("wing_l", (-4, 9, 0), [
            box(-2, 0, -5, 2, 6, 10, "#5d472d", "feather"),
        ], parent="body", anim="wing"),
        part("wing_r", (4, 9, 0), [
            box(0, 0, -5, 2, 6, 10, "#5d472d", "feather"),
        ], parent="body", anim="wing"),
        part("leg_l", (-2, 16, 0), [
            box(-1, 0, -1, 2, 8, 2, "#a88450", "bone"),
        ], parent="body", anim="leg"),
        part("leg_r", (2, 16, 0), [
            box(-1, 0, -1, 2, 8, 2, "#a88450", "bone"),
        ], parent="body", anim="leg"),
    ],
}

# ---------------------------------------------------------------- 14. Lights
# Small grey quadruped with one huge glowing white eye; appears around storms.
MOBS["lights"] = {
    "class": "LightsModel", "shadow": 0.5, "scale": 0.62, "height": 1.0,
    "parts": [
        part("body", (0, 8, 0), [
            box(-7, -8, -9, 14, 13, 18, "#8e9095", "skin", face="skin"),
            box(-5, -10, -11, 10, 5, 6, "#9aa0a6", "skin"),
        ], anim="bob"),
        part("head", (0, 4, -10), [
            box(-6, -6, -5, 12, 11, 9, "#9ba1a7", "skin", face="socket"),
        ], parent="body", anim="head"),
        part("eye", (0, 1, -15), [
            box(-4, -4, -2, 8, 8, 3, "#ffffff", "lens", glow=True, face="iris"),
        ], parent="head", anim="eye"),
        *[part("leg_%d" % i, (-5 + (i % 2) * 10, 6, -6 + (i // 2) * 12), [
            box(-2, 0, -2, 4, 12, 4, "#7c7f85", "skin"),
        ], parent="body", anim="leg") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 15. Chest Mimic
MOBS["chest_mimic"] = {
    "class": "ChestMimicModel", "shadow": 0.6, "scale": 0.70, "height": 1.0,
    "parts": [
        part("body", (0, 10, 0), [
            box(-7, -7, -5, 14, 12, 10, "#8a6134", "wood", face="chest"),
            box(-7, -9, -5, 14, 3, 10, "#a67a45", "wood", face="lid"),
        ], anim="bob"),
        part("head", (0, 5, -5), [
            box(-5, -2, -2, 10, 5, 3, "#2b1c10", "wet", face="teeth"),
        ], parent="body", anim="jaw"),
        *[part("leg_%d" % i, (-4 + (i % 2) * 8, 14, -3 + (i // 2) * 6), [
            box(-1, 0, -1, 3, 6, 3, "#3b2a18", "chitin"),
        ], parent="body", anim="leg") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 16. Water Grabber
MOBS["water_grabber"] = {
    "class": "WaterGrabberModel", "shadow": 1.6, "scale": 0.80, "height": 1.6,
    "parts": [
        part("body", (0, 2, 0), [
            box(-16, -8, -16, 32, 14, 32, "#7a2f3c", "flesh", face="star"),
            box(-12, 6, -12, 24, 5, 24, "#5e2230", "flesh"),
        ], anim="bob"),
        part("head", (0, -6, 0), [
            box(-7, -4, -7, 14, 6, 14, "#2a0f16", "wet", face="maw"),
        ], parent="body", anim="jaw"),
        part("arm_l", (-16, 0, 0), [
            box(-2, -3, -2, 4, 26, 4, "#83343f", "flesh"),
        ], parent="body", rot=(0, 0, -30), anim="arm"),
        part("arm_l_low", (0, 26, 0), [
            box(-2, 0, -2, 3, 26, 3, "#6f2a36", "flesh"),
        ], parent="arm_l", rot=(-24, 0, 20), anim="arm_low"),
        part("arm_r", (16, 0, 0), [
            box(-2, -3, -2, 4, 26, 4, "#83343f", "flesh"),
        ], parent="body", rot=(0, 0, 30), anim="arm"),
        part("arm_r_low", (0, 26, 0), [
            box(-2, 0, -2, 3, 26, 3, "#6f2a36", "flesh"),
        ], parent="arm_r", rot=(-24, 0, -20), anim="arm_low"),
    ],
}

# ---------------------------------------------------------------- 17. Tank
MOBS["tank"] = {
    "class": "TankModel", "shadow": 1.6, "scale": 1.01, "height": 2.4,
    "parts": [
        part("body", (0, 4, 0), [
            box(-16, -8, -22, 32, 14, 44, "#4c5445", "milmetal", face="armor"),
            box(-18, 4, -24, 36, 6, 48, "#3c4337", "milmetal"),
            box(-14, -12, -20, 28, 5, 40, "#454d3f", "milmetal", face="tracks"),
        ], anim="bob"),
        part("head", (0, -10, 4), [
            box(-10, -8, -10, 20, 10, 20, "#525b4a", "milmetal", face="armor"),
            box(-2, -5, -26, 4, 4, 18, "#2f3529", "milmetal"),
            box(-3, -6, -28, 6, 6, 4, "#232820", "milmetal", face="muzzle"),
        ], parent="body", anim="head"),
    ],
}

# ---------------------------------------------------------------- 18. Siren Head
MOBS["siren_head"] = {
    "class": "SirenHeadModel", "shadow": 1.6, "scale": 1.52, "height": 9.5,
    "parts": [
        part("body", (0, -6, 0), [
            box(-5, -44, -4, 10, 58, 8, "#5d5145", "skin", face="ribs"),
            box(-8, 10, -5, 16, 12, 10, "#4d4238", "skin"),
        ], anim="bob"),
        part("head", (0, -46, 0), [
            box(-7, -10, -6, 14, 11, 12, "#6a5c4d", "rust", face="speaker"),
            box(-5, -24, -5, 10, 15, 10, "#5f5244", "rust", face="speaker"),
            box(-2, -13, -7, 4, 4, 2, "#ff3b30", "lens", glow=True),
        ], parent="body", anim="head"),
        part("arm_l", (-6, -34, 0), [
            box(-2, 0, -2, 4, 34, 4, "#54483d", "skin"),
        ], parent="body", rot=(0, 0, -4), anim="arm"),
        part("arm_r", (6, -34, 0), [
            box(-2, 0, -2, 4, 34, 4, "#54483d", "skin"),
        ], parent="body", rot=(0, 0, 4), anim="arm"),
    ],
}

# ---------------------------------------------------------------- 19. Warship
MOBS["warship"] = {
    "class": "WarshipModel", "shadow": 3.0, "scale": 1.37, "height": 6.0,
    "parts": [
        part("body", (0, 0, 0), [
            box(-18, -10, -46, 36, 18, 92, "#5a6067", "milmetal", face="hull"),
            box(-14, -18, -34, 28, 9, 60, "#666d75", "milmetal", face="deck"),
            box(-6, -30, -18, 12, 13, 20, "#7b838c", "milmetal", face="bridge"),
            box(-2, -46, -6, 3, 18, 3, "#4b5259", "milmetal"),
        ], anim="bob"),
        part("head", (0, -18, -40), [
            box(-7, -6, -8, 14, 8, 16, "#5f666e", "milmetal", face="armor"),
            box(-1, -4, -22, 2, 2, 14, "#31363b", "milmetal"),
        ], parent="body", anim="head"),
    ],
}

# ---------------------------------------------------------------- 20. Circuit
MOBS["circuit"] = {
    "class": "CircuitModel", "shadow": 0.8, "scale": 0.73, "height": 2.2,
    "parts": [
        part("body", (0, -4, 0), [
            box(-6, -6, -4, 12, 20, 8, "#1d1d22", "circuit", face="screen"),
            box(-7, -8, -5, 14, 5, 10, "#2a2a33", "circuit"),
        ], anim="bob"),
        part("head", (0, -12, 0), [
            box(-6, -8, -6, 12, 11, 12, "#15151a", "circuit", face="tvscreen"),
            *[box(-4 + i * 3, -5, -7, 2, 2, 1, "#ff2b2b", "lens", glow=True) for i in range(3)],
        ], parent="body", anim="head"),
        part("arm_l", (-7, -4, 0), [
            box(-2, 0, -2, 3, 20, 3, "#202027", "circuit"),
        ], parent="body", rot=(0, 0, -6), anim="arm"),
        part("arm_r", (7, -4, 0), [
            box(-1, 0, -2, 3, 20, 3, "#202027", "circuit"),
        ], parent="body", rot=(0, 0, 6), anim="arm"),
        part("leg_l", (-3, 14, 0), [
            box(-2, 0, -2, 3, 12, 3, "#202027", "circuit"),
        ], parent="body", anim="leg"),
        part("leg_r", (3, 14, 0), [
            box(-1, 0, -2, 3, 12, 3, "#202027", "circuit"),
        ], parent="body", anim="leg"),
    ],
}

# ---------------------------------------------------------------- 21. Ash Hound
MOBS["ash_hound"] = {
    "class": "AshHoundModel", "shadow": 0.9, "scale": 0.74, "height": 1.3,
    "parts": [
        part("body", (0, 6, 2), [
            box(-7, -8, -14, 14, 14, 28, "#3a3531", "ash", face="ash"),
        ], anim="bob"),
        part("head", (0, -2, -14), [
            box(-6, -6, -8, 12, 11, 12, "#423c37", "ash", face="hound"),
            box(-3, 1, -12, 6, 4, 6, "#2a2624", "ash", face="teeth"),
            *[box(-3 + i * 6, -8, -6, 2, 4, 2, "#c46a2a", "lens", glow=True) for i in range(2)],
        ], parent="body", anim="head"),
        *[part("leg_%d" % i, (-5 + (i % 2) * 10, 6, -8 + (i // 2) * 16), [
            box(-2, 0, -2, 4, 14, 4, "#312c29", "ash"),
        ], parent="body", anim="leg") for i in range(4)],
        part("tentacle_0", (0, 4, 14), [
            box(-2, 0, -2, 3, 14, 3, "#2e2a27", "ash"),
        ], parent="body", rot=(30, 0, 0), anim="tentacle"),
    ],
}

# ---------------------------------------------------------------- 22. Cloud Ray
MOBS["cloud_ray"] = {
    "class": "CloudRayModel", "shadow": 1.6, "scale": 0.66, "height": 1.6,
    "parts": [
        part("body", (0, -6, 0), [
            box(-9, -4, -14, 18, 7, 28, "#cfd6dd", "cloud", face="ray"),
            box(-26, -3, -10, 18, 3, 22, "#bcc4cc", "cloud"),
            box(8, -3, -10, 18, 3, 22, "#bcc4cc", "cloud"),
        ], anim="bob"),
        part("head", (0, -6, -14), [
            box(-5, -3, -5, 10, 6, 8, "#dde3e8", "cloud", face="ray"),
        ], parent="body", anim="head"),
        part("wing_l", (-26, -6, 6), [
            box(-2, 0, -2, 3, 22, 3, "#b8c0c8", "cloud"),
        ], parent="body", rot=(0, 0, -18), anim="wing"),
        part("wing_r", (26, -6, 6), [
            box(-1, 0, -2, 3, 22, 3, "#b8c0c8", "cloud"),
        ], parent="body", rot=(0, 0, 18), anim="wing"),
        part("tentacle_0", (0, 0, 12), [
            box(-1, 0, -1, 2, 18, 2, "#c3cad1", "cloud"),
        ], parent="body", rot=(20, 0, 0), anim="tentacle"),
    ],
}

# ---------------------------------------------------------------- 23. Bog Wretch
MOBS["bog_wretch"] = {
    "class": "BogWretchModel", "shadow": 0.9, "scale": 0.86, "height": 2.2,
    "parts": [
        part("body", (0, 0, 0), [
            box(-8, -10, -6, 16, 20, 12, "#43563a", "wet", face="ribs"),
            box(-10, 8, -7, 20, 8, 14, "#38492f", "wet"),
        ], anim="bob"),
        part("head", (0, -10, -4), [
            box(-6, -7, -7, 12, 11, 11, "#4c6141", "wet", face="skull"),
            box(-2, -2, -10, 4, 5, 4, "#8ea86a", "wet", face="teeth"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, -6, 0), [
            box(-2, 0, -2, 3, 26, 3, "#3c4d33", "wet"),
        ], parent="body", rot=(-8, 0, -10), anim="arm"),
        part("arm_l_low", (0, 26, 0), [
            box(-2, 0, -2, 3, 20, 3, "#33432c", "wet"),
        ], parent="arm_l", rot=(18, 0, 0), anim="arm_low"),
        part("arm_r", (8, -6, 0), [
            box(-1, 0, -2, 3, 26, 3, "#3c4d33", "wet"),
        ], parent="body", rot=(-8, 0, 10), anim="arm"),
        part("arm_r_low", (0, 26, 0), [
            box(-1, 0, -2, 3, 20, 3, "#33432c", "wet"),
        ], parent="arm_r", rot=(18, 0, 0), anim="arm_low"),
    ],
}

# ---------------------------------------------------------------- 24. Lantern Wraith
MOBS["lantern_wraith"] = {
    "class": "LanternWraithModel", "shadow": 0.7, "scale": 0.51, "height": 2.0,
    "parts": [
        part("body", (0, -2, 0), [
            box(-7, -12, -6, 14, 26, 12, "#2b2a3a", "cloth", face="cloth"),
            box(-9, 10, -8, 18, 8, 16, "#232232", "cloth"),
        ], anim="bob"),
        part("head", (0, -14, 0), [
            box(-5, -6, -5, 10, 10, 10, "#1d1c28", "cloth", face="hood"),
        ], parent="body", anim="head"),
        part("orb", (0, -20, -2), [
            box(-3, -3, -3, 6, 6, 6, "#a9e9ff", "lens", glow=True),
        ], parent="head", anim="eye"),
        part("arm_l", (-7, -8, 0), [
            box(-2, 0, -2, 3, 24, 3, "#2b2a3a", "cloth"),
        ], parent="body", rot=(0, 0, -12), anim="arm"),
        part("arm_r", (7, -8, 0), [
            box(-1, 0, -2, 3, 24, 3, "#2b2a3a", "cloth"),
        ], parent="body", rot=(0, 0, 12), anim="arm"),
        part("tentacle_0", (0, 16, 0), [
            box(-4, 0, -4, 8, 10, 8, "#1b1a26", "cloth"),
        ], parent="body", anim="tentacle"),
    ],
}

# ---------------------------------------------------------------- 25. Hollow Neighbor
MOBS["hollow_neighbor"] = {
    "class": "HollowNeighborModel", "shadow": 0.9, "scale": 0.66, "height": 2.1,
    "parts": [
        part("body", (0, -6, 0), [
            box(-7, -6, -4, 14, 22, 8, "#6f5a45", "cloth", face="robe"),
            box(-6, 12, -3, 12, 8, 6, "#5c4a39", "cloth"),
        ], anim="bob"),
        part("head", (0, -12, -2), [
            box(-6, -9, -5, 12, 12, 10, "#8a7057", "skin", face="faceless"),
            box(-7, -4, -6, 14, 5, 3, "#5a4534", "skin"),
        ], parent="body", anim="head"),
        part("arm_l", (-7, -6, 0), [
            box(-2, 0, -2, 3, 22, 3, "#7a6349", "cloth"),
        ], parent="body", rot=(0, 0, -4), anim="arm"),
        part("arm_r", (7, -6, 0), [
            box(-1, 0, -2, 3, 22, 3, "#7a6349", "cloth"),
        ], parent="body", rot=(0, 0, 4), anim="arm"),
        part("leg_l", (-3, 16, 0), [
            box(-2, 0, -2, 3, 8, 3, "#4f3f2f", "cloth"),
        ], parent="body", anim="leg"),
        part("leg_r", (3, 16, 0), [
            box(-1, 0, -2, 3, 8, 3, "#4f3f2f", "cloth"),
        ], parent="body", anim="leg"),
    ],
}

# ---------------------------------------------------------------- 26. Tornado
MOBS["tornado"] = {
    "class": "TornadoModel", "shadow": 0.0, "scale": 2.04, "height": 12.0,
    "parts": [
        part("body", (0, -60, 0), [
            box(-26, -10, -26, 52, 20, 52, "#9aa6b2", "storm", face="vortex", glow=True),
            box(-18, 10, -18, 36, 25, 36, "#8b98a5", "storm", face="vortex", glow=True),
            box(-11, 35, -11, 22, 25, 22, "#7d8996", "storm", face="vortex", glow=True),
            box(-6, 60, -6, 12, 24, 12, "#6f7b88", "storm", face="vortex", glow=True),
        ], anim="rotor"),
    ],
}

MOB_ORDER = list(MOBS.keys())
