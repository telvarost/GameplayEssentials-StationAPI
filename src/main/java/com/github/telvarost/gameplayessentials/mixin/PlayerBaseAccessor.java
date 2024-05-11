package com.github.telvarost.gameplayessentials.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PlayerEntity.class)
public interface PlayerBaseAccessor {
    @Accessor("spawnPos")
    void setRespawnPos(Vec3i respawnPos);
}
