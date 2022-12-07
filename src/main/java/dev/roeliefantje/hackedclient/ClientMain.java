package dev.roeliefantje.hackedclient;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMain implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("hackclient");


//	Classes I might need:
//	C2S packets classes
//	ClientPlayNetworkHandler
//	ClientConnectionInvoker
//	ClientConnection
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		MinecraftClient client = MinecraftClient.getInstance();

		LOGGER.info("Hello Fabric world!");
		ClientTickEvents.END_CLIENT_TICK.register(this::tick);

	}

	private void tick(MinecraftClient client){
//		conn = client.player.networkHandler.getConnection()

	}
}
