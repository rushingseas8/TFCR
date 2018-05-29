package com.pffft.tfcr;


import com.jcraft.jorbis.Block;
import com.pffft.tfcr.blocks.TileEntityFirepit;
import com.pffft.tfcr.data.TreeType;
import com.pffft.tfcr.gui.GuiHandler;
import com.pffft.tfcr.init.ModBiomes;
import com.pffft.tfcr.init.ModBlocks;
import com.pffft.tfcr.init.ModItems;

import net.minecraft.advancements.critereon.BredAnimalsTrigger.Instance;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@Mod(
		modid = TFCR.MODID,
		name = TFCR.NAME,
		version = TFCR.VERSION)
public class TFCR {
    public static final String MODID = "tfcr";
    public static final String NAME = "TerraFirmaCraft Reloaded";
    public static final String VERSION = "1.0";
    
    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static TFCR instance = null;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	System.out.println(MODID + ":preinit");
    	OBJLoader.INSTANCE.addDomain(MODID);
    	NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityFirepit.class, "tileEntityGUITest");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	System.out.println(MODID + ":init");
    }
}
