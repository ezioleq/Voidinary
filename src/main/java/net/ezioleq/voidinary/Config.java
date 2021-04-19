package net.ezioleq.voidinary;

import blue.endless.jankson.Comment;
import io.github.cottonmc.cotton.config.annotations.ConfigFile;

@ConfigFile(name="Voidinary")
public class Config {
	@Comment(value="1 VF = N units, default value is 1000")
	public int voidFluxUnit = 1000;

	public int batteryCapacity = 1000;
	public int vfMeterCapacity = 500;

	public int heatGeneratorCapacity = 2000;
	public int heatGeneratorFuelCapacity = 1000;
	public int heatGeneratorChargeAmount = 10;
}
