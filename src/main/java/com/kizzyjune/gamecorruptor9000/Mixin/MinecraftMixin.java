package com.kizzyjune.gamecorruptor9000.Mixin;

import com.kizzyjune.gamecorruptor9000.Config;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "createTitle", at = @At("RETURN"), cancellable = true)
    private static void change_windowTitle(CallbackInfoReturnable<String> ci) {
        ci.setReturnValue("Please, never play this.");

        // Makes the funny window title.
        // Reference to the SMW ROM hack Super Toad Planet
    }

    @Inject(
            method = "onGameLoadFinished(Lnet/minecraft/client/Minecraft$GameLoadCookie;)V",
            at = @At("TAIL")
    )
    private void onGameLoadFinished(@Coerce Object cookie, CallbackInfo ci) {
        Config.hasGameLoaded = true;
    }
}