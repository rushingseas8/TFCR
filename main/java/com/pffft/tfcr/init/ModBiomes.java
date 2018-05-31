package com.pffft.tfcr.init;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.biomes.BiomeTFCRBase;
import com.pffft.tfcr.biomes.BiomeTFCRForest;
import com.pffft.tfcr.biomes.BiomeTFCRPlains;
import com.pffft.tfcr.biomes.BiomeTFCRSnowWasteland;
import com.pffft.tfcr.worldgen.WorldTypeTFCR;

import net.minecraft.world.WorldType;
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
	
	public static final WorldTypeTFCR wt =  new WorldTypeTFCR();
	
	public static final BiomeTFCRPlains BIOME_TFCR_PLAINS = new BiomeTFCRPlains();
	public static final BiomeTFCRForest BIOME_TFCR_FOREST = new BiomeTFCRForest();
	public static final BiomeTFCRSnowWasteland BIOME_TFCR_SNOW_WASTELAND = new BiomeTFCRSnowWasteland();
	
	private static BiomeTFCRBase[] biomesList = new BiomeTFCRBase[] {
		BIOME_TFCR_PLAINS,
		BIOME_TFCR_FOREST,
		BIOME_TFCR_SNOW_WASTELAND
	};
	
	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		//removeOtherBiomes();
		
		for (int i = 0; i < biomesList.length; i++) {
			event.getRegistry().register(biomesList[i]);
			//BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(biomesList[i], 10));
			//BiomeDictionary.addTypes(biomesList[i], BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.DRY);
			BiomeManager.addBiome(biomesList[i].biomeType, new BiomeEntry(biomesList[i], biomesList[i].weight));
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
