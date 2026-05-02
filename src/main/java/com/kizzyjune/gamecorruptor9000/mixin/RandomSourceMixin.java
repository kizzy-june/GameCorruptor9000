package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.world.level.levelgen.BitRandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BitRandomSource.class)
interface RandomSourceMixin {
    @Inject(method = "nextLong", at = @At("RETURN"), cancellable = true)
    private static void deRandomizeLongRandomSource(CallbackInfoReturnable<Long> ci) {
        ci.setReturnValue(0L);
    }
}