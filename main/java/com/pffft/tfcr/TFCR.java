package com.pffft.tfcr;


import com.pffft.tfcr.blocks.TileEntityFirepit;
import com.pffft.tfcr.gui.GuiHandler;
import com.pffft.tfcr.init.ModColorManager;

import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
    	ModColorManager.registerBlockColors();
    }
}
