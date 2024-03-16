package org.exampl.japan_mod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.exampl.japan_mod.Japan_mod;
import org.exampl.japan_mod.worldgen.ModBiomeModifiers;
import org.exampl.japan_mod.worldgen.ModConfiguredFeatures;
import org.exampl.japan_mod.worldgen.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldgenDataProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap).add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

        public ModWorldgenDataProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    super(output,
        registries,
        BUILDER,
        Set.of(Japan_mod.MODID));
        }
}
