package com.abstractlabs.toe.block;

import java.util.Iterator;
import java.util.List;

import com.abstractlabs.toe.creativetab.ToeTab;
import com.abstractlabs.toe.reference.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockLandmine extends BlockBaseLandmine
{
    private BlockLandmine.Sensitivity field_150069_a;
    private static final String __OBFID = "CL_00000289";

    public BlockLandmine(String p_i45418_1_, Material p_i45418_2_, BlockLandmine.Sensitivity p_i45418_3_)
    {
        super(p_i45418_1_, p_i45418_2_);
        this.setCreativeTab(ToeTab.TOE_TAB);
        setBlockName(Reference.MOD_ID + ":landmine");
        this.field_150069_a = p_i45418_3_;
    }

    protected int func_150066_d(int p_150066_1_)
    {
        return p_150066_1_ > 0 ? 1 : 0;
    }

    protected int func_150060_c(int p_150060_1_)
    {
        return p_150060_1_ == 1 ? 15 : 0;
    }

    protected int func_150065_e(World world, int x, int y, int z)
    {
        List list = null;

        if (this.field_150069_a == BlockLandmine.Sensitivity.everything)
        {
            list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, this.func_150061_a(x, y, z));
        }

        if (this.field_150069_a == BlockLandmine.Sensitivity.mobs)
        {
            list = world.getEntitiesWithinAABB(EntityLivingBase.class, this.func_150061_a(x, y, z));
        }

        if (this.field_150069_a == BlockLandmine.Sensitivity.players)
        {
            list = world.getEntitiesWithinAABB(EntityPlayer.class, this.func_150061_a(x, y, z));
        }

        if (list != null && !list.isEmpty())
        {
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                Entity entity = (Entity)iterator.next();

                if (!entity.doesEntityNotTriggerPressurePlate())
                {
                	world.createExplosion((Entity) null, x, y, z, 2.0F, true);
                }
            }
        }

        return 0;
    }

    public static enum Sensitivity
    {
        everything,
        mobs,
        players;

        private static final String __OBFID = "CL_00000290";
    }
}
