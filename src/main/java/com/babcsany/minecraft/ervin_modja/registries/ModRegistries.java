package com.babcsany.minecraft.ervin_modja.registries;

import com.babcsany.minecraft.ervin_modja.ErvinModja;
import com.babcsany.minecraft.ervin_modja.registries.init.BlockInit;
import com.babcsany.minecraft.ervin_modja.registries.init.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRegistries {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);

    private static <B> DeferredRegister<B> create(IForgeRegistry<B> reg) {
        return DeferredRegister.create(reg, ErvinModja.MOD_ID);
    }

    public static void register(IEventBus modEventBus) {
        ErvinModja.LOGGER.info(ModRegistries.class);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        BlockInit.register(ErvinModja.LOGGER);
        ItemInit.register(modEventBus, ErvinModja.LOGGER);
    }
}
