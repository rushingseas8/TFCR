package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;
import com.sun.jna.platform.win32.LMAccess.LOCALGROUP_INFO_0;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSmallWood extends Block {
	
	public static final PropertyEnum<EnumDiameter> DIAMETER = PropertyEnum.create("width", EnumDiameter.class);
    public static final PropertyEnum<BlockLog.EnumAxis> LOG_AXIS = PropertyEnum.<BlockLog.EnumAxis>create("axis", BlockLog.EnumAxis.class);
	
	public BlockSmallWood() {
		super(Material.WOOD);
		setUnlocalizedName("block_branch");
		setRegistryName(TFCR.MODID, "block_branch");
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y).withProperty(DIAMETER, EnumDiameter.TWO));
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		// TODO Auto-generated method stub
		//super.getSubBlocks(itemIn, items);
		for (int i = 0; i < 4; i++) {
			items.add(new ItemStack(this, 1, i << 2));
		}
	}
	
	// Copied from log logic
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getStateFromMeta(meta).withProperty(LOG_AXIS, BlockLog.EnumAxis.fromFacingAxis(facing.getAxis()));
	}
	
	// From log logic
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {
                    case X:
                        return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
    }
    @Override
    public boolean isFullBlock(IBlockState state) {
    	return false;
    }
   
    @Override
    public boolean isFullCube(IBlockState state) {
    	return false;
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
    	int diameterVal = state.getValue(DIAMETER).ordinal(); // temporarily 4 values
    	int axisVal = state.getValue(LOG_AXIS).ordinal(); //4 values
    	
    	return (diameterVal << 2) + axisVal;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
    	int diameterVal = meta >> 2;
    	int axisVal = meta % 4;
    	
    	return this.getDefaultState()
    			.withProperty(DIAMETER, EnumDiameter.values()[diameterVal])
    			.withProperty(LOG_AXIS, EnumAxis.values()[axisVal]);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, new IProperty[] {DIAMETER, LOG_AXIS});
    }
	
	public enum EnumDiameter implements IStringSerializable {
		
		TWO(2),
		FOUR(4),
		//SIX(6),
		EIGHT(8),
		//TEN(10),
		TWELVE(12);
		//FOURTEEN(14);
		
		int diameter;
		
		EnumDiameter(int diameter) {
			this.diameter = diameter;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.toString().toLowerCase();
		}
	}
}
