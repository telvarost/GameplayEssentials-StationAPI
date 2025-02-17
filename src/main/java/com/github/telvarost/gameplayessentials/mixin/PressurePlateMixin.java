package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.PressurePlateActivationRule;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PressurePlateBlock.class)
class PressurePlateMixin extends Block {
    @Shadow
    private PressurePlateActivationRule activationRule;

    public PressurePlateMixin(int i, int j, PressurePlateActivationRule arg, Material arg2) {
        super(i, j, arg2);
        this.activationRule = arg;
        this.setTickRandomly(true);
        float var5 = 0.0625F;
        this.setBoundingBox(var5, 0.0F, var5, 1.0F - var5, 0.03125F, 1.0F - var5);
    }

    @WrapOperation(
            method = "canPlaceAt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;shouldSuffocate(III)Z"
            )
    )
    public boolean annoyanceFix_canPlaceAt(World instance, int x, int y, int z, Operation<Boolean> original) {
        if (Config.config.ALLOW_PRESSURE_PLATES_ON_FENCES) {
            return original.call(instance, x, y, z) || (Block.FENCE.id == instance.getBlockId(x, y, z));
        } else {
            return original.call(instance, x, y, z);
        }
    }

    @WrapOperation(
            method = "neighborUpdate",
            at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/World;shouldSuffocate(III)Z"
            )
    )
    public boolean annoyanceFix_onAdjacentBlockUpdate(World instance, int x, int y, int z, Operation<Boolean> original) {
        if (Config.config.ALLOW_PRESSURE_PLATES_ON_FENCES) {
            int blockBelowPressurePlateId = instance.getBlockId(x, y, z);

            if (Block.FENCE.id == blockBelowPressurePlateId) {
                return original.call(instance, x, y, z) || (Block.FENCE.id == instance.getBlockId(x, y, z));
            }
            else
            {
                return original.call(instance, x, y, z);
            }
        }
        else
        {
            return original.call(instance, x, y, z);
        }
    }
}