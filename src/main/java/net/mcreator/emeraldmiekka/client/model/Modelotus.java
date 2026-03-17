package net.mcreator.emeraldmiekka.client.model;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelotus extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("emerald_miekka", "modelotus"), "main");
	public final ModelPart keho;
	public final ModelPart paa;
	public final ModelPart etujalka1;
	public final ModelPart etujalka2;
	public final ModelPart takajalka1;
	public final ModelPart takajalka2;

	public Modelotus(ModelPart root) {
		super(root);
		this.keho = root.getChild("keho");
		this.paa = this.keho.getChild("paa");
		this.etujalka1 = this.keho.getChild("etujalka1");
		this.etujalka2 = this.keho.getChild("etujalka2");
		this.takajalka1 = this.keho.getChild("takajalka1");
		this.takajalka2 = this.keho.getChild("takajalka2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition keho = partdefinition.addOrReplaceChild("keho", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -8.0F, -12.0F, 2.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition paa = keho.addOrReplaceChild("paa", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -12.0F));
		PartDefinition etujalka1 = keho.addOrReplaceChild("etujalka1", CubeListBuilder.create().texOffs(18, 25).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -8.0F, -11.0F));
		PartDefinition etujalka2 = keho.addOrReplaceChild("etujalka2", CubeListBuilder.create().texOffs(26, 25).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -8.0F, -11.0F));
		PartDefinition takajalka1 = keho.addOrReplaceChild("takajalka1", CubeListBuilder.create().texOffs(0, 34).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -8.0F, 10.0F));
		PartDefinition takajalka2 = keho.addOrReplaceChild("takajalka2", CubeListBuilder.create().texOffs(8, 34).addBox(0.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -8.0F, 10.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

		this.etujalka1.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.takajalka2.zRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.paa.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.paa.xRot = headPitch / (180F / (float) Math.PI);
		this.etujalka2.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.takajalka1.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}