package com.pffft.tfcr.items;

import com.pffft.tfcr.TFCR;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ItemOre extends Item {
	private int meltingTemp;
	
	public ItemOre(String name, int meltingTemp) {
		setUnlocalizedName("ore_" + name);
		setRegistryName(TFCR.MODID, "ore_" + name);
		setCreativeTab(CreativeTabs.MISC);
		
		this.meltingTemp = meltingTemp;
	}
	
	private void registerSelf(String name, int maxDataValues) {

		ResourceLocation[] locations = new ResourceLocation[maxDataValues];
		for (int i = 0; i < maxDataValues; i++) {
			locations[i] = new ResourceLocation(TFCR.MODID + ":" + name + "_" + i);
		}
		
		ItemMeshDefinition def = new ItemMeshDefinition() {
			
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				int damage = stack.getItemDamage();
				if (damage > 0 && damage <= maxDataValues) {
					return (ModelResourceLocation) locations[damage];
				}
				return null;
			}
		};
		ModelLoader.setCustomMeshDefinition(this, def);
		ModelBakery.registerItemVariants(this, locations);
	}
}
