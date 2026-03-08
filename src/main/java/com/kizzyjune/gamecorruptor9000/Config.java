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
            .comment("If true, the ceil function will be corrupted (disabled by default, sometimes causes logspam when generating new chunks). Can only be turned off by the reset button. If on, you can no longer select the game mode via GUI, you have to open to LAN and use /gamemode")
            .define("corruptCeil", false);


    public static final ModConfigSpec SPEC = Config.BUILDER.build();
}
