package net.ezioleq.voidinary.blocks.entities;

import net.ezioleq.voidinary.VRegister;
import net.ezioleq.voidinary.energy.IEnergy;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.Direction;

public class HeatGeneratorEntity extends BlockEntity implements IEnergy {
	final int capacity = 2 * IEnergy.VOIDFLUX;

	public HeatGeneratorEntity() {
		super(VRegister.HEAT_GENERATOR_ENTITY);
	}

	@Override
	public int getEnergy(Direction dir) {
		return 0;
	}

	@Override
	public void setEnergy(Direction dir, int amount) {
		
	}

	@Override
	public int getMaxEnergy(Direction dir) {
		return capacity;
	}
}
