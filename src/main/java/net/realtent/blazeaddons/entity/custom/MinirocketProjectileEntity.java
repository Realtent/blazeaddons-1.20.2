package net.realtent.blazeaddons.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.item.ModItems;

public class MinirocketProjectileEntity extends ThrownItemEntity {
    public MinirocketProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public MinirocketProjectileEntity(LivingEntity entityType, World world) {
        super(ModEntities.MINIROCKET_PROJECTILE, entityType, world);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.MINIROCKET;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        entityHitResult.getEntity().damage(this.getDamageSources().thrown(this, this.getOwner()), 4.0f);
    }
}
