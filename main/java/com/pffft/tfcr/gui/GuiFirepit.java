package com.pffft.tfcr.gui;

import java.awt.Color;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import com.pffft.tfcr.TFCR;
import com.pffft.tfcr.blocks.ContainerFirepit;
import com.pffft.tfcr.blocks.TileEntityFirepit;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class GuiFirepit extends GuiContainer {
	
	private static final ResourceLocation firepitGUITexture = new ResourceLocation(TFCR.MODID, "textures/gui/firepit.png");
	
	public GuiFirepit(InventoryPlayer ip, TileEntityFirepit tef) {
		super(new ContainerFirepit(ip, tef));
		// TODO Auto-generated constructor stub
	}

	public static final int GUI_ID = 1;
	
	/**
	 * Call your GUI drawing logic in here.
	 * Note: the integer "color" is in the form 0xAARRGGBB, with 00-FF = none-all.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub

		//super.drawScreen(mouseX, mouseY, partialTicks);
		
		int middleX = width / 2;
		int middleY = height / 2;
		
		int marginHorizontal = (width - xSize) / 2;
        int marginVertical = (height - ySize) / 2;
        
		//drawCenteredString(fontRenderer, "Hello world", middleX, middleY, 0x0000FF00);
		mc.getTextureManager().bindTexture(firepitGUITexture);
		//drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, 256, 256);
		drawModalRectWithCustomSizedTexture(marginHorizontal, marginVertical, 0, 0, xSize, ySize, 256, 256);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		// TODO Auto-generated method stub
	}
}
