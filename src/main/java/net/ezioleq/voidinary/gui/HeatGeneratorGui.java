package net.ezioleq.voidinary.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.ezioleq.voidinary.VRegister;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;

public class HeatGeneratorGui extends SyncedGuiDescription {
	public HeatGeneratorGui(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
		super(VRegister.HEAT_GENERATOR_GUI, syncId, playerInventory, getBlockInventory(context),
				getBlockPropertyDelegate(context));
		
		WGridPanel root = new WGridPanel();
		setRootPanel(root);

		WSprite flame = new WSprite(Sprites.FLAME_BG);
		root.add(flame, 4, 1);

		WItemSlot input = WItemSlot.of(blockInventory, 0);
		root.add(input, 4, 2);

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
