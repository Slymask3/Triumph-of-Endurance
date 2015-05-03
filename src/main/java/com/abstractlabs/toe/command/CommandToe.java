package com.abstractlabs.toe.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

import com.abstractlabs.toe.reference.Reference;

public class CommandToe extends CommandBase {
	public String getCommandName() {
        return "toe";
    }

	public boolean canCommandSenderUseCommand(ICommandSender par1ICommandSender) {
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
        	} else if (arg[0].equalsIgnoreCase("changelog")) {
                changelog(player);
        	} else {
            	list1(player);
        	}
        } else {
    		list1(player);
    	}
    }
    
    public void list1(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_NAME + " v" + Reference.VERSION + " - Command List - Page 1/1")); //2
    	player.addChatMessage(new ChatComponentText("\u00a72/toe changelog \u00a7a- Mod changelog."));
        player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
	
	public void changelog(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
    	player.addChatMessage(new ChatComponentText("\u00a73\u00a7l" + Reference.MOD_NAME + " v" + Reference.VERSION + " - Changelog"));
		player.addChatMessage(new ChatComponentText("\u00a72- Mod released."));
		player.addChatMessage(new ChatComponentText("\u00a78\u00a7l============================================="));
	}
}