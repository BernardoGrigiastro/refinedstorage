package com.raoulvdberge.refinedstorage.gui;

import com.raoulvdberge.refinedstorage.container.ContainerCrafter;
import com.raoulvdberge.refinedstorage.tile.TileCrafter;
import com.raoulvdberge.refinedstorage.util.RenderUtils;
import net.minecraft.entity.player.PlayerInventory;

public class GuiCrafter extends GuiBase<ContainerCrafter> {
    public GuiCrafter(ContainerCrafter container, PlayerInventory inventory) {
        super(container, 211, 137, inventory, null);
    }

    @Override
    public void init(int x, int y) {
    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void drawBackground(int x, int y, int mouseX, int mouseY) {
        bindTexture("gui/crafter.png");

        drawTexture(x, y, 0, 0, screenWidth, screenHeight);
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        drawString(7, 7, RenderUtils.shorten(t(TileCrafter.NAME.getValue()), 26));
        drawString(7, 43, t("container.inventory"));
    }
}
