package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.world.level.levelgen.synth.ImprovedNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ImprovedNoise.class)
public class ImprovedNoiseMixin {
    @Inject(method = "noise(DDDDD)D", at = @At("RETURN"), cancellable = true)
    private static void corrupt_improvedNoiseGEN(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(ci.getReturnValue() * 1.3F);

        // Also corrupts worldgen.

    }
}
