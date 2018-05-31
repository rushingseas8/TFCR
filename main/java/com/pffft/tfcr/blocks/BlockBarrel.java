package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBarrel extends Block {
	
	/*
	private static final float OS = 1f / 16f;
	private static final float TS = 2f / 16f;
	private static final AxisAlignedBB BOTTOM = new AxisAlignedBB(new BlockPos(OS, 0, OS), new BlockPos(1 - OS, OS, 1 - OS));
	private static final AxisAlignedBB LEFT = new AxisAlignedBB(new BlockPos(OS, 0, OS), new BlockPos(TS, 1, 1 - OS));
	private static final AxisAlignedBB RIGHT = new AxisAlignedBB(new BlockPos(1 - OS, 0, OS), new BlockPos(1 - TS, 1, 1 - OS));
	private static final AxisAlignedBB FRONT = new AxisAlignedBB(new BlockPos(OS, 0, OS), new BlockPos(1 - OS, 1, TS));
	private static final AxisAlignedBB BACK = new AxisAlignedBB(new BlockPos(OS, 0, 1 - OS), new BlockPos(1 - OS, 1, 1 - TS));
	*/
	
	public BlockBarrel() {
		super(Material.WOOD);
		setUnlocalizedName("block_barrel");
		setRegistryName(TFCR.MODID, "block_barrel");
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
		
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
}
