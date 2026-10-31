MOBS = {}


def up(blocks):
    """Y coordinate (model units) for a height above the ground, in blocks."""
    return GROUND - blocks * 16.0


# ---------------------------------------------------------------- 1. Tripod
MOBS["tripod"] = {
    "class": "TripodModel", "shadow": 2.2, "height": 6.4,
    "parts": [
        part("body", (0, up(3.4), 0), [
            blk(3.4, -11, 4.35, -11, 22, 1.25, 22, "#5b6470", "metal", face="panel"),
            blk(3.4, -13, 3.1, -8, 26, 0.4, 16, "#464e58", "metal"),
            blk(3.4, -7, 2.8, -7, 14, 0.55, 14, "#3b424b", "metal", face="vent"),
            blk(3.4, -15, 3.6, -3, 30, 0.25, 6, "#6d7683", "metal"),
            # shoulder armour + core
            blk(3.4, -13, 4.2, -6, 4, 0.7, 12, "#525b66", "metal", face="armor"),
            blk(3.4, 9, 4.2, -6, 4, 0.7, 12, "#525b66", "metal", face="armor"),
            blk(3.4, -3, 3.7, -12, 6, 0.4, 2, "#8ef7c8", "lens", glow=True),
            # dorsal vents and cables
            *ridge(-9, 0, -9, 18, 3, 2, 6, "#4b535d", "metal", axis="x"),
            *bolts(-10, -1, -10, 20, 4, 2, "#7b8693", "metal"),
            *bolts(-10, 14, -10, 20, 4, 2, "#7b8693", "metal"),
            *hose(-12, 2, -10, 10, 2, "#2f343b", "metal", axis="y", segments=4, sag=2),
            blk(3.4, -5, 5.3, -5, 10, 1.0, 10, "#4b535d", "metal"),
            blk(3.4, -6, 5.3, -6, 12, 0.25, 12, "#5b6470", "metal"),
        ], anim="bob"),
        part("head", (0, up(4.9), 0), [
            blk(4.9, -8, 5.9, -9, 16, 0.75, 17, "#6f7a86", "metal", face="panel"),
            blk(4.9, -5, 5.55, -12, 10, 0.45, 4, "#232a31", "metal", face="visor"),
            blk(4.9, -2, 5.05, -12, 4, 0.25, 3, "#8ef7c8", "lens", glow=True),
            blk(4.9, -9, 5.7, -6, 2, 0.5, 10, "#5b6673", "metal"),
            blk(4.9, 7, 5.7, -6, 2, 0.5, 10, "#5b6673", "metal"),
            # radar dish + antennae
            blk(4.9, -4, 6.4, 2, 8, 0.2, 6, "#7b8693", "metal", face="radar"),
            blk(4.9, -1, 6.6, 3, 2, 0.8, 2, "#3b424b", "metal"),
            blk(4.9, 4, 6.6, -7, 1, 1.1, 1, "#4b535d", "metal"),
            blk(4.9, -5, 6.6, -7, 1, 1.1, 1, "#4b535d", "metal"),
            *teeth_row(-4, 8, -12, 8, 3, 2, 4, "#98a3af", "metal"),
        ], parent="body", anim="head"),
        part("eye", (0, up(5.1), -13), [
            blk(5.1, -4, 5.6, -1, 8, 0.35, 2, "#ffe98a", "lens", glow=True),
            blk(5.1, -2, 5.62, -2, 4, 0.2, 1, "#8a6a20", "lens"),
        ], parent="head", anim="eye"),
        *leg("leg_a", -9, up(3.0), 9, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_b", 9, up(3.0), 9, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_c", 0, up(3.0), -11, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        part("arm_l", (-13, up(3.2), -2), [
            blk(3.2, -2, 3.2, -2, 4, 0.85, 4, "#5b6470", "metal"),
            blk(3.2, -3, 2.45, -3, 5, 0.8, 5, "#4b535d", "metal"),
            blk(3.2, -3, 2.3, -4, 6, 0.3, 6, "#2f343b", "metal", face="claw"),
            *ridge(-3, 12, -4, 6, 2, 2, 3, "#7b8693", "metal", axis="x"),
        ], parent="body", rot=(0, 0, 6), anim="arm"),
        part("arm_r", (13, up(3.2), -2), [
            blk(3.2, -2, 3.2, -2, 4, 0.85, 4, "#5b6470", "metal"),
            blk(3.2, -2, 2.45, -3, 5, 0.8, 5, "#4b535d", "metal"),
            blk(3.2, -3, 2.3, -4, 6, 0.3, 6, "#2f343b", "metal", face="claw"),
            *ridge(-3, 12, -4, 6, 2, 2, 3, "#7b8693", "metal", axis="x"),
        ], parent="body", rot=(0, 0, -6), anim="arm"),
    ],
}

# ---------------------------------------------------------------- 2. Woodcrawler
MOBS["woodcrawler"] = {
    "class": "WoodcrawlerModel", "shadow": 0.9, "height": 2.0,
    "parts": [
        part("body", (0, up(1.75), 0), [
            box(-6, -5, -5, 12, 6, 10, "#6b4f33", "chitin", face="plates"),
            box(-5, 1, -4, 10, 6, 8, "#5a4128", "chitin", face="plates"),
            box(-4, 7, -3, 8, 6, 6, "#4a3520", "chitin", face="plates"),
            box(-3, 13, -2, 6, 5, 4, "#3c2b1a", "chitin", face="plates"),
            box(-7, 2, -1, 2, 4, 2, "#8a6a45", "bone"),
            box(5, 2, -1, 2, 4, 2, "#8a6a45", "bone"),
            box(-6, 8, -1, 2, 3, 2, "#8a6a45", "bone"),
            box(4, 8, -1, 2, 3, 2, "#8a6a45", "bone"),
        ], anim="bob"),
        part("head", (0, -15, -2), [
            box(-6, -5, -5, 12, 8, 10, "#7a5c3c", "chitin", face="skull"),
            box(-5, 2, -4, 10, 3, 8, "#33261a", "chitin", face="jaw"),
            box(-4, 4, -5, 3, 4, 2, "#8a6a45", "bone"),
            box(1, 4, -5, 3, 4, 2, "#8a6a45", "bone"),
        ], parent="body", anim="head"),
        part("eye_l", (-3, -17, -8), [
            box(-2, -2, -1, 4, 4, 2, "#c9ff8a", "lens", glow=True),
        ], parent="head", anim="eye"),
        part("eye_r", (3, -17, -8), [
            box(-2, -2, -1, 4, 4, 2, "#c9ff8a", "lens", glow=True),
        ], parent="head", anim="eye"),
        part("palp_l", (-3, -13, -7), [
            box(-1, 0, -1, 2, 6, 2, "#6b4f33", "chitin"),
        ], parent="head", rot=(28, 0, 14)),
        part("palp_r", (3, -13, -7), [
            box(-1, 0, -1, 2, 6, 2, "#6b4f33", "chitin"),
        ], parent="head", rot=(28, 0, -14)),
        *spider_legs("leg", -4, 8, 6, 20, 26, 4, "#6b4f33", "#3f2d1c", "chitin", knee_lift=4),
    ],
}

# ---------------------------------------------------------------- 3. Bloop
MOBS["bloop"] = {
    "class": "BloopModel", "shadow": 3.4, "height": 4.2,
    "parts": [
        part("body", (0, up(2.4), 0), [
            blk(2.4, -20, 3.4, -20, 40, 0.9, 40, "#12303f", "wet"),
            blk(2.4, -22, 2.9, -18, 44, 0.5, 36, "#0e2733", "wet"),
            blk(2.4, -17, 2.2, -17, 34, 0.7, 34, "#143a4c", "wet"),
            blk(2.4, -14, 1.6, -14, 28, 0.6, 28, "#173f52", "wet"),
            # dorsal fin ridge
            *ridge(-12, 4, -8, 24, 5, 3, 5, "#1d4c61", "wet", axis="x"),
            *bolts(-18, 0, -18, 36, 5, 2, "#1a4457", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.3), -12), [
            blk(3.3, -12, 3.9, -8, 24, 0.6, 16, "#1a4457", "wet", face="maw"),
            blk(3.3, -10, 2.9, -9, 20, 0.5, 15, "#0a1c24", "wet", face="teeth"),
            *teeth_row(-9, 0, -9, 18, 4, 2, 6, "#e8e2cf", "bone"),
            *teeth_row(-9, 10, -9, 18, 4, 2, 5, "#e8e2cf", "bone", upper=False),
            # tentacle "beard"
            *ridge(-10, 12, -8, 20, 6, 2, 5, "#12303f", "wet", axis="x"),
        ], parent="body", anim="head"),
        part("eye", (0, up(3.55), -20), [
            blk(3.55, -6, 3.85, -1, 12, 0.3, 2, "#2fd6c9", "lens", glow=True),
            blk(3.55, -3, 3.9, -2, 6, 0.2, 1, "#06131a", "lens"),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-14 + i * 7, up(1.9), -4 + (i % 3) * 5), [
            blk(1.9, -3, 1.9, -3, 6, 1.6, 6, "#12303f", "wet", face="suckers"),
            blk(1.9, -2, 0.45, -2, 4, 1.4, 4, "#1a4457", "wet"),
            *ridge(-2, 18, -2, 4, 2, 2, 2, "#0e2733", "wet", axis="x"),
        ], parent="body", rot=(0, 0, -10 + i * 5), anim="tentacle") for i in range(5)],
    ],
}

