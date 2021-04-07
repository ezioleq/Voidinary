package net.ezioleq.voidinary.blocks;

import net.ezioleq.voidinary.blocks.entities.HeatGeneratorEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class HeatGenerator extends HorizontalFacingBlock implements BlockEntityProvider {
	public HeatGenerator() {
		super(Settings.of(Material.METAL).strength(4, 8));
		setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public BlockEntity createBlockEntity(BlockView arg0) {
		return new HeatGeneratorEntity();
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

	// TODO: GUI
	// TODO: Energy generation
	// TODO: Other stuff I forgot to write here
}
