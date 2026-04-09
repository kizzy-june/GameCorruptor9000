package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(method = "getViewXRot", at = @At("TAIL"), cancellable = true)
    private static void corrupt_XViewRotation(CallbackInfoReturnable<Float> ci) {
        ci.setReturnValue(ci.getReturnValue() * 2);
    }
}
