package com.pffft.tfcr.gui;

import com.pffft.tfcr.blocks.ContainerFirepit;
import com.pffft.tfcr.blocks.TileEntityFirepit;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		if (te != null) {
			switch(ID) {
				case GuiFirepit.GUI_ID: 
					return te instanceof TileEntityFirepit ? new ContainerFirepit(player.inventory, (TileEntityFirepit)te) : null;
				default: return null;
			}	
		} else {
			System.out.println("Couldn't find a TileEntity at the position. Failed to get container.");
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(new BlockPos(x, y, z));
		
		if (te != null) {
			switch(ID) {
				case GuiFirepit.GUI_ID: 
					return te instanceof TileEntityFirepit ? new GuiFirepit(player.inventory, (TileEntityFirepit)te) : null;
				default: return null;
			}	
		} else {
			System.out.println("Couldn't find a TileEntity at the position. Failed to open GUI.");
			return null;
		}
	}
	
}
