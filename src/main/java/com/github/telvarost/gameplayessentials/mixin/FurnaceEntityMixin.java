package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import com.github.telvarost.gameplayessentials.ModHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FurnaceBlockEntity.class)
public abstract class FurnaceEntityMixin extends BlockEntity implements Inventory {

	@Shadow
	private ItemStack[] inventory;

	@Shadow public int burnTime;

	@Inject(
			method = "tick",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/block/entity/FurnaceBlockEntity;getFuelTime(Lnet/minecraft/item/ItemStack;)I"
			),
			cancellable = true
	)
	public void gameplayEssentials_tickConsumeLavaBucket(CallbackInfo ci) {
		if(Config.config.FIX_FURNACE_LAVA_BUCKET) {
			if(this.inventory[1] != null && this.inventory[1].itemId == Item.LAVA_BUCKET.id) {
				ModHelper.ModHelperFields.IS_LAVA_BUCKET_CONSUMED++;
			}			
		}
	}

	@Inject(method = "tick", at = @At(value = "RETURN"))
	public void gameplayEssentials_tickConsumeLavaBucketReturnEmptyBucket(CallbackInfo ci) {
		if(0 < ModHelper.ModHelperFields.IS_LAVA_BUCKET_CONSUMED) {
			this.inventory[1] = new ItemStack(Item.BUCKET);
			ModHelper.ModHelperFields.IS_LAVA_BUCKET_CONSUMED--;
		}
	}
}
