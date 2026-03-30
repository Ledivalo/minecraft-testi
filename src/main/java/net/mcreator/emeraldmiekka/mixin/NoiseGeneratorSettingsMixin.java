package net.mcreator.emeraldmiekka.mixin;

import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.core.Holder;

import net.mcreator.emeraldmiekka.init.EmeraldMiekkaModBiomes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;

@Mixin(NoiseGeneratorSettings.class)
public class NoiseGeneratorSettingsMixin implements EmeraldMiekkaModBiomes.EmeraldMiekkaModNoiseGeneratorSettings {
	@Unique
	private Holder<DimensionType> emerald_miekka_dimensionTypeReference;

	@WrapMethod(method = "surfaceRule")
	public SurfaceRules.RuleSource surfaceRule(Operation<SurfaceRules.RuleSource> original) {
		SurfaceRules.RuleSource retval = original.call();
		if (this.emerald_miekka_dimensionTypeReference != null) {
			retval = EmeraldMiekkaModBiomes.adaptSurfaceRule(retval, this.emerald_miekka_dimensionTypeReference);
		}
		return retval;
	}

	@Override
	public void setemerald_miekkaDimensionTypeReference(Holder<DimensionType> dimensionType) {
		this.emerald_miekka_dimensionTypeReference = dimensionType;
	}
}