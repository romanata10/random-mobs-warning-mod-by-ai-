#!/usr/bin/env python3
"""Generates every 16x16 item/block icon, the mob effect icon and the mod logo."""
import os
import random

from PIL import Image, ImageDraw

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ASSETS = os.path.join(ROOT, "src/main/resources/assets/randommobs")
ITEM = os.path.join(ASSETS, "textures/item")
BLOCK = os.path.join(ASSETS, "textures/block")
EFFECT = os.path.join(ASSETS, "textures/mob_effect")


def hx(v):
    v = v.lstrip("#")
    return tuple(int(v[i:i + 2], 16) for i in (0, 2, 4))


def mix(a, b, t):
    return tuple(int(a[i] + (b[i] - a[i]) * t) for i in range(3))


def light(c, f):
    return tuple(max(0, min(255, int(v * f))) for v in c)


def new_icon(size=16):
    img = Image.new("RGBA", (size, size), (0, 0, 0, 0))
    return img, ImageDraw.Draw(img)


def noisy(img, rng, amount=10):
    px = img.load()
    w, h = img.size
    for y in range(h):
        for x in range(w):
            r, g, b, a = px[x, y]
            if a == 0:
                continue
            d = rng.randint(-amount, amount)
            px[x, y] = (max(0, min(255, r + d)), max(0, min(255, g + d)), max(0, min(255, b + d)), a)


def outline(img, color=(20, 16, 12, 255)):
    px = img.load()
    w, h = img.size
    src = [[px[x, y] for x in range(w)] for y in range(h)]
    for y in range(h):
        for x in range(w):
            if src[x][y][3] != 0:
                continue
            for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
                nx, ny = x + dx, y + dy
                if 0 <= nx < w and 0 <= ny < h and src[nx][ny][3] > 0:
                    px[x, y] = color
                    break


def save(img, folder, name):
    os.makedirs(folder, exist_ok=True)
    img.save(os.path.join(folder, name + ".png"))


# --------------------------------------------------------------------------- items
def icon_tripod_core(rng):
    img, d = new_icon()
    d.ellipse([1, 1, 14, 14], fill=hx("#3d444d"))
    d.ellipse([3, 3, 12, 12], fill=hx("#6a7480"))
    d.ellipse([4, 4, 11, 11], fill=hx("#2a2f35"))
    d.ellipse([5, 5, 10, 10], fill=hx("#f6e27a"))
    d.ellipse([6, 6, 8, 8], fill=hx("#fffbe0"))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_ingot(rng, base="#7d8f8a"):
    img, d = new_icon()
    c = hx(base)
    d.polygon([(3, 10), (12, 10), (14, 13), (5, 13)], fill=light(c, 0.8))
    d.polygon([(3, 6), (12, 6), (12, 10), (3, 10)], fill=c)
    d.polygon([(3, 6), (5, 4), (14, 4), (12, 6)], fill=light(c, 1.25))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_claw(rng):
    img, d = new_icon()
    base = hx("#5d4227")
    d.rectangle([3, 11, 12, 14], fill=hx("#3a2a18"))
    for i, off in enumerate((2, 7, 12)):
        d.polygon([(off - 1, 12), (off + 2, 12), (off + 1, 2), (off, 1)], fill=light(base, 1.0 + i * 0.1))
    noisy(img, rng, 9)
    outline(img)
    return img


def icon_pod(rng):
    img, d = new_icon()
    d.ellipse([4, 3, 11, 14], fill=hx("#8a3b1c"))
    d.ellipse([5, 4, 10, 12], fill=hx("#b8542a"))
    d.line([7, 5, 7, 11], fill=hx("#ffd27a"))
    d.line([8, 5, 8, 11], fill=hx("#ffd27a"))
    for x in (3, 12):
        d.line([x, 8, x - 1 if x > 8 else x + 1, 14], fill=hx("#5d4227"))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_eye(rng, iris="#2fd6c9"):
    img, d = new_icon()
    d.ellipse([1, 3, 14, 12], fill=hx("#0d2b3a"))
    d.ellipse([3, 4, 12, 11], fill=hx(iris))
    d.ellipse([6, 5, 9, 10], fill=hx("#06131a"))
    d.point((5, 6), fill=hx("#eafffb"))
    noisy(img, rng, 6)
    outline(img)
    return img


