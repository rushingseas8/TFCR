package com.pffft.tfcr.worldgen;

import java.util.ArrayList;
import java.util.Random;

import com.pffft.tfcr.blocks.BlockSmallWood;
import com.pffft.tfcr.data.TreeType;
import com.pffft.tfcr.init.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

public class WorldGenTreeClimate extends WorldGenerator {

	private static final double[] DEFAULT_BREADTHS = new double[]{1, 2, 3, 4, 4, 3, 2, 1, 0};
	private static final double[] DOUGLAS_FIR_LEAVES = new double[] {2, 4, 4, 3, 2, 2, 1, 0, 0};
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean generate(World worldIn, Random rand, BlockPos position, boolean notify, int temperature, int numTrees) {
		
		ArrayList<TreeType> treeTypes = new ArrayList<>();
		ArrayList<Double> treeWeights = new ArrayList<>();
		
		// Go through all the tree types. If the tree can spawn in this temperature, add its probability
		// to the weight list.
		for (int i = 0; i < TreeType.values().length; i++) {
			TreeType tree = TreeType.values()[i];
			if (temperature > tree.minTemperature && temperature < tree.maxTemperature) {
				treeTypes.add(tree);
				treeWeights.add((Double)(tree.temperatureCurve.getValue(temperature)));
			}
		}
		
		// Make a cumulative probability array. E.g., for 0.1, 0.2, 0.3, we generate
		// [0, 0.1, 0.3, 0.6]. 
		double totalWeight = 0;
		double[] cumulativeWeights = new double[treeWeights.size() + 1];
		cumulativeWeights[0] = 0;
		for (int i = 0; i < treeWeights.size(); i++) {
			totalWeight += treeWeights.get(i);
			cumulativeWeights[i + 1] = totalWeight; 
		}
		
		//System.out.println("Cumulative weights size: " + cumulativeWeights.length);
		
		// We generate a random range form 0 to (tree types possible). If it falls in
		// the boundary of a tree type, it is generated; else it fails to generate.
		for (int i = 0; i < numTrees; i++) {
			double randValue = rand.nextDouble() * totalWeight; //treeTypes.size()
			for (int j = 0; j < cumulativeWeights.length - 1; j++) {
				if (randValue > cumulativeWeights[j] && randValue < cumulativeWeights[j + 1]) {
					generateTree(worldIn, rand, position, treeTypes.get(j), notify);
				}
			}
		}
		
		return true;
	}
	
	public boolean generateTree(World worldIn, Random rand, BlockPos chunkBase, TreeType tree, boolean notify) {
		int xOffset = rand.nextInt(16) + 8;
		int zOffset = rand.nextInt(16) + 8;
		
		BlockPos base = worldIn.getHeight(chunkBase.add(xOffset, 0, zOffset));
		IBlockState state = worldIn.getBlockState(base.down());
		
		// If this isn't a dirt/grass/etc. block, fail to grow
		if (!state.getBlock().canSustainPlant(state, worldIn, base.down(), EnumFacing.UP, (IPlantable) Blocks.SAPLING))
			return false;
		
		// Set grass to dirt if needed
		state.getBlock().onPlantGrow(state, worldIn, base.down(), base);
		
		IBlockState testState;
		int nextRand = rand.nextInt(3);
		if (nextRand == 0) {
			testState = ModBlocks.WOOD_ASH.getDefaultState();
		} else if (nextRand == 1) {
			testState = ModBlocks.BLOCK_SMALL_WOOD.getDefaultState().withProperty(BlockSmallWood.DIAMETER, BlockSmallWood.EnumDiameter.EIGHT);
		} else {
			testState = ModBlocks.BLOCK_SMALL_WOOD.getDefaultState().withProperty(BlockSmallWood.DIAMETER, BlockSmallWood.EnumDiameter.TWELVE);
		}
		
		int height;
		switch(tree.name.toLowerCase()) {
			case "acacia":
				return true;
			case "ash":
				height = 4 + rand.nextInt(2);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "aspen":
				height = 3 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "birch":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "blackwood":
				height = 5 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "chestnut":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "douglas_fir":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				generateEllipsoidTree(worldIn, rand, base, tree, notify, height, DOUGLAS_FIR_LEAVES);
				
				return true;
			case "hickory":
				height = 5 + rand.nextInt(4);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "kapok":
				height = 7 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "maple":
				height = 5 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "oak":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "palm":
				height = 6 + rand.nextInt(2);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "pine":
				height = 7 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "rosewood": //TODO make this jungle tree; taller
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "sequoia": //TODO remove
				height = 10 + rand.nextInt(6);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "spruce":
				height = 7 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "sycamore":
				height = 9 + rand.nextInt(5);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "white_cedar":
				height = 5 + rand.nextInt(4);
				generateEllipsoidTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "white_elm":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "willow": // TODO
				height = 5 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
				default: return false;
		}
	}
	
	/**
	 * Helper function for generating a basic trunk + leaves. Exact same as vanilla oaks.
	 */
	private void generateBasicTree(World worldIn, Random rand, BlockPos pos, TreeType tree, boolean notify, int height) {
		generateBasicTrunk(worldIn, pos, tree, notify, height);
		generateBasicLeaves(worldIn, rand, pos, tree, notify, height);
	}
	
