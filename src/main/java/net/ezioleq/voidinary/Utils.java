package net.ezioleq.voidinary;

import java.text.DecimalFormat;

public class Utils {
	public static float clampf(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static int clampi(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	public static String getPercentString(int min, int max) {
		DecimalFormat df = new DecimalFormat("0.00");
		float percent = ((float)min/(float)max)*100.f;

		return df.format(percent);
	}
}