# ---------------------------------------------------------------- 4. Alive House
MOBS["alive_house"] = {
    "class": "AliveHouseModel", "shadow": 1.8, "height": 4.5,
    "parts": [
        part("body", (0, up(2.6), 0), [
            box(-20, -22, -18, 40, 34, 36, "#8a7358", "planks", face="door"),
            box(-21, -2, -19, 42, 4, 38, "#6f5a44", "wood"),
            box(-22, 12, -20, 44, 6, 40, "#5d4a38", "wood"),
        ], anim="bob"),
        part("head", (0, up(4.1), 0), [
            box(-24, -10, -20, 48, 14, 40, "#7a4632", "planks", face="window"),
            box(-16, -18, -14, 32, 9, 28, "#6b3d2b", "planks"),
            box(6, -30, 6, 7, 14, 7, "#7d7a72", "metal"),
        ], parent="body", anim="head"),
        part("eye_l", (-9, 2, -18), [
            box(-3, -3, -1, 6, 6, 2, "#ffd166", "lens", glow=True),
        ], parent="body", anim="eye"),
        part("eye_r", (9, 2, -18), [
            box(-3, -3, -1, 6, 6, 2, "#ffd166", "lens", glow=True),
        ], parent="body", anim="eye"),
        *leg("leg_a", -14, up(1.0), -10, 14, 10, 6, "#6f5a44", "#4a3a2b", "wood"),
        *leg("leg_b", 14, up(1.0), -10, 14, 10, 6, "#6f5a44", "#4a3a2b", "wood"),
        *leg("leg_c", -14, up(1.0), 12, 14, 10, 6, "#6f5a44", "#4a3a2b", "wood"),
        *leg("leg_d", 14, up(1.0), 12, 14, 10, 6, "#6f5a44", "#4a3a2b", "wood"),
    ],
}

# ---------------------------------------------------------------- 5. Giant Spider
MOBS["giant_spider"] = {
    "class": "GiantSpiderModel", "shadow": 1.8, "height": 2.2,
    "parts": [
        part("body", (0, up(1.2), 6), [
            box(-11, -9, -12, 22, 18, 26, "#3b2f22", "chitin", face="chest"),
            box(-9, -12, -10, 18, 5, 20, "#2c2318", "chitin"),
        ], anim="bob"),
        part("head", (0, up(1.35), -8), [
            box(-9, -8, -9, 18, 14, 14, "#4a3a2a", "chitin", face="spider"),
            box(-6, 4, -10, 4, 4, 3, "#c9bc9a", "bone"),
            box(2, 4, -10, 4, 4, 3, "#c9bc9a", "bone"),
        ], parent="body", anim="head"),
        *spider_legs("leg", -7, 9, 6, 22, 26, 4, "#4a3a2a", "#2c2318", "chitin", knee_lift=7),
    ],
}

# ---------------------------------------------------------------- 6. Gardener
MOBS["gardener"] = {
    "class": "GardenerModel", "shadow": 1.2, "height": 3.2,
    "parts": [
        part("body", (0, up(1.5), 0), [
            blk(1.5, -7, 2.15, -5, 14, 1.25, 10, "#2a2622", "cloth", face="robe"),
            blk(1.5, -9, 1.2, -6, 18, 0.4, 12, "#221e1b", "cloth"),
            blk(1.5, -8, 0.85, -6, 16, 0.4, 12, "#1d1a18", "cloth"),
            blk(1.5, -6, 0.5, -5, 12, 0.4, 10, "#191613", "cloth", face="robe"),
            # robe folds
            *ridge(-7, 0, -5, 14, 3, 2, 5, "#26221e", "cloth", axis="x", taper=False),
            *ridge(-6, 8, -4, 12, 3, 2, 4, "#211d1a", "cloth", axis="x", taper=False),
            # belt with shears
            blk(1.5, -8, 1.25, -6, 16, 0.16, 12, "#3a332c", "cloth"),
            blk(1.5, 4, 1.2, -7, 3, 0.28, 2, "#8f8b80", "metal"),
            blk(1.5, 4, 1.0, -8, 2, 0.22, 3, "#a8a49a", "bone"),
        ], anim="bob"),
        part("head", (0, up(2.35), 0), [
            blk(2.35, -6, 2.72, -6, 12, 0.55, 12, "#14120f", "cloth", face="hood"),
            blk(2.35, -7, 2.34, -7, 14, 0.32, 14, "#100e0c", "cloth"),
            blk(2.35, -5, 2.2, -8, 10, 0.2, 3, "#0b0a09", "cloth"),
            *bolts(-4, 4, -6, 8, 3, 1, "#2f2b26", "cloth"),
        ], parent="body", anim="head"),
        part("orb", (0, up(2.95), 0), [
            blk(2.95, -4, 3.14, -4, 8, 0.3, 8, "#fff39a", "lens", glow=True),
            blk(2.95, -3, 3.15, -3, 6, 0.24, 6, "#ffe14d", "lens", glow=True),
            blk(2.95, -5, 3.17, -5, 10, 0.08, 10, "#3a342b", "metal"),
            blk(2.95, -1, 3.06, -1, 2, 0.22, 2, "#8f8b80", "metal"),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-5 + (i % 2) * 10, up(1.3), -3 + (i // 2) * 4), [
            blk(1.3, -1, 1.3, -1, 3, 0.6, 3, "#26221e", "cloth"),
            blk(1.3, -1, 0.75, -1, 2, 0.55, 2, "#1d1a17", "cloth"),
            *toes(-1, 3, 0, 2, 3, 2, 3, "#3a332c", "bone"),
        ], parent="body", rot=(0, 0, -14 if i % 2 else 14), anim="tentacle") for i in range(4)],
        *leg("leg_l", -4, up(0.55), 0, 9, 6, 3, "#201d1a", "#151311", "cloth", anim="leg"),
        *leg("leg_r", 4, up(0.55), 0, 9, 6, 3, "#201d1a", "#151311", "cloth", anim="leg"),
    ],
}

