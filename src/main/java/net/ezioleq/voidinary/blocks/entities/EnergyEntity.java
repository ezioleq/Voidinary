package net.ezioleq.voidinary.blocks.entities;

import net.ezioleq.voidinary.energy.IEnergy;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Direction;

public abstract class EnergyEntity extends BlockEntity implements IEnergy {
	int energyAmount = 0;

	public EnergyEntity(BlockEntityType<?> type) {
		super(type);
	}

	@Override
	public int getEnergy(Direction dir) {
		return energyAmount;
	}

	@Override
	public void setEnergy(Direction dir, int amount) {
		energyAmount = amount;
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		energyAmount = tag.getInt("energyAmount");
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		tag.putInt("energyAmount", energyAmount);
		return super.toTag(tag);
	}
}
