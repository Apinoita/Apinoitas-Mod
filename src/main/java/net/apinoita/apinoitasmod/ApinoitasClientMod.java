package net.apinoita.apinoitasmod;

import net.apinoita.apinoitasmod.sound.ModSounds;
import net.fabricmc.api.ClientModInitializer;

public class ApinoitasClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModSounds.registerModSounds();
    }
}
