package com.abstractlabs.toe.gui;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import com.abstractlabs.toe.handler.ConfigurationHandler;

import cpw.mods.fml.client.config.GuiConfig;

public class GuiConfigToe extends GuiConfig {  
    static List list = new ConfigElement(ConfigurationHandler.configuration.getCategory("options")).getChildElements();
    
	private static String titleDir = GuiConfigToe.getAbridgedConfigPath(ConfigurationHandler.configuration.toString());
    
	public GuiConfigToe(GuiScreen parent) {
        super(parent, list, "toe", false, false, titleDir);
    }
}