package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Handles the registration for colored blocks and items.
 */
public class ModColorManager implements IBlockColor {
	
	public static final IBlockColor INSTANCE = new ModColorManager();
	
	public static void registerBlockColors() {
		System.out.println("Registering block colors");
		
		BlockColors blockColors = Minecraft.getMinecraft().getBlockColors();
		for (int i = 0; i < ModBlocks.LEAVES.length; i++) {
			//blockColors.registerBlockColorHandler(, ModBlocks.LEAVES[i]);
			blockColors.registerBlockColorHandler(ModBlocks.LEAVES[i], ModBlocks.LEAVES[i]);
		}
		
		blockColors.registerBlockColorHandler(ModBlocks.BLOCK_HALF_GRASS, ModBlocks.BLOCK_HALF_GRASS);
	}

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		// TODO Auto-generated method stub
		int value = worldIn.getBiome(pos).getFoliageColorAtPos(pos);
		return value;
	}
}
