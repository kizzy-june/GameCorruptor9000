package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MainClassMixin {
    @Inject(method = "createTitle", at = @At("RETURN"), cancellable = true)
    private static void change_windowTitle(CallbackInfoReturnable<String> ci) {
        ci.setReturnValue("Please, never play this.");

        // Makes the funny window title.
    }

}
