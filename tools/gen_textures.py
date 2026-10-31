#!/usr/bin/env python3
"""Generates pixel-art textures for the Random Mobs mod.

The UV layout below MUST match the Java models:
- TripodModel      (128x256): legs 4x96x4 @ (0/16/32,0), body 14x12x14 @ (48,0),
  hood 20x14x20 @ (0,132), aperture 6x6x2 @ (96,132), tentacles 2x26x2 @ (80/88,132)
- WoodcrawlerModel (64x64): head 8x8x8 @ (0,0), torso 8x24x6 @ (32,0),
  legs 4x20x4 @ (0/16,16), arms 2x26x2 @ (32/40,30)

Run from the repo root:  python3 tools/gen_textures.py
"""
import os
import random

from PIL import Image

RES = os.path.join(os.path.dirname(__file__), "..", "src", "main", "resources",
                   "assets", "randommobs", "textures", "entity")


def faces(u, v, w, h, d):
    """Standard Minecraft box-UV layout for one cube of size w x h x d."""
    return {
        "top":    (u + d, v, w, d),
        "bottom": (u + d + w, v, w, d),
        "right":  (u, v + d, d, h),
        "front":  (u + d, v + d, w, h),
        "left":   (u + d + w, v + d, d, h),
        "back":   (u + d + w + d, v + d, w, h),
    }


def lerp(a, b, t):
    return a + (b - a) * t


def jitter(px, rng, amount):
    return tuple(max(0, min(255, int(c + rng.uniform(-amount, amount)))) for c in px)


def shade(px, factor):
    return tuple(max(0, min(255, int(c * factor))) for c in px)


def paint_box(img, box, base, rng, *, jitter_amt=10, streak=18, edge=0.78,
              column_rng=None, vfade=0.0):
    """Paints all 6 faces of a box UV region with a noisy base colour."""
    rng = column_rng or rng
    for name, (x0, y0, w, h) in box.items():
        col_off = [rng.uniform(-streak, streak) for _ in range(w)]
        for yy in range(h):
            for xx in range(w):
                c = base
                c = shade(c, 1.0 + col_off[xx] / 100.0)
                c = jitter(c, rng, jitter_amt)
                if vfade:
                    c = shade(c, lerp(1.0 + vfade, 1.0 - vfade, yy / max(1, h - 1)))
                if xx == 0 or yy == 0 or xx == w - 1 or yy == h - 1:
                    c = shade(c, edge)
                img.putpixel((x0 + xx, y0 + yy), c)


def rust_patches(img, rects, rng, count, colour=(118, 62, 34)):
    """Random blotches of rust on given rect list [(x,y,w,h), ...]."""
    for x0, y0, w, h in rects:
        for _ in range(count):
            bx = rng.randrange(x0, x0 + w)
            by = rng.randrange(y0, y0 + h)
            bw = rng.randint(1, 3)
            bh = rng.randint(1, 3)
            for yy in range(by, min(by + bh, y0 + h)):
                for xx in range(bx, min(bx + bw, x0 + w)):
                    img.putpixel((xx, yy), jitter(colour, rng, 14))


def glow_dot(img, cx, cy, radius, core, halo):
    for yy in range(cy - radius, cy + radius + 1):
        for xx in range(cx - radius, cx + radius + 1):
            dist = ((xx - cx) ** 2 + (yy - cy) ** 2) ** 0.5
            if dist <= radius:
                t = dist / radius
                img.putpixel((xx, yy), tuple(int(lerp(halo[i], core[i], max(0.0, 1.0 - t))) for i in range(3)))


# ---------------------------------------------------------------- tripod ----

