package com.pffft.tfcr.init;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.blocks.ISelfRegister;
import com.pffft.tfcr.data.MetalType;
import com.pffft.tfcr.data.OreType;
import com.pffft.tfcr.items.IItemSelfRegister;
import com.pffft.tfcr.items.ItemIngot;
import com.pffft.tfcr.items.ItemOre;
import com.pffft.tfcr.items.ItemOre.Richness;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=TFCR.MODID)
public class ModItems {

	public static Item[] oresList = 
		(Arrays.stream(OreType.values()).map(ore -> new ItemOre(ore.getName() + "_normal", 0, Richness.NORMAL)).toArray(Item[]::new));
	
	public static Item[] ingotsList =
		(Arrays.stream(MetalType.values()).map(metal -> new ItemIngot(metal.getName())).toArray(Item[]::new));

	// List of all items we're keeping track of. Automatically registers them.
	public static Item[] itemsList = ArrayUtils.addAll(oresList, ingotsList);

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (int i = 0; i < itemsList.length; i++) {
			System.out.println("Registering item: " + itemsList[i].getRegistryName());
			if (itemsList[i] instanceof IItemSelfRegister) {
				((IItemSelfRegister)itemsList[i]).registerItem(event, itemsList[i]);
			} else {
				event.getRegistry().register(itemsList[i]);
			}
		}
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (int i = 0; i < itemsList.length; i++) {
			if (itemsList[i] instanceof ISelfRegister) {
				((ISelfRegister)itemsList[i]).registerRenders(event);
			} else {
				ModelLoader.setCustomModelResourceLocation(itemsList[i], 0, new ModelResourceLocation( itemsList[i].getRegistryName(), "inventory"));
			}
		}
	}
}
