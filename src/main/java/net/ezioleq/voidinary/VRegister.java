package net.ezioleq.voidinary;

import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VRegister {
	// Items
	public static final BatteryCell BATTERY_CELL = new BatteryCell(
			new FabricItemSettings().maxCount(16).group(Voidinary.ITEM_GROUP));
	public static final Battery BATTERY = new Battery(new FabricItemSettings().maxCount(1).group(Voidinary.ITEM_GROUP));

	/**
	 * Register all items, blocks, effects etc. from mod
	 */
	public static void registerAll() {
		registerItem(BATTERY_CELL, new Identifier(Voidinary.MODID, "battery_cell"));
		registerItem(BATTERY, new Identifier(Voidinary.MODID, "battery"));
	}

	/**
	 * Register an item
	 * 
	 * @param item
	 * @param id
	 */
	public static void registerItem(Item item, Identifier id) {
		Registry.register(Registry.ITEM, id, item);
	}
}
