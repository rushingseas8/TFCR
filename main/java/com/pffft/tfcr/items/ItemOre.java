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
import scala.tools.nsc.interpreter.IMain.StrippingTruncatingWriter;

public class ItemOre extends Item implements ItemInventoryRegisterer{
	private int meltingTemp;
	private String name;
	private Richness richness;
	
	public ItemOre(String name, int meltingTemp, Richness richness) {
		this.name = name;
		this.richness = richness;
		setUnlocalizedName("ore_" + name);
		setRegistryName(TFCR.MODID, "ore_" + name);
		setCreativeTab(ModCreativeTabs.CREATIVE_TAB_CUSTOM_ORES);
		
		this.meltingTemp = meltingTemp;
	}
	
	@Override
	public void registerSelf(ModelRegistryEvent event) {
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
