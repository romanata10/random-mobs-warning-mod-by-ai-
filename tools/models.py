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


def rings(cx, cz, base_top, height, r0, r1, count, color, style="sand", curve=(0.0, 0.0),
          groove=None, face=None, pivot=0.0):
    """Stack of rounded, tapering rings — worm / tail / trunk bodies."""
    boxes = []
    step = height / float(max(1, count - 1)) if count > 1 else height
    for i in range(count):
        t = i / float(max(1, count - 1)) if count > 1 else 1.0
        top = base_top + height * t
        w = max(2, int(round((r0 + (r1 - r0) * t) * 2)))
        dx = int(round(curve[0] * t * t))
        dz = int(round(curve[1] * t * t))
        thick = max(2, int(round(step * 16)) + 1)
        col = color if (i % 2 == 0 or not groove) else groove
        y = up(top) - up(pivot)
        boxes.append(box(cx + dx - w // 2, y, cz + dz - w // 2, w, thick, w,
                         col, style, face=face))
        w2 = max(2, int(round(w * 0.72)))
        boxes.append(box(cx + dx - w2 // 2, y - 1, cz + dz - w2 // 2, w2, 2, w2,
                         col, style))
    return boxes


def blk(pivot_blocks, x, top_blocks, z, w, thick_blocks, d, color, style="noise",
        face=None, glow=False):
    """Box addressed by world height: `top_blocks` is where its top edge sits, and
    `thick_blocks` is its height. `pivot_blocks` is the pivot height of its part."""
    height = max(1, int(round(thick_blocks * 16)))
    y = int(round(up(top_blocks) - up(pivot_blocks)))
    return box(x, y, z, w, height, d, color, style, face=face, glow=glow)


# ------------------------------------------------------------------ detail helpers
def ridge(cx, cy, cz, length, out, thick, count, color, style="chitin", axis="z",
          taper=True, face=None):
    """A row of spines/fins/plates along an axis (back ridges, hull plating, antennae)."""
    boxes = []
    step = length / float(max(1, count))
    for i in range(count):
        k = 1.0
        if taper:
            k = 0.55 + 0.45 * (1.0 - abs(i - (count - 1) / 2.0) / max(1.0, count / 2.0))
        h = max(1, int(round(out * k)))
        t = max(1, int(round(thick * k)))
        pos = i * step
        if axis == "z":
            boxes.append(box(cx - t // 2, cy - h, cz + int(pos), t, h, max(1, int(step)),
                             color, style, face=face))
        elif axis == "x":
            boxes.append(box(cx + int(pos), cy - h, cz - t // 2, max(1, int(step)), h, t,
                             color, style, face=face))
        else:
            boxes.append(box(cx - t // 2, cy - h, cz + int(pos), t, max(1, int(step)), h,
                             color, style, face=face))
    return boxes


def teeth_row(cx, cy, cz, width, height, depth, count, color, style="bone", upper=True):
    """A row of triangular-ish teeth hanging from (upper) or standing on a jaw line."""
    boxes = []
    step = max(2, int(round(width / float(max(1, count)))))
    for i in range(count):
        h = max(1, height - (i % 2) - (1 if i in (0, count - 1) else 0))
        x = cx + i * (width - step) // max(1, count - 1) if count > 1 else cx
        y = cy if upper else cy - h
        boxes.append(box(int(x), int(y), cz, max(1, step - 1), h, depth, color, style))
    return boxes


def toes(cx, cy, cz, spread, length, thick, count, color, style="chitin", forward=True):
    """Splayed toes/claws at the end of a foot."""
    boxes = []
    for i in range(count):
        off = int(round((i - (count - 1) / 2.0) * spread))
        if forward:
            boxes.append(box(cx + off - thick // 2, cy, cz - length, thick, max(1, thick - 1),
                             length, color, style))
        else:
            boxes.append(box(cx + off - thick // 2, cy, cz, thick, max(1, thick - 1),
                             length, color, style))
    return boxes


def bolts(cx, cy, cz, along, count, size, color="#6f7378", style="metal", axis="x"):
    """Evenly spaced rivets along one edge."""
    boxes = []
    step = along / float(max(1, count))
    for i in range(count):
        p = int(round(i * step))
        if axis == "x":
            boxes.append(box(cx + p, cy, cz, size, size, size, color, style))
        elif axis == "y":
            boxes.append(box(cx, cy + p, cz, size, size, size, color, style))
        else:
            boxes.append(box(cx, cy, cz + p, size, size, size, color, style))
    return boxes


def hose(cx, cy, cz, length, size, color, style="metal", axis="y", segments=4, sag=0.0):
    """A cable/pipe split into segments so it can bend with the body."""
    boxes = []
    step = length / float(max(1, segments))
    for i in range(segments):
        off = sag * math.sin(math.pi * i / max(1, segments - 1))
        if axis == "y":
            boxes.append(box(cx + off, cy + int(i * step), cz, size, int(step) + 1, size, color, style))
        else:
            boxes.append(box(cx, cy + int(off), cz + int(i * step), size, size, int(step) + 1,
                             color, style))
    return boxes


GROUND = 24.0


