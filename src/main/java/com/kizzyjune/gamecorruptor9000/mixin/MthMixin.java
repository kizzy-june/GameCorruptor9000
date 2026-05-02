package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
// Don't show this to my math teacher
@Mixin(Mth.class)
public class MthMixin {
    @Inject(method = "sin", at = @At("TAIL"), cancellable = true)
    private static void corruptSine(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 5F);
    }

    @Inject(method = "cos", at = @At("TAIL"), cancellable = true)
    private static void corruptCosine(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 5F);
        // Kosinus Kokusnuss
    }

    // Sine and Cosine mainly affect movement, flowing water and lava texture, worldgen and player animation.
    // Can also affect skybox rendering.
    // Causes server crashes and corrupted worldgen when too fast.
    // Messing with Cosine swapped sky rendering of day and night on older versions of Minecraft.
    // Credits to Destroyer [GD] for finding out it also affects elytra a lot!
    // Also affects boats.

    @Inject(method = "sqrt", at = @At("TAIL"), cancellable = true)
    private static void corruptSquareRoot(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 4.5F);
    }

    // Affects third-person camera and tree generation.

    @Inject(method = "abs", at = @At("HEAD"), cancellable = true)
    private static void corruptAbs(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(0F);

        // Turns inventory items and some blocks dark.
        // Caused missing models on older versions of Minecraft.

    }

    @Inject(method = "unpackDegrees", at = @At("TAIL"), cancellable = true)
    private static void corruptUnpackDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 20);

    }

    @Inject(method = "wrapDegrees", at = @At("HEAD"), cancellable = true)
    private static void corruptWrapDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(RandomSource.create().nextFloat());
    }

    @Inject(method = "atan2", at = @At("TAIL"), cancellable = true)
    private static void corruptAtan2(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);
    }

    @Inject(method = "rotLerp", at = @At("TAIL"), cancellable = true)
    private static void corruptRotLerp(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);
    }

    // Affects rotation-related functions.

    @Inject(method = "triangleWave", at = @At("TAIL"), cancellable = true)
    private static void corruptTriangleWave(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 32);
    }

    // Corrupts Iron Golem and Ravenger animations.

    @Inject(method = "length(DDD)D", at = @At("HEAD"), cancellable = true)
    private static void corruptLength2(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(1D);

        // Causes walking animations to permanently play if set to 1 or higher.
        // All walking animations stop working when set to 0 or a negative number.
        // Very large positive numbers caused monoliths in older versions of Minecraft.
        // Causes Villages to generate incorrectly when fixed at a number.
    }

    @Inject(method = "ceil(F)I", at = @At("TAIL"), cancellable = true)
    private static void corruptCeil(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(ci.getReturnValue() / 2);
    }

    @Inject(method = "degreesDifferenceAbs", at = @At("TAIL"), cancellable = true)
    private static void corruptDegreesDifferencesAbs(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);

        // Breaks signs and phantoms.

    }
}
