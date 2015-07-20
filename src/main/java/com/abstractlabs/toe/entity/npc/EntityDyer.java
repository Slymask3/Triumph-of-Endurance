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
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import com.abstractlabs.toe.Toe;
import com.abstractlabs.toe.init.ToeItems;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.GuiID;
import com.abstractlabs.toe.utility.Helper;

public class EntityDyer extends EntityAnimal implements IInventory {
    private ItemStack[] itemstacks = new ItemStack[2];
	//private InventoryDyer inventory;
    
    private EntityPlayer player;
    
    private boolean inUse;
	
	public EntityDyer(World world) {
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
        //this.inventory = new InventoryDyer();
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
        if (this.isEntityAlive() && !player.isSneaking() && !inUse) {
            if (!this.worldObj.isRemote) {
                //player.displayGUIMerchant(this, this.getCustomNameTag());
                player.openGui(Toe.instance, GuiID.DYER.ordinal(), this.worldObj, this.getEntityId(), 0, 0);
                this.player = player;
                this.inUse = true;
            }
            return true;
        } else if(inUse) {
        	Helper.msg(player, "The Dyer is currently busy.", Color.red);
        	return super.interact(player);
        } else {
            return super.interact(player);
        }
    }
    
    public void setInUse(boolean inUse) {
    	this.inUse = inUse;
    }

//    protected void entityInit() {
//        super.entityInit();
//        this.dataWatcher.addObject(16, Integer.valueOf(0));
//    }

//    public void writeEntityToNBT(NBTTagCompound nbt) {
//        super.writeEntityToNBT(nbt);
//    }
//
//    public void readEntityFromNBT(NBTTagCompound nbt) {
//        super.readEntityFromNBT(nbt);
//    }
    
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.itemstacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i) {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.itemstacks.length) {
                this.itemstacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.itemstacks.length; ++i) {
            if (this.itemstacks[i] != null) {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemstacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);
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
	
//	public InventoryDyer getInventory() {
//		return this.inventory;
//	}
	
	//iinventory
	
	@Override
	public int getSizeInventory() {
		return this.itemstacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.itemstacks[slot];
	}
	
	public void setStackInSlot(int slot, ItemStack is) {
		this.itemstacks[slot] = is;
	}

	@Override
	public ItemStack decrStackSize(int slot, int num) {
        if (this.itemstacks[slot] != null) {
            ItemStack itemstack;

            if (this.itemstacks[slot].stackSize <= num) {
                itemstack = this.itemstacks[slot];
                this.itemstacks[slot] = null;
                return itemstack;
            } else {
                itemstack = this.itemstacks[slot].splitStack(num);

                if (this.itemstacks[slot].stackSize == 0) {
                    this.itemstacks[slot] = null;
                }

                return itemstack;
            }
        } else {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
        if (this.itemstacks[slot] != null) {
            ItemStack itemstack = this.itemstacks[slot];
            this.itemstacks[slot] = null;
            return itemstack;
        } else {
            return null;
        }
    }

	@Override
    public void setInventorySlotContents(int slot, ItemStack is) {
        this.itemstacks[slot] = is;

        if (is != null && is.stackSize > this.getInventoryStackLimit()) {
        	is.stackSize = this.getInventoryStackLimit();
        }
    }

	@Override
	public String getInventoryName() {
		return "Dyer";
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
		if(slot == 0) {
			return isItemDyeable(is);
		} else if(slot == 1) {
			return isItemCoin(is);
		}
		return false;
	}
	
	private boolean isItemDyeable(ItemStack is) {
		Item i = is.getItem();
		return i == Items.leather_helmet || i == Items.leather_chestplate || i == Items.leather_leggings || i == Items.leather_boots || i == ToeItems.woodClaw || i == ToeItems.stoneClaw || i == ToeItems.ironClaw || i == ToeItems.goldClaw || i == ToeItems.diamondClaw || i == ToeItems.emeraldClaw || i == ToeItems.rubyClaw || i == ToeItems.sapphireClaw || i == ToeItems.tophat;
	}
	
	private boolean isItemCoin(ItemStack is) {
		Item i = is.getItem();
		return i == ToeItems.coinCopper;
	}
}