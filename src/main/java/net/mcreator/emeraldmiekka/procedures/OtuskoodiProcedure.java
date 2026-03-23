package net.mcreator.emeraldmiekka.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.emeraldmiekka.init.EmeraldMiekkaModEntities;
import net.mcreator.emeraldmiekka.entity.OtusEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OtuskoodiProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof OtusEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) < (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 2d) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EmeraldMiekkaModEntities.OTUS_2.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), EntitySpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}