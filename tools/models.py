"""Model specifications for every Random Mobs creature (v3).

Coordinate system matches vanilla entity models: 16 units = 1 block, +Y points DOWN,
the model origin sits 1.5 blocks above the ground (feet end up around y = +24),
and -Z is the direction the mob is looking at.

Pivots of root-level parts are absolute; pivots of nested parts are relative to
their parent (vanilla behaviour).

Every box carries a texture spec: ``color`` + ``style`` for the base material and an
optional ``face`` decoration that is painted on the front (north) face of the box.
"""
import math


def box(x, y, z, w, h, d, color, style="noise", face=None, glow=False):
    return {"x": x, "y": y, "z": z, "w": w, "h": h, "d": d,
            "color": color, "style": style, "face": face, "glow": glow}


def part(name, pivot, boxes, parent=None, rot=None, anim=None):
    return {"name": name, "pivot": pivot, "boxes": boxes, "parent": parent,
            "rot": rot, "anim": anim}


# ------------------------------------------------------------------ aiming helpers
def _norm(v):
    length = math.sqrt(sum(c * c for c in v)) or 1.0
    return tuple(c / length for c in v)


def _sub(a, b):
    return (a[0] - b[0], a[1] - b[1], a[2] - b[2])


def _len(v):
    return math.sqrt(sum(c * c for c in v))


def rot_matrix(rot):
    """Minecraft rotates z, then y, then x, so R = Rx * Ry * Rz."""
    rx, ry, rz = (math.radians(a) for a in (rot or (0, 0, 0)))
    cz, sz = math.cos(rz), math.sin(rz)
    cy, sy = math.cos(ry), math.sin(ry)
    cx, sx = math.cos(rx), math.sin(rx)
    mz = ((cz, -sz, 0.0), (sz, cz, 0.0), (0.0, 0.0, 1.0))
    my = ((cy, 0.0, sy), (0.0, 1.0, 0.0), (-sy, 0.0, cy))
    mx = ((1.0, 0.0, 0.0), (0.0, cx, -sx), (0.0, sx, cx))

    def mul(a, b):
        return tuple(tuple(sum(a[i][k] * b[k][j] for k in range(3)) for j in range(3)) for i in range(3))

    return mul(mul(mx, my), mz)


def aim(direction):
    """Rotation (rx, ry, rz) in degrees that makes a +Y box point along ``direction``."""
    dx, dy, dz = _norm(direction)
    dx = max(-1.0, min(1.0, dx))
    rz = -math.degrees(math.asin(dx))
    rx = math.degrees(math.atan2(dz, dy))
    return (round(rx, 2), 0.0, round(rz, 2))


def aim_local(parent_rot, world_direction):
    """Same as aim(), but expressed in the parent's already rotated frame."""
    m = rot_matrix(parent_rot)
    local = tuple(sum(m[k][i] * world_direction[k] for k in range(3)) for i in range(3))
    return aim(local)


GROUND = 24.0


