package com.pffft.tfcr.items;

import com.example.examplemod.ExampleMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCopperOre extends Item {
	
	public ItemCopperOre() {
		setUnlocalizedName("item.copperOre");
		setRegistryName(ExampleMod.MODID, "copperOre");
		setCreativeTab(CreativeTabs.MISC);
	}
}
