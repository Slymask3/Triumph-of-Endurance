package com.abstractlabs.toe.client.gui;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import com.abstractlabs.toe.handler.ConfigHandler;

import cpw.mods.fml.client.config.GuiConfig;

public class GuiConfigToe extends GuiConfig {  
    static List list = new ConfigElement(ConfigHandler.configuration.getCategory("options")).getChildElements();
    
	private static String titleDir = GuiConfigToe.getAbridgedConfigPath(ConfigHandler.configuration.toString());
    
	public GuiConfigToe(GuiScreen parent) {
        super(parent, list, "toe", false, false, titleDir);
    }
}