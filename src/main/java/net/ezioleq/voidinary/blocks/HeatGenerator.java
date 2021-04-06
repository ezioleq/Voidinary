package net.ezioleq.voidinary.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class HeatGenerator extends HorizontalFacingBlock {
	public HeatGenerator() {
		super(Settings.of(Material.METAL).strength(4, 8));
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	protected void appendProperties(Builder<Block, BlockState> builder) {
		builder.add(Properties.HORIZONTAL_FACING);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		Direction dir = Direction.fromHorizontal(ctx.getPlayerFacing().getOpposite().getHorizontal());
		return getDefaultState().with(Properties.HORIZONTAL_FACING, dir);
	}

	// TODO: Crafting
	// TODO: GUI
	// TODO: Energy generation
	// TODO: Other stuff I forgot to write here
}
