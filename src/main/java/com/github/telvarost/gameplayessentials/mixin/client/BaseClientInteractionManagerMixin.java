package com.github.telvarost.gameplayessentials.mixin.client;

import com.github.telvarost.gameplayessentials.Config;
import com.github.telvarost.gameplayessentials.events.init.KeyBindingListener;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.InteractionManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

/** - All credit for the code in this class goes to Dany and his mod UniTweaks
 *  See: https://github.com/DanyGames2014/UniTweaks
 */
@Environment(EnvType.CLIENT)
@Mixin(InteractionManager.class)
public class BaseClientInteractionManagerMixin {

    @Shadow
    @Final
    protected Minecraft minecraft;

    @WrapOperation(method = "interactBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockId(III)I"))
    public int shiftPlacing(World instance, int x, int y, int z, Operation<Integer> original) {
        if (  Config.config.DISABLE_BLOCK_INTERACTIONS_WITH_KEYBIND
           && (Keyboard.isKeyDown(KeyBindingListener.disableBlockInteractions.code))
           && !(this.minecraft.player.getHand() == null)
        ) {
            return 0;
        }

        return original.call(instance, x, y, z);
    }
}