def gen_tripod(path):
    rng = random.Random(20261031)
    img = Image.new("RGBA", (128, 256), (0, 0, 0, 0))

    gunmetal = (68, 65, 72)
    bronze = (84, 60, 44)

    # Three long legs (each a 16-wide, 132-tall column).
    leg_boxes = [faces(0, 0, 4, 96, 4), faces(16, 0, 4, 96, 4), faces(32, 0, 4, 96, 4)]
    for i, box in enumerate(leg_boxes):
        paint_box(img, box, gunmetal, rng, streak=26, vfade=0.12)
        rust_patches(img, list(box.values()), rng, 14)

    # Body.
    body = faces(48, 0, 14, 12, 14)
    paint_box(img, body, gunmetal, rng, streak=14, edge=0.7)
    rust_patches(img, list(body.values()), rng, 10)

    # Hood.
    hood = faces(0, 132, 20, 14, 20)
    paint_box(img, hood, bronze, rng, streak=16, edge=0.75)
    rust_patches(img, list(hood.values()), rng, 12)

    # Glowing lights on the hood front face (x20..40, y152..166).
    fy, fx = 152 + 14 // 2, 20
    for offset in (4, 10, 16):
        glow_dot(img, fx + offset, fy, 2, (255, 214, 120), (214, 92, 26))

    # Aperture (front lens).
    ap = faces(96, 132, 6, 6, 2)
    paint_box(img, ap, (46, 30, 22), rng, streak=4, edge=0.85)
    glow_dot(img, 98 + 2, 134 + 2, 2, (255, 190, 90), (180, 60, 20))

    # Tentacles.
    for u in (80, 88):
        tent = faces(u, 132, 2, 26, 2)
        paint_box(img, tent, (128, 106, 98), rng, streak=10, vfade=-0.10, edge=0.8)

    img.save(path)
    return img


# ------------------------------------------------------------ woodcrawler ---

def gen_woodcrawler(path):
    rng = random.Random(19111960)
    img = Image.new("RGBA", (64, 64), (0, 0, 0, 0))

    bark = (62, 47, 33)
    bark_dark = (48, 36, 25)
    pale_wood = (146, 128, 102)

    # Head.
    head = faces(0, 0, 8, 8, 8)
    paint_box(img, head, bark, rng, streak=12, edge=0.8)

    # Face: pale wood plate with hollow black eyes and a stitched mouth.
    fx0, fy0 = 8, 8  # front face of the head
    for yy in range(fy0 + 1, fy0 + 7):
        for xx in range(fx0 + 1, fx0 + 7):
            img.putpixel((xx, yy), jitter(pale_wood, rng, 8))
    for ex, ey in ((9, 10), (9, 11), (10, 10), (10, 11), (9, 12), (10, 12),
                   (13, 10), (13, 11), (14, 10), (14, 11), (13, 12), (14, 12)):
        img.putpixel((ex, ey), (14, 10, 8))
    img.putpixel((10, 11), (120, 20, 16))
    img.putpixel((13, 11), (120, 20, 16))
    for xx, yy in ((11, 13), (12, 13), (11, 14), (12, 14)):
        img.putpixel((xx, yy), (26, 18, 12))

    # Torso.
    torso = faces(32, 0, 8, 24, 6)
    paint_box(img, torso, bark, rng, streak=16, vfade=0.10, edge=0.78)
    # Vertical grain cracks.
    for x0, y0, w, h in torso.values():
        for _ in range(4):
            cx = rng.randrange(x0, x0 + w)
            for yy in range(y0 + 1, y0 + h - 1):
                if rng.random() < 0.8:
                    img.putpixel((cx, yy), jitter(bark_dark, rng, 8))

    # Legs.
    for u in (0, 16):
        leg = faces(u, 16, 4, 20, 4)
        paint_box(img, leg, bark, rng, streak=12, vfade=0.08, edge=0.75)

    # Arms (slightly paler, stripped wood).
    for u in (32, 40):
        arm = faces(u, 30, 2, 26, 2)
        paint_box(img, arm, (94, 76, 56), rng, streak=14, vfade=-0.08, edge=0.78)

    img.save(path)
    return img


def upscale(img, factor):
    return img.resize((img.width * factor, img.height * factor), Image.NEAREST)


