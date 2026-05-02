package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.CloudRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(CloudRenderer.class)
public class CloudRendererMixin {
    @ModifyVariable(
            method = "prepare",
            at = @At(value = "STORE"),
            ordinal = 0,
            argsOnly = false
    )
    private int modifyCloudWidth(int originalWidth) {
        return 4;
    }

    @ModifyVariable(
            method = "prepare",
            at = @At(value = "STORE"),
            ordinal = 1,
            argsOnly = false
    )
    private int modifyCloudHeight(int originalHeight) {
        return originalHeight;
    }
}