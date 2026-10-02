package com.serilum.hidehands.neoforge.events;

import com.serilum.hidehands.events.HandEvent;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;

public class NeoForgeHandEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onHandRender(RenderHandEvent e) {
		if (!HandEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}