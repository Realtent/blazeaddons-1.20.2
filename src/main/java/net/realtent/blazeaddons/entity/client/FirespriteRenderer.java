package net.realtent.blazeaddons.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.entity.custom.FirespriteEntity;

public class FirespriteRenderer extends MobEntityRenderer<FirespriteEntity, FirespriteModel<FirespriteEntity>> {


    public FirespriteRenderer(EntityRendererFactory.Context context) {
        super(context, new FirespriteModel<>(context.getPart(ModModelLayers.FIRESPRITE)), 0.5f);
    }

    @Override
    public Identifier getTexture(FirespriteEntity entity) {
        return null;
    }
}
