/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.realtent.blazeaddons.entity.projectile;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.entity.custom.MinirocketProjectileEntity;
import net.realtent.blazeaddons.item.ModItems;

public class BlazeboltEntity
        extends PersistentProjectileEntity {
    LivingEntity entityType;

    public BlazeboltEntity(World world, LivingEntity owner) {
        super(ModEntities.BLAZEBOLT, owner, world);
    }

    public BlazeboltEntity(World world, double x, double y, double z) {
        super(ModEntities.BLAZEBOLT, x, y, z, world);
    }


    public BlazeboltEntity(EntityType<? extends BlazeboltEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 2.0f, World.ExplosionSourceType.NONE);
        super.onEntityHit(entityHitResult);
    }


    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && !this.inGround) {
            this.getWorld().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        this.getWorld().createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(), 3.0f, World.ExplosionSourceType.NONE);
        super.onBlockHit(blockHitResult);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BLAZEBOLT);
    }

    protected boolean isBurning() {
        return true;
    }


}

