package net.realtent.blazeaddons.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;
import net.realtent.blazeaddons.entity.custom.MinirocketProjectileEntity;

public class ModEntities {
    public static final EntityType<MinirocketProjectileEntity> MINIROCKET_PROJECTILE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(BlazeAddons.MOD_ID, "minirocket_projectile"),
            FabricEntityTypeBuilder.<MinirocketProjectileEntity>create(SpawnGroup.MISC, MinirocketProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());


}
