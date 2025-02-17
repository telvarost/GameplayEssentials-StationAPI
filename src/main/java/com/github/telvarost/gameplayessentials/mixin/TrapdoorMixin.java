package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TrapdoorBlock.class)
public class TrapdoorMixin extends Block {

    public TrapdoorMixin(int i, Material arg) {
        super(i, arg);
    }

    @WrapOperation(
            method = "neighborUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;shouldSuffocate(III)Z"
            )
    )
    public boolean gameplayEssentials_onAdjacentBlockUpdate(World instance, int x, int y, int z, Operation<Boolean> original) {
        if (Config.config.ALLOW_TRAPDOORS_WITHOUT_SUPPORTS) {
            return true;
        } else {
            return original.call(instance, x, y, z);
        }
    }

    @Inject(method = "canPlaceAt", at = @At("HEAD"), cancellable = true)
    public void gameplayEssentials_canPlaceAt(World arg, int i, int j, int k, int l, CallbackInfoReturnable<Boolean> cir) {
        if (Config.config.ALLOW_TRAPDOORS_WITHOUT_SUPPORTS) {
            cir.setReturnValue(!arg.getMaterial(i, j, k).isSolid());
        }
    }
}