# ---------------------------------------------------------------- 7. Sand Worm
MOBS["sand_worm"] = {
    "class": "SandWormModel", "shadow": 2.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.0), 0), [
            # five tapering segments, each with its own rim
            blk(1.0, -11, 1.9, -11, 22, 0.42, 22, "#c8b07a", "sand", face="segments"),
            blk(1.0, -10, 1.9, -10, 20, 0.1, 20, "#d8c28e", "sand"),
            blk(1.0, -12, 1.5, -12, 24, 0.42, 24, "#bda36e", "sand", face="segments"),
            blk(1.0, -13, 1.1, -13, 26, 0.42, 26, "#b09460", "sand", face="segments"),
            blk(1.0, -12, 0.72, -12, 24, 0.4, 24, "#a08753", "sand"),
            blk(1.0, -10, 0.34, -10, 20, 0.38, 20, "#8f7745", "sand"),
            *ridge(-10, 0, -8, 18, 3, 2, 5, "#e0cba0", "bone", axis="x"),
            *ridge(-9, 6, -8, 16, 2, 2, 4, "#e0cba0", "bone", axis="x"),
            *bolts(-11, 0, -11, 20, 4, 2, "#dcc69a", "bone"),
        ], anim="bob"),
        part("head", (0, up(1.9), 0), [
            blk(1.9, -9, 2.2, -9, 18, 0.34, 18, "#cbb27c", "sand", face="maw"),
            blk(1.9, -8, 2.2, -8, 16, 0.12, 16, "#dfc99a", "sand"),
            blk(1.9, -7, 1.98, -8, 14, 0.28, 12, "#7d5236", "flesh", face="teeth"),
            blk(1.9, -5, 1.9, -10, 10, 0.2, 3, "#4a2a1c", "flesh"),
            *teeth_row(-8, -4, -10, 16, 4, 3, 7, "#efe3c4", "bone"),
            *teeth_row(-8, 4, -10, 16, 4, 3, 6, "#efe3c4", "bone", upper=False),
            # mandibles
            blk(1.9, -11, 2.05, -12, 3, 0.24, 8, "#b09462", "bone"),
            blk(1.9, 8, 2.05, -12, 3, 0.24, 8, "#b09462", "bone"),
            *bolts(-7, -2, -9, 14, 5, 1, "#f0e2c2", "bone"),
        ], parent="body", anim="head"),
        part("jaw", (0, up(1.05), 0), [
            blk(1.05, -7, 1.05, -9, 14, 0.3, 10, "#a8804f", "flesh", face="teeth"),
            *teeth_row(-6, 0, -9, 12, 3, 2, 5, "#e9dcc0", "bone", upper=False),
        ], parent="head", anim="jaw"),
        *[part("fin_%d" % i, (-9 + i * 6, up(1.25), 4), [
            blk(1.25, -1, 1.5, -1, 2, 0.3, 6, "#e0cba0", "bone"),
        ], parent="body", rot=(0, 0, -34 + i * 22), anim="tentacle") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 8. UFO
MOBS["ufo"] = {
    "class": "UfoModel", "shadow": 1.4, "height": 2.0,
    "parts": [
        part("body", (0, up(0.9), 0), [
            # three stacked saucer rims
            blk(0.9, -24, 0.92, -24, 48, 0.22, 48, "#6b747b", "metal", face="lights"),
            blk(0.9, -19, 1.06, -19, 38, 0.2, 38, "#7d878f", "metal"),
            blk(0.9, -13, 1.2, -13, 26, 0.22, 26, "#8f99a1", "metal", face="panel"),
            blk(0.9, -8, 0.82, -8, 16, 0.3, 16, "#525a60", "metal"),
            # underside dome and hatch
            blk(0.9, -6, 0.62, -6, 12, 0.26, 12, "#464e54", "metal"),
            blk(0.9, -4, 0.5, -4, 8, 0.16, 8, "#8ef7c8", "lens", glow=True),
            # rim lamps
            *[blk(0.9, -2, 0.98, z, 4, 0.14, 3, "#8ef7c8", "lens", glow=True)
              for z in (-22, -11, 11, 22)],
            *[blk(0.9, x, 0.98, -2, 3, 0.14, 4, "#8ef7c8", "lens", glow=True)
              for x in (-22, -11, 11, 22)],
            *ridge(-20, 0, -20, 40, 3, 2, 7, "#5b656c", "metal", axis="x"),
        ], anim="bob"),
        part("head", (0, up(1.35), 0), [
            blk(1.35, -9, 1.5, -9, 18, 0.22, 18, "#9aa4ac", "metal"),
            blk(1.35, -6, 1.66, -6, 12, 0.24, 12, "#b6c0c7", "metal", face="dome"),
            blk(1.35, -4, 1.78, -4, 8, 0.16, 8, "#8ef7c8", "lens", glow=True),
            blk(1.35, -1, 2.0, -1, 2, 0.24, 2, "#6b747b", "metal"),
        ], parent="body", anim="head"),
        *[part("strut_%d" % i, (0, up(0.55), 0), [
            blk(0.55, -8, 0.6, -1 + i * 0, 2, 0.5, 2, "#4b535a", "metal"),
        ], parent="body", rot=(0, 120 * i, 0), anim="leg") for i in range(3)],
        part("beam", (0, up(0.35), 0), [
            blk(0.35, -10, 0.34, -10, 20, 0.1, 20, "#9be3ff", "lens", glow=True),
        ], parent="body", anim="eye"),
    ],
}

# ---------------------------------------------------------------- 9. Bear
MOBS["bear"] = {
    "class": "BearModel", "shadow": 1.0, "height": 1.8,
    "parts": [
        part("body", (0, up(0.95), 0), [
            blk(0.95, -9, 1.35, -14, 18, 1.0, 28, "#503a26", "fur"),
            blk(0.95, -10, 1.15, -12, 20, 0.55, 24, "#5d442d", "fur"),
            blk(0.95, -7, 0.85, 8, 14, 0.3, 8, "#3f2c1e", "fur"),
            # shoulder hump
            blk(0.95, -7, 1.62, -9, 14, 0.3, 10, "#5a4129", "fur"),
            *ridge(-8, 0, -12, 24, 3, 2, 7, "#463222", "fur", axis="x"),
            *ridge(-6, 8, -8, 20, 2, 2, 5, "#5a4129", "fur", axis="x"),
            # tail
            blk(0.95, -2, 1.0, 14, 4, 0.25, 3, "#3f2c1e", "fur"),
        ], anim="bob"),
        part("head", (0, up(1.25), -15), [
            blk(1.25, -7, 1.5, -7, 14, 0.8, 13, "#573f29", "fur", face="bear"),
            blk(1.25, -3, 1.3, -10, 6, 0.32, 4, "#b09a7c", "fur", face="snout"),
            blk(1.25, -2, 1.26, -11, 4, 0.16, 2, "#241a12", "fur"),
            blk(1.25, -9, 1.55, -3, 4, 0.3, 5, "#4a3421", "fur"),
            blk(1.25, 5, 1.55, -3, 4, 0.3, 5, "#4a3421", "fur"),
            blk(1.25, -8, 1.42, -2, 3, 0.2, 3, "#6b5138", "fur"),
            blk(1.25, 5, 1.42, -2, 3, 0.2, 3, "#6b5138", "fur"),
            # teeth + eyes
            *teeth_row(-2, 4, -11, 4, 2, 2, 3, "#f0ead8", "bone"),
            blk(1.25, -5, 1.44, -8, 2, 0.08, 1, "#1a120c", "lens"),
            blk(1.25, 3, 1.44, -8, 2, 0.08, 1, "#1a120c", "lens"),
        ], parent="body", anim="head"),
        *leg("leg_0", -7, up(0.8), -9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_1", 7, up(0.8), -9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_2", -7, up(0.8), 9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_3", 7, up(0.8), 9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
    ],
}

# ---------------------------------------------------------------- 10. Kraken
MOBS["kraken"] = {
    "class": "KrakenModel", "shadow": 2.6, "height": 4.2,
    "parts": [
        part("body", (0, up(2.6), 4), [
            blk(2.6, -16, 3.4, -16, 32, 1.75, 30, "#2a1a3a", "wet"),
            blk(2.6, -18, 2.4, -14, 36, 0.75, 26, "#22152f", "wet"),
            blk(2.6, -13, 1.7, -12, 26, 0.6, 22, "#322049", "wet"),
            # fins and barnacles
            *ridge(-14, 6, -12, 28, 4, 3, 5, "#3a2454", "wet", axis="x"),
            *bolts(-15, 20, -15, 30, 4, 2, "#4a3266", "wet"),
            blk(2.6, -17, 2.9, -2, 3, 0.4, 10, "#4a3266", "wet"),
            blk(2.6, 14, 2.9, -2, 3, 0.4, 10, "#4a3266", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.0), -12), [
            blk(3.0, -14, 3.9, -12, 28, 1.5, 22, "#35244a", "wet", face="maw"),
            blk(3.0, -11, 2.6, -11, 22, 0.5, 18, "#1d1230", "wet", face="teeth"),
            blk(3.0, -6, 4.1, -6, 12, 0.25, 12, "#4a3266", "wet"),
            *teeth_row(-10, 8, -12, 20, 5, 2, 6, "#eee7d2", "bone"),
            *teeth_row(-10, 12, -12, 20, 5, 2, 5, "#eee7d2", "bone", upper=False),
            *ridge(-11, 14, -11, 22, 4, 2, 5, "#2a1a3a", "wet", axis="x"),
        ], parent="body", anim="head"),
        part("eye_l", (-7, up(3.6), -23), [
            blk(3.6, -4, 3.95, -1, 8, 0.3, 2, "#f2d15a", "lens", glow=True),
            blk(3.6, -1, 3.97, -2, 2, 0.2, 1, "#4a3a10", "lens"),
        ], parent="body", anim="eye"),
        part("eye_r", (7, up(3.6), -23), [
            blk(3.6, -4, 3.95, -1, 8, 0.3, 2, "#f2d15a", "lens", glow=True),
            blk(3.6, -1, 3.97, -2, 2, 0.2, 1, "#4a3a10", "lens"),
        ], parent="body", anim="eye"),
        *[part("tentacle_%d" % i, (-12 + i * 4, up(1.4), -6 + (i // 3) * 12), [
            blk(1.4, -2, 1.4, -2, 5, 1.25, 5, "#2a1a3a", "wet", face="suckers"),
            blk(1.4, -2, 0.35, -2, 4, 1.05, 4, "#35244a", "wet"),
            blk(1.4, -3, 0.1, -3, 6, 0.3, 6, "#4a3266", "wet"),
            *ridge(-2, 1, 4, 2, 2, 2, 2, "#1d1230", "wet", axis="y"),
        ], parent="body", rot=(0, 0, -18 + i * 6), anim="tentacle") for i in range(7)],
    ],
}

# ---------------------------------------------------------------- 11. Evil Watermelon
MOBS["evil_watermelon"] = {
    "class": "EvilWatermelonModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.6), 0), [
            box(-7, -7, -7, 14, 13, 14, "#2f5c1f", "melon", face="melon"),
            box(-6, 4, -6, 12, 4, 12, "#27491a", "melon"),
            box(-2, -11, -2, 4, 5, 4, "#4a6b2a", "leaves"),
        ], anim="bob"),
        part("head", (0, up(0.55), -7), [
            box(-6, -5, -1, 12, 10, 3, "#2f5c1f", "melon", face="scream"),
            box(-4, 0, -2, 3, 3, 1, "#d43a3a", "lens", glow=True),
            box(1, 0, -2, 3, 3, 1, "#d43a3a", "lens", glow=True),
        ], parent="body", anim="head"),
        *leg("leg_0", -5, up(0.35), -4, 6, 5, 2, "#26431a", "#1b3013", "bark"),
        *leg("leg_1", 5, up(0.35), -4, 6, 5, 2, "#26431a", "#1b3013", "bark"),
        *leg("leg_2", -5, up(0.35), 4, 6, 5, 2, "#26431a", "#1b3013", "bark"),
        *leg("leg_3", 5, up(0.35), 4, 6, 5, 2, "#26431a", "#1b3013", "bark"),
    ],
}

