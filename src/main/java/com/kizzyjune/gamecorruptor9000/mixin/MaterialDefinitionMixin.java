package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.model.geom.builders.MaterialDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MaterialDefinition.class)
public class MaterialDefinitionMixin {
        @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 0, argsOnly = true)
        private static int modifyX(int x) {
            return x * 2;
        }
        @ModifyVariable(method = "<init>", at = @At("HEAD"), ordinal = 1, argsOnly = true)
        private static int modifyY(int y) {
            return y * 2;
        }

        // Breaks entity textures by multiplying the texture res by 2

    }