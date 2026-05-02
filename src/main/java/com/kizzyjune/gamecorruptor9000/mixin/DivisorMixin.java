package com.kizzyjune.gamecorruptor9000.mixin;

import com.mojang.math.Divisor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Divisor.class)
public class DivisorMixin {
    @Inject(method = "nextInt", at = @At("TAIL"), cancellable = true)
    private static void corruptDivisor(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(ci.getReturnValue() + 16);
    }
}