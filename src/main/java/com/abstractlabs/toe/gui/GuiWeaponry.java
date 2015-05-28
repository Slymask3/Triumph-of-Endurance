package com.abstractlabs.toe.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketWeaponry;
import com.abstractlabs.toe.reference.Price;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.tileentity.TileEntityWeaponry;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiWeaponry extends GuiScreen {
	private EntityPlayer player;
	private TileEntityWeaponry tileEntity;
	private World world;
	private int x;
	private int y;
	private int z;
	
	//private PlayerExtra pe = new PlayerExtra(player);

    private GuiButtonExt done;
    
    private GuiButtonExt woodSword;
    private GuiButtonExt stoneSword;
    private GuiButtonExt ironSword;
    private GuiButtonExt goldSword;
    private GuiButtonExt diamondSword;
    
    private int xSize = 256;
	private int ySize = 221;

	public GuiWeaponry(EntityPlayer player, TileEntityWeaponry entity, World world, int x, int y, int z) {
		this.player = player;
		this.tileEntity = entity;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
        
        this.buttonList.add(this.done = new GuiButtonExt(1, width / 2 + 0 - 75, height/2 + 75, 150, 20, I18n.format("gui.done", new Object[0])));
        
        this.buttonList.add(this.woodSword = new GuiButtonExt(0, width/2 - 75, height/2 - 80, 150, 20, "$" + Price.woodSword + " - Buy Wooden Sword"));
        this.buttonList.add(this.stoneSword = new GuiButtonExt(2, width/2 - 75, height/2 - 60, 150, 20, "$" + Price.stoneSword + " - Buy Stone Sword"));
        this.buttonList.add(this.ironSword = new GuiButtonExt(3, width/2 - 75, height/2 - 40, 150, 20, "$" + Price.ironSword + " - Buy Iron Sword"));
        this.buttonList.add(this.goldSword = new GuiButtonExt(4, width/2 - 75, height/2 - 20, 150, 20, "$" + Price.goldSword + " - Buy Golden Sword"));
        this.buttonList.add(this.diamondSword = new GuiButtonExt(5, width/2 - 75, height/2, 150, 20, "$" + Price.diamondSword + " - Buy Diamond Sword"));
	}
	
	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

	@Override
	protected void actionPerformed(final GuiButton btn) {
		if (btn.enabled) {
			if (btn.id == done.id) {
				Keyboard.enableRepeatEvents(false);
				mc.displayGuiScreen(null);
			} else if (btn.id == woodSword.id) {
				buy("woodSword", Price.woodSword);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == stoneSword.id) {
				buy("stoneSword", Price.stoneSword);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == ironSword.id) {
				buy("ironSword", Price.ironSword);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == goldSword.id) {
				buy("goldSword", Price.goldSword);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == diamondSword.id) {
				buy("diamondSword", Price.diamondSword);
				Keyboard.enableRepeatEvents(false);
			}
		}
	}

	@Override
	protected void keyTyped(final char par1, final int id) {
		if (id == done.id) {
			actionPerformed(done);
		} else if (id == woodSword.id) {
			actionPerformed(woodSword);
		} else if (id == stoneSword.id) {
			actionPerformed(stoneSword);
		} else if (id == ironSword.id) {
			actionPerformed(ironSword);
		} else if (id == goldSword.id) {
			actionPerformed(goldSword);
		} else if (id == diamondSword.id) {
			actionPerformed(diamondSword);
		}
	}
	
	@Override
	public void drawScreen(final int par1, final int par2, final float par3) {
		this.drawDefaultBackground();
		
		int guiX = (width - xSize) / 2;
        int guiY = (height - ySize) / 2;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/weaponry.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, xSize, ySize);
		
        this.drawCenteredString(this.fontRendererObj, "Weaponry Shop   Cash: $" + ArenalismHelper.getProperties(player).getCash(), width/2, height/2 - 100, 0x00AAAA);
        
		super.drawScreen(par1, par2, par3);
	}
	
	public void buy(String weapon, int price) {
		LogHelper.info("gui.price: " + price);
		Toe.packetPipeline.sendToServer(new PacketWeaponry(weapon, price));
		//LogHelper.info(weapon + " bought!");
	}
}