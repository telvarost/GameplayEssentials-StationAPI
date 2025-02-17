package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SugarCaneBlock.class)
class SugarCaneMixin extends Block {

    public SugarCaneMixin(int i, int j) {
        super(i, Material.PLANT);
        this.textureId = j;
        float var3 = 0.375F;
        this.setBoundingBox(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
        this.setTickRandomly(true);
    }

    @WrapOperation(
            method = "canPlaceAt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;getBlockId(III)I"
            )
    )
    public int gameplayEssentials_canPlaceAt(World instance, int x, int y, int z, Operation<Integer> original) {
        if (Config.config.ALLOW_SUGAR_CANE_ON_SAND)
        {
            int tileToPlaceAt = original.call(instance, x, y, z);

            /** - Treat sand like dirt so that sugarcane can be place-able */
            if (Block.SAND.id == tileToPlaceAt)
            {
                tileToPlaceAt = Block.DIRT.id;
            }

            return tileToPlaceAt;
        }
        else
        {
            return original.call(instance, x, y, z);
        }
    }
}

