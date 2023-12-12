package com.natamus.hidehands.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.hidehands.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry public static boolean alwaysHideMainHand = false;
	@Entry public static boolean alwaysHideEmptyMainHand = true;
	@Entry public static String hideMainHandWithItems = "";
	@Entry public static boolean alwaysHideOffhand = false;
	@Entry public static String hideOffhandWithItems = "minecraft:totem_of_undying,minecraft:torch";

	public static void initConfig() {
		configMetaData.put("alwaysHideMainHand", Arrays.asList(
			"If enabled, always hides the main hand. If disabled, hides the main hand when holding the items defined in hideMainHandWithItems."
		));
		configMetaData.put("alwaysHideEmptyMainHand", Arrays.asList(
			"If enabled, always hides the main hand if it's empty. Will still be visible when swung empty."
		));
		configMetaData.put("hideMainHandWithItems", Arrays.asList(
			"The items which when held will hide the main hand if alwaysHideMainHand is disabled."
		));
		configMetaData.put("alwaysHideOffhand", Arrays.asList(
			"If enabled, always hides the offhand. If disabled, hides the offhand when holding the items defined in hideOffhandWithItems."
		));
		configMetaData.put("hideOffhandWithItems", Arrays.asList(
			"The items which when held will hide the offhand if alwaysHideOffhand is disabled."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}