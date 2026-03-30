package com.kizzyjune.gamecorruptor9000.mixin;

import com.mojang.math.Axis;
import org.joml.Quaternionf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Axis.class)
interface AxisInterfaceMixin {
    @Inject(method = "rotationDegrees", at = @At("HEAD"), cancellable = true)
    default void corrupt_rotation(float degrees, CallbackInfoReturnable<Quaternionf> cir) {
        float degrees2 = degrees + 180.0F;
        cir.setReturnValue(((Axis) (Object) this).rotation(degrees2));
    }
}