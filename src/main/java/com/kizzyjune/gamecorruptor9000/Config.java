package com.kizzyjune.gamecorruptor9000;

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
