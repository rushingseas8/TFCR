package com.pffft.tfcr.init;

import com.example.examplemod.ExampleMod;
import com.pffft.tfcr.items.ItemCopperOre;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=ExampleMod.MODID)
public class ModItems {
	
	public static final ItemCopperOre ITEM_COPPER_ORE = new ItemCopperOre();
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(ITEM_COPPER_ORE);
	}
}
