package com.abstractlabs.toe.client.gui.component;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiButtonArrow extends GuiButton {
    private static final ResourceLocation villager = new ResourceLocation("textures/gui/container/villager.png");
	private final boolean right;

    public GuiButtonArrow(int id, int x, int y, boolean right) {
        super(id, x, y, 12, 19, "");
        this.right = right;
    }

    public void drawButton(Minecraft mc, int x, int y) {
        if (this.visible) {
            mc.getTextureManager().bindTexture(villager);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean flag = x >= this.xPosition && y >= this.yPosition && x < this.xPosition + this.width && y < this.yPosition + this.height;
            int k = 0;
            int l = 176;

            if (!this.enabled) {
                l += this.width * 2;
            } else if (flag) {
                l += this.width;
            }

            if (!this.right) {
                k += this.height;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, l, k, this.width, this.height);
        }
    }
}