package net.ezioleq.voidinary.blocks.entities;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import net.ezioleq.voidinary.VRegister;
import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.utils.IDefaultInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

public class HeatGeneratorEntity extends EnergyEntity implements PropertyDelegateHolder, IDefaultInventory, InventoryProvider, SidedInventory {
	final int capacity = Voidinary.config.heatGeneratorCapacity;

	DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
	static final int[] INPUT_SLOTS = {0};
	static final int[] OUTPUT_SLOTS = {1};
	int fuel = 0;
	int maxFuel = 1000;

	public HeatGeneratorEntity() {
		super(VRegister.HEAT_GENERATOR_ENTITY);
	}

	@Override
	public int getMaxEnergy(Direction dir) {
		return capacity;
	}

	@Override
	public DefaultedList<ItemStack> getItems() {
		return inventory;
	}

	@Override
	public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
		return this;
	}

	@Override
	public int[] getAvailableSlots(Direction side) {
		return side == Direction.DOWN ? OUTPUT_SLOTS : INPUT_SLOTS;
	}

	@Override
	public boolean canExtract(int slot, ItemStack stack, Direction dir) {
		return slot == OUTPUT_SLOTS[0];
	}

	@Override
	public boolean canInsert(int slot, ItemStack stack, Direction dir) {
		if (slot == OUTPUT_SLOTS[0])
			return false;
		return true;
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		Inventories.toTag(tag, inventory);
		tag.putInt("fuel", fuel);
		tag.putInt("maxFuel", maxFuel);
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		Inventories.fromTag(tag, inventory);
		fuel = tag.getInt("fuel");
		maxFuel = tag.getInt("maxFuel");
	}

	PropertyDelegate propdel = new PropertyDelegate() {
		@Override
		public int size() {
			return 4;
		};

		@Override
		public void set(int index, int value) {
			switch (index) {
				case 0:
					getEnergy(Direction.UP);
					break;
				case 1:
					getMaxEnergy(Direction.UP);
					break;
				case 2:
					fuel = value;
					break;
				case 3:
					maxFuel = value;
					break;
			}
		};

		@Override
		public int get(int index) {
			switch (index) {
				case 0:
					return getEnergy(Direction.UP);
				case 1:
					return getMaxEnergy(Direction.UP);
				case 2:
					return fuel;
				case 3:
					return maxFuel;
			}
			return 0;
		};
	};

	@Override
	public PropertyDelegate getPropertyDelegate() {
		return propdel;
	}
}
