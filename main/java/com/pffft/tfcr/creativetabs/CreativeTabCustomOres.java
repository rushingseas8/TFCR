package com.pffft.tfcr.creativetabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import static com.pffft.tfcr.init.ModItems.ITEM_COPPER_ORE;

public class CreativeTabCustomOres extends CreativeTabs {

	public static final String name = "tab_custom_ores";
	
	public CreativeTabCustomOres() {
		super(name);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ITEM_COPPER_ORE);
	}

}
