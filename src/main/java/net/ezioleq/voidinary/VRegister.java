package net.ezioleq.voidinary;

import net.ezioleq.voidinary.blocks.HeatGenerator;
import net.ezioleq.voidinary.blocks.entities.HeatGeneratorEntity;
import net.ezioleq.voidinary.blocks.items.HeatGeneratorItem;
import net.ezioleq.voidinary.energy.IEnergyItem;
import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;
import net.ezioleq.voidinary.items.misc.EnergyProcessor;
import net.ezioleq.voidinary.items.misc.LogicProcessor;
import net.ezioleq.voidinary.items.tools.VFMeter;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VRegister {
	// Items
	public static final BatteryCell BATTERY_CELL = new BatteryCell();
	public static final Battery BATTERY = new Battery(1*IEnergyItem.VOIDFLUX);
	public static final EnergyProcessor ENERGY_PROCESSOR = new EnergyProcessor();
	public static final LogicProcessor LOGIC_PROCESSOR = new LogicProcessor();
	public static final VFMeter VF_METER = new VFMeter();

	// Blocks
	public static final HeatGenerator HEAT_GENERATOR = new HeatGenerator();
	public static final HeatGeneratorItem HEAT_GENERATOR_ITEM = new HeatGeneratorItem();
	public static BlockEntityType<HeatGeneratorEntity> HEAT_GENERATOR_ENTITY;

	/**
	 * Register all items, blocks, effects etc.
	 */
	public static void registerAll() {
		// Register items
		registerItem(BATTERY_CELL, new Identifier(Voidinary.MODID, "battery_cell"));
		registerItem(BATTERY, new Identifier(Voidinary.MODID, "battery"));
		registerItem(ENERGY_PROCESSOR, new Identifier(Voidinary.MODID, "energy_processor"));
		registerItem(LOGIC_PROCESSOR, new Identifier(Voidinary.MODID, "logic_processor"));
		registerItem(VF_METER, new Identifier(Voidinary.MODID, "vf_meter"));

		// Register blocks and it's items
		registerBlock(HEAT_GENERATOR, new Identifier(Voidinary.MODID, "heat_generator"));
		registerItem(HEAT_GENERATOR_ITEM, new Identifier(Voidinary.MODID, "heat_generator"));
		// FIXME: please
		HEAT_GENERATOR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "voidinary:heat_generator", BlockEntityType.Builder.create(HeatGeneratorEntity::new, HEAT_GENERATOR).build(null));
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

	/**
	 * Register a block
	 * 
	 * @param item
	 * @param id
	 */
	public static void registerBlock(Block block, Identifier id) {
		Registry.register(Registry.BLOCK, id, block);
	}
}
