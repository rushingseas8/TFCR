package com.pffft.tfcr.items;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.init.ModCreativeTabs;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class ItemOre extends Item implements IItemSelfRegister {
	private int meltingTemp;
	private String name;
	private Richness richness;
	
	public ItemOre(String name, int meltingTemp, Richness richness) {
		this.name = name;
		this.richness = richness;
		setUnlocalizedName("ore_" + name);
		setRegistryName(TFCR.MODID, "ore/ore_" + name);
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_ORES);
		
		this.meltingTemp = meltingTemp;
	}
	
	@Override
	public void registerRenders(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
	
	public enum Richness {
		POOR, SMALL, NORMAL, RICH;
		
		public String toString() {
			String toReturn = "Ores/";
			switch (this) {
			case POOR: toReturn += "Poor/";
			case SMALL: toReturn += "Small/";
			case NORMAL: toReturn += "Normal/";
			case RICH: toReturn += "Rich/";
			}
			return toReturn;
		}
	}
}
