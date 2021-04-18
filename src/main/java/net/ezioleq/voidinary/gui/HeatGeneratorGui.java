package net.ezioleq.voidinary.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WBar.Direction;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.ezioleq.voidinary.VRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class HeatGeneratorGui extends SyncedGuiDescription {
	public HeatGeneratorGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
		super(VRegister.HEAT_GENERATOR_GUI, syncId, playerInventory, getBlockInventory(context),
				getBlockPropertyDelegate(context));
		
		WGridPanel root = new WGridPanel();
		setRootPanel(root);

		// Header label
		WLabel label = new WLabel(new TranslatableText("block.voidinary.heat_generator"));
		label.setHorizontalAlignment(HorizontalAlignment.CENTER);
		root.add(label, 0, 0, 9, 1);

		// Left energy bar
		WBar energyBar = new WBar(Sprites.TANK_BG, Sprites.TANK_ENERGY, 0, 1, Direction.UP);
		root.add(energyBar, 0, 0, 1, 4);

		// Right fuel bar
		WBar fuelBar = new WBar(Sprites.TANK_BG, Sprites.TANK_FUEL, 2, 3, Direction.UP);
		root.add(fuelBar, 8, 0, 1, 4);

		// Flame above input slot
		WSprite flame = new WSprite(Sprites.FLAME_BG);
		root.add(flame, 3, 1);

		// Input slot
		WItemSlot input = WItemSlot.of(blockInventory, 0);
		root.add(input, 3, 2);

		// Output slot
		WItemSlot output = WItemSlot.of(blockInventory, 1);
		root.add(output, 5, 2);

		root.add(createPlayerInventoryPanel(), 0, 4);
		root.validate(this);
	}

	@Override
	public void close(PlayerEntity player) {
		super.close(player);
	}

	public static class HeatGeneratorScreen extends CottonInventoryScreen<HeatGeneratorGui> {
		public HeatGeneratorScreen(HeatGeneratorGui gui, PlayerInventory playerInventory, Text text) {
			super(gui, playerInventory.player);
		}
	}
}
