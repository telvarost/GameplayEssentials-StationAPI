package com.github.telvarost.gameplayessentials.mixin.server;

import com.github.telvarost.gameplayessentials.Config;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_70;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Environment(EnvType.SERVER)
@Mixin(class_70.class)
public class class_70Mixin {

    @Shadow
    public PlayerEntity field_2309;

    @Redirect(method = "method_1832", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockId(III)I"))
    public int shiftPlacing(World level, int x, int y, int z) {
        if (  Config.config.DISABLE_BLOCK_INTERACTIONS_WITH_KEYBIND
           && this.field_2309.method_1373() // Sneak keybinding
           && !(this.field_2309.getHand() == null)
        ) {
            return 0;
        }
        return level.getBlockId(x, y, z);
    }
}
