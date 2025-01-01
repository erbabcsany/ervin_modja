package com.babcsany.minecraft.ervin_modja.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class CanBurningBlockItem extends BlockItem {
    private final int burnTime;

    public CanBurningBlockItem(Block p_i48527_1_, Properties p_i48527_2_, int burnTime) {
        super(p_i48527_1_, p_i48527_2_);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return this.burnTime;
    }
}
