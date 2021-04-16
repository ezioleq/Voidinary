package net.ezioleq.voidinary.energy;

import net.ezioleq.voidinary.Voidinary;
import net.minecraft.item.ItemStack;

public interface IEnergyItem {
	public static final int VOIDFLUX = Voidinary.config.voidFluxUnit;

	/**
	 * Our tag for energy
	 */
	public static final String TAG_KEY = Voidinary.MODID + "energy";

	/**
	 * @param stack
	 * @return Amount of energy stored in object
	 */
	public int getEnergy(ItemStack stack);

	/**
	 * Set amount of energy stored by object
	 * 
	 * @param stack
	 * @param amount
	 */
	public void setEnergy(ItemStack stack, int amount);

	/**
	 * Get object energy capacity
	 * 
	 * @param stack
	 * @return
	 */
	public int getMaxEnergy(ItemStack stack);

	/**
	 * Add given amount of energy to object
	 * 
	 * @param stack
	 * @param amount
	 * @return Amount of accepted energy
	 */
	default public int addEnergy(ItemStack stack, int amount) {
		if (getEnergy(stack) + amount <= getMaxEnergy(stack)) {
			setEnergy(stack, getEnergy(stack) + amount);
			return amount;
		} else {
			int accepted = getMaxEnergy(stack) - getEnergy(stack);
			setEnergy(stack, getMaxEnergy(stack));
			return accepted;
		}
	}

	/**
	 * Subtract given amount of energy from object
	 * 
	 * @param stack
	 * @param amount
	 * @return Amount of subtracted energy
	 */
	default public int subtractEnergy(ItemStack stack, int amount) {
		if (getEnergy(stack) - amount > 0) {
			setEnergy(stack, getEnergy(stack) - amount);
			return amount;
		} else {
			int subtracted = getEnergy(stack);
			setEnergy(stack, 0);
			return subtracted;
		}
	}
}
