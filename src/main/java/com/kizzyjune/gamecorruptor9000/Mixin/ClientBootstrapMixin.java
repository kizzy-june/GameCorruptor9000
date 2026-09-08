package com.kizzyjune.gamecorruptor9000.Mixin;

import com.kizzyjune.gamecorruptor9000.BadWorkaround;
import net.minecraft.CrashReport;
import net.minecraft.client.ClientBootstrap;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(ClientBootstrap.class)
public class ClientBootstrapMixin {
    @Shadow
    private static volatile boolean isBootstrapped;

    @Inject(method = "bootstrap", at = @At("HEAD"), cancellable = true)
    private static void cancelClientBootstrap(CallbackInfo ci) {
        try {
            if (BadWorkaround.get()) {
                isBootstrapped = true;
                ci.cancel();
            }
        } catch (IOException e) {
            Minecraft.getInstance().emergencySaveAndCrash(new CrashReport("IO exception",e));
        }
    }
}