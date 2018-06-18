package com.pffft.tfcr.blocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWeakStone extends Block {
	
	public static final PropertyInteger DURABILITY = PropertyInteger.create("durability", 0, 3);
	
	public BlockWeakStone() {
		super(Material.ROCK);
		
        setHardness(1F);
        setSoundType(SoundType.STONE);

		setUnlocalizedName("weak_stone");
		setRegistryName(TFCR.MODID, "weak_stone");
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		
		ArrayList<BlockPos> whatever = new ArrayList<>(30);
		//LinkedList<BlockPos> whatever = new LinkedList<>();
		whatever.add(pos.west());
		whatever.add(pos.east());
		whatever.add(pos.north());
		whatever.add(pos.south());
		whatever.add(pos.up());
		whatever.add(pos.down());
		int count = 0;
		while (!whatever.isEmpty() && count < 150) {
			int nextIndex = worldIn.rand.nextInt(whatever.size());
			BlockPos nextPos = whatever.get(nextIndex);
			if (!isStable(worldIn, nextPos) || worldIn.rand.nextInt(2) == 0) {
				count++;
				worldIn.setBlockState(nextPos, Blocks.AIR.getDefaultState(), 3);
				whatever.add(nextPos.west());
				whatever.add(nextPos.east());
				whatever.add(nextPos.north());
				whatever.add(nextPos.south());
				whatever.add(nextPos.up());
			}
		}
		System.out.println("Removed " + count + " blocks.");
	}
	
	// Returns true if this block is currently stable, i.e., is on top of a full block.
	// TODO: add more detailed checks, currently is unstable iff above air
	private boolean isStable(World worldIn, BlockPos pos) {
		if (!worldIn.getBlockState(pos).getBlock().equals(this)) {
			return true;
		}
		
		return !worldIn.getBlockState(pos.down()).getBlock().equals(Blocks.AIR);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta < 0 || meta > 3) {
			return getDefaultState();
		}
		return getDefaultState().withProperty(DURABILITY, meta);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return (Integer)state.getValue(DURABILITY);
	}

    @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, new IProperty[] {DURABILITY});
    }
}
