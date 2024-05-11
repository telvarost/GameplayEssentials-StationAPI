package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(FishingBobberEntity.class)
public class FishHookMixin {

	@WrapOperation(
			method = "method_956",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/World;method_210(Lnet/minecraft/entity/Entity;)Z"
			)
	)
	private boolean gameplayEssentials_onFishCaught(World instance, Entity entity, Operation<Boolean> original) {
		if (Config.config.FIX_FISHING) {
			FishingBobberEntity hook = (FishingBobberEntity) (Object) this;

			if (entity != null)
			{
				double x = hook.field_1067.x - hook.x;
				double y = hook.field_1067.y - hook.y;
				double z = hook.field_1067.z - hook.z;
				entity.velocityX = x * 0.1D;
				entity.velocityY = y * 0.1D + Math.sqrt(Math.sqrt(x * x + y * y + z * z)) * 0.05D;
				entity.velocityZ = z * 0.1D;
			}
		}
		return original.call(instance, entity);
	}
}
