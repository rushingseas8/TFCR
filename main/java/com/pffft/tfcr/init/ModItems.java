package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.items.ItemInventoryRegisterer;
import com.pffft.tfcr.items.ItemOre;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=TFCR.MODID)
public class ModItems {
	
	// A custom Creative Tab for storing all of our new ores
	public static final CreativeTabs TAB_CUSTOM_ORES = (new CreativeTabs("tab_custom_ores") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ITEM_COPPER_ORE);
		}
		
	});
	
	public static final ItemOre ITEM_COPPER_ORE = new ItemOre("copper", 2);
	public static final ItemOre ITEM_IRON_ORE = new ItemOre("iron", 3);
	public static final ItemOre ITEM_BISMUTH_ORE = new ItemOre("bismuth", 0);

	// List of all items we're keeping track of. Automatically registers them.
	private static Item[] itemsList = new Item[]{
		ITEM_COPPER_ORE,
		ITEM_IRON_ORE,
		ITEM_BISMUTH_ORE
	};
	
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (int i = 0; i < itemsList.length; i++) {
			event.getRegistry().register(itemsList[i]);
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (int i = 0; i < itemsList.length; i++) {
			if (itemsList[i] instanceof ItemInventoryRegisterer)
				((ItemInventoryRegisterer) itemsList[i]).registerSelf(event);
			else
				ModelLoader.setCustomModelResourceLocation(itemsList[i], 0, new ModelResourceLocation( itemsList[i].getRegistryName(), "inventory"));
		}
	}
}
