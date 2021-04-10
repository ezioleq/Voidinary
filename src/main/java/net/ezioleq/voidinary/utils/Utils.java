package net.ezioleq.voidinary.utils;

import java.text.DecimalFormat;

public class Utils {
	// Some colors
	public static final int COLOR_BLACK = Utils.mapRGB(0, 0, 0);
	public static final int COLOR_WHITE = Utils.mapRGB(255, 255, 255);
	public static final int COLOR_RED = Utils.mapRGB(255, 0, 0);
	public static final int COLOR_GREEN = Utils.mapRGB(0, 255, 0);
	public static final int COLOR_MC_GREEN = Utils.mapRGB(101, 255, 0);
	public static final int COLOR_BLUE = Utils.mapRGB(0, 0, 255);

	/**
	 * Clamp float value in given range
	 * 
	 * @param value Value to clamp
	 * @param min   Minimum
	 * @param max   Maximum
	 * @return Clamped value
	 */
	public static float clampf(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Clamp int value in given range
	 * 
	 * @param value Value to clamp
	 * @param min   Minimum
	 * @param max   Maximum
	 * @return Clamped value
	 */
	public static int clampi(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Get percentage string with 2 decimal places (e.g. 21.37%)
	 * 
	 * @param min First value
	 * @param max Second value
	 * @return Percentage string
	 */
	public static String getPercentString(int min, int max) {
		DecimalFormat df = new DecimalFormat("0.00");
		float percent = ((float) min / (float) max) * 100.f;

		return df.format(percent);
	}

	/**
	 * Map RGB color to int using bitwise operations
	 * 
	 * @param r Red
	 * @param g Green
	 * @param b Blue
	 * @return Encoded color
	 */
	public static int mapRGB(int r, int g, int b) {
		return ((r & 0xFF) << 16 | (g & 0xFF) << 8 | (b & 0xFF));
	}

	/**
	 * Get random number between given range
	 * 
	 * @param min Minimum
	 * @param max Maximum
	 * @return Random number from given range
	 */
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (min - max)) + min);
	}

	/**
	 * Format value to use kilo, mega, giga etc.
	 * 
	 * @param value
	 * @param separate Use space before suffix
	 * @return Formatted string
	 */
	
	public static String getHumanReadableValueString(int value, boolean separate) {
		final String[] suffixes = { "", "k", "M", "G", "T", "P", "E" };
		float val = (float) value;

		int magnitude = (int) Math.floor(Math.log(value) / Math.log(1000));
		for (int i = magnitude; i > 0; i--)
			val /= 1000;

		val = Math.round(val * 100.f) / 100.f;
		/* For some reason Minecraft during initialization want to access suffixes array with int's MIN_VALUE
		 * what caused ArrayOutOfBoundsException, so the clamp here is very important anyway.
		 */
		return String.valueOf(val) + (separate ? " " : "") + suffixes[clampi(magnitude, 0, suffixes.length-1)];
	}

	/**
	 * Format energy amount to kilo, mega, giga etc. e.g. 1802 VF; 2 kVF, 300 GVF
	 * 
	 * @param value
	 * @return Formatted string
	 */
	public static String getFormattedEnergy(int value) {
		return getHumanReadableValueString(value, true) + "VF";
	}

	/**
	 * Format current and max energy amount to kilo, mega, giga etc., e.g. 1.80k/2 kVF
	 *
	 * @param current
	 * @param max
	 * @return Formatted string
	 */
	public static String getFormmatedEnergy(int current, int max) {
		return getHumanReadableValueString(current, false) + "/" + getHumanReadableValueString(max, true) + "VF";
	}
}
