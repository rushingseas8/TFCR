package com.pffft.tfcr.data;

import com.pffft.tfcr.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.IStringSerializable;

/**
 * TODO: add growth speed, burn temperature, burn duration, others?
 * TODO: make this into an enum, and make TFC wood one block with different blockstates using
 * this enum.
 */
public enum TreeType implements IStringSerializable {
	
	ACACIA		("Acacia", 		ModBlocks.WOOD_ACACIA, 		ModBlocks.LEAVES_ACACIA, 28, 50),
	ASH			("Ash",			ModBlocks.WOOD_ASH, 		ModBlocks.LEAVES_ASH, 4, 24),
	ASPEN		("Aspen",		ModBlocks.WOOD_ASPEN, 		ModBlocks.LEAVES_ASPEN, -5, 18),
	BIRCH		("Birch",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH),
		Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH)
		.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -10, 12),
	BLACKWOOD	("Blackwood",	ModBlocks.WOOD_BLACKWOOD, 	ModBlocks.LEAVES_BLACKWOOD, 0, 0),
	CHESTNUT	("Chestnut",	ModBlocks.WOOD_CHESTNUT, 	ModBlocks.LEAVES_CHESTNUT, 3, 24),
	DOUGLAS_FIR	("Douglas_Fir",	ModBlocks.WOOD_DOUGLAS_FIR, ModBlocks.LEAVES_DOUGLAS_FIR, 1, 14),
	HICKORY		("Hickory",		ModBlocks.WOOD_HICKORY, 	ModBlocks.LEAVES_HICKORY, 4, 28),
	KAPOK		("Kapok",		ModBlocks.WOOD_KAPOK, 		ModBlocks.LEAVES_KAPOK, 30, 50),
	MAPLE		("Maple",		ModBlocks.WOOD_MAPLE, 		ModBlocks.LEAVES_MAPLE, 3, 20),
	OAK			("Oak",			Blocks.LOG, Blocks.LEAVES, 5, 25),
	PALM		("Palm",		ModBlocks.WOOD_PALM, 		ModBlocks.LEAVES_PALM, 0, 0),
	PINE		("Pine",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE),
		Blocks.LEAVES.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE)
		.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -15, 24),
	ROSEWOOD	("Rosewood",	ModBlocks.WOOD_ROSEWOOD, 	ModBlocks.LEAVES_ROSEWOOD, 0, 0),
	SEQUOIA		("Sequoia",		ModBlocks.WOOD_SEQUOIA, 	ModBlocks.LEAVES_SEQUOIA, 10, 16),
	SPRUCE		("Spruce",		Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE),
		Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE)
		.withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)), -5, 24),
	SYCAMORE	("Sycamore",	ModBlocks.WOOD_SYCAMORE, 	ModBlocks.LEAVES_SYCAMORE, 6, 30),
	WHITE_CEDAR	("White_Cedar",	ModBlocks.WOOD_WHITE_CEDAR, ModBlocks.LEAVES_WHITE_CEDAR, -5, 24),
	WHITE_ELM	("White_Elm",	ModBlocks.WOOD_WHITE_ELM, 	ModBlocks.LEAVES_WHITE_ELM, 4, 30),
	WILLOW		("Willow",		ModBlocks.WOOD_WILLOW, 		ModBlocks.LEAVES_WILLOW, 10, 30);
	
    
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
	
	private TreeType(String name, Block log, Block leaf, int minTemp, int maxTemp) {
		this(name, log.getDefaultState(), leaf.getDefaultState(), minTemp, maxTemp);
	}
	
	private TreeType(String name, IBlockState log, IBlockState leaf, int minTemp, int maxTemp) {
		this.name = name;
		this.log = log;
		this.leaf = leaf;
		this.minTemperature = minTemp;
		this.maxTemperature = maxTemp;
		this.temperatureCurve = new BellCurve(minTemp, maxTemp);
	}

	@Override
	public String getName() {
		return name.toLowerCase();
	}
	
}