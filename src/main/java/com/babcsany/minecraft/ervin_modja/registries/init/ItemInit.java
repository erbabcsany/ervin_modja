package com.babcsany.minecraft.ervin_modja.registries.init;

import com.babcsany.minecraft.ervin_modja.item.CanBurningBlockItem;
import com.babcsany.minecraft.ervin_modja.registries.ModRegistries;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ItemInit {
    public static final RegistryObject<Item> CHARCOAL_BLOCK = ModRegistries.ITEMS.register("charcoal_block", () -> new CanBurningBlockItem(BlockInit.CHARCOAL_BLOCK.orElse(Blocks.COAL_BLOCK), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS), 16000));

    public static void register() {
        System.out.println(ItemInit.class);
    }
}
