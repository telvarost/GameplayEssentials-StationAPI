package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.BedBehaviorEnum;
import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.block.Bed;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.util.SleepStatus;
import net.minecraft.util.Vec3i;
import net.minecraft.util.maths.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.level.Level;

@Mixin(Bed.class)
public class BedMixin {

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    public void gameplayEssentials_canUse(Level level, int x, int y, int z, PlayerBase player, CallbackInfoReturnable<Boolean> cir) {
        if (BedBehaviorEnum.DISABLE_ENTIRELY == Config.config.BED_BEHAVIOR_ENUM) {
            cir.setReturnValue(false);
        }
    }

    /** - All credit for the code in this class goes to Dany and his mod UniTweaks
     *  See: https://github.com/DanyGames2014/UniTweaks
     */
    @Redirect(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerBase;trySleep(III)Lnet/minecraft/util/SleepStatus;"))
    public SleepStatus gameplayEssentials_canUseSetSpawnPoint(PlayerBase player, int x, int y, int z) {
        if (BedBehaviorEnum.SET_SPAWN_POINT_ONLY == Config.config.BED_BEHAVIOR_ENUM) {
            if (!player.level.isServerSide) {
                player.sendMessage("Respawn Point Set");
                ((PlayerBaseAccessor) player).setRespawnPos(new Vec3i(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z)));
                return SleepStatus.field_2660;
            }
        }
        return player.trySleep(x, y, z);
    }
}
