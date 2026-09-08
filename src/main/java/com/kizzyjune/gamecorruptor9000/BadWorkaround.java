package com.kizzyjune.gamecorruptor9000;

import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BadWorkaround {
    private static final Path skipClientBootstrap = Path.of("skipclientbootstrap");

    // Decided to try, uhh, something new, my config system over Config.java got boring.
    // Okay (everyone!) okay originally I forgot how this mod worked because I haven't worked on it in months so I wrote this when I forgot the fix for the "cannot get config before config is loaded" already existed.
    // Honestly I forgot how like 40% of the mod works.
    // Wait, if the mod config system sets a value as false until it can be loaded, this means this workaround is actually necessary since the skip client bootstrap must be read before any configs can be loaded, it doesn't work if it's only loaded after configs can be read.

    public static void writeTrueOrFalse(boolean bool) {
        try {
            if (!Files.exists(skipClientBootstrap)) {
                Files.createFile(skipClientBootstrap);
            }
            Files.writeString(skipClientBootstrap, String.valueOf(bool));
        } catch (IOException e) {
            Minecraft.getInstance().emergencySaveAndCrash(new CrashReport("IO exception", e));
        }
    }

    public static boolean get() throws IOException {
        if (!Files.exists(skipClientBootstrap)) {
            Files.createFile(skipClientBootstrap);
            return false;
        }
        return Boolean.parseBoolean(Files.readString(skipClientBootstrap));
    }
}