package com.babcsany.minecraft.ervin_modja.item;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class CanBurningBlockItem extends BlockItem {
    private final int burnTime;

    public CanBurningBlockItem(Block p_i48527_1_, Properties p_i48527_2_, int burnTime) {
        super(p_i48527_1_, p_i48527_2_);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
