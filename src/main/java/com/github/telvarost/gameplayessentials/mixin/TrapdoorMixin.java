package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
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

    @Redirect(
            method = "neighborUpdate",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;method_1780(III)Z"
            )
    )
    public boolean gameplayEssentials_onAdjacentBlockUpdate(World instance, int i, int j, int k) {
        if (Config.config.ALLOW_TRAPDOORS_WITHOUT_SUPPORTS) {
            return true;
        } else {
            return instance.method_1780(i, j, k);
        }
    }

    @Inject(method = "canPlaceAt", at = @At("HEAD"), cancellable = true)
    public void gameplayEssentials_canPlaceAt(World arg, int i, int j, int k, int l, CallbackInfoReturnable<Boolean> cir) {
        if (Config.config.ALLOW_TRAPDOORS_WITHOUT_SUPPORTS) {
            cir.setReturnValue(!arg.method_1779(i, j, k).method_905());
        }
    }
}
