
package com.neofastftl.ultoolmate;

import com.neofastftl.ultoolmate.blocks.CustomBlocks;
import com.neofastftl.ultoolmate.items.CustomItems;
import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Ultoolmate.MOD_ID)
public class Ultoolmate {
    public static final String MOD_ID = "ultoolmate";
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Ultoolmate(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);
        CustomItems.register(modEventBus);
        CustomBlocks.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(CustomItems.END_STONE_PICKAXE);
            event.accept(CustomItems.END_STONE_AXE);
            event.accept(CustomItems.END_STONE_HOE);
            event.accept(CustomItems.END_STONE_SHOVEL);
            event.accept(CustomItems.END_STONE_SWORD);
            event.accept(CustomItems.END_STONE_SHEARS);
            event.accept(CustomItems.END_STONE_BRUSH);
            event.accept(CustomItems.END_STONE_PAXEL);
            event.accept(CustomItems.END_STONE_SWOROE);

            event.accept(CustomItems.NETHERRACK_PICKAXE);
            event.accept(CustomItems.NETHERRACK_AXE);
            event.accept(CustomItems.NETHERRACK_HOE);
            event.accept(CustomItems.NETHERRACK_SHOVEL);
            event.accept(CustomItems.NETHERRACK_SWORD);
            event.accept(CustomItems.NETHERRACK_SHEARS);
            event.accept(CustomItems.NETHERRACK_BRUSH);
            event.accept(CustomItems.NETHERRACK_PAXEL);
            event.accept(CustomItems.NETHERRACK_SWOROE);

            event.accept(CustomItems.END_STONE_ST);
            event.accept(CustomItems.NETHERRACK_ST);

            event.accept(CustomItems.SWOROE_ST);
            event.accept(CustomItems.PAXEL_ST);
            event.accept(CustomItems.SHEARS_ST);
            event.accept(CustomItems.SHOVEL_ST);
            event.accept(CustomItems.SWORD_ST);
            event.accept(CustomItems.AXE_ST);
            event.accept(CustomItems.HOE_ST);
            event.accept(CustomItems.PICKAXE_ST);
            event.accept(CustomItems.BRUSH_ST);



            event.accept(CustomItems.PLACEHOLDER_PAXEL);
            event.accept(CustomItems.PLACEHOLDER_SWOROE);
            event.accept(CustomItems.PLACEHOLDER_HOE);
            event.accept(CustomItems.PLACEHOLDER_AXE);
            event.accept(CustomItems.PLACEHOLDER_SWORD);
            event.accept(CustomItems.PLACEHOLDER_PICKAXE);
            event.accept(CustomItems.PLACEHOLDER_SHOVEL);
            event.accept(CustomItems.PLACEHOLDER_BRUSH);
            event.accept(CustomItems.PLACEHOLDER_SHEARS);


            event.accept(CustomBlocks.RAW_ELECTRUM_ORE);
            event.accept(CustomBlocks.DEEPSLATE_RAW_ELECTRUM_ORE);
            event.accept(CustomBlocks.RAW_ELECTRUM_BLOCK);
            event.accept(CustomItems.RAW_ELECTRUM);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
