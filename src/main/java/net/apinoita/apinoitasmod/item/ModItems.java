package net.apinoita.apinoitasmod.item;

import net.apinoita.apinoitasmod.ApinoitasMod;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(ApinoitasMod.MOD_ID, name), item);
    }

    public static void registerModIems() {
        ApinoitasMod.LOGGER.info("Registering items for " + ApinoitasMod.MOD_ID);
    }
}
