package net.ezioleq.voidinary.blocks.items;

import java.util.List;

import net.ezioleq.voidinary.VRegister;
import net.ezioleq.voidinary.Voidinary;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class HeatGeneratorItem extends BlockItem {
	public HeatGeneratorItem() {
		super(VRegister.HEAT_GENERATOR, new Item.Settings().group(Voidinary.ITEM_GROUP));
	}

	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(new TranslatableText("item.voidinary.heat_generator.tooltip").formatted(Formatting.GRAY));
	}
}
