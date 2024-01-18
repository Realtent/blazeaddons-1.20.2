package net.realtent.blazeaddons.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.realtent.blazeaddons.item.ModItems;

public class PrimedMinirocketItem extends Item {

    public PrimedMinirocketItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient) {
            return TypedActionResult.success(itemStack);
        }
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        user.getWorld().playSoundFromEntity(null, user, SoundEvents.ENTITY_TNT_PRIMED, user.getSoundCategory(), 0.2f, 5.0f);
        ItemStack itemStack2 = new ItemStack(ModItems.MINIROCKET);
        if (itemStack.isEmpty()) {
            return TypedActionResult.consume(itemStack2);
        }
        if (!user.getInventory().insertStack(itemStack2.copy())) {
            user.dropItem(itemStack2, false);
        }
        return TypedActionResult.consume(itemStack);
    }
}
