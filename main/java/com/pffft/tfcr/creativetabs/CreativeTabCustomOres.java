package com.pffft.tfcr.creativetabs;

import com.pffft.tfcr.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCustomOres extends CreativeTabs {

	public static final String name = "tab_custom_ores";
	
	public CreativeTabCustomOres() {
		super(name);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.oresList[0]);
	}

}
