package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.github.telvarost.gameplayessentials.ModHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Item;
import net.minecraft.entity.Minecart;
import net.minecraft.entity.projectile.Arrow;
import net.minecraft.block.Rail;
import net.minecraft.util.maths.Box;
import net.minecraft.util.maths.MathHelper;

@Mixin(Minecart.class)
public class MinecartMixin {

	private static final double EXTRA_MINECART_XZ_SIZE = 0.4;
	private static final double EXTRA_MINECART_Y_SIZE = 0.0;

	@Inject(method = "getBoundingBox", at = @At("HEAD"), cancellable = true)
	public void gameplayEssentials_onCollision(EntityBase other, CallbackInfoReturnable<Box> ci) {
		if (Config.config.FIX_MINECART_STOPPING_ON_ITEMS) {
			if (other instanceof Item || other instanceof Arrow) {
				ci.setReturnValue(null);
			}
		}
	}
}