def _leg(name, hip, knee, foot, thick, upper_color, lower_color, style, anim, claw):
    up_len = max(1.0, _len(_sub(knee, hip)))
    low_len = max(1.0, _len(_sub(foot, knee)))
    thigh_rot = aim(_sub(knee, hip))
    shin_rot = aim_local(thigh_rot, _sub(foot, knee))
    parts = [
        part(name, hip, [
            box(-thick // 2, 0, -thick // 2, thick, up_len, thick, upper_color, style),
            box(-thick // 2 - 1, up_len * 0.25, -thick // 2 - 1, thick + 2, max(2, thick // 2),
                thick + 2, upper_color, style),
        ], rot=thigh_rot, anim=anim),
        part(name + "_low", (hip[0], hip[1] + up_len, hip[2]),
             [box(-thick // 2 + 1, 0, -thick // 2 + 1, max(1, thick - 1), low_len, max(1, thick - 1),
                  lower_color, style)]
             + ([box(-2, low_len - 2, -2, 4, 3, 4, lower_color, "bone"),
                 box(-3, low_len, -2, 2, 3, 2, lower_color, "bone"),
                 box(1, low_len, -2, 2, 3, 2, lower_color, "bone")] if claw else []),
             parent=name, rot=shin_rot, anim=anim + "_low"),
    ]
    return parts


def leg(name, x, y, z, upper, lower, thick, upper_color, lower_color, style="chitin",
        out=0.0, spread=0.0, anim="leg", claw=True):
    """Knee-bent two segment leg: it keeps the authored lengths, only adds a knee."""
    side = -1.0 if x < 0 else 1.0
    reach = max(1.0, thick * 0.55) + abs(out)
    knee = (x + side * reach, y + upper * 0.9, z + spread * 0.5)
    foot = (x + side * (reach + max(1.0, thick * 0.45)), y + (upper + lower) * 0.92, z + spread)
    return _leg(name, (x, y, z), knee, foot, thick, upper_color, lower_color, style, anim, claw)


def spider_legs(prefix, pivot_y, radius_x, radius_z, upper, lower, thick,
                upper_color, lower_color, style="chitin", anim="leg", knee_lift=0.0):
    """Eight harvestman legs: they rise to a high knee, then fold out and down."""
    parts = []
    for side, sx in (("l", -1), ("r", 1)):
        for i, (ang, zoff) in enumerate(((-40, -5), (-17, -2), (17, 2), (40, 5))):
            x = sx * radius_x
            z = zoff * (radius_z / 5.0)
            name = "%s_%s%d" % (prefix, side, i)
            hip = (x, pivot_y, z)
            knee = (x + sx * (radius_x * 1.35 + 4), pivot_y - upper * 0.08 - knee_lift,
                    z + zoff * 1.1)
            foot = (x + sx * (radius_x * 2.5 + 9), GROUND, z + zoff * 2.4)
            parts += _leg(name, hip, knee, foot, thick, upper_color, lower_color, style, anim, True)
    return parts


MOBS = {}


def up(blocks):
    """Y coordinate (model units) for a height above the ground, in blocks."""
    return GROUND - blocks * 16.0


# ---------------------------------------------------------------- 1. Tripod
MOBS["tripod"] = {
    "class": "TripodModel", "shadow": 2.2, "height": 6.4,
    "parts": [
        part("body", (0, up(3.4), 0), [
            box(-11, -10, -11, 22, 20, 22, "#5b6470", "metal", face="panel"),
            box(-13, 4, -8, 26, 6, 16, "#464e58", "metal"),
            box(-7, 8, -7, 14, 9, 14, "#3b424b", "metal", face="vent"),
            box(-15, -2, -3, 30, 4, 6, "#6d7683", "metal"),
        ], anim="bob"),
        part("head", (0, up(4.6), 0), [
            box(-8, -8, -9, 16, 12, 17, "#6f7a86", "metal", face="panel"),
            box(-5, -6, -12, 10, 7, 4, "#232a31", "metal", face="visor"),
            box(-2, 2, -12, 4, 4, 3, "#8ef7c8", "lens", glow=True),
        ], anim="head"),
        part("eye", (0, -2, -12), [
            box(-4, -4, -1, 8, 8, 2, "#ffe98a", "lens", glow=True),
        ], parent="head", anim="eye"),
        *leg("leg_a", -9, up(3.0), 9, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_b", 9, up(3.0), 9, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_c", 0, up(3.0), -11, 30, 28, 6, "#4b535d", "#3a414a", "metal", anim="leg"),
        part("arm_l", (-13, up(3.2), -2), [
            box(-2, 0, -2, 4, 14, 4, "#5b6470", "metal"),
            box(-3, 12, -3, 6, 4, 6, "#2f343b", "metal"),
        ], anim="arm"),
        part("arm_r", (13, up(3.2), -2), [
            box(-2, 0, -2, 4, 14, 4, "#5b6470", "metal"),
            box(-3, 12, -3, 6, 4, 6, "#2f343b", "metal"),
        ], anim="arm"),
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
            box(-20, -16, -20, 40, 34, 40, "#12303f", "wet"),
            box(-22, -6, -18, 44, 16, 36, "#0e2733", "wet"),
            box(-16, 16, -16, 32, 8, 32, "#193f52", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.3), -12), [
            box(-12, -10, -8, 24, 18, 16, "#1a4457", "wet", face="maw"),
            box(-10, 2, -9, 20, 6, 4, "#0a1c24", "wet", face="teeth"),
        ], parent="body", anim="head"),
        part("eye", (0, -30.8, -21), [
            box(-6, -6, -2, 12, 12, 3, "#2fd6c9", "lens", glow=True),
            box(-3, -3, -3, 6, 6, 2, "#06131a", "lens"),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-14 + i * 7, 18, -4 + (i % 3) * 5), [
            box(-3, 0, -3, 6, 26, 6, "#12303f", "wet", face="suckers"),
            box(-2, 22, -2, 4, 8, 4, "#1a4457", "wet"),
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
        part("body", (0, up(1.9), 0), [
            box(-7, -8, -5, 14, 18, 10, "#2a2622", "cloth", face="robe"),
            box(-9, 6, -6, 18, 6, 12, "#221e1b", "cloth"),
            box(-6, 12, -5, 12, 12, 10, "#1d1a18", "cloth", face="robe"),
            box(-8, 0, -6, 16, 3, 12, "#332e28", "cloth"),
        ], anim="bob"),
        part("head", (0, up(2.5), 0), [
            box(-6, -3, -6, 12, 11, 12, "#14120f", "cloth", face="hood"),
            box(-7, 6, -6, 14, 4, 13, "#100e0c", "cloth"),
        ], parent="body", anim="head"),
        part("orb", (0, up(2.95), 0), [
            box(-4, -4, -4, 8, 8, 8, "#fff39a", "lens", glow=True),
            box(-2, 3, -2, 4, 2, 4, "#ffe14d", "lens", glow=True),
            box(-5, 4, -5, 10, 2, 10, "#3a342b", "metal"),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-5 + (i % 2) * 10, up(1.6), -3 + (i // 2) * 4), [
            box(-1, 0, -1, 3, 12, 3, "#26221e", "cloth"),
            box(-1, 10, -1, 2, 10, 2, "#1d1a17", "cloth"),
            box(-5, 18, -1, 6, 2, 2, "#3a332c", "bone"),
        ], parent="body", rot=(0, 0, -14 if i % 2 else 14), anim="tentacle") for i in range(4)],
        *leg("leg_l", -4, up(0.55), 0, 9, 6, 3, "#201d1a", "#151311", "cloth", anim="leg"),
        *leg("leg_r", 4, up(0.55), 0, 9, 6, 3, "#201d1a", "#151311", "cloth", anim="leg"),
    ],
}

# ---------------------------------------------------------------- 7. Sand Worm
MOBS["sand_worm"] = {
    "class": "SandWormModel", "shadow": 2.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.1), 0), [
            box(-10, -10, -10, 20, 22, 20, "#c8b07a", "sand", face="segments"),
            box(-8, 10, -8, 16, 8, 16, "#b09460", "sand"),
            box(-12, -2, -12, 24, 5, 24, "#d6c08c", "bone", face="ridge"),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            box(-9, -6, -9, 18, 12, 18, "#cbb27c", "sand", face="maw"),
            box(-7, 4, -7, 14, 5, 14, "#8d5a3c", "flesh", face="teeth"),
        ], parent="body", anim="head"),
        part("jaw", (0, -2, -2), [
            box(-6, -2, -6, 12, 8, 12, "#a8804f", "flesh", face="teeth"),
        ], parent="head", anim="jaw"),
        *[part("spike_%d" % i, (-12 + i * 8, up(1.3), 0), [
            box(-1, -4, -1, 2, 8, 2, "#e0cba0", "bone"),
        ], parent="body", rot=(0, 0, -30 + i * 20), anim="tentacle") for i in range(4)],
    ],
}

