package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.Panorama;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Panorama.class)
public class PanoramaRendererMixin {
    @ModifyConstant(
            method = "extractRenderState",
            constant = @Constant(floatValue = 0.1F)
    )
    private float changeSpeed(float constant) {
        return 0.1F + RandomSource.create().nextFloat() * 1.85F;
    }
}

