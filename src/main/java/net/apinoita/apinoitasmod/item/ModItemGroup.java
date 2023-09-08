package net.apinoita.apinoitasmod.item;

import net.apinoita.apinoitasmod.ApinoitasMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup APINOITASMOD = FabricItemGroupBuilder.build(new Identifier(ApinoitasMod.MOD_ID,
            "apinoitasmod"), () -> new ItemStack(Items.AIR));
}
