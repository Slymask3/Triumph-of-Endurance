package com.abstractlabs.toe.reference;

import java.io.File;

public class Reference {
	public static final String MOD_ID = "toe";
    public static final String MOD_NAME = "Triumph of Endurance";
    public static final String MOD_ACRONYM = "ToE";
    public static final String VERSION = "1.0.0";
	public static final String CHANNEL = "toe";
	public static final String CLIENT_PROXY_CLASS = "com.abstractlabs.toe.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "com.abstractlabs.toe.proxy.ServerProxy";
    public static final String GUI_FACTORY_CLASS = "com.abstractlabs.toe.client.gui.GuiFactory";
    public static final String CHECK_URL = "https://dl.dropboxusercontent.com/u/23446861/Mods/Toe/check.txt";
    
    public static final String DATA_FOLDERNAME = "toe_statues";
    public static File minecraftDirectory = new File("./");
    
    public static File getDataFolder() {
        return new File(minecraftDirectory, DATA_FOLDERNAME);
    }
}