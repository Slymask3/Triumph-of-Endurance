package com.abstractlabs.toe.client.gui.screen;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.network.PacketStatue;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.tileentity.TileEntityStatueBiped;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStatue extends GuiScreen {
	private EntityPlayer player;
	private TileEntityStatueBiped tileEntity;
	private World world;
	private int x;
	private int y;
	private int z;

    private GuiButtonExt done;
	private GuiTextField input;

	public GuiStatue(EntityPlayer player, TileEntityStatueBiped e, World world, int x, int y, int z) {
		this.player = player;
		this.tileEntity = e;
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
        
        this.input = new GuiTextField(this.fontRendererObj, this.width / 2 - 4 - 150, 50, 300+8, 20);
		this.input.setText("");
		this.input.setFocused(true);
		
		this.done.enabled = this.input.getText().trim().length() > 0;
	}
	
	@Override
    public boolean doesGuiPauseGame() {
        return false;
    }

	@Override
	protected void actionPerformed(final GuiButton btn) {
		if (btn.enabled) {
			if (btn.id == done.id) {
				send();
				Keyboard.enableRepeatEvents(false);
				mc.displayGuiScreen(null);
			}
		}
	}

	@Override
	protected void keyTyped(final char par1, final int par2) {
		
		if (("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_".indexOf(par1) >= 0) || (par2 == 14)) {
			input.textboxKeyTyped(par1, par2);
		} else if (par2 == done.id) {
			actionPerformed(done);
		}

        this.done.enabled = this.input.getText().trim().length() > 0;
	}
	
	@Override
	protected void mouseClicked(int x, int y, int click) {
        super.mouseClicked(x, y, click);
        this.input.mouseClicked(x, y, click);
    }
	
	@Override
	public void drawScreen(final int par1, final int par2, final float par3) {
		this.drawDefaultBackground();
		
		this.drawCenteredString(this.fontRendererObj, "Statue", this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, "Enter a valid player's username:", this.width / 2 - 4 - 150, 37, 10526880);
        
		this.input.drawTextBox();
		
		super.drawScreen(par1, par2, par3);
	}
	
	public void send() {
		tileEntity.setUsername(this.input.getText());
		Toe.packetPipeline.sendToServer(new PacketStatue(this.world, this.x, this.y, this.z, this.input.getText()));
		LogHelper.info("getText() == " + this.input.getText());
		
		Helper.msg(player, "Created a statue of the player: " + this.input.getText(), Color.lime);
	}
}