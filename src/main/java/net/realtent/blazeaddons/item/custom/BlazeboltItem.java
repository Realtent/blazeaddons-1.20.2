/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */
package net.realtent.blazeaddons.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.realtent.blazeaddons.entity.projectile.BlazeboltEntity;

public class BlazeboltItem
        extends ArrowItem {
    public BlazeboltItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new BlazeboltEntity(world, shooter);
    }
}

