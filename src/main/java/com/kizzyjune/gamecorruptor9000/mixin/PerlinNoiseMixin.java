package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PerlinNoise.class)
public class PerlinNoiseMixin {
    @Inject(method = "getValue(DDDDDZ)D", at = @At("RETURN"), cancellable = true)
    private static void corrupt_perlinNoiseGEN2(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(ci.getReturnValue() * 20);

        // Corrupts worldgen.
    }
}
