package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.network.chat.TextColor;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextColor.class)
public class TextColorMixin {
    @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
    private static void randomize_textColors(CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(RandomSource.create().nextInt());

        // Makes the rainbow text.

    }
}