def icon_scrap(rng):
    img, d = new_icon()
    d.polygon([(2, 4), (12, 2), (14, 8), (9, 14), (3, 11)], fill=hx("#878f96"))
    d.polygon([(3, 6), (10, 4), (11, 8), (6, 11)], fill=hx("#6f777e"))
    for p in ((5, 8), (9, 6), (7, 10)):
        d.point(p, fill=hx("#7cf2a8"))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_silk(rng):
    img, d = new_icon()
    for i in range(4):
        d.line([2 + i * 3, 14, 12 - i, 2], fill=hx("#e8e8e8"))
    d.line([2, 4, 13, 12], fill=hx("#cfcfcf"))
    noisy(img, rng, 6)
    outline(img)
    return img


def icon_feather(rng):
    img, d = new_icon()
    d.line([4, 14, 11, 2], fill=hx("#3a2c20"))
    for i in range(4):
        d.ellipse([3 + i, 3 + i * 2, 11 - i, 6 + i * 2], fill=hx("#6b5540"))
    d.line([4, 14, 11, 2], fill=hx("#d8c3a2"))
    noisy(img, rng, 7)
    outline(img)
    return img


def icon_heat_ray(rng):
    img, d = new_icon()
    d.rectangle([2, 5, 11, 8], fill=hx("#5c646d"))
    d.rectangle([2, 4, 8, 5], fill=hx("#7b858f"))
    d.rectangle([5, 8, 8, 14], fill=hx("#3a2a1c"))
    d.rectangle([11, 4, 14, 9], fill=hx("#33383f"))
    d.ellipse([12, 5, 14, 8], fill=hx("#ffd45a"))
    d.point((13, 3), fill=hx("#ffef9a"))
    noisy(img, rng, 7)
    outline(img)
    return img


def icon_sword(rng, blade="#6b4a2a", edge="#b6f06a", hilt="#3a2a1c"):
    img, d = new_icon()
    d.polygon([(12, 1), (15, 4), (6, 13), (4, 11)], fill=hx(blade))
    d.line([13, 2, 12, 3], fill=hx(edge))
    d.line([11, 4, 5, 10], fill=hx(edge))
    d.line([3, 10, 7, 14], fill=hx(hilt))
    d.rectangle([2, 13, 4, 15], fill=hx(hilt))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_fang(rng):
    img, d = new_icon()
    d.polygon([(4, 2), (12, 5), (9, 14), (5, 12)], fill=hx("#f2ead6"))
    d.polygon([(6, 3), (11, 5), (8, 12)], fill=hx("#d9cfb4"))
    d.line([5, 3, 8, 13], fill=hx("#a89a7a"))
    noisy(img, rng, 6)
    outline(img)
    return img


def icon_serum(rng):
    img, d = new_icon()
    d.rectangle([6, 1, 9, 3], fill=hx("#c9d3d7"))
    d.polygon([(5, 4), (10, 4), (12, 14), (3, 14)], fill=hx("#9fb0b8"))
    d.polygon([(5, 8), (10, 8), (11, 13), (4, 13)], fill=hx("#7a3d1c"))
    d.line([6, 9, 6, 12], fill=hx("#c46a2c"))
    noisy(img, rng, 6)
    outline(img)
    return img


def icon_meat(rng, base="#c9566b", cooked=False):
    img, d = new_icon()
    c = hx(base) if not cooked else hx("#8a4a22")
    d.ellipse([2, 4, 12, 13], fill=c)
    d.ellipse([3, 5, 8, 10], fill=light(c, 1.18))
    d.rectangle([11, 2, 14, 4], fill=hx("#efe6d2"))
    d.line([12, 3, 14, 6], fill=hx("#efe6d2"))
    noisy(img, rng, 9)
    outline(img)
    return img


def icon_tentacle(rng, base="#5b3f80", cooked=False):
    img, d = new_icon()
    c = hx(base) if not cooked else hx("#a55c2a")
    points = [(4, 14), (5, 10), (8, 7), (10, 4), (13, 3)]
    for i in range(len(points) - 1):
        d.line([points[i], points[i + 1]], fill=c, width=3)
    for p in ((6, 12), (8, 9), (10, 6)):
        d.point(p, fill=light(c, 1.5))
    noisy(img, rng, 8)
    outline(img)
    return img


def icon_root_fruit(rng):
    img, d = new_icon()
    d.line([8, 14, 8, 6], fill=hx("#5d4227"))
    for cx, cy in ((5, 7), (10, 6), (7, 10)):
        d.ellipse([cx - 2, cy - 2, cx + 2, cy + 2], fill=hx("#b02a2a"))
        d.point((cx - 1, cy - 1), fill=hx("#e8674a"))
    d.line([8, 4, 11, 2], fill=hx("#3f7a2e"))
    noisy(img, rng, 7)
    outline(img)
    return img


