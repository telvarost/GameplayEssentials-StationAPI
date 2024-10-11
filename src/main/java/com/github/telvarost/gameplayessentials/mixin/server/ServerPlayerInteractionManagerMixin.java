package com.github.telvarost.gameplayessentials.mixin.server;

import com.github.telvarost.gameplayessentials.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Environment(EnvType.SERVER)
@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {

    @Shadow
    public PlayerEntity player;

    @Redirect(
            method = "interactBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;getBlockId(III)I"
            )
    )
    public int shiftPlacing(World level, int x, int y, int z) {
        if (  Config.config.DISABLE_BLOCK_INTERACTIONS_WITH_KEYBIND
           && this.player.isSneaking()
           && !(this.player.getHand() == null)
        ) {
            return 0;
        }
        return level.getBlockId(x, y, z);
    }
}
