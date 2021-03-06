package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;
import com.pffft.tfcr.items.IItemSelfRegister;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public class BlockSmallWood extends Block implements IItemSelfRegister, IBlockSelfRegister {
	
	public String name;
	
	public static final PropertyEnum<EnumDiameter> DIAMETER = PropertyEnum.create("width", EnumDiameter.class);
    public static final PropertyEnum<EnumAxis> LOG_AXIS = PropertyEnum.<EnumAxis>create("axis", EnumAxis.class);
	
	public BlockSmallWood() {
		super(Material.WOOD);
		//this.name = name;
		
		setUnlocalizedName("block_branch");
		setRegistryName(TFCR.MODID, "block_branch");
		setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y).withProperty(DIAMETER, EnumDiameter.FOUR));
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_BLOCKS);
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (int i = 0; i < EnumDiameter.values().length; i++) {
			items.add(new ItemStack(this, 1, i * 3));
		}
	}

	// Begin custom registration in Forge game registries
	
	@Override
	public void registerItem(RegistryEvent.Register<Item> event, Item item) {
		ItemBlock newItemBlock = (ItemBlock)item;
		newItemBlock.setRegistryName(this.getRegistryName());
		event.getRegistry().register(newItemBlock);
	}
	
	@Override
	public void registerRenders(ModelRegistryEvent event) {
		Item inventoryItem = Item.getItemFromBlock(this);
		for (int meta = 0; meta < EnumDiameter.values().length; meta++) {
			String variant = "axis=y,width=" + EnumDiameter.values()[meta].getName();
			System.out.println("Registering variant: " + variant);
			ModelLoader.setCustomModelResourceLocation(inventoryItem, meta * 3, new ModelResourceLocation( inventoryItem.getRegistryName(), variant));
		}
	}
	
	// End custom registration
	
	// Copied from log logic
	// TODO: the "meta" value is returning 0 always. This indicates that it thinks item metadata is always 0.
	// Maybe the subblocks aren't registered properly? This is a temporary hack to fix it.
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		
		
		//IBlockState normalState = getStateFromMeta(meta);
		//System.out.println("Get state for placement, meta value " + meta + " width found: " + normalState.getValue(DIAMETER));
		//System.out.println("Placer's metadata: " + placer.getHeldItemMainhand().getMetadata());
		int trueMeta = placer.getHeldItemMainhand().getMetadata();
		
        return this.getStateFromMeta(trueMeta)
        		.withProperty(LOG_AXIS, EnumAxis.fromFacingAxis(facing.getAxis()));
        		//.withProperty(DIAMETER, EnumDiameter.FOUR);
	}
	
	// From log logic
    public IBlockState withRotation(IBlockState state, Rotation rot) {
    	System.out.println("With rotation called");
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:

                switch ((EnumAxis)state.getValue(LOG_AXIS)) {
                    case X:
                        return state.withProperty(LOG_AXIS, EnumAxis.Z);
                    case Z:
                        return state.withProperty(LOG_AXIS, EnumAxis.X);
                    default:
                        return state;
                }

            default:
                return state;
        }
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
    public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
    	// TODO Auto-generated method stub
    	return true;
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
    		ItemStack stack) {
    	// TODO Auto-generated method stub
    	//System.out.println("Block placed, metadata is: " + stack.getMetadata());
    	//System.out.println("Block state on ground width is " + state.getValue(DIAMETER));
    	//worldIn.setBlockState(pos, this.getStateFromMeta(stack.getMetadata()));
    	super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
    	int diameterVal = state.getValue(DIAMETER).ordinal(); // temporarily 4 values
    	int axisVal = state.getValue(LOG_AXIS).ordinal(); //4 values

    	//System.out.println("Got meta from state called. Input diameter: " + state.getValue(DIAMETER) + ", input axis: " + state.getValue(LOG_AXIS));
    	//System.out.println("Returning meta value: " + ((diameterVal * 4) + axisVal));
    	return (diameterVal * 3) + axisVal;
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {

    	//System.out.println("Got input meta: " + meta + ". ");
    	int diameterVal = meta / 3;
    	int axisVal = meta % 3;
    	//System.out.println("Therefore, diameter is " + EnumDiameter.values()[diameterVal]);
    	
    	return this.getDefaultState()
    			.withProperty(DIAMETER, EnumDiameter.values()[diameterVal])
    			.withProperty(LOG_AXIS, EnumAxis.values()[axisVal]);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
    	return new BlockStateContainer(this, new IProperty[] {DIAMETER, LOG_AXIS});
    }
	
	public enum EnumDiameter implements IStringSerializable {
		
		FOUR(4),
		SIX(6),
		EIGHT(8),
		TEN(10),
		TWELVE(12);
		
		int diameter;
		
		private EnumDiameter(int diameter) {
			this.diameter = diameter;
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name().toLowerCase();
		}
	}
	
	// Note: this is like BlockLog.EnumAxis, but without the default bark-only variant.
	public enum EnumAxis implements IStringSerializable {
		X,
		Y,
		Z;

		public static EnumAxis fromFacingAxis(EnumFacing.Axis axis) {
			switch(axis) {
				case X: return X;
				case Y: return Y;
				case Z: return Z;
				default: return Y;
			}
		}
		
		@Override
		public String getName() {
			return this.name().toLowerCase();
		}
	}
}
