package com.babcsany.minecraft.ervin_modja;

import com.babcsany.minecraft.ervin_modja.registries.ModRegistries;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ErvinModja.MOD_ID)
public class ErvinModja {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ervin_modja";

    public ErvinModja() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the mod objects for mod-loading
        ModRegistries.register(modEventBus);
        // Register the setup method for mod-loading
        modEventBus.addListener(this::setup);
        // Register the enqueueIMC method for mod-loading
        modEventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for mod-loading
        modEventBus.addListener(this::processIMC);
        // Register the doClientStuff method for mod-loading
        modEventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some pre-init code
        LOGGER.info("HELLO FROM PRE-INIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getDescriptionId());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", Minecraft.getInstance().getUser().getName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(MOD_ID, "hello-world", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        try {
            List<Object> messages = event.getIMCStream()
                    .map(m -> {
                        try {
                            return Optional.ofNullable(m.messageSupplier().get());
                        } catch (Exception e) {
                            LOGGER.error("Error processing IMC message", e);
                            return Optional.empty();
                        }
                    })
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            LOGGER.info("Got IMC {}", messages);
        } catch (Exception e) {
            LOGGER.error("Error processing IMC stream", e);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
}