# ---------------------------------------------------------------- 12. Alive Tree
MOBS["alive_tree"] = {
    "class": "AliveTreeModel", "shadow": 1.6, "height": 4.6,
    "parts": [
        part("body", (0, up(1.8), 0), [
            box(-7, -14, -7, 14, 30, 14, "#5f4527", "bark", face="bark"),
            box(-10, 6, -10, 20, 6, 20, "#4b361d", "bark"),
            box(-5, -18, -5, 10, 6, 10, "#3d2b16", "bark"),
        ], anim="bob"),
        part("head", (0, up(3.5), 0), [
            box(-16, -10, -16, 32, 14, 32, "#3f7a2e", "leaves", face="leaves"),
            box(-12, -18, -12, 24, 8, 24, "#4a8c36", "leaves"),
            box(-3, 2, -8, 6, 6, 3, "#1b2a12", "bark", face="skull"),
        ], parent="body", anim="head"),
        *leg("leg_0", -5, up(0.7), -5, 11, 8, 4, "#4b361d", "#33240f", "bark"),
        *leg("leg_1", 5, up(0.7), -5, 11, 8, 4, "#4b361d", "#33240f", "bark"),
        *leg("leg_2", -5, up(0.7), 5, 11, 8, 4, "#4b361d", "#33240f", "bark"),
        *leg("leg_3", 5, up(0.7), 5, 11, 8, 4, "#4b361d", "#33240f", "bark"),
    ],
}

# ---------------------------------------------------------------- 13. Woodcock
MOBS["woodcock"] = {
    "class": "WoodcockModel", "shadow": 0.3, "height": 0.9,
    "parts": [
        part("body", (0, up(0.34), 1), [
            blk(0.34, -5, 0.5, -7, 10, 0.16, 7, "#6b5335", "feather"),
            blk(0.34, -4, 0.42, -6, 8, 0.18, 9, "#7b6140", "feather"),
            # chest bars (woodcock-ish banding)
            blk(0.34, -4, 0.34, -4, 8, 0.1, 3, "#5a4529", "feather"),
            blk(0.34, -3, 0.32, 1, 6, 0.1, 3, "#8a6f49", "feather"),
            # tail fan
            *ridge(-4, 0, 3, 8, 3, 3, 4, "#4b3823", "feather", axis="x"),
        ], anim="bob"),
        part("head", (0, up(0.62), -5), [
            blk(0.62, -3, 0.74, -4, 6, 0.18, 7, "#7b6140", "feather", face="bird"),
            blk(0.62, -2, 0.8, -5, 4, 0.1, 4, "#8f7350", "feather"),
            # long woodcock beak
            blk(0.62, -1, 0.66, -13, 2, 0.1, 10, "#c8a86a", "bone"),
            blk(0.62, -1, 0.62, -13, 2, 0.05, 9, "#a08050", "bone"),
            *bolts(-3, 0, -5, 5, 2, 1, "#8f7350", "feather"),
            # eyes
            blk(0.62, -4, 0.76, -5, 1, 0.08, 1, "#1a1510", "lens"),
            blk(0.62, 3, 0.76, -5, 1, 0.08, 1, "#1a1510", "lens"),
        ], parent="body", anim="head"),
        part("wing_l", (-5, up(0.42), 0), [
            blk(0.42, -4, 0.5, -6, 4, 0.14, 12, "#5d472d", "feather", face="feather"),
            blk(0.42, -3, 0.44, -5, 3, 0.1, 10, "#4b3823", "feather"),
            *ridge(-3, 0, -5, 10, 2, 2, 4, "#6b5335", "feather", axis="z"),
        ], parent="body", anim="wing"),
        part("wing_r", (3, up(0.42), 0), [
            blk(0.42, 0, 0.5, -6, 4, 0.14, 12, "#5d472d", "feather", face="feather"),
            blk(0.42, 1, 0.44, -5, 3, 0.1, 10, "#4b3823", "feather"),
            *ridge(1, 0, -5, 10, 2, 2, 4, "#6b5335", "feather", axis="z"),
        ], parent="body", anim="wing"),
        *[part("leg_%d" % i, (-2 + i * 4, up(0.24), 0), [
            blk(0.24, -1, 0.24, -1, 2, 0.18, 2, "#b08c56", "bone"),
            *toes(-1, 3, 1, 2, 4, 2, 3, "#c09a62", "bone"),
        ], parent="body", anim="leg") for i in range(2)],
    ],
}

# ---------------------------------------------------------------- 14. Lights
MOBS["lights"] = {
    "class": "LightsModel", "shadow": 0.5, "height": 1.0,
    "parts": [
        part("body", (0, up(0.42), 0), [
            box(-6, -5, -6, 12, 10, 11, "#7f858b", "skin", face="scales"),
            box(-7, 2, -5, 14, 4, 10, "#686d73", "skin"),
            box(-5, 5, -5, 10, 3, 10, "#5c6166", "skin"),
        ], anim="bob"),
        part("head", (0, up(0.6), -1), [
            box(-4, -5, -5, 8, 9, 7, "#9aa0a6", "skin", face="scales"),
            box(-5, -6, -5, 10, 2, 8, "#82888e", "skin"),
        ], parent="body", anim="head"),
        part("eye", (0, up(0.6), -6), [
            box(-4, -4, -2, 8, 8, 3, "#f7fbff", "lens", glow=True),
            box(-2, -2, -3, 4, 4, 1, "#1b262e", "lens"),
        ], parent="head", anim="eye"),
        *leg("leg_0", -3, up(0.2), -3, 5, 4, 3, "#7d8288", "#5c6166", "skin", claw=False),
        *leg("leg_1", 3, up(0.2), -3, 5, 4, 3, "#7d8288", "#5c6166", "skin", claw=False),
        *leg("leg_2", -3, up(0.2), 3, 5, 4, 3, "#7d8288", "#5c6166", "skin", claw=False),
        *leg("leg_3", 3, up(0.2), 3, 5, 4, 3, "#7d8288", "#5c6166", "skin", claw=False),
    ],
}

