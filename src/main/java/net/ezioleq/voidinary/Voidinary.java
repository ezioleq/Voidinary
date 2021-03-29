package net.ezioleq.voidinary;

import net.ezioleq.voidinary.items.BatteryCell;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Voidinary implements ModInitializer {
	public static final BatteryCell BATTERY_CELL = new BatteryCell(
			new FabricItemSettings().group(Voidinary.ITEM_GROUP).maxCount(16));

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier("voidinary", "general"),
			() -> new ItemStack(BATTERY_CELL));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("voidinary", "battery_cell"), BATTERY_CELL);

		System.out.println("Hello Fabric world!");
	}
}
