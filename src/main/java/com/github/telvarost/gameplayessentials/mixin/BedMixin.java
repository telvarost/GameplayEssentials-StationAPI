package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.BedBehaviorEnum;
import com.github.telvarost.gameplayessentials.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.BedBlock;
import net.minecraft.client.resource.language.TranslationStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.SleepAttemptResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BedBlock.class)
public class BedMixin {

    @Inject(method = "onUse", at = @At("HEAD"), cancellable = true)
    public void gameplayEssentials_canUse(World level, int x, int y, int z, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (BedBehaviorEnum.DISABLE_ENTIRELY == Config.config.BED_BEHAVIOR_ENUM) {
            cir.setReturnValue(false);
        }
    }

    /** - All credit for the code in this class goes to Dany and his mod UniTweaks
     *  See: https://github.com/DanyGames2014/UniTweaks
     */
    @WrapOperation(
            method = "onUse",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;trySleep(III)Lnet/minecraft/entity/player/SleepAttemptResult;"
            )
    )
    public SleepAttemptResult gameplayEssentials_canUseSetSpawnPoint(PlayerEntity player, int x, int y, int z, Operation<SleepAttemptResult> original) {
        if (BedBehaviorEnum.SET_SPAWN_POINT_ONLY == Config.config.BED_BEHAVIOR_ENUM) {
            if (!player.world.isRemote) {
                TranslationStorage translationStorage = TranslationStorage.getInstance();
                player.sendMessage(translationStorage.get("tile.gameplayessentials.bed.spawnPointSet"));
                ((PlayerBaseAccessor) player).setRespawnPos(new Vec3i(MathHelper.floor(x), MathHelper.floor(y), MathHelper.floor(z)));
                return SleepAttemptResult.OK;
            }
        }
        return original.call(player, x, y, z);
    }
}
