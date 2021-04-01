package net.ezioleq.voidinary.energy;

import net.ezioleq.voidinary.Voidinary;
import net.minecraft.item.ItemStack;

public interface IEnergy {
	/**
	 * 1 VoidFlux = 1000 units
	 */
	public static final int VOIDFLUX = 1000;

	/**
	 * Our tag for energy
	 */
	public static final String TAG_KEY = Voidinary.MODID + "energy";

	/**
	 * @return Amount of energy stored in object
	 */
	int getEnergy(ItemStack stack);

	/**
	 * Set amount of energy stored by object
	 * @param amount
	 */
	void setEnergy(ItemStack stack, int amount);

	/**
	 * Subtract given amount of energy from object
	 * @param amount
	 */
	void subtractEnergy(ItemStack stack, int amount);

	/**
	 * Add given amount of energy to object
	 * @param amount
	 */
	void addEnergy(ItemStack stack, int amount);
}
