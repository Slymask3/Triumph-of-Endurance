package com.abstractlabs.toe.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

import com.abstractlabs.toe.init.ToeMaterials;
import com.abstractlabs.toe.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTopHat extends ItemToeArmor {
	public ItemTopHat() {
		super(ToeMaterials.suit, "tophat", 0);
	}
	
	@SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack is, int par2) {
        if (par2 > 0) {
            return 16777215;
        } else {
            int j = this.getColor(is);

            if (j < 0) {
                j = 16777215;
            }

            return j;
        }
    }
    
    public boolean hasColor(ItemStack is) {
        return !is.hasTagCompound() ? false : (!is.getTagCompound().hasKey("display", 10) ? false : is.getTagCompound().getCompoundTag("display").hasKey("color", 3));
    }

    public int getColor(ItemStack is) {
        NBTTagCompound tag = is.getTagCompound();

        if (tag == null) {
            return 0xFFFFFF;
        } else {
            NBTTagCompound tag1 = tag.getCompoundTag("display");
            return tag1 == null ? 0xFFFFFF : (tag1.hasKey("color", 3) ? tag1.getInteger("color") : 0xFFFFFF);
        }
    }
    
    public void dye(ItemStack is, int color) {
        NBTTagCompound nbttagcompound = is.getTagCompound();

        if (nbttagcompound == null) {
            nbttagcompound = new NBTTagCompound();
            is.setTagCompound(nbttagcompound);
        }

        NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

        if (!nbttagcompound.hasKey("display", 10)) {
            nbttagcompound.setTag("display", nbttagcompound1);
        }

        nbttagcompound1.setInteger("color", color);
    }
    
    public void removeColor(ItemStack is) {
        NBTTagCompound nbttagcompound = is.getTagCompound();

        if (nbttagcompound != null) {
            NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");

            if (nbttagcompound1.hasKey("color")) {
                nbttagcompound1.removeTag("color");
            }
        }
    }
    
    //overlay code
    
    @SideOnly(Side.CLIENT)
    private IIcon overlayIcon;
    
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
        return pass == 1 ? this.overlayIcon : super.getIconFromDamageForRenderPass(meta, pass);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        this.itemIcon = ir.registerIcon(Reference.MOD_ID+":"+"tophat");
        this.overlayIcon = ir.registerIcon(Reference.MOD_ID+":"+"tophat_overlay");
    }
}