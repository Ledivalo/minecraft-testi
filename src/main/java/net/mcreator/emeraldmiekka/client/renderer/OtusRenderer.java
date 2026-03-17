package net.mcreator.emeraldmiekka.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.emeraldmiekka.entity.OtusEntity;
import net.mcreator.emeraldmiekka.client.model.Modelotus;

import com.mojang.blaze3d.vertex.PoseStack;

public class OtusRenderer extends MobRenderer<OtusEntity, LivingEntityRenderState, Modelotus> {
	private OtusEntity entity = null;

	public OtusRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelotus(context.bakeLayer(Modelotus.LAYER_LOCATION)), 2f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(OtusEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("emerald_miekka:textures/entities/otus_texture.png");
	}

	@Override
	protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
		poseStack.scale(2.5f, 2.5f, 2.5f);
	}
}