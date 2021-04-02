package net.ezioleq.voidinary;

import net.ezioleq.voidinary.energy.IEnergy;
import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;
import net.ezioleq.voidinary.items.misc.EnergyProcessor;
import net.ezioleq.voidinary.items.misc.LogicProcessor;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VRegister {
	// Items
	public static final BatteryCell BATTERY_CELL = new BatteryCell();
	public static final Battery BATTERY = new Battery(IEnergy.VOIDFLUX);
	public static final EnergyProcessor ENERGY_PROCESSOR = new EnergyProcessor();
	public static final LogicProcessor LOGIC_PROCESSOR = new LogicProcessor();

	/**
	 * Register all items, blocks, effects etc.
	 */
	public static void registerAll() {
		registerItem(BATTERY_CELL, new Identifier(Voidinary.MODID, "battery_cell"));
		registerItem(BATTERY, new Identifier(Voidinary.MODID, "battery"));
		registerItem(ENERGY_PROCESSOR, new Identifier(Voidinary.MODID, "energy_processor"));
		registerItem(LOGIC_PROCESSOR, new Identifier(Voidinary.MODID, "logic_processor"));
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
