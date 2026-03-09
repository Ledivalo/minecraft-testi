package net.mcreator.emeraldmiekka.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class MiekkaItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 800, 9f, 0, 15, TagKey.create(Registries.ITEM, ResourceLocation.parse("emerald_miekka:miekka_repair_items")));

	public MiekkaItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 7f, -3f));
	}
}