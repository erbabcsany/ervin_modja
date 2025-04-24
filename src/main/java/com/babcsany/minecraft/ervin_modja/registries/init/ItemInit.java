package com.babcsany.minecraft.ervin_modja.registries.init;

import com.babcsany.minecraft.ervin_modja.item.CanBurningBlockItem;
import com.babcsany.minecraft.ervin_modja.registries.ModRegistries;
import com.google.common.collect.Maps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ItemInit {
    private static final Map<ResourceKey<CreativeModeTab>, RegistryObject<Item>> CREATIVE_MODE_TAB_ITEMS = Maps.newHashMap();

//    public static final RegistryObject<Item> CHARCOAL_BLOCK = ModRegistries.ITEMS.register("charcoal_block", () -> new CanBurningBlockItem(BlockInit.CHARCOAL_BLOCK.orElse(Blocks.field_150402_ci), new Item.Properties().func_200916_a(ItemGroup.field_78030_b), 16000));
    public static final RegistryObject<Item> CHARCOAL_BLOCK = ModRegistries.ITEMS.register("charcoal_block", () -> new CanBurningBlockItem(BlockInit.CHARCOAL_BLOCK.orElse(Blocks.COAL_BLOCK), new Item.Properties(), 16000));

    public static void register(IEventBus modEventBus, Logger logger) {
        CREATIVE_MODE_TAB_ITEMS.put(CreativeModeTabs.BUILDING_BLOCKS, CHARCOAL_BLOCK);
        modEventBus.addListener(ItemInit::addCreative);
        logger.info(ItemInit.class);
    }

    // Add example items to some creative mode tabs
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        for (Map.Entry<ResourceKey<CreativeModeTab>, RegistryObject<Item>> entry : CREATIVE_MODE_TAB_ITEMS.entrySet()) {
            addItemToCreativeTab(event, entry.getKey(), entry.getValue().orElse(null));
        }
    }

    // Add the example item to the creative mode tab
    private static void addItemToCreativeTab(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, Item item) {
        if (event.getTabKey() == tab) {
            event.accept(item);
        }
    }
}
