package com.pffft.tfcr.creativetabs;

import com.pffft.tfcr.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCustomBlocks extends CreativeTabs {

	public static final String name = "tab_custom_blocks";
	
	public CreativeTabCustomBlocks() {
		super(name);
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.WOOD_ASH);
	}

}
