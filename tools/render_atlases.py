#!/usr/bin/env python3
"""Contact sheet of every generated entity texture (the raw UV atlases).

    python3 tools/render_atlases.py      ->  tools/preview/entity_textures.png
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from generate_assets import ENTITY_TEX  # noqa: E402
from models import MOBS  # noqa: E402

from PIL import Image, ImageDraw  # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
OUT = os.path.join(ROOT, "tools", "preview")
CELL = 256


def fit(img, size):
    k = min(size / img.width, size / img.height)
    return img.resize((max(1, int(img.width * k)), max(1, int(img.height * k))), Image.NEAREST)


def main():
    names = [n for n in MOBS if os.path.exists(os.path.join(ENTITY_TEX, n + ".png"))]
    cols = 5
    rows = (len(names) + cols - 1) // cols
    sheet = Image.new("RGB", (cols * (CELL + 12), rows * (CELL + 26)), (22, 24, 30))
    draw = ImageDraw.Draw(sheet)
    for i, name in enumerate(names):
        img = Image.open(os.path.join(ENTITY_TEX, name + ".png")).convert("RGBA")
        tile = Image.new("RGBA", img.size, (52, 56, 66, 255))
        tile.alpha_composite(img)
        thumb = fit(tile.convert("RGB"), CELL)
        x = (i % cols) * (CELL + 12) + 6 + (CELL - thumb.width) // 2
        y = (i // cols) * (CELL + 26) + 6 + (CELL - thumb.height) // 2
        sheet.paste(thumb, (x, y))
        draw.text(((i % cols) * (CELL + 12) + 8, (i // cols) * (CELL + 26) + CELL + 8),
                  "%s  %dx%d" % (name, img.width, img.height), fill=(196, 202, 214))
    path = os.path.join(OUT, "entity_textures.png")
    sheet.save(path)
    print("atlases:", path)


if __name__ == "__main__":
    main()
