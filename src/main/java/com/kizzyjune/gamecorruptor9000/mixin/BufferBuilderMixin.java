package com.kizzyjune.gamecorruptor9000.mixin;

import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(BufferBuilder.class)
public class BufferBuilderMixin {
    @ModifyVariable(method = "addVertex(FFF)Lcom/mojang/blaze3d/vertex/VertexConsumer;", at = @At("HEAD"), ordinal = 2, argsOnly = true)
    private static float corruptVertexStuff(float veemo) {
        return veemo / 2;
    }
    // I think this is the vertex buffer X coordinate or resolution, not sure tho.
    @ModifyVariable(method = "addVertex(FFFIFFIIFFF)V", at = @At("HEAD"), ordinal = 2, argsOnly = true)
    private static float offsetRenderingFromGeometry(float veemo2) {

        // Offsets the world rendering 2 blocks from the actual geometry.

        return veemo2 + 2;
    }
    @ModifyVariable(method = "addVertex(FFFIFFIIFFF)V", at = @At("HEAD"), ordinal = 4, argsOnly = true)
    private static float corruptTextures(float veemo3) {
        return veemo3 + RandomSource.create().nextFloat();
    }
    @ModifyVariable(method = "setUv", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    private static float corruptUvMapping1(float veemo4) {
        return veemo4 - 0.008F;
    }
    @ModifyVariable(method = "setUv", at = @At("HEAD"), ordinal = 1, argsOnly = true)
    private static float corruptUvMapping2(float veemo5) {
        return veemo5 * 1.15F;
    }
}