# ---------------------------------------------------------------- 8. UFO
MOBS["ufo"] = {
    "class": "UfoModel", "shadow": 1.4, "height": 2.0,
    "parts": [
        part("body", (0, up(1.2), 0), [
            box(-13, -3, -13, 26, 5, 26, "#9aa4ac", "metal", face="panel"),
            box(-19, -1, -19, 38, 4, 38, "#7d878f", "metal"),
            box(-24, 0, -24, 48, 3, 48, "#6b747b", "metal", face="lights"),
            box(-15, 3, -15, 30, 3, 30, "#525a60", "metal"),
        ], anim="bob"),
        part("head", (0, up(1.75), 0), [
            box(-9, -6, -9, 18, 8, 18, "#d7e3ea", "metal"),
            box(-7, -4, -7, 14, 5, 14, "#8ef7c8", "lens", glow=True),
            box(-1, -10, -1, 2, 5, 2, "#3a4a52", "metal"),
        ], parent="body", anim="head"),
        *[part("lamp_%d" % i, (-16 + (i % 2) * 32, 1, -16 + (i // 2) * 32), [
            box(-2, 0, -2, 4, 3, 4, "#8ef7c8", "lens", glow=True),
        ], parent="body", anim="rotor") for i in range(4)],
        part("beam", (0, 4, 0), [
            box(-12, 0, -12, 24, 2, 24, "#9be3ff", "lens", glow=True),
        ], parent="body", anim="eye"),
    ],
}

# ---------------------------------------------------------------- 9. Bear
MOBS["bear"] = {
    "class": "BearModel", "shadow": 1.0, "height": 1.8,
    "parts": [
        part("body", (0, up(0.95), 0), [
            box(-9, -9, -14, 18, 16, 28, "#503a26", "fur"),
            box(-10, -3, -12, 20, 9, 24, "#5d442d", "fur"),
            box(-7, -13, 8, 14, 5, 8, "#3f2c1e", "fur"),
        ], anim="bob"),
        part("head", (0, up(1.25), -15), [
            box(-7, -7, -7, 14, 12, 13, "#573f29", "fur", face="bear"),
            box(-3, -2, -10, 6, 5, 4, "#b09a7c", "fur", face="snout"),
            box(-9, -9, -3, 4, 5, 5, "#4a3421", "fur"),
            box(5, -9, -3, 4, 5, 5, "#4a3421", "fur"),
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
            box(-16, -14, -16, 32, 28, 30, "#2a1a3a", "wet"),
            box(-18, -4, -14, 36, 12, 26, "#22152f", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.0), -12), [
            box(-14, -12, -12, 28, 24, 22, "#35244a", "wet", face="maw"),
            box(-11, 6, -11, 22, 8, 18, "#1d1230", "wet", face="teeth"),
            box(-6, -14, -6, 12, 4, 12, "#4a3266", "wet"),
        ], parent="body", anim="head"),
        part("eye_l", (-7, up(3.2), -22), [
            box(-4, -4, -1, 8, 8, 2, "#f2d15a", "lens", glow=True),
        ], parent="body", anim="eye"),
        part("eye_r", (7, up(3.2), -22), [
            box(-4, -4, -1, 8, 8, 2, "#f2d15a", "lens", glow=True),
        ], parent="body", anim="eye"),
        *[part("tentacle_%d" % i, (-12 + i * 4, up(1.4), -6 + (i // 3) * 12), [
            box(-2, 0, -2, 5, 20, 5, "#2a1a3a", "wet", face="suckers"),
            box(-2, 18, -2, 4, 12, 4, "#35244a", "wet"),
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
        part("body", (0, up(0.5), 2), [
            box(-4, -5, -6, 8, 8, 12, "#6b5335", "feather"),
            box(-3, 2, 3, 6, 3, 6, "#5d472d", "feather", face="feather"),
        ], anim="bob"),
        part("head", (0, up(0.72), -5), [
            box(-3, -3, -4, 6, 6, 7, "#7b6140", "feather", face="bird"),
            box(-1, -1, -11, 2, 2, 8, "#c8a86a", "bone"),
            box(-4, -4, -2, 2, 2, 3, "#6b5335", "feather"),
            box(3, -4, -2, 2, 2, 3, "#6b5335", "feather"),
        ], parent="body", anim="head"),
        part("wing_l", (-4, up(0.62), 0), [
            box(-2, 0, -5, 2, 7, 11, "#5d472d", "feather", face="feather"),
            box(-2, 4, -2, 2, 3, 8, "#4b3823", "feather"),
        ], parent="body", anim="wing"),
        part("wing_r", (4, up(0.62), 0), [
            box(0, 0, -5, 2, 7, 11, "#5d472d", "feather", face="feather"),
            box(0, 4, -2, 2, 3, 8, "#4b3823", "feather"),
        ], parent="body", anim="wing"),
        part("leg_l", (-2, up(0.3), 1), [
            box(-1, 0, -1, 2, 6, 2, "#a88450", "bone"),
            box(-2, 5, -2, 4, 1, 4, "#8d6d3f", "bone"),
        ], parent="body", anim="leg"),
        part("leg_r", (2, up(0.3), 1), [
            box(-1, 0, -1, 2, 6, 2, "#a88450", "bone"),
            box(-2, 5, -2, 4, 1, 4, "#8d6d3f", "bone"),
        ], parent="body", anim="leg"),
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
            box(-7, -6, -5, 14, 12, 10, "#8a6234", "planks", face="chest"),
            box(-7, -7, -5, 14, 3, 10, "#6b4a26", "wood"),
            box(-8, 4, -6, 16, 3, 12, "#5a3d1f", "wood"),
        ], anim="bob"),
        part("head", (0, up(0.85), 2), [
            box(-8, -3, -6, 16, 5, 12, "#966c3a", "planks", face="lid"),
            box(-2, 1, -7, 4, 3, 2, "#d9b45a", "metal"),
        ], parent="body", anim="jaw"),
        part("jaw", (0, up(0.5), -6), [
            box(-6, -2, -3, 12, 4, 4, "#2b1a10", "flesh"),
            box(-5, -1, -4, 2, 2, 1, "#f5f3ec", "bone"),
            box(-1, -1, -4, 2, 2, 1, "#f5f3ec", "bone"),
            box(3, -1, -4, 2, 2, 1, "#f5f3ec", "bone"),
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
        part("body", (0, up(0.95), 0), [
            box(-15, -7, -20, 30, 13, 40, "#4c5445", "milmetal", face="armor"),
            box(-16, 5, -21, 32, 4, 42, "#3c4337", "milmetal"),
            box(-17, -10, -22, 34, 6, 44, "#333a2e", "milmetal", face="tracks"),
            box(-17, -10, -22, 5, 14, 44, "#2b3126", "milmetal", face="tracks"),
            box(12, -10, -22, 5, 14, 44, "#2b3126", "milmetal", face="tracks"),
        ], anim="bob"),
        part("head", (0, up(1.45), 2), [
            box(-11, -9, -11, 22, 11, 22, "#525b4a", "milmetal", face="armor"),
            box(-8, -12, -8, 16, 4, 16, "#464e3f", "milmetal"),
            box(-2, -5, -20, 4, 4, 12, "#5c6552", "milmetal", face="deck"),
            box(-3, -6, -26, 6, 6, 7, "#3a4234", "milmetal", face="muzzle"),
            box(-1, -13, -2, 2, 3, 2, "#2f3529", "milmetal"),
        ], parent="body", anim="head"),
        part("arm_l", (-16, up(1.1), -14), [
            box(-3, 0, -3, 4, 8, 4, "#3c4337", "milmetal"),
        ], parent="body", anim="arm"),
        part("arm_r", (16, up(1.1), 6), [
            box(-1, 0, -1, 4, 6, 4, "#3c4337", "milmetal"),
        ], parent="body", anim="arm"),
    ],
}

# ---------------------------------------------------------------- 18. Siren Head
MOBS["siren_head"] = {
    "class": "SirenHeadModel", "shadow": 1.6, "height": 9.5,
    "parts": [
        part("body", (0, up(5.0), 0), [
            box(-6, -26, -6, 12, 54, 12, "#8e8471", "skin", face="ribs"),
            box(-8, -16, -8, 16, 5, 16, "#7d7462", "skin"),
            box(-8, 8, -8, 16, 5, 16, "#7d7462", "skin"),
            box(-7, 24, -7, 14, 6, 14, "#6f6757", "skin"),
            box(-3, -50, -3, 6, 25, 6, "#8e8471", "skin"),
        ], anim="bob"),
        part("head", (0, up(8.7), 0), [
            box(-7, -9, -7, 14, 18, 14, "#8e8471", "skin", face="panel"),
            box(-11, -7, -6, 4, 12, 12, "#6f6757", "metal", face="speaker"),
            box(7, -7, -6, 4, 12, 12, "#6f6757", "metal", face="speaker"),
            box(-3, -14, -3, 6, 6, 6, "#5f5849", "metal"),
            box(-2, 9, -2, 4, 3, 4, "#4c4639", "metal"),
        ], parent="body", anim="head"),
        part("arm_l", (-6, up(6.4), 0), [
            box(-2, 0, -2, 4, 26, 4, "#8e8471", "skin"),
            box(-2, 24, -2, 5, 20, 5, "#7d7462", "skin"),
            box(-2, 42, -2, 6, 7, 6, "#6f6757", "bone"),
        ], parent="body", rot=(0, 0, 5), anim="arm"),
        part("arm_r", (6, up(6.4), 0), [
            box(-2, 0, -2, 4, 26, 4, "#8e8471", "skin"),
            box(-2, 24, -2, 5, 20, 5, "#7d7462", "skin"),
            box(-2, 42, -2, 6, 7, 6, "#6f6757", "bone"),
        ], parent="body", rot=(0, 0, -5), anim="arm"),
        *leg("leg_l", -4, up(3.4), 0, 34, 25, 4, "#7d7462", "#5f5849", "skin"),
        *leg("leg_r", 4, up(3.4), 0, 34, 25, 4, "#7d7462", "#5f5849", "skin"),
    ],
}

# ---------------------------------------------------------------- 19. Warship
MOBS["warship"] = {
    "class": "WarshipModel", "shadow": 3.0, "height": 6.0,
    "parts": [
        part("body", (0, up(1.6), 0), [
            box(-16, -10, -46, 32, 20, 92, "#3d4650", "milmetal", face="hull"),
            box(-13, -16, -40, 26, 8, 80, "#333b44", "milmetal", face="hull"),
            box(-15, 10, -44, 30, 4, 88, "#4a545f", "milmetal", face="deck"),
        ], anim="bob"),
        part("head", (0, up(3.6), 6), [
            box(-10, -14, -12, 20, 15, 24, "#4a545f", "milmetal", face="bridge"),
            box(-7, -22, -8, 14, 8, 16, "#54606c", "milmetal"),
            box(-4, -26, -4, 8, 4, 8, "#3d4650", "milmetal"),
            box(-1, -32, -1, 2, 8, 2, "#2f363d", "milmetal"),
            box(-6, -30, -6, 12, 2, 12, "#5c6875", "milmetal", face="deck"),
        ], parent="body", anim="head"),
        part("arm_l", (-4, up(1.5), -26), [
            box(-6, -6, -6, 12, 10, 12, "#454f59", "milmetal", face="armor"),
            box(-2, -4, -16, 4, 4, 12, "#333b44", "milmetal"),
        ], parent="body", anim="arm"),
        part("arm_r", (4, up(1.5), -4), [
            box(-6, -6, -6, 12, 10, 12, "#454f59", "milmetal", face="armor"),
            box(-2, -4, -16, 4, 4, 12, "#333b44", "milmetal"),
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
            box(-7, -6, -5, 14, 16, 10, "#2a2f3c", "cloth", face="robe"),
            box(-8, 8, -6, 16, 5, 12, "#222633", "cloth"),
            box(-6, 13, -5, 12, 5, 10, "#1c2029", "cloth", face="robe"),
        ], anim="bob"),
        part("head", (0, up(2.35), 0), [
            box(-7, -7, -7, 14, 12, 14, "#161a22", "cloth", face="hood"),
            box(-5, -10, -5, 10, 4, 10, "#10131a", "cloth"),
        ], parent="body", anim="head"),
        part("orb", (0, 2, -4), [
            box(-4, -4, -4, 8, 8, 8, "#74c9ff", "lens", glow=True),
            box(-2, -6, -2, 4, 3, 4, "#bfe9ff", "lens", glow=True),
        ], parent="body", anim="eye"),
        part("arm_l", (-7, up(1.7), 0), [
            box(-2, 0, -2, 3, 16, 3, "#242a35", "cloth"),
            box(-2, 14, -2, 4, 10, 4, "#1c2029", "cloth"),
            box(-2, 22, -3, 3, 4, 5, "#8fb5cc", "bone"),
        ], parent="body", rot=(0, 0, 8), anim="arm"),
        part("arm_r", (7, up(1.7), 0), [
            box(-1, 0, -2, 3, 16, 3, "#242a35", "cloth"),
            box(-2, 14, -2, 4, 10, 4, "#1c2029", "cloth"),
            box(-1, 22, -3, 3, 4, 5, "#8fb5cc", "bone"),
        ], parent="body", rot=(0, 0, -8), anim="arm"),
        part("tentacle_0", (0, up(0.35), 2), [
            box(-4, 0, -3, 8, 6, 6, "#1c2029", "cloth"),
        ], parent="body", anim="tentacle"),
    ],
}

# ---------------------------------------------------------------- 25. Hollow Neighbour
MOBS["hollow_neighbor"] = {
    "class": "HollowNeighborModel", "shadow": 0.9, "height": 2.1,
    "parts": [
        part("body", (0, up(1.15), 0), [
            box(-7, -8, -4, 14, 19, 9, "#5a4a38", "cloth", face="robe"),
            box(-8, 8, -5, 16, 4, 11, "#4a3c2d", "cloth"),
            box(-9, 2, -5, 18, 4, 11, "#4a3c2d", "cloth"),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            box(-6, -6, -5, 12, 11, 10, "#6a5a48", "skin", face="faceless"),
            box(-2, 1, -8, 4, 6, 4, "#7d6c58", "skin"),
            box(-7, -7, -4, 14, 3, 9, "#3f3426", "cloth"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.6), 0), [
            box(-2, 0, -2, 3, 15, 3, "#5a4a38", "cloth"),
            box(-2, 13, -2, 4, 12, 4, "#6a5a48", "skin"),
            box(-3, 23, -3, 5, 4, 5, "#7d6c58", "skin"),
        ], parent="body", rot=(4, 0, 6), anim="arm"),
        part("arm_r", (8, up(1.6), 0), [
            box(-1, 0, -2, 3, 15, 3, "#5a4a38", "cloth"),
            box(-2, 13, -2, 4, 12, 4, "#6a5a48", "skin"),
            box(-2, 23, -3, 5, 4, 5, "#7d6c58", "skin"),
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

# --------------------------------------------------------------------- normalisation
def _relativize():
    """Spec files author every pivot in absolute model space; Minecraft wants nested
    pivots relative to their parent, so subtract the parent's absolute pivot once."""
    for spec in MOBS.values():
        authored = {p["name"]: tuple(p["pivot"]) for p in spec["parts"]}
        for p in spec["parts"]:
            parent = p.get("parent")
            if parent in authored:
                base = authored[parent]
                p["pivot"] = (authored[p["name"]][0] - base[0],
                              authored[p["name"]][1] - base[1],
                              authored[p["name"]][2] - base[2])


_relativize()
