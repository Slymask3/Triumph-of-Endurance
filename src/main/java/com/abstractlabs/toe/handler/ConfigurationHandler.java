package com.abstractlabs.toe.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
    public static Configuration configuration;
    
    public static boolean msg;

    public static void init(File configFile) {
        if (configuration == null) {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

	public static String category = "Options";
    
    private static void loadConfiguration() {
        msg = configuration.get(category, "[Option] Messages", true, "Whether to show messages from the mod or not.\n(Default = true)").getBoolean(true);
		
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase("toe")) {
            loadConfiguration();
        }
    }
}