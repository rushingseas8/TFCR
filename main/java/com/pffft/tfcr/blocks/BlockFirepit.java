package com.pffft.tfcr.blocks;

import java.util.Random;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.gui.GuiFirepit;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import scala.reflect.internal.Trees.Return;

public class BlockFirepit extends Block {

	public BlockFirepit() {
		super(Material.CLOTH);
		setUnlocalizedName("block_firepit");
		setRegistryName(TFCR.MODID, "block_firepit");
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		
		if (!worldIn.isRemote) {
			FMLNetworkHandler.openGui(playerIn, TFCR.instance, GuiFirepit.GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
		
		//return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		// TODO Auto-generated method stub
		System.out.println("Added a new Firepit TileEntity");
		return new TileEntityFirepit();
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
	
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		// TODO Auto-generated method stub
		//super.randomDisplayTick(stateIn, worldIn, pos, rand);
		
		for (int i = 0; i < 6; i++) {
			float xPosition = pos.getX() + (rand.nextFloat() * 0.6f) + 0.2f;
			float zPosition = pos.getZ() + (rand.nextFloat() * 0.6f) + 0.2f;
			

			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xPosition, pos.getY() - 0.1f, zPosition, 0f, rand.nextFloat() * 0.25f, 0);
		}

		for (int i = 0; i < 2; i++) {
			float xPosition = pos.getX() + (rand.nextFloat() * 0.6f) + 0.2f;
			float zPosition = pos.getZ() + (rand.nextFloat() * 0.6f) + 0.2f;
			

			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, xPosition, pos.getY() + 0.1f, zPosition, 0f, rand.nextFloat() * 0.10f, 0);
		}

		for (int i = 0; i < 3; i++) {
			float xPosition = pos.getX() + (rand.nextFloat() * 0.6f) + 0.2f;
			float zPosition = pos.getZ() + (rand.nextFloat() * 0.6f) + 0.2f;

			worldIn.spawnParticle(EnumParticleTypes.FLAME, xPosition, pos.getY() + 0.1f, zPosition, 0f, rand.nextFloat() * 0.05f, 0);
		}
	}
}
