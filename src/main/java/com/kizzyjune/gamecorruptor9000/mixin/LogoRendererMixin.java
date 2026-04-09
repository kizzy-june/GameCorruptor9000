package com.kizzyjune.gamecorruptor9000.mixin;

import net.minecraft.client.gui.components.LogoRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @ModifyConstant(
            method = "extractRenderState(Lnet/minecraft/client/gui/GuiGraphicsExtractor;IFI)V",
            constant = @Constant(intValue = 128)
    )
    private int corruptLogo(int constant) {
        return constant * 3;
    }
}

