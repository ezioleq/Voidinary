package net.ezioleq.voidinary.gui.components;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;

public class VGuiScreenHandler extends SyncedGuiDescription {
	public VGuiScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory inventory, ScreenHandlerContext ctx) {
		super(type, syncId, inventory, getBlockInventory(ctx), getBlockPropertyDelegate(ctx));
	}

	@Override
	public void sendContentUpdates() {
		PlayerEntity player = playerInventory.player;
		if (player instanceof ServerPlayerEntity) {
			for (int i = 0; i < propertyDelegate.size(); i++) {
				// TODO: ?
			}
		}
		super.sendContentUpdates();
	}
}
