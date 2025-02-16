package com.github.telvarost.gameplayessentials.mixin.client;

import com.github.telvarost.gameplayessentials.events.init.KeyBindingListener;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Arrays;

@Mixin(GameOptions.class)
public class GameOptionsMixin {
    @Shadow
    public KeyBinding[] allKeys;

    @Inject(method = {"<init>()V", "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V"}, at = @At("RETURN"))
    public void onInit(CallbackInfo ci) {
        ArrayList<KeyBinding> newKeys = new ArrayList<>(Arrays.asList(allKeys));

        newKeys.add(KeyBindingListener.disableBlockInteractions);

        allKeys = newKeys.toArray(new KeyBinding[0]);
    }
}
