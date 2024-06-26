package net.realtent.blazeaddons.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.realtent.blazeaddons.entity.animation.ModAnimations;
import net.realtent.blazeaddons.entity.custom.FirespriteEntity;

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class FirespriteModel<T extends FirespriteEntity> extends SinglePartEntityModel<T> {
	private final ModelPart mainbody;
	private final ModelPart maincube;
	private final ModelPart spinners;
	private final ModelPart NS;
	private final ModelPart WE;
	public FirespriteModel(ModelPart root) {
		this.mainbody = root.getChild("mainbody");
		this.spinners = mainbody.getChild("spinners");
		this.NS = spinners.getChild("NS");
		this.WE = spinners.getChild("WE");
		this.maincube = mainbody.getChild("maincube");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mainbody = modelPartData.addChild("mainbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData spinners = mainbody.addChild("spinners", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData NS = spinners.addChild("NS", ModelPartBuilder.create().uv(0, 16).cuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(8, 12).cuboid(-1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData WE = spinners.addChild("WE", ModelPartBuilder.create().uv(14, 14).cuboid(6.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 12).cuboid(-8.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData maincube = mainbody.addChild("maincube", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		mainbody.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return mainbody;
	}

	@Override
	public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netheadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);

		this.animateMovement(ModAnimations.FIRESPRITE_WALK, limbSwing, limbSwingAmount, 1.0f, 1.0f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.FIRESPRITE_IDLE, ageInTicks, 1f);

	}


}