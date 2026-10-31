#!/usr/bin/env python3
"""Generates model + texture assets for the Random Mobs mod (v2).

Textures are painted per cube face (up/down/west/north/east/south) at 2 pixels per
model unit, so eyes, panels and materials look like actual art instead of noise.

Run:  python3 tools/generate_assets.py
"""
import math
import os
import random
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from models import MOBS  # noqa: E402

from PIL import Image, ImageDraw  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ASSETS = os.path.join(ROOT, "src/main/resources/assets/randommobs")
MODEL_JAVA = os.path.join(ROOT, "src/main/java/com/arena/randommobs/entity/client/model")
ENTITY_TEX = os.path.join(ASSETS, "textures/entity")

UV = 2  # texels per model unit


def hex_rgb(value):
    value = value.lstrip("#")
    return tuple(int(value[i:i + 2], 16) for i in (0, 2, 4))


def clamp(color):
    return tuple(max(0, min(255, int(c))) for c in color)


def shade(color, factor):
    return clamp(tuple(c * factor for c in color))


def mix(a, b, t):
    return clamp(tuple(a[i] + (b[i] - a[i]) * t for i in range(3)))


def _hash01(ix, iy, seed):
    n = (ix * 374761393 + iy * 668265263 + seed * 2246822519) & 0xFFFFFFFF
    n = ((n ^ (n >> 13)) * 1274126177) & 0xFFFFFFFF
    return ((n ^ (n >> 16)) & 0xFFFF) / 65535.0


def value_noise(x, y, seed=0, freq=4.0):
    fx, fy = x / freq, y / freq
    ix, iy = math.floor(fx), math.floor(fy)
    tx, ty = fx - ix, fy - iy
    sx, sy = tx * tx * (3.0 - 2.0 * tx), ty * ty * (3.0 - 2.0 * ty)
    a = _hash01(ix, iy, seed)
    b = _hash01(ix + 1, iy, seed)
    c = _hash01(ix, iy + 1, seed)
    d = _hash01(ix + 1, iy + 1, seed)
    return (a * (1.0 - sx) + b * sx) * (1.0 - sy) + (c * (1.0 - sx) + d * sx) * sy


def fbm(x, y, seed=0, freq=4.0, octaves=2):
    total, amp, f, weight = 0.0, 1.0, freq, 0.0
    for o in range(octaves):
        total += value_noise(x, y, seed + o * 31, f) * amp
        weight += amp
        amp *= 0.5
        f *= 2.1
    return total / weight


def boost(color, sat=1.18, lum=1.06):
    """A little more punch: saturation up, brightness slightly up."""
    r, g, b = color
    grey = (r + g + b) / 3.0
    r, g, b = (grey + (c - grey) * sat for c in (r, g, b))
    return clamp((r * lum + 6, g * lum + 6, b * lum + 4))


def tone(base, t):
    """t in [-1, 1]: negative goes to a cool shadow, positive to a warm highlight."""
    t = max(-1.0, min(1.0, t))
    if t < 0:
        shadow = (base[0] * 0.52 + 8, base[1] * 0.56 + 8, base[2] * 0.68 + 12)
        return mix(base, shadow, -t)
    light = (min(255, base[0] * 1.22 + 30), min(255, base[1] * 1.2 + 26), min(255, base[2] * 1.1 + 18))
    return mix(base, light, t)


def box_px(box):
    """Integer texel size of a box's UV island."""
    w = int(round((2 * box["d"] + 2 * box["w"]) * UV))
    h = int(round((box["d"] + box["h"]) * UV))
    return max(1, w), max(1, h)


def pack(boxes, width):
    placed, x, y, shelf = [], 0, 0, 0
    for b in boxes:
        w, h = box_px(b)
        if x + w > width:
            x, y, shelf = 0, y + shelf + 1, 0
        placed.append((x, y, w, h))
        x += w + 1
        shelf = max(shelf, h)
    return placed, y + shelf


def next_pow2(v):
    p = 1
    while p < v:
        p *= 2
    return p


