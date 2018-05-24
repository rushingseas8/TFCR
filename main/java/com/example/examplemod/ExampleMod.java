package com.example.examplemod;

import com.pffft.tfcr.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod(
		modid = ExampleMod.MODID,
		name = ExampleMod.NAME,
		version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "tfcr";
    public static final String NAME = "TerraFirmaCraft Reloaded";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	System.out.println(MODID + ":preinit");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	System.out.println(MODID + ":init");
    }
}
