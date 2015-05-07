package com.abstractlabs.toe.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketArmoury;
import com.abstractlabs.toe.network.PacketUtility;
import com.abstractlabs.toe.network.PacketWeaponry;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityBlockArmoury;
import com.abstractlabs.toe.tileentity.TileEntityUtility;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class GuiUtility extends GuiScreen 
{
	private EntityPlayer player;
	private TileEntityUtility tileEntity;
	private World world;
	private int x;
	private int y;
	private int z;
	
	private int xSize = 256;
	private int ySize = 221;
	
	// BUTTONS
	private GuiButtonExt done;
	
	private GuiButtonExt flashBang;
	private GuiButtonExt landMine;
	private GuiButtonExt grenade;
	private GuiButtonExt bois;
	private GuiButtonExt selfRevive;
	private GuiButtonExt exp;
	
	public GuiUtility(EntityPlayer player, TileEntityUtility entity, World world, int x, int y, int z) 
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
        
        this.buttonList.add(this.flashBang = new GuiButtonExt(0, width / 2 - 75, height / 2 - 80, 150, 20, "50 - Buy Flashbang"));
        this.buttonList.add(this.landMine = new GuiButtonExt(2, width/2 - 75, height/2 - 60, 150, 20, "$100 - Buy Landmine"));
        this.buttonList.add(this.grenade = new GuiButtonExt(3, width/2 - 75, height/2 - 40, 150, 20, "$150 - Buy Grenade"));
        this.buttonList.add(this.bois = new GuiButtonExt(4, width/2 - 75, height/2 - 20, 150, 20, "$200 - Buy Backup"));
        this.buttonList.add(this.selfRevive = new GuiButtonExt(5, width/2 - 75, height/2, 150, 20, "$250 - Buy Self Revive"));
        this.buttonList.add(this.exp = new GuiButtonExt(6, width/2 - 75, height/2 + 0, 150, 20, "$500 - Buy Experience"));
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
			else if (btn.id == flashBang.id) 
			{
				buy("flashBang");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == landMine.id) 
			{
				buy("landMine");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == grenade.id) 
			{
				buy("grenade");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == bois.id) 
			{
				buy("bois");
				Keyboard.enableRepeatEvents(false);
			} 
			else if (btn.id == selfRevive.id) 
			{
				buy("selfRevive");
				Keyboard.enableRepeatEvents(false);
			}
			else if (btn.id == exp.id) 
			{
				buy("exp");
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
		else if (id == flashBang.id) 
		{
			actionPerformed(flashBang);
		} 
		else if (id == landMine.id) 
		{
			actionPerformed(landMine);
		}
		else if (id == grenade.id) 
		{
			actionPerformed(grenade);
		} 
		else if (id == bois.id) 
		{
			actionPerformed(bois);
		} 
		else if (id == selfRevive.id) 
		{
			actionPerformed(selfRevive);
		}
		else if (id == exp.id) 
		{
			actionPerformed(exp);
		}
	}
	
	@Override
	public void drawScreen(int x, int y, float ticks) 
	{
		int guiX = (width - xSize) / 2;
		int guiY = (height - ySize) / 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		drawDefaultBackground();
	   	mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/utilityblock.png"));
	   	drawTexturedModalRect(guiX, guiY, 0, 0, xSize, ySize);
	   	this.drawCenteredString(this.fontRendererObj, "Utility Shop", width / 2, height / 2 - 100, 0x006600);
	   	super.drawScreen(x, y, ticks);
	}
	
	public void buy(String utility) 
    {
		Toe.packetPipeline.sendToServer(new PacketUtility(utility));
		//LogHelper.info(utility + " bought!");
	}
}
