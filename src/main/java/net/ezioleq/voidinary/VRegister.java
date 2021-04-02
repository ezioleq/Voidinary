package net.ezioleq.voidinary;

import net.ezioleq.voidinary.energy.IEnergy;
import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;
import net.ezioleq.voidinary.items.misc.EnergyManagementProcessor;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VRegister {
	// Items
	public static final BatteryCell BATTERY_CELL = new BatteryCell();
	public static final Battery BATTERY = new Battery(IEnergy.VOIDFLUX);
	public static final EnergyManagementProcessor ENERGY_MANAGEMENT_PROCESSOR = new EnergyManagementProcessor();

	/**
	 * Register all items, blocks, effects etc.
	 */
	public static void registerAll() {
		registerItem(BATTERY_CELL, new Identifier(Voidinary.MODID, "battery_cell"));
		registerItem(BATTERY, new Identifier(Voidinary.MODID, "battery"));
		registerItem(ENERGY_MANAGEMENT_PROCESSOR, new Identifier(Voidinary.MODID, "energy_management_processor"));
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
