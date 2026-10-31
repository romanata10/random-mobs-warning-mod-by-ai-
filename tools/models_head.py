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


