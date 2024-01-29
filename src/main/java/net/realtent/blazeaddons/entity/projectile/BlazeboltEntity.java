/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.realtent.blazeaddons.entity.projectile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import net.realtent.blazeaddons.entity.ModEntities;
import net.realtent.blazeaddons.entity.custom.MinirocketProjectileEntity;
import net.realtent.blazeaddons.item.ModItems;

public class BlazeboltEntity
        extends PersistentProjectileEntity {
    LivingEntity entityType;

    public BlazeboltEntity(World world, LivingEntity owner) {
        super(EntityType.SPECTRAL_ARROW, owner, world);
    }

    public BlazeboltEntity(World world, double x, double y, double z) {
        super(EntityType.SPECTRAL_ARROW, x, y, z, world);
    }

    public BlazeboltEntity(EntityType<Entity> entityType, World world) {
        super((EntityType<? extends PersistentProjectileEntity>) entityType, world);
    }


    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && !this.inGround) {
            this.getWorld().addParticle(ParticleTypes.FLAME, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.BLAZEBOLT);
    }


}

