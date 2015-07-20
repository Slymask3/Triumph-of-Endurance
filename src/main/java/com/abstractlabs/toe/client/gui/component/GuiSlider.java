package com.abstractlabs.toe.client.gui.component;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSlider extends GuiButton {
    private float min;
    private float max;
    private float value;
    public boolean pressed;
    
    private String text;
    private int color;

    public GuiSlider(int id, int x, int y, int width, int height, int min, int max, float defaultValue, String text, int color) {
        super(id, x, y, width, height, "");
        this.min = min;
        this.max = max;
        this.value = defaultValue/max;
        this.text = text;
        this.displayString = text + ": " + getActualValue();
        this.color = color;
    }

    public int getHoverState(boolean p_146114_1_) {
        return 0;
    }

    protected void mouseDragged(Minecraft mc, int par2, int par3) {
        if (this.visible) {
            if (this.pressed) {
                this.value = (float)(par2 - (this.xPosition + 4)) / (float)(this.width - 8);

                if (this.value < 0.0F) {
                    this.value = 0.0F;
                }

                if (this.value > 1.0F) {
                    this.value = 1.0F;
                }

//                float f = this.option.denormalizeValue(this.value);
//                mc.gameSettings.setOptionFloatValue(this.option, f);
                //this.value = this.option.normalizeValue(f);
                this.displayString = text + ": " + getActualValue();
            }

            GL11.glColor4f(getRed(color), getGreen(color), getBlue(color), 1.0F);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)), this.yPosition, 0, 66, 4, this.height);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)), this.yPosition + (this.height/2), 0, 66 + (20-(this.height/2)), 4, this.height/2);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, this.height);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)) + 4, this.yPosition + (this.height/2), 196, 66 + (20-(this.height/2)), 4, this.height/2);
        }
    }

    public boolean mousePressed(Minecraft mc, int par2, int par3) {
        if (super.mousePressed(mc, par2, par3)) {
            this.value = (float)(par2 - (this.xPosition + 4)) / (float)(this.width - 8);

            if (this.value < 0.0F) {
                this.value = 0.0F;
            }

            if (this.value > 1.0F) {
                this.value = 1.0F;
            }

            //mc.gameSettings.setOptionFloatValue(this.option, this.option.denormalizeValue(this.value));
            this.displayString = text + ": " + getActualValue();
            this.pressed = true;
            return true;
        } else {
            return false;
        }
    }

    public void mouseReleased(int par1, int par2) {
        this.pressed = false;
    }
    
    public int getActualValue() {
    	return (int) (value * max);
    }
    
    public float getRed(int color) {
    	Color c = new Color(color);
    	return c.getRed() / 255.0F;
    }
    
    public float getGreen(int color) {
    	Color c = new Color(color);
    	return c.getGreen() / 255.0F;
    }
    
    public float getBlue(int color) {
    	Color c = new Color(color);
    	return c.getBlue() / 255.0F;
    }
    
    public void drawButton(Minecraft mc, int par2, int par3) {
        if (this.visible) {
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(buttonTextures);
            
            GL11.glColor4f(getRed(color), getGreen(color), getBlue(color), 1.0F);
            
            //LogHelper.info("color == " + color + " | red == " + getRed(color) + " | green == " + getGreen(color) + " | blue == " + getBlue(color));
            
            this.field_146123_n = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition, this.yPosition + (this.height/2), 0, 46 + k * 20 + (20-(this.height/2)), this.width / 2, this.height/2);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + k * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition + (this.height/2), 200 - this.width / 2, 46 + k * 20 + (20-(this.height/2)), this.width / 2, this.height/2);
            
//            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)), this.yPosition, 0, 66, 4, this.height);
//            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)), this.yPosition + (this.height/2), 0, 66 + (20-(this.height/2)), 4, this.height/2);
//            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, this.height);
//            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)) + 4, this.yPosition + (this.height/2), 196, 66 + (20-(this.height/2)), 4, this.height/2);
            
            this.mouseDragged(mc, par2, par3);
            int l = 14737632;

            if (packedFGColour != 0) {
                l = packedFGColour;
            } else if (!this.enabled) {
                l = 10526880;
            } else if (this.field_146123_n) {
                l = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
        }
    }
}