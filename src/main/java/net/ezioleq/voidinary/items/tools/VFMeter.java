package net.ezioleq.voidinary.items.tools;

import java.util.List;

import net.ezioleq.voidinary.Voidinary;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class VFMeter extends Item {
	public VFMeter() {
		super(new Item.Settings().group(Voidinary.ITEM_GROUP).maxCount(1));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.vf_meter.tooltip"));
	}
}
