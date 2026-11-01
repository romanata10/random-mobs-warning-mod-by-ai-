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


def up(blocks):
    """Model-space y of a height given in blocks above the feet."""
    return GROUND - blocks * 16.0


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


def hull(pivot_blocks, x, top_blocks, z, w, thick_blocks, d, color, style="noise",
         cut=3, face=None, glow=False):
    """Octagonal volume: a box with its four vertical corners cut away, so the silhouette
    reads round instead of cubic. Same arguments as blk(); returns a list of boxes."""
    height = max(1, int(round(thick_blocks * 16)))
    y = int(round(up(top_blocks) - up(pivot_blocks)))
    c = max(1, min(int(cut), max(1, w // 3), max(1, d // 3)))
    out = [box(x + c, y, z + c, w - 2 * c, height, d - 2 * c, color, style,
               face=face, glow=glow)]
    out.append(box(x, y, z + c, c, height, d - 2 * c, color, style))
    out.append(box(x + w - c, y, z + c, c, height, d - 2 * c, color, style))
    out.append(box(x + c, y, z, w - 2 * c, height, c, color, style))
    out.append(box(x + c, y, z + d - c, w - 2 * c, height, c, color, style))
    return out


def dome(pivot_blocks, x, top_blocks, z, w, thick_blocks, d, color, style="noise",
         steps=3, face=None):
    """Stacked shrinking slabs — a rounded shell, hat or lid."""
    out = []
    step_h = thick_blocks / float(max(1, steps))
    for i in range(steps):
        k = (i + 0.5) / steps                       # 0 bottom .. 1 top
        shrink = int(round(k * min(w, d) * 0.28))
        top = top_blocks + step_h * (steps - i)
        out += hull(pivot_blocks, x + shrink, top, z + shrink, w - 2 * shrink,
                    step_h * 1.05, d - 2 * shrink, color, style,
                    cut=max(1, (w - 2 * shrink) // 6),
                    face=face if i == steps - 1 else None)
    return out


def cone(cx, cy, cz, w, h, color, style="bone", steps=4, d=None, face=None, glow=False,
         pivot=None):
    """Tapering spike / horn / tooth: base at (cx, cy, cz), growing upwards (-y).
    Pass ``pivot`` (the part's pivot height in blocks) inside a nested part."""
    d = w if d is None else d
    if pivot is not None:
        cy = cy - up(pivot)
    out = []
    for i in range(steps):
        k = i / float(max(1, steps))
        cw = max(1, int(round(w * (1.0 - 0.72 * k))))
        cd = max(1, int(round(d * (1.0 - 0.72 * k))))
        step = max(1, int(round(h / steps)))
        out.append(box(cx - cw // 2, int(round(cy - h * k)) - step, cz - cd // 2,
                       cw, step + 1, cd, color, style,
                       face=face if i == 0 else None, glow=glow))
    return out


def skull(pivot_blocks, x, top_blocks, z, w, thick_blocks, d, color, style="bone",
          eye="#c9ff8a", glow=True, jaw=True):
    """Chamfered head with a brow ridge, sunken eye sockets and a jaw."""
    out = hull(pivot_blocks, x, top_blocks, z, w, thick_blocks, d, color, style,
               cut=max(2, w // 5), face="skull")
    out.append(box(x + 1, int(round(up(top_blocks) - up(pivot_blocks))), z - 1,
                   w - 2, max(1, int(round(thick_blocks * 16 * 0.22))), 2, color, style))
    # eye sockets sit under the brow
    ey = int(round(up(top_blocks - thick_blocks * 0.3) - up(pivot_blocks)))
    out.append(box(x + 2, ey, z - 1, max(1, w // 4), max(1, int(thick_blocks * 3)),
                   1, "#1b1a18", "cloth"))
    out.append(box(x + w - 2 - max(1, w // 4), ey, z - 1, max(1, w // 4),
                   max(1, int(thick_blocks * 3)), 1, "#1b1a18", "cloth"))
    out.append(box(x + 3, ey + 1, z - 1, max(1, w // 6), max(1, int(thick_blocks * 2)),
                   1, eye, "lens", glow=glow))
    out.append(box(x + w - 3 - max(1, w // 6), ey + 1, z - 1, max(1, w // 6),
                   max(1, int(thick_blocks * 2)), 1, eye, "lens", glow=glow))
    if jaw:
        out.append(box(x + 2, int(round(up(top_blocks - thick_blocks) - up(pivot_blocks))),
                       z + 1, w - 4, max(2, int(round(thick_blocks * 16 * 0.34))), 3,
                       color, style))
    return out


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


def arm(name, x, y, z, upper, lower, thick, color, lower_color=None, side=None,
        out=2.0, fwd=0.0, style="cloth", anim="arm", claw=False):
    """Hanging arm with an elbow: same machinery as a leg, but it never reaches the floor."""
    side = (-1.0 if x < 0 else 1.0) if side is None else side
    elbow = (x + side * out, y + upper, z + fwd * 0.5)
    hand = (x + side * (out + 1.5), y + upper + lower, z + fwd)
    return _leg(name, (x, y, z), elbow, hand, thick, color,
                lower_color or color, style, anim, claw)


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


"""Model specifications for every Random Mobs creature (v5 — rebuild with rounded volumes).

Coordinate system matches vanilla entity models: 16 units = 1 block, +Y points DOWN,
the model origin sits 1.5 blocks above the ground, -Z is where the mob is looking.

Every pivot is authored in ABSOLUTE model space; `_relativize()` in models.py turns the
nested ones into parent-relative offsets that Minecraft expects.

Bodies are built from `hull()` (chamfered octagonal volumes) and `dome()` (stacked,
shrinking shells) instead of plain cubes, so the silhouettes read round instead of blocky.
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
        part("body", (0, up(4.5), 0), [
            # big rounded hull
            *hull(4.5, -13, 5.5, -13, 26, 1.3, 26, "#5f6874", "metal", cut=5, face="panel"),
            *hull(4.5, -11, 4.45, -11, 22, 0.55, 22, "#4a525c", "metal", cut=4),
            # belly pod and vents
            *hull(4.5, -8, 3.95, -7, 16, 0.5, 14, "#3d444d", "metal", cut=3, face="vent"),
            # shoulder armour
            *hull(4.5, -16, 5.4, -7, 6, 0.85, 14, "#525b66", "metal", cut=2, face="armor"),
            *hull(4.5, 10, 5.4, -7, 6, 0.85, 14, "#525b66", "metal", cut=2, face="armor"),
            # dorsal spine and cables
            *ridge(-11, 0, -11, 22, 3, 2, 6, "#4b535d", "metal", axis="x"),
            *bolts(-12, -4, -12, 24, 5, 2, "#8b95a2", "metal"),
            *hose(-15, 2, -10, 11, 2, "#2f343b", "metal", axis="y", segments=4, sag=2),
            # core light
            blk(4.5, -4, 4.6, -14, 8, 0.3, 2, "#8ef7c8", "lens", glow=True),
            blk(4.5, -5, 4.75, -14, 10, 0.1, 1, "#2b323a", "metal"),
        ], anim="bob"),
        part("head", (0, up(5.55), -2), [
            *hull(5.55, -8, 5.95, -7, 16, 0.6, 14, "#6b7581", "metal", cut=4, face="visor"),
            *hull(5.55, -6, 5.6, -5, 12, 0.4, 10, "#4a525c", "metal", cut=3),
            blk(5.55, -5, 5.86, -8, 10, 0.18, 1, "#9dfbd4", "lens", glow=True),
            blk(5.55, -6, 5.9, -8, 12, 0.08, 1, "#2b323a", "metal"),
            # short antenna
            *cone(0, int(up(6.05)), 2, 3, 6, "#7b8693", "metal", steps=2, pivot=5.55),
        ], parent="body", anim="head"),
        *leg("leg_l", -11, up(4.1), -5, 24, 26, 8, "#5b6470", "#3f464f", "metal", out=4, spread=-3),
        *leg("leg_r", 11, up(4.1), -5, 24, 26, 8, "#5b6470", "#3f464f", "metal", out=4, spread=-3),
        *leg("leg_b", 1, up(4.1), 11, 24, 26, 8, "#5b6470", "#3f464f", "metal", out=3, spread=4),
    ],
}
# -------------------------------------------------------------------- 2. Woodcrawler
MOBS["woodcrawler"] = {
    "class": "WoodcrawlerModel", "shadow": 0.9, "height": 2.0,
    "parts": [
        part("body", (0, up(1.45), 0), [
            # cephalothorax
            *hull(1.45, -7, 1.6, -8, 14, 0.42, 11, "#7d5d3c", "chitin", cut=3, face="plates"),
            *hull(1.45, -5, 1.24, -6, 10, 0.3, 8, "#63482d", "chitin", cut=2),
            # abdomen, heavy and behind
            *hull(1.45, -8, 1.56, 2, 16, 0.5, 15, "#6f5235", "chitin", cut=4, face="plates"),
            *hull(1.45, -6, 1.16, 4, 12, 0.34, 11, "#523a25", "chitin", cut=3),
            *dome(1.45, -6, 1.56, 4, 12, 0.22, 10, "#8a6943", "chitin", steps=2),
            # spine ridge + sockets
            *ridge(-6, 0, 3, 12, 3, 3, 4, "#9a7850", "chitin", axis="z"),
            *bolts(-8, -1, -3, 16, 4, 2, "#8d6c46", "chitin"),
        ], anim="bob"),
        part("head", (0, up(1.45), -8), [
            *skull(1.45, -6, 1.52, -4, 12, 0.34, 6, "#7d5d3c", "chitin", eye="#d8ff9a"),
            blk(1.45, -3, 1.2, -6, 2, 0.22, 3, "#d9d0b8", "bone"),
            blk(1.45, 1, 1.2, -6, 2, 0.22, 3, "#d9d0b8", "bone"),
            # palps
            blk(1.45, -7, 1.18, -4, 2, 0.2, 4, "#63482d", "chitin"),
            blk(1.45, 5, 1.18, -4, 2, 0.2, 4, "#63482d", "chitin"),
        ], parent="body", anim="head"),
        *spider_legs("leg", up(1.1), 7, 8, 12, 16, 5, "#6f5235", "#43301f", "chitin", knee_lift=11),
    ],
}

# ------------------------------------------------------------------------- 3. Bloop
MOBS["bloop"] = {
    "class": "BloopModel", "shadow": 3.4, "height": 4.2,
    "parts": [
        part("body", (0, up(2.35), 0), [
            # whale bulk: rounded top shell on a tapered body
            *hull(2.35, -22, 3.5, -20, 44, 1.05, 40, "#173a4a", "wet", cut=8),
            *dome(2.35, -20, 3.5, -18, 40, 0.6, 36, "#1d4759", "wet", steps=2),
            *hull(2.35, -18, 2.95, -16, 36, 0.6, 32, "#122f3e", "wet", cut=7),
            *hull(2.35, -13, 2.4, -12, 26, 0.5, 24, "#0f2733", "wet", cut=5),
            # dorsal ridge fin
            *[b for i in range(4)
              for b in cone(0, int(up(4.0)) - i * 0, -6 + i * 4, 3, 4 + (i % 2) * 2,
                            "#0d2634", "wet", steps=2, pivot=2.35)],
            # flank light band
            *hull(2.35, -21, 3.15, -18, 42, 0.14, 36, "#2a6b84", "wet", cut=6),
            # barnacles
            *[blk(2.35, sx * 18, 3.3, -14 + i * 9, 3, 0.2, 3, "#3f7f92", "scales")
              for sx in (-1, 1) for i in range(3)],
        ], anim="bob"),
        part("head", (0, up(2.3), -20), [
            # huge front maw
            *hull(2.3, -16, 3.4, -8, 32, 1.0, 10, "#173a4a", "wet", cut=5, face="maw"),
            blk(2.3, -13, 2.95, -9, 26, 0.35, 3, "#0a1a24", "flesh"),
            *teeth_row(-12, -4, -10, 24, 5, 3, 8, "#e7e2cf", "bone"),
            *teeth_row(-12, 2, -10, 24, 5, 3, 8, "#e7e2cf", "bone", upper=False),
            # eyes
            blk(2.3, -18, 2.7, -4, 4, 0.3, 4, "#c9ff8a", "lens", glow=True),
            blk(2.3, 14, 2.7, -4, 4, 0.3, 4, "#c9ff8a", "lens", glow=True),
        ], parent="body", anim="head"),
        # flippers, clearly outside the hull
        *[part("fin_%s" % nm, (sx * 22, up(1.9), -8), [
            *hull(1.9, -2 if sx < 0 else 0, 2.2, -7, 9, 0.35, 14, "#12303f", "wet", cut=3),
            *hull(1.9, -1 if sx < 0 else 0, 1.9, -11, 6, 0.3, 11, "#1a4557", "wet", cut=2),
        ], parent="body", rot=(0, 0, sx * -20), anim="arm") for nm, sx in (("l", -1), ("r", 1))],
        # tail fluke
        part("tail", (0, up(2.3), 19), [
            *hull(2.3, -12, 3.1, 0, 24, 0.4, 10, "#12303f", "wet", cut=3),
            *hull(2.3, -7, 2.9, 8, 14, 0.34, 8, "#1a4557", "wet", cut=2),
        ], parent="body", anim="tentacle"),
    ],
}
# ------------------------------------------------------------------- 4. Alive house
MOBS["alive_house"] = {
    "class": "AliveHouseModel", "shadow": 2.4, "height": 4.5,
    "parts": [
        part("body", (0, up(2.4), 0), [
            # plaster walls with timber frame
            *hull(2.4, -20, 3.6, -16, 40, 1.9, 32, "#cbb890", "cloth", cut=5, face="wall"),
            *hull(2.4, -18, 3.35, -15, 36, 0.3, 30, "#b3a077", "cloth", cut=4),
            # timber corners and beams
            *[blk(2.4, sx * 19, 3.62, sz * 15, 2, 1.95, 2, "#4a3524", "bark")
              for sx in (-1, 1) for sz in (-1, 1)],
            blk(2.4, -19, 3.62, 15, 38, 0.16, 2, "#4a3524", "bark"),
            blk(2.4, -19, 2.5, 15, 38, 0.14, 2, "#4a3524", "bark"),
            # windows and door are painted on the front face
            *hull(2.4, -14, 1.4, -19, 28, 1.3, 4, "#cbb894", "cloth", cut=3, face="door"),
            # roof: two stacked shells
            *dome(2.4, -21, 3.62, -17, 42, 0.95, 34, "#6f3a2a", "planks", steps=3, face="roof"),
            *dome(2.4, -19, 4.6, -15, 38, 0.55, 30, "#5e3023", "planks", steps=2),
            # chimney
            *hull(2.4, 8, 5.2, -8, 6, 1.6, 6, "#7a6a60", "metal", cut=1, face="crate"),
        ], anim="bob"),
        part("face", (0, up(2.6), -19), [
            # lit window eyes
            blk(2.6, -12, 3.1, -1, 8, 0.3, 2, "#ffd06a", "lens", glow=True),
            blk(2.6, 4, 3.1, -1, 8, 0.3, 2, "#ffd06a", "lens", glow=True),
            # door mouth with teeth
            blk(2.6, -6, 1.5, -1, 12, 0.75, 2, "#2a1a12", "flesh", face="maw"),
            *teeth_row(-5, -4, -2, 10, 3, 2, 5, "#efe4c9", "bone"),
            *teeth_row(-5, 6, -2, 10, 3, 2, 5, "#efe4c9", "bone", upper=False),
        ], parent="body", anim="head"),
        *leg("leg_0", -14, up(1.5), -10, 8, 12, 7, "#5b4630", "#3b2c1d", "bark", out=2, claw=False),
        *leg("leg_1", 14, up(1.5), -10, 8, 12, 7, "#5b4630", "#3b2c1d", "bark", out=2, claw=False),
        *leg("leg_2", -14, up(1.5), 10, 8, 12, 7, "#5b4630", "#3b2c1d", "bark", out=2, claw=False),
        *leg("leg_3", 14, up(1.5), 10, 8, 12, 7, "#5b4630", "#3b2c1d", "bark", out=2, claw=False),
    ],
}

# ------------------------------------------------------------------- 5. Giant spider
MOBS["giant_spider"] = {
    "class": "GiantSpiderModel", "shadow": 1.8, "height": 2.2,
    "parts": [
        part("body", (0, up(1.5), 0), [
            # abdomen
            *hull(1.5, -11, 1.6, 1, 22, 0.5, 16, "#5f4a33", "chitin", cut=4, face="plates"),
            *hull(1.5, -9, 1.18, 2, 18, 0.36, 13, "#4a3724", "chitin", cut=3),
            *dome(1.5, -9, 1.6, 2, 18, 0.24, 13, "#75593c", "chitin", steps=2),
            # cephalothorax
            *hull(1.5, -9, 1.42, -9, 18, 0.42, 12, "#54402c", "chitin", cut=4, face="chest"),
            *ridge(-8, 0, 3, 14, 3, 3, 5, "#75593c", "chitin", axis="z"),
            *bolts(-9, 0, -2, 18, 5, 2, "#75593c", "chitin"),
        ], anim="bob"),
        part("head", (0, up(1.5), -9), [
            *skull(1.5, -7, 1.44, -6, 14, 0.4, 7, "#5f4a33", "chitin", eye="#d8ff9a"),
            # four extra eyes on the brow
            *[blk(1.5, ex, 1.48, -6, 2, 0.12, 2, "#d8ff9a", "lens", glow=True)
              for ex in (-5, 3)],
            # fangs
            *cone(-2, int(up(1.15)), -8, 3, 5, "#ddd4bd", "bone", steps=3, pivot=1.5),
            *cone(2, int(up(1.15)), -8, 3, 5, "#ddd4bd", "bone", steps=3, pivot=1.5),
        ], parent="body", anim="head"),
        *spider_legs("leg", up(1.1), 9, 9, 13, 16, 6, "#5f4a33", "#3a2c1d", "chitin", knee_lift=10),
    ],
}

# ---------------------------------------------------------------------- 6. Gardener
MOBS["gardener"] = {
    "class": "GardenerModel", "shadow": 1.2, "height": 3.2,
    "parts": [
        part("body", (0, up(1.9), 0), [
            # long coat, tapering to the hem
            *hull(1.9, -8, 2.6, -6, 16, 0.6, 12, "#2b2723", "cloth", cut=3, face="robe"),
            *hull(1.9, -9, 2.05, -7, 18, 0.55, 14, "#262220", "cloth", cut=3),
            *hull(1.9, -10, 1.5, -8, 20, 0.55, 16, "#211d1b", "cloth", cut=4, face="rags"),
            # shoulders and collar
            *hull(1.9, -9, 2.9, -7, 18, 0.35, 14, "#35302a", "cloth", cut=3),
            *hull(1.9, -6, 3.0, -5, 12, 0.28, 10, "#3d3730", "cloth", cut=2),
            # straw hat brim
            *dome(1.9, -11, 3.55, -11, 22, 0.2, 22, "#c8a24d", "bone", steps=2, face="roof"),
        ], anim="bob"),
        part("head", (0, up(2.95), 0), [
            *skull(2.95, -5, 3.45, -5, 10, 0.5, 9, "#3a3630", "cloth", eye="#b8ff7a", jaw=False),
            # hat crown
            *dome(2.95, -7, 3.52, -7, 14, 0.3, 14, "#d7b25a", "bone", steps=2),
            blk(2.95, -7, 3.62, -7, 14, 0.1, 14, "#a3813b", "bone"),
            # long nose under the brim shadow
            *cone(0, int(up(3.05)), -6, 3, 5, "#2f2b26", "cloth", steps=3, pivot=2.95),
        ], parent="body", anim="head"),
        # long neck so the head sits above the coat
        part("neck", (0, up(2.4), 0), [
            *hull(2.4, -3, 2.95, -3, 6, 0.6, 6, "#2e2a25", "cloth", cut=2),
        ], parent="body"),
        *arm("arm_l", -9, up(2.55), -1, 12, 11, 4, "#2b2723", "#211d1b", style="cloth", out=2),
        *arm("arm_r", 9, up(2.55), -1, 12, 11, 4, "#2b2723", "#211d1b", style="cloth", out=2),
        *leg("leg_l", -5, up(1.4), 0, 10, 10, 4, "#1d1a18", "#151312", "cloth", out=2, claw=False),
        *leg("leg_r", 5, up(1.4), 0, 10, 10, 4, "#1d1a18", "#151312", "cloth", out=2, claw=False),
    ],
}

# -------------------------------------------------------------------- 7. Sand worm
MOBS["sand_worm"] = {
    "class": "SandWormModel", "shadow": 2.0, "height": 2.2,
    "parts": [
        part("body", (0, up(2.2), 0), [
            # crater of sand it pushed up
            *dome(2.2, -16, 0.16, -16, 32, 0.3, 32, "#b9a274", "sand", steps=2),
            *dome(2.2, -12, 0.38, -12, 24, 0.22, 24, "#cbb589", "sand", steps=2),
            # throat trunk
            *rings(0, -1, 0.34, 0.95, 10.0, 8.6, 6, "#d2bc8e", "sand", curve=(0, -1),
                   groove="#bda878", face="segments", pivot=2.2),
            # collar of bone spikes
            *[b for a in [k * math.pi / 5.0 for k in range(10)]
              for b in cone(int(round(10.0 * math.cos(a))), int(up(0.95)),
                            int(round(10.0 * math.sin(a))) - 1, 3, 5, "#efe2bd", "bone", steps=2,
                            pivot=2.2)],
        ], anim="bob"),
        part("head", (0, up(1.42), -6), [
            # lamprey maw, face-on
            *hull(1.42, -9, 1.9, -2, 18, 0.6, 4, "#e0cba2", "sand", cut=4, face="maw"),
            box(-10, -9, -1, 20, 19, 1, "#e8d6b0", "sand"),
            box(-5, -4, -6, 10, 9, 5, "#5a3722", "flesh"),
            box(-3, -2, -7, 6, 5, 3, "#241410", "flesh"),
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
        part("body", (0, up(1.55), 0), [
            # saucer rim, thin and wide
            *hull(1.55, -18, 1.72, -18, 36, 0.24, 36, "#8b95a2", "metal", cut=9, face="panel"),
            *hull(1.55, -15, 1.46, -15, 30, 0.26, 30, "#737d8a", "metal", cut=8)
            ,
            *hull(1.55, -10, 1.16, -10, 20, 0.34, 20, "#5d6673", "metal", cut=5, face="vent"),
            # hull belly
            *hull(1.55, -7, 0.92, -7, 14, 0.26, 14, "#4c545f", "metal", cut=4),
            # lights around the rim
            *[blk(1.55, int(round(14.5 * math.cos(a))) - 1, 1.5,
                  int(round(14.5 * math.sin(a))) - 1, 3, 0.16, 3, "#9dfbd4", "lens", glow=True)
              for a in [k * math.pi / 6.0 for k in range(12)]],
        ], anim="bob"),
        part("dome", (0, up(2.05), 0), [
            *dome(2.05, -7, 1.78, -7, 14, 0.42, 14, "#a7e9ff", "lens", steps=2),
            *hull(2.05, -5, 1.86, -5, 10, 0.3, 10, "#d6f6ff", "lens", cut=3),
        ], parent="body", anim="bob"),
        part("head", (0, up(1.6), -4), [
            # the pilot light behind the glass
            *hull(1.6, -4, 1.86, -4, 8, 0.3, 8, "#ffcf6b", "lens", cut=3, glow=True),
            *hull(1.6, -2, 1.9, -2, 4, 0.1, 4, "#fff5d0", "lens", glow=True),
        ], parent="dome", anim="eye"),
        # landing struts
        part("struts", (0, 0.0, 0), [
            *[b for a in [math.pi / 2.0 * k for k in range(3)]
              for b in cone(int(round(11.0 * math.cos(a))), int(GROUND),
                            int(round(11.0 * math.sin(a))), 3, 10, "#6a737f", "metal", steps=3)],
        ], anim="bob"),
    ],
}

# ------------------------------------------------------------------------- 9. Bear
MOBS["bear"] = {
    "class": "BearModel", "shadow": 1.0, "height": 1.8,
    "parts": [
        part("body", (0, up(1.05), 2), [
            *hull(1.05, -11, 1.6, -12, 22, 0.62, 24, "#5b4230", "fur", cut=5),
            *hull(1.05, -9, 1.0, -10, 18, 0.4, 20, "#4d3728", "fur", cut=4),
            # shoulder hump
            *dome(1.05, -8, 1.62, -8, 16, 0.24, 14, "#6a4d36", "fur", steps=2),
            # tail
            blk(1.05, -2, 1.15, 12, 4, 0.2, 3, "#4d3728", "fur"),
        ], anim="bob"),
        part("neck", (0, up(1.35), -7), [
            *hull(1.35, -7, 1.62, -5, 14, 0.5, 9, "#5b4230", "fur", cut=4),
        ], parent="body", anim="head"),
        part("head", (0, up(1.5), -11), [
            *skull(1.5, -6, 1.82, -6, 12, 0.44, 8, "#5f4632", "fur", eye="#2b1c12", glow=False, jaw=False),
            # muzzle
            *hull(1.5, -4, 1.66, -4, 8, 0.3, 5, "#7a5a3f", "fur", cut=2),
            *cone(0, int(up(1.5)), -7, 4, 3, "#2b1c12", "cloth", steps=2, pivot=1.5),
            *teeth_row(-3, -2, -6, 6, 2, 2, 3, "#efe4c9", "bone"),
            # ears
            *dome(1.5, -7, 1.86, -3, 4, 0.14, 4, "#6a4d36", "fur", steps=2),
            *dome(1.5, 3, 1.86, -3, 4, 0.14, 4, "#6a4d36", "fur", steps=2),
        ], parent="neck", anim="head"),
        *leg("leg_0", -8, up(0.95), -7, 7, 8, 5, "#543d2c", "#3b2a1e", "fur"),
        *leg("leg_1", 8, up(0.95), -7, 7, 8, 5, "#543d2c", "#3b2a1e", "fur"),
        *leg("leg_2", -8, up(0.95), 8, 7, 8, 5, "#543d2c", "#3b2a1e", "fur"),
        *leg("leg_3", 8, up(0.95), 8, 7, 8, 5, "#543d2c", "#3b2a1e", "fur"),
    ],
}

# ----------------------------------------------------------------------- 10. Kraken
MOBS["kraken"] = {
    "class": "KrakenModel", "shadow": 2.6, "height": 4.2,
    "parts": [
        part("body", (0, up(2.6), 0), [
            # tall pointed mantle
            *dome(2.6, -11, 2.35, -11, 22, 1.15, 22, "#5a2869", "wet", steps=3, face="scales"),
            *hull(2.6, -10, 2.15, -10, 20, 0.55, 20, "#4c2158", "wet", cut=5),
            *hull(2.6, -8, 1.7, -8, 16, 0.45, 16, "#3f1a4a", "wet", cut=4),
            # head block with eyes at the front
            *hull(2.6, -9, 1.85, -10, 18, 0.5, 8, "#4f2359", "wet", cut=4),
            blk(2.6, -7, 1.6, -12, 4, 0.34, 3, "#ffe07a", "lens", glow=True),
            blk(2.6, 3, 1.6, -12, 4, 0.34, 3, "#ffe07a", "lens", glow=True),
            # beak
            *hull(2.6, -3, 1.25, -13, 6, 0.22, 6, "#2e1336", "wet", cut=2),
            *cone(0, int(up(1.35)), -14, 5, 4, "#e8e0c8", "bone", steps=3, pivot=2.6),
        ], anim="bob"),
        # eight long curling tentacles
        *[part("t_%s%d" % (nm, i), (sx * 8, up(1.75), -8 + i * 5), [
            *[box(-3 + k // 2, k * 5, -3 + k // 2, 7 - k, 6, 7 - k,
                  "#5a2869" if k < 3 else "#4c2158", "wet",
                  face="suckers" if k == 4 else None) for k in range(5)],
            box(-1, 25, -1, 3, 4, 3, "#8f5aa0", "wet"),
        ], parent="body", rot=(8, 0, sx * 26), anim="tentacle")
          for nm, sx in (("l", -1), ("r", 1)) for i in range(4)],
    ],
}
# --------------------------------------------------------------- 11. Evil watermelon
MOBS["evil_watermelon"] = {
    "class": "EvilWatermelonModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.66), 0), [
            *hull(0.66, -10, 0.9, -10, 20, 0.5, 20, "#2f6b28", "melon", cut=6),
            *hull(0.66, -8, 0.42, -8, 16, 0.34, 16, "#265c21", "melon", cut=5),
            *dome(0.66, -8, 0.9, -8, 16, 0.26, 16, "#3b7d31", "melon", steps=2),
            # dark stripes over the rind
            *[blk(0.66, sx * 6 - 1, 0.92, -9, 2, 0.06, 18, "#1d4a19", "melon")
              for sx in (-1, 1)],
            blk(0.66, -9, 0.92, -1, 18, 0.06, 2, "#1d4a19", "melon"),
        ], anim="bob"),
        part("head", (0, up(0.62), -9), [
            # carved face
            *hull(0.62, -7, 0.86, -2, 14, 0.42, 4, "#265c21", "melon", cut=3, face="melon"),
            # jagged mouth with teeth
            blk(0.62, -5, 0.6, -3, 10, 0.34, 2, "#3c0b0b", "flesh"),
            *teeth_row(-4, -2, -4, 8, 3, 2, 4, "#f2e9cf", "bone"),
            *teeth_row(-4, 4, -4, 8, 3, 2, 4, "#f2e9cf", "bone", upper=False),
            # glowing eyes
            blk(0.62, -4, 0.8, -3, 3, 0.2, 2, "#ff5a3c", "lens", glow=True),
            blk(0.62, 1, 0.8, -3, 3, 0.2, 2, "#ff5a3c", "lens", glow=True),
        ], parent="body", anim="head"),
        *leg("leg_0", -6, up(0.4), -5, 3, 4, 3, "#265c21", "#1d4a19", "melon", claw=False),
        *leg("leg_1", 6, up(0.4), -5, 3, 4, 3, "#265c21", "#1d4a19", "melon", claw=False),
        *leg("leg_2", -6, up(0.4), 5, 3, 4, 3, "#265c21", "#1d4a19", "melon", claw=False),
        *leg("leg_3", 6, up(0.4), 5, 3, 4, 3, "#265c21", "#1d4a19", "melon", claw=False),
    ],
}

# ------------------------------------------------------------------- 12. Alive tree
MOBS["alive_tree"] = {
    "class": "AliveTreeModel", "shadow": 2.6, "height": 4.6,
    "parts": [
        part("body", (0, up(2.0), 0), [
            # trunk, thick at the base
            *hull(2.0, -8, 2.3, -8, 16, 1.0, 16, "#5a4227", "bark", cut=4, face="tree"),
            *hull(2.0, -9, 1.4, -9, 18, 0.9, 18, "#4d3822", "bark", cut=4),
            blk(2.0, -10, 0.55, -10, 20, 0.6, 20, "#412f1d", "bark"),
            # root buttresses
            *[b for a in [k * math.pi / 4.0 for k in range(4)]
              for b in cone(int(round(11.0 * math.cos(a))), int(up(0.6)),
                            int(round(11.0 * math.sin(a))), 6, 9, "#3f2e1c", "bark", steps=3,
                            pivot=2.0)],
            # face in the trunk
            blk(2.0, -5, 1.62, -9, 4, 0.24, 2, "#120c07", "bark"),
            blk(2.0, 2, 1.62, -9, 4, 0.24, 2, "#120c07", "bark"),
            blk(2.0, -4, 1.52, -9, 2, 0.12, 1, "#ffdd6b", "lens", glow=True),
            blk(2.0, 3, 1.52, -9, 2, 0.12, 1, "#ffdd6b", "lens", glow=True),
            blk(2.0, -4, 0.95, -9, 8, 0.34, 2, "#140d07", "bark", face="teeth"),
        ], anim="bob"),
        # canopy, sitting right on the trunk
        part("crown", (0, up(2.9), 0), [
            *dome(2.9, -16, 2.6, -16, 32, 0.8, 32, "#2b5425", "leaves", steps=3, face="leaves"),
            *dome(2.9, -14, 3.35, -14, 28, 0.75, 28, "#356330", "leaves", steps=2),
            *dome(2.9, -11, 4.05, -11, 22, 0.65, 22, "#3f7238", "leaves", steps=2),
            *dome(2.9, -8, 4.65, -8, 16, 0.5, 16, "#4a8340", "leaves", steps=2),
            # hanging leaves under the canopy
            *[blk(2.9, x, 2.55, z, 3, 0.3, 3, "#2b5425", "leaves")
              for x, z in ((-13, -6), (10, 4), (-4, 12), (6, -12))],
        ], parent="body", anim="head"),
        *arm("arm_l", -8, up(2.5), 0, 8, 8, 5, "#4d3822", "#3b2a19", style="bark", out=6),
        *arm("arm_r", 8, up(2.5), 0, 8, 8, 5, "#4d3822", "#3b2a19", style="bark", out=6),
        *leg("leg_l", -5, up(1.6), 0, 14, 15, 6, "#463322", "#33251a", "bark", out=2, claw=False),
        *leg("leg_r", 5, up(1.6), 0, 14, 15, 6, "#463322", "#33251a", "bark", out=2, claw=False),
    ],
}
# --------------------------------------------------------------------- 13. Woodcock
MOBS["woodcock"] = {
    "class": "WoodcockModel", "shadow": 0.3, "height": 0.9,
    "parts": [
        part("body", (0, up(0.4), 1), [
            *hull(0.4, -5, 0.56, -7, 10, 0.28, 12, "#6b5335", "feather", cut=3),
            *hull(0.4, -4, 0.36, -6, 8, 0.2, 10, "#5a4529", "feather", cut=2),
            *ridge(-4, 0, 3, 8, 3, 3, 4, "#4b3823", "feather", axis="x"),
        ], anim="bob"),
        part("head", (0, up(0.66), -5), [
            *skull(0.66, -3, 0.8, -4, 6, 0.2, 6, "#7b6140", "feather", eye="#12100c",
                   glow=False, jaw=False),
            blk(0.66, -3, 0.84, -5, 6, 0.1, 4, "#8f7350", "feather"),
            # long straight beak
            *[blk(0.66, -1, 0.72 - i * 0.02, -7 - i * 3, 2, 0.06, 4,
                  "#c8a86a" if i == 0 else "#a8845a", "bone") for i in range(3)],
        ], parent="body", anim="head"),
        part("wing_l", (-5, up(0.46), 0), [
            *hull(0.46, -4, 0.56, -6, 5, 0.16, 12, "#5d472d", "feather", cut=2, face="feather"),
            *ridge(-3, 0, -5, 10, 2, 2, 4, "#6b5335", "feather", axis="z"),
        ], parent="body", rot=(0, 0, 8), anim="wing"),
        part("wing_r", (5, up(0.46), 0), [
            *hull(0.46, -1, 0.56, -6, 5, 0.16, 12, "#5d472d", "feather", cut=2, face="feather"),
            *ridge(-2, 0, -5, 10, 2, 2, 4, "#6b5335", "feather", axis="z"),
        ], parent="body", rot=(0, 0, -8), anim="wing"),
        *[part("leg_%d" % i, (-2 + i * 4, up(0.26), 0), [
            blk(0.26, -1, 0.26, -1, 2, 0.16, 2, "#b08c56", "bone"),
            *toes(-1, 3, 1, 2, 4, 2, 3, "#c09a62", "bone"),
        ], parent="body", anim="leg") for i in range(2)],
    ],
}

# ----------------------------------------------------------------------- 14. Lights
MOBS["lights"] = {
    "class": "LightsModel", "shadow": 0.5, "height": 1.0,
    "parts": [
        part("body", (0, up(0.5), 0), [
            *hull(0.5, -7, 0.82, -6, 14, 0.42, 12, "#81878d", "scales", cut=3, face="scales"),
            *hull(0.5, -6, 0.46, -5, 12, 0.3, 10, "#666c72", "scales", cut=3),
            *hull(0.5, -4, 0.28, -4, 8, 0.2, 8, "#565b60", "scales", cut=2),
            *ridge(-5, 0, -4, 10, 2, 2, 4, "#8f959b", "scales", axis="x"),
        ], anim="bob"),
        part("head", (0, up(0.72), -2), [
            *hull(0.72, -5, 0.98, -5, 10, 0.3, 8, "#9aa0a6", "scales", cut=3, face="scales"),
        ], parent="body", anim="head"),
        part("eye", (0, up(0.7), -6), [
            *hull(0.7, -4, 0.94, -2, 8, 0.3, 3, "#f7fbff", "lens", cut=3, glow=True),
            *hull(0.7, -2, 0.9, -3, 4, 0.16, 1, "#1b262e", "lens", cut=1),
        ], parent="head", anim="eye"),
        *leg("leg_0", -3, up(0.24), -3, 4, 3, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_1", 3, up(0.24), -3, 4, 3, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_2", -3, up(0.24), 3, 4, 3, 3, "#7d8288", "#5c6166", "scales", claw=False),
        *leg("leg_3", 3, up(0.24), 3, 4, 3, 3, "#7d8288", "#5c6166", "scales", claw=False),
    ],
}

# ------------------------------------------------------------------ 15. Chest mimic
MOBS["chest_mimic"] = {
    "class": "ChestMimicModel", "shadow": 0.6, "height": 1.0,
    "parts": [
        part("body", (0, up(0.5), 0), [
            *hull(0.5, -9, 0.82, -7, 18, 0.44, 14, "#8a5a2c", "planks", cut=3, face="chest"),
            *hull(0.5, -8, 0.5, -6, 16, 0.26, 12, "#6d4823", "planks", cut=2),
            # iron bands and lock
            blk(0.5, -9, 0.84, -3, 18, 0.06, 2, "#5b5f66", "metal", face="lock"),
            blk(0.5, -2, 0.84, -7, 4, 0.06, 14, "#5b5f66", "metal"),
            # lid, still open
            *hull(0.9, -9, 1.06, -8, 18, 0.26, 15, "#7d5028", "planks", cut=3, face="board"),
        ], anim="bob"),
        part("head", (0, up(0.75), -7), [
            # maw between lid and box
            *hull(0.75, -8, 0.8, -3, 16, 0.28, 4, "#3a1f10", "flesh", cut=2, face="maw"),
            *teeth_row(-7, -3, -4, 14, 4, 2, 6, "#f1e6cd", "bone"),
            *teeth_row(-7, 4, -4, 14, 4, 2, 6, "#f1e6cd", "bone", upper=False),
            # tongue
            blk(0.75, -2, 0.62, -5, 4, 0.3, 4, "#b8434f", "flesh"),
        ], parent="body", anim="jaw"),
        *leg("leg_0", -6, up(0.42), -4, 3, 4, 3, "#6d4823", "#4a3116", "planks", claw=False),
        *leg("leg_1", 6, up(0.42), -4, 3, 4, 3, "#6d4823", "#4a3116", "planks", claw=False),
        *leg("leg_2", -6, up(0.42), 4, 3, 4, 3, "#6d4823", "#4a3116", "planks", claw=False),
        *leg("leg_3", 6, up(0.42), 4, 3, 4, 3, "#6d4823", "#4a3116", "planks", claw=False),
    ],
}

# ----------------------------------------------------------------- 16. Water grabber
MOBS["water_grabber"] = {
    "class": "WaterGrabberModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(1.05), 0), [
            # shell
            *dome(1.05, -11, 1.02, -10, 22, 0.55, 20, "#a03a52", "wet", steps=3, face="scales"),
            *hull(1.05, -10, 0.86, -9, 20, 0.3, 18, "#7d2b3e", "wet", cut=4),
            *hull(1.05, -8, 0.66, -7, 16, 0.2, 14, "#66212f", "wet", cut=3),
            # carapace spines
            *[b for a in [k * math.pi / 3.0 for k in range(6)]
              for b in cone(int(round(9.0 * math.cos(a))), int(up(1.15)),
                            int(round(8.0 * math.sin(a))), 3, 4, "#c2586f", "bone", steps=2,
                            pivot=1.05)],
        ], anim="bob"),
        part("head", (0, up(0.95), -11), [
            *hull(0.95, -7, 1.12, -3, 14, 0.34, 6, "#b8455f", "wet", cut=3, face="star"),
            blk(0.95, -5, 1.16, -2, 10, 0.2, 4, "#c95a72", "wet", face="trident"),
            blk(0.95, -4, 0.9, -1, 8, 0.24, 4, "#66212f", "wet"),
            blk(0.95, -5, 1.12, -1, 2, 0.12, 2, "#d8ffb0", "lens", glow=True),
            blk(0.95, 3, 1.12, -1, 2, 0.12, 2, "#d8ffb0", "lens", glow=True),
        ], parent="body", anim="head"),
        *[b for i, (x, z) in enumerate([(-10, -6), (-11, 0), (-10, 6),
                                        (10, -6), (11, 0), (10, 6)])
          for b in leg("leg_%d" % i, x, up(0.9), z, 7, 7, 4,
                       "#8c2f45", "#66212f", "wet", out=4, spread=2)],
        # pincers
        *[part("claw_%s" % nm, (sx * 8, up(0.95), -8), [
            *hull(0.95, -3, 1.02, -4, 6, 0.34, 8, "#a03a52", "wet", cut=2, face="suckers"),
            blk(0.95, -2, 0.55, -12, 4, 0.22, 7, "#b8455f", "bone"),
            blk(0.95, -3, 0.36, -12, 3, 0.2, 6, "#c95a72", "bone", face="teeth"),
            blk(0.95, 1, 0.36, -12, 3, 0.2, 6, "#c95a72", "bone"),
        ], parent="body", rot=(14, 0, sx * 18), anim="arm") for nm, sx in (("l", -1), ("r", 1))],
    ],
}

# ------------------------------------------------------------------------- 17. Tank
MOBS["tank"] = {
    "class": "TankModel", "shadow": 1.6, "height": 2.4,
    "parts": [
        part("body", (0, up(1.35), 0), [
            # hull
            *hull(1.35, -15, 1.6, -14, 30, 0.62, 28, "#4d5541", "armor", cut=4, face="plates"),
            *hull(1.35, -13, 1.1, -13, 26, 0.42, 26, "#414835", "armor", cut=3),
            # sloped front plate
            *hull(1.35, -13, 1.28, -16, 26, 0.34, 5, "#565f49", "armor", cut=3, face="armor"),
            # tracks on both sides
            *hull(1.35, -19, 0.75, -15, 7, 0.8, 30, "#2c3128", "armor", cut=2, face="tracks"),
            *hull(1.35, 12, 0.75, -15, 7, 0.8, 30, "#2c3128", "armor", cut=2, face="tracks"),
            *[blk(1.35, sx * 18, 0.42, z, 5, 0.4, 5, "#3a4034", "armor")
              for sx in (-1, 1) for z in (-12, -4, 4, 12)],
            # stowage boxes and exhaust
            *hull(1.35, -12, 1.72, 8, 8, 0.3, 6, "#4a523c", "metal", cut=2, face="crate"),
            *hose(16, -2, 10, 8, 2, "#2f352b", "metal", axis="y", segments=3, sag=1),
            # hatch and antenna
            *dome(1.35, -3, 1.66, 4, 6, 0.16, 6, "#565f49", "armor", steps=2),
            *cone(9, int(up(1.7)), 10, 2, 12, "#6b7360", "metal", steps=3, pivot=1.35),
        ], anim="bob"),
        part("head", (0, up(1.95), 1), [
            # turret
            *hull(1.95, -9, 2.3, -8, 18, 0.55, 16, "#535c46", "armor", cut=4, face="plates"),
            *hull(1.95, -7, 2.42, -6, 14, 0.2, 12, "#5e6850", "armor", cut=3),
            # gun barrel
            blk(1.95, -2, 2.16, -24, 4, 0.34, 16, "#3c4437", "metal"),
            blk(1.95, -3, 2.26, -25, 6, 0.14, 3, "#4a5344", "metal"),
            blk(1.95, -3, 2.1, -12, 6, 0.2, 2, "#4a5344", "metal"),
        ], parent="body", anim="head"),
    ],
}

# ------------------------------------------------------------------- 18. Siren head
MOBS["siren_head"] = {
    "class": "SirenHeadModel", "shadow": 1.6, "height": 9.5,
    "parts": [
        part("body", (0, up(5.6), 0), [
            *hull(5.6, -7, 6.3, -5, 14, 1.5, 10, "#3a3026", "skin", cut=3, face="ribs"),
            *hull(5.6, -5, 4.8, -4, 10, 1.5, 8, "#332a21", "skin", cut=3),
            # ribs
            *ridge(-4, 0, -3, 8, 2, 2, 5, "#4a3d30", "skin", axis="x"),
        ], anim="bob"),
        part("neck", (0, up(6.6), 0), [
            *hull(6.6, -4, 8.4, -4, 8, 1.8, 7, "#463a2d", "skin", cut=2),
        ], parent="body", anim="head"),
        part("head", (0, up(8.4), 0), [
            # speaker housing
            *hull(8.4, -9, 9.4, -8, 18, 1.0, 15, "#6a6055", "metal", cut=5, face="speaker"),
            *hull(8.4, -7, 9.5, -6, 14, 0.2, 11, "#7a6f62", "metal", cut=3),
            # two sirens on top
            *[b for sx in (-1, 1)
              for b in cone(sx * 6, int(up(9.45)), 0, 7, 8, "#8a7f70", "metal", steps=3,
                          pivot=8.4)],
            # speaker cones facing forward
            *[b for sx in (-1, 1)
              for b in cone(sx * 5, int(up(8.8)), -10, 9, 6, "#2c2620", "metal", steps=3,
                          pivot=8.4)],
            blk(8.4, -1, 9.52, -8, 2, 0.2, 1, "#ff6b3c", "lens", glow=True),
        ], parent="neck", anim="head"),
        *arm("arm_l", -4, up(6.2), 0, 22, 20, 4, "#3a3026", "#2c241c", style="skin", out=3),
        *arm("arm_r", 4, up(6.2), 0, 22, 20, 4, "#3a3026", "#2c241c", style="skin", out=3),
        *leg("leg_l", -4, up(4.6), 0, 27, 30, 7, "#3a3026", "#2c241c", "skin", out=2, claw=False),
        *leg("leg_r", 4, up(4.6), 0, 27, 30, 7, "#3a3026", "#2c241c", "skin", out=2, claw=False),
    ],
}

# ---------------------------------------------------------------------- 19. Warship
MOBS["warship"] = {
    "class": "WarshipModel", "shadow": 3.0, "height": 6.0,
    "parts": [
        part("body", (0, up(2.6), 6), [
            # hull: long, tapering towards bow (-z) and stern (+z)
            *hull(2.6, -11, 3.9, -34, 22, 1.5, 56, "#5a636f", "metal", cut=5, face="hull"),
            *hull(2.6, -9, 2.6, -30, 18, 0.7, 48, "#49525e", "metal", cut=4),
            *hull(2.6, -7, 4.15, -22, 14, 0.3, 34, "#6b7480", "metal", cut=3, face="deck"),
            # bow
            *hull(2.6, -8, 4.0, -38, 16, 1.2, 8, "#5a636f", "metal", cut=4),
            # stern block
            *hull(2.6, -8, 4.05, 22, 16, 0.9, 8, "#525b66", "metal", cut=3),
            # hull side detail
            blk(2.6, -11, 3.3, -30, 1, 0.4, 50, "#414a54", "metal"),
            blk(2.6, 10, 3.3, -30, 1, 0.4, 50, "#414a54", "metal"),
            # anchor chains
            *bolts(-10, 1, -30, 50, 6, 2, "#7d8794", "metal", axis="z"),
        ], anim="bob"),
        part("bridge", (0, up(4.3), -6), [
            *hull(4.3, -8, 5.6, -9, 16, 1.35, 18, "#6b7480", "metal", cut=3, face="windows"),
            *hull(4.3, -6, 6.1, -7, 12, 0.5, 14, "#7d8794", "metal", cut=2),
            *hull(4.3, -4, 6.4, -5, 8, 0.3, 10, "#8a949f", "metal", cut=2),
            *cone(0, int(up(6.7)), -4, 2, 14, "#9aa3ad", "metal", steps=4, pivot=4.3),
        ], parent="body", anim="head"),
        # funnels
        *[part("funnel_%d" % i, (0, up(5.3), 4 + i * 10), [
            *hull(5.3, -4, 6.0, -4, 8, 0.7, 8, "#4d5560", "metal", cut=2, face="funnel"),
            *hull(5.3, -3, 6.1, -3, 6, 0.16, 6, "#2f343b", "metal", cut=1),
        ], parent="body", anim="bob") for i in range(2)],
        # turrets with barrels
        *[part("turret_%d" % i, (0, up(4.25), z), [
            *hull(4.25, -5, 4.75, -5, 10, 0.5, 10, "#5f6874", "metal", cut=3, face="plates"),
            blk(4.25, -3, 4.5, -14, 2, 0.2, 9, "#3f464f", "metal"),
            blk(4.25, 1, 4.5, -14, 2, 0.2, 9, "#3f464f", "metal"),
        ], parent="body", anim="head") for i, z in enumerate((-18, 14))],
    ],
}

# --------------------------------------------------------------------- 20. Circuit
MOBS["circuit"] = {
    "class": "CircuitModel", "shadow": 1.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.35), 0), [
            *hull(1.35, -7, 1.85, -5, 14, 0.5, 10, "#1d4a3f", "circuit", cut=3, face="board"),
            *hull(1.35, -6, 1.35, -4, 12, 0.5, 8, "#173c33", "circuit", cut=3),
            # PCB edge connectors
            blk(1.35, -6, 1.88, -5, 12, 0.08, 2, "#2f7a63", "circuit"),
            *bolts(-6, 1, -5, 12, 3, 2, "#7fe6c0", "lens"),
        ], anim="bob"),
        part("head", (0, up(1.98), 0), [
            *hull(1.98, -6, 2.2, -5, 12, 0.42, 10, "#234f42", "circuit", cut=3, face="screen"),
            *hull(1.98, -4, 2.24, -6, 8, 0.1, 2, "#0c2a24", "circuit", cut=1),
        ], parent="body", anim="head"),
        part("face", (0, up(2.1), -6), [
            blk(2.1, -4, 2.2, -6, 8, 0.22, 1, "#123a31", "circuit", face="board"),
            blk(2.1, -3, 2.14, -7, 2, 0.1, 1, "#8dffd0", "lens", glow=True),
            blk(2.1, 1, 2.14, -7, 2, 0.1, 1, "#8dffd0", "lens", glow=True),
        ], parent="head", anim="eye"),
        *leg("leg_l", -5, up(1.05), 0, 8, 9, 4, "#1d4a3f", "#123a31", "circuit"),
        *leg("leg_r", 5, up(1.05), 0, 8, 9, 4, "#1d4a3f", "#123a31", "circuit"),
        *arm("arm_l", -7, up(1.7), 0, 10, 9, 3, "#204d40", "#123a31", style="circuit", out=2, claw=True),
        *arm("arm_r", 7, up(1.7), 0, 10, 9, 3, "#204d40", "#123a31", style="circuit", out=2, claw=True),
    ],
}

# -------------------------------------------------------------------- 21. Ash hound
MOBS["ash_hound"] = {
    "class": "AshHoundModel", "shadow": 0.7, "height": 1.3,
    "parts": [
        part("body", (0, up(0.82), 0), [
            *hull(0.82, -6, 1.14, -10, 12, 0.4, 20, "#4a4038", "ash", cut=3, face="ribs"),
            *hull(0.82, -5, 0.86, -9, 10, 0.3, 18, "#3c332c", "ash", cut=3),
            # ember spine
            *[b for i in range(5)
              for b in cone(0, int(up(1.14)), -8 + i * 4, 2, 4, "#8a5a3a", "bone", steps=2,
                          pivot=0.82)],
            blk(0.82, -1, 1.16, -3, 2, 0.08, 8, "#ff7a3c", "lens", glow=True),
        ], anim="bob"),
        part("neck", (0, up(1.0), -9), [
            *hull(1.0, -4, 1.24, -3, 8, 0.34, 8, "#4a4038", "ash", cut=3),
        ], parent="body", anim="head"),
        part("head", (0, up(1.06), -14), [
            *skull(1.06, -4, 1.28, -4, 8, 0.3, 6, "#544940", "ash", eye="#ff8a4c", glow=True, jaw=False),
            # long muzzle
            *hull(1.06, -3, 1.16, -6, 6, 0.26, 8, "#5e5248", "ash", cut=2),
            blk(1.06, -1, 1.0, -7, 2, 0.1, 3, "#2a1a12", "cloth"),
            *teeth_row(-2, 1, -7, 4, 2, 2, 3, "#efe4c9", "bone"),
            # ears
            *cone(-3, int(up(1.34)), -3, 2, 5, "#4a4038", "ash", steps=2, pivot=1.06),
            *cone(2, int(up(1.34)), -3, 2, 5, "#4a4038", "ash", steps=2, pivot=1.06),
        ], parent="neck", anim="head"),
        *leg("leg_0", -5, up(0.7), -7, 7, 7, 3, "#423a33", "#2e2721", "ash", claw=True),
        *leg("leg_1", 5, up(0.7), -7, 7, 7, 3, "#423a33", "#2e2721", "ash", claw=True),
        *leg("leg_2", -5, up(0.7), 6, 7, 7, 3, "#423a33", "#2e2721", "ash", claw=True),
        *leg("leg_3", 5, up(0.7), 6, 7, 7, 3, "#423a33", "#2e2721", "ash", claw=True),
    ],
}

# ------------------------------------------------------------------- 22. Cloud ray
MOBS["cloud_ray"] = {
    "class": "CloudRayModel", "shadow": 1.6, "height": 1.6,
    "parts": [
        part("body", (0, up(1.2), 0), [
            *hull(1.2, -8, 1.44, -9, 16, 0.3, 18, "#dfe8f2", "cloud", cut=5),
            *hull(1.2, -6, 1.28, -7, 12, 0.2, 14, "#eef4fb", "cloud", cut=4),
            *hull(1.2, -5, 1.18, -6, 10, 0.14, 12, "#c7d6e6", "cloud", cut=3, face="ray_eye"),
            *ridge(-4, 0, -6, 8, 2, 2, 3, "#f4f9ff", "cloud", axis="z"),
        ], anim="bob"),
        # wings: wide flat plates
        *[part("wing_%s" % nm, (sx * 8, up(1.3), -2), [
            *hull(1.3, -2 if sx < 0 else 0, 1.42, -7, 14, 0.14, 16, "#e6eef8", "cloud", cut=3,
                  face="feather"),
            *hull(1.3, -1 if sx < 0 else 0, 1.36, -5, 11, 0.1, 12, "#f6faff", "cloud", cut=2),
        ], parent="body", rot=(0, 0, sx * 6), anim="wing") for nm, sx in (("l", -1), ("r", 1))],
        part("tail", (0, up(1.22), 8), [
            *[blk(1.22, -1, 1.3 - i * 0.02, i * 4, 2 - i // 3, 0.08, 4, "#c7d6e6", "cloud")
              for i in range(4)],
        ], parent="body", rot=(-8, 0, 0), anim="tentacle"),
    ],
}

# ------------------------------------------------------------------- 23. Bog wretch
MOBS["bog_wretch"] = {
    "class": "BogWretchModel", "shadow": 1.0, "height": 2.2,
    "parts": [
        part("body", (0, up(1.35), 0), [
            # hunched torso
            *hull(1.35, -8, 1.85, -6, 16, 0.6, 12, "#3b4a2c", "skin", cut=4, face="ribs"),
            *hull(1.35, -7, 1.3, -5, 14, 0.5, 10, "#33412a", "skin", cut=3),
            # shoulder hunch
            *dome(1.35, -8, 1.88, -7, 16, 0.2, 14, "#42522f", "skin", steps=2),
            # rags hanging from the hips
            *hull(1.35, -9, 0.92, -7, 18, 0.9, 14, "#2f3a22", "cloth", cut=4, face="rags"),
            *ridge(-8, 0, -6, 16, 3, 2, 5, "#4d5f38", "skin", axis="x"),
        ], anim="bob"),
        part("head", (0, up(1.9), -6), [
            *skull(1.9, -5, 2.2, -5, 10, 0.32, 8, "#46552f", "skin", eye="#d6ff8a", glow=True),
            *hull(1.9, -4, 1.98, -6, 8, 0.2, 4, "#3b4a2c", "skin", cut=2),
            *teeth_row(-3, 1, -7, 6, 2, 2, 4, "#e6dcb8", "bone"),
        ], parent="body", anim="head"),
        *arm("arm_l", -8, up(1.7), -1, 14, 13, 3, "#3b4a2c", "#2a3520", style="skin", out=4, claw=True),
        *arm("arm_r", 8, up(1.7), -1, 14, 13, 3, "#3b4a2c", "#2a3520", style="skin", out=4, claw=True),
        *leg("leg_l", -5, up(0.95), 0, 9, 10, 4, "#33412a", "#243019", "skin", claw=True),
        *leg("leg_r", 5, up(0.95), 0, 9, 10, 4, "#33412a", "#243019", "skin", claw=True),
    ],
}

# -------------------------------------------------------------- 24. Lantern wraith
MOBS["lantern_wraith"] = {
    "class": "LanternWraithModel", "shadow": 0.7, "height": 2.0,
    "parts": [
        part("body", (0, up(1.1), 0), [
            # robe, wide at the hem
            *hull(1.1, -8, 1.6, -6, 16, 0.9, 12, "#2a2f3c", "cloth", cut=4, face="robe"),
            *hull(1.1, -9, 0.9, -7, 18, 0.5, 14, "#222633", "cloth", cut=4),
            *[blk(1.1, -9 + i * 4, 0.62, -6, 2, 0.4, 3, "#191d25", "cloth", face="rags")
              for i in range(5)],
            # rope belt
            blk(1.1, -8, 1.62, -6, 16, 0.1, 12, "#3a3326", "bone"),
        ], anim="bob"),
        part("head", (0, up(1.75), 0), [
            *skull(1.75, -5, 1.98, -5, 10, 0.34, 10, "#161a22", "cloth", eye="#74c9ff",
                   glow=True, jaw=False),
            # hood
            *dome(1.75, -7, 2.02, -7, 14, 0.3, 14, "#10131a", "cloth", steps=2),
        ], parent="body", anim="head"),
        part("orb", (0, up(1.5), -7), [
            *hull(1.5, -4, 1.72, -4, 8, 0.28, 8, "#74c9ff", "lens", cut=3, glow=True),
            *hull(1.5, -3, 1.76, -3, 6, 0.14, 6, "#bfe9ff", "lens", cut=2, glow=True),
            blk(1.5, -5, 1.78, -1, 10, 0.08, 2, "#8b7a56", "metal"),
            blk(1.5, -1, 1.84, -1, 2, 0.1, 2, "#8b7a56", "metal"),
        ], parent="body", anim="eye"),
        *arm("arm_l", -8, up(1.6), 0, 12, 11, 3, "#2a2f3c", "#1c2029", style="cloth", out=3),
        *arm("arm_r", 8, up(1.6), 0, 12, 11, 3, "#2a2f3c", "#1c2029", style="cloth", out=3),
    ],
}

# ------------------------------------------------------------- 25. Hollow neighbor
MOBS["hollow_neighbor"] = {
    "class": "HollowNeighborModel", "shadow": 0.9, "height": 2.1,
    "parts": [
        part("body", (0, up(1.3), 0), [
            # long coat
            *hull(1.3, -7, 1.75, -5, 14, 0.55, 10, "#4a3a2c", "cloth", cut=3, face="robe"),
            *hull(1.3, -8, 1.2, -6, 16, 0.6, 12, "#40311f", "cloth", cut=4, face="rags"),
            *hull(1.3, -9, 0.72, -7, 18, 0.5, 14, "#372a1c", "cloth", cut=4),
            # collar
            *hull(1.3, -6, 1.78, -5, 12, 0.16, 10, "#5a4632", "cloth", cut=3),
        ], anim="bob"),
        part("head", (0, up(1.92), 0), [
            *skull(1.92, -5, 2.1, -5, 10, 0.36, 9, "#c9b393", "skin", eye="#0d0a07",
                   glow=False, jaw=False),
            # wide empty grin
            blk(1.92, -4, 1.8, -6, 8, 0.2, 1, "#221610", "cloth", face="teeth"),
            blk(1.92, -3, 1.84, -6, 6, 0.14, 1, "#f2ead6", "bone", face="teeth"),
        ], parent="body", anim="head"),
        *arm("arm_l", -7, up(1.68), 0, 16, 15, 3, "#4a3a2c", "#372a1c", style="cloth", out=3),
        *arm("arm_r", 7, up(1.68), 0, 16, 15, 3, "#4a3a2c", "#372a1c", style="cloth", out=3),
        *leg("leg_l", -4, up(0.9), 0, 10, 11, 4, "#33281c", "#241c13", "cloth", claw=False),
        *leg("leg_r", 4, up(0.9), 0, 10, 11, 4, "#33281c", "#241c13", "cloth", claw=False),
    ],
}

# --------------------------------------------------------------------- 26. Tornado
MOBS["tornado"] = {
    "class": "TornadoModel", "shadow": 0.0, "height": 12.0,
    "parts": [
        part("body", (0, up(12.0), 0), [
            # funnel: narrow at the ground, widening towards the top
            *rings(0, 0, 0.05, 4.2, 8.0, 15.0, 14, "#8f98a5", "storm", curve=(3, 2),
                   groove="#7b8492", face="vortex", pivot=12.0),
            *rings(0, 1, 4.2, 4.0, 15.0, 23.0, 14, "#a3acb8", "storm", curve=(-4, -3),
                   groove="#8b94a1", face="vortex", pivot=12.0),
            *rings(0, 0, 8.2, 3.4, 23.0, 32.0, 12, "#b6bec9", "storm", curve=(3, 3),
                   groove="#98a1ae", face="vortex", pivot=12.0),
            # debris swept up in the wind
            *[box(int(round(6.0 * math.cos(a))) - 2, int(up(1.2 + i * 1.6)) - int(up(12.0)),
                  int(round(6.0 * math.sin(a))) - 2, 4, 2, 4,
                  "#5a4227" if i % 2 else "#3b4a2c", "bark" if i % 2 else "leaves")
              for i, a in enumerate([k * 1.1 for k in range(7)])],
        ], anim="spin"),
        part("core", (0, up(11.5), 0), [
            *rings(0, 0, 0.5, 10.0, 2.0, 6.0, 10, "#e8f2ff", "storm", curve=(1, 0),
                   pivot=11.5),
        ], parent="body", anim="spin"),
        part("eye", (0, up(11.6), 0), [
            *hull(11.6, -6, 11.9, -6, 12, 0.3, 12, "#cfe6ff", "lens", cut=4, glow=True),
        ], parent="body", anim="eye"),
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
