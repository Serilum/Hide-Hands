package com.serilum.hidehands;

import com.mojang.blaze3d.vertex.PoseStack;
import com.natamus.collective.fabric.callbacks.CollectiveRenderEvents;
import com.serilum.hidehands.events.HandEvent;

import net.fabricmc.api.ClientModInitializer;
import com.serilum.hidehands.util.Reference;
import com.natamus.collective.check.ShouldLoadCheck;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
	}
	
	private void registerEvents() {
		CollectiveRenderEvents.RENDER_SPECIFIC_HAND.register((InteractionHand interactionHand, PoseStack poseStack, ItemStack itemStack) -> {
			return HandEvent.onHandRender(interactionHand, poseStack, itemStack);
		});
	}
}
