package com.natamus.hidehands.neoforge.events;

import com.natamus.hidehands.events.HandEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.RenderHandEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(value = Dist.CLIENT)
public class NeoForgeHandEvent {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onHandRender(RenderHandEvent e) {
		if (!HandEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			e.setCanceled(true);
		}
	}
}