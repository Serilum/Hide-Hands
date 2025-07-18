package com.natamus.hidehands.forge.events;

import com.natamus.hidehands.events.HandEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.listener.Priority;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeHandEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeHandEvent.class);

		RenderHandEvent.BUS.addListener(ForgeHandEvent::onHandRender);
	}

	@SubscribeEvent(priority = Priority.HIGHEST)
	public static boolean onHandRender(RenderHandEvent e) {
		if (!HandEvent.onHandRender(e.getHand(), e.getPoseStack(), e.getItemStack())) {
			return true;
		}
		return false;
	}
}