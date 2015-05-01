package com.abstractlabs.toe.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketArmoury;
import com.abstractlabs.toe.network.PacketWeaponry;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class BlockArmouryGui extends GuiScreen 
{
	private EntityPlayer player;
	private TileEntityBlockArmoury tileEntity;
	private World world;
	private int x;
	private int y;
	private int z;
	
	private int xSize = 256;
	private int ySize = 221;
	
	// BUTTONS
	private GuiButtonExt done;
	
	private GuiButtonExt leatherArmour;
	private GuiButtonExt goldArmour;
	private GuiButtonExt chainArmour;
	private GuiButtonExt ironArmour;
	private GuiButtonExt diamondArmour;
	
    public BlockArmouryGui(EntityPlayer player, TileEntityBlockArmoury entity, World world, int x, int y, int z) 
    {
		this.player = player;
		this.tileEntity = entity;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

    @Override
    public void initGui() 
    {
        Keyboard.enableRepeatEvents(true);
        
        this.buttonList.clear();
        
        this.buttonList.add(this.done = new GuiButtonExt(1, width / 2 + 0 - 75, height / 2 + 75, 150, 20, I18n.format("gui.done", new Object[0])));
        
        this.buttonList.add(this.leatherArmour = new GuiButtonExt(0, width / 2 - 75, height / 2 - 80, 150, 20, "$50 - Buy Leather Set"));
        this.buttonList.add(this.goldArmour = new GuiButtonExt(2, width/2 - 75, height/2 - 60, 150, 20, "$100 - Buy Gold Set"));
        this.buttonList.add(this.chainArmour = new GuiButtonExt(3, width/2 - 75, height/2 - 40, 150, 20, "$150 - Buy Chain Set"));
        this.buttonList.add(this.ironArmour = new GuiButtonExt(4, width/2 - 75, height/2 - 20, 150, 20, "$200 - Buy Iron Set"));
        this.buttonList.add(this.diamondArmour = new GuiButtonExt(5, width/2 - 75, height/2, 150, 20, "$250 - Buy Diamond Set"));
    }
    
    @Override
    public boolean doesGuiPauseGame() 
    {
        return false;
    }
    
    @Override
	protected void actionPerformed(final GuiButton btn) 
    {
		if (btn.enabled) 
		{
			if (btn.id == done.id) 
			{
				Keyboard.enableRepeatEvents(false);
				mc.displayGuiScreen(null);
			} 
			else if (btn.id == leatherArmour.id) 
			{
				buy("leatherArmour");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == goldArmour.id) 
			{
				buy("goldArmour");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == chainArmour.id) 
			{
				buy("chainArmour");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == ironArmour.id) 
			{
				buy("ironArmour");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == diamondArmour.id) 
			{
				buy("diamondArmour");
				Keyboard.enableRepeatEvents(false);
			}
		}
	}
    
    @Override
	protected void keyTyped(final char par1, final int id) 
    {
		if (id == done.id) 
		{
			actionPerformed(done);
		} 
		else if (id == leatherArmour.id) 
		{
			actionPerformed(leatherArmour);
		} 
		else if (id == goldArmour.id) 
		{
			actionPerformed(goldArmour);
		}
		else if (id == chainArmour.id) 
		{
			actionPerformed(chainArmour);
		} 
		else if (id == ironArmour.id) 
		{
			actionPerformed(ironArmour);
		} 
		else if (id == diamondArmour.id) 
		{
			actionPerformed(diamondArmour);
		}
	}

    @Override
    public void drawScreen(int x, int y, float ticks) 
    {
    	int guiX = (width - xSize) / 2;
        int guiY = (height - ySize) / 2;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/armouryblock.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, xSize, ySize);
        this.drawCenteredString(this.fontRendererObj, "Armoury Shop", width / 2, height / 2 - 100, 0x006600);
        super.drawScreen(x, y, ticks);
    }
    
    public void buy(String armoury) 
    {
		Toe.packetPipeline.sendToServer(new PacketArmoury(armoury));
		//LogHelper.info(armour + " bought!");
	}
}
