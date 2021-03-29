package net.ezioleq.voidinary;

import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Voidinary implements ModInitializer {
	public static final BatteryCell BATTERY_CELL = new BatteryCell(new FabricItemSettings().maxCount(16));
	public static final Battery BATTERY = new Battery(new FabricItemSettings().maxCount(1));

	public static final ItemGroup VOIDINARY_GROUP = FabricItemGroupBuilder
			.create(new Identifier("voidinary", "general")).icon(() -> new ItemStack(BATTERY_CELL))
			.appendItems(stacks -> {
				stacks.add(new ItemStack(BATTERY));
				stacks.add(new ItemStack(BATTERY_CELL));
			}).build();

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("voidinary", "battery_cell"), BATTERY_CELL);
		Registry.register(Registry.ITEM, new Identifier("voidinary", "battery"), BATTERY);

		System.out.println("Voidinary loaded!");
	}
}
