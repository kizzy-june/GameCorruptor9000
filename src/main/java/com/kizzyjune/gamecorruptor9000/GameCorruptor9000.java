package com.kizzyjune.gamecorruptor9000;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(GameCorruptor9000.MODID)
public class GameCorruptor9000 {
    public static final String MODID = "gamecorruptor9000";
    public static final Logger LOGGER = LogUtils.getLogger();

    public GameCorruptor9000(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
    }

    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.warn("GameCorruptor9000 loaded!");
        LOGGER.warn("Your game is now corrupted.");
        LOGGER.warn("I don't know why anyone would want this tho lol");
    }
}
