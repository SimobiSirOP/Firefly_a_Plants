package org.simobisirop.firefly_a_plants.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.simobisirop.firefly_a_plants.Firefly_a_plants;

public class ModWoodTypes {
    public static final WoodType MAPLE = WoodType.register(new WoodType(Firefly_a_plants.MODID + ":maple", BlockSetType.OAK));
    public static final WoodType WISTERIA = WoodType.register(new WoodType(Firefly_a_plants.MODID + ":wisteria", BlockSetType.OAK));
}
