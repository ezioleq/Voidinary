package net.ezioleq.voidinary.items;

import java.util.List;

import net.ezioleq.voidinary.utils.IDurabilityBar;
import net.ezioleq.voidinary.utils.Utils;
import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.energy.IEnergyItem;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class Battery extends Item implements IEnergyItem, IDurabilityBar {
	final int capacity = Voidinary.config.batteryCapacity;

	public Battery() {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.battery.tooltip",
				Utils.getFormmatedEnergy(getEnergy(stack), this.capacity)).formatted(Formatting.GREEN));
	}

	// IEnergy
	@Override
	public int getEnergy(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		if (tag.contains(IEnergyItem.TAG_KEY))
			return tag.getInt(TAG_KEY);
		else {
			tag.putInt(TAG_KEY, 0);
			return 0;
		}
	}

	@Override
	public void setEnergy(ItemStack stack, int amount) {
		CompoundTag tag = stack.getOrCreateTag();
		tag.putInt(TAG_KEY, amount);
	}

	@Override
	public int getMaxEnergy(ItemStack stack) {
		return capacity;
	}

	// IDurability
	@Override
	public double getDurability(ItemStack stack) {
		return (float)getEnergy(stack)/(float)capacity;
	}

	@Override
	public boolean showDurability(ItemStack stack) {
		return true;
	}

	@Override
	public int getDurabilityColor(ItemStack stack) {
		return Utils.Colors.getDefaultBarColor(getDurability(stack));
	}
}