# --------------------------------------------------------------------------- materials
def material_px(style, base, x, y, w, h, rng):
    """Returns a color for pixel (x,y) inside a face of size (w,h)."""
    t = y / max(h - 1, 1)
    if style == "metal":
        grain = fbm(x, y, 11, 5.0)
        c = tone(base, 0.24 - 0.5 * t + (grain - 0.5) * 0.28)
        if x % 6 == 0:
            c = shade(c, 0.9)
        if (x % 11 == 3) and (y % 9 == 4):
            c = shade(c, 1.25)
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "milmetal":
        c = shade(base, 1.05 - 0.12 * t)
        if ((x // 7) + (y // 9)) % 3 == 0:
            c = mix(c, shade(base, 0.7), 0.35)
        if rng.random() < 0.06:
            c = shade(c, 1.2)
        return c
    if style in ("planks", "wood"):
        row = (y // 5) % 2
        c = shade(base, 1.04 if row == 0 else 0.9)
        if y % 5 == 0:
            c = shade(c, 0.78)
        if style == "wood" and (x + y * 3) % 13 == 0:
            c = shade(c, 0.72)
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "bark":
        c = shade(base, 1.0 + 0.12 * math.sin(x * 0.9))
        if y % 7 == 0:
            c = shade(c, 0.75)
        return shade(c, 1.0 + rng.uniform(-0.07, 0.07))
    if style == "chitin":
        band = 0.2 * math.sin(y * 0.5) + (fbm(x, y, 33, 6.0) - 0.5) * 0.3
        c = tone(base, band + 0.1 - 0.35 * t)
        if y % 6 == 0:
            c = shade(c, 0.7)
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "flesh":
        c = tone(base, 0.25 - 0.55 * t + (fbm(x, y, 41, 3.0) - 0.5) * 0.5)
        if rng.random() < 0.08:
            c = shade(c, 0.78)
        if rng.random() < 0.05:
            c = mix(c, (190, 90, 110), 0.35)
        return shade(c, 1.0 + rng.uniform(-0.06, 0.06))
    if style == "jelly":
        d = math.hypot((x / max(w, 1)) - 0.5, (y / max(h, 1)) - 0.5)
        return shade(base, 1.16 - 0.5 * d + rng.uniform(-0.03, 0.03))
    if style == "fur":
        c = tone(base, 0.18 - 0.3 * t + (fbm(x, y, 21, 2.4) - 0.5) * 0.7)
        if (x * 3 + y * 5) % 11 == 0:
            c = shade(c, 1.18)
        if (x + y) % 9 == 0:
            c = shade(c, 0.82)
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "sand":
        c = shade(base, 0.95 + 0.1 * math.sin((x + y * 2) * 0.35))
        if rng.random() < 0.1:
            c = shade(c, 1.1)
        return shade(c, 1.0 + rng.uniform(-0.04, 0.04))
    if style == "melon":
        stripe = (x // 4) % 2
        c = shade(base, 0.72 if stripe else 1.12)
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "leaves":
        c = shade(base, 1.0 + rng.uniform(-0.18, 0.18))
        if rng.random() < 0.18:
            c = shade(c, 0.7)
        return c
    if style == "feather":
        c = shade(base, 1.0 + 0.08 * math.sin(y * 1.2))
        if (y % 4) == 0 and (x + y // 4) % 3 == 0:
            c = shade(c, 0.82)
        return shade(c, 1.0 + rng.uniform(-0.04, 0.04))
    if style == "skin":
        c = tone(base, 0.16 - 0.34 * t + (fbm(x, y, 53, 4.0) - 0.5) * 0.34)
        if (x * 7 + y * 3) % 23 == 0:
            c = shade(c, 0.88)
        return shade(c, 1.0 + rng.uniform(-0.03, 0.03))
    if style == "lens":
        d = math.hypot((x / max(w, 1)) - 0.5, (y / max(h, 1)) - 0.5) * 2.0
        return clamp(mix((255, 255, 255), base, min(1.0, d * 0.9)))
    if style == "circuit":
        c = shade(base, 1.0)
        if x % 8 == 0 or y % 8 == 0:
            c = shade(c, 0.78)
        if (x % 8 == 0 and y % 16 == 5) or (y % 8 == 0 and x % 16 == 3):
            c = mix(c, (255, 60, 60), 0.6)
        return shade(c, 1.0 + rng.uniform(-0.03, 0.03))
    if style == "ash":
        c = shade(base, 1.0 + rng.uniform(-0.16, 0.16))
        if rng.random() < 0.03:
            c = mix(c, (255, 130, 60), 0.5)
        return c
    if style == "cloud":
        c = shade(base, 1.0 + 0.08 * math.sin(x * 0.7 + y * 0.9))
        return shade(c, 1.0 + rng.uniform(-0.04, 0.04))
    if style == "wet":
        c = tone(base, 0.3 - 0.6 * t + (fbm(x, y, 71, 2.6) - 0.5) * 0.4)
        if rng.random() < 0.06:
            c = shade(c, 1.4)
        return shade(c, 1.0 + rng.uniform(-0.06, 0.06))
    if style == "cloth":
        c = shade(base, 0.94 + 0.08 * ((x + y) % 4 < 2))
        if y % 10 == 0:
            c = shade(c, 0.86)
        return shade(c, 1.0 + rng.uniform(-0.04, 0.04))
    if style == "bone":
        c = tone(base, 0.1 - 0.2 * t + (fbm(x, y, 61, 3.4) - 0.5) * 0.3)
        if (x * 5 + y * 3) % 29 == 0:
            c = shade(c, 0.8)
        return shade(c, 1.0 + rng.uniform(-0.03, 0.03))
    if style == "storm":
        ang = math.atan2(y - h / 2.0, x - w / 2.0)
        c = shade(base, 1.0 + 0.22 * math.sin(ang * 4 + math.hypot(x, y) * 0.25))
        return shade(c, 1.0 + rng.uniform(-0.05, 0.05))
    if style == "rust":
        c = shade(base, 1.0 + rng.uniform(-0.12, 0.12))
        if rng.random() < 0.12:
            c = mix(c, (150, 90, 50), 0.55)
        return c
    # noise / default
    c = tone(base, 0.12 - 0.3 * t + (fbm(x, y, 91, 4.2) - 0.5) * 0.36)
    return shade(c, 1.0 + rng.uniform(-0.03, 0.03))


# --------------------------------------------------------------------------- faces
def draw_face(kind, draw, x0, y0, w, h, base, rng):
    if not kind:
        return
    cx = x0 + w // 2
    cy = y0 + h // 2
    dark = shade(base, 0.35)
    black = (12, 10, 10)
    white = (245, 243, 236)

    def rect(x, y, ww, hh, color):
        draw.rectangle([x, y, x + ww - 1, y + hh - 1], fill=color + (255,))

    def eye(x, y, r, iris, pupil=True):
        draw.ellipse([x - r, y - r, x + r - 1, y + r - 1], fill=white + (255,))
        if r >= 2:
            draw.ellipse([x - r + 1, y - r + 1, x + r - 2, y + r - 2], fill=iris + (255,))
        if pupil and r >= 3:
            pr = max(1, r // 3)
            draw.ellipse([x - pr, y - pr, x + pr - 1, y + pr - 1], fill=black + (255,))

    if kind == "iris":
        draw.ellipse([x0, y0, x0 + w - 1, y0 + h - 1], fill=(250, 250, 245, 255))
        eye(cx, cy, max(2, w // 2 - 1), (120, 190, 235))
        return
    if kind in ("eye", "ray_eye"):
        eye(cx, cy, max(2, min(w, h) // 3), (235, 200, 90))
        return
    if kind == "socket":
        rect(x0 + 1, y0 + 1, w - 2, h - 2, shade(base, 0.72))
        eye(cx, cy, max(2, min(w, h) // 3), (235, 190, 120))
        return
    if kind == "visor":
        rect(x0, y0, w, h, (20, 24, 30))
        rect(x0 + 1, y0 + 1, w - 2, max(1, h // 3), (70, 90, 110))
        return
    if kind in ("mouth", "teeth", "maw", "throat"):
        rect(x0, y0 + h // 3, w, max(2, h - h // 3), (26, 12, 14) if kind != "throat" else (18, 8, 8))
        step = 4
        for i in range(x0 + 1, x0 + w - 1, step):
            draw.polygon([(i, y0 + h // 3), (i + step - 1, y0 + h // 3),
                          (i + (step - 1) // 2, y0 + h // 3 + h // 4)], fill=white + (255,))
            draw.polygon([(i, y0 + h - 1), (i + step - 1, y0 + h - 1),
                          (i + (step - 1) // 2, y0 + h - 1 - h // 4)], fill=white + (255,))
        return
    if kind == "skull":
        rect(cx - w // 3, cy - h // 4, max(2, w // 4), max(2, h // 4), black)
        rect(cx + w // 6, cy - h // 4, max(2, w // 4), max(2, h // 4), black)
        rect(cx - 1, cy + h // 8, 2, max(2, h // 6), shade(base, 0.5))
        rect(cx - w // 4, cy + h // 3, w // 2, 2, black)
        return
    if kind == "hound":
        rect(x0 + 1, cy - h // 4, 3, 2, (230, 120, 40))
        rect(x0 + w - 4, cy - h // 4, 3, 2, (230, 120, 40))
        rect(cx - 2, cy, 4, 3, black)
        rect(cx - w // 3, y0 + h - h // 4, w // 2, 2, shade(base, 0.55))
        return
    if kind == "bear":
        rect(x0 + 1, cy - h // 3, 3, 3, black)
        rect(x0 + w - 4, cy - h // 3, 3, 3, black)
        return
    if kind == "snout":
        rect(cx - 2, y0 + 1, 4, 2, (40, 32, 28))
        return
    if kind == "bird":
        rect(x0 + 1, cy - 2, 3, 3, black)
        rect(x0 + w - 4, cy - 2, 3, 3, black)
        draw.polygon([(cx - 1, y0 + h - 3), (cx + 1, y0 + h - 3), (cx, y0 + h - 1)], fill=(210, 170, 90, 255))
        return
    if kind in ("panel", "armor", "deck", "hull", "tracks", "bridge"):
        rect(x0, cy, w, 1, shade(base, 0.62))
        rect(cx, y0, 1, h, shade(base, 0.68))
        if kind in ("hull", "deck"):
            rect(x0 + 1, y0 + h - max(2, h // 5), w - 2, max(1, h // 6), shade(base, 0.55))
        for bx, by in ((x0 + 2, y0 + 2), (x0 + w - 3, y0 + 2), (x0 + 2, y0 + h - 3)):
            rect(bx, by, 1, 1, shade(base, 1.35))
        return
    if kind == "vent":
        for yy in range(y0 + 1, y0 + h - 1, 3):
            rect(x0 + 1, yy, w - 2, 1, shade(base, 0.55))
        return
    if kind == "muzzle":
        rect(cx - 2, cy - 2, 4, 4, black)
        return
    if kind == "window":
        rect(x0 + 1, y0 + 1, w - 2, h - 2, (40, 46, 52))
        rect(x0 + 2, y0 + 2, w - 4, h - 4, (215, 205, 150))
        rect(cx, y0 + 2, 1, h - 4, (60, 55, 45))
        return
    if kind == "door":
        rect(cx - max(2, w // 5), y0, max(4, w // 2), h, shade(base, 0.7))
        rect(cx + max(1, w // 4), cy, 1, 1, (230, 210, 120))
        return
    if kind == "lights":
        for i in range(x0 + 2, x0 + w - 1, 6):
            rect(i, cy - 1, 2, 2, (140, 245, 200))
        return
    if kind == "screen":
        rect(x0 + 1, y0 + 1, w - 2, h - 2, (14, 40, 22))
        for yy in range(y0 + 2, y0 + h - 1, 3):
            rect(x0 + 2, yy, max(2, w - 4 - rng.randint(0, 3)), 1, (60, 210, 110))
        return
    if kind == "tvscreen":
        rect(x0, y0, w, h, (10, 10, 14))
        rect(x0 + 1, y0 + 1, w - 2, h - 2, (30, 30, 44))
        for yy in range(y0 + 2, y0 + h - 1, 3):
            rect(x0 + 2, yy, w - 4, 1, (90, 90, 130))
        rect(cx - 2, cy - 2, 4, 4, (255, 40, 40))
        return
    if kind == "speaker":
        draw.ellipse([cx - w // 3, cy - h // 3, cx + w // 3, cy + h // 3],
                     outline=shade(base, 0.5) + (255,), width=1)
        draw.ellipse([cx - 2, cy - 2, cx + 2, cy + 2], fill=black + (255,))
        return
    if kind in ("chest", "lid"):
        rect(x0, y0, w, 1, shade(base, 0.6))
        rect(x0, y0 + h - 1, w, 1, shade(base, 0.6))
        if kind == "chest":
            rect(cx - 2, cy - 1, 4, 3, (200, 170, 60))
            rect(cx - 1, cy, 2, 1, (60, 45, 20))
        return
    if kind == "star":
        for i in range(5):
            ang = i * math.tau / 5
            px = int(cx + math.cos(ang) * (w // 3))
            py = int(cy + math.sin(ang) * (h // 3))
            draw.ellipse([px - 2, py - 2, px + 2, py + 2], fill=shade(base, 1.3) + (255,))
        return
    if kind == "suckers":
        for yy in range(y0 + 2, y0 + h - 1, 5):
            for xx in range(x0 + 2, x0 + w - 1, 5):
                draw.ellipse([xx, yy, xx + 2, yy + 2], fill=shade(base, 1.45) + (255,))
        return
    if kind == "plates":
        for yy in range(y0 + 2, y0 + h - 1, 5):
            rect(x0, yy, w, 1, shade(base, 0.6))
        return
    if kind == "segments":
        for yy in range(y0 + 1, y0 + h - 1, 6):
            rect(x0, yy, w, 1, shade(base, 0.68))
        return
    if kind == "spider":
        for i, ox in enumerate((-w // 3, 0, w // 3)):
            c = [(255, 60, 60), (255, 140, 60), (255, 60, 60)][i]
            draw.ellipse([cx + ox - 1, y0 + h // 3 - 1, cx + ox + 1, y0 + h // 3 + 1], fill=c + (255,))
        return
    if kind == "melon":
        for i in range(x0 + 1, x0 + w - 1, 4):
            rect(i, y0, 1, h, shade(base, 0.7))
        return
    if kind == "scream" or kind == "faceless":
        rect(cx - w // 4, cy - h // 5, max(2, w // 6), max(2, h // 6), black)
        rect(cx + w // 8, cy - h // 5, max(2, w // 6), max(2, h // 6), black)
        if kind == "scream":
            draw.ellipse([cx - 2, cy + h // 6, cx + 2, cy + h // 3], fill=black + (255,))
        return
    if kind == "hood":
        rect(x0 + 1, y0 + 1, w - 2, h - 2, (14, 13, 20))
        rect(cx - 3, cy - 1, 2, 2, (190, 235, 255))
        rect(cx + 1, cy - 1, 2, 2, (190, 235, 255))
        return
    if kind == "robe":
        for yy in range(y0 + 2, y0 + h - 1, 5):
            rect(x0 + 1, yy, w - 2, 1, shade(base, 0.8))
        return
    if kind == "ribs":
        for yy in range(y0 + 1, y0 + h - 1, 4):
            rect(x0 + 1, yy, w - 2, 1, shade(base, 1.3))
        return
    if kind == "knots":
        rect(cx - 1, cy - 1, 3, 3, shade(base, 0.45))
        return
    if kind == "bark":
        for xx in range(x0 + 2, x0 + w - 1, 4):
            rect(xx, y0, 1, h, shade(base, 0.7))
        return
    if kind == "leaves":
        for _ in range(max(3, w * h // 40)):
            xx, yy = rng.randint(x0, x0 + w - 2), rng.randint(y0, y0 + h - 2)
            rect(xx, yy, 2, 2, shade(base, rng.uniform(0.8, 1.4)))
        return
    if kind == "vortex":
        for i in range(3):
            yy = y0 + (i * h) // 3
            rect(x0, yy, w, 1, shade(base, 1.35))
        return
    if kind == "ridge":
        rect(x0, cy, w, 1, shade(base, 0.72))
        return
    if kind == "fur" or kind == "feather" or kind == "ash" or kind == "cloth" or kind == "bone":
        return
    if kind == "jaw":
        rect(x0, y0 + h // 2, w, max(1, h // 3), (28, 20, 16))
        return


def face_rects(u, v, w, h, d):
    """Texture rectangle of every box face (down, up, west, north, east, south)."""
    W = max(1, int(round(w * UV)))
    H = max(1, int(round(h * UV)))
    D = max(1, int(round(d * UV)))
    return {
        "down": (u + D, v, W, D),
        "up": (u + D + W, v, W, D),
        "west": (u, v + D, D, H),
        "north": (u + D, v + D, W, H),
        "east": (u + D + W, v + D, D, H),
        "south": (u + 2 * D + W, v + D, W, H),
    }


def paint_box(img, u, v, w, h, d, spec, rng):
    base = hex_rgb(spec["color"])
    style = spec.get("style", "noise")
    face = spec.get("face")
    glow = spec.get("glow", False)
    px = img.load()

    faces = face_rects(u, v, w, h, d)

    shiny = style in ("metal", "milmetal", "lens", "circuit", "wet", "storm")
    seed = sum(ord(ch) for ch in style) * 7 + w * 13 + h * 3 + d
    for name, (fx, fy, fw, fh) in faces.items():
        if fw <= 0 or fh <= 0:
            continue
        light = {"up": 1.14, "down": 0.72, "west": 0.9, "east": 0.9,
                 "north": 1.0, "south": 0.85}[name]
        for yy in range(fh):
            for xx in range(fw):
                c = material_px(style, base, xx, yy, fw, fh, rng)
                # rounded shading: darker towards the edges of the face
                ex = min(xx, fw - 1 - xx) / max(1.0, fw * 0.18)
                ey = min(yy, fh - 1 - yy) / max(1.0, fh * 0.18)
                border = min(1.0, min(ex, ey))
                c = shade(c, 0.8 + 0.2 * border)
                # gentle vertical gradient on side faces
                if name not in ("up", "down"):
                    c = shade(c, 1.05 - 0.1 * (yy / max(1, fh - 1)))
                if shiny and name not in ("up", "down"):
                    streak = (xx + (fh - yy)) / max(1.0, fw + fh)
                    if 0.55 < streak < 0.7:
                        c = shade(c, 1.16)
                if glow:
                    c = shade(c, 1.22)
                px[fx + xx, fy + yy] = boost(clamp(shade(c, light))) + (255,)

    draw = ImageDraw.Draw(img)
    edge = clamp(shade(base, 0.62)) + (200,)
    for name, (fx, fy, fw, fh) in faces.items():
        draw.rectangle([fx, fy, fx + fw - 1, fy + fh - 1], outline=edge)

    if face:
        fx, fy, fw, fh = faces["north"]
        draw_face(face, draw, fx, fy, fw, fh, base, rng)


def build_texture(spec, out_path):
    boxes = [b for p in spec["parts"] for b in p["boxes"]]
    width = 512
    for b in boxes:
        need = box_px(b)[0]
        if need > width:
            width = next_pow2(need)
    placed, height = pack(boxes, width)
    tex_h = next_pow2(max(64, height + 1))
    img = Image.new("RGBA", (width, tex_h), (0, 0, 0, 0))
    rng = random.Random(sum(ord(c) for c in out_path) * 977)
    for b, (u, v, _, _) in zip(boxes, placed):
        paint_box(img, u, v, b["w"], b["h"], b["d"], b, rng)
    img.save(out_path)
    return width, tex_h, placed


def f(value):
    if abs(value - round(value)) < 1e-6:
        return "%.1fF" % value
    return "%.2fF" % value


ANIM_LINES = {
    "leg": "Anims.swing(part, limbSwing, limbSwingAmount, 0.95F, %.2fF);",
    "leg_low": "Anims.swing(part, limbSwing, limbSwingAmount, 0.45F, %.2fF);",
    "arm": "Anims.swing(part, limbSwing, limbSwingAmount, 0.6F, %.2fF);",
    "arm_low": "Anims.swing(part, limbSwing, limbSwingAmount, 0.3F, %.2fF);",
    "tentacle": "Anims.swayOne(part, ageInTicks, 0.09F, %.2fF);",
    "wing": "Anims.flapOne(part, ageInTicks, 0.25F, %.2fF);",
    "head": "Anims.look(part, netHeadYaw, headPitch);",
    "jaw": "Anims.jaw(part, ageInTicks, 0.18F);",
    "bob": "Anims.bob(part, ageInTicks, 0.45F);",
    "rotor": "Anims.spin(part, ageInTicks, 0.35F);",
    "eye": "Anims.pulse(part, ageInTicks, 0.06F);",
}



# ------------------------------------------------------------------ geometry helpers
def _rot_matrix(rot):
    """Minecraft applies zRot, then yRot, then xRot to the local vector."""
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


def _translate(m, v):
    return tuple(sum(m[i][k] * v[k] for k in range(3)) for i in range(3))


def model_bounds(spec):
    """Returns (lowest, highest) in blocks measured up from the feet."""
    by_name = {p["name"]: p for p in spec["parts"]}
    low = 1e9
    high = -1e9
    for p in spec["parts"]:
        chain = []
        cur = p
        while cur is not None:
            chain.append(cur)
            parent = cur.get("parent")
            cur = by_name.get(parent) if parent else None
        chain.reverse()
        for b in p["boxes"]:
            for cx in (b["x"], b["x"] + b["w"]):
                for cy in (b["y"], b["y"] + b["h"]):
                    for cz in (b["z"], b["z"] + b["d"]):
                        v = (float(cx), float(cy), float(cz))
                        for node in chain:
                            m = _rot_matrix(node.get("rot"))
                            v = _translate(m, v)
                            px, py, pz = node["pivot"]
                            v = (v[0] + px, v[1] + py, v[2] + pz)
                        low = min(low, 24.0 - v[1])
                        high = max(high, 24.0 - v[1])
    return low, high


def model_metrics(spec):
    """(shift, scale) that put the model on the ground and fit it into its hitbox."""
    low, high = model_bounds(spec)
    shift = -low if low < 0 else 0.0
    height = (high + shift) / 16.0
    scale = spec["height"] / height if height > 0 else 1.0
    return shift, scale


def build_java(name, spec, tex_w, tex_h, placed):
    boxes = [b for p in spec["parts"] for b in p["boxes"]]
    positions = {id(b): pos for b, pos in zip(boxes, placed)}
    cls = spec["class"]
    entity_cls = "".join(p.capitalize() for p in name.split("_")) + "Entity"
    L = []
    L.append("package com.arena.randommobs.entity.client.model;")
    L.append("")
    L.append("import com.arena.randommobs.entity.%s;" % entity_cls)
    L.append("import net.minecraft.client.model.geom.ModelPart;")
    L.append("import net.minecraft.client.model.geom.PartPose;")
    L.append("import net.minecraft.client.model.geom.builders.CubeDeformation;")
    L.append("import net.minecraft.client.model.geom.builders.CubeListBuilder;")
    L.append("import net.minecraft.client.model.geom.builders.LayerDefinition;")
    L.append("import net.minecraft.client.model.geom.builders.MeshDefinition;")
    L.append("import net.minecraft.client.model.geom.builders.PartDefinition;")
    L.append("import net.minecraft.resources.ResourceLocation;")
    L.append("")
    L.append("public class %s extends RMobModel<%s> {" % (cls, entity_cls))
    L.append('    public static final ResourceLocation TEXTURE = new ResourceLocation("randommobs", "textures/entity/%s.png");' % name)
    shift, scale = model_metrics(spec)
    L.append("    public static final float SCALE = %s;" % f(round(scale, 3)))
    L.append("    public static final float SHADOW = %s;" % f(spec.get("shadow", 1.0)))
    L.append("")
    L.append("    public %s(ModelPart root) {" % cls)
    L.append("        super(root);")
    L.append("    }")
    L.append("")
    L.append("    public static LayerDefinition createBodyLayer() {")
    L.append("        MeshDefinition mesh = new MeshDefinition();")
    L.append("        PartDefinition root = mesh.getRoot();")
    for p in spec["parts"]:
        var = p["name"]
        b = "CubeListBuilder.create()"
        for bx in p["boxes"]:
            u, v, _, _ = positions[id(bx)]
            b += "\n                .texOffs(%d, %d).addBox(%s, %s, %s, %s, %s, %s, CubeDeformation.NONE, %s, %s)" % (
                u, v, f(bx["x"]), f(bx["y"]), f(bx["z"]), f(bx["w"]), f(bx["h"]), f(bx["d"]),
                f(float(UV)), f(float(UV)))
        pivot_y = p["pivot"][1] - (shift if not p.get("parent") else 0.0)
        if p.get("rot"):
            pose = "PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)" % (
                f(p["pivot"][0]), f(pivot_y), f(p["pivot"][2]),
                f(math.radians(p["rot"][0])), f(math.radians(p["rot"][1])), f(math.radians(p["rot"][2])))
        else:
            pose = "PartPose.offset(%s, %s, %s)" % (
                f(p["pivot"][0]), f(pivot_y), f(p["pivot"][2]))
        parent = "root" if not p.get("parent") else p["parent"]
        L.append("        PartDefinition %s = %s.addOrReplaceChild(\"%s\", %s," % (var, parent, var, b))
        L.append("                %s);" % pose)
    L.append("        return LayerDefinition.create(mesh, %d, %d);" % (tex_w, tex_h))
    L.append("    }")
    L.append("")
    L.append("    @Override")
    L.append("    public void setupAnim(%s entity, float limbSwing, float limbSwingAmount, float ageInTicks,"
             % entity_cls)
    L.append("                        float netHeadYaw, float headPitch) {")
    L.append("        this.resetPose();")
    phase = 0.0
    by_name = {p["name"]: p for p in spec["parts"]}
    for p in spec["parts"]:
        anim = p.get("anim")
        if not anim:
            continue
        template = ANIM_LINES.get(anim)
        if template is None:
            continue
        line = (template % phase if "%" in template else template).replace("part,", p["name"] + ",")
        chain = []
        cur = p
        while cur is not None:
            chain.append(cur["name"])
            parent_name = cur.get("parent")
            cur = by_name.get(parent_name) if parent_name else None
        chain.reverse()
        accessor = "this.root" + "".join('.getChild("%s")' % n for n in chain)
        prefix = "" if p["name"] == "head" else "ModelPart %s = " % p["name"]
        if p["name"] == "head":
            prefix = "ModelPart head = "
        L.append("        " + prefix + accessor + "; " + line)
        phase += math.pi / 2
    L.append("    }")
    L.append("}")
    return "\n".join(L) + "\n"


def main():
    os.makedirs(MODEL_JAVA, exist_ok=True)
    os.makedirs(ENTITY_TEX, exist_ok=True)
    for name, spec in MOBS.items():
        tex_w, tex_h, placed = build_texture(spec, os.path.join(ENTITY_TEX, name + ".png"))
        java = build_java(name, spec, tex_w, tex_h, placed)
        with open(os.path.join(MODEL_JAVA, spec["class"] + ".java"), "w") as fh:
            fh.write(java)
        print("built %-16s texture %dx%d" % (name, tex_w, tex_h))


if __name__ == "__main__":
    main()
