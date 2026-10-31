#!/usr/bin/env python3
"""Offline preview renderer for the Random Mobs creature models.

Rasterises the very same cuboids that generate_assets.py writes into the Java models,
using the generated texture atlas, so the look of a mob can be checked without launching
Minecraft.

    python3 tools/render_preview.py                 # every mob, 3 views each
    python3 tools/render_preview.py woodcrawler     # just one

Output: tools/preview/<mob>.png and tools/preview/all_mobs.png
"""
import math
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from models import MOBS  # noqa: E402
from generate_assets import ENTITY_TEX, face_rects, model_metrics, pack  # noqa: E402

from PIL import Image, ImageDraw  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
OUT = os.path.join(ROOT, "tools", "preview")

SUPERSAMPLE = 2
VIEW_W, VIEW_H = 400, 440
LIGHT = (0.45, -0.75, 0.5)  # key light, from the upper front-left
FILL = (-0.6, 0.3, -0.55)   # cool bounce from the opposite side


def norm(v):
    length = math.sqrt(sum(c * c for c in v)) or 1.0
    return tuple(c / length for c in v)


def rot_matrix(rot):
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


def apply(m, v):
    return tuple(sum(m[i][k] * v[k] for k in range(3)) for i in range(3))


# (origin, x-axis, y-axis, normal) in box fractions; all inner values are 0 or 1
FACES = {
    "west": ((0, 0, 1), (0, 0, -1), (0, 1, 0), (-1, 0, 0)),
    "east": ((1, 0, 0), (0, 0, 1), (0, 1, 0), (1, 0, 0)),
    "north": ((0, 0, 0), (1, 0, 0), (0, 1, 0), (0, 0, -1)),
    "south": ((1, 0, 1), (-1, 0, 0), (0, 1, 0), (0, 0, 1)),
    "up": ((0, 1, 1), (1, 0, 0), (0, 0, -1), (0, 1, 0)),
    "down": ((0, 0, 0), (1, 0, 0), (0, 0, 1), (0, -1, 0)),
}


def build_quads(spec, texture, scale):
    """Returns a list of triangles: (points3d, uvs, color_mul)."""
    by_name = {p["name"]: p for p in spec["parts"]}
    boxes = [b for p in spec["parts"] for b in p["boxes"]]
    placed, _ = pack(boxes, texture.width)
    tris = []
    tw, th = texture.size
    for part in spec["parts"]:
        chain = []
        cur = part
        while cur is not None:
            chain.append(cur)
            parent = cur.get("parent")
            cur = by_name.get(parent) if parent else None
        chain.reverse()
        for box in part["boxes"]:
            u, v, _, _ = placed[boxes.index(box)]
            rects = face_rects(u, v, box["w"], box["h"], box["d"])
            for face, (o, ax, ay, n) in FACES.items():
                rx, ry, rw, rh = rects[face]
                if rw <= 0 or rh <= 0:
                    continue
                corners = []
                uvs = []
                for (sx, sy) in ((0, 0), (1, 0), (1, 1), (0, 1)):
                    p = (box["x"] + (o[0] + ax[0] * sx + ay[0] * sy) * box["w"],
                         box["y"] + (o[1] + ax[1] * sx + ay[1] * sy) * box["h"],
                         box["z"] + (o[2] + ax[2] * sx + ay[2] * sy) * box["d"])
                    for node in chain:
                        p = apply(rot_matrix(node.get("rot")), p)
                        p = (p[0] + node["pivot"][0], p[1] + node["pivot"][1], p[2] + node["pivot"][2])
                    # model units -> blocks, y flips so that the feet sit on y = 0
                    world = (p[0] / 16.0, (24.0 - p[1]) / 16.0, p[2] / 16.0)
                    corners.append(tuple(c * scale for c in world))
                    uvs.append((rx + sx * (rw - 1), ry + sy * (rh - 1)))
                normal = norm(n)
                key = max(0.0, sum(normal[i] * LIGHT[i] for i in range(3)))
                fill = max(0.0, sum(normal[i] * FILL[i] for i in range(3)))
                ambient = 0.46 + 0.14 * max(0.0, -normal[1])
                mul = ambient + 0.52 * key + 0.16 * fill
                tris.append(((corners[0], corners[1], corners[2]),
                             (uvs[0], uvs[1], uvs[2]), mul, tw, th))
                tris.append(((corners[0], corners[2], corners[3]),
                             (uvs[0], uvs[2], uvs[3]), mul, tw, th))
    return tris


