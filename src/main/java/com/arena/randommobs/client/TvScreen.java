package com.arena.randommobs.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The television browser. It is a browser in the same way that a cardboard box is a car.
 */
public class TvScreen extends Screen {
    private static final String[] PAGES = {"randommobs://home", "randommobs://storm", "randommobs://mobs"};

    private final List<String> history = new ArrayList<>();
    private int page;

    public TvScreen() {
        super(Component.translatable("block.randommobs.tv.title"));
    }

    @Override
    protected void init() {
        int y = this.height - 40;
        this.addRenderableWidget(Button.builder(Component.literal("<"), button -> this.turn(-1))
                .bounds(this.width / 2 - 90, y, 24, 20).build());
        this.addRenderableWidget(Button.builder(Component.literal(">"), button -> this.turn(1))
                .bounds(this.width / 2 + 66, y, 24, 20).build());
        this.addRenderableWidget(Button.builder(Component.translatable("gui.done"), button -> this.onClose())
                .bounds(this.width / 2 - 40, y, 80, 20).build());
    }

    private void turn(int direction) {
        this.page = (this.page + direction + PAGES.length) % PAGES.length;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        int left = this.width / 2 - 160;
        int top = 40;
        graphics.fill(left, top, left + 320, top + this.height - 110, 0xF0101418);
        graphics.fill(left + 4, top + 30, left + 316, top + this.height - 116, 0xFF05080A);
        graphics.drawString(this.font, PAGES[this.page], left + 10, top + 10, 0xFF6CF0C8);
        int lineY = top + 44;
        for (String line : this.lines()) {
            graphics.drawString(this.font, line, left + 12, lineY, 0xFF9BE3C9);
            lineY += 12;
        }
        graphics.drawString(this.font, Component.translatable("block.randommobs.tv.status"),
                left + 10, top + this.height - 120, 0xFF3E7A63);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    private List<String> lines() {
        List<String> out = new ArrayList<>();
        switch (this.page) {
            case 1 -> {
                out.add("randommobs.net/storm");
                out.add("");
                out.add("> tornado watch in effect");
                out.add("> do not trust the sky");
                out.add("> reinforced glass recommended");
            }
            case 2 -> {
                out.add("randommobs.net/mobs");
                out.add("");
                out.add("> woodcrawler ............ avoid");
                out.add("> chest mimic ............ it is a mouth");
                out.add("> lights ................. do not follow");
            }
            default -> {
                out.add("randommobs.net");
                out.add("");
                out.add("> welcome to the browser");
                out.add("> everything here is real");
                out.add("> except the browser");
            }
        }
        return out;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
