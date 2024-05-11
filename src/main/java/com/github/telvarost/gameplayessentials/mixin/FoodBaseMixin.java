package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Mixin(FoodItem.class)
public class FoodBaseMixin {

    @Inject(method = "use", at = @At(value = "HEAD"), cancellable = true)
    public void preventEatingWithFullHealth(ItemStack stack, World level, PlayerEntity player, CallbackInfoReturnable<ItemStack> cir) {
        if (Config.config.DISABLE_EATING_AT_MAX_HEALTH && (player.health >= 20)) {
            cir.setReturnValue(stack);
        }
    }
}