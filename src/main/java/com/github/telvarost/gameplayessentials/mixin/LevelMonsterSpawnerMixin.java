package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.BedBehaviorEnum;
import com.github.telvarost.gameplayessentials.Config;
import java.util.List;

import net.minecraft.world.NaturalSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Mixin(NaturalSpawner.class)
public class LevelMonsterSpawnerMixin {

    @Inject(method = "spawnMonstersAndWakePlayers", at = @At("HEAD"), cancellable = true)
    private static void nightmaresHandler(World level, List<PlayerEntity> playersList, CallbackInfoReturnable<Boolean> cir) {
        if (BedBehaviorEnum.DISABLE_NIGHTMARES == Config.config.BED_BEHAVIOR_ENUM) {
            cir.setReturnValue(false);
        }
    }
}
