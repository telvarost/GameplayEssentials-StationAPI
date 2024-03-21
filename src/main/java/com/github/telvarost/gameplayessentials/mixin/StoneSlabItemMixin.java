package com.github.telvarost.gameplayessentials.mixin;

import net.minecraft.item.ItemInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Mixin(net.minecraft.item.StoneSlab.class)
public class StoneSlabItemMixin {

    @Inject(method = "getTranslationKey", at = @At("HEAD"), cancellable = true)
    public void preventCrash(ItemInstance stack, CallbackInfoReturnable<String> cir){
        if(stack.getDamage() > net.minecraft.block.StoneSlab.field_2323.length){
            cir.setReturnValue(null);
        }
    }
}
