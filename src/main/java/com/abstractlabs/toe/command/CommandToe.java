package com.abstractlabs.toe.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import com.abstractlabs.toe.reference.Color;
import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.skill.swords.SwordsHelper;
import com.abstractlabs.toe.utility.Helper;

public class CommandToe extends CommandBase {
	public String getCommandName() {
        return "toe";
    }

	public boolean canCommandSenderUseCommand(ICommandSender ics) {
        return true;
    }
	
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
	@Override
	public String getCommandUsage(ICommandSender ics) {
		return null;
	}

    //public List getCommandAliases() {
    //    return Arrays.asList(new String[] {"triumphofendurance"});
    //}
    
    public void processCommand(ICommandSender ics, String[] arg) {
    	EntityPlayer player = CommandBase.getCommandSenderAsPlayer(ics);
		
		if (arg.length == 1) {
        	if (arg[0].equalsIgnoreCase("1") || arg[0].equalsIgnoreCase("one")) {
        		list1(player);
        	} else if (arg[0].equalsIgnoreCase("2") || arg[0].equalsIgnoreCase("two")) {
        		list2(player);
        	} else if (arg[0].equalsIgnoreCase("3") || arg[0].equalsIgnoreCase("three")) {
        		list3(player);
        	} else if (arg[0].equalsIgnoreCase("changelog")) {
                changelog(player);
        	} else if (arg[0].equalsIgnoreCase("swords")) {
                swords(player);
        	} else {
            	list1(player);
        	}
        } else if (arg.length == 3) {
        	if(arg[0].equalsIgnoreCase("swords")) {
        		if (arg[1].equalsIgnoreCase("lvl") || arg[1].equalsIgnoreCase("level")) {
            		swordslvl(player, Integer.parseInt(arg[2]));
            	} else if (arg[1].equalsIgnoreCase("givexp") || arg[1].equalsIgnoreCase("xp") || arg[1].equalsIgnoreCase("xpgive")) {
            		swordsgivexp(player, Float.parseFloat(arg[2]));
            	} else {
                	list1(player);
            	}
        	}
        } else {
    		list1(player);
    	}
    }
    
    public void list1(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + " - Command List - Page 1/3")); //2
    	player.addChatMessage(new ChatComponentText("\u00a72/toe changelog \u00a7a- Mod changelog."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe swords \u00a7a- Swords skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe ranged \u00a7a- Ranged skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe magic \u00a7a- Magic skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe mining \u00a7a- Mining skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe woodcutting \u00a7a- Woodcutting skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe fishing \u00a7a- Fishing skill information."));
        player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
    
    public void list2(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + " - Command List - Page 2/3"));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe farming \u00a7a- Farming skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe cooking \u00a7a- Cooking skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe smelting \u00a7a- Smelting skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe brewing \u00a7a- Brewing skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe runemaking \u00a7a- Runemaking skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe prayer \u00a7a- Prayer skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe slayer \u00a7a- Slayer skill information."));
        player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
    
    public void list3(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + " - Command List - Page 3/3"));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe agility \u00a7a- Agility skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe thieving \u00a7a- Thieving skill information."));
    	player.addChatMessage(new ChatComponentText("\u00a72/toe arenalism \u00a7a- Arenalism skill information."));
        player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
	
	public void changelog(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + " - Changelog"));
		player.addChatMessage(new ChatComponentText("\u00a72- Mod released."));
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
	
	public void swords(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_ACRONYM + " v" + Reference.VERSION + " - Swords"));
    	player.addChatMessage(new ChatComponentText("\u00a7bLevel: " + SwordsHelper.getProperties(player).getLevel() + "/99"));
    	player.addChatMessage(new ChatComponentText("\u00a7bXP Left to Next Level: " + SwordsHelper.getProperties(player).getExpLeft()));
    	if(player.worldObj.getWorldInfo().areCommandsAllowed()) {
	    	player.addChatMessage(new ChatComponentText("\u00a7c/toe swords lvl [number] \u00a7c- Set lvl."));
	    	player.addChatMessage(new ChatComponentText("\u00a7c/toe swords xp [number] \u00a7c- Give xp."));
    	}
        player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
	
	public void swordslvl(EntityPlayer player, int amount) {
		if(player.worldObj.getWorldInfo().areCommandsAllowed()) {
			SwordsHelper.getProperties(player).setLevel(amount);
			SwordsHelper.getProperties(player).setExperience(0);
	    	Helper.msgClean(player, "Swords level set to " + SwordsHelper.getProperties(player).getLevel() + ".", Color.green);
		} else {
	    	Helper.msgClean(player, "Cheats are not enabled.", Color.red);
		}
	}
	
	public void swordsgivexp(EntityPlayer player, float amount) {
		if(player.worldObj.getWorldInfo().areCommandsAllowed()) {
			SwordsHelper.getProperties(player).addExperience(amount);
	    	Helper.msgClean(player, amount + " xp given to Swords skill.", Color.green);
		} else {
	    	Helper.msgClean(player, "Cheats are not enabled.", Color.red);
		}
	}
}