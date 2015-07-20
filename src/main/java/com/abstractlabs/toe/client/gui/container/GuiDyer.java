package com.abstractlabs.toe.client.gui.container;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.client.gui.component.GuiSlider;
import com.abstractlabs.toe.entity.npc.EntityDyer;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.inventory.ContainerDyer;
import com.abstractlabs.toe.network.PacketDyer;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDyer extends GuiContainer {
    private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/dyer.png");

    //private static final GameSettings.Options[] options = new GameSettings.Options[] {GameSettings.Options.FOV, GameSettings.Options.DIFFICULTY};
    //private GameSettings.Options option = GameSettings.Options.DIFFICULTY;
    
    private EntityDyer entity;
    
    private GuiButtonExt done;
    private GuiSlider red;
    private GuiSlider blue;
    private GuiSlider green;
    
    public GuiDyer(InventoryPlayer inventory, EntityDyer entity) {
        super(new ContainerDyer(inventory, entity));
        this.entity = entity;
    }
    
    public void initGui() {
    	super.initGui();
		//Keyboard.enableRepeatEvents(true);
    	//this.buttonList.clear();
        this.buttonList.add(this.done = new GuiButtonExt(0, this.width/2+30, this.height/2-47, 24, 12, "Dye"));

        this.buttonList.add(this.red = new GuiSlider(1, this.width/2-81, this.height/2-67, 80, 14, 0, 255, 127, "Red", 0xFF0000));
        this.buttonList.add(this.green = new GuiSlider(2, this.width/2-81, this.height/2-48, 80, 14, 0, 255, 127, "Green", 0x00FF00));
        this.buttonList.add(this.blue = new GuiSlider(3, this.width/2-81, this.height/2-29, 80, 14, 0, 255, 127, "Blue", 0x0088FF));
        
        this.done.enabled = false;
        
//        this.color[i] = new GuiTextField(this.fontRendererObj, this.width / 2 - 4 - 100, 45 + (20*i), 60, 14);
//		this.color[i].setText(tileEntity.color[i]);
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = "Dyer";
    	this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);

//        this.mc.getTextureManager().bindTexture(textures);
//        GL11.glColor3f(red.getActualValue()/255.0F, green.getActualValue()/255.0F, blue.getActualValue()/255.0F);
//        this.drawTexturedModalRect(this.xSize/2+34, this.ySize/2-66, 176, 0, 16, 16);

        ItemStack slot0 = ((Slot)this.inventorySlots.inventorySlots.get(0)).inventory.getStackInSlot(0);
        ItemStack slot1 = ((Slot)this.inventorySlots.inventorySlots.get(1)).inventory.getStackInSlot(1);
        
        if(isItemDyeable(slot0) && isItemCoin(slot1)) {
        	this.done.enabled = true;
        } else {
        	this.done.enabled = false;
        }
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
        GL11.glColor3f(red.getActualValue()/255.0F, green.getActualValue()/255.0F, blue.getActualValue()/255.0F);
        this.drawTexturedModalRect(this.width/2+34, this.height/2-66, 176, 0, 16, 16);
    }
    
    @Override
	protected void actionPerformed(final GuiButton btn) {
		if (btn.enabled) {
			if (btn.id == done.id) {
				sendInfo();
				//Keyboard.enableRepeatEvents(false);
			}
		}
	}
    
    public void sendInfo() {
    	LogHelper.info("slot 0 == " + ((Slot)this.inventorySlots.inventorySlots.get(0)).inventory.getStackInSlot(0));
    	LogHelper.info("slot 1 == " + ((Slot)this.inventorySlots.inventorySlots.get(1)).inventory.getStackInSlot(1));
    	
    	Toe.packetPipeline.sendToServer(new PacketDyer(entity.worldObj, entity.getEntityId(), red.getActualValue(), green.getActualValue(), blue.getActualValue()));
    	
		//InstantBlocks.packetPipeline.sendToServer(new PacketSkydive(this.world, this.x, this.y, this.z, this.player.getDisplayName(), getHex(color[0].getText()), getHex(color[1].getText()), getHex(color[2].getText()), getHex(color[3].getText()), getHex(color[4].getText()), getHex(color[5].getText()), getHex(color[6].getText()), getHex(color[7].getText()), getHex(color[8].getText()), getHex(color[9].getText()), getHex(color[10].getText()), tp.isChecked()));
	}
    
    private boolean isItemDyeable(ItemStack is) {
    	if(is== null) {
    		return false;
    	}
    	
		Item i = is.getItem();
		return i == Items.leather_helmet || i == Items.leather_chestplate || i == Items.leather_leggings || i == Items.leather_boots || i == ToeItems.woodClaw || i == ToeItems.stoneClaw || i == ToeItems.ironClaw || i == ToeItems.goldClaw || i == ToeItems.diamondClaw || i == ToeItems.emeraldClaw || i == ToeItems.rubyClaw || i == ToeItems.sapphireClaw || i == ToeItems.tophat;
	}
	
	private boolean isItemCoin(ItemStack is) {
    	if(is== null) {
    		return false;
    	}
    	
		Item i = is.getItem();
		return i == ToeItems.coinCopper;
	}
}