package com.abstractlabs.toe.client.gui.screen;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketATM;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.tileentity.TileEntityATM;
import com.abstractlabs.toe.utility.Helper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiATM extends GuiScreen {
	private EntityPlayer player;
	private TileEntityATM tileEntity;
	private World world;
	private int x;
	private int y;
	private int z;

    private GuiButtonExt done;
    
	private GuiTextField input;
    
    private GuiButtonExt depositCopper;
    private GuiButtonExt depositSilver;
    private GuiButtonExt depositGold;
    private GuiButtonExt depositAll;
    private GuiButtonExt withdrawCopper;
    private GuiButtonExt withdrawSilver;
    private GuiButtonExt withdrawGold;
    private GuiButtonExt withdrawAll;
    
    public static int copper;
    public static int silver;
    public static int gold;
    
//    private int copper;
//    private int silver;
//    private int gold;
    
    private int xSize = 256;
	private int ySize = 221;

	public GuiATM(EntityPlayer player, TileEntityATM entity, World world, int x, int y, int z) {
		this.player = player;
		this.tileEntity = entity;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
//		this.copper = c;
//		this.silver = s;
//		this.gold = g;
	}

	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		this.buttonList.clear();
        
        this.buttonList.add(this.done = new GuiButtonExt(1, width/2 + 0 - 75, height/2 + 75, 150, 20, I18n.format("gui.done", new Object[0])));
        
        this.buttonList.add(this.depositCopper = new GuiButtonExt(0, width/2 - 105, height/2 - 62, 80, 20, "Deposit"));
        this.buttonList.add(this.depositSilver = new GuiButtonExt(2, width/2 - 105, height/2 - 38, 80, 20, "Deposit"));
        this.buttonList.add(this.depositGold = new GuiButtonExt(3, width/2 - 105, height/2 - 14, 80, 20, "Deposit"));
        this.buttonList.add(this.depositAll = new GuiButtonExt(4, width/2 - 105, height/2 + 10, 100, 20, "Deposit All Coins"));
        this.buttonList.add(this.withdrawCopper = new GuiButtonExt(5, width/2 + 26, height/2 - 62, 80, 20, "Withdraw"));
        this.buttonList.add(this.withdrawSilver = new GuiButtonExt(6, width/2 + 26, height/2 -38, 80, 20, "Withdraw"));
        this.buttonList.add(this.withdrawGold = new GuiButtonExt(7, width/2 + 26, height/2 -14, 80, 20, "Withdraw"));
        this.buttonList.add(this.withdrawAll = new GuiButtonExt(8, width/2 + 6, height/2 + 10, 100, 20, "Withdraw All Coins"));
        
        this.input = new GuiTextField(this.fontRendererObj, this.width/2 - 105, height/2 - 86, 210, 20);
		this.input.setText("");
		this.input.setFocused(true);
		
		this.depositCopper.enabled = this.input.getText().trim().length() > 0;
		this.depositSilver.enabled = this.input.getText().trim().length() > 0;
		this.depositGold.enabled = this.input.getText().trim().length() > 0;
		this.withdrawCopper.enabled = this.input.getText().trim().length() > 0;
		this.withdrawSilver.enabled = this.input.getText().trim().length() > 0;
		this.withdrawGold.enabled = this.input.getText().trim().length() > 0;
	}
	
	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

	@Override
	protected void actionPerformed(final GuiButton btn) {
		if (btn.enabled) {
			if (btn.id == done.id) {
//				done();
				Keyboard.enableRepeatEvents(false);
				mc.displayGuiScreen(null);
			} else if (btn.id == depositCopper.id) {
				deposit(1);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == depositSilver.id) {
				deposit(2);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == depositGold.id) {
				deposit(3);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == depositAll.id) {
				depositAll();
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == withdrawCopper.id) {
				withdraw(1);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == withdrawSilver.id) {
				withdraw(2);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == withdrawGold.id) {
				withdraw(3);
				Keyboard.enableRepeatEvents(false);
			} else if (btn.id == withdrawAll.id) {
				withdrawAll();
				Keyboard.enableRepeatEvents(false);
			}
		}
	}

	@Override
	protected void keyTyped(final char par1, final int id) {
		if (("0123456789".indexOf(par1) >= 0) || (id == 14)) {
			input.textboxKeyTyped(par1, id);
		} else if (id == done.id) {
			actionPerformed(done);
		} else if (id == depositCopper.id) {
			actionPerformed(depositCopper);
		} else if (id == depositSilver.id) {
			actionPerformed(depositSilver);
		} else if (id == depositGold.id) {
			actionPerformed(depositGold);
		} else if (id == depositAll.id) {
			actionPerformed(depositAll);
		} else if (id == withdrawCopper.id) {
			actionPerformed(withdrawCopper);
		} else if (id == withdrawSilver.id) {
			actionPerformed(withdrawSilver);
		} else if (id == withdrawGold.id) {
			actionPerformed(withdrawGold);
		} else if (id == withdrawAll.id) {
			actionPerformed(withdrawAll);
		}

		this.depositCopper.enabled = this.input.getText().trim().length() > 0;
		this.depositSilver.enabled = this.input.getText().trim().length() > 0;
		this.depositGold.enabled = this.input.getText().trim().length() > 0;
		this.withdrawCopper.enabled = this.input.getText().trim().length() > 0;
		this.withdrawSilver.enabled = this.input.getText().trim().length() > 0;
		this.withdrawGold.enabled = this.input.getText().trim().length() > 0;
	}
	
	@Override
	protected void mouseClicked(int x, int y, int click) {
        super.mouseClicked(x, y, click);
        this.input.mouseClicked(x, y, click);
    }
	
	@Override
	public void drawScreen(final int par1, final int par2, final float par3) {
		this.drawDefaultBackground();
		
		int guiX = (width - xSize) / 2;
        int guiY = (height - ySize) / 2;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/atm.png"));
        drawTexturedModalRect(guiX, guiY, 0, 0, xSize, ySize);
		
        //ATM atm = ATM.getProperties(this.player);
        
        //this.drawCenteredString(this.fontRendererObj, "ATM | Copper = " + copper + ", Silver = " + silver + ", Gold = " + gold, width/2, height/2 - 100, 0xAA00AA);

        Helper.drawCenteredStringWithBorder(mc, width/2, height/2-100, "ATM", 0xAA00AA, 0x000000);

        Helper.drawCenteredStringWithBorder(mc, width/2, height/2-56, copper, 0X8D6B44, 0x000000);
        Helper.drawCenteredStringWithBorder(mc, width/2, height/2-32, silver, 0xB5B5B5, 0x000000);
        Helper.drawCenteredStringWithBorder(mc, width/2, height/2-8, gold, 0xAC972B, 0x000000);
        
        this.input.drawTextBox();
        
		super.drawScreen(par1, par2, par3);
	}
	
	private void deposit(int coin) {
		Toe.packetPipeline.sendToServer(new PacketATM(0, coin, Integer.parseInt(input.getText())));
	}
	
	private void withdraw(int coin) {
		Toe.packetPipeline.sendToServer(new PacketATM(1, coin, Integer.parseInt(input.getText())));
	}
	
	private void depositAll() {
		Toe.packetPipeline.sendToServer(new PacketATM(0, -1, -1));
	}
	
	private void withdrawAll() {
		Toe.packetPipeline.sendToServer(new PacketATM(1, -1, -1));
	}
	
//	private void done() {
//		GuiATMOverlay.usingATM = false;
//	}
}