package com.natamus.hidehands.forge.events;

import com.natamus.hidehands.events.HandEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeHandEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onHandRender(RenderHandEvent e) {
		if (!HandEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}