def camera(yaw_deg, pitch_deg):
    """Returns (to_camera, right, up) for an orbit camera around the model."""
    yaw, pitch = math.radians(yaw_deg), math.radians(pitch_deg)
    to_cam = (math.sin(yaw) * math.cos(pitch), math.sin(pitch), math.cos(yaw) * math.cos(pitch))
    right = norm((to_cam[2], 0.0, -to_cam[0]))
    up = norm((to_cam[1] * right[2] - to_cam[2] * right[1],
               to_cam[2] * right[0] - to_cam[0] * right[2],
               to_cam[0] * right[1] - to_cam[1] * right[0]))
    return to_cam, right, up


def background(w, h):
    img = Image.new("RGB", (w, h))
    px = img.load()
    for y in range(h):
        t = y / max(1, h - 1)
        top = (30, 33, 42)
        bottom = (12, 13, 17)
        color = tuple(int(top[i] + (bottom[i] - top[i]) * (t ** 0.8)) for i in range(3))
        for x in range(w):
            px[x, y] = color
    return img, px


def render(spec, texture, yaw, pitch, center, extent):
    w, h = VIEW_W * SUPERSAMPLE, VIEW_H * SUPERSAMPLE
    img, px = background(w, h)
    scale_px = (min(w, h) / extent) * 0.82
    to_cam, right, up = camera(yaw, pitch)
    scale = model_metrics(spec)[1]

    # soft contact shadow under the creature
    ground_pt = (center[0], 0.0, center[2])
    gx = w / 2 + sum(ground_pt[i] * right[i] for i in range(3)) * scale_px - 0 * scale_px
    gy = h / 2 - sum(ground_pt[i] * up[i] for i in range(3)) * scale_px
    gx = w / 2 + ((ground_pt[0] - center[0]) * right[0] + ground_pt[1] * right[1]
                  + (ground_pt[2] - center[2]) * right[2]) * scale_px
    gy = h / 2 - (((ground_pt[0] - center[0]) * up[0] + (ground_pt[1] - center[1]) * up[1]
                   + (ground_pt[2] - center[2]) * up[2]) * scale_px)
    shadow_rx = max(12, extent * scale_px * 0.34)
    shadow_ry = max(6, shadow_rx * 0.3)
    for i in range(9, 0, -1):
        k = i / 9.0
        dark = int(6 + 16 * (1.0 - k))
        px_draw = ImageDraw.Draw(img)
        px_draw.ellipse([gx - shadow_rx * k, gy - shadow_ry * k, gx + shadow_rx * k, gy + shadow_ry * k],
                        fill=(min(255, 12 + dark), min(255, 13 + dark), min(255, 17 + dark)))

    projected = []
    for tri, uvs, mul, tw, th in build_quads(spec, texture, scale):
        pts = []
        ds = []
        depth = 0.0
        for p in tri:
            q = (p[0] - center[0], p[1] - center[1], p[2] - center[2])
            sx = w / 2 + q[0] * right[0] * scale_px + q[1] * right[1] * scale_px + q[2] * right[2] * scale_px
            sy = h / 2 - (q[0] * up[0] + q[1] * up[1] + q[2] * up[2]) * scale_px
            d = q[0] * to_cam[0] + q[1] * to_cam[1] + q[2] * to_cam[2]
            pts.append((sx, sy))
            ds.append(d)
            depth += d
        projected.append((depth / 3.0, pts, ds, uvs, mul, tw, th))
    projected.sort(key=lambda t: t[0])

    zbuf = [[1e9] * w for _ in range(h)]
    for _, pts, ds, uvs, mul, tw, th in projected:
        rasterise(px, zbuf, pts, ds, uvs, mul, texture, tw, th, w, h)
    img = img.resize((VIEW_W, VIEW_H), Image.LANCZOS)
    return img


