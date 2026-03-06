package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.PanoramaRenderer;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PanoramaRenderer.class)
public class PanoramaRendererMixin { ;

    // Mixin for messing up the panorama rendering.

    @ModifyConstant(
            method = "render",
            constant = @Constant(floatValue = 10.0F)
    )
    private float changeAngle(float constant) {
        return 193.5F;
    }
    @ModifyConstant(
            method = "render",
            constant = @Constant(floatValue = 0.1F)
    )
    private float changeSpeed(float constant) {
        return RandomSource.create().nextFloat() * RandomSource.create().nextFloat() * 5;
    }
}