# ---------------------------------------------------------------- 15. Chest Mimic
MOBS["chest_mimic"] = {
    "class": "ChestMimicModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.45), 0), [
            blk(0.45, -7, 0.62, -5, 14, 0.5, 10, "#8a6234", "planks", face="chest"),
            blk(0.45, -7, 0.64, -5, 14, 0.1, 10, "#6b4a26", "wood"),
            blk(0.45, -8, 0.55, -6, 16, 0.18, 12, "#5a3d1f", "wood"),
            # iron bands and rivets
            blk(0.45, -7, 0.66, -5, 2, 0.52, 10, "#4a4a4e", "metal"),
            blk(0.45, 5, 0.66, -5, 2, 0.52, 10, "#4a4a4e", "metal"),
            blk(0.45, -1, 0.68, -6, 3, 0.44, 2, "#5a5a60", "metal", face="lock"),
            *bolts(-6, 3, -6, 12, 4, 1, "#7a7a80", "metal"),
        ], anim="bob"),
        part("head", (0, up(0.85), 2), [
            blk(0.85, -8, 0.98, -6, 16, 0.22, 12, "#966c3a", "planks", face="lid"),
            blk(0.85, -6, 1.0, -5, 12, 0.1, 10, "#a87c44", "wood"),
            blk(0.85, -7, 1.0, -5, 2, 0.2, 10, "#4a4a4e", "metal"),
            blk(0.85, 5, 1.0, -5, 2, 0.2, 10, "#4a4a4e", "metal"),
        ], parent="body", anim="jaw"),
        part("jaw", (0, up(0.5), -6), [
            blk(0.5, -6, 0.5, -3, 12, 0.28, 4, "#2b1a10", "flesh"),
            *teeth_row(-5, -1, -3, 10, 3, 2, 5, "#f5f3ec", "bone"),
            *teeth_row(-5, 4, -3, 10, 3, 2, 4, "#f5f3ec", "bone", upper=False),
            blk(0.5, -3, 0.32, -4, 6, 0.12, 3, "#a83a3a", "flesh"),
        ], parent="body", anim="jaw"),
        *leg("leg_0", -5, up(0.3), -3, 6, 4, 2, "#6b4a26", "#4a3219", "wood"),
        *leg("leg_1", 5, up(0.3), -3, 6, 4, 2, "#6b4a26", "#4a3219", "wood"),
        *leg("leg_2", -5, up(0.3), 3, 6, 4, 2, "#6b4a26", "#4a3219", "wood"),
        *leg("leg_3", 5, up(0.3), 3, 6, 4, 2, "#6b4a26", "#4a3219", "wood"),
    ],
}

# ---------------------------------------------------------------- 16. Water Grabber
MOBS["water_grabber"] = {
    "class": "WaterGrabberModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(0.85), 0), [
            box(-11, -7, -11, 22, 14, 22, "#8c2f45", "wet"),
            box(-9, -9, -9, 18, 3, 18, "#a8405a", "wet"),
            box(-9, 7, -9, 18, 4, 18, "#6f2437", "wet"),
            box(-13, -3, -4, 2, 7, 8, "#b04b63", "wet"),
            box(11, -3, -4, 2, 7, 8, "#b04b63", "wet"),
        ], anim="bob"),
        part("head", (0, up(0.8), -12), [
            box(-8, -6, -2, 16, 12, 3, "#a8405a", "wet", face="star"),
            box(-5, -8, -3, 10, 3, 3, "#c2586f", "wet", face="trident"),
            box(-9, -2, 0, 18, 4, 2, "#6f2437", "wet"),
        ], parent="body", anim="head"),
        part("dome", (0, up(1.3), 0), [
            box(-8, -4, -8, 16, 4, 16, "#a8405a", "wet"),
            box(-5, -7, -5, 10, 3, 10, "#c2586f", "wet"),
        ], parent="body", anim="bob"),
        *[lp for i in range(6)
          for lp in leg("leg_%d" % i, -10 + 20 * (i // 3), up(0.18), -7 + 7 * (i % 3), 6, 4, 3,
                        "#8c2f45", "#6f2437", "wet", out=3)],
        part("claw_l", (-9, up(0.75), -5), [
            box(-2, 0, -2, 4, 13, 4, "#8c2f45", "wet", face="suckers"),
            box(-4, 11, -4, 8, 4, 8, "#a8405a", "wet"),
            box(-4, 14, -6, 3, 4, 5, "#c2586f", "bone"),
            box(1, 14, -6, 3, 4, 5, "#c2586f", "bone"),
        ], parent="body", rot=(18, 0, 52), anim="arm"),
        part("claw_r", (9, up(0.75), -5), [
            box(-2, 0, -2, 4, 13, 4, "#8c2f45", "wet", face="suckers"),
            box(-4, 11, -4, 8, 4, 8, "#a8405a", "wet"),
            box(-4, 14, -6, 3, 4, 5, "#c2586f", "bone"),
            box(1, 14, -6, 3, 4, 5, "#c2586f", "bone"),
        ], parent="body", rot=(18, 0, -52), anim="arm"),
    ],
}

