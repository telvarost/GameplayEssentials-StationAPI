package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.BedBehaviorEnum;
import com.github.telvarost.gameplayessentials.Config;
import java.util.List;

import net.minecraft.entity.player.PlayerBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.level.Level;
import net.minecraft.sortme.LevelMonsterSpawner;

@Mixin(LevelMonsterSpawner.class)
public class LevelMonsterSpawnerMixin {

    @Inject(method = "method_1869", at = @At("HEAD"), cancellable = true)
    private static void nightmaresHandler(Level level, List<PlayerBase> playersList, CallbackInfoReturnable<Boolean> cir) {
        if (BedBehaviorEnum.DISABLE_NIGHTMARES == Config.config.BED_BEHAVIOR_ENUM) {
            cir.setReturnValue(false);
        }
    }
}
