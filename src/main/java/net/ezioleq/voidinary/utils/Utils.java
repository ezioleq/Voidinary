package net.ezioleq.voidinary.utils;

import java.text.DecimalFormat;

public class Utils {
	/**
	 * Clamp float value in given range
	 * @param value Value to clamp
	 * @param min Minimum
	 * @param max Maximum
	 * @return Clamped value
	 */
	public static float clampf(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Clamp int value in given range
	 * @param value Value to clamp
	 * @param min Minimum
	 * @param max Maximum
	 * @return Clamped value
	 */
	public static int clampi(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	/**
	 * Get percentage string with 2 decimal places (e.g. 21.37%)
	 * @param min First value
	 * @param max Second value
	 * @return Percentage string
	 */
	public static String getPercentString(int min, int max) {
		DecimalFormat df = new DecimalFormat("0.00");
		float percent = ((float)min/(float)max)*100.f;

		return df.format(percent);
	}

	/**
	 * Map RGB color to int using bitwise operations
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
	 * @param min Minimum
	 * @param max Maximum
	 * @return Random number from given range
	 */
	public static int getRandomNumber(int min, int max) {
		return (int)((Math.random() * (min - max)) + min);
	}
}
