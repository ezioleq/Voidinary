package net.ezioleq.voidinary;

import net.ezioleq.voidinary.gui.HeatGeneratorGui;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ClientRegister implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(VRegister.HEAT_GENERATOR_GUI, HeatGeneratorGui.HeatGeneratorScreen::new);		
	}
}
