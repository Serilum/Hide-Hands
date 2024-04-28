package com.natamus.hidehands;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.collective.fabric.callbacks.CollectiveRenderEvents;
import com.natamus.hidehands.events.HandEvent;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		registerEvents();
	}
	
	private void registerEvents() {
		CollectiveRenderEvents.RENDER_SPECIFIC_HAND.register((InteractionHand interactionHand, PoseStack poseStack, ItemStack itemStack) -> {
			return HandEvent.onHandRender(interactionHand, poseStack, itemStack);
		});
	}
}
