package com.abstractlabs.toe.init;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

import com.abstractlabs.toe.potion.PotionToe;

public class ToePotions {
	public static Potion moon;
	public static Potion stun;
	
	public static void init() {
		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
					Field modfield = Field.class.getDeclaredField("modifiers");
					modfield.setAccessible(true);
					modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

					potionTypes = (Potion[])f.get(null);
					final Potion[] newPotionTypes = new Potion[256];
					System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
					f.set(null, newPotionTypes);
				}
			} catch (Exception e) {
				System.err.println("Severe error, please report this to the mod author:");
				System.err.println(e);
			}
		}

		moon = (new PotionToe(32, false, 0x00FF00)).setIconIndex(6, 1).setPotionName("potion.moon");
		stun = (new PotionToe(33, true, 0xFF7F50)).setIconIndex(6, 2).setPotionName("potion.stun").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160890", -10.0D, 0);
	}
}