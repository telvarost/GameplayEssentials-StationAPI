package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.PressurePlateActivationRule;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

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

    @Redirect(
            method = "canPlaceAt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;shouldSuffocate(III)Z"
            )
    )
    public boolean annoyanceFix_canPlaceAt(World arg, int i, int j, int k) {
        if (Config.config.ALLOW_PRESSURE_PLATES_ON_FENCES) {
            return arg.shouldSuffocate(i, j, k) || (Block.FENCE.id == arg.getBlockId(i, j, k));
        }
        else
        {
            return arg.shouldSuffocate(i, j, k);
        }
    }

    @Redirect(
            method = "neighborUpdate",
            at = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/World;shouldSuffocate(III)Z"
            )
    )
    public boolean annoyanceFix_onAdjacentBlockUpdate(World instance, int i, int j, int k) {
        if (Config.config.ALLOW_PRESSURE_PLATES_ON_FENCES) {
            int blockBelowPressurePlateId = instance.getBlockId(i, j, k);

            if (Block.FENCE.id == blockBelowPressurePlateId)
            {
                return instance.shouldSuffocate(i, j, k) || (Block.FENCE.id == instance.getBlockId(i, j, k));
            }
            else
            {
                return instance.shouldSuffocate(i, j, k);
            }
        }
        else
        {
            return instance.shouldSuffocate(i, j, k);
        }
    }
}