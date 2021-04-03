package net.ezioleq.voidinary.items.tools;

import java.util.List;

import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.energy.IEnergy;
import net.ezioleq.voidinary.utils.IDurabilityBar;
import net.ezioleq.voidinary.utils.Utils;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class VFMeter extends Item implements IEnergy, IDurabilityBar {
	int capacity = 1*IEnergy.VOIDFLUX;

	public VFMeter() {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.vf_meter.tooltip_1",
				Utils.getPercentString(getEnergy(stack), this.capacity) + "%").formatted(Formatting.GREEN));
		tooltip.add(new TranslatableText("item.voidinary.vf_meter.tooltip_2").formatted(Formatting.GRAY));
	}

	// IEnergy
	@Override
	public int getEnergy(ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		if (tag.contains(IEnergy.TAG_KEY))
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
	public void subtractEnergy(ItemStack stack, int amount) {
		CompoundTag tag = stack.getOrCreateTag();
		tag.putInt(TAG_KEY, Utils.clampi(tag.getInt(TAG_KEY) - amount, 0, capacity));
	}

	@Override
	public void addEnergy(ItemStack stack, int amount) {
		CompoundTag tag = stack.getOrCreateTag();
		tag.putInt(TAG_KEY, Utils.clampi(tag.getInt(TAG_KEY) + amount, 0, capacity));
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
		return Utils.COLOR_MC_GREEN;
	}
}
