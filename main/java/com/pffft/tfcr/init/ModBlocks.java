package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.blocks.BlockFirepit;
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
	
	public static final BlockFirepit BLOCK_FIREPIT = new BlockFirepit();
	
	// List of all blocks we're keeping track of. Automatically registers them.
	private static Block[] blocksList = new Block[] {
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
			WOOD_WILLOW,
			BLOCK_FIREPIT
	};
	
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