def rasterise(px, zbuf, pts, depths, uvs, mul, texture, tw, th, w, h):
    (x0, y0), (x1, y1), (x2, y2) = pts
    area = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0)
    if abs(area) < 1e-9:
        return
    minx = max(0, int(min(x0, x1, x2)))
    maxx = min(w - 1, int(max(x0, x1, x2)) + 1)
    miny = max(0, int(min(y0, y1, y2)))
    maxy = min(h - 1, int(max(y0, y1, y2)) + 1)
    if minx > maxx or miny > maxy:
        return
    src = texture.load()
    for y in range(miny, maxy + 1):
        cy = y + 0.5
        for x in range(minx, maxx + 1):
            cx = x + 0.5
            w0 = ((x1 - cx) * (y2 - cy) - (x2 - cx) * (y1 - cy)) / area
            w1 = ((x2 - cx) * (y0 - cy) - (x0 - cx) * (y2 - cy)) / area
            w2 = 1.0 - w0 - w1
            if w0 < 0 or w1 < 0 or w2 < 0:
                continue
            depth = depths[0] * w0 + depths[1] * w1 + depths[2] * w2
            if depth >= zbuf[y][x]:
                continue
            tu = uvs[0][0] * w0 + uvs[1][0] * w1 + uvs[2][0] * w2
            tv = uvs[0][1] * w0 + uvs[1][1] * w1 + uvs[2][1] * w2
            r, g, b, a = src[int(tu) % tw, int(tv) % th]
            if a < 32:
                continue
            zbuf[y][x] = depth
            px[x, y] = (min(255, int(r * mul)), min(255, int(g * mul)), min(255, int(b * mul)))


def model_extent(spec):
    """Axis aligned bounds of the finished model in blocks (y from the ground up)."""
    by_name = {p["name"]: p for p in spec["parts"]}
    shift, scale = model_metrics(spec)
    lo = [1e9, 1e9, 1e9]
    hi = [-1e9, -1e9, -1e9]
    for part in spec["parts"]:
        chain = []
        cur = part
        while cur is not None:
            chain.append(cur)
            parent = cur.get("parent")
            cur = by_name.get(parent) if parent else None
        chain.reverse()
        for b in part["boxes"]:
            for cx in (b["x"], b["x"] + b["w"]):
                for cy in (b["y"], b["y"] + b["h"]):
                    for cz in (b["z"], b["z"] + b["d"]):
                        v = [float(cx), float(cy), float(cz)]
                        for node in chain:
                            v = list(apply(rot_matrix(node.get("rot")), v))
                            v = [v[i] + node["pivot"][i] for i in range(3)]
                        world = (v[0] / 16.0 * scale, (24.0 - v[1]) / 16.0 * scale, v[2] / 16.0 * scale)
                        for i in range(3):
                            lo[i] = min(lo[i], world[i])
                            hi[i] = max(hi[i], world[i])
    return lo, hi


def render_mob(name, spec, views=None):
    path = os.path.join(ENTITY_TEX, name + ".png")
    texture = Image.open(path).convert("RGBA")
    lo, hi = model_extent(spec)
    center = tuple((lo[i] + hi[i]) / 2.0 for i in range(3))
    diag = math.sqrt(sum((hi[i] - lo[i]) ** 2 for i in range(3)))
    extent = max(diag * 1.02, 0.8)
    views = views or ((-28, 8), (-90, 4), (0, 14))
    frames = [render(spec, texture, yaw, pitch, center, extent) for (yaw, pitch) in views]
    sheet = Image.new("RGB", (VIEW_W * len(frames), VIEW_H), (18, 20, 26))
    for i, frame in enumerate(frames):
        sheet.paste(frame, (i * VIEW_W, 0))
    return sheet


def main():
    os.makedirs(OUT, exist_ok=True)
    wanted = sys.argv[1:] or list(MOBS.keys())
    sheets = []
    for name in wanted:
        if name not in MOBS:
            print("unknown mob", name)
            continue
        sheet = render_mob(name, MOBS[name])
        sheet.save(os.path.join(OUT, name + ".png"))
        sheets.append((name, sheet))
        print("rendered", name)
    if len(sheets) > 1:
        cols = 4
        cell_w, cell_h = VIEW_W * 3 // 2, VIEW_H // 2
        rows = (len(sheets) + cols - 1) // cols
        contact = Image.new("RGB", (cols * cell_w, rows * cell_h), (14, 15, 19))
        for i, (_, sheet) in enumerate(sheets):
            thumb = sheet.resize((cell_w - 8, cell_h - 8), Image.LANCZOS)
            contact.paste(thumb, ((i % cols) * cell_w + 4, (i // cols) * cell_h + 4))
        contact.save(os.path.join(OUT, "all_mobs.png"))
        print("contact sheet:", os.path.join(OUT, "all_mobs.png"))


if __name__ == "__main__":
    main()
