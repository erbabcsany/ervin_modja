package com.babcsany.minecraft.ervin_modja.registries.init;

import com.babcsany.minecraft.ervin_modja.registries.ModRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.Logger;

public class BlockInit {
//    public static final RegistryObject<Block> CHARCOAL_BLOCK = ModRegistries.BLOCKS.register("charcoal_block", () -> new Block(AbstractBlock.Properties.func_200950_a(Blocks.field_150402_ci)));
    public static final RegistryObject<Block> CHARCOAL_BLOCK = ModRegistries.BLOCKS.register("charcoal_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));

    public static void register(Logger logger) {
        logger.info(BlockInit.class);
    }
}
