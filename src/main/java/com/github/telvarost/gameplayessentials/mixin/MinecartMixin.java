package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.vehicle.MinecartEntity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MinecartEntity.class)
public class MinecartMixin {

	@Inject(method = "method_1379", at = @At("HEAD"), cancellable = true)
	public void gameplayEssentials_onCollision(Entity other, CallbackInfoReturnable<Box> ci) {
		if (Config.config.FIX_MINECART_STOPPING_ON_ITEMS) {
			if (other instanceof ItemEntity || other instanceof ArrowEntity) {
				ci.setReturnValue(null);
			}
		}
	}
}
