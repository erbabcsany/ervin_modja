package com.babcsany.minecraft.ervin_modja.registries;

import com.babcsany.minecraft.ervin_modja.Ervin_modja;
import com.babcsany.minecraft.ervin_modja.registries.init.BlockInit;
import com.babcsany.minecraft.ervin_modja.registries.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModRegistries {
    public static final DeferredRegister<Block> BLOCKS = create(ForgeRegistries.BLOCKS);
    public static final DeferredRegister<Item> ITEMS = create(ForgeRegistries.ITEMS);

    private static <B extends IForgeRegistryEntry<B>> DeferredRegister<B> create(IForgeRegistry<B> reg) {
        return DeferredRegister.create(reg, Ervin_modja.MOD_ID);
    }

    public static void register(IEventBus modEventBus) {
        System.out.println(ModRegistries.class);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
