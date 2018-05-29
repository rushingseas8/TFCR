package com.pffft.tfcr.items;

import org.apache.commons.io.monitor.FileAlterationListener;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class ItemOre extends Item implements ItemInventoryRegisterer{
	private int meltingTemp;
	private final int MAX_DATA_VALUES = 4;
	
	public ItemOre(String name, int meltingTemp) {
		setUnlocalizedName("ore_" + name);
		setRegistryName(TFCR.MODID, "ore_" + name);
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_ORES);
		
		//Support for richness of ores.
		setHasSubtypes(true);
		setMaxDamage(0);
		
		this.meltingTemp = meltingTemp;
	}
	
	@Override
	public void registerSelf(ModelRegistryEvent event) {
		for (int i = 0; i < MAX_DATA_VALUES; i++)
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(getRegistryName() + "_" + i, "inventory"));
	}
}
