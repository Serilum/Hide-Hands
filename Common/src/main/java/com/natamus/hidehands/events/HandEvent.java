package com.natamus.hidehands.events;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.hidehands.config.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class HandEvent {
	private static final Minecraft mc = Minecraft.getInstance();
	private static int hideDelay = 0;

	public static boolean onHandRender(InteractionHand hand, PoseStack poseStack, ItemStack itemstack) {
		if (hand.equals(InteractionHand.MAIN_HAND)) {
			if (!itemstack.isEmpty()) {
				if (!ConfigHandler.alwaysHideMainHand) {
					if (!isHoldingItem(ConfigHandler.hideMainHandWithItems, itemstack)) {
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
			else if (mc.player.swinging) {
				hideDelay = 30;
			}

			if (hideDelay > 0) {
				hideDelay -= 1;
				return true;
			}
		}
		else if (hand.equals(InteractionHand.OFF_HAND)) {
			if (!ConfigHandler.alwaysHideOffhand) {
				return !isHoldingItem(ConfigHandler.hideOffhandWithItems, itemstack);
			}
		}

		return false;
	}
	
	private static boolean isHoldingItem(String hideitems, ItemStack item) {
		if (hideitems.length() > 1) {
			String itemstackid = Registry.ITEM.getKey(item.getItem()).toString().toLowerCase();
			return hideitems.toLowerCase().contains(itemstackid);
		}
		return false;
	}
}