# ---------------------------------------------------------------- 17. Tank
MOBS["tank"] = {
    "class": "TankModel", "shadow": 1.6, "height": 2.4,
    "parts": [
        part("body", (0, up(1.1), 0), [
            # hull
            blk(1.1, -13, 1.62, -19, 26, 0.5, 38, "#4c5445", "milmetal", face="armor"),
            blk(1.1, -11, 1.12, -18, 22, 0.46, 36, "#3c4337", "milmetal"),
            blk(1.1, -12, 1.86, -20, 24, 0.24, 7, "#565f4c", "milmetal", face="armor"),
            blk(1.1, -12, 1.5, 18, 24, 0.2, 5, "#3a4134", "milmetal"),
            # fenders over the tracks
            blk(1.1, -20, 1.02, -21, 7, 0.12, 42, "#454d3f", "milmetal"),
            blk(1.1, 13, 1.02, -21, 7, 0.12, 42, "#454d3f", "milmetal"),
            # tracks
            blk(1.1, -19, 0.92, -21, 6, 0.72, 42, "#2b3126", "milmetal", face="tracks"),
            blk(1.1, 13, 0.92, -21, 6, 0.72, 42, "#2b3126", "milmetal", face="tracks"),
            blk(1.1, -19, 1.0, -20, 6, 0.1, 40, "#333a2e", "milmetal", face="tracks"),
            blk(1.1, 13, 1.0, -20, 6, 0.1, 40, "#333a2e", "milmetal", face="tracks"),
            # road wheels
            *[blk(1.1, -18.5, 0.58, -16 + i * 8, 4, 0.42, 5, "#3a4134", "milmetal")
              for i in range(5)],
            *[blk(1.1, 14.5, 0.58, -16 + i * 8, 4, 0.42, 5, "#3a4134", "milmetal")
              for i in range(5)],
            # exhaust, stowage, headlights, bolts
            blk(1.1, -9, 1.75, 20, 4, 0.3, 5, "#2f3529", "metal"),
            blk(1.1, 5, 1.75, 20, 4, 0.3, 5, "#2f3529", "metal"),
            blk(1.1, 14.5, 1.4, 6, 5, 0.36, 9, "#3f4739", "milmetal", face="crate"),
            blk(1.1, -19.5, 1.4, 4, 5, 0.36, 9, "#3f4739", "milmetal", face="crate"),
            blk(1.1, -8, 1.45, -21, 3, 0.24, 2, "#e8e4c8", "lens", glow=True),
            blk(1.1, 5, 1.45, -21, 3, 0.24, 2, "#e8e4c8", "lens", glow=True),
            *bolts(-12, -2, -19, 24, 5, 2, "#5b6452", "milmetal"),
        ], anim="bob"),
        part("head", (0, up(1.9), -2), [
            # turret
            blk(1.9, -9, 2.16, -9, 18, 0.46, 18, "#525b4a", "milmetal", face="armor"),
            blk(1.9, -8, 2.26, -8, 16, 0.12, 16, "#5c6552", "milmetal", face="deck"),
            blk(1.9, -9.5, 1.96, -6, 19, 0.2, 12, "#454d3f", "milmetal"),
            # mantlet + gun
            blk(1.9, -4, 2.1, -12, 8, 0.42, 5, "#4b5343", "milmetal", face="armor"),
            blk(1.9, -2, 2.06, -30, 3, 0.2, 19, "#3c4337", "milmetal"),
            blk(1.9, -3, 2.16, -35, 6, 0.3, 6, "#333a2e", "milmetal", face="muzzle"),
            # cupola, hatch, MG
            blk(1.9, -4, 2.4, 2, 7, 0.2, 7, "#4f5847", "milmetal", face="deck"),
            blk(1.9, -3, 2.46, 3, 5, 0.1, 5, "#3c4337", "milmetal"),
            blk(1.9, 6, 2.5, -2, 1, 0.34, 1, "#2f3529", "metal"),
            blk(1.9, 6, 2.36, -4, 2, 0.14, 6, "#2f3529", "metal"),
            # smoke launchers
            *ridge(-8, -1, -6, 14, 3, 3, 3, "#3a4134", "milmetal", axis="x"),
            *ridge(4, -1, 8, 12, 3, 3, 2, "#3a4134", "milmetal", axis="x"),
        ], parent="body", anim="head"),
        *[part("wheel_%d" % i, (-19.5 + 39 * (i // 2), up(0.7), -16 + 16 * (i % 2)), [
            blk(0.7, -3, 1.02, -3, 6, 0.9, 6, "#26301f", "milmetal", face="tracks"),
        ], parent="body", rot=(0, 0, 0), anim="wheel") for i in range(2)],
    ],
}

# ---------------------------------------------------------------- 18. Siren Head
MOBS["siren_head"] = {
    "class": "SirenHeadModel", "shadow": 1.6, "height": 9.5,
    "parts": [
        part("body", (0, up(5.0), 0), [
            blk(5.0, -6, 6.7, -6, 12, 3.4, 12, "#8e8471", "skin", face="ribs"),
            blk(5.0, -8, 4.2, -8, 16, 0.3, 16, "#7d7462", "skin"),
            blk(5.0, -8, 3.2, -8, 16, 0.3, 16, "#7d7462", "skin"),
            blk(5.0, -7, 2.9, -7, 14, 0.4, 14, "#6f6757", "skin"),
            # rib bars
            *ridge(-6, 0, -6, 12, 3, 2, 4, "#9a917c", "bone", axis="x", taper=False),
            *ridge(-6, 6, -6, 12, 3, 2, 3, "#9a917c", "bone", axis="x", taper=False),
            # neck + cables
            blk(5.0, -3, 8.0, -3, 6, 1.3, 6, "#8e8471", "skin"),
            *hose(-4, 1, -2, 10, 2, "#4c4639", "metal", axis="y", segments=5, sag=1),
            *hose(2, 1, -2, 10, 2, "#4c4639", "metal", axis="y", segments=5, sag=-1),
        ], anim="bob"),
        part("head", (0, up(8.6), 0), [
            blk(8.6, -7, 9.4, -7, 14, 1.1, 14, "#8e8471", "skin", face="panel"),
            blk(8.6, -11, 9.2, -6, 4, 0.75, 12, "#6f6757", "metal", face="speaker"),
            blk(8.6, 7, 9.2, -6, 4, 0.75, 12, "#6f6757", "metal", face="speaker"),
            blk(8.6, -12, 9.1, -3, 1, 0.5, 6, "#565044", "metal"),
            blk(8.6, 11, 9.1, -3, 1, 0.5, 6, "#565044", "metal"),
            blk(8.6, -3, 9.55, -3, 6, 0.35, 6, "#5f5849", "metal"),
            blk(8.6, -2, 9.75, -2, 4, 0.2, 4, "#4c4639", "metal"),
            blk(8.6, -1, 9.9, -1, 2, 0.2, 2, "#d04a3a", "lens", glow=True),
            *bolts(-6, 4, -7, 12, 4, 1, "#6f6757", "metal"),
        ], parent="body", anim="head"),
        part("arm_l", (-6, up(6.4), 0), [
            blk(6.4, -2, 6.4, -2, 4, 1.6, 4, "#8e8471", "skin"),
            blk(6.4, -2, 4.9, -2, 5, 1.3, 5, "#7d7462", "skin"),
            blk(6.4, -2, 2.4, -2, 6, 0.4, 6, "#6f6757", "bone"),
            *ridge(-2, 20, -3, 5, 2, 2, 3, "#9a917c", "bone", axis="x"),
        ], parent="body", rot=(0, 0, 5), anim="arm"),
        part("arm_r", (6, up(6.4), 0), [
            blk(6.4, -2, 6.4, -2, 4, 1.6, 4, "#8e8471", "skin"),
            blk(6.4, -2, 4.9, -2, 5, 1.3, 5, "#7d7462", "skin"),
            blk(6.4, -2, 2.4, -2, 6, 0.4, 6, "#6f6757", "bone"),
            *ridge(-2, 20, -3, 5, 2, 2, 3, "#9a917c", "bone", axis="x"),
        ], parent="body", rot=(0, 0, -5), anim="arm"),
        *leg("leg_l", -4, up(3.4), 0, 34, 25, 4, "#7d7462", "#5f5849", "skin"),
        *leg("leg_r", 4, up(3.4), 0, 34, 25, 4, "#7d7462", "#5f5849", "skin"),
    ],
}

# ---------------------------------------------------------------- 19. Warship
MOBS["warship"] = {
    "class": "WarshipModel", "shadow": 3.0, "height": 6.0,
    "parts": [
        part("body", (0, up(1.2), 0), [
            # hull with a tapering bow and a flat stern
            blk(1.2, -14, 1.34, -42, 28, 0.92, 84, "#3d4650", "milmetal", face="hull"),
            blk(1.2, -10, 0.74, -38, 20, 0.6, 76, "#333b44", "milmetal", face="hull"),
            blk(1.2, -8, 1.34, -50, 16, 0.92, 10, "#414b56", "milmetal", face="hull"),
            blk(1.2, -3, 1.34, -56, 6, 0.92, 8, "#414b56", "milmetal"),
            blk(1.2, -11, 1.3, 42, 22, 0.88, 8, "#39424c", "milmetal", face="hull"),
            # deck plating
            blk(1.2, -12, 1.46, -40, 24, 0.14, 80, "#4a545f", "milmetal", face="deck"),
            blk(1.2, -7, 1.46, -48, 14, 0.14, 8, "#4a545f", "milmetal", face="deck"),
            # deck rails: posts + top rail
            *ridge(-12, 0, -38, 76, 4, 2, 13, "#5b6672", "metal", axis="z"),
            *ridge(11, 0, -38, 76, 4, 2, 13, "#5b6672", "metal", axis="z"),
            blk(1.2, -13, 1.62, -40, 2, 0.1, 80, "#66717d", "metal"),
            blk(1.2, 11, 1.62, -40, 2, 0.1, 80, "#66717d", "metal"),
            # anchor chains, portholes
            *[blk(1.2, -13, 1.1, -24 + i * 14, 2, 0.16, 2, "#8b8f7a", "lens", glow=True)
              for i in range(5)],
            *[blk(1.2, 11, 1.1, -24 + i * 14, 2, 0.16, 2, "#8b8f7a", "lens", glow=True)
              for i in range(5)],
        ], anim="bob"),
        part("head", (0, up(2.2), 0), [
            # bridge block
            blk(2.2, -9, 2.5, -8, 18, 0.9, 18, "#4a545f", "milmetal", face="bridge"),
            blk(2.2, -10, 2.7, -9, 20, 0.2, 20, "#556170", "milmetal"),
            blk(2.2, -6, 3.1, -5, 12, 0.6, 14, "#54606c", "milmetal", face="windows"),
            blk(2.2, -7, 3.2, -6, 14, 0.16, 16, "#5f6b78", "milmetal", face="deck"),
            # funnels
            blk(2.2, -3, 4.0, 6, 6, 1.0, 7, "#414b56", "milmetal", face="funnel"),
            blk(2.2, -4, 4.15, 5, 8, 0.16, 9, "#2f363d", "metal"),
            blk(2.2, -3, 3.7, 16, 5, 0.7, 5, "#414b56", "milmetal", face="funnel"),
            # mast + radar
            blk(2.2, -1, 5.7, -2, 2, 2.6, 2, "#5b6672", "metal"),
            blk(2.2, -4, 5.2, -3, 8, 0.24, 2, "#6b7684", "metal", face="radar"),
            blk(2.2, -6, 4.6, -1, 12, 0.16, 1, "#6b7684", "metal"),
            blk(2.2, -2, 5.9, -1, 4, 0.14, 4, "#8b93a0", "metal"),
            # AA tubs
            *ridge(-9, -2, -4, 16, 3, 3, 3, "#3a424c", "milmetal", axis="x"),
        ], parent="body", anim="head"),
        part("arm_l", (0, up(1.9), -26), [
            blk(1.9, -6, 2.3, -6, 12, 0.8, 12, "#454f59", "milmetal", face="armor"),
            blk(1.9, -5, 2.4, -5, 10, 0.14, 10, "#4f5a66", "milmetal", face="deck"),
            blk(1.9, -4, 2.02, -18, 2, 0.2, 12, "#333b44", "milmetal"),
            blk(1.9, 2, 2.02, -18, 2, 0.2, 12, "#333b44", "milmetal"),
            blk(1.9, -5, 2.5, -4, 2, 0.6, 2, "#2f363d", "metal"),
        ], parent="body", anim="arm"),
        part("arm_r", (0, up(1.9), 26), [
            blk(1.9, -5, 2.2, -5, 10, 0.7, 10, "#454f59", "milmetal", face="armor"),
            blk(1.9, -4, 1.98, -16, 2, 0.2, 11, "#333b44", "milmetal"),
            blk(1.9, 2, 1.98, -16, 2, 0.2, 11, "#333b44", "milmetal"),
        ], parent="body", anim="arm"),
    ],
}

# ---------------------------------------------------------------- 20. Circuit
MOBS["circuit"] = {
    "class": "CircuitModel", "shadow": 0.8, "height": 2.2,
    "parts": [
        part("body", (0, up(1.35), 0), [
            box(-6, -9, -4, 12, 20, 8, "#1d2b2b", "circuit", face="screen"),
            box(-7, 8, -5, 14, 4, 10, "#16211f", "circuit"),
            box(-2, -12, -3, 4, 3, 6, "#59ffd0", "lens", glow=True),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            box(-7, -7, -6, 14, 12, 12, "#233332", "circuit", face="screen"),
            box(-9, -2, -7, 3, 8, 14, "#2fa88a", "circuit"),
            box(6, -2, -7, 3, 8, 14, "#2fa88a", "circuit"),
            box(-4, -9, -3, 8, 3, 6, "#59ffd0", "lens", glow=True),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.5), 0), [
            box(-2, 0, -2, 3, 14, 3, "#1d2b2b", "circuit"),
            box(-2, 12, -2, 4, 8, 4, "#2fa88a", "circuit", face="panel"),
        ], parent="body", rot=(0, 0, 6), anim="arm"),
        part("arm_r", (8, up(1.5), 0), [
            box(-1, 0, -2, 3, 14, 3, "#1d2b2b", "circuit"),
            box(-2, 12, -2, 4, 8, 4, "#2fa88a", "circuit", face="panel"),
        ], parent="body", rot=(0, 0, -6), anim="arm"),
        *leg("leg_l", -4, up(0.85), 0, 8, 6, 3, "#16211f", "#0f1717", "circuit"),
        *leg("leg_r", 4, up(0.85), 0, 8, 6, 3, "#16211f", "#0f1717", "circuit"),
    ],
}

