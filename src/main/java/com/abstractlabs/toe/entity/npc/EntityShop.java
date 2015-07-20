package com.abstractlabs.toe.entity.npc;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public abstract class EntityShop extends EntityAnimal implements IInventory {
    private ItemStack[] itemstacksAll;
    private ItemStack[] itemstacksCurrent;

    private int[] operationAll;
    private int[] operationCurrent;
    
    private EntityPlayer player;
    
    private int currentPage;
	
    protected final int BUY = 0;
    protected final int SELL = 1;
    
    private String shopName;
    
	public EntityShop(World world, String name, int items) {
		super(world);
		this.setSize(0.6F, 1.8F);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.itemstacksAll = new ItemStack[items*2];
        this.itemstacksCurrent = new ItemStack[6*2];
        this.operationAll = new int[items*2];
        this.operationCurrent = new int[6*2];
        this.shopName = name;
        
        this.addItemStacksToShop();
        this.createFirstPage();
	}
	
	public abstract void addItemStacksToShop();

	protected void createFirstPage() {
//		int times = 0;
//		
//		if(this.getSizeAll() >= 6) {
//			times = 6;
//		} else {
//			times = this.getSizeAll();
//		}
//		
//		for(int i=0; i<times; i++) {
//			this.itemstacksCurrent[i] = this.itemstacksAll[i].copy();
//		}
		this.resetSlots();
	}
	
	public void operateItem(int item, EntityPlayer player) {

//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < itemstacksCurrent.length; i++) {
//		   sb.append( itemstacksCurrent[i] + ", " );
//		}
//		String isc = sb.toString();
//
//		StringBuilder sb2 = new StringBuilder();
//		for (int i = 0; i < itemstacksAll.length; i++) {
//		   sb2.append( itemstacksAll[i] + ", " );
//		}
//		String isa = sb2.toString();
//		
//		LogHelper.info("[EntityShop] itemstacksCurrent == " + isc);
//		LogHelper.info("[EntityShop] itemstacksAll == " + isa);
//		LogHelper.info("[EntityShop] currentPage == " + currentPage);
//		LogHelper.info("[EntityShop] getPageAmount() == " + getPageAmount());
//		LogHelper.info("[EntityShop] getShopItemsAmount() == " + getShopItemsAmount());
//		LogHelper.info("[EntityShop] getShopItemsAmountOnCurrentPage() == " + getShopItemsAmountOnCurrentPage());
		

		ItemStack is = this.itemstacksCurrent[item].copy();
		ItemStack price = this.itemstacksCurrent[(item)+1].copy();
		
		int operation = this.operationCurrent[item];
		
		LogHelper.info("[EntityShop] Recieved packet to operate " + is + " (costs == " + price + ")");
		
		if(operation == BUY) {
			Helper.removeItemsFromInventory(player, price.getItem(), price.stackSize);
			Helper.addItemStackstoInventory(player, is);
			this.playLivingSound();
		} else if(operation == SELL) {
			Helper.removeItemsFromInventory(player, is.getItem(), is.stackSize);
			Helper.addItemStackstoInventory(player, price);
			this.playLivingSound();
		}
	}
	
	public void addItemStackToShop(int id, int operation, ItemStack is, ItemStack price) {
		this.itemstacksAll[id*2] = is;
		this.itemstacksAll[(id*2)+1] = price;
		this.operationAll[id*2] = operation;
		this.operationAll[(id*2)+1] = operation;
	}
	
	public int getOperationFromSlot(int slot) {
		return this.operationCurrent[slot*2];
	}
	
	public int getCurrentPage() {
		return this.currentPage;
	}
	
	public int getPageAmount() {
		int pages = this.getShopItemsAmount()/6;
		int remainder = this.getShopItemsAmount()%6;
		
		if(remainder > 0) {
			pages++;
		}
		
		return pages;
	}
	
	public int getShopItemsAmount() {
		return this.itemstacksAll.length/2;
	}
	
	public int getShopItemsAmountOnCurrentPage() {
		int fullpages = this.getShopItemsAmount()/6; //LogHelper.info("[EntityShop] fullpages == " + fullpages);
		int remainder = this.getShopItemsAmount()%6; //LogHelper.info("[EntityShop] remainder == " + remainder);
		
		if(this.getShopItemsAmount() <= 6) {
			return this.getShopItemsAmount();
		}
		
		if(this.currentPage < fullpages) {
			//LogHelper.info("[EntityShop] getShopItemAmountOnCurrentPage - returns 6");
			return 6;
		} else {
			//LogHelper.info("[EntityShop] getShopItemAmountOnCurrentPage - returns " + remainder);
			return remainder;
		}
	}
	
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected void updateAITick() {
        super.updateAITick();
    }

    public boolean interact(EntityPlayer player) {
        if (this.isEntityAlive() && !player.isSneaking()) {
            if (!this.worldObj.isRemote) {
                //player.displayGUIMerchant(this, this.getCustomNameTag());
            	this.currentPage = 0;
                player.openGui(Toe.instance, GuiID.SHOP.ordinal(), this.worldObj, this.getEntityId(), 0, 0);
                this.player = player;
            }
            return true;
        } else {
            return super.interact(player);
        }
    }
    
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.itemstacksCurrent = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemstacksCurrent.length) {
                this.itemstacksCurrent[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        
        //new
        NBTTagList nbttaglist1 = nbt.getTagList("ItemsAll", 10);
        this.itemstacksCurrent = new ItemStack[this.getSizeAll()];

        for (int i = 0; i < nbttaglist1.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist1.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemstacksCurrent.length) {
                this.itemstacksCurrent[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemstacksCurrent.length; ++i) {
            if (this.itemstacksCurrent[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemstacksCurrent[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);
        
        //new
        NBTTagList nbttaglist1 = new NBTTagList();

        for (int i = 0; i < this.itemstacksCurrent.length; ++i) {
            if (this.itemstacksCurrent[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemstacksCurrent[i].writeToNBT(nbttagcompound1);
                nbttaglist1.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("ItemsAll", nbttaglist1);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		return null;
	}
	
	//iinventory
	
	@Override
	public int getSizeInventory() {
		return this.itemstacksCurrent.length;
	}
	
	public int getSizeAll() {
		return this.itemstacksAll.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.itemstacksCurrent[slot];
	}
	
	public void setStackInSlot(int slot, ItemStack is) {
		this.itemstacksCurrent[slot] = is;
	}

	@Override
	public ItemStack decrStackSize(int slot, int num) {
        if (this.itemstacksCurrent[slot] != null) {
            ItemStack itemstack;

            if (this.itemstacksCurrent[slot].stackSize <= num) {
                itemstack = this.itemstacksCurrent[slot];
                this.itemstacksCurrent[slot] = null;
                return itemstack;
            } else {
                itemstack = this.itemstacksCurrent[slot].splitStack(num);

                if (this.itemstacksCurrent[slot].stackSize == 0) {
                    this.itemstacksCurrent[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.itemstacksCurrent[slot] != null) {
            ItemStack itemstack = this.itemstacksCurrent[slot];
            this.itemstacksCurrent[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

	@Override
    public void setInventorySlotContents(int slot, ItemStack is) {
        this.itemstacksCurrent[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

	@Override
	public String getInventoryName() {
		return shopName;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		this.resetSlots();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player == this.player;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		return false;
	}
	
	public void resetSlots() {
//		if(this.getShopItemsAmount() > 0) {
//			this.setInventorySlotContents(0, itemstacksCurrent[0*currentPage].copy());
//		}
//		this.setInventorySlotContents(1, itemstacksCurrent[1*currentPage].copy());
//		this.setInventorySlotContents(2, itemstacksCurrent[2*currentPage].copy());
//		this.setInventorySlotContents(3, itemstacksCurrent[3*currentPage].copy());
//		this.setInventorySlotContents(4, itemstacksCurrent[4*currentPage].copy());
//		this.setInventorySlotContents(5, itemstacksCurrent[5*currentPage].copy());
//		this.setInventorySlotContents(6, itemstacksCurrent[6*currentPage].copy());
//		this.setInventorySlotContents(7, itemstacksCurrent[7*currentPage].copy());
		
//		for(int i=0; i<12; i++) {
//			if(this.getShopItemsAmountOnCurrentPage() > i/2) {
//				this.setInventorySlotContents(i, itemstacksAll[i*currentPage].copy());
//			}
//		}
		
		/////////////////////
		
		for(int i=0; i<12; i++) {
			this.itemstacksCurrent[i] = null;
			this.operationCurrent[i] = -1;
		}
		
		int times = this.getShopItemsAmountOnCurrentPage()*2;
		
		try {
			for(int i=0; i<times-1; i++) {
				this.itemstacksCurrent[i] = this.itemstacksAll[i+(12*currentPage)].copy();
				this.itemstacksCurrent[i+1] = this.itemstacksAll[i+1+(12*currentPage)].copy();
				this.operationCurrent[i] = this.operationAll[i+(12*currentPage)];
				this.operationCurrent[i+1] = this.operationAll[i+1+(12*currentPage)];
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
//		if(this.getShopItemsAmountOnCurrentPage() > 0) {
//			this.itemstacksCurrent[0] = this.itemstacksAll[0+(12*currentPage)].copy();
//			this.itemstacksCurrent[1] = this.itemstacksAll[1+(12*currentPage)].copy();
//		}
//		if(this.getShopItemsAmountOnCurrentPage() > 1) {
//			this.itemstacksCurrent[2] = this.itemstacksAll[2+(12*currentPage)].copy();
//			this.itemstacksCurrent[3] = this.itemstacksAll[3+(12*currentPage)].copy();
//		}
//		if(this.getShopItemsAmountOnCurrentPage() > 2) {
//			this.itemstacksCurrent[4] = this.itemstacksAll[4+(12*currentPage)].copy();
//			this.itemstacksCurrent[5] = this.itemstacksAll[5+(12*currentPage)].copy();
//		}
//		if(this.getShopItemsAmountOnCurrentPage() > 3) {
//			this.itemstacksCurrent[6] = this.itemstacksAll[6+(12*currentPage)].copy();
//			this.itemstacksCurrent[7] = this.itemstacksAll[7+(12*currentPage)].copy();
//		}
//		if(this.getShopItemsAmountOnCurrentPage() > 4) {
//			this.itemstacksCurrent[8] = this.itemstacksAll[8+(12*currentPage)].copy();
//			this.itemstacksCurrent[9] = this.itemstacksAll[9+(12*currentPage)].copy();
//		}
//		if(this.getShopItemsAmountOnCurrentPage() > 5) {
//			this.itemstacksCurrent[10] = this.itemstacksAll[10+(12*currentPage)].copy();
//			this.itemstacksCurrent[11] = this.itemstacksAll[11+(12*currentPage)].copy();
//		}
    }

    public void setCurrentPage(int page) {
        this.currentPage = page;
        this.resetSlots();
        
//        StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < itemstacksCurrent.length; i++) {
//		   sb.append( itemstacksCurrent[i] + ", " );
//		}
//		String isc = sb.toString();
//
//		StringBuilder sb2 = new StringBuilder();
//		for (int i = 0; i < itemstacksAll.length; i++) {
//		   sb2.append( itemstacksAll[i] + ", " );
//		}
//		String isa = sb2.toString();
//		
//		LogHelper.info("[EntityShop] itemstacksCurrent == " + isc);
//		LogHelper.info("[EntityShop] itemstacksAll == " + isa);
//		LogHelper.info("[EntityShop] currentPage == " + currentPage);
//		LogHelper.info("[EntityShop] getPageAmount() == " + getPageAmount());
//		LogHelper.info("[EntityShop] getShopItemsAmount() == " + getShopItemsAmount());
//		LogHelper.info("[EntityShop] getShopItemsAmountOnCurrentPage() == " + getShopItemsAmountOnCurrentPage());
    }
}