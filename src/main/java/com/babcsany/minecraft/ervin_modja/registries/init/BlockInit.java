package com.babcsany.minecraft.ervin_modja.registries.init;

import com.babcsany.minecraft.ervin_modja.registries.ModRegistries;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;

public class BlockInit {
    public static final RegistryObject<Block> CHARCOAL_BLOCK = ModRegistries.BLOCKS.register("charcoal_block", () -> new Block(AbstractBlock.Properties.from(Blocks.COAL_BLOCK)));

    public static void register() {
        System.out.println(BlockInit.class);
    }
}
