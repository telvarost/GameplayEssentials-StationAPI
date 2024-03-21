package com.github.telvarost.gameplayessentials.mixin;

import net.minecraft.entity.player.PlayerBase;
import net.minecraft.util.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerBase.class)
public interface PlayerBaseAccessor {
    @Accessor("spawnPos")
    void setRespawnPos(Vec3i respawnPos);
}
