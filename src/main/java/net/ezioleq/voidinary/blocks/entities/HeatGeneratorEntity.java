package net.ezioleq.voidinary.blocks.entities;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import net.ezioleq.voidinary.VRegister;
import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.energy.IEnergyItem;
import net.ezioleq.voidinary.utils.IDefaultInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.InventoryProvider;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldAccess;

// FIXME: please fix energy
public class HeatGeneratorEntity extends EnergyEntity implements PropertyDelegateHolder, IDefaultInventory, InventoryProvider, SidedInventory, Tickable {
	final int capacity = Voidinary.config.heatGeneratorCapacity;
	int maxFuel = Voidinary.config.heatGeneratorFuelCapacity;

	DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
	static final int[] INPUT_SLOTS = {0};
	static final int[] OUTPUT_SLOTS = {1};
	int fuel = 0;

	public HeatGeneratorEntity() {
		super(VRegister.HEAT_GENERATOR_ENTITY);
	}

	@Override
	public void tick() {
		if (world.isClient)
			return;

		if (world.getTime()%5 == 0) {
			if (inventory.get(OUTPUT_SLOTS[0]).getItem() instanceof IEnergyItem) {
				IEnergyItem item = (IEnergyItem)inventory.get(OUTPUT_SLOTS[0]).getItem();
				if (item.getEnergy(inventory.get(OUTPUT_SLOTS[0])) == item.getMaxEnergy(inventory.get(OUTPUT_SLOTS[0])))
					return;
				item.addEnergy(inventory.get(OUTPUT_SLOTS[0]),
					subtractEnergy(Direction.UP, Voidinary.config.heatGeneratorChargeAmount));
			}
		}
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
		if (slot == OUTPUT_SLOTS[0] && stack.getItem() instanceof IEnergyItem) {
			IEnergyItem energyItem = ((IEnergyItem)stack.getItem());
			if (energyItem.getEnergy(stack) == energyItem.getMaxEnergy(stack))
				return true;
		}
		return false;
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
		tag.putInt("energyAmount", energyAmount);
		return super.toTag(tag);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		Inventories.fromTag(tag, inventory);
		fuel = tag.getInt("fuel");
		maxFuel = tag.getInt("maxFuel");
		energyAmount = tag.getInt("energyAmount");
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
					setEnergy(Direction.UP, value);
					break;
				case 1:
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
