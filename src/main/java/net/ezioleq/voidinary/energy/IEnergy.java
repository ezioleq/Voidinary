package net.ezioleq.voidinary.energy;

import net.minecraft.util.math.Direction;

public interface IEnergy {
	/**
	 * 1 VoidFlux = 1000 units
	 */
	public static final int VOIDFLUX = 1000;

	/**
	 * @param dir
	 * @return Amount of energy stored in object
	 */
	public int getEnergy(Direction dir);

	/**
	 * Set amount of energy stored by object
	 * 
	 * @param dir
	 * @param amount
	 */
	public void setEnergy(Direction dir, int amount);

	/**
	 * Get object energy capacity
	 * 
	 * @param dir
	 * @return
	 */
	public int getMaxEnergy(Direction dir);

	/**
	 * If a cable can connect to a given side
	 * @param dir
	 * @return
	 */
	default public boolean canCableConnect(Direction dir) {
		return true;
	}

	/**
	 * Add given amount of energy to object
	 * 
	 * @param dir
	 * @param amount
	 * @return Amount of accepted energy
	 */
	default public int addEnergy(Direction dir, int amount) {
		if (getEnergy(dir) + amount <= getMaxEnergy(dir)) {
			setEnergy(dir, getEnergy(dir) + amount);
			return amount;
		} else {
			int accepted = getMaxEnergy(dir) - getEnergy(dir);
			setEnergy(dir, getMaxEnergy(dir));
			return accepted;
		}
	}

	/**
	 * Subtract given amount of energy from object
	 * 
	 * @param dir
	 * @param amount
	 * @return Amount of subtracted energy
	 */
	default public int subtractEnergy(Direction dir, int amount) {
		if (getEnergy(dir) - amount > 0) {
			setEnergy(dir, getEnergy(dir) - amount);
			return amount;
		} else {
			int subtracted = getEnergy(dir);
			setEnergy(dir, 0);
			return subtracted;
		}
	}
}
