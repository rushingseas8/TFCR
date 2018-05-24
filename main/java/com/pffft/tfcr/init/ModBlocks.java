package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;
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
	
	public static final BlockWood WOOD_ASH = new BlockWood("ash");
	
	// List of all blocks we're keeping track of. Automatically registers them.
	private static Block[] blocksList = new Block[] {
			WOOD_ASH
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
