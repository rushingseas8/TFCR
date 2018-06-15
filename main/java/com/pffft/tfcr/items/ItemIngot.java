package com.pffft.tfcr.items;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.item.Item;

public class ItemIngot extends Item {

	public String name;
	
	public ItemIngot(String name) {
		this.name = name;
		setUnlocalizedName("ingot_" + name);
		setRegistryName(TFCR.MODID, "ingot/ingot_" + name);
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_ORES);
	}
	
}
