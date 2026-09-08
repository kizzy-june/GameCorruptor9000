package com.kizzyjune.gamecorruptor9000;

import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ENABLE_RENDERING_CORRUPTIONS;
    public static final ModConfigSpec.BooleanValue ENABLE_LERP_CORRUPTION;
    public static final ModConfigSpec.BooleanValue ENABLE_BINSEARCH_CORRUPTION;
    public static final ModConfigSpec.EnumValue<FLOAT_CLAMP_CORRUPTION_MODE> FLOAT_CLAMP_CORRUPTION_MODE_CONFIG;
    public static final ModConfigSpec.BooleanValue SKIP_CLIENT_BOOTSTRAP;

    public static boolean hasGameLoaded = false;

    // Cached values
    public static boolean isRenderingCorruptionsEnabled = false;
    public static boolean isLerpCorruptionEnabled = false;
    public static boolean isBinarySearchCorruptionEnabled = false;
    public static FLOAT_CLAMP_CORRUPTION_MODE floatClampCorruptionMode = FLOAT_CLAMP_CORRUPTION_MODE.OFF;

    static {
        ENABLE_RENDERING_CORRUPTIONS = BUILDER
                .comment("Enable or disable most of the rendering corruptions.")
                .define("enableRenderingCorruptions", false);

        ENABLE_LERP_CORRUPTION = BUILDER
                .comment("Enable or disable lerp math corruption, enabling it might freeze the game or softlock the game, that's why it's off by default.")
                .define("enableLerpCorruption", false);

        ENABLE_BINSEARCH_CORRUPTION = BUILDER
                .comment("Enable or disable binary search corruption, has various effects mostly the collision engine.")
                .define("enableBinSearchCorruption", false);

        FLOAT_CLAMP_CORRUPTION_MODE_CONFIG = BUILDER
                .comment("Mode 1 = Divide by 2, Mode 2 = Set to 0, Mode 3 = Set to 1, Mode 4 = Set to -1, Mode 5 = Randomize, Mode 6 = Do not clamp. Might softlock game.")
                .defineEnum("floatClampCorruptionMode", FLOAT_CLAMP_CORRUPTION_MODE.OFF);

        SKIP_CLIENT_BOOTSTRAP = BUILDER
                .comment("Skips client bootstrap \n, completely breaks texture and model loading. \n Requires game restart.")
                .define("skipClientBootstrap",false);


        SPEC = BUILDER.build();
    }

    public static void bakeConfig() {
        BadWorkaround.writeTrueOrFalse(SKIP_CLIENT_BOOTSTRAP.getAsBoolean());


        boolean prevIsRenderingCorruptionsEnabled = isRenderingCorruptionsEnabled;


        // Update cached values from the config file
        isRenderingCorruptionsEnabled = ENABLE_RENDERING_CORRUPTIONS.get();
        isLerpCorruptionEnabled = ENABLE_LERP_CORRUPTION.get();
        isBinarySearchCorruptionEnabled = ENABLE_BINSEARCH_CORRUPTION.get();
        floatClampCorruptionMode = FLOAT_CLAMP_CORRUPTION_MODE_CONFIG.get();

        // Only reload resources if a relevant config option has changed AND the game is loaded
        if (hasGameLoaded && (isRenderingCorruptionsEnabled != prevIsRenderingCorruptionsEnabled)) {
            Minecraft.getInstance().reloadResourcePacks();
        }
    }

    public enum FLOAT_CLAMP_CORRUPTION_MODE {
        OFF,
        MODE_1,
        MODE_2,
        MODE_3,
        MODE_4,
        MODE_5,
        MODE_6
    }
}