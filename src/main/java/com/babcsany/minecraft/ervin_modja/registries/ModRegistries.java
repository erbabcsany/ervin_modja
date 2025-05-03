package com.babcsany.minecraft.ervin_modja.registries;

import com.babcsany.minecraft.ervin_modja.ErvinModja;
import com.babcsany.minecraft.ervin_modja.registries.init.BlockInit;
import com.babcsany.minecraft.ervin_modja.registries.init.ItemInit;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import static com.babcsany.minecraft.ervin_modja.ErvinModja.MOD_ID;

public class ModRegistries {
    // Create a Deferred Register to hold Blocks which will all be registered under the "ervin_modja" namespace
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    // Create a Deferred Register to hold Items which will all be registered under the "ervin_modja" namespace
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "ervin_modja" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = create(Registries.CREATIVE_MODE_TAB);

    ModRegistries() {}

    private static <B> DeferredRegister<B> create(IForgeRegistry<B> reg) {
        return DeferredRegister.create(reg, MOD_ID);
    }

    private static <B> DeferredRegister<B> create(ResourceKey<? extends Registry<B>> reg) {
        return DeferredRegister.create(reg, MOD_ID);
    }

    public static void register(IEventBus modEventBus) {
        BlockInit.register(ErvinModja.LOGGER);
        ItemInit.register(modEventBus, ErvinModja.LOGGER);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        ErvinModja.LOGGER.info(ModRegistries.class);
    }
}
