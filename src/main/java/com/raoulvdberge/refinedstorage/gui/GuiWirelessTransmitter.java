package com.raoulvdberge.refinedstorage.gui;

import com.raoulvdberge.refinedstorage.container.ContainerWirelessTransmitter;
import com.raoulvdberge.refinedstorage.gui.control.SideButtonRedstoneMode;
import com.raoulvdberge.refinedstorage.tile.TileWirelessTransmitter;
import net.minecraft.entity.player.PlayerInventory;

public class GuiWirelessTransmitter extends GuiBase<ContainerWirelessTransmitter> {
    public GuiWirelessTransmitter(ContainerWirelessTransmitter container, PlayerInventory inventory) {
        super(container, 211, 137, inventory, null);
    }

    @Override
    public void init(int x, int y) {
        addSideButton(new SideButtonRedstoneMode(this, TileWirelessTransmitter.REDSTONE_MODE));
    }

    @Override
    public void update(int x, int y) {
    }

    @Override
    public void drawBackground(int x, int y, int mouseX, int mouseY) {
        bindTexture("gui/wireless_transmitter.png");

        drawTexture(x, y, 0, 0, screenWidth, screenHeight);
    }

    @Override
    public void drawForeground(int mouseX, int mouseY) {
        drawString(7, 7, t("gui.refinedstorage:wireless_transmitter"));
        drawString(28, 25, t("gui.refinedstorage:wireless_transmitter.distance", TileWirelessTransmitter.RANGE.getValue()));
        drawString(7, 43, t("container.inventory"));
    }
}
