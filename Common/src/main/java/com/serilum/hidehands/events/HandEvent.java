package com.serilum.hidehands.events;

import com.natamus.collective.functions.ConfigFunctions;
import com.mojang.blaze3d.vertex.PoseStack;
import com.serilum.hidehands.config.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class HandEvent {
	private static final Minecraft mc = Minecraft.getInstance();
	private static int hideDelay = 0;

	public static boolean onHandRender(InteractionHand hand, PoseStack poseStack, ItemStack itemstack) {
		if (hand.equals(InteractionHand.MAIN_HAND)) {
			if (!itemstack.isEmpty()) {
				if (!ConfigHandler.alwaysHideMainHand) {
					if (!ConfigFunctions.isInIdList(ConfigHandler.hideMainHandWithItems, BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString())) {
						hideDelay = 10;
						return true;
					}
				}
			}
			else if (!ConfigHandler.alwaysHideEmptyMainHand) {
				if (hideDelay > 0) {
					hideDelay -= 1;
				}
				return true;
			}
			else if (mc.player.isSwinging()) {
				hideDelay = 30;
			}

			if (hideDelay > 0) {
				hideDelay -= 1;
				return true;
			}
		}
		else if (hand.equals(InteractionHand.OFF_HAND)) {
			if (!ConfigHandler.alwaysHideOffhand) {
				return !ConfigFunctions.isInIdList(ConfigHandler.hideOffhandWithItems, BuiltInRegistries.ITEM.getKey(itemstack.getItem()).toString());
			}
		}

		return false;
	}
}