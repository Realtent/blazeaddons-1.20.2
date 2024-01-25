package net.realtent.blazeaddons.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.realtent.blazeaddons.entity.custom.MinirocketProjectileEntity;

public class MinirocketItem extends Item {

    public MinirocketItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.PLAYERS, 0.5f, 0.8f / (world.getRandom().nextFloat() * 0.2f + 0.8f));
        if (!world.isClient) {
            MinirocketProjectileEntity minirocketProjectile = new MinirocketProjectileEntity(user, world);
            minirocketProjectile.setItem(itemStack);
            minirocketProjectile.setVelocity(user, (user.getPitch()/3)+30, user.getYaw(), 3.0f, 5f, 1.0f);
            world.spawnEntity(minirocketProjectile);
            user.sendMessage(Text.of(String.valueOf(user.getPitch())));
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
