package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BiomeColors.class)
public class BiomeColorMixin {
    @Inject(method = "getAverageColor", at = @At("HEAD"), cancellable = true)
    private static void randomize_biomeColors(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(RandomSource.create().nextInt());

        // Causes the random colors on grass and foliage.

    }
}
