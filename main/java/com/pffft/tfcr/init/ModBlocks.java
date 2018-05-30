package com.pffft.tfcr.init;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.impl.cookie.PublicSuffixFilter;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.blocks.BlockBarrel;
import com.pffft.tfcr.blocks.BlockFirepit;
import com.pffft.tfcr.blocks.BlockLeaves;
import com.pffft.tfcr.blocks.BlockWood;

import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLog;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=TFCR.MODID)
public class ModBlocks {

	/**
	 * Wood block declarations
	 */
	public static final BlockWood WOOD_ACACIA = new BlockWood("acacia");
	public static final BlockWood WOOD_ASH = new BlockWood("ash");
	public static final BlockWood WOOD_ASPEN = new BlockWood("aspen");
	public static final BlockWood WOOD_BLACKWOOD = new BlockWood("blackwood");
	public static final BlockWood WOOD_CHESTNUT = new BlockWood("chestnut");
	public static final BlockWood WOOD_DOUGLAS_FIR = new BlockWood("douglas_fir");
	public static final BlockWood WOOD_HICKORY = new BlockWood("hickory");
	public static final BlockWood WOOD_KAPOK = new BlockWood("kapok");
	public static final BlockWood WOOD_MAPLE = new BlockWood("maple");
	public static final BlockWood WOOD_PALM = new BlockWood("palm");
	public static final BlockWood WOOD_ROSEWOOD = new BlockWood("rosewood");
	public static final BlockWood WOOD_SEQUOIA = new BlockWood("sequoia");
	public static final BlockWood WOOD_SYCAMORE = new BlockWood("sycamore");
	public static final BlockWood WOOD_WHITE_CEDAR = new BlockWood("white_cedar");
	public static final BlockWood WOOD_WHITE_ELM = new BlockWood("white_elm");
	public static final BlockWood WOOD_WILLOW = new BlockWood("willow");
	public static final BlockWood[] WOODS = new BlockWood[] {
		WOOD_ACACIA,
		WOOD_ASH,
		WOOD_ASPEN,
		WOOD_BLACKWOOD,
		WOOD_CHESTNUT,
		WOOD_DOUGLAS_FIR,
		WOOD_HICKORY,
		WOOD_KAPOK,
		WOOD_MAPLE,
		WOOD_PALM,
		WOOD_ROSEWOOD,
		WOOD_SEQUOIA,
		WOOD_SYCAMORE,
		WOOD_WHITE_CEDAR,
		WOOD_WHITE_ELM,
		WOOD_WILLOW
	};

	/**
	 * Leaf block declarations
	 */
	public static final BlockLeaves LEAVES_ACACIA = new BlockLeaves("acacia");
	public static final BlockLeaves LEAVES_ASH = new BlockLeaves("ash");
	public static final BlockLeaves LEAVES_ASPEN = new BlockLeaves("aspen");
	public static final BlockLeaves LEAVES_BLACKWOOD = new BlockLeaves("blackwood");
	public static final BlockLeaves LEAVES_CHESTNUT = new BlockLeaves("chestnut");
	public static final BlockLeaves LEAVES_DOUGLAS_FIR = new BlockLeaves("douglas_fir");
	public static final BlockLeaves LEAVES_HICKORY = new BlockLeaves("hickory");
	public static final BlockLeaves LEAVES_KAPOK = new BlockLeaves("kapok");
	public static final BlockLeaves LEAVES_MAPLE = new BlockLeaves("maple");
	public static final BlockLeaves LEAVES_PALM = new BlockLeaves("palm");
	public static final BlockLeaves LEAVES_ROSEWOOD = new BlockLeaves("rosewood");
	public static final BlockLeaves LEAVES_SEQUOIA = new BlockLeaves("sequoia");
	public static final BlockLeaves LEAVES_SYCAMORE = new BlockLeaves("sycamore");
	public static final BlockLeaves LEAVES_WHITE_CEDAR = new BlockLeaves("white_cedar");
	public static final BlockLeaves LEAVES_WHITE_ELM = new BlockLeaves("white_elm");
	public static final BlockLeaves LEAVES_WILLOW = new BlockLeaves("willow");
	public static final BlockLeaves[] LEAVES = new BlockLeaves[] {
		LEAVES_ACACIA,
		LEAVES_ASH,
		LEAVES_ASPEN,
		LEAVES_BLACKWOOD,
		LEAVES_CHESTNUT,
		LEAVES_DOUGLAS_FIR,
		LEAVES_HICKORY,
		LEAVES_KAPOK,
		LEAVES_MAPLE,
		LEAVES_PALM,
		LEAVES_ROSEWOOD,
		LEAVES_SEQUOIA,
		LEAVES_SYCAMORE,
		LEAVES_WHITE_CEDAR,
		LEAVES_WHITE_ELM,
		LEAVES_WILLOW
	};
	
	public static final BlockFirepit BLOCK_FIREPIT = new BlockFirepit();
	public static final BlockBarrel BLOCK_BARREL = new BlockBarrel();
	
	// List of all blocks we're keeping track of. Automatically registers them.
	private static Block[] blocksList = new Block[] {
			BLOCK_BARREL,
			BLOCK_FIREPIT
	};
	
	// Adds in all of the lists of items we have.
	static {
		blocksList = ArrayUtils.addAll(blocksList, WOODS);
		blocksList = ArrayUtils.addAll(blocksList, LEAVES);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Block> event) {
		for (int i = 0; i < blocksList.length; i++) {
			event.getRegistry().register(blocksList[i]);
		}
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		for (int i = 0; i < blocksList.length; i++) {
			ItemBlock newItemBlock = new ItemBlock(blocksList[i]);
			newItemBlock.setRegistryName(blocksList[i].getRegistryName());
			
			event.getRegistry().register(newItemBlock);
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (int i = 0; i < blocksList.length; i++) {
			Item inventoryItem = Item.getItemFromBlock(blocksList[i]);
			ModelLoader.setCustomModelResourceLocation(inventoryItem, 0, new ModelResourceLocation( inventoryItem.getRegistryName(), "inventory"));
		}
	}
}
