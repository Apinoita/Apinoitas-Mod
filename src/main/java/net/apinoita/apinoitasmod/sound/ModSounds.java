package net.apinoita.apinoitasmod.sound;

import net.apinoita.apinoitasmod.ApinoitasMod;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static SoundEvent C4_BEEP = registerSoundEvent("c4_beep");

    public static SoundEvent registerSoundEvent(String name){
        Identifier identifier = new Identifier(ApinoitasMod.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, identifier, new SoundEvent(identifier));
    }

    public static void registerModSounds() {
        ApinoitasMod.LOGGER.info("Registering ModSounds for " + ApinoitasMod.MOD_ID);
    }
}
