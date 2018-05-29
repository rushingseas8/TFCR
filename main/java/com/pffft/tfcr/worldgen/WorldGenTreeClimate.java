package com.pffft.tfcr.worldgen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.text.Position;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.data.BellCurve;
import com.pffft.tfcr.data.TreeType;

import akka.actor.FSM.State;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.IPlantable;

public class WorldGenTreeClimate extends WorldGenerator {

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
		for (int i = 0; i < TreeType.trees.length; i++) {
			TreeType tree = TreeType.trees[i];
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
				height = 6 + rand.nextInt(5);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
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
			case "rosewood":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "sequoia":
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
				height = 4 + rand.nextInt(2);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "white_elm":
				height = 4 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			case "willow":
				height = 5 + rand.nextInt(3);
				generateBasicTree(worldIn, rand, base, tree, notify, height);
				
				return true;
			default:
				return false;
		}
	}
	
	/**
	 * Helper function for generating a basic trunk + leaves.
	 */
	private void generateBasicTree(World worldIn, Random rand, BlockPos pos, TreeType tree, boolean notify, int height) {
		generateBasicTrunk(worldIn, pos, tree, notify, height);
		generateBasicLeaves(worldIn, rand, pos, tree, notify, height);
	}
	
	/**
	 * Generates a single block tower of a given height.
	 */
	private void generateBasicTrunk(World worldIn, BlockPos basePos, TreeType tree, boolean notify, int height) {
		for (int i = 0; i < height; i++) {
			BlockPos upN = basePos.up(i);
			IBlockState state = worldIn.getBlockState(upN);
			if (state.getBlock().isAir(state, worldIn, upN)) {
				setBlockAndNotify(worldIn, basePos.up(i), tree.log, notify);
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
	
	private void setBlockAndNotify(World world, BlockPos pos, IBlockState state, boolean notify) {
        if (notify){
            world.setBlockState(pos, state, 3);
        } else {
        	world.setBlockState(pos, state, 18);
        }
	}
}
