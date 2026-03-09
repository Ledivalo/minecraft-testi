/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.emeraldmiekka.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.emeraldmiekka.item.MiekkaItem;
import net.mcreator.emeraldmiekka.EmeraldMiekkaMod;

import java.util.function.Function;

public class EmeraldMiekkaModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(EmeraldMiekkaMod.MODID);
	public static final DeferredItem<Item> MIEKKA;
	static {
		MIEKKA = register("miekka", MiekkaItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}