if __name__ == "__main__":
    os.makedirs(RES, exist_ok=True)
    t = gen_tripod(os.path.join(RES, "tripod.png"))
    w = gen_woodcrawler(os.path.join(RES, "woodcrawler.png"))
    logo = gen_logo(os.path.join(RES, "..", "randommobs_logo.png"))
    prev = os.path.join(os.path.dirname(__file__), "preview")
    os.makedirs(prev, exist_ok=True)
    upscale(t, 4).save(os.path.join(prev, "tripod_x4.png"))
    upscale(w, 6).save(os.path.join(prev, "woodcrawler_x6.png"))
    upscale(logo, 2).save(os.path.join(prev, "logo_x2.png"))
    print("textures written to", os.path.normpath(RES))


def gen_logo(path):
    """Mod logo: 256x256, tripod silhouette with glowing eye + woodcrawler silhouette."""
    rng = random.Random(7)
    W = H = 256
    img = Image.new("RGBA", (W, H), (0, 0, 0, 255))
    # Night gradient background.
    for y in range(H):
        t = y / (H - 1)
        c = (int(lerp(24, 8, t)), int(lerp(20, 8, t)), int(lerp(34, 14, t)))
        for x in range(W):
            img.putpixel((x, y), c + (255,))

    def rect(x0, y0, x1, y1, col):
        for yy in range(int(y0), int(y1) + 1):
            for xx in range(int(x0), int(x1) + 1):
                if 0 <= xx < W and 0 <= yy < H:
                    img.putpixel((xx, yy), col)

    # Moon
    glow_dot(img, 212, 44, 26, (200, 200, 170), (60, 60, 50))
    glow_dot(img, 212, 44, 18, (235, 235, 200), (150, 150, 120))

    # Ground line
    rect(0, 216, W - 1, H - 1, (16, 14, 12))

    # Tripod silhouette (left-center, large).
    tri = (6, 5, 7)
    hood_x, hood_y = 52, 52
    rect(hood_x, hood_y, hood_x + 64, hood_y + 40, tri)          # hood
    rect(hood_x + 14, hood_y - 12, hood_x + 50, hood_y, tri)     # top beak
    rect(hood_x + 22, hood_y + 40, hood_x + 42, hood_y + 56, tri)  # neck/body
    rect(hood_x - 18, hood_y + 56, hood_x + 82, hood_y + 68, tri)  # hips
    # three legs
    rect(hood_x - 12, hood_y + 68, hood_x + 2, 216, tri)
    rect(hood_x + 50, hood_y + 68, hood_x + 64, 216, tri)
    rect(hood_x + 22, hood_y + 68, hood_x + 34, 210, tri)
    # eye lights
    for dx in (14, 30, 46):
        glow_dot(img, hood_x + dx, hood_y + 30, 3, (255, 170, 60), (140, 40, 10))

    # Heat ray to the right
    for i in range(70):
        x = hood_x + 66 + i * 1.6
        y = hood_y + 30 - i * 0.5
        glow_dot(img, int(x), int(y), 2, (255, 140, 40), (120, 30, 8))

    # Woodcrawler silhouette (right, thin & tall).
    wc = (10, 8, 7)
    rect(178, 96, 194, 118, wc)      # head
    rect(182, 118, 190, 176, wc)     # torso
    rect(180, 176, 187, 216, wc)     # left leg
    rect(190, 176, 196, 216, wc)     # right leg
    rect(176, 120, 181, 168, wc)     # left arm
    rect(191, 120, 196, 168, wc)     # right arm
    img.putpixel((183, 104), (150, 20, 16))
    img.putpixel((189, 104), (150, 20, 16))

    # Title text
    try:
        from PIL import ImageFont
        font = ImageFont.load_default(28)
    except Exception:
        font = ImageFont.load_default()
    from PIL import ImageDraw
    d = ImageDraw.Draw(img)
    d.text((128, 226), "RANDOM MOBS", anchor="mm", fill=(232, 120, 60), font=font)

    img.save(path)
    return img
