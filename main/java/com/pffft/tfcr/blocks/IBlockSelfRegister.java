package com.pffft.tfcr.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockSelfRegister extends ISelfRegister {

	/**
	 * Register this block yourself. See ModBlocks (registerX) for default behavior.
	 * 
	 * @param event The registration event.
	 * @param block The block that is to be registered. Same as "this" for classes
	 * 	implementing this interface.
	 */
	public default void registerBlock(RegistryEvent.Register<Block> event, Block block) {
		event.getRegistry().register(block);
	}
}
