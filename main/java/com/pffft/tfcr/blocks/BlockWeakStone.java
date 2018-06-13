package com.pffft.tfcr.blocks;

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
		
		setTickRandomly(true);
        setHardness(1F);
        setSoundType(SoundType.STONE);

		setUnlocalizedName("weak_stone");
		setRegistryName(TFCR.MODID, "weak_stone");
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
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
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		int durability = state.getValue(DURABILITY);
		if (durability >= 3) {
			return;
		} else {
			worldIn.setBlockState(pos, state.withProperty(DURABILITY, durability + 1));
		}
		//super.randomTick(worldIn, pos, state, random);
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
