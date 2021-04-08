package net.ezioleq.voidinary.energy;

import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.utils.Utils;
import net.minecraft.item.ItemStack;

public interface IEnergyItem {
	/**
	 * 1 VoidFlux = 1000 units
	 */
	public static final int VOIDFLUX = 1000;

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
	 * @param amount
	 */
	default public void addEnergy(ItemStack stack, int amount) {
		setEnergy(stack, Utils.clampi(getEnergy(stack) + amount, amount, getMaxEnergy(stack)));
	}

	/**
	 * Subtract given amount of energy from object
	 * 
	 * @param amount
	 */
	default public void subtractEnergy(ItemStack stack, int amount) {
		setEnergy(stack, Utils.clampi(getEnergy(stack) - amount, 0, amount));
	}
}
