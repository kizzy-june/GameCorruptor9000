package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SplashRenderer.class)
    public class SplashRendererMixin {

    // Mixin for messing up the splash text rendering.

    @ModifyConstant(
            method = "render",
            constant = @Constant(floatValue = 69.0F)
    )
    private float changeHeight(float constant) {
        return RandomSource.create().nextFloat() * 65F;
    }
}