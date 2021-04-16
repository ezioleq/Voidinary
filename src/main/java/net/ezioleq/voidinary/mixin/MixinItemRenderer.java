package net.ezioleq.voidinary.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.ezioleq.voidinary.utils.IDurabilityBar;
import net.ezioleq.voidinary.utils.QuadRenderer;
import net.ezioleq.voidinary.utils.Utils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.item.ItemStack;

@Mixin(ItemRenderer.class)
@Environment(EnvType.CLIENT)
public abstract class MixinItemRenderer {
	@Inject(method = "renderGuiItemOverlay(Lnet/minecraft/client/font/TextRenderer;Lnet/minecraft/item/ItemStack;IILjava/lang/String;)V", at = @At(value = "TAIL"))
	public void onGuiRender(TextRenderer textRenderer, ItemStack stack, int x, int y, String string, CallbackInfo callback) {
		if (stack.getItem() instanceof IDurabilityBar) {
			IDurabilityBar itemDurability = (IDurabilityBar)stack.getItem();
			if (!itemDurability.showDurability(stack))
				return;

			QuadRenderer.draw(x+2, y+13, 12, 2, Utils.Colors.COLOR_BLACK);
			QuadRenderer.draw(x+2, y+13,
				(int)Math.floor(itemDurability.getDurability(stack)*12), 1, itemDurability.getDurabilityColor(stack));
		}
	}
}
