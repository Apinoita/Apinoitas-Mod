package net.apinoita.apinoitasmod;

import net.apinoita.apinoitasmod.block.ModBlocks;
import net.apinoita.apinoitasmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApinoitasMod implements ModInitializer {
	public static final String MOD_ID ="apinoitasmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModIems();
		ModBlocks.registerModBlocks();


	}
}