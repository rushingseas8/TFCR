package com.pffft.tfcr.items;

import com.pffft.tfcr.TFCR;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemOre extends Item {
	
	public ItemOre(String name) {
		setUnlocalizedName("ore_" + name);
		setRegistryName(TFCR.MODID, "ore_" + name);
		setCreativeTab(CreativeTabs.MISC);
	}
}
