package net.realtent.blazeaddons.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;

public class ModModelLayers {
    public static final EntityModelLayer FIRESPRITE =
            new EntityModelLayer(new Identifier(BlazeAddons.MOD_ID, "firesprite"),"main");
}
