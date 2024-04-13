package org.exampl.japan_mod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.exampl.japan_mod.block.ModBlocks;
import org.exampl.japan_mod.entity.ModEntities;
import org.exampl.japan_mod.entity.client.FireflyRenderer;
import org.exampl.japan_mod.entity.client.ModBoatRenderer;
import org.exampl.japan_mod.item.ModCreativeTabs;
import org.exampl.japan_mod.item.ModItems;
import org.exampl.japan_mod.util.ModWoodTypes;
import org.exampl.japan_mod.worldgen.ModConfiguredFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Japan_mod.MODID)
public class Japan_mod {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "japan_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "japan_mod" namespace


    public Japan_mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);
        modEventBus.addListener(this::commonSetup);



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Eating Rice...");

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.FIREFLY.get(), FireflyRenderer::new);
            EntityRenderers.register(ModEntities.MODBOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MODCHESTBOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
            Sheets.addWoodType(ModWoodTypes.MAPLE);
            Sheets.addWoodType(ModWoodTypes.GLYCINIA);
        }
    }
}
