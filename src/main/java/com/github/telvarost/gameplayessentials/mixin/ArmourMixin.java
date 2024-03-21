package com.github.telvarost.gameplayessentials.mixin;

import com.github.telvarost.gameplayessentials.Config;
import net.minecraft.entity.player.PlayerBase;
import net.minecraft.item.ItemBase;
import net.minecraft.item.ItemInstance;
import net.minecraft.item.armour.Armour;
import net.minecraft.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Armour.class)
public abstract class ArmourMixin extends ItemBase {

    @Shadow
    @Final
    public int armourSlot;

    public ArmourMixin(int i, int j, int k, int l) {
        super(i);
    }

    @Override
    public ItemInstance use(ItemInstance arg, Level arg2, PlayerBase arg3) {
        if (Config.config.RIGHT_CLICK_ARMOR_EQUIP) {
            if (arg3.inventory.armour[Math.abs(this.armourSlot - 3)] == null) {
                arg3.inventory.armour[Math.abs(this.armourSlot - 3)] = arg.copy();
                arg.count = 0;
            } else {
                ItemInstance temp = arg3.inventory.armour[Math.abs(this.armourSlot - 3)];
                arg3.inventory.armour[Math.abs(this.armourSlot - 3)] = arg.copy();
                return temp;
            }
        }

        return arg;
    }
}