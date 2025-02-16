package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ArmorItem.class)
public abstract class ArmorMixin extends Item {

    @Shadow
    @Final
    public int equipmentSlot;

    public ArmorMixin(int i, int j, int k, int l) {
        super(i);
    }

    @Override
    public ItemStack use(ItemStack arg, World arg2, PlayerEntity arg3) {
        if (Config.config.RIGHT_CLICK_ARMOR_EQUIP) {
            if (arg3.inventory.armor[Math.abs(this.equipmentSlot - 3)] == null) {
                arg3.inventory.armor[Math.abs(this.equipmentSlot - 3)] = arg.copy();
                arg.count = 0;
            } else {
                ItemStack temp = arg3.inventory.armor[Math.abs(this.equipmentSlot - 3)];
                arg3.inventory.armor[Math.abs(this.equipmentSlot - 3)] = arg.copy();
                return temp;
            }
        }

        return arg;
    }
}