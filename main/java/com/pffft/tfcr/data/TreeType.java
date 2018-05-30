package com.pffft.tfcr.data;

import com.pffft.tfcr.init.ModBlocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

/**
 * TODO: add growth speed, burn temperature, burn duration, others?
 * TODO: make this into an enum, and make TFC wood one block with different blockstates using
 * this enum.
 */
public class TreeType {

	private static IBlockState leaves_default = Blocks.LEAVES.getDefaultState()
		.withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK)
		.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
	
	/**
	 * List of all TreeTypes in the game.
	 */
    public static final TreeType[] trees = new TreeType[] {
    	new TreeType("Acacia",		ModBlocks.WOOD_ACACIA.getDefaultState(), leaves_default, 28, 50),
    	new TreeType("Ash",			ModBlocks.WOOD_ASH.getDefaultState(), leaves_default, 4, 24),
    	new TreeType("Aspen",		ModBlocks.WOOD_ASPEN.getDefaultState(), leaves_default, -5, 18),
    	new TreeType("Birch",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH),
    		leaves_default.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH)
    		.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -10, 12),
    	new TreeType("Blackwood",	ModBlocks.WOOD_BLACKWOOD.getDefaultState(), leaves_default, 0, 0),
    	new TreeType("Chestnut",	ModBlocks.WOOD_CHESTNUT.getDefaultState(), leaves_default, 3, 24),
    	new TreeType("Douglas_Fir",	ModBlocks.WOOD_DOUGLAS_FIR.getDefaultState(), leaves_default, 1, 14),
    	new TreeType("Hickory",		ModBlocks.WOOD_HICKORY.getDefaultState(), leaves_default, 4, 28),
    	new TreeType("Kapok",		ModBlocks.WOOD_KAPOK.getDefaultState(), leaves_default, 30, 50),
    	new TreeType("Maple",		ModBlocks.WOOD_MAPLE.getDefaultState(), leaves_default, 3, 20),
    	new TreeType("Oak",			Blocks.LOG.getDefaultState(), leaves_default, 5, 25),
    	new TreeType("Palm",		ModBlocks.WOOD_PALM.getDefaultState(), leaves_default, 0, 0),
    	new TreeType("Pine",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE),
			leaves_default.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE)
			.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -15, 24),
    	new TreeType("Rosewood",	ModBlocks.WOOD_ROSEWOOD.getDefaultState(), leaves_default, 0, 0),
    	new TreeType("Sequoia",		ModBlocks.WOOD_SEQUOIA.getDefaultState(), leaves_default, 10, 16),
    	new TreeType("Spruce",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE),
			leaves_default.withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE)
			.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -5, 24),
    	new TreeType("Sycamore",	ModBlocks.WOOD_SYCAMORE.getDefaultState(), leaves_default, 6, 30),
    	new TreeType("White_Cedar",	ModBlocks.WOOD_WHITE_CEDAR.getDefaultState(), leaves_default, -5, 24),
    	new TreeType("White_Elm",	ModBlocks.WOOD_WHITE_ELM.getDefaultState(), leaves_default, 4, 30),
    	new TreeType("Willow",		ModBlocks.WOOD_WILLOW.getDefaultState(), leaves_default, 10, 30)
    };
    
    
	// The common name of this tree.
	public String name;
	
	// The Block used for generating the log of the tree.
	public IBlockState log;
	// The Block used for generating the leaf of the tree.
	public IBlockState leaf;
	
	// The minimum temperature this tree spawns at.
	public int minTemperature;
	// The maximum temperature this tree spawns at.
	public int maxTemperature;
	
	// The probability of spawning at a given temperature.
	public BellCurve temperatureCurve;
	
	private TreeType(String name, IBlockState log, IBlockState leaf, int minTemp, int maxTemp) {
		this.name = name;
		this.log = log;
		this.leaf = leaf;
		this.minTemperature = minTemp;
		this.maxTemperature = maxTemp;
		this.temperatureCurve = new BellCurve(minTemp, maxTemp);
	}
	
}