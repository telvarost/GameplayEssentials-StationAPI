package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Mixin(SlimeEntity.class)
public class SlimeMixin extends LivingEntity {

    public SlimeMixin(World arg) {
        super(arg);
    }

    @Inject(method = "markDead", at = @At("HEAD"))
    public void splitOnDeathFix(CallbackInfo ci) {
        if (!Config.config.FIX_SLIME_DROPS) {
            return;
        }

        if (this.health < 0) {
            this.health = 0;
        }
    }
}