def icon_root_seed(rng):
    img, d = new_icon()
    for cx, cy in ((5, 10), (9, 11), (7, 7), (11, 8)):
        d.ellipse([cx - 1, cy - 1, cx + 1, cy + 1], fill=hx("#3a2a18"))
    d.line([5, 10, 4, 14], fill=hx("#6b3a1b"))
    d.line([10, 8, 13, 11], fill=hx("#6b3a1b"))
    d.point((12, 5), fill=hx("#8a5a2a"))
    noisy(img, rng, 6)
    outline(img)
    return img


def icon_shard(rng):
    img, d = new_icon()
    d.polygon([(8, 1), (13, 6), (11, 14), (5, 14), (3, 6)], fill=hx("#4a2a1a"))
    d.polygon([(8, 3), (11, 7), (10, 12), (6, 12), (5, 7)], fill=hx("#6b3a1b"))
    d.polygon([(8, 5), (10, 8), (8, 11), (6, 8)], fill=hx("#e8674a"))
    d.point((8, 7), fill=hx("#ffd27a"))
    noisy(img, rng, 7)
    outline(img)
    return img


# --------------------------------------------------------------------------- blocks
def block_red_root_block(rng):
    img = Image.new("RGBA", (16, 16), hx("#5b2c18") + (255,))
    d = ImageDraw.Draw(img)
    for _ in range(26):
        x, y = rng.randrange(16), rng.randrange(16)
        d.point((x, y), fill=hx(rng.choice(["#7a3d21", "#45200f", "#8f4a28"])))
    noisy(img, rng, 8)
    return img


def block_alien_metal(rng):
    img = Image.new("RGBA", (16, 16), hx("#6a727c") + (255,))
    d = ImageDraw.Draw(img)
    d.rectangle([0, 0, 15, 15], outline=hx("#4a515a"))
    d.rectangle([2, 2, 13, 13], outline=hx("#8b949e"))
    d.line([3, 3, 12, 12], fill=hx("#565d66"))
    d.line([12, 3, 3, 12], fill=hx("#565d66"))
    d.point((7, 7), fill=hx("#a8b2bc"))
    d.point((8, 8), fill=hx("#a8b2bc"))
    noisy(img, rng, 7)
    return img


def block_bloop_flesh(rng):
    img = Image.new("RGBA", (16, 16), hx("#14485a") + (255,))
    d = ImageDraw.Draw(img)
    for _ in range(14):
        x, y = rng.randrange(16), rng.randrange(16)
        r = rng.choice([1, 2])
        d.ellipse([x - r, y - r, x + r, y + r], fill=hx(rng.choice(["#1d6a80", "#0d3542"])))
    noisy(img, rng, 8)
    return img


def block_red_roots(rng):
    img, d = new_icon()
    for x in (3, 6, 8, 12):
        d.line([x, 15, x + rng.randint(-1, 1), 6 + rng.randint(0, 3)], fill=hx("#8f4a28"), width=1)
    for _ in range(10):
        x = rng.randrange(2, 14)
        y = rng.randrange(4, 15)
        d.point((x, y), fill=hx(rng.choice(["#c26a3a", "#6b3418"])))
    noisy(img, rng, 8)
    return img


def block_root_liana(rng):
    img, d = new_icon()
    for x in (4, 7, 10, 13):
        d.line([x, 0, x + rng.randint(-1, 1), 15], fill=hx("#7a3d21"))
    for _ in range(12):
        x = rng.randrange(2, 14)
        y = rng.randrange(0, 16)
        d.point((x, y), fill=hx(rng.choice(["#a8522a", "#5b2c18"])))
    noisy(img, rng, 8)
    return img


def block_mockery_bloom(rng):
    img, d = new_icon()
    d.line([8, 15, 8, 8], fill=hx("#5d4227"))
    d.line([8, 12, 4, 9], fill=hx("#5d4227"))
    d.line([8, 11, 12, 8], fill=hx("#5d4227"))
    for cx, cy in ((8, 5), (4, 6), (12, 6), (6, 2), (10, 2)):
        d.ellipse([cx - 2, cy - 2, cx + 2, cy + 2], fill=hx("#c46a2c"))
    d.ellipse([6, 3, 10, 7], fill=hx("#ffd27a"))
    noisy(img, rng, 8)
    return img


def effect_root_infection(rng):
    img = Image.new("RGBA", (18, 18), (0, 0, 0, 0))
    d = ImageDraw.Draw(img)
    d.ellipse([1, 1, 16, 16], fill=hx("#2b1a10") + (255,))
    for i in range(5):
        x = 4 + i * 2.5
        d.line([x, 15, x + rng.randint(-2, 2), 5], fill=hx("#8f4a28"))
    for cx, cy in ((6, 6), (10, 5), (12, 9), (7, 10)):
        d.ellipse([cx - 2, cy - 2, cx + 2, cy + 2], fill=hx("#b8542a"))
    d.ellipse([7, 7, 11, 11], fill=hx("#e8674a"))
    return img


def logo():
    size = 128
    img = Image.new("RGBA", (size, size), (12, 20, 24, 255))
    d = ImageDraw.Draw(img)
    for i in range(40):
        c = (12 + i, 20 + i, 24 + int(i * 0.6), 255)
        d.ellipse([10 + i // 2, 30 + i // 2, size - 10 - i // 2, size - 20 - i // 2], fill=c)
    d.polygon([(40, 44), (88, 44), (96, 78), (32, 78)], fill=(150, 132, 118, 255))
    for x, end in ((44, 116), (54, 124), (64, 120), (74, 126), (84, 114)):
        d.line([x, 74, end - 4, 118], fill=(168, 147, 124, 255), width=3)
    d.ellipse([46, 16, 82, 52], fill=(255, 231, 140, 255))
    d.ellipse([54, 24, 74, 44], fill=(255, 252, 214, 255))
    img.save(os.path.join(ROOT, "src/main/resources/randommobs_logo.png"))


def main():
    rng = random.Random(4242)
    os.makedirs(ITEM, exist_ok=True)
    os.makedirs(BLOCK, exist_ok=True)
    os.makedirs(EFFECT, exist_ok=True)

    save(icon_tripod_core(rng), ITEM, "tripod_core")
    save(icon_ingot(rng), ITEM, "alien_metal_ingot")
    save(icon_claw(rng), ITEM, "crawler_claw")
    save(icon_pod(rng), ITEM, "mockery_pod")
    save(icon_eye(rng), ITEM, "bloop_eye")
    save(icon_scrap(rng), ITEM, "ufo_scrap")
    save(icon_silk(rng), ITEM, "giant_spider_silk")
    save(icon_feather(rng), ITEM, "meep_feather")
    save(icon_heat_ray(rng), ITEM, "heat_ray")
    save(icon_sword(rng), ITEM, "root_blade")
    save(icon_fang(rng), ITEM, "sand_worm_fang")
    save(icon_serum(rng), ITEM, "root_serum")
    save(icon_meat(rng), ITEM, "bear_meat")
    save(icon_meat(rng, cooked=True), ITEM, "cooked_bear_meat")
    save(icon_tentacle(rng), ITEM, "kraken_tentacle")
    save(icon_tentacle(rng, cooked=True), ITEM, "cooked_kraken_tentacle")
    save(icon_root_fruit(rng), ITEM, "root_fruit")
    save(icon_root_seed(rng), ITEM, "root_seed")
    save(icon_shard(rng), ITEM, "root_shard")

    save(block_red_roots(rng), BLOCK, "red_roots")
    save(block_root_liana(rng), BLOCK, "root_liana")
    save(block_mockery_bloom(rng), BLOCK, "mockery_bloom")
    save(block_red_root_block(rng), BLOCK, "red_root_block")
    save(block_alien_metal(rng), BLOCK, "alien_metal_block")
    save(block_bloop_flesh(rng), BLOCK, "bloop_flesh_block")

    save(effect_root_infection(rng), EFFECT, "root_infection")
    logo()

    # contact sheet for a quick visual check
    names = sorted(os.listdir(ITEM))
    sheet = Image.new("RGBA", (len(names) * 20, 20), (40, 40, 48, 255))
    for i, n in enumerate(names):
        sheet.alpha_composite(Image.open(os.path.join(ITEM, n)).resize((16, 16)), (i * 20 + 2, 2))
    sheet.resize((len(names) * 60, 60), Image.NEAREST).save(os.path.join(ROOT, "tools", "_icons.png"))
    print("icons written:", len(names))


if __name__ == "__main__":
    main()
