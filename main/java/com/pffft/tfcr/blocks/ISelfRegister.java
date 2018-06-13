package com.pffft.tfcr.blocks;

import net.minecraftforge.client.event.ModelRegistryEvent;

public interface ISelfRegister {
	
	/**
	 * Register this object's renders yourself. Used for implementing visual
	 * variations based on metadata in blocks and items.
	 * 
	 * @param event The registration event.
	 */
	public void registerRenders(ModelRegistryEvent event);
}
