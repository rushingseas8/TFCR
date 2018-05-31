package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHalfGrass extends Block implements IBlockColor {
	
    protected static final AxisAlignedBB TALL_GRASS_AABB = new AxisAlignedBB(0.1, 0.0D, 0.1D, 0.9D, 0.8D, 0.9D);
	
	public BlockHalfGrass() {
		super(Material.PLANTS);
        setHardness(0F);
        setLightOpacity(1);
        setSoundType(SoundType.PLANT);
        
        
		setUnlocalizedName("block_half_grass");
		setRegistryName(TFCR.MODID, "block_half_grass");
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
	}    
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return TALL_GRASS_AABB;
    }
    
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        return NULL_AABB;
    }
	
	public boolean isOpaqueCube(IBlockState state) {
        return !Minecraft.isFancyGraphicsEnabled();
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return Minecraft.isFancyGraphicsEnabled() ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return !Minecraft.isFancyGraphicsEnabled() && blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		return worldIn.getBiome(pos).getGrassColorAtPos(pos);
	}
}
