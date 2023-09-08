package net.apinoita.apinoitasmod.block;

import net.apinoita.apinoitasmod.ApinoitasMod;
import net.apinoita.apinoitasmod.block.custom.C4Block;
import net.apinoita.apinoitasmod.item.ModItemGroup;
import net.apinoita.apinoitasmod.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    public static final Block C4 = registerBlock("c4",
            new C4Block(FabricBlockSettings.of(Material.TNT).
                    strength(5f).nonOpaque()), ModItemGroup.APINOITASMOD);

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(ApinoitasMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(ApinoitasMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(Text.translatable(tooltipKey));
                    }
                });
    }

    private static Block registerBlockWithoutBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.BLOCK, new Identifier(ApinoitasMod.MOD_ID, name), block);
    }
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ApinoitasMod.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(ApinoitasMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        ApinoitasMod.LOGGER.info("Registering ModBlocks for " + ApinoitasMod.MOD_ID);
    }
}
