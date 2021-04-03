package net.ezioleq.voidinary.items;

import java.util.List;

import net.ezioleq.voidinary.Voidinary;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class BatteryCell extends Item {
	public BatteryCell() {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(16));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.battery_cell.tooltip").formatted(Formatting.GRAY));
	}
}
