package com.kizzyjune.gamecorruptor9000;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.ConfigValue<Boolean> CORRUPT_CEIL = BUILDER
            .comment("If true, the ceil function will be corrupted (disabled by default, causes logspam).")
            .define("corruptCeil", false);

    public static final ModConfigSpec.ConfigValue<Boolean> CORRUPT_POSITIVE_MODULO = Config.BUILDER
                .comment("If true, the positive modulo function will be corrupted. No longer allows you to change game mode via GUI, you need to open to LAN and use /gamemode")
                .define("corruptPositiveModulo", false);


    public static final ModConfigSpec SPEC = Config.BUILDER.build();
}
