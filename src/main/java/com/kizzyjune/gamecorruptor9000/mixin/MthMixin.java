package com.kizzyjune.gamecorruptor9000.mixin;

import com.kizzyjune.gamecorruptor9000.Config;
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
            ci.setReturnValue(ci.getReturnValue() * 1.5F);
    }

    @Inject(method = "cos", at = @At("TAIL"), cancellable = true)
    private static void corruptCosine(CallbackInfoReturnable<Float> ci) {
            ci.setReturnValue(ci.getReturnValue() * 1.5F);
            // Kosinus Kokusnuss
    }

    // Sine and Cosine changes mainly affect movement, flowing water and lava texture, worldgen and player animation.
    // Can also affect skybox rendering.
    // Causes server crashes and corrupted worldgen when increased too much.
    // Messing with Cosine swapped sky rendering of day and night.
    // Credits to Destroyer [GD] for finding out it also affects elytra a lot!
    // Also affects boats.
    // Affects third-person camera and tree generation.
    // I was thinking about corrupting the sine table like QuickMäth does, but I leave it like this for now.

    @Inject(method = "abs(F)F", at = @At("HEAD"), cancellable = true)
    private static void corruptAbs(float Input, CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(Input);
        // Turns inventory items and some blocks dark.
        // Caused missing models on older versions of Minecraft.
    }

    @Inject(method = "unpackDegrees", at = @At("TAIL"), cancellable = true)
    private static void corruptUnpackDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 20);
        // Affects rotation-related functions.
    }

    @Inject(method = "wrapDegrees", at = @At("HEAD"), cancellable = true)
    private static void corruptWrapDegrees(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(RandomSource.create().nextFloat());
        // Supposed to smoothly make entities rotate, not really smooth anymore now, huh?
    }

    @Inject(method = "atan2", at = @At("TAIL"), cancellable = true)
    private static void corruptAtan2(CallbackInfoReturnable<Double> ci) {
        ci.setReturnValue(0D);
    }
    // Rotation stuff
    // Probably more?

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
        ci.setReturnValue((double) Integer.MAX_VALUE);

        // Causes walking animations to permanently play if set to 1 or higher.
        // All walking animations stop working when set to 0 or a negative number.
        // Causes Villages to generate incorrectly when fixed at a number.
    }

    @Inject(method = "ceil(F)I", at = @At("TAIL"), cancellable = true)
    private static void corruptCeil(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(ci.getReturnValue() / 2);
        // Ceil always rounds up
    }

    @Inject(method = "binarySearch", at = @At("TAIL"), cancellable = true)
    private static void corruptBinSearch(CallbackInfoReturnable<Integer> ci) {
        if (Config.isBinarySearchCorruptionEnabled)
        {
            ci.setReturnValue(ci.getReturnValue() / 2);
        }
    }

    // Binary search is a search algorithm that finds the position of a target value within a sorted collection of data.
    // The physics engine uses this.

    @Inject(method = "lerp(FFF)F", at = @At("TAIL"), cancellable = true)
    private static void corruptFloatLerp(CallbackInfoReturnable<Float> ci) {
        if (Config.isLerpCorruptionEnabled) {
            ci.setReturnValue(ci.getReturnValue() + 0.2F);
        }
    }

    @Inject(method = "clamp(FFF)F", at = @At("TAIL"), cancellable = true)
    private static void corruptFloatClamp(float input, float min, float max, CallbackInfoReturnable<Float> ci) {
        switch (Config.floatClampCorruptionMode) {
            case OFF:
                ci.setReturnValue(ci.getReturnValue());
                break;
            case MODE_1:
                ci.setReturnValue(ci.getReturnValue() / 2);
                break;
            case MODE_2:
                ci.setReturnValue(0F);
                break;
            case MODE_3:
                ci.setReturnValue(1F);
                break;
            case MODE_4:
                ci.setReturnValue(-1F);
                break;
            case MODE_5:
                ci.setReturnValue(RandomSource.create().nextFloat());
                break;
            case MODE_6:
                ci.setReturnValue(input);
                break;
            default:
                throw new IllegalStateException("Invalid mode for float clamp corruption!");
        }
    }


    // lerp a mathematical formula used to find a smooth value at a specific percentage between two numbers or points.
    // Heavily used by worldgen and some other stuff like GUI and skybox colors?


    @Inject(method = "degreesDifferenceAbs", at = @At("TAIL"), cancellable = true)
    private static void corruptDegreesDifferencesAbs(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);
        // Breaks signs and phantoms.
    }

    @Inject(method = "positiveModulo(FF)F", at = @At("TAIL"), cancellable = true)
    private static void corruptFloatModulo(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(RandomSource.create().nextFloat());
        // Breaks compasses and clocks.
    }
}