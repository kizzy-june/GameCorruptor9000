package com.kizzyjune.gamecorruptor9000.mixin;

import com.mojang.blaze3d.audio.Channel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Channel.class)
public class AudioEngineMixin1 {
    @ModifyVariable(method = "setSelfPosition(Lnet/minecraft/world/phys/Vec3;)V", at = @At("HEAD"), argsOnly = true)
    private Vec3 editPositions(Vec3 originalVec) {
        return new Vec3(originalVec.x + 3.0, originalVec.y + 3.0, originalVec.z + 3.0);

        // Offsets audio from the player.

    }
}