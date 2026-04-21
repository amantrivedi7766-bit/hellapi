package com.hellapi.boost;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HellApiClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("hellapi");

    @Override
    public void onInitializeClient() {
        LOGGER.info("HellAPI booster init started");

        boolean nativeReady = NativeBridge.load();
        if (nativeReady) {
            LOGGER.info("Native bridge loaded; using hybrid optimization path");
        } else {
            LOGGER.warn("Native bridge unavailable; running Java-safe fallback path");
        }

        OptimizerProfile profile = OptimizerProfile.loadDefault();
        LOGGER.info("Loaded profile: {}", profile.name());
    }
}
