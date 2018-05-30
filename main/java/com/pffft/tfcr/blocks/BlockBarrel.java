package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBarrel extends Block {
	
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
