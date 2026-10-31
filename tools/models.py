"""Model specifications for every Random Mobs creature.

Coordinate system matches vanilla entity models: 16 units = 1 block, +Y points DOWN,
the model origin sits 1.5 blocks above the ground (so feet are at y = 24), and -Z is the
direction the mob is looking at.
"""


def box(x, y, z, w, h, d, color, style="noise", glow=False):
    return {"x": x, "y": y, "z": z, "w": w, "h": h, "d": d,
            "color": color, "style": style, "glow": glow}


def part(name, pivot, boxes, parent=None, rot=None):
    return {"name": name, "pivot": pivot, "boxes": boxes, "parent": parent, "rot": rot}


MOBS = {
    # ------------------------------------------------------------------ 1
    "tripod": {
        "class": "TripodModel",
        "shadow": 2.0,
        "scale": 1.32,
        "parts": [
            part("body", (0, -20, 0), [
                box(-11, -12, -11, 22, 24, 22, "#4c525c", "noise"),
                box(-7, -10, -12, 14, 10, 2, "#3a3f47", "noise"),
            ]),
            part("head", (0, -34, 0), [
                box(-8, -9, -8, 16, 11, 16, "#5a616b", "noise"),
            ]),
            part("eye", (0, -37, -7), [
                box(-4, -4, -3, 8, 8, 3, "#f6e27a", "glow", glow=True),
            ]),
            part("leg_a", (11, -12, 8), [
                box(-2, 0, -2, 4, 38, 4, "#33383f", "noise"),
            ], rot=(0, 0, -8)),
            part("leg_b", (-11, -12, 8), [
                box(-2, 0, -2, 4, 38, 4, "#33383f", "noise"),
            ], rot=(0, 0, 8)),
            part("leg_c", (0, -12, -12), [
                box(-2, 0, -2, 4, 38, 4, "#33383f", "noise"),
            ], rot=(10, 0, 0)),
        ],
    },
    # ------------------------------------------------------------------ 2
    "woodcrawler": {
        "class": "WoodcrawlerModel",
        "shadow": 0.6,
        "scale": 1.0,
        "parts": [
            part("body", (0, 10, 0), [
                box(-5, -10, -3, 10, 12, 6, "#5d4227", "wood"),
                box(-6, -2, -4, 12, 4, 8, "#4a3420", "wood"),
            ]),
            part("head", (0, 2, 0), [
                box(-4, -4, -4, 8, 8, 8, "#6d4d2d", "wood"),
                box(-2, 0, -6, 4, 4, 3, "#8a6a3f", "wood"),
                box(-3, -6, -2, 2, 3, 2, "#7fb04a", "plain", glow=True),
                box(1, -6, -2, 2, 3, 2, "#7fb04a", "plain", glow=True),
            ]),
            part("crown", (0, -4, 0), [
                box(-5, -5, -5, 10, 5, 10, "#3f6b2a", "spots"),
            ]),
            part("arm_r", (6, 2, 0), [
                box(-2, 0, -2, 4, 14, 4, "#54391f", "wood"),
            ], rot=(0, 0, -6)),
            part("arm_l", (-6, 2, 0), [
                box(-2, 0, -2, 4, 14, 4, "#54391f", "wood"),
            ], rot=(0, 0, 6)),
            part("leg_r", (4, 12, 0), [
                box(-2, 0, -2, 4, 12, 4, "#4a3420", "wood"),
            ]),
            part("leg_l", (-4, 12, 0), [
                box(-2, 0, -2, 4, 12, 4, "#4a3420", "wood"),
            ]),
        ],
    },
    # ------------------------------------------------------------------ 3
    "bloop": {
        "class": "BloopModel",
        "shadow": 3.0,
        "scale": 1.7,
        "parts": [
            part("body", (0, -30, 0), [
                box(-26, -22, -20, 52, 44, 40, "#10303f", "noise"),
                box(-18, 6, -14, 36, 16, 28, "#1d4a5c", "noise"),
            ]),
            part("head", (0, -46, 0), [
                box(-18, -8, -14, 36, 14, 28, "#153a4b", "noise"),
            ]),
            part("eye", (0, -46, -15), [
                box(-7, -7, -2, 14, 14, 3, "#d6fff7", "glow", glow=True),
            ]),
            part("fin_r", (26, -20, 0), [
                box(0, -2, -10, 18, 4, 20, "#0d2734", "noise"),
            ], rot=(0, 0, -18)),
            part("fin_l", (-26, -20, 0), [
                box(-18, -2, -10, 18, 4, 20, "#0d2734", "noise"),
            ], rot=(0, 0, 18)),
            part("tentacle_0", (10, -6, 8), [
                box(-3, 0, -3, 6, 26, 6, "#0b2130", "noise"),
            ]),
            part("tentacle_1", (-10, -6, 8), [
                box(-3, 0, -3, 6, 30, 6, "#0b2130", "noise"),
            ]),
            part("tentacle_2", (10, -6, -8), [
                box(-3, 0, -3, 6, 30, 6, "#0b2130", "noise"),
            ]),
            part("tentacle_3", (-10, -6, -8), [
                box(-3, 0, -3, 6, 26, 6, "#0b2130", "noise"),
            ]),
        ],
    },
    # ------------------------------------------------------------------ 4
    "alive_house": {
        "class": "AliveHouseModel",
        "shadow": 2.4,
        "scale": 1.12,
        "parts": [
            part("body", (0, -6, 0), [
                box(-24, -22, -20, 48, 40, 40, "#a08055", "wood"),
            ]),
            part("roof", (0, -28, 0), [
                box(-27, -7, -23, 54, 8, 46, "#6b4a33", "wood"),
                box(-20, -12, -16, 40, 5, 32, "#7d5637", "wood"),
            ]),
            part("door", (0, 12, -20), [
                box(-6, -18, -1, 12, 22, 2, "#3b2a1c", "wood"),
                box(-1, -10, -2, 2, 2, 2, "#d9b45a", "plain", glow=True),
            ]),
            part("window_r", (15, -2, -20), [
                box(-5, -5, 0, 10, 10, 2, "#ffd76e", "glow", glow=True),
            ]),
            part("window_l", (-15, -2, -20), [
                box(-5, -5, 0, 10, 10, 2, "#ffd76e", "glow", glow=True),
            ]),
            part("leg_a", (16, 14, 14), [
                box(-2, 0, -2, 4, 12, 4, "#4a3626", "wood"),
            ]),
            part("leg_b", (-16, 14, 14), [
                box(-2, 0, -2, 4, 12, 4, "#4a3626", "wood"),
            ]),
            part("leg_c", (16, 14, -14), [
                box(-2, 0, -2, 4, 12, 4, "#4a3626", "wood"),
            ]),
            part("leg_d", (-16, 14, -14), [
                box(-2, 0, -2, 4, 12, 4, "#4a3626", "wood"),
            ]),
        ],
    },
    # ------------------------------------------------------------------ 5
    "giant_spider": {
        "class": "GiantSpiderModel",
        "shadow": 1.6,
        "scale": 1.05,
        "parts": [
            part("abdomen", (0, 4, 12), [
                box(-12, -10, -15, 24, 20, 30, "#3b3324", "spots"),
            ]),
            part("body", (0, 4, -4), [
                box(-9, -8, -10, 18, 16, 20, "#332c1f", "spots"),
            ]),
            part("head", (0, 2, -16), [
                box(-7, -6, -8, 14, 12, 16, "#2c261a", "noise"),
                box(-4, -2, -10, 3, 3, 2, "#8b2d1c", "glow", glow=True),
                box(1, -2, -10, 3, 3, 2, "#8b2d1c", "glow", glow=True),
            ]),
            part("leg_r0", (8, 0, -8), [box(0, -1, -1, 26, 3, 3, "#2a2419", "noise")], rot=(0, 20, -32)),
            part("leg_r1", (9, 0, -2), [box(0, -1, -1, 30, 3, 3, "#2a2419", "noise")], rot=(0, 8, -22)),
            part("leg_r2", (9, 0, 4), [box(0, -1, -1, 30, 3, 3, "#2a2419", "noise")], rot=(0, -8, -22)),
            part("leg_r3", (8, 0, 10), [box(0, -1, -1, 26, 3, 3, "#2a2419", "noise")], rot=(0, -20, -32)),
            part("leg_l0", (-8, 0, -8), [box(-26, -1, -1, 26, 3, 3, "#2a2419", "noise")], rot=(0, -20, 32)),
            part("leg_l1", (-9, 0, -2), [box(-30, -1, -1, 30, 3, 3, "#2a2419", "noise")], rot=(0, -8, 22)),
            part("leg_l2", (-9, 0, 4), [box(-30, -1, -1, 30, 3, 3, "#2a2419", "noise")], rot=(0, 8, 22)),
            part("leg_l3", (-8, 0, 10), [box(-26, -1, -1, 26, 3, 3, "#2a2419", "noise")], rot=(0, 20, 32)),
        ],
    },
    # ------------------------------------------------------------------ 6
    "gardener": {
        "class": "GardenerModel",
        "shadow": 1.0,
        "scale": 1.0,
        "parts": [
            part("body", (0, -26, 0), [
                box(-10, -9, -10, 20, 19, 20, "#cbb9a4", "noise"),
                box(-13, 6, -6, 26, 8, 12, "#bda791", "noise"),
            ]),
            part("head", (0, -34, 0), [
                box(-8, -8, -8, 16, 8, 16, "#e0d0bb", "noise"),
            ]),
            part("orb", (0, -42, 0), [
                box(-5, -5, -5, 10, 10, 10, "#fff39a", "glow", glow=True),
            ]),
            part("tentacle_0", (6, -8, 6), [box(-2, 0, -2, 4, 32, 4, "#a8937c", "noise")]),
            part("tentacle_1", (-6, -8, 6), [box(-2, 0, -2, 4, 30, 4, "#a8937c", "noise")]),
            part("tentacle_2", (6, -8, -6), [box(-2, 0, -2, 4, 30, 4, "#a8937c", "noise")]),
            part("tentacle_3", (-6, -8, -6), [box(-2, 0, -2, 4, 32, 4, "#a8937c", "noise")]),
            part("tentacle_4", (0, -8, 0), [box(-2, 0, -2, 4, 34, 4, "#9c8770", "noise")]),
        ],
    },
    # ------------------------------------------------------------------ 7
    "sand_worm": {
        "class": "SandWormModel",
        "shadow": 1.4,
        "scale": 1.15,
        "parts": [
            part("head", (0, -2, -26), [
                box(-12, -12, -7, 24, 24, 14, "#c8b07a", "stripes"),
                box(-9, -9, -9, 18, 18, 3, "#6d2b23", "plain"),
                box(-8, -10, -10, 3, 3, 4, "#f2ead6", "plain", glow=True),
                box(5, -10, -10, 3, 3, 4, "#f2ead6", "plain", glow=True),
                box(-8, 7, -10, 3, 3, 4, "#f2ead6", "plain", glow=True),
                box(5, 7, -10, 3, 3, 4, "#f2ead6", "plain", glow=True),
            ]),
            part("body", (0, 0, -6), [
                box(-11, -11, -8, 22, 22, 22, "#bda268", "stripes"),
            ]),
            part("seg2", (0, 3, 12), [
                box(-9, -9, -6, 18, 18, 18, "#c8b07a", "stripes"),
            ]),
            part("seg3", (0, 6, 26), [
                box(-7, -7, -6, 14, 14, 18, "#bda268", "stripes"),
            ]),
            part("seg4", (0, 8, 40), [
                box(-5, -5, -6, 10, 10, 16, "#c8b07a", "stripes"),
            ]),
        ],
    },
    # ------------------------------------------------------------------ 8
    "ufo": {
        "class": "UfoModel",
        "shadow": 1.6,
        "scale": 1.0,
        "parts": [
            part("body", (0, 8, 0), [
                box(-24, -4, -24, 48, 8, 48, "#878f96", "noise"),
                box(-14, -8, -14, 28, 4, 28, "#6f777e", "noise"),
            ]),
            part("head", (0, 4, 0), [
                box(-10, -9, -10, 20, 9, 20, "#9fe6c0", "glow", glow=True),
            ]),
            part("light_a", (20, 8, 0), [box(-2, -2, -6, 4, 4, 12, "#7cf2a8", "glow", glow=True)]),
            part("light_b", (-20, 8, 0), [box(-2, -2, -6, 4, 4, 12, "#7cf2a8", "glow", glow=True)]),
            part("light_c", (0, 8, 20), [box(-6, -2, -2, 12, 4, 4, "#7cf2a8", "glow", glow=True)]),
            part("light_d", (0, 8, -20), [box(-6, -2, -2, 12, 4, 4, "#7cf2a8", "glow", glow=True)]),
        ],
    },
    # ------------------------------------------------------------------ 9
    "bear": {
        "class": "BearModel",
        "shadow": 0.9,
        "scale": 1.0,
        "parts": [
            part("body", (0, 4, 0), [
                box(-7, -8, -13, 14, 16, 26, "#5b3a24", "noise"),
            ]),
            part("head", (0, 2, -13), [
                box(-6, -7, -8, 12, 12, 12, "#5b3a24", "noise"),
                box(-4, 1, -11, 8, 5, 4, "#7a5638", "noise"),
                box(-2, 2, -12, 4, 3, 2, "#1c1310", "plain"),
                box(-5, -9, -3, 3, 3, 3, "#4a2e1c", "noise"),
                box(2, -9, -3, 3, 3, 3, "#4a2e1c", "noise"),
            ]),
            part("leg_a", (5, 10, -9), [box(-2, 0, -2, 4, 14, 4, "#4a2e1c", "noise")]),
            part("leg_b", (-5, 10, -9), [box(-2, 0, -2, 4, 14, 4, "#4a2e1c", "noise")]),
            part("leg_c", (5, 10, 9), [box(-2, 0, -2, 4, 14, 4, "#4a2e1c", "noise")]),
            part("leg_d", (-5, 10, 9), [box(-2, 0, -2, 4, 14, 4, "#4a2e1c", "noise")]),
            part("tail", (0, 0, 13), [box(-2, -2, 0, 4, 4, 4, "#4a2e1c", "noise")]),
        ],
    },
    # ------------------------------------------------------------------ 10
    "kraken": {
        "class": "KrakenModel",
        "shadow": 2.2,
        "scale": 1.2,
        "parts": [
            part("body", (0, -16, 0), [
                box(-22, -18, -20, 44, 36, 40, "#3b2a52", "noise"),
                box(-16, 14, -14, 32, 12, 28, "#2c1d3f", "noise"),
            ]),
            part("head", (0, -30, 0), [
                box(-16, -8, -14, 32, 14, 28, "#463060", "noise"),
            ]),
            part("eye_r", (11, -30, -14), [box(-4, -4, -2, 8, 8, 3, "#c9a6ff", "glow", glow=True)]),
            part("eye_l", (-11, -30, -14), [box(-4, -4, -2, 8, 8, 3, "#c9a6ff", "glow", glow=True)]),
            part("tentacle_0", (12, 10, 10), [box(-3, 0, -3, 6, 32, 6, "#4a3566", "noise")]),
            part("tentacle_1", (-12, 10, 10), [box(-3, 0, -3, 6, 30, 6, "#4a3566", "noise")]),
            part("tentacle_2", (12, 10, -10), [box(-3, 0, -3, 6, 30, 6, "#4a3566", "noise")]),
            part("tentacle_3", (-12, 10, -10), [box(-3, 0, -3, 6, 32, 6, "#4a3566", "noise")]),
            part("tentacle_4", (0, 10, 14), [box(-3, 0, -3, 6, 34, 6, "#4a3566", "noise")]),
        ],
    },
    # ------------------------------------------------------------------ 11
    "evil_watermelon": {
        "class": "EvilWatermelonModel",
        "shadow": 0.5,
        "scale": 0.85,
        "parts": [
            part("body", (0, 10, 0), [
                box(-9, -10, -9, 18, 18, 18, "#2f5c1f", "stripes"),
                box(-4, 0, -10, 3, 4, 2, "#d43a3a", "glow", glow=True),
                box(1, 0, -10, 3, 4, 2, "#d43a3a", "glow", glow=True),
                box(-4, 6, -10, 8, 2, 2, "#1c0c0c", "plain"),
            ]),
            part("leg_a", (3, 18, 0), [box(-2, 0, -2, 4, 6, 4, "#233f16", "noise")]),
            part("leg_b", (-3, 18, 0), [box(-2, 0, -2, 4, 6, 4, "#233f16", "noise")]),
        ],
    },
    # ------------------------------------------------------------------ 12
    "alive_tree": {
        "class": "AliveTreeModel",
        "shadow": 1.8,
        "scale": 1.0,
        "parts": [
            part("body", (0, -18, 0), [
                box(-5, -16, -5, 10, 30, 10, "#5a3f22", "wood"),
                box(-8, 6, -8, 16, 6, 16, "#4a3320", "wood"),
            ]),
            part("head", (0, -38, 0), [
                box(-20, -12, -20, 40, 20, 40, "#2f6b22", "spots"),
                box(-14, -18, -14, 28, 8, 28, "#24521a", "spots"),
                box(-4, -24, -4, 8, 8, 8, "#3f7a2e", "spots"),
            ]),
            part("leg_a", (6, 12, 6), [box(-1.5, 0, -1.5, 3, 12, 3, "#4a3320", "wood")]),
            part("leg_b", (-6, 12, 6), [box(-1.5, 0, -1.5, 3, 12, 3, "#4a3320", "wood")]),
            part("leg_c", (6, 12, -6), [box(-1.5, 0, -1.5, 3, 12, 3, "#4a3320", "wood")]),
            part("leg_d", (-6, 12, -6), [box(-1.5, 0, -1.5, 3, 12, 3, "#4a3320", "wood")]),
        ],
    },
    # ------------------------------------------------------------------ 13
    "woodcock": {
        "class": "WoodcockModel",
        "shadow": 0.3,
        "scale": 1.0,
        "parts": [
            part("body", (0, 16, 0), [
                box(-5, -6, -7, 10, 12, 14, "#6b5540", "noise"),
                box(-4, 4, -5, 8, 4, 10, "#d8c3a2", "noise"),
            ]),
            part("head", (0, 8, -7), [
                box(-4, -5, -4, 8, 8, 8, "#755e46", "noise"),
                box(-3, -2, -5, 2, 2, 1, "#101010", "plain"),
                box(1, -2, -5, 2, 2, 1, "#101010", "plain"),
            ]),
            part("wing_r", (5, 12, 0), [box(-1, 0, -6, 2, 8, 12, "#7d6650", "noise")]),
            part("wing_l", (-5, 12, 0), [box(-1, 0, -6, 2, 8, 12, "#7d6650", "noise")]),
            part("tail", (0, 14, 7), [box(-3, -2, 0, 6, 4, 6, "#5b4735", "noise")]),
            part("beak", (0, 10, -11), [box(-1, -1, -9, 2, 2, 9, "#3a2c20", "plain")]),
            part("leg_a", (2, 22, 0), [box(-1, 0, -1, 2, 4, 2, "#8a6a45", "plain")]),
            part("leg_b", (-2, 22, 0), [box(-1, 0, -1, 2, 4, 2, "#8a6a45", "plain")]),
        ],
    },
}
