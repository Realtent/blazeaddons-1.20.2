package net.realtent.blazeaddons.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.realtent.blazeaddons.BlazeAddons;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BLAZE_ROD_BLOCKS =
                createTag("blaze_rod_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(BlazeAddons.MOD_ID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(BlazeAddons.MOD_ID, name));
        }
    }
}
