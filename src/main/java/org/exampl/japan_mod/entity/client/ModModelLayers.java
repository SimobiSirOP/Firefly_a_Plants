package org.exampl.japan_mod.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.exampl.japan_mod.Japan_mod;

public class ModModelLayers {
    public  static final ModelLayerLocation FIREFLY_LAYER = new ModelLayerLocation(
            new ResourceLocation(Japan_mod.MODID, "firefly"), "main");
    public static final ModelLayerLocation MAPLE_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Japan_mod.MODID, "boat/maple"), "main");
    public static final ModelLayerLocation MAPLE_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Japan_mod.MODID, "chest_boat/maple"), "main");

    public static final ModelLayerLocation GLYCINIA_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Japan_mod.MODID, "boat/glycinia"), "main");
    public static final ModelLayerLocation GLYCINIA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Japan_mod.MODID, "chest_boat/glycinia"), "main");
}
