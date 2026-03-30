package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AvatarRenderer.class)
public class AvatarRendererMixin {
    @Inject(method = "isPlayerUpsideDown", at = @At("TAIL"), cancellable = true)
    private static void makePlayerUpsideDown_lol(CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(true);

        // Makes the player upside-down, with these corruptions it's not really upside-down tho...

    }
}
