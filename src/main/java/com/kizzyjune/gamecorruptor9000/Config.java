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
            .comment("If true, the ceil function will be corrupted (disabled by default, causes logspam). Requires you to use F3 + T after enabling, can only be turned off by the reset button. ")
            .define("corruptCeil", false);


    public static final ModConfigSpec SPEC = Config.BUILDER.build();
}
