package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.SkyRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(SkyRenderer.class)
public class SkyRendererMixin {
    @ModifyConstant(
            method = "renderSunMoonAndStars",
            constant = @Constant(floatValue = -90.0F)
    )
    private float breakSunMoonStars(float constant) {
        return (float) (-90.0 * Math.random());

        // Causes the sun and moon to go SPEEEEEEEEEEEEEEEEEEEEEEEEEEEEN, also the stars btw.

    }

    @ModifyConstant(
            method = "buildStars",
            constant = @Constant(floatValue = 0.15F)
    )
    private float breakStars(float constant) {
        return (float) (0.5);

        // Makes the stars bigger.

    }
}