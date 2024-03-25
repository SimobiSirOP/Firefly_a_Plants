package org.exampl.japan_mod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.exampl.japan_mod.Japan_mod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Block> GLYCINIA_LOGS = tag("glycinia_logs");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Japan_mod.MODID, name));

        }

    }
    public static class Items {
        public static final TagKey<Item> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Item> GLYCINIA_LOGS = tag("glycinia_logs");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Japan_mod.MODID, name));
        }
    }
}
