package net.ezioleq.voidinary.utils;

import com.mojang.blaze3d.systems.RenderSystem;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;

@Environment(EnvType.CLIENT)
public class QuadRenderer {
	/**
	 * Draw quad using separate RGB values
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param r
	 * @param g
	 * @param b
	 */
	public static void draw(int x, int y, int w, int h, int r, int g, int b) {
		RenderSystem.disableDepthTest();
		RenderSystem.disableTexture();
		RenderSystem.disableAlphaTest();
		RenderSystem.disableBlend();

		BufferBuilder bufferBuilder = Tessellator.getInstance().getBuffer();
		bufferBuilder.begin(7, VertexFormats.POSITION_COLOR);
		bufferBuilder.vertex(x, y, 0.f).color(r, g, b, 255).next();
		bufferBuilder.vertex((double)x, y+h, 0.f).color(r, g, b, 255).next();
		bufferBuilder.vertex((double)x+w, y+h, 0.f).color(r, g, b, 255).next();
		bufferBuilder.vertex((double)x+w, y, 0.f).color(r, g, b, 255).next();
		Tessellator.getInstance().draw();

		RenderSystem.enableBlend();
		RenderSystem.enableAlphaTest();
		RenderSystem.enableTexture();
		RenderSystem.enableDepthTest();
	}

	/**
	 * Draw quad using packed RGB color
	 * @see {@link net.ezioleq.voidinary.utils.Utils#mapRGB(int, int, int)}
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param color
	 */
	public static void draw(int x, int y, int w, int h, int color) {
		draw(x, y, w, h, (color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
	}
}
