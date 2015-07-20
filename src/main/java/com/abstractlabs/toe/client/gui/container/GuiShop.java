package com.abstractlabs.toe.client.gui.container;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.client.gui.component.GuiButtonArrow;
import com.abstractlabs.toe.entity.npc.EntityShop;
import com.abstractlabs.toe.inventory.ContainerShop;
import com.abstractlabs.toe.network.PacketShop;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.client.config.GuiButtonExt;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiShop extends GuiContainer {
    private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID, "textures/gui/container/shop.png");
    
    private EntityPlayer player;
    private EntityShop entity;
    
    private GuiButtonExt[] buy = new GuiButtonExt[6];
    private GuiButtonArrow left;
    private GuiButtonArrow right;
    
    private int page = 0;
    
    public GuiShop(InventoryPlayer inventory, EntityShop entity) {
        super(new ContainerShop(inventory, entity));
        this.player = inventory.player;
        this.entity = entity;
    }
    
    public void initGui() {
    	super.initGui();
    	int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
    	
        this.buttonList.add(this.buy[0] = new GuiButtonExt(0, this.width/2-26, this.height/2-64, 24, 12, ""));
        this.buttonList.add(this.buy[1] = new GuiButtonExt(1, this.width/2-26, this.height/2-47, 24, 12, ""));
        this.buttonList.add(this.buy[2] = new GuiButtonExt(2, this.width/2-26, this.height/2-29, 24, 12, ""));
        this.buttonList.add(this.buy[3] = new GuiButtonExt(3, this.width/2+2, this.height/2-64, 24, 12, ""));
        this.buttonList.add(this.buy[4] = new GuiButtonExt(4, this.width/2+2, this.height/2-47, 24, 12, ""));
        this.buttonList.add(this.buy[5] = new GuiButtonExt(5, this.width/2+2, this.height/2-29, 24, 12, ""));

//        this.buttonList.add(this.left = new GuiButtonArrow(6, i + 120 + 27, j + 24 - 1, true));
//        this.buttonList.add(this.right = new GuiButtonArrow(7, i + 36 - 19, j + 24 - 1, false));
        this.buttonList.add(this.left = new GuiButtonArrow(6, this.width/2-78, this.height/2-50, false));
        this.buttonList.add(this.right = new GuiButtonArrow(7, this.width/2+66, this.height/2-50, true));

        for(int s=0; s<6; s++) {
        	this.buy[s].visible = false;
        }
        
        this.left.enabled = false;
        this.right.enabled = false;
    }
    
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        String s = entity.getInventoryName() + " - Page " + (entity.getCurrentPage()+1) + "/" + entity.getPageAmount();
    	this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
        
        ItemStack slot1 = null;
        ItemStack slot1c = null;
        ItemStack slot2 = null;
        ItemStack slot2c = null;
        ItemStack slot3 = null;
        ItemStack slot3c = null;
        ItemStack slot4 = null;
        ItemStack slot4c = null;
        ItemStack slot5 = null;
        ItemStack slot5c = null;
        ItemStack slot6 = null;
        ItemStack slot6c = null;

        //SLOT 1
        if(entity.getShopItemsAmountOnCurrentPage() > 0) {
            slot1 = ((Slot)this.inventorySlots.inventorySlots.get(0)).inventory.getStackInSlot(0);
            slot1c = ((Slot)this.inventorySlots.inventorySlots.get(1)).inventory.getStackInSlot(1);
            this.buy[0].visible = true;
            
            if(entity.getOperationFromSlot(0) == 0) {
            	this.buy[0].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot1c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot1)) {
                	this.buy[0].enabled = true;
                } else {
                	this.buy[0].enabled = false;
                }
            } else if(entity.getOperationFromSlot(0) == 1) {
            	this.buy[0].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot1) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot1c)) {
                	this.buy[0].enabled = true;
                } else {
                	this.buy[0].enabled = false;
                }
            } else if(entity.getOperationFromSlot(0) == -1) {
            	this.buy[0].displayString = "???";
            	this.buy[0].enabled = false;
            }
            
        } else {
        	this.buy[0].visible = false;
        }
        
        //SLOT 2
        if(entity.getShopItemsAmountOnCurrentPage() > 1) {
	        slot2 = ((Slot)this.inventorySlots.inventorySlots.get(2)).inventory.getStackInSlot(2);
	        slot2c = ((Slot)this.inventorySlots.inventorySlots.get(3)).inventory.getStackInSlot(3);
            this.buy[1].visible = true;
            
            if(entity.getOperationFromSlot(1) == 0) {
            	this.buy[1].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot2c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot2)) {
                	this.buy[1].enabled = true;
                } else {
                	this.buy[1].enabled = false;
                }
            } else if(entity.getOperationFromSlot(1) == 1) {
            	this.buy[1].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot2) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot2c)) {
                	this.buy[1].enabled = true;
                } else {
                	this.buy[1].enabled = false;
                }
            } else if(entity.getOperationFromSlot(1) == -1) {
            	this.buy[1].displayString = "???";
            	this.buy[1].enabled = false;
            }
        } else {
        	this.buy[1].visible = false;
        }
        
        //SLOT 3
        if(entity.getShopItemsAmountOnCurrentPage() > 2) {
	        slot3 = ((Slot)this.inventorySlots.inventorySlots.get(4)).inventory.getStackInSlot(4);
	        slot3c = ((Slot)this.inventorySlots.inventorySlots.get(5)).inventory.getStackInSlot(5);
            this.buy[2].visible = true;
            
            if(entity.getOperationFromSlot(2) == 0) {
            	this.buy[2].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot3c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot3)) {
                	this.buy[2].enabled = true;
                } else {
                	this.buy[2].enabled = false;
                }
            } else if(entity.getOperationFromSlot(2) == 1) {
            	this.buy[2].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot3) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot3c)) {
                	this.buy[2].enabled = true;
                } else {
                	this.buy[2].enabled = false;
                }
            } else if(entity.getOperationFromSlot(2) == -1) {
            	this.buy[2].displayString = "???";
            	this.buy[2].enabled = false;
            }
        } else {
        	this.buy[2].visible = false;
        }

        //SLOT 4
        if(entity.getShopItemsAmountOnCurrentPage() > 3) {
	        slot4 = ((Slot)this.inventorySlots.inventorySlots.get(6)).inventory.getStackInSlot(6);
	        slot4c = ((Slot)this.inventorySlots.inventorySlots.get(7)).inventory.getStackInSlot(7);
            this.buy[3].visible = true;
            
            if(entity.getOperationFromSlot(3) == 0) {
            	this.buy[3].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot4c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot4)) {
                	this.buy[3].enabled = true;
                } else {
                	this.buy[3].enabled = false;
                }
            } else if(entity.getOperationFromSlot(3) == 1) {
            	this.buy[3].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot4) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot4c)) {
                	this.buy[3].enabled = true;
                } else {
                	this.buy[3].enabled = false;
                }
            } else if(entity.getOperationFromSlot(3) == -1) {
            	this.buy[3].displayString = "???";
            	this.buy[3].enabled = false;
            }
            
        } else {
        	this.buy[3].visible = false;
        }

        //SLOT 5
        if(entity.getShopItemsAmountOnCurrentPage() > 4) {
	        slot5 = ((Slot)this.inventorySlots.inventorySlots.get(8)).inventory.getStackInSlot(8);
	        slot5c = ((Slot)this.inventorySlots.inventorySlots.get(9)).inventory.getStackInSlot(9);
            this.buy[4].visible = true;
            
            if(entity.getOperationFromSlot(4) == 0) {
            	this.buy[4].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot5c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot5)) {
                	this.buy[4].enabled = true;
                } else {
                	this.buy[4].enabled = false;
                }
            } else if(entity.getOperationFromSlot(4) == 1) {
            	this.buy[4].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot5) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot5c)) {
                	this.buy[4].enabled = true;
                } else {
                	this.buy[4].enabled = false;
                }
            } else if(entity.getOperationFromSlot(4) == -1) {
            	this.buy[4].displayString = "???";
            	this.buy[4].enabled = false;
            }
        } else {
        	this.buy[4].visible = false;
        }
        
        //SLOT 6
        if(entity.getShopItemsAmountOnCurrentPage() > 5) {
	        slot6 = ((Slot)this.inventorySlots.inventorySlots.get(10)).inventory.getStackInSlot(10);
	        slot6c = ((Slot)this.inventorySlots.inventorySlots.get(11)).inventory.getStackInSlot(11);
            this.buy[5].visible = true;
            
            if(entity.getOperationFromSlot(5) == 0) {
            	this.buy[5].displayString = "Buy";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot6c) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot6)) {
                	this.buy[5].enabled = true;
                } else {
                	this.buy[5].enabled = false;
                }
            } else if(entity.getOperationFromSlot(5) == 1) {
            	this.buy[5].displayString = "Sell";
            	
            	if(Helper.doesPlayerHaveEnoughItemAmount(player, slot6) && Helper.doesPlayerHaveEnoughSpaceForItemStacks(player, slot6c)) {
                	this.buy[5].enabled = true;
                } else {
                	this.buy[5].enabled = false;
                }
            } else if(entity.getOperationFromSlot(5) == -1) {
            	this.buy[5].displayString = "???";
            	this.buy[5].enabled = false;
            }
        } else {
        	this.buy[5].visible = false;
        }
        
        //LEFT ARROW
        if(this.entity.getCurrentPage() > 0) {
        	this.left.enabled = true;
        } else {
        	this.left.enabled = false;
        }

        //RIGHT ARROW
        if(this.entity.getCurrentPage() < this.entity.getPageAmount()-1) {
        	this.right.enabled = true;
        } else {
        	this.right.enabled = false;
        }
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
    
    @Override
	protected void actionPerformed(final GuiButton btn) {
		if (btn.enabled) {
			sendInfo(btn.id);
		}
	}
    
    public void sendInfo(int id) {
    	if(id < 6) {
        	Toe.packetPipeline.sendToServer(new PacketShop(0, entity.worldObj, entity.getEntityId(), id*2));
        	
        	ItemStack is = ((Slot)this.inventorySlots.inventorySlots.get(id*2)).inventory.getStackInSlot(id*2);
    		LogHelper.info("[GuiShop] Sent packet to operate " + is);
    	} else if(id == 6) {
    		page--;
    		
    		((ContainerShop) this.inventorySlots).changePage(page);
        	//Toe.packetPipeline.sendToAll(new PacketShop(1, entity.worldObj, entity.getEntityId(), entity.getCurrentPage()-1));
        	Toe.packetPipeline.sendToServer(new PacketShop(1, entity.worldObj, entity.getEntityId(), page));
    	} else if(id == 7) {
    		page++;
    		
    		((ContainerShop) this.inventorySlots).changePage(page);
        	//Toe.packetPipeline.sendToAll(new PacketShop(1, entity.worldObj, entity.getEntityId(), entity.getCurrentPage()+1));
        	Toe.packetPipeline.sendToServer(new PacketShop(1, entity.worldObj, entity.getEntityId(), page));
    	}
	}
    
    @Override
    public void onGuiClosed() {
    	page = 0;
//    	entity.setCurrentPage(0);
    	
    	((ContainerShop) this.inventorySlots).changePage(page);
    	Toe.packetPipeline.sendToServer(new PacketShop(1, entity.worldObj, entity.getEntityId(), page));
    }
}