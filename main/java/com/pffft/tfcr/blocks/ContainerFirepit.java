package com.pffft.tfcr.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerFirepit extends Container {

	private InventoryPlayer inventoryPlayer;
	private TileEntityFirepit tileEntityFirepit;
	
	public ContainerFirepit(InventoryPlayer ip, TileEntityFirepit tef) {
		inventoryPlayer = ip;
		tileEntityFirepit = tef;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

}