# ---------------------------------------------------------------- 21. Ash Hound
MOBS["ash_hound"] = {
    "class": "AshHoundModel", "shadow": 0.9, "height": 1.3,
    "parts": [
        part("body", (0, up(0.7), 0), [
            box(-5, -5, -9, 10, 10, 18, "#3b332d", "ash"),
            box(-6, -2, -8, 12, 6, 16, "#463d35", "ash"),
            box(-3, -6, 6, 6, 4, 6, "#2e2722", "ash"),
        ], anim="bob"),
        part("head", (0, up(0.95), -10), [
            box(-5, -5, -5, 10, 9, 10, "#42392f", "ash", face="hound"),
            box(-3, -1, -9, 6, 4, 5, "#2a231e", "ash", face="muzzle"),
            box(-5, -7, -3, 3, 4, 3, "#332c26", "ash"),
            box(2, -7, -3, 3, 4, 3, "#332c26", "ash"),
        ], parent="body", anim="head"),
        part("tentacle_0", (0, up(0.6), 8), [
            box(-1, 0, -1, 2, 10, 2, "#332c26", "ash"),
            box(-1, 8, -1, 3, 3, 3, "#d9713a", "lens", glow=True),
        ], parent="body", rot=(-35, 0, 0), anim="tentacle"),
        *leg("leg_0", -4, up(0.55), -7, 7, 5, 3, "#332c26", "#241e1a", "ash"),
        *leg("leg_1", 4, up(0.55), -7, 7, 5, 3, "#332c26", "#241e1a", "ash"),
        *leg("leg_2", -4, up(0.55), 7, 7, 5, 3, "#332c26", "#241e1a", "ash"),
        *leg("leg_3", 4, up(0.55), 7, 7, 5, 3, "#332c26", "#241e1a", "ash"),
    ],
}

# ---------------------------------------------------------------- 22. Cloud Ray
MOBS["cloud_ray"] = {
    "class": "CloudRayModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(0.85), 0), [
            box(-8, -4, -10, 16, 7, 20, "#d7dde2", "cloud"),
            box(-5, -6, -7, 10, 3, 15, "#eef3f7", "cloud"),
            box(-6, 3, -7, 12, 3, 14, "#c2cbd2", "cloud"),
            box(-2, 6, -3, 4, 3, 8, "#aeb8c0", "cloud"),
        ], anim="bob"),
        part("head", (0, up(0.8), -10), [
            box(-6, -4, -4, 12, 7, 7, "#c2cbd2", "cloud", face="ray_eye"),
            box(-4, -6, -2, 8, 3, 5, "#eef3f7", "cloud"),
            box(-1, -1, -5, 2, 2, 2, "#6fa8c9", "lens", glow=True),
        ], parent="body", anim="head"),
        part("wing_l", (-7, up(0.9), -2), [
            box(-14, -1, -7, 14, 3, 15, "#d7dde2", "cloud"),
            box(-21, 0, -5, 8, 2, 11, "#c2cbd2", "cloud"),
            box(-26, 1, -3, 6, 2, 7, "#aeb8c0", "cloud"),
        ], parent="body", rot=(0, 0, 10), anim="wing"),
        part("wing_r", (7, up(0.9), -2), [
            box(0, -1, -7, 14, 3, 15, "#d7dde2", "cloud"),
            box(13, 0, -5, 8, 2, 11, "#c2cbd2", "cloud"),
            box(20, 1, -3, 6, 2, 7, "#aeb8c0", "cloud"),
        ], parent="body", rot=(0, 0, -10), anim="wing"),
        part("tentacle_0", (0, up(0.8), 10), [
            box(-1, 0, -1, 3, 16, 3, "#c2cbd2", "cloud"),
            box(-1, 14, -1, 2, 12, 2, "#aeb8c0", "cloud"),
        ], parent="body", rot=(-24, 0, 0), anim="tentacle"),
        *[part("fin_%d" % i, (-6 + i * 12, up(0.9), 8), [
            box(-1, 0, -1, 3, 10, 3, "#aeb8c0", "cloud"),
        ], parent="body", rot=(20, 0, 0), anim="wing") for i in range(2)],
    ],
}

# ---------------------------------------------------------------- 23. Bog Wretch
MOBS["bog_wretch"] = {
    "class": "BogWretchModel", "shadow": 0.9, "height": 2.2,
    "parts": [
        part("body", (0, up(1.35), 0), [
            box(-7, -8, -4, 14, 20, 9, "#38442c", "wet", face="ribs"),
            box(-8, 8, -5, 16, 4, 10, "#2e3824", "wet"),
            box(-5, -11, -3, 10, 4, 8, "#2a3321", "wet"),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            box(-6, -6, -5, 12, 11, 10, "#42502f", "wet", face="skull"),
            box(-4, 3, -6, 8, 3, 3, "#33402a", "flesh", face="teeth"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.7), 0), [
            box(-2, 0, -2, 4, 14, 4, "#38442c", "wet"),
            box(-2, 12, -2, 5, 14, 5, "#2e3824", "wet"),
            box(-3, 24, -3, 6, 4, 6, "#4a5a36", "flesh"),
        ], parent="body", rot=(8, 0, 6), anim="arm"),
        part("arm_r", (8, up(1.7), 0), [
            box(-2, 0, -2, 4, 14, 4, "#38442c", "wet"),
            box(-2, 12, -2, 5, 14, 5, "#2e3824", "wet"),
            box(-3, 24, -3, 6, 4, 6, "#4a5a36", "flesh"),
        ], parent="body", rot=(8, 0, -6), anim="arm"),
        *leg("leg_l", -4, up(0.85), 0, 10, 7, 4, "#2e3824", "#232b1b", "wet"),
        *leg("leg_r", 4, up(0.85), 0, 10, 7, 4, "#2e3824", "#232b1b", "wet"),
    ],
}

