package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.biomes.BiomeTFCRPlains;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.BiomeBeach;
import net.minecraft.world.biome.BiomePlains;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=TFCR.MODID)
public class ModBiomes {
	
	public static final BiomeTFCRPlains testPlains = new BiomeTFCRPlains(new BiomeProperties(BiomeTFCRPlains.name));
	
	private static Biome[] biomesList = new Biome[] {
		testPlains
	};
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		//removeOtherBiomes();
		for (int i = 0; i < biomesList.length; i++) {
			event.getRegistry().register(biomesList[i]);
			BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(biomesList[i], 10));
			BiomeDictionary.addTypes(biomesList[i], BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
		}
	}
	
	private static void removeOtherBiomes() {
		for (BiomeManager.BiomeType type : BiomeManager.BiomeType.values()) {
			for (BiomeManager.BiomeEntry entry : BiomeManager.getBiomes(type)) {
				BiomeManager.removeBiome(type, entry);
			}
		}
	}
}