	private void generateEllipsoidTree(World worldIn, Random rand, BlockPos pos, TreeType tree, boolean notify, int height) {
		generateEllipsoidTree(worldIn, rand, pos, tree, notify, height, DEFAULT_BREADTHS);
	}

	/**
	 * Generates a tree trunk with an ellipsoidal leaf cone. By default, the canopy is 8 blocks tall.
	 */
	private void generateEllipsoidTree(World worldIn, Random rand, BlockPos pos, TreeType tree, boolean notify, int height, double[] breadths) {
		generateBasicTrunk(worldIn, pos, tree, notify, height);
		generateEllipsoidLeaves(worldIn, rand, pos, tree, notify, height, breadths);
	}
	
	/**
	 * Generates a single block tower of a given height.
	 */
	private void generateBasicTrunk(World worldIn, BlockPos basePos, TreeType tree, boolean notify, int height) {
		for (int i = 0; i < height; i++) {
			BlockPos upN = basePos.up(i);
			IBlockState state = worldIn.getBlockState(upN);
			if (state.getBlock().isAir(state, worldIn, upN)) {
				//setBlockAndNotify(worldIn, basePos.up(i), tree.log, notify);
				setBlockAndNotify(worldIn, basePos.up(i), ModBlocks.BLOCK_SMALL_WOOD.getDefaultState().withProperty(BlockSmallWood.DIAMETER, BlockSmallWood.EnumDiameter.EIGHT), notify);
			}
		}
	}
	
	// Testing; creates a tree with a thinner base. Uses the ash texture.
	private void generateBasicTrunkTest(World worldIn, BlockPos basePos, IBlockState blockState, boolean notify, int height) {
		for (int i = 0; i < height; i++) {
			BlockPos upN = basePos.up(i);
			IBlockState state = worldIn.getBlockState(upN);
			if (state.getBlock().isAir(state, worldIn, upN)) {
				//setBlockAndNotify(worldIn, basePos.up(i), tree.log, notify);
				setBlockAndNotify(worldIn, basePos.up(i), blockState, notify);
			}
		}
	}
	
	/**
	 * Generates a vanilla tree-like poof of leaves.
	 */
	private void generateBasicLeaves(World worldIn, Random rand, BlockPos basePos, TreeType tree, boolean notify, int height) {
		for (int y = basePos.getY() + height - 3; y <= basePos.getY() + height; y++) {
			int posFromBaseOfLeaves = y - (basePos.getY() + height);
			int breadth = 1 - posFromBaseOfLeaves / 2;
			for (int x = basePos.getX() - breadth; x <= basePos.getX() + breadth; x++) {
				int xOffset = x - basePos.getX();
				for (int z = basePos.getZ() - breadth; z <= basePos.getZ() + breadth; z++) {
					int zOffset = z - basePos.getZ();
					
					// Vanilla Minecraft leaf poof: bottom layer is full, more scattered as it gets higher.
					if (Math.abs(xOffset) != breadth || Math.abs(zOffset) != breadth || rand.nextInt(2) != 0 && posFromBaseOfLeaves != 0) {
						BlockPos pos = new BlockPos(x, y, z);
						IBlockState state = worldIn.getBlockState(pos);
						
						if (state.getMaterial() == Material.VINE || state.getMaterial() == Material.AIR) {
							setBlockAndNotify(worldIn, pos, tree.leaf, notify);
						}
					}
				}
			}
		}
	}
	
	private void generateEllipsoidLeaves(World worldIn, Random rand, BlockPos basePos, TreeType tree, boolean notify, int height) {
		generateEllipsoidLeaves(worldIn, rand, basePos, tree, notify, height, DEFAULT_BREADTHS);
	}
	
	// Creates an ellipsoidal poof of leaves.
	private void generateEllipsoidLeaves(World worldIn, Random rand, BlockPos basePos, TreeType tree, boolean notify, int height, double[] breadths) {
		
		for (int y = basePos.getY() + height - (breadths.length - 3); y <= basePos.getY() + height + 1; y++) {
			int index = y - basePos.getY() - height + breadths.length - 3;
			double breadth = breadths[index];
			double halfBreadth = breadth / 2;
			
			for (double x = basePos.getX() - breadth; x <= basePos.getX() + breadth; x++) {
				double xOffset = x - basePos.getX();
				for (double z = basePos.getZ() - breadth; z <= basePos.getZ() + breadth; z++) {
					double zOffset = z - basePos.getZ();
					
					double distance = (xOffset * xOffset) + (zOffset * zOffset);
					if (distance <= halfBreadth * halfBreadth && (distance >= 1 || index >= breadths.length - 3)) {
						
						BlockPos pos = new BlockPos(x, y, z);
						IBlockState state = worldIn.getBlockState(pos);

						if (state.getMaterial() == Material.VINE || state.getMaterial() == Material.AIR) {
							setBlockAndNotify(worldIn, pos, tree.leaf, notify);
						}
					}
				}
			}
		}
	}
	
	private void setBlockAndNotify(World world, BlockPos pos, IBlockState state, boolean notify) {
        if (notify){
            world.setBlockState(pos, state, 3);
        } else {
        	world.setBlockState(pos, state, 18);
        }
	}
}