# ---------------------------------------------------------------- 24. Lantern Wraith
MOBS["lantern_wraith"] = {
    "class": "LanternWraithModel", "shadow": 0.7, "height": 2.0,
    "parts": [
        part("body", (0, up(1.0), 0), [
            blk(1.0, -7, 1.7, -5, 14, 0.9, 10, "#2a2f3c", "cloth", face="robe"),
            blk(1.0, -8, 1.05, -6, 16, 0.36, 12, "#222633", "cloth"),
            blk(1.0, -6, 0.6, -5, 12, 0.3, 10, "#1c2029", "cloth", face="robe"),
            # tattered strips
            *ridge(-7, 0, -5, 12, 4, 2, 5, "#1c2029", "cloth", axis="x", taper=False),
            *ridge(-6, 8, -4, 11, 5, 2, 4, "#191d25", "cloth", axis="x", taper=False),
            # belt with a skull clasp
            blk(1.0, -8, 1.05, -6, 16, 0.1, 12, "#3a3326", "bone"),
            blk(1.0, -2, 1.1, -7, 4, 0.14, 2, "#cbbd9a", "bone"),
        ], anim="bob"),
        part("head", (0, up(1.62), 0), [
            blk(1.62, -7, 2.0, -7, 14, 0.55, 14, "#161a22", "cloth", face="hood"),
            blk(1.62, -5, 2.03, -5, 10, 0.3, 10, "#10131a", "cloth"),
            blk(1.62, -6, 1.72, -8, 12, 0.24, 3, "#0d1016", "cloth"),
            # hollow eyes
            blk(1.62, -4, 1.9, -8, 2, 0.1, 1, "#74c9ff", "lens", glow=True),
            blk(1.62, 2, 1.9, -8, 2, 0.1, 1, "#74c9ff", "lens", glow=True),
        ], parent="body", anim="head"),
        part("orb", (0, up(1.15), -8), [
            blk(1.15, -4, 1.5, -4, 8, 0.36, 8, "#74c9ff", "lens", glow=True),
            blk(1.15, -3, 1.56, -3, 6, 0.3, 6, "#bfe9ff", "lens", glow=True),
            blk(1.15, -5, 1.62, -2, 10, 0.08, 4, "#3a3326", "metal"),
            blk(1.15, -1, 1.68, -1, 2, 0.1, 2, "#3a3326", "metal"),
            blk(1.15, -1, 1.14, -1, 2, 0.2, 2, "#8b7a56", "metal"),
        ], parent="body", anim="eye"),
        part("arm_l", (-7, up(1.45), 0), [
            blk(1.45, -2, 1.45, -2, 3, 0.5, 3, "#242a35", "cloth"),
            blk(1.45, -2, 0.95, -3, 3, 0.5, 3, "#1c2029", "cloth"),
            blk(1.45, -3, 0.88, -4, 4, 0.09, 5, "#8fb5cc", "bone"),
            *ridge(-3, 3, -4, 4, 2, 2, 3, "#a8c6d8", "bone", axis="x"),
        ], parent="body", rot=(0, 0, 9), anim="arm"),
        part("arm_r", (7, up(1.45), 0), [
            blk(1.45, -1, 1.45, -2, 3, 0.5, 3, "#242a35", "cloth"),
            blk(1.45, -1, 0.95, -3, 3, 0.5, 3, "#1c2029", "cloth"),
            blk(1.45, -1, 0.88, -4, 4, 0.09, 5, "#8fb5cc", "bone"),
            *ridge(-1, 3, -4, 4, 2, 2, 3, "#a8c6d8", "bone", axis="x"),
        ], parent="body", rot=(0, 0, -9), anim="arm"),
    ],
}

# ---------------------------------------------------------------- 25. Hollow Neighbour
MOBS["hollow_neighbor"] = {
    "class": "HollowNeighborModel", "shadow": 0.9, "height": 2.1,
    "parts": [
        part("body", (0, up(1.15), 0), [
            blk(1.15, -7, 1.7, -4, 14, 1.2, 9, "#5a4a38", "cloth", face="robe"),
            blk(1.15, -8, 1.05, -5, 16, 0.3, 11, "#4a3c2d", "cloth"),
            blk(1.15, -9, 1.42, -5, 18, 0.24, 11, "#4a3c2d", "cloth"),
            # apron + belt with keys
            blk(1.15, -6, 1.2, -6, 12, 0.6, 2, "#7a6a52", "cloth"),
            blk(1.15, -8, 1.0, -5, 16, 0.18, 11, "#2e261c", "cloth"),
            blk(1.15, 2, 0.96, -6, 2, 0.3, 2, "#c9b27a", "metal"),
            blk(1.15, 5, 0.94, -6, 2, 0.26, 2, "#8f7d52", "metal"),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            blk(2.0, -6, 2.1, -5, 12, 0.7, 10, "#6a5a48", "skin", face="faceless"),
            blk(2.0, -2, 1.95, -8, 4, 0.4, 4, "#7d6c58", "skin"),
            blk(2.0, -7, 2.12, -4, 14, 0.2, 9, "#3f3426", "cloth"),
            blk(2.0, -3, 2.06, -7, 3, 0.12, 1, "#c8c0ae", "bone"),
            blk(2.0, 1, 2.06, -7, 3, 0.12, 1, "#c8c0ae", "bone"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.6), 0), [
            blk(1.6, -2, 1.6, -2, 3, 0.95, 3, "#5a4a38", "cloth"),
            blk(1.6, -2, 0.8, -2, 4, 0.75, 4, "#6a5a48", "skin"),
            blk(1.6, -3, 0.55, -3, 5, 0.3, 5, "#7d6c58", "skin"),
            *ridge(-3, 10, -3, 5, 2, 2, 3, "#8d7c66", "skin", axis="x"),
        ], parent="body", rot=(4, 0, 6), anim="arm"),
        part("arm_r", (8, up(1.6), 0), [
            blk(1.6, -1, 1.6, -2, 3, 0.95, 3, "#5a4a38", "cloth"),
            blk(1.6, -2, 0.8, -2, 4, 0.75, 4, "#6a5a48", "skin"),
            blk(1.6, -2, 0.55, -3, 5, 0.3, 5, "#7d6c58", "skin"),
            *ridge(-2, 10, -3, 5, 2, 2, 3, "#8d7c66", "skin", axis="x"),
        ], parent="body", rot=(4, 0, -6), anim="arm"),
        *leg("leg_l", -4, up(0.9), 0, 10, 6, 3, "#3f3426", "#2e261c", "cloth"),
        *leg("leg_r", 4, up(0.9), 0, 10, 6, 3, "#3f3426", "#2e261c", "cloth"),
    ],
}

# ---------------------------------------------------------------- 26. Tornado
def _funnel():
    parts = []
    rings = 9
    for i in range(rings):
        t = i / float(rings - 1)
        radius = int(round(40 - 34 * (t ** 0.7)))
        height = 20
        y = GROUND - 8 - i * height
        dx = int(round(math.sin(i * 1.9) * (5 - 3 * t)))
        dz = int(round(math.cos(i * 1.9) * (5 - 3 * t)))
        shade = "#8c99a6" if i % 2 else "#9dabb8"
        boxes = [box(-radius, 0, -radius, radius * 2, height, radius * 2, shade, "storm", face="vortex")]
        if i % 2 == 0:
            boxes.append(box(-radius - 3, 4, -radius - 3, radius * 2 + 6, 4, radius * 2 + 6,
                             "#7f8b98", "storm"))
        parts.append(part("ring_%d" % i, (dx, y, dz), boxes, anim="bob" if i % 3 == 0 else None))
    return parts


def _funnel():
    parts = []
    rings = 12
    for i in range(rings):
        t = i / float(rings - 1)
        radius = int(round(44 - 38 * (t ** 0.8)))
        y = GROUND - 8 - i * 16
        dx = int(round(math.sin(i * 1.7) * (6 - 4 * t)))
        dz = int(round(math.cos(i * 1.7) * (6 - 4 * t)))
        shade = "#8c99a6" if i % 2 else "#9dabb8"
        boxes = [box(-radius, 0, -radius, radius * 2, 18, radius * 2, shade, "storm", face="vortex")]
        if i % 2 == 0:
            boxes.append(box(-radius - 2, 3, -radius - 2, radius * 2 + 4, 3, radius * 2 + 4,
                             "#7f8b98", "storm"))
        parts.append(part("ring_%d" % i, (dx, y - 9, dz), boxes,
                          anim="bob" if i % 4 == 0 else None))
    return parts


MOBS["tornado"] = {
    "class": "TornadoModel", "shadow": 0.0, "height": 12.0,
    "parts": [
        *_funnel(),
        part("base", (0, up(0.3), 0), [
            box(-44, -3, -44, 88, 6, 88, "#5d6874", "storm", face="vortex"),
            box(-30, -8, -26, 56, 5, 50, "#6b7683", "storm"),
            box(-16, -12, -12, 32, 5, 24, "#77828e", "storm"),
        ], anim="bob"),
        part("top", (0, up(11.5), 0), [
            box(-14, -4, -14, 28, 8, 28, "#a8b5c1", "storm", face="vortex"),
            box(-20, -2, -9, 40, 4, 18, "#b6c2ce", "storm"),
        ], anim="bob"),
    ],
}
