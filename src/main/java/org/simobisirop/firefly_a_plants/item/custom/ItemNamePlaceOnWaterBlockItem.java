package org.simobisirop.firefly_a_plants.item.custom;

import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;

public class ItemNamePlaceOnWaterBlockItem extends PlaceOnWaterBlockItem {
    public ItemNamePlaceOnWaterBlockItem(Block p_220226_, Properties p_220227_) {
        super(p_220226_, p_220227_);
    }
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}
