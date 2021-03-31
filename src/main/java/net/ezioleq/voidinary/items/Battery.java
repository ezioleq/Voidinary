package net.ezioleq.voidinary.items;

import java.util.List;

import net.ezioleq.voidinary.utils.IDurabilityBar;
import net.ezioleq.voidinary.utils.Utils;
import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.energy.IEnergy;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class Battery extends Item implements IEnergy, IDurabilityBar {
	int capacity = 0;
	int storedEnergy = 500;
	BatteryStatus status = BatteryStatus.IDLE;

	public Battery(int capacity) {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(1));
		this.capacity = capacity;
		this.storedEnergy = capacity/2; // FIXME: Test purposes only
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.battery.tooltip",
				Utils.getPercentString(this.storedEnergy, this.capacity) + "%"));
	}

	// IEnergy
	@Override
	public int getEnergy() {
		return storedEnergy;
	}

	@Override
	public void setEnergy(int amount) {
		storedEnergy = amount;
	}

	@Override
	public void subtractEnergy(int amount) {
		storedEnergy -= amount;
		if (storedEnergy < 0)
			storedEnergy = 0;
	}

	@Override
	public void addEnergy(int amount) {
		storedEnergy += amount;
		if (storedEnergy > capacity)
			storedEnergy = capacity;
	}

	// IDurability
	@Override
	public double getDurability(ItemStack stack) {
		return (float)storedEnergy/(float)capacity;
	}

	@Override
	public boolean showDurability(ItemStack stack) {
		return true;
	}

	@Override
	public int getDurabilityColor(ItemStack stack) {
		return Utils.mapRGB(32, 255, 32);
	}
}