def _leg(name, hip, knee, foot, thick, upper_color, lower_color, style, anim, claw):
    """Two-segment leg. Each segment is built from a few tapered blocks so limbs read
    as bone/flesh instead of a single stick, and a joint ball hides the seam."""
    up_len = max(1.0, _len(_sub(knee, hip)))
    low_len = max(1.0, _len(_sub(foot, knee)))
    thigh_rot = aim(_sub(knee, hip))
    shin_rot = aim_local(thigh_rot, _sub(foot, knee))
    t = max(2, int(thick))
    head_w = t + 2
    parts = [
        part(name, hip, [
            # hip socket
            box(-head_w // 2, 0, -head_w // 2, head_w, max(2, up_len * 0.16), head_w,
                upper_color, style),
            # upper segment tapering towards the knee
            box(-t // 2, up_len * 0.12, -t // 2, t, max(2, up_len * 0.5), t, upper_color, style),
            box(-t // 2 + 1, up_len * 0.58, -t // 2 + 1, max(1, t - 2), max(2, up_len * 0.3),
                max(1, t - 2), upper_color, style),
            # knee ball
            box(-(t + 1) // 2, up_len - max(2, t), -(t + 1) // 2, t + 1, max(2, t), t + 1,
                lower_color, style),
        ], rot=thigh_rot, anim=anim),
        part(name + "_low", (knee[0], knee[1], knee[2]), [
            box(-t // 2, 0, -t // 2, t, max(2, low_len * 0.45), t, lower_color, style),
            box(-t // 2 + 1, low_len * 0.4, -t // 2 + 1, max(1, t - 2), max(2, low_len * 0.4),
                max(1, t - 2), lower_color, style),
            box(-t // 2 + 1, low_len - max(2, t), -t // 2 + 1, max(1, t - 2), max(2, t),
                max(1, t - 2), lower_color, style),
        ] + ([
            box(-2, low_len - 3, -3, 4, 3, 6, lower_color, "bone"),
            box(-3, low_len, -3, 2, 3, 4, lower_color, "bone"),
            box(1, low_len, -3, 2, 3, 4, lower_color, "bone"),
        ] if claw else []),
            parent=name, rot=shin_rot, anim=anim + "_low"),
    ]
    return parts


def leg(name, x, y, z, upper, lower, thick, upper_color, lower_color, style="chitin",
        out=0.0, spread=0.0, anim="leg", claw=True):
    """Knee-bent two segment leg: it keeps the authored lengths, only adds a knee."""
    side = -1.0 if x < 0 else 1.0
    reach = max(1.0, thick * 0.55) + abs(out)
    # the knee always stays above the ground plane, and the shin lands on it
    knee = (x + side * reach, min(y + upper * 0.9, GROUND - max(3.0, lower * 0.7)),
            z + spread * 0.5)
    foot = (x + side * (reach + max(1.0, thick * 0.45)), GROUND, z + spread)
    return _leg(name, (x, y, z), knee, foot, thick, upper_color, lower_color, style, anim, claw)


def spider_legs(prefix, pivot_y, radius_x, radius_z, upper, lower, thick,
                upper_color, lower_color, style="chitin", anim="leg", knee_lift=0.0,
                z_shift=0.0):
    """Eight harvestman legs: they rise to a high knee, then fold out and down."""
    parts = []
    for side, sx in (("l", -1), ("r", 1)):
        for i, (ang, zoff) in enumerate(((-40, -5), (-17, -2), (17, 2), (40, 5))):
            x = sx * radius_x
            z = zoff * (radius_z / 5.0) + z_shift
            name = "%s_%s%d" % (prefix, side, i)
            hip = (x, pivot_y, z)
            knee = (x + sx * (radius_x * 1.05 + 3), pivot_y - max(1.0, knee_lift),
                    z + zoff * 1.1)
            foot = (x + sx * (radius_x * 2.2 + 8), GROUND, z + zoff * 2.4)
            parts += _leg(name, hip, knee, foot, thick, upper_color, lower_color, style, anim, True)
    return parts


"""Model specifications for every Random Mobs creature (v4 - full rebuild).

Coordinate system matches vanilla entity models: 16 units = 1 block, +Y points DOWN,
the model origin sits 1.5 blocks above the ground, -Z is where the mob is looking.

Every pivot is authored in ABSOLUTE model space; `_relativize()` in models.py turns the
nested ones into parent-relative offsets that Minecraft expects.
"""
import math

MOBS = {}


def up(blocks):
    """Model-space y of a height given in blocks above the feet."""
    return GROUND - blocks * 16.0


# ------------------------------------------------------------------------- 1. Tripod
MOBS["tripod"] = {
    "class": "TripodModel", "shadow": 2.2, "height": 6.4,
    "parts": [
        part("body", (0, up(4.05), 0), [
            blk(4.05, -11, 4.65, -11, 22, 1.2, 22, "#5b6470", "metal", face="panel"),
            blk(4.05, -9, 3.75, -9, 18, 0.5, 18, "#49515b", "metal"),
            blk(4.05, -8, 3.35, -7, 16, 0.4, 14, "#3f464f", "metal", face="vent"),
            blk(4.05, -13, 4.0, -7, 26, 0.28, 14, "#6d7683", "metal"),
            blk(4.05, -12, 4.25, -5, 24, 0.18, 10, "#7b8693", "metal"),
            # shoulder armour
            blk(4.05, -13, 4.55, -6, 4, 0.7, 12, "#525b66", "metal", face="armor"),
            blk(4.05, 9, 4.55, -6, 4, 0.7, 12, "#525b66", "metal", face="armor"),
            # dorsal vents + cables
            *ridge(-9, 0, -9, 18, 3, 2, 6, "#4b535d", "metal", axis="x"),
            *bolts(-10, -3, -10, 20, 4, 2, "#8b95a2", "metal"),
            *hose(-13, 1, -9, 10, 2, "#2f343b", "metal", axis="y", segments=4, sag=2),
            # core light
            blk(4.05, -3, 4.0, -12, 6, 0.3, 2, "#8ef7c8", "lens", glow=True),
            blk(4.05, -4, 4.2, -12, 8, 0.1, 1, "#2b323a", "metal"),
        ], anim="bob"),
        part("head", (0, up(5.25), 0), [
            blk(5.25, -8, 6.05, -9, 16, 1.0, 17, "#6f7a86", "metal", face="panel"),
            blk(5.25, -9, 5.55, -7, 18, 0.5, 13, "#5b6470", "metal"),
            blk(5.25, -5, 5.75, -12, 10, 0.45, 3, "#1e242b", "metal", face="visor"),
            blk(5.25, -2, 5.4, -12, 4, 0.3, 2, "#8ef7c8", "lens", glow=True),
            blk(5.25, -9, 6.0, -6, 2, 0.5, 10, "#5b6673", "metal"),
            blk(5.25, 7, 6.0, -6, 2, 0.5, 10, "#5b6673", "metal"),
            # radar + antennae
            blk(5.25, -4, 6.5, 2, 8, 0.18, 6, "#7b8693", "metal", face="radar"),
            blk(5.25, -1, 6.6, 3, 2, 0.6, 2, "#3b424b", "metal"),
            blk(5.25, 4, 6.5, -7, 1, 1.0, 1, "#4b535d", "metal"),
            blk(5.25, -5, 6.5, -7, 1, 1.0, 1, "#4b535d", "metal"),
            *teeth_row(-4, 9, -12, 8, 3, 2, 4, "#9aa5b1", "metal"),
        ], parent="body", anim="head"),
        part("eye", (0, up(5.7), -13), [
            blk(5.7, -4, 6.0, -1, 8, 0.3, 2, "#ffe98a", "lens", glow=True),
            blk(5.7, -2, 6.02, -2, 4, 0.16, 1, "#7a5c10", "lens"),
        ], parent="head", anim="eye"),
        *leg("leg_a", -10, up(3.4), 8, 30, 26, 7, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_b", 10, up(3.4), 8, 30, 26, 7, "#4b535d", "#3a414a", "metal", anim="leg"),
        *leg("leg_c", 0, up(3.4), -10, 30, 26, 7, "#4b535d", "#3a414a", "metal", anim="leg"),
        part("arm_l", (-13, up(3.6), -2), [
            blk(3.6, -2, 3.6, -2, 4, 0.8, 4, "#5b6470", "metal"),
            blk(3.6, -3, 2.9, -3, 5, 0.7, 5, "#4b535d", "metal"),
            blk(3.6, -3, 2.75, -4, 6, 0.3, 6, "#2f343b", "metal", face="claw"),
            *ridge(-3, 12, -4, 6, 2, 2, 3, "#7b8693", "metal", axis="x"),
        ], parent="body", rot=(0, 0, 6), anim="arm"),
        part("arm_r", (13, up(3.6), -2), [
            blk(3.6, -2, 3.6, -2, 4, 0.8, 4, "#5b6470", "metal"),
            blk(3.6, -2, 2.9, -3, 5, 0.7, 5, "#4b535d", "metal"),
            blk(3.6, -3, 2.75, -4, 6, 0.3, 6, "#2f343b", "metal", face="claw"),
            *ridge(-3, 12, -4, 6, 2, 2, 3, "#7b8693", "metal", axis="x"),
        ], parent="body", rot=(0, 0, -6), anim="arm"),
    ],
}

# --------------------------------------------------------------------- 2. Woodcrawler
MOBS["woodcrawler"] = {
    "class": "WoodcrawlerModel", "shadow": 0.9, "height": 2.0,
    "parts": [
        part("body", (0, up(1.45), 0), [
            # cephalothorax — layered bark plates
            blk(1.45, -7, 1.6, -8, 14, 0.34, 11, "#7d5d3c", "chitin", face="plates"),
            blk(1.45, -6, 1.32, -7, 12, 0.3, 9, "#67492d", "chitin"),
            blk(1.45, -4, 1.08, -6, 8, 0.26, 7, "#523a25", "chitin"),
            # abdomen: bigger, behind the shoulders
            blk(1.45, -8, 1.52, 2, 16, 0.42, 15, "#6f5235", "chitin", face="plates"),
            blk(1.45, -7, 1.18, 3, 14, 0.34, 13, "#5b4129", "chitin"),
            blk(1.45, -5, 0.94, 5, 10, 0.28, 10, "#48331f", "chitin"),
            blk(1.45, -3, 1.64, 6, 6, 0.2, 7, "#94714a", "chitin", face="knots"),
            # spine ridge along the back
            *ridge(-6, 0, 3, 12, 3, 3, 4, "#9a7850", "chitin", axis="z"),
            # leg sockets
            *bolts(-8, -1, -3, 16, 4, 2, "#8d6c46", "chitin"),
        ], anim="bob"),
        part("head", (0, up(1.45), -8), [
            blk(1.45, -6, 1.52, -4, 12, 0.32, 7, "#7d5d3c", "chitin", face="skull"),
            blk(1.45, -5, 1.26, -1, 10, 0.24, 6, "#4a3520", "chitin", face="jaw"),
            *[blk(1.45, ex, 1.58, -3, 2, 0.1, 2, "#d8ff9a", "lens", glow=True)
              for ex in (-4, -1, 1, 4)],
            *[blk(1.45, ex, 1.38, -2, 1, 0.08, 1, "#d8ff9a", "lens", glow=True)
              for ex in (-3, 3)],
            blk(1.45, -3, 1.22, -5, 2, 0.24, 3, "#d9d0b8", "bone"),
            blk(1.45, 1, 1.22, -5, 2, 0.24, 3, "#d9d0b8", "bone"),
            blk(1.45, -6, 1.2, -4, 2, 0.2, 4, "#67492d", "chitin"),
            blk(1.45, 4, 1.2, -4, 2, 0.2, 4, "#67492d", "chitin"),
        ], parent="body", anim="head"),
        *spider_legs("leg", up(1.1), 7, 8, 12, 16, 5, "#6f5235", "#43301f", "chitin",
                     knee_lift=11),
    ],
}
# ------------------------------------------------------------------------- 3. Bloop
MOBS["bloop"] = {
    "class": "BloopModel", "shadow": 3.4, "height": 4.2,
    "parts": [
        part("body", (0, up(2.4), 0), [
            blk(2.4, -20, 3.45, -19, 40, 0.9, 38, "#12303f", "wet"),
            blk(2.4, -22, 2.95, -17, 44, 0.5, 34, "#0e2733", "wet"),
            blk(2.4, -18, 2.5, -16, 36, 0.5, 32, "#143a4c", "wet"),
            blk(2.4, -14, 2.05, -13, 28, 0.5, 26, "#173f52", "wet"),
            blk(2.4, -19, 3.4, -18, 38, 0.2, 36, "#1d4c61", "wet"),
            # dorsal fin
            *ridge(-12, 4, -6, 24, 5, 3, 5, "#1d4c61", "wet", axis="x"),
            *bolts(-18, 4, -18, 36, 5, 2, "#1a4457", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.2), -13), [
            blk(3.2, -12, 3.85, -8, 24, 0.65, 16, "#1a4457", "wet", face="maw"),
            blk(3.2, -10, 2.95, -9, 20, 0.5, 15, "#0a1c24", "wet", face="teeth"),
            *teeth_row(-9, 0, -9, 18, 4, 2, 6, "#e8e2cf", "bone"),
            *teeth_row(-9, 11, -9, 18, 4, 2, 5, "#e8e2cf", "bone", upper=False),
            *ridge(-10, 13, -8, 20, 6, 2, 5, "#12303f", "wet", axis="x"),
        ], parent="body", anim="head"),
        part("eye", (0, up(3.5), -21), [
            blk(3.5, -6, 3.76, -1, 12, 0.26, 2, "#2fd6c9", "lens", glow=True),
            blk(3.5, -3, 3.8, -2, 6, 0.16, 1, "#06131a", "lens"),
        ], parent="head", anim="eye"),
        *[part("tentacle_%d" % i, (-14 + i * 7, up(1.9), -4 + (i % 3) * 5), [
            blk(1.9, -3, 1.9, -3, 6, 0.5, 6, "#12303f", "wet", face="suckers"),
            blk(1.9, -2, 1.2, -2, 5, 0.4, 5, "#143a4c", "wet"),
            blk(1.9, -2, 0.55, -2, 4, 0.4, 4, "#1a4457", "wet"),
            blk(1.9, -3, 0.1, -3, 6, 0.2, 6, "#0e2733", "wet"),
        ], parent="body", rot=(0, 0, -10 + i * 5), anim="tentacle") for i in range(5)],
    ],
}

# ------------------------------------------------------------------- 4. Alive House
MOBS["alive_house"] = {
    "class": "AliveHouseModel", "shadow": 2.4, "height": 4.5,
    "parts": [
        part("body", (0, up(2.4), 0), [
            # walls
            blk(2.4, -16, 3.0, -14, 32, 1.5, 28, "#c9b48e", "planks", face="wall"),
            blk(2.4, -17, 3.05, -15, 34, 0.12, 30, "#6b5539", "wood"),
            # roof: two slanted slabs
            blk(2.4, -18, 3.6, -16, 36, 0.35, 14, "#8a4b34", "wood", face="roof"),
            blk(2.4, -18, 3.6, 2, 36, 0.35, 14, "#8a4b34", "wood", face="roof"),
            blk(2.4, -12, 4.05, -12, 24, 0.35, 24, "#9c5638", "wood", face="roof"),
            blk(2.4, -6, 4.35, -6, 12, 0.25, 12, "#8a4b34", "wood"),
            # chimney + porch + windows
            blk(2.4, 7, 4.5, 5, 5, 0.9, 5, "#7d6650", "bone"),
            blk(2.4, -18, 1.6, -6, 4, 0.4, 12, "#8a6b45", "wood"),
            *[blk(2.4, -14, 2.55, -15, 6, 0.5, 1, "#3c4a52", "lens", face="window")],
            *[blk(2.4, x, 2.55, -15, 5, 0.5, 1, "#3c4a52", "lens", face="window")
              for x in (3, 10)],
            blk(2.4, -3, 2.3, -16, 6, 0.9, 1, "#6b4a26", "planks", face="door"),
            *bolts(-16, 0, -15, 32, 5, 2, "#8a6b45", "wood"),
        ], anim="bob"),
        part("head", (0, up(1.9), -15), [
            blk(1.9, -8, 3.05, -2, 16, 1.1, 3, "#c9b48e", "planks", face="face"),
            blk(1.9, -3, 2.0, -3, 6, 0.3, 2, "#6b4a26", "wood", face="teeth"),
        ], parent="body", anim="head"),
        part("eye_l", (-5, up(2.6), -17), [
            blk(2.6, -2, 2.8, -1, 4, 0.16, 1, "#ffd76a", "lens", glow=True),
        ], parent="body", anim="eye"),
        part("eye_r", (5, up(2.6), -17), [
            blk(2.6, -2, 2.8, -1, 4, 0.16, 1, "#ffd76a", "lens", glow=True),
        ], parent="body", anim="eye"),
        *leg("leg_0", -10, up(1.7), -9, 14, 12, 5, "#8a6b45", "#5f4728", "wood"),
        *leg("leg_1", 10, up(1.7), -9, 14, 12, 5, "#8a6b45", "#5f4728", "wood"),
        *leg("leg_2", -10, up(1.7), 9, 14, 12, 5, "#8a6b45", "#5f4728", "wood"),
        *leg("leg_3", 10, up(1.7), 9, 14, 12, 5, "#8a6b45", "#5f4728", "wood"),
    ],
}

# ------------------------------------------------------------------- 5. Giant Spider
MOBS["giant_spider"] = {
    "class": "GiantSpiderModel", "shadow": 1.8, "height": 2.2,
    "parts": [
        part("body", (0, up(1.5), 0), [
            # chunky abdomen
            blk(1.5, -11, 1.58, 1, 22, 0.46, 16, "#5f4a33", "chitin", face="plates"),
            blk(1.5, -10, 1.22, 2, 20, 0.36, 14, "#4d3a27", "chitin"),
            blk(1.5, -8, 0.92, 3, 16, 0.3, 12, "#3e2e1f", "chitin"),
            # cephalothorax
            blk(1.5, -9, 1.4, -9, 18, 0.38, 11, "#54402c", "chitin", face="chest"),
            blk(1.5, -7, 1.16, -8, 14, 0.3, 9, "#42321f", "chitin"),
            *ridge(-8, 0, 3, 14, 3, 3, 5, "#75593c", "chitin", axis="z"),
            *bolts(-9, 0, -2, 18, 5, 2, "#75593c", "chitin"),
        ], anim="bob"),
        part("head", (0, up(1.5), -9), [
            blk(1.5, -7, 1.42, -5, 14, 0.36, 7, "#5f4a33", "chitin", face="spider"),
            blk(1.5, -5, 1.14, -2, 10, 0.26, 5, "#3e2e1f", "chitin", face="jaw"),
            *[blk(1.5, ex, 1.48, -5, 2, 0.1, 2, "#d8ff9a", "lens", glow=True)
              for ex in (-5, -2, 2, 5)],
            *[blk(1.5, ex, 1.3, -4, 1, 0.08, 1, "#d8ff9a", "lens", glow=True)
              for ex in (-3, 3)],
            blk(1.5, -4, 1.1, -6, 2, 0.26, 3, "#ddd4bd", "bone"),
            blk(1.5, 2, 1.1, -6, 2, 0.26, 3, "#ddd4bd", "bone"),
        ], parent="body", anim="head"),
        *spider_legs("leg", up(1.1), 9, 9, 13, 16, 6, "#5f4a33", "#3a2c1d", "chitin",
                     knee_lift=10),
    ],
}
# ---------------------------------------------------------------------- 6. Gardener
MOBS["gardener"] = {
    "class": "GardenerModel", "shadow": 1.2, "height": 3.2,
    "parts": [
        part("body", (0, up(1.5), 0), [
            blk(1.5, -7, 2.15, -5, 14, 1.25, 10, "#2a2622", "cloth", face="robe"),
            blk(1.5, -9, 1.2, -6, 18, 0.4, 12, "#221e1b", "cloth"),
            blk(1.5, -8, 0.85, -6, 16, 0.4, 12, "#1d1a18", "cloth"),
            blk(1.5, -6, 0.55, -5, 12, 0.4, 10, "#191613", "cloth", face="robe"),
            *ridge(-7, 0, -5, 14, 3, 2, 5, "#26221e", "cloth", axis="x", taper=False),
            *ridge(-6, 8, -4, 12, 3, 2, 4, "#211d1a", "cloth", axis="x", taper=False),
            blk(1.5, -8, 1.25, -6, 16, 0.16, 12, "#3a332c", "cloth"),
            blk(1.5, 4, 1.2, -7, 3, 0.28, 2, "#8f8b80", "metal"),
        ], anim="bob"),
        part("head", (0, up(2.35), 0), [
            blk(2.35, -6, 2.72, -6, 12, 0.55, 12, "#14120f", "cloth", face="hood"),
            blk(2.35, -7, 2.34, -7, 14, 0.32, 14, "#100e0c", "cloth"),
            blk(2.35, -5, 2.2, -8, 10, 0.2, 3, "#0b0a09", "cloth"),
            blk(2.35, -4, 2.4, -8, 2, 0.1, 1, "#a8d8ff", "lens", glow=True),
            blk(2.35, 2, 2.4, -8, 2, 0.1, 1, "#a8d8ff", "lens", glow=True),
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

# -------------------------------------------------------------------- 7. Sand Worm
MOBS["sand_worm"] = {
    "class": "SandWormModel", "shadow": 2.0, "height": 2.2,
    "parts": [
        part("body", (0, up(2.2), 0), [
            # the sand it throws up while breaking the surface
            blk(2.2, -15, 0.2, -15, 30, 0.12, 30, "#756030", "sand"),
            blk(2.2, -13, 0.3, -13, 26, 0.12, 26, "#8b7440", "sand"),
            blk(2.2, -11, 0.4, -11, 22, 0.12, 22, "#9b8149", "sand"),
            # thick neck
            *rings(0, -1, 0.36, 0.95, 9.5, 8.6, 6, "#ab8f52", "sand", curve=(0, -1),
                   groove="#8f7841", face="segments", pivot=2.2),
            # collar of bone spikes around the neck
            *[box(int(round(10.2 * math.cos(a))) - 1, int(up(0.95)) - int(up(2.2)) - 3,
                  int(round(10.2 * math.sin(a))) - 1 - 1, 2, 4, 2, "#efe2bd", "bone")
              for a in [k * math.pi / 5.0 for k in range(10)]],
        ], anim="bob"),
        part("head", (0, up(1.42), -6), [
            # lamprey maw facing the player
            box(-8, -7, -2, 16, 15, 3, "#c3a86f", "sand", face="maw"),
            box(-9, -8, -1, 18, 17, 1, "#dcc79a", "sand"),
            # gullet
            box(-5, -4, -6, 10, 9, 5, "#5a3722", "flesh"),
            box(-3, -2, -7, 6, 5, 3, "#241410", "flesh"),
            # ring of teeth
            *[box(int(round(6.0 * math.cos(a))) - 1, int(round(6.0 * math.sin(a))) - 1,
                  -4, 2, 2, 4, "#f4ecd2", "bone")
              for a in [k * math.pi / 6.0 for k in range(12)]],
        ], parent="body", anim="head"),
        *[part("fin_%d" % i, (-9 + i * 6, up(0.7), 3), [
            blk(0.7, -1, 0.95, -1, 2, 0.3, 7, "#e0cba0", "bone"),
        ], parent="body", rot=(0, 0, -30 + i * 20), anim="tentacle") for i in range(3)],
    ],
}
# -------------------------------------------------------------------------- 8. UFO
MOBS["ufo"] = {
    "class": "UfoModel", "shadow": 1.4, "height": 2.0,
    "parts": [
        part("body", (0, up(0.9), 0), [
            blk(0.9, -24, 0.95, -24, 48, 0.22, 48, "#6b747b", "metal", face="lights"),
            blk(0.9, -19, 1.08, -19, 38, 0.18, 38, "#7d878f", "metal"),
            blk(0.9, -13, 1.22, -13, 26, 0.2, 26, "#8f99a1", "metal", face="panel"),
            blk(0.9, -8, 0.8, -8, 16, 0.28, 16, "#525a60", "metal"),
            blk(0.9, -6, 0.58, -6, 12, 0.24, 12, "#464e54", "metal"),
            *[blk(0.9, -2, 1.0, z, 4, 0.12, 3, "#8ef7c8", "lens", glow=True)
              for z in (-22, -11, 11, 22)],
            *[blk(0.9, x, 1.0, -2, 3, 0.12, 4, "#8ef7c8", "lens", glow=True)
              for x in (-22, -11, 11, 22)],
            *ridge(-20, 0, -20, 40, 3, 2, 7, "#5b656c", "metal", axis="x"),
            *bolts(-18, 2, -18, 36, 6, 1, "#9aa5b0", "metal"),
        ], anim="bob"),
        part("head", (0, up(1.4), 0), [
            blk(1.4, -9, 1.52, -9, 18, 0.2, 18, "#9aa4ac", "metal"),
            blk(1.4, -7, 1.68, -7, 14, 0.22, 14, "#b6c0c7", "metal", face="dome"),
            blk(1.4, -4, 1.82, -4, 8, 0.18, 8, "#8ef7c8", "lens", glow=True),
            blk(1.4, -1, 2.0, -1, 2, 0.2, 2, "#6b747b", "metal"),
        ], parent="body", anim="head"),
        *[part("strut_%d" % i, (0, up(0.5), 0), [
            blk(0.5, -8, 0.5, -1, 2, 0.42, 2, "#4b535a", "metal"),
        ], parent="body", rot=(0, 120 * i, 0), anim="leg") for i in range(3)],
        part("beam", (0, up(0.34), 0), [
            blk(0.34, -9, 0.32, -9, 18, 0.08, 18, "#9be3ff", "lens", glow=True),
        ], parent="body", anim="eye"),
    ],
}

# -------------------------------------------------------------------------- 9. Bear
MOBS["bear"] = {
    "class": "BearModel", "shadow": 1.0, "height": 1.8,
    "parts": [
        part("body", (0, up(0.95), 0), [
            blk(0.95, -10, 1.32, -14, 20, 0.95, 28, "#503a26", "fur"),
            blk(0.95, -9, 0.88, -13, 18, 0.45, 26, "#42301f", "fur"),
            blk(0.95, -7, 0.62, 8, 14, 0.3, 8, "#3f2c1e", "fur"),
            # shoulder hump + fur tufts
            blk(0.95, -8, 1.6, -10, 16, 0.32, 11, "#5a4129", "fur"),
            *ridge(-9, 0, -12, 24, 3, 2, 7, "#463222", "fur", axis="x"),
            *ridge(-7, 8, -8, 20, 2, 2, 5, "#5a4129", "fur", axis="x"),
            blk(0.95, -2, 1.0, 14, 4, 0.25, 3, "#3f2c1e", "fur"),
        ], anim="bob"),
        part("head", (0, up(1.25), -15), [
            blk(1.25, -7, 1.5, -7, 14, 0.75, 13, "#573f29", "fur", face="bear"),
            blk(1.25, -3, 1.3, -10, 6, 0.3, 4, "#b09a7c", "fur", face="snout"),
            blk(1.25, -2, 1.27, -11, 4, 0.14, 2, "#241a12", "fur"),
            blk(1.25, -9, 1.55, -3, 4, 0.28, 5, "#4a3421", "fur"),
            blk(1.25, 5, 1.55, -3, 4, 0.28, 5, "#4a3421", "fur"),
            blk(1.25, -8, 1.44, -2, 3, 0.18, 3, "#6b5138", "fur"),
            blk(1.25, 5, 1.44, -2, 3, 0.18, 3, "#6b5138", "fur"),
            *teeth_row(-2, 4, -11, 4, 2, 2, 3, "#f0ead8", "bone"),
            blk(1.25, -5, 1.46, -8, 2, 0.08, 1, "#e8c46a", "lens", glow=True),
            blk(1.25, 3, 1.46, -8, 2, 0.08, 1, "#e8c46a", "lens", glow=True),
        ], parent="body", anim="head"),
        *leg("leg_0", -7, up(0.8), -9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_1", 7, up(0.8), -9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_2", -7, up(0.8), 9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
        *leg("leg_3", 7, up(0.8), 9, 10, 8, 5, "#4a3421", "#33241a", "fur"),
    ],
}

# ------------------------------------------------------------------------ 10. Kraken
MOBS["kraken"] = {
    "class": "KrakenModel", "shadow": 2.6, "height": 4.2,
    "parts": [
        part("body", (0, up(2.6), 4), [
            blk(2.6, -16, 3.35, -16, 32, 1.6, 30, "#2a1a3a", "wet"),
            blk(2.6, -18, 2.35, -14, 36, 0.7, 26, "#22152f", "wet"),
            blk(2.6, -13, 1.75, -12, 26, 0.55, 22, "#322049", "wet"),
            *ridge(-14, 6, -12, 28, 4, 3, 5, "#3a2454", "wet", axis="x"),
            *bolts(-15, 20, -15, 30, 4, 2, "#4a3266", "wet"),
            blk(2.6, -17, 2.9, -2, 3, 0.35, 10, "#4a3266", "wet"),
            blk(2.6, 14, 2.9, -2, 3, 0.35, 10, "#4a3266", "wet"),
        ], anim="bob"),
        part("head", (0, up(3.0), -12), [
            blk(3.0, -14, 3.85, -12, 28, 1.4, 22, "#35244a", "wet", face="maw"),
            blk(3.0, -11, 2.6, -11, 22, 0.45, 18, "#1d1230", "wet", face="teeth"),
            blk(3.0, -6, 4.05, -6, 12, 0.22, 12, "#4a3266", "wet"),
            *teeth_row(-10, 8, -12, 20, 5, 2, 6, "#eee7d2", "bone"),
            *teeth_row(-10, 12, -12, 20, 5, 2, 5, "#eee7d2", "bone", upper=False),
            *ridge(-11, 14, -11, 22, 4, 2, 5, "#2a1a3a", "wet", axis="x"),
        ], parent="body", anim="head"),
        part("eye_l", (-7, up(3.6), -23), [
            blk(3.6, -4, 3.9, -1, 8, 0.26, 2, "#f2d15a", "lens", glow=True),
            blk(3.6, -1, 3.92, -2, 2, 0.16, 1, "#4a3a10", "lens"),
        ], parent="body", anim="eye"),
        part("eye_r", (7, up(3.6), -23), [
            blk(3.6, -4, 3.9, -1, 8, 0.26, 2, "#f2d15a", "lens", glow=True),
            blk(3.6, -1, 3.92, -2, 2, 0.16, 1, "#4a3a10", "lens"),
        ], parent="body", anim="eye"),
        *[part("tentacle_%d" % i, (-12 + i * 4, up(1.4), -6 + (i // 3) * 12), [
            blk(1.4, -3, 1.4, -3, 6, 0.45, 6, "#2a1a3a", "wet", face="suckers"),
            blk(1.4, -2, 0.85, -2, 4, 0.45, 4, "#35244a", "wet"),
            blk(1.4, -2, 0.32, -2, 3, 0.4, 3, "#3f2a5c", "wet"),
            blk(1.4, -4, 0.06, -4, 8, 0.16, 8, "#4a3266", "wet"),
        ], parent="body", rot=(0, 0, -18 + i * 6), anim="tentacle") for i in range(7)],
    ],
}

# ---------------------------------------------------------------- 11. Evil Watermelon
MOBS["evil_watermelon"] = {
    "class": "EvilWatermelonModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.45), 0), [
            blk(0.45, -7, 0.72, -7, 14, 0.5, 14, "#2f5c1f", "melon", face="melon"),
            blk(0.45, -6, 0.28, -6, 12, 0.28, 12, "#27491a", "melon"),
            blk(0.45, -7, 0.76, -6, 14, 0.12, 12, "#3d7228", "melon"),
            *ridge(-5, 0, -1, 10, 3, 2, 4, "#4a6b2a", "leaves", axis="x"),
            blk(0.45, -1, 1.0, -1, 2, 0.28, 2, "#4a6b2a", "leaves"),
        ], anim="bob"),
        part("head", (0, up(0.62), -7), [
            blk(0.62, -6, 0.92, -1, 12, 0.34, 3, "#2f5c1f", "melon", face="scream"),
            blk(0.62, -4, 0.77, -2, 3, 0.12, 1, "#ff3b3b", "lens", glow=True),
            blk(0.62, 1, 0.77, -2, 3, 0.12, 1, "#ff3b3b", "lens", glow=True),
            *teeth_row(-4, -2, -2, 8, 2, 1, 4, "#e8f0d0", "bone"),
        ], parent="body", anim="head"),
        *leg("leg_0", -5, up(0.3), -4, 6, 4, 3, "#26431a", "#1b3013", "bark"),
        *leg("leg_1", 5, up(0.3), -4, 6, 4, 3, "#26431a", "#1b3013", "bark"),
        *leg("leg_2", -5, up(0.3), 4, 6, 4, 3, "#26431a", "#1b3013", "bark"),
        *leg("leg_3", 5, up(0.3), 4, 6, 4, 3, "#26431a", "#1b3013", "bark"),
    ],
}

# -------------------------------------------------------------------- 12. Alive Tree
MOBS["alive_tree"] = {
    "class": "AliveTreeModel", "shadow": 2.6, "height": 4.6,
    "parts": [
        part("body", (0, up(1.9), 0), [
            blk(1.9, -7, 3.5, -6, 14, 2.9, 12, "#6b4a2a", "bark", face="tree"),
            blk(1.9, -9, 0.9, -7, 18, 0.7, 14, "#5a3d22", "bark"),
            blk(1.9, -5, 3.55, -4, 10, 0.2, 8, "#7d5a34", "bark"),
            # roots
            *ridge(-8, 0, -7, 16, 4, 3, 4, "#4e331c", "bark", axis="x"),
            *bolts(-6, -4, -5, 12, 3, 2, "#8a6a45", "bark"),
        ], anim="bob"),
        part("head", (0, up(3.2), -1), [
            blk(3.2, -8, 4.15, -7, 16, 1.0, 14, "#7d5a34", "bark", face="treant"),
            blk(3.2, -6, 3.6, -8, 12, 0.5, 4, "#3a2a18", "bark"),
            blk(3.2, -5, 4.05, -8, 2, 0.12, 1, "#ffd76a", "lens", glow=True),
            blk(3.2, 3, 4.05, -8, 2, 0.12, 1, "#ffd76a", "lens", glow=True),
            *teeth_row(-4, 3, -8, 8, 2, 1, 4, "#e8dcc0", "bone"),
        ], parent="body", anim="head"),
        part("crown", (0, up(4.0), 0), [
            blk(4.0, -9, 4.5, -9, 18, 0.6, 18, "#3f6b2a", "leaves"),
            blk(4.0, -6, 4.6, -6, 12, 0.4, 12, "#4c7f33", "leaves"),
            *ridge(-7, 0, -7, 14, 3, 3, 4, "#4c7f33", "leaves", axis="x"),
        ], parent="body", anim="head"),
        *[part("branch_%d" % i, (-8 + i * 16, up(2.9), 3), [
            blk(2.9, -1, 2.9, -1, 2, 0.5, 2, "#6b4a2a", "bark"),
            blk(2.9, -1 if i else -7, 2.4, -1, 2, 0.4, 8, "#5a3d22", "bark"),
        ], parent="body", rot=(0, 0, -26 if i else 26), anim="tentacle") for i in range(2)],
        *leg("leg_0", -5, up(1.0), -4, 12, 10, 4, "#5a3d22", "#3f2a16", "bark"),
        *leg("leg_1", 5, up(1.0), -4, 12, 10, 4, "#5a3d22", "#3f2a16", "bark"),
        *leg("leg_2", -5, up(1.0), 4, 12, 10, 4, "#5a3d22", "#3f2a16", "bark"),
        *leg("leg_3", 5, up(1.0), 4, 12, 10, 4, "#5a3d22", "#3f2a16", "bark"),
    ],
}

# ---------------------------------------------------------------------- 13. Woodcock
MOBS["woodcock"] = {
    "class": "WoodcockModel", "shadow": 0.3, "height": 0.9,
    "parts": [
        part("body", (0, up(0.34), 1), [
            blk(0.34, -5, 0.5, -7, 10, 0.16, 7, "#6b5335", "feather"),
            blk(0.34, -4, 0.42, -6, 8, 0.18, 9, "#7b6140", "feather"),
            blk(0.34, -4, 0.34, -4, 8, 0.1, 3, "#5a4529", "feather"),
            blk(0.34, -3, 0.32, 1, 6, 0.1, 3, "#8a6f49", "feather"),
            *ridge(-4, 0, 3, 8, 3, 3, 4, "#4b3823", "feather", axis="x"),
        ], anim="bob"),
        part("head", (0, up(0.62), -5), [
            blk(0.62, -3, 0.74, -4, 6, 0.18, 7, "#7b6140", "feather", face="bird"),
            blk(0.62, -2, 0.8, -5, 4, 0.1, 4, "#8f7350", "feather"),
            blk(0.62, -1, 0.66, -13, 2, 0.1, 10, "#c8a86a", "bone"),
            blk(0.62, -1, 0.62, -13, 2, 0.05, 9, "#a08050", "bone"),
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

# ------------------------------------------------------------------------ 14. Lights
MOBS["lights"] = {
    "class": "LightsModel", "shadow": 0.5, "height": 1.0,
    "parts": [
        part("body", (0, up(0.42), 0), [
            blk(0.42, -6, 0.76, -6, 12, 0.4, 11, "#7f858b", "scales", face="scales"),
            blk(0.42, -7, 0.46, -5, 14, 0.24, 10, "#686d73", "scales"),
            blk(0.42, -5, 0.24, -5, 10, 0.22, 10, "#5c6166", "scales"),
            *ridge(-5, 0, -4, 10, 2, 2, 4, "#8f959b", "scales", axis="x"),
        ], anim="bob"),
        part("head", (0, up(0.6), -1), [
            blk(0.6, -4, 0.95, -5, 8, 0.32, 7, "#9aa0a6", "scales", face="scales"),
            blk(0.6, -5, 0.9, -5, 10, 0.14, 8, "#82888e", "scales"),
        ], parent="body", anim="head"),
        part("eye", (0, up(0.62), -6), [
            blk(0.62, -4, 0.86, -2, 8, 0.28, 3, "#f7fbff", "lens", glow=True),
            blk(0.62, -2, 0.88, -3, 4, 0.2, 1, "#1b262e", "lens"),
        ], parent="head", anim="eye"),
        *leg("leg_0", -3, up(0.2), -3, 5, 4, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_1", 3, up(0.2), -3, 5, 4, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_2", -3, up(0.2), 3, 5, 4, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_3", 3, up(0.2), 3, 5, 4, 3, "#7d8288", "#5c6166", "scales", claw=False),
    ],
}

# ------------------------------------------------------------------- 15. Chest Mimic
MOBS["chest_mimic"] = {
    "class": "ChestMimicModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.45), 0), [
            blk(0.45, -7, 0.62, -5, 14, 0.5, 10, "#8a6234", "planks", face="chest"),
            blk(0.45, -7, 0.64, -5, 14, 0.1, 10, "#6b4a26", "wood"),
            blk(0.45, -8, 0.55, -6, 16, 0.18, 12, "#5a3d1f", "wood"),
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

# ----------------------------------------------------------------- 16. Water Grabber
MOBS["water_grabber"] = {
    "class": "WaterGrabberModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(1.0), 0), [
            # rounded shell
            blk(1.0, -11, 1.18, -10, 22, 0.4, 20, "#a03a52", "wet", face="scales"),
            blk(1.0, -9, 1.38, -8, 18, 0.24, 16, "#b8455f", "wet"),
            blk(1.0, -6, 1.52, -5, 12, 0.16, 10, "#c95a72", "wet"),
            # underbelly
            blk(1.0, -10, 0.86, -9, 20, 0.32, 18, "#7d2b3e", "wet"),
            blk(1.0, -8, 0.68, -7, 16, 0.2, 14, "#66212f", "wet"),
            # carapace spines
            *bolts(-9, 0, -9, 18, 4, 2, "#c2586f", "wet"),
        ], anim="bob"),
        part("head", (0, up(0.95), -11), [
            blk(0.95, -7, 1.1, -3, 14, 0.3, 6, "#b8455f", "wet", face="star"),
            blk(0.95, -5, 1.16, -2, 10, 0.2, 4, "#c95a72", "wet", face="trident"),
            blk(0.95, -4, 0.9, -1, 8, 0.24, 4, "#66212f", "wet"),
            blk(0.95, -5, 1.12, -1, 2, 0.12, 2, "#d8ffb0", "lens", glow=True),
            blk(0.95, 3, 1.12, -1, 2, 0.12, 2, "#d8ffb0", "lens", glow=True),
        ], parent="body", anim="head"),
        # six walking legs
        *[lp for i, (x, z) in enumerate([(-10, -6), (-11, 0), (-10, 6),
                                         (10, -6), (11, 0), (10, 6)])
          for lp in leg("leg_%d" % i, x, up(0.95), z, 8, 7, 4,
                        "#8c2f45", "#66212f", "wet", out=4, spread=2)],
        # two big claws
        *[part("claw_%s" % nm, (sx * 8, up(0.95), -8), [
            blk(0.95, -3, 1.02, -4, 6, 0.3, 8, "#a03a52", "wet", face="suckers"),
            blk(0.95, -2, 1.16, -3, 4, 0.24, 6, "#b8455f", "wet"),
            # pincer
            blk(0.95, -2, 0.5, -12, 4, 0.24, 7, "#b8455f", "bone"),
            blk(0.95, -3, 0.34, -12, 2, 0.2, 6, "#c95a72", "bone", face="teeth"),
            blk(0.95, -3, 0.66, -12, 2, 0.2, 6, "#c95a72", "bone"),
        ], parent="body", rot=(14, 0, sx * 18), anim="arm") for nm, sx in (("l", -1), ("r", 1))],
    ],
}
# ------------------------------------------------------------------------- 17. Tank
MOBS["tank"] = {
    "class": "TankModel", "shadow": 1.6, "height": 2.4,
    "parts": [
        part("body", (0, up(1.1), 0), [
            blk(1.1, -13, 1.62, -19, 26, 0.5, 38, "#4c5445", "milmetal", face="armor"),
            blk(1.1, -11, 1.12, -18, 22, 0.46, 36, "#3c4337", "milmetal"),
            blk(1.1, -12, 1.86, -20, 24, 0.24, 7, "#565f4c", "milmetal", face="armor"),
            blk(1.1, -12, 1.5, 18, 24, 0.2, 5, "#3a4134", "milmetal"),
            blk(1.1, -20, 1.02, -21, 7, 0.12, 42, "#454d3f", "milmetal"),
            blk(1.1, 13, 1.02, -21, 7, 0.12, 42, "#454d3f", "milmetal"),
            blk(1.1, -19, 0.92, -21, 6, 0.72, 42, "#2b3126", "milmetal", face="tracks"),
            blk(1.1, 13, 0.92, -21, 6, 0.72, 42, "#2b3126", "milmetal", face="tracks"),
            # road wheels, visible outside the track
            *[blk(1.1, -20.5, 0.62, -16 + i * 8, 3, 0.44, 6, "#3a4134", "milmetal")
              for i in range(5)],
            *[blk(1.1, 17.5, 0.62, -16 + i * 8, 3, 0.44, 6, "#3a4134", "milmetal")
              for i in range(5)],
            blk(1.1, -9, 1.75, 20, 4, 0.3, 5, "#2f3529", "metal"),
            blk(1.1, 5, 1.75, 20, 4, 0.3, 5, "#2f3529", "metal"),
            blk(1.1, 14.5, 1.4, 6, 5, 0.36, 9, "#3f4739", "milmetal", face="crate"),
            blk(1.1, -19.5, 1.4, 4, 5, 0.36, 9, "#3f4739", "milmetal", face="crate"),
            blk(1.1, -8, 1.45, -21, 3, 0.24, 2, "#e8e4c8", "lens", glow=True),
            blk(1.1, 5, 1.45, -21, 3, 0.24, 2, "#e8e4c8", "lens", glow=True),
            *bolts(-12, -2, -19, 24, 5, 1, "#5b6452", "milmetal"),
        ], anim="bob"),
        part("head", (0, up(1.9), -2), [
            blk(1.9, -9, 2.16, -9, 18, 0.46, 18, "#525b4a", "milmetal", face="armor"),
            blk(1.9, -8, 2.26, -8, 16, 0.12, 16, "#5c6552", "milmetal", face="deck"),
            blk(1.9, -9.5, 1.96, -6, 19, 0.2, 12, "#454d3f", "milmetal"),
            blk(1.9, -4, 2.1, -12, 8, 0.42, 5, "#4b5343", "milmetal", face="armor"),
            blk(1.9, -2, 2.06, -30, 3, 0.2, 19, "#3c4337", "milmetal"),
            blk(1.9, -3, 2.16, -35, 6, 0.3, 6, "#333a2e", "milmetal", face="muzzle"),
            blk(1.9, -4, 2.4, 2, 7, 0.2, 7, "#4f5847", "milmetal", face="deck"),
            blk(1.9, -3, 2.46, 3, 5, 0.1, 5, "#3c4337", "milmetal"),
            blk(1.9, 6, 2.5, -2, 1, 0.34, 1, "#2f3529", "metal"),
            blk(1.9, 6, 2.36, -4, 2, 0.14, 6, "#2f3529", "metal"),
            *ridge(-8, -1, -6, 14, 3, 3, 3, "#3a4134", "milmetal", axis="x"),
            *ridge(2, -1, 8, 10, 3, 3, 2, "#3a4134", "milmetal", axis="x"),
        ], parent="body", anim="head"),
    ],
}

# ------------------------------------------------------------------- 18. Siren Head
MOBS["siren_head"] = {
    "class": "SirenHeadModel", "shadow": 1.6, "height": 9.5,
    "parts": [
        part("body", (0, up(5.0), 0), [
            blk(5.0, -6, 6.7, -6, 12, 3.4, 12, "#8e8471", "skin", face="ribs"),
            blk(5.0, -8, 4.2, -8, 16, 0.3, 16, "#7d7462", "skin"),
            blk(5.0, -8, 3.2, -8, 16, 0.3, 16, "#7d7462", "skin"),
            blk(5.0, -7, 2.9, -7, 14, 0.4, 14, "#6f6757", "skin"),
            *ridge(-6, 0, -6, 12, 3, 2, 4, "#9a917c", "bone", axis="x", taper=False),
            *ridge(-6, 6, -6, 12, 3, 2, 3, "#9a917c", "bone", axis="x", taper=False),
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

# ---------------------------------------------------------------------- 19. Warship
MOBS["warship"] = {
    "class": "WarshipModel", "shadow": 3.0, "height": 6.0,
    "parts": [
        part("body", (0, up(1.2), 0), [
            blk(1.2, -14, 1.34, -42, 28, 0.92, 84, "#3d4650", "milmetal", face="hull"),
            blk(1.2, -10, 0.74, -38, 20, 0.6, 76, "#333b44", "milmetal", face="hull"),
            blk(1.2, -8, 1.34, -50, 16, 0.92, 10, "#414b56", "milmetal", face="hull"),
            blk(1.2, -3, 1.34, -56, 6, 0.92, 8, "#414b56", "milmetal"),
            blk(1.2, -11, 1.3, 42, 22, 0.88, 8, "#39424c", "milmetal", face="hull"),
            blk(1.2, -12, 1.46, -40, 24, 0.14, 80, "#4a545f", "milmetal", face="deck"),
            blk(1.2, -7, 1.46, -48, 14, 0.14, 8, "#4a545f", "milmetal", face="deck"),
            *ridge(-12, 0, -38, 76, 4, 2, 13, "#5b6672", "metal", axis="z"),
            *ridge(11, 0, -38, 76, 4, 2, 13, "#5b6672", "metal", axis="z"),
            blk(1.2, -13, 1.62, -40, 2, 0.1, 80, "#66717d", "metal"),
            blk(1.2, 11, 1.62, -40, 2, 0.1, 80, "#66717d", "metal"),
            *[blk(1.2, -13, 1.1, -24 + i * 14, 2, 0.16, 2, "#8b8f7a", "lens", glow=True)
              for i in range(5)],
            *[blk(1.2, 11, 1.1, -24 + i * 14, 2, 0.16, 2, "#8b8f7a", "lens", glow=True)
              for i in range(5)],
        ], anim="bob"),
        part("head", (0, up(2.2), 0), [
            blk(2.2, -9, 2.5, -8, 18, 0.9, 18, "#4a545f", "milmetal", face="bridge"),
            blk(2.2, -10, 2.7, -9, 20, 0.2, 20, "#556170", "milmetal"),
            blk(2.2, -6, 3.1, -5, 12, 0.6, 14, "#54606c", "milmetal", face="windows"),
            blk(2.2, -7, 3.2, -6, 14, 0.16, 16, "#5f6b78", "milmetal", face="deck"),
            blk(2.2, -3, 4.0, 6, 6, 1.0, 7, "#414b56", "milmetal", face="funnel"),
            blk(2.2, -4, 4.15, 5, 8, 0.16, 9, "#2f363d", "metal"),
            blk(2.2, -3, 3.7, 16, 5, 0.7, 5, "#414b56", "milmetal", face="funnel"),
            blk(2.2, -1, 5.7, -2, 2, 2.6, 2, "#5b6672", "metal"),
            blk(2.2, -4, 5.2, -3, 8, 0.24, 2, "#6b7684", "metal", face="radar"),
            blk(2.2, -6, 4.6, -1, 12, 0.16, 1, "#6b7684", "metal"),
            blk(2.2, -2, 5.9, -1, 4, 0.14, 4, "#8b93a0", "metal"),
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

# ---------------------------------------------------------------------- 20. Circuit
MOBS["circuit"] = {
    "class": "CircuitModel", "shadow": 1.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.35), 0), [
            blk(1.35, -7, 1.9, -4, 14, 0.9, 9, "#123a34", "circuit", face="board"),
            blk(1.35, -8, 1.0, -5, 16, 0.36, 11, "#0e2c28", "circuit"),
            blk(1.35, -6, 1.92, -3, 12, 0.1, 7, "#1a5a4e", "circuit"),
            *ridge(-6, 0, -3, 12, 3, 2, 4, "#1f6b5c", "circuit", axis="x"),
            *bolts(-8, 2, -5, 2, 3, 1, "#33d6a0", "circuit", axis="y"),
            *hose(-8, 1, -3, 8, 2, "#0b2320", "circuit", axis="y", segments=4, sag=1),
        ], anim="bob"),
        part("head", (0, up(2.0), 0), [
            blk(2.0, -6, 2.2, -6, 12, 0.6, 12, "#16453c", "circuit", face="screen"),
            blk(2.0, -5, 2.24, -5, 10, 0.12, 10, "#2fd6c9", "lens", glow=True),
            blk(2.0, -2, 2.28, -7, 4, 0.14, 2, "#ff5454", "lens", glow=True),
            *bolts(-5, 5, -6, 10, 3, 1, "#33d6a0", "circuit"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.7), 0), [
            blk(1.7, -2, 1.7, -2, 3, 0.7, 3, "#0e2c28", "circuit"),
            blk(1.7, -2, 1.0, -2, 4, 0.6, 4, "#123a34", "circuit", face="board"),
            blk(1.7, -2, 0.7, -3, 5, 0.25, 5, "#1f6b5c", "circuit"),
        ], parent="body", rot=(0, 0, 7), anim="arm"),
        part("arm_r", (8, up(1.7), 0), [
            blk(1.7, -1, 1.7, -2, 3, 0.7, 3, "#0e2c28", "circuit"),
            blk(1.7, -2, 1.0, -2, 4, 0.6, 4, "#123a34", "circuit", face="board"),
            blk(1.7, -2, 0.7, -3, 5, 0.25, 5, "#1f6b5c", "circuit"),
        ], parent="body", rot=(0, 0, -7), anim="arm"),
        *leg("leg_l", -4, up(0.95), 0, 10, 8, 3, "#0e2c28", "#08201c", "circuit"),
        *leg("leg_r", 4, up(0.95), 0, 10, 8, 3, "#0e2c28", "#08201c", "circuit"),
    ],
}

# -------------------------------------------------------------------- 21. Ash Hound
MOBS["ash_hound"] = {
    "class": "AshHoundModel", "shadow": 0.7, "height": 1.3,
    "parts": [
        part("body", (0, up(0.75), 0), [
            blk(0.75, -5, 0.98, -11, 10, 0.34, 22, "#4d473f", "ash"),
            blk(0.75, -4, 0.66, -10, 8, 0.32, 20, "#3a352f", "ash"),
            *ridge(-5, 0, -9, 18, 3, 2, 5, "#57504a", "ash", axis="x"),
            blk(0.75, -2, 0.8, 11, 4, 0.2, 4, "#2e2a26", "ash"),
            *[blk(0.75, -1, 0.9, z, 3, 0.1, 2, "#ff8a40", "lens", glow=True)
              for z in (-6, 0, 6)],
        ], anim="bob"),
        part("head", (0, up(0.95), -12), [
            blk(0.95, -4, 1.14, -5, 8, 0.28, 10, "#57504a", "ash", face="hound"),
            blk(0.95, -2, 0.94, -8, 4, 0.2, 4, "#2e2a26", "ash"),
            blk(0.95, -4, 1.16, -3, 3, 0.24, 3, "#4d473f", "ash"),
            blk(0.95, 1, 1.16, -3, 3, 0.24, 3, "#4d473f", "ash"),
            *teeth_row(-3, 0, -8, 6, 2, 2, 4, "#e8dcc0", "bone"),
            blk(0.95, -3, 1.06, -6, 2, 0.1, 1, "#ff8a40", "lens", glow=True),
            blk(0.95, 1, 1.06, -6, 2, 0.1, 1, "#ff8a40", "lens", glow=True),
        ], parent="body", anim="head"),
        *leg("leg_0", -4, up(0.62), -8, 7, 6, 3, "#4d473f", "#332e29", "ash"),
        *leg("leg_1", 4, up(0.62), -8, 7, 6, 3, "#4d473f", "#332e29", "ash"),
        *leg("leg_2", -4, up(0.62), 8, 7, 6, 3, "#4d473f", "#332e29", "ash"),
        *leg("leg_3", 4, up(0.62), 8, 7, 6, 3, "#4d473f", "#332e29", "ash"),
    ],
}

# ------------------------------------------------------------------- 22. Cloud Ray
MOBS["cloud_ray"] = {
    "class": "CloudRayModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(0.85), 0), [
            blk(0.85, -8, 1.12, -10, 16, 0.3, 20, "#d7dde2", "cloud"),
            blk(0.85, -6, 0.86, -8, 12, 0.26, 16, "#eef3f7", "cloud"),
            blk(0.85, -6, 1.24, -7, 12, 0.18, 14, "#c2cbd2", "cloud"),
            blk(0.85, -2, 0.66, -3, 4, 0.18, 8, "#aeb8c0", "cloud"),
        ], anim="bob"),
        part("head", (0, up(0.85), -10), [
            blk(0.85, -6, 1.16, -4, 12, 0.28, 7, "#c2cbd2", "cloud", face="ray_eye"),
            blk(0.85, -4, 1.3, -2, 8, 0.16, 5, "#eef3f7", "cloud"),
            blk(0.85, -1, 1.06, -6, 2, 0.14, 2, "#6fa8c9", "lens", glow=True),
        ], parent="body", anim="head"),
        part("wing_l", (-7, up(0.9), -2), [
            blk(0.9, -14, 1.04, -7, 14, 0.2, 15, "#d7dde2", "cloud"),
            blk(0.9, -21, 1.06, -5, 8, 0.16, 11, "#c2cbd2", "cloud"),
            blk(0.9, -26, 1.08, -3, 6, 0.14, 7, "#aeb8c0", "cloud"),
            *ridge(-20, 0, -5, 12, 2, 2, 4, "#eef3f7", "cloud", axis="z"),
        ], parent="body", rot=(0, 0, 9), anim="wing"),
        part("wing_r", (7, up(0.9), -2), [
            blk(0.9, 0, 1.04, -7, 14, 0.2, 15, "#d7dde2", "cloud"),
            blk(0.9, 13, 1.06, -5, 8, 0.16, 11, "#c2cbd2", "cloud"),
            blk(0.9, 20, 1.08, -3, 6, 0.14, 7, "#aeb8c0", "cloud"),
            *ridge(8, 0, -5, 12, 2, 2, 4, "#eef3f7", "cloud", axis="z"),
        ], parent="body", rot=(0, 0, -9), anim="wing"),
        part("tentacle_0", (0, up(0.8), 9), [
            blk(0.8, -1, 0.8, -1, 3, 0.5, 3, "#c2cbd2", "cloud"),
            blk(0.8, -1, 0.4, -1, 2, 0.4, 2, "#aeb8c0", "cloud"),
        ], parent="body", rot=(-24, 0, 0), anim="tentacle"),
        *[part("fin_%d" % i, (-6 + i * 12, up(0.9), 7), [
            blk(0.9, -1, 1.1, -1, 3, 0.3, 8, "#aeb8c0", "cloud"),
        ], parent="body", rot=(18, 0, 0), anim="wing") for i in range(2)],
    ],
}

# ------------------------------------------------------------------- 23. Bog Wretch
MOBS["bog_wretch"] = {
    "class": "BogWretchModel", "shadow": 1.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.2), 0), [
            blk(1.2, -7, 1.8, -4, 14, 0.85, 9, "#3f5a2a", "wet", face="rags"),
            blk(1.2, -8, 1.0, -5, 16, 0.4, 11, "#354b23", "wet"),
            blk(1.2, -6, 0.62, -4, 12, 0.4, 9, "#2c3f1d", "wet", face="rags"),
            *ridge(-7, 0, -4, 14, 4, 2, 5, "#4c6b34", "wet", axis="x", taper=False),
            *ridge(-6, 8, -3, 12, 3, 2, 4, "#2c3f1d", "wet", axis="x", taper=False),
            # swamp growth on the shoulders
            *[blk(1.2, x, 1.72, -3, 3, 0.16, 3, "#6f8f3f", "leaves") for x in (-6, 3)],
        ], anim="bob"),
        part("head", (0, up(1.95), 0), [
            blk(1.95, -6, 2.16, -5, 12, 0.55, 10, "#4a6630", "wet", face="skull"),
            blk(1.95, -3, 1.9, -7, 6, 0.34, 3, "#3f5a2a", "wet"),
            blk(1.95, -4, 2.06, -6, 2, 0.14, 1, "#c9ff6a", "lens", glow=True),
            blk(1.95, 2, 2.06, -6, 2, 0.14, 1, "#c9ff6a", "lens", glow=True),
            *teeth_row(-4, 1, -6, 8, 2, 2, 4, "#e0d8b0", "bone"),
        ], parent="body", anim="head"),
        part("arm_l", (-8, up(1.7), 0), [
            blk(1.7, -2, 1.7, -2, 3, 0.75, 3, "#3f5a2a", "wet"),
            blk(1.7, -2, 0.95, -2, 4, 0.7, 4, "#4a6630", "wet"),
            blk(1.7, -2, 0.55, -3, 5, 0.3, 5, "#354b23", "wet"),
            *toes(-2, 10, -1, 2, 4, 2, 3, "#a8b878", "bone"),
        ], parent="body", rot=(0, 0, 9), anim="arm"),
        part("arm_r", (8, up(1.7), 0), [
            blk(1.7, -1, 1.7, -2, 3, 0.75, 3, "#3f5a2a", "wet"),
            blk(1.7, -2, 0.95, -2, 4, 0.7, 4, "#4a6630", "wet"),
            blk(1.7, -2, 0.55, -3, 5, 0.3, 5, "#354b23", "wet"),
            *toes(-2, 10, -1, 2, 4, 2, 3, "#a8b878", "bone"),
        ], parent="body", rot=(0, 0, -9), anim="arm"),
        *leg("leg_l", -4, up(0.85), 0, 10, 8, 4, "#354b23", "#243318", "wet"),
        *leg("leg_r", 4, up(0.85), 0, 10, 8, 4, "#354b23", "#243318", "wet"),
    ],
}

# --------------------------------------------------------------- 24. Lantern Wraith
MOBS["lantern_wraith"] = {
    "class": "LanternWraithModel", "shadow": 0.7, "height": 2.0,
    "parts": [
        part("body", (0, up(1.0), 0), [
            blk(1.0, -7, 1.7, -5, 14, 0.9, 10, "#2a2f3c", "cloth", face="robe"),
            blk(1.0, -8, 1.05, -6, 16, 0.36, 12, "#222633", "cloth"),
            blk(1.0, -6, 0.6, -5, 12, 0.3, 10, "#1c2029", "cloth", face="robe"),
            *ridge(-7, 0, -5, 12, 4, 2, 5, "#1c2029", "cloth", axis="x", taper=False),
            *ridge(-6, 8, -4, 11, 5, 2, 4, "#191d25", "cloth", axis="x", taper=False),
            blk(1.0, -8, 1.05, -6, 16, 0.1, 12, "#3a3326", "bone"),
            blk(1.0, -2, 1.1, -7, 4, 0.14, 2, "#cbbd9a", "bone"),
        ], anim="bob"),
        part("head", (0, up(1.62), 0), [
            blk(1.62, -7, 2.0, -7, 14, 0.55, 14, "#161a22", "cloth", face="hood"),
            blk(1.62, -5, 2.03, -5, 10, 0.3, 10, "#10131a", "cloth"),
            blk(1.62, -6, 1.72, -8, 12, 0.24, 3, "#0d1016", "cloth"),
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

# --------------------------------------------------------------- 25. Hollow Neighbor
MOBS["hollow_neighbor"] = {
    "class": "HollowNeighborModel", "shadow": 0.9, "height": 2.1,
    "parts": [
        part("body", (0, up(1.15), 0), [
            blk(1.15, -7, 1.7, -4, 14, 1.2, 9, "#5a4a38", "cloth", face="robe"),
            blk(1.15, -8, 1.05, -5, 16, 0.3, 11, "#4a3c2d", "cloth"),
            blk(1.15, -9, 1.42, -5, 18, 0.24, 11, "#4a3c2d", "cloth"),
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
            blk(1.6, -2, 1.6, -2, 3, 0.75, 3, "#5a4a38", "cloth"),
            blk(1.6, -2, 0.9, -2, 4, 0.7, 4, "#6a5a48", "skin"),
            blk(1.6, -3, 0.6, -3, 5, 0.3, 5, "#7d6c58", "skin"),
            *ridge(-3, 10, -3, 5, 2, 2, 3, "#8d7c66", "skin", axis="x"),
        ], parent="body", rot=(4, 0, 6), anim="arm"),
        part("arm_r", (8, up(1.6), 0), [
            blk(1.6, -1, 1.6, -2, 3, 0.75, 3, "#5a4a38", "cloth"),
            blk(1.6, -2, 0.9, -2, 4, 0.7, 4, "#6a5a48", "skin"),
            blk(1.6, -2, 0.6, -3, 5, 0.3, 5, "#7d6c58", "skin"),
            *ridge(-2, 10, -3, 5, 2, 2, 3, "#8d7c66", "skin", axis="x"),
        ], parent="body", rot=(4, 0, -6), anim="arm"),
        *leg("leg_l", -4, up(0.9), 0, 10, 6, 3, "#3f3426", "#2e261c", "cloth"),
        *leg("leg_r", 4, up(0.9), 0, 10, 6, 3, "#3f3426", "#2e261c", "cloth"),
    ],
}

# --------------------------------------------------------------------- 26. Tornado
def _funnel():
    parts = []
    rings = 12
    for i in range(rings):
        t = i / float(rings - 1)
        radius = int(round(44 - 38 * (t ** 0.8)))
        y = GROUND - 8 - i * 16
        dx = int(round(math.sin(i * 1.7) * (6 - 4 * t)))
        dz = int(round(math.cos(i * 1.7) * (6 - 4 * t)))
        shade_ = "#8c99a6" if i % 2 else "#9dabb8"
        boxes = [box(-radius, 0, -radius, radius * 2, 18, radius * 2, shade_, "storm",
                     face="vortex")]
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
            blk(0.3, -44, 0.3, -44, 88, 0.35, 88, "#5d6874", "storm", face="vortex"),
            blk(0.3, -30, 0.55, -26, 56, 0.3, 50, "#6b7683", "storm"),
            blk(0.3, -16, 0.8, -12, 32, 0.3, 24, "#77828e", "storm"),
        ], anim="bob"),
        part("top", (0, up(11.5), 0), [
            blk(11.5, -14, 11.9, -14, 28, 0.4, 28, "#a8b5c1", "storm", face="vortex"),
            blk(11.5, -20, 11.95, -9, 40, 0.2, 18, "#b6c2ce", "storm"),
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
