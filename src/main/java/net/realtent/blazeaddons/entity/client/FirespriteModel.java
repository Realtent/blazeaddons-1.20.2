package net.realtent.blazeaddons.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
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
		this.maincube = mainbody.getChild("maincube");
		this.spinners = mainbody.getChild("spinners");
		this.NS = spinners.getChild("NS");
		this.WE = spinners.getChild("WE");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData mainbody = modelPartData.addChild("mainbody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData maincube = mainbody.addChild("maincube", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData spinners = mainbody.addChild("spinners", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData NS = spinners.addChild("NS", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData N_Sinner_r1 = NS.addChild("N_Sinner_r1", ModelPartBuilder.create().uv(0, 6).cuboid(-3.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 2.3562F));

		ModelPartData WE = spinners.addChild("WE", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData W_Einner_r1 = WE.addChild("W_Einner_r1", ModelPartBuilder.create().uv(6, 0).cuboid(-3.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
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
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

	}
}