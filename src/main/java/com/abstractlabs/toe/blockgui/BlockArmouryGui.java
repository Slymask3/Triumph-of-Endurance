package com.abstractlabs.toe.blockgui;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.reference.Reference;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class BlockArmouryGui extends GuiScreen 
{
	int xSize = 148;
	int ySize = 80;
	
    public static final int GUI_ID = 20;

    public BlockArmouryGui() 
    {
        System.out.print("gui constructor.\n");
    }

    @Override
    public void initGui() 
    {
        //buttonList.clear();
        //buttonList.add(new GuiButton(0, 100, 100, 60, 60, "Button"));
    }

    @Override
    public boolean doesGuiPauseGame() 
    {
        return false;
    }

    @Override
    public void drawScreen(int x, int y, float ticks) 
    {
    	int guiX = (width - xSize) / 2;
        int guiY = (height - ySize) / 2;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/armouryblock.png"));
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        fontRendererObj.drawString("Armoury", guiX + 40, guiY + 5, 0xFFFFFF);
        super.drawScreen(x, y, ticks);
        System.out.print("drawing gui.\n");
    }
}
