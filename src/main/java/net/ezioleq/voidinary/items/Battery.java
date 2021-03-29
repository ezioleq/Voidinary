package net.ezioleq.voidinary.items;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class Battery extends Item {
	int capacity = 100;
	int currentLevel = 0;
	BatteryStatus status = BatteryStatus.IDLE;

	public Battery(Settings settings) {
		super(settings);
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.battery.tooltip", currentLevel + "/" + capacity));
	}
}
