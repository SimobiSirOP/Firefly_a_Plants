package org.simobisirop.firefly_a_plants.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Block> WISTERIA_LOGS = tag("wisteria_logs");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Firefly_a_plants.MODID, name));

        }

    }
    public static class Items {
        public static final TagKey<Item> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Item> WISTERIA_LOGS = tag("wisteria_logs");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Firefly_a_plants.MODID, name));
        }
    }
}
