package com.pffft.tfcr.items;

import com.pffft.tfcr.blocks.ISelfRegister;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public interface IItemSelfRegister extends ISelfRegister {
	
	/**
	 * Register this item yourself. See ModBlocks or ModItems (registerX) for default behavior.
	 * 
	 * @param event The registration event.
	 * @param item The item that is to be registered. Usually same as "this" for classes
	 * 	implementing this interface; same as "new ItemBlock(this)" for Blocks.
	 */
	public default void registerItem(RegistryEvent.Register<Item> event, Item item) {
		event.getRegistry().register(item);
	}
}
