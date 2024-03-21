package com.github.telvarost.gameplayessentials.mixin;

import net.minecraft.entity.EntityBase;
import net.minecraft.entity.Living;
import net.minecraft.entity.player.PlayerBase;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * @author calmilamsy
 * Ported from <a href="https://github.com/calmilamsy/MPEntityPhysicsFix/blob/master/src/main/java/net/glasslauncher/mpentityphysicsfix/mixin/MixinEntityBase.java">here</a>
 */
@Mixin(EntityBase.class)
public class EntityBaseMixin {
    @Redirect(method = "move", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/EntityBase;x:D", opcode = Opcodes.PUTFIELD))
    private void fixX(EntityBase entity, double value) {
        if (!entity.level.isServerSide || entity instanceof PlayerBase || !(entity instanceof Living)) {
            entity.x = value;
        }
    }

    @Redirect(method = "move", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/EntityBase;y:D", opcode = Opcodes.PUTFIELD))
    private void fixY(EntityBase entity, double value) {
        if (!entity.level.isServerSide || entity instanceof PlayerBase || !(entity instanceof Living)) {
            entity.y = value;
        }
    }

    @Redirect(method = "move", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/EntityBase;z:D", opcode = Opcodes.PUTFIELD))
    private void fixZ(EntityBase entity, double value) {
        if (!entity.level.isServerSide || entity instanceof PlayerBase || !(entity instanceof Living)) {
            entity.z = value;
        }
    }
}