#!/usr/bin/env python3
"""Generates the model + texture assets for the Random Mobs mod.

Run:  python3 tools/generate_assets.py
"""
import json
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
ITEM_TEX = os.path.join(ASSETS, "textures/item")
BLOCK_TEX = os.path.join(ASSETS, "textures/block")


def hex_rgb(value):
    value = value.lstrip("#")
    return tuple(int(value[i:i + 2], 16) for i in (0, 2, 4))


def shade(color, factor):
    return tuple(max(0, min(255, int(c * factor))) for c in color)


def clamp_color(value):
    return tuple(max(0, min(255, int(c))) for c in value)


def pack_boxes(boxes, width=256):
    placed = []
    x = 0
    y = 0
    shelf = 0
    for b in boxes:
        w = 2 * (b["w"] + b["d"])
        h = b["h"] + b["d"]
        if b["w"] > width or w > width:
            raise ValueError("box too wide for atlas: %r" % (b,))
        if x + w > width:
            x = 0
            y += shelf + 1
            shelf = 0
        placed.append((x, y, w, h))
        x += w + 1
        shelf = max(shelf, h)
    height = y + shelf
    return placed, height


def next_pow2(value):
    p = 1
    while p < value:
        p *= 2
    return p


def paint_box(img, u, v, w, h, spec, rng):
    base = hex_rgb(spec["color"])
    style = spec.get("style", "noise")
    glow = spec.get("glow", False)
    px = img.load()
    for yy in range(h):
        for xx in range(w):
            if glow:
                cx, cy = w / 2.0, h / 2.0
                dist = math.hypot((xx - cx) / max(cx, 1), (yy - cy) / max(cy, 1))
                color = shade(base, 1.15 - 0.18 * min(dist, 1.0))
                if dist < 0.35:
                    color = shade(base, 1.3)
            elif style == "stripes":
                color = shade(base, 0.82 if (xx // 3) % 2 == 0 else 1.05)
                color = shade(color, 1.0 + rng.uniform(-0.05, 0.05))
            elif style == "wood":
                color = shade(base, 0.85 if yy % 5 == 0 else 1.0)
                color = shade(color, 1.0 + rng.uniform(-0.06, 0.06))
            elif style == "spots":
                color = shade(base, 0.8 if rng.random() < 0.12 else 1.0)
                color = shade(color, 1.0 + rng.uniform(-0.08, 0.08))
            elif style == "plain":
                color = base
            else:
                color = shade(base, 1.0 + rng.uniform(-0.11, 0.11))
                color = shade(color, 1.08 if yy < h * 0.2 else (0.9 if yy > h * 0.82 else 1.0))
            px[u + xx, v + yy] = clamp_color(color) + (255,)

    draw = ImageDraw.Draw(img)
    edge = clamp_color(shade(base, 0.7)) + (255,)
    draw.line([(u, v), (u + w - 1, v)], fill=edge)
    draw.line([(u, v + h - 1), (u + w - 1, v + h - 1)], fill=edge)
    draw.line([(u, v), (u, v + h - 1)], fill=edge)
    draw.line([(u + w - 1, v), (u + w - 1, v + h - 1)], fill=edge)
    if glow:
        draw.rectangle([u + 1, v + 1, u + w - 2, v + h - 2], outline=clamp_color(shade(base, 1.25)) + (255,))


def build_texture(spec, out_path):
    boxes = [b for p in spec["parts"] for b in p["boxes"]]
    width = 256
    placed, height = pack_boxes(boxes, width)
    for b in boxes:
        if 2 * (b["w"] + b["d"]) > width:
            width = next_pow2(2 * (b["w"] + b["d"]))
            placed, height = pack_boxes(boxes, width)
            break
    tex_h = max(64, next_pow2(height + 1))
    img = Image.new("RGBA", (width, tex_h), (0, 0, 0, 0))
    rng = random.Random(hash(out_path) & 0xFFFFFFFF)
    for b, (u, v, w, h) in zip(boxes, placed):
        paint_box(img, u, v, w, h, b, rng)
    img.save(out_path)
    return width, tex_h, dict(zip([id(b) for b in boxes], placed)), placed


def f(value):
    if abs(value - round(value)) < 1e-6:
        return "%.1fF" % value
    return "%.2fF" % value


def build_java(name, spec, tex_w, tex_h, placed):
    boxes = [b for p in spec["parts"] for b in p["boxes"]]
    positions = {id(b): p for b, p in zip(boxes, placed)}
    cls = spec["class"]
    entity_cls = "".join(part.capitalize() for part in name.split("_")) + "Entity"
    lines = []
    lines.append("package com.arena.randommobs.entity.client.model;")
    lines.append("")
    lines.append("import com.arena.randommobs.entity.%s;" % entity_cls)
    lines.append("import net.minecraft.client.model.geom.ModelPart;")
    lines.append("import net.minecraft.client.model.geom.PartPose;")
    lines.append("import net.minecraft.client.model.geom.builders.CubeListBuilder;")
    lines.append("import net.minecraft.client.model.geom.builders.LayerDefinition;")
    lines.append("import net.minecraft.client.model.geom.builders.MeshDefinition;")
    lines.append("import net.minecraft.client.model.geom.builders.PartDefinition;")
    lines.append("import net.minecraft.resources.ResourceLocation;")
    lines.append("")
    lines.append("import java.util.List;")
    lines.append("")
    lines.append("public class %s extends RMobModel<%s> {" % (cls, entity_cls))
    lines.append("    public static final ResourceLocation TEXTURE = new ResourceLocation(\"randommobs\", \"textures/entity/%s.png\");" % name)
    lines.append("    public static final float SCALE = %s;" % f(spec.get("scale", 1.0)))
    lines.append("    public static final float SHADOW = %s;" % f(spec.get("shadow", 1.0)))
    lines.append("")
    lines.append("    public %s(ModelPart root) {" % cls)
    lines.append("        super(root);")

    def collect(prefixes):
        return [p["name"] for p in spec["parts"] if any(p["name"].startswith(x) for x in prefixes)]

    legs = collect(("leg",))
    tentacles = collect(("tentacle",))
    arms = collect(("arm",))
    wings = collect(("wing",))
    head = "head" if any(p["name"] == "head" for p in spec["parts"]) else None
    body = "body" if any(p["name"] == "body" for p in spec["parts"]) else None

    def list_of(names):
        if not names:
            return "List.of()"
        return "List.of(" + ", ".join('root.getChild("%s")' % n for n in names) + ")"

    lines.append("        this.registerParts(%s," % list_of(legs))
    lines.append("                %s," % list_of(tentacles))
    lines.append("                %s," % list_of(arms))
    lines.append("                %s," % list_of(wings))
    lines.append('                %s,' % ('root.getChild("head")' if head else "null"))
    lines.append('                %s);' % ('root.getChild("body")' if body else "null"))
    lines.append("    }")
    lines.append("")
    lines.append("    public static LayerDefinition createBodyLayer() {")
    lines.append("        MeshDefinition mesh = new MeshDefinition();")
    lines.append("        PartDefinition root = mesh.getRoot();")
    for p in spec["parts"]:
        var = p["name"]
        builder = "CubeListBuilder.create()"
        for b in p["boxes"]:
            u, v, _, _ = positions[id(b)]
            builder += "\n                .texOffs(%d, %d).addBox(%s, %s, %s, %s, %s, %s)" % (
                u, v, f(b["x"]), f(b["y"]), f(b["z"]), f(b["w"]), f(b["h"]), f(b["d"]))
        if p.get("rot"):
            pose = "PartPose.offsetAndRotation(%s, %s, %s, %s, %s, %s)" % (
                f(p["pivot"][0]), f(p["pivot"][1]), f(p["pivot"][2]),
                f(math.radians(p["rot"][0])), f(math.radians(p["rot"][1])), f(math.radians(p["rot"][2])))
        else:
            pose = "PartPose.offset(%s, %s, %s)" % (
                f(p["pivot"][0]), f(p["pivot"][1]), f(p["pivot"][2]))
        parent = "root" if not p.get("parent") else p["parent"]
        lines.append("        PartDefinition %s = %s.addOrReplaceChild(\"%s\", %s," % (var, parent, var, builder))
        lines.append("                %s);" % pose)
    lines.append("        return LayerDefinition.create(mesh, %d, %d);" % (tex_w, tex_h))
    lines.append("    }")
    lines.append("")
    lines.append("    @Override")
    lines.append("    public void setupAnim(%s entity, float limbSwing, float limbSwingAmount, float ageInTicks,"
                 % entity_cls)
    lines.append("                        float netHeadYaw, float headPitch) {")
    lines.append("        this.resetPose();")
    if legs:
        amp = "0.9F" if name not in ("tripod", "giant_spider") else "0.45F"
        lines.append("        Anims.legs(this.legs, limbSwing, limbSwingAmount, %s);" % amp)
    if tentacles:
        lines.append("        Anims.sway(this.tentacles, ageInTicks, 0.09F, 0.7F);")
    if arms:
        lines.append("        Anims.arms(this.arms, limbSwing, limbSwingAmount, 0.6F);")
    if wings:
        lines.append("        Anims.flap(this.wings, ageInTicks, 0.25F);")
    if head:
        lines.append("        Anims.head(this.head, netHeadYaw, headPitch);")
    if body and name in ("gardener", "ufo", "bloop", "kraken"):
        lines.append("        Anims.bob(this.body, ageInTicks, 0.6F);")
    lines.append("    }")
    lines.append("}")
    return "\n".join(lines) + "\n"


def main():
    os.makedirs(MODEL_JAVA, exist_ok=True)
    os.makedirs(ENTITY_TEX, exist_ok=True)
    os.makedirs(ITEM_TEX, exist_ok=True)
    os.makedirs(BLOCK_TEX, exist_ok=True)
    for name, spec in MOBS.items():
        tex_w, tex_h, _, placed = build_texture(spec, os.path.join(ENTITY_TEX, name + ".png"))
        java = build_java(name, spec, tex_w, tex_h, placed)
        with open(os.path.join(MODEL_JAVA, spec["class"] + ".java"), "w") as fh:
            fh.write(java)
        print("built %-16s texture %dx%d" % (name, tex_w, tex_h))


if __name__ == "__main__":
    main()
