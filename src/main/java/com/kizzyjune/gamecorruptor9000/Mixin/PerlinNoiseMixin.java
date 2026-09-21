package com.kizzyjune.gamecorruptor9000.Mixin;

import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PerlinNoise.class)
public class PerlinNoiseMixin {
   @Inject(method = "wrap",at = @At("RETURN"),cancellable = true)
    private static void removePrecision(double in, CallbackInfoReturnable<Double> cir) {
       double in2 = (int) in;
       cir.setReturnValue(in2 * 4);
   }
}