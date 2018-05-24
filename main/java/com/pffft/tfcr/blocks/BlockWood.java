package com.pffft.tfcr.blocks;

import com.pffft.tfcr.TFCR;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockWood extends Block {
	public BlockWood(String name) {
		super(Material.WOOD);
		setUnlocalizedName("wood_" + name);
		setRegistryName(TFCR.MODID, "wood_" + name);
	}
}
