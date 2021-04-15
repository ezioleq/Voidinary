package net.ezioleq.voidinary;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class Voidinary implements ModInitializer {
	public static final String MODID = "voidinary";

	/**
	 * Default Voidinary item group
	 */
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "general"),
			() -> new ItemStack(VRegister.BATTERY_CELL));

	@Override
	public void onInitialize() {
		VRegister.registerAll();

		System.out.println("Voidinary loaded!");
	}
}
