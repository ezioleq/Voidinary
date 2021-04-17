package net.ezioleq.voidinary;

import java.util.function.Supplier;

import net.ezioleq.voidinary.blocks.HeatGenerator;
import net.ezioleq.voidinary.blocks.entities.HeatGeneratorEntity;
import net.ezioleq.voidinary.blocks.items.HeatGeneratorItem;
import net.ezioleq.voidinary.gui.HeatGeneratorGui;
import net.ezioleq.voidinary.items.Battery;
import net.ezioleq.voidinary.items.BatteryCell;
import net.ezioleq.voidinary.items.misc.EnergyProcessor;
import net.ezioleq.voidinary.items.misc.LogicProcessor;
import net.ezioleq.voidinary.items.tools.VFMeter;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VRegister {
	// Items
	public static final BatteryCell BATTERY_CELL = new BatteryCell();
	public static final Battery BATTERY = new Battery();
	public static final EnergyProcessor ENERGY_PROCESSOR = new EnergyProcessor();
	public static final LogicProcessor LOGIC_PROCESSOR = new LogicProcessor();
	public static final VFMeter VF_METER = new VFMeter();

	// Blocks
	public static final HeatGenerator HEAT_GENERATOR = new HeatGenerator();
	public static final HeatGeneratorItem HEAT_GENERATOR_ITEM = new HeatGeneratorItem();
	public static final BlockEntityType<HeatGeneratorEntity> HEAT_GENERATOR_ENTITY = registerBlockEntity(HEAT_GENERATOR,
			new Identifier(Voidinary.MODID, "heat_generator"), HeatGeneratorEntity::new);

	// Guis
	public static ScreenHandlerType<HeatGeneratorGui> HEAT_GENERATOR_GUI;

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

		// Register Guis
		HEAT_GENERATOR_GUI = ScreenHandlerRegistry.registerExtended(new Identifier(Voidinary.MODID, "heat_generator"),
				(syncId, player, buffer) -> new HeatGeneratorGui(syncId, player,
						ScreenHandlerContext.create(player.player.world, buffer.readBlockPos())));
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

	/**
	 * Register block entity
	 * 
	 * @param <T>         Entity class
	 * @param block
	 * @param id
	 * @param blockEntity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(Block block, Identifier id,
			Supplier<BlockEntity> blockEntity) {
		return (BlockEntityType<T>) Registry.register(Registry.BLOCK_ENTITY_TYPE, id,
				BlockEntityType.Builder.create(blockEntity, block).build(null));
	}
}
