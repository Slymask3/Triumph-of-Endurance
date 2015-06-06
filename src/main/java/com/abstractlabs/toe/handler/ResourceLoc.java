package com.abstractlabs.toe.handler;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;

import org.apache.commons.io.input.NullInputStream;

import com.abstractlabs.toe.reference.Reference;
import com.abstractlabs.toe.utility.LogHelper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cpw.mods.fml.common.FMLLog;

public class ResourceLoc implements IResourcePack {

//	@Override
//	public InputStream getInputStream(ResourceLocation loc) throws IOException {
////		FileInputStream stream = new FileInputStream(new File("toe_statues"));
////		return stream;
//		
//		LogHelper.info("getInputStream()");
//		
//		BufferedInputStream stream = new BufferedInputStream(new NullInputStream(0));
//        try {
//            File modFolder = new File(Reference.getDataFolder(), loc.getResourceDomain());
//            File targetFile = new File(modFolder, loc.getResourcePath());
//            stream = new BufferedInputStream(new FileInputStream(targetFile));
//
//    		LogHelper.info("getInputStream() - targetFile == " + targetFile);
//        }
//        catch (Exception e) {
//            FMLLog.getLogger().error("Error reading resource " + loc.toString());
//        }
//        return stream;
//	}
//
//	@Override
//	public boolean resourceExists(ResourceLocation loc) {
//		try {
//            File modFolder = new File(Reference.getDataFolder(), loc.getResourceDomain());
//            File targetFile = new File(modFolder, loc.getResourcePath());
//            return targetFile.exists();
//        }
//        catch (Exception e) {
//            FMLLog.getLogger().error("Error reading resource " + loc.toString());
//        }
//        return false;
//	}
//
//	@Override
//	public Set getResourceDomains() {
//		if(!Reference.getDataFolder().exists()) {
//            //noinspection ResultOfMethodCallIgnored
//            Reference.getDataFolder().mkdirs();
//        }
//
//        Set<String> modNames = new HashSet<String>();
//
//        try {
//            File configFolder = Reference.getDataFolder();
//            //noinspection ConstantConditions
//            for(File file : configFolder.listFiles()) {
//                if(file.isDirectory()) {
//                    modNames.add(file.getName());
//                }
//            }
//        }
//        catch (Exception e) {
//            FMLLog.getLogger().error("Additional Resources: Error listing config folder files");
//        }
//
//        return modNames;
//	}
//
//	@Override
//	public IMetadataSection getPackMetadata(IMetadataSerializer par1, String par2) throws IOException {
//		String fakePackMeta = "" +
//                "{\n" +
//                "  'pack': { \n" +
//                "    'description': 'ToE Statues',\n" +
//                "    'pack_format': 1\n" +
//                "  }\n" +
//                "}";
//        fakePackMeta = fakePackMeta.replaceAll("'", "\"");
//        JsonObject fakePackMetaJson = new JsonParser().parse(fakePackMeta).getAsJsonObject();
//
//        return par1.parseMetadataSection(par2, fakePackMetaJson);
//	}
//
//	@Override
//	public BufferedImage getPackImage() throws IOException {
//		return null;
//	}
//
//	@Override
//	public String getPackName() {
//		return "ToE Statues";
//	}
	
	String path = "config/toe_statues";

    @Override
    public InputStream getInputStream(ResourceLocation rl) throws IOException {
        return !this.resourceExists(rl) ? null : new FileInputStream(new File(path + "/" + rl.getResourceDomain(), rl.getResourcePath()));
    }

    @Override
    public boolean resourceExists(ResourceLocation rl) {
        File fileRequested = new File(path +  "/" + rl.getResourceDomain(), rl.getResourcePath());
        return fileRequested.exists();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set getResourceDomains() {
        File folder = new File(path);
        if(!folder.exists()) {
            folder.mkdir();
        }

        String[] content = folder.list();
        HashSet folders = new HashSet();


        for(String s : content) {
            File f = new File(folder, s);
            if(f.exists() && f.isDirectory()) {
                folders.add(f.getName());
            }
        }

        return folders;
    }


    public IMetadataSection getPackMetadata(IMetadataSerializer p_135058_1_, String p_135058_2_) throws IOException {
        return null;
    }

    public BufferedImage getPackImage() throws IOException {
        return null;
    }

    public String getPackName() {
        return "toe_statues";
    }

}
