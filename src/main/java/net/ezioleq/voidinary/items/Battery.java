package net.ezioleq.voidinary.items;

import java.util.List;

import net.ezioleq.voidinary.utils.IDurabilityBar;
import net.ezioleq.voidinary.utils.Utils;
import net.ezioleq.voidinary.Voidinary;
import net.ezioleq.voidinary.energy.IEnergy;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Battery extends Item implements IEnergy, IDurabilityBar {
	int capacity = 0;
	BatteryStatus status = BatteryStatus.IDLE;

	public Battery(int capacity) {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(1));
		this.capacity = capacity;
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.battery.tooltip",
				Utils.getPercentString(getEnergy(stack), this.capacity) + "%"));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		// TODO: Do you seriously think we will charge batteries by shaking them?
		ItemStack stack = user.getStackInHand(hand); 
		if (getEnergy(stack) < capacity) {
			addEnergy(stack, 10);
		}
		return TypedActionResult.success(stack);
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
		return Utils.mapRGB(32, 255, 32);
	}
}
