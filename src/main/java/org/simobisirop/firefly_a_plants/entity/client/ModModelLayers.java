package org.simobisirop.firefly_a_plants.entity.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;

public class ModModelLayers {
    public  static final ModelLayerLocation FIREFLY_LAYER = new ModelLayerLocation(
            new ResourceLocation(Firefly_a_plants.MODID, "firefly"), "main");
    public static final ModelLayerLocation MAPLE_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Firefly_a_plants.MODID, "boat/maple"), "main");
    public static final ModelLayerLocation MAPLE_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Firefly_a_plants.MODID, "chest_boat/maple"), "main");

    public static final ModelLayerLocation WISTERIA_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Firefly_a_plants.MODID, "boat/wisteria"), "main");
    public static final ModelLayerLocation WISTERIA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            new ResourceLocation(Firefly_a_plants.MODID, "chest_boat/wisteria"), "main");
}
