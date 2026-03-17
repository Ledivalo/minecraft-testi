/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.emeraldmiekka.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.emeraldmiekka.client.model.Modelotus;

@EventBusSubscriber(Dist.CLIENT)
public class EmeraldMiekkaModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelotus.LAYER_LOCATION, Modelotus::createBodyLayer);
	}
}