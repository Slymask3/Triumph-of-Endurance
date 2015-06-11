package com.abstractlabs.toe.world.arena;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;

import com.abstractlabs.toe.entity.monster.EntityMummy;
import com.abstractlabs.toe.entity.monster.EntityScorpion;
import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.skill.arenalism.ArenalismHelper;
import com.abstractlabs.toe.utility.Helper;
import com.abstractlabs.toe.utility.LogHelper;

public class ArenaDesert extends Arena {
	public ArenaDesert() {
		super();
		this.intermissionTime = 30;
		this.maxWaves = 10;
	}
	
	public void startClient() {
		super.startClient();
		//player.setPositionAndUpdate(xCoord, yCoord-34, zCoord);
	}
	
	public void startServer() {
		super.startServer();
		player.setPositionAndUpdate(xCoord, yCoord-34, zCoord);
	}
	
	public void spawnWave(int wave) {
		LogHelper.info("spawnWave(" +wave+ ")");
		
		if(wave == 1) {
			spawnWave1();
		} else if(wave == 2) {
			spawnWave2();
		} else if(wave == 3) {
			spawnWave3();
		} else if(wave == 4) {
			spawnWave4();
		} else if(wave == 5) {
			spawnWave5();
		} else if(wave == 6) {
			spawnWave6();
		} else if(wave == 7) {
			spawnWave7();
		} else if(wave == 8) {
			spawnWave8();
		} else if(wave == 9) {
			spawnWave9();
		} else if(wave == 10) {
			spawnWave10();
		} else {
			LogHelper.info("Wave " +wave+ " doesn't exist.");
		}
	}
	
	public void spawnWave1() {
		LogHelper.info("spawnWave1()");
		Helper.msgClean(player, "Wave 1/" +maxWaves+ " has spawned.", Color.lime);
		
		if(!worldObj.isRemote) {
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord+20, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord, yCoord-34, zCoord+20));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord-20, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord, yCoord-34, zCoord-20));
		}
		
		//Enemy.update(player, 4);
		//ArenalismHelper.getProperties(player).updateEnemies(4);
		//this.enemiesLeft = 4;
		updateEnemiesLeft(4);
	}
	
	public void spawnWave2() {
		LogHelper.info("spawnWave2()");
		Helper.msgClean(player, "Wave 2/" +maxWaves+ " has spawned.", Color.lime);

		if(!worldObj.isRemote) {
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord+20, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord, yCoord-34, zCoord+20));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord-20, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityMummy(worldObj), xCoord, yCoord-34, zCoord-20));
			
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityScorpion(worldObj), xCoord+21, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityScorpion(worldObj), xCoord, yCoord-34, zCoord+21));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityScorpion(worldObj), xCoord-21, yCoord-34, zCoord));
			worldObj.spawnEntityInWorld(Helper.createEntity(new EntityScorpion(worldObj), xCoord, yCoord-34, zCoord-21));
		}

		//ArenalismHelper.getProperties(player).updateEnemies(0);
		updateEnemiesLeft(8);
	}
	
	public void spawnWave3() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 3/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave4() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 4/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave5() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 5/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave6() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 6/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave7() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 7/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave8() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 8/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave9() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 9/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}
	
	public void spawnWave10() {
		LogHelper.info("spawnWave3()");
		Helper.msgClean(player, "Wave 10/" +maxWaves+ " has spawned.", Color.lime);
		updateEnemiesLeft(0);
	}

	public void endGame() {
		if(ArenalismHelper.getProperties(player).inArena()) {
			ArenalismHelper.getProperties(player).endArena(100); //ends the arena with the reward of 100xp.
			
			LogHelper.info("endGame() ~ isRemote = " + worldObj.isRemote);
			
			Helper.msgClean(player, "Congratulations! You have completed all the waves of the Desert Arena.", Color.lime);
	
			Helper.clearInventory(player);
			
			worldObj.setBlock(xCoord, yCoord-34, zCoord, Blocks.chest);
			TileEntityChest chest = (TileEntityChest)worldObj.getTileEntity(xCoord, yCoord-34, zCoord);
			Helper.addRewardToChest(this, chest);
	
			//BuildHelper.replaceBlocks(worldObj, xCoord, yCoord, zCoord, 35, ToeBlocks.exteriorDesert, ToeBlocks.breakableDesert);
			//worldObj.setBlock(xCoord, yCoord, zCoord, Blocks.air);
		}
	}
}