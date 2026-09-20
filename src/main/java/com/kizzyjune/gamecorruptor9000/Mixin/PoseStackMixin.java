package com.kizzyjune.gamecorruptor9000.Mixin;

import com.kizzyjune.gamecorruptor9000.Config;
import com.mojang.blaze3d.vertex.PoseStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PoseStack.class)
public class PoseStackMixin {
    @ModifyVariable(method = "scale", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float stretchModels(float original) {
        if (Config.isRenderingCorruptionsEnabled) {
            return original + 8;
        }
        return original;
    }
}
