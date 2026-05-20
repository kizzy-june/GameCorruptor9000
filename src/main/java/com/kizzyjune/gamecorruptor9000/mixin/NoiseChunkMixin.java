package com.kizzyjune.gamecorruptor9000.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.level.levelgen.NoiseChunk;

@Mixin(NoiseChunk.class)
public class NoiseChunkMixin {

    @Shadow @Mutable private int firstCellX;
    @Shadow @Mutable private int firstCellZ;

    @Inject(
            method = "<init>",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/level/levelgen/NoiseChunk;interpolators:Ljava/util/List;",
                    shift = At.Shift.BEFORE
            )
    )
    private void onInitFields(CallbackInfo ci) {
        this.firstCellX = 1;
        this.firstCellZ = 1;
    }
}