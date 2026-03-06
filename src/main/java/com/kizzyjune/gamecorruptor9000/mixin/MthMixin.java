package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mth.class)
public class MthMixin {
    @Inject(method = "sin", at = @At("TAIL"), cancellable = true)
    private static void break_sineWave(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 5);
    }

    @Inject(method = "cos", at = @At("TAIL"), cancellable = true)
    private static void break_cosineWave(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 5);
    }

    // Sine and Cosine mainly affect movement, flowing water and lava texture, worldgen and player animation.
    // Can also affect skybox rendering.
    // Causes server crashes and corrupted worldgen when too fast.
    // Faster Cosine swapped sky rendering of day and night on older versions of Minecraft.

    @Inject(method = "sqrt", at = @At("TAIL"), cancellable = true)
    private static void break_squareRoot(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 4.5F);
    }

    // Affects third-person camera and tree generation.

    @Inject(method = "abs", at = @At("HEAD"), cancellable = true)
    private static void breakAbs(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(0F);

        // Turns inventory items and some blocks dark.
        // Caused missing models on older versions of Minecraft.

    }

    @Inject(method = "unpackDegrees", at = @At("TAIL"), cancellable = true)
    private static void break_unpackDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 20);

    }

    @Inject(method = "wrapDegrees", at = @At("HEAD"), cancellable = true)
    private static void break_wrapDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(RandomSource.create().nextFloat());
    }

    @Inject(method = "atan2", at = @At("TAIL"), cancellable = true)
    private static void break_atan2(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);

    }

    @Inject(method = "rotLerp", at = @At("TAIL"), cancellable = true)
    private static void break_rotLerp(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);
    }

    // Affects rotation-related functions.

    @Inject(method = "triangleWave", at = @At("TAIL"), cancellable = true)
    private static void break_triangleWave(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 32);
    }

    // Breaks Iron Golem and Ravenger animations.

    @Inject(method = "length", at = @At("TAIL"), cancellable = true)
    private static void break_length(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 64);
    }

    // Makes round caves appear in the world.

    @Inject(method = "length(DDD)D", at = @At("HEAD"), cancellable = true)
    private static void break_anotherSquareRootCalculation(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(1D);

        // Causes walking animations to permanently play if set to 1 or higher.
        // All walking animations stop working when set to 0 or a negative number.
        // Very large positive numbers caused monoliths in older versions of Minecraft.
        // Causes Villages to generate incorrectly when fixed at a number.
    }
}
