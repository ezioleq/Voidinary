package net.ezioleq.voidinary.utils;

import net.minecraft.item.ItemStack;

public interface IDurabilityBar {
	/**
	 * Get current item durability, this should be a value between 0.0 and 1.0
	 * 
	 * @param stack
	 * @return
	 */
	default double getDurability(ItemStack stack) {
		return 0;
	}

	/**
	 * Self-explained
	 * 
	 * @param stack
	 * @return
	 */
	default boolean showDurability(ItemStack stack) {
		return false;
	}

	/**
	 * Get durability bar color, basic colors are available in {@link net.ezioleq.voidinary.utils.Utils}
	 * 
	 * @param stack
	 * @return
	 */
	default int getDurabilityColor(ItemStack stack) {
		return 0;
	}
}
