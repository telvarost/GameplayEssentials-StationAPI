package com.github.telvarost.gameplayessentials;

import net.fabricmc.loader.api.FabricLoader;
import net.glasslauncher.mods.gcapi3.impl.GlassYamlFile;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class GameplayEssentialsMixinPlugin implements IMixinConfigPlugin {
    public static GlassYamlFile configObject;

    @Override
    public void onLoad(String mixinPackage) {
        // Add your own logic here
    }

    @Override
    public String getRefMapperConfig() {
        return null; // null = default behaviour
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
        // Add your own logic here
    }

    @Override
    public List<String> getMixins() {
        return null; // null = I don't wish to append any mixin
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // Add your own logic here
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // Add your own logic here
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.equals("com.github.telvarost.gameplayessentials.mixin.client.GameOptionsMixin")) {
            return (false == FabricLoader.getInstance().isModLoaded("stationapi"));
        } else {
            return true;
        }
    }
}
