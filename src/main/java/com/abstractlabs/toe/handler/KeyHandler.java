package com.abstractlabs.toe.handler;

import net.minecraft.client.settings.KeyBinding;

import com.abstractlabs.toe.proxy.ClientProxy;
import com.abstractlabs.toe.skill.DescriptionGUI;
import com.abstractlabs.toe.utility.LogHelper;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class KeyHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event) {
	    //System.out.println("Key Input Event");

	    // make local copy of key binding array
	    KeyBinding[] keyBindings = ClientProxy.keyBindings;
	   
	    if (keyBindings[0].isPressed()) {
	        //System.out.println("Key binding ="+keyBindings[0].getKeyDescription());
	        
	        if(DescriptionGUI.isOn) {
	        	DescriptionGUI.isOn = false;
	        	LogHelper.info("turned off");
	        } else if (!DescriptionGUI.isOn) {
	        	DescriptionGUI.isOn = true;
	        	LogHelper.info("turned on");
	        }
	    }
	    
	    if(DescriptionGUI.isOn && keyBindings[1].isPressed()) {
	    	DescriptionGUI.skillSelected--;
	    	
	    	if(DescriptionGUI.skillSelected < 1) {
	    		DescriptionGUI.skillSelected = 16;
	    	}
	    }
	    
	    if(DescriptionGUI.isOn && keyBindings[2].isPressed()) {
	    	DescriptionGUI.skillSelected++;
	    	
	    	if(DescriptionGUI.skillSelected > 16) {
	    		DescriptionGUI.skillSelected = 1;
	    	}
	    }
	}
}
