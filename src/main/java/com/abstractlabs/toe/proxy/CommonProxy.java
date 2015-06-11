package com.abstractlabs.toe.proxy;


public abstract class CommonProxy implements IProxy {
	public void registerInformation() {
		//ConfigHandler.init(new File(Reference.MOD_ID + "_server.cfg"));
	}

//	@Override
//	public void createConfigFile(File file) {
//		ConfigurationHandler.init(file);
//		LogHelper.info("[CommonProxy] Created config file.");
//	}
}
