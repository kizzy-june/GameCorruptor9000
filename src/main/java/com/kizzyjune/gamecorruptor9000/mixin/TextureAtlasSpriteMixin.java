package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextureAtlasSprite.class)
public class TextureAtlasSpriteMixin {
    @Inject(method = "getU", at = @At("TAIL"), cancellable = true)
    private static void corrupt_textures(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() + 0.00375F);
    }
}
