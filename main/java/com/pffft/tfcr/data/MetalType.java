package com.pffft.tfcr.data;

import net.minecraft.util.IStringSerializable;

public enum MetalType implements IStringSerializable {
	
	// Pure metal
	BISMUTH,
	COPPER,
	GOLD,
	LEAD,
	NICKEL,
	PIG_IRON,
	PLATINUM,
	SILVER,
	STEEL,
	TIN,
	WROUGHT_IRON,
	ZINC,
	
	// Alloys
	BISMUTH_BRONZE(new AlloyEntry[]{}),
	BLACK_BRONZE(new AlloyEntry[]{}),
	BRASS(new AlloyEntry[]{}),
	BRONZE(new AlloyEntry[]{new AlloyEntry(COPPER, 88, 92), new AlloyEntry(TIN, 8, 12)}),
	ROSE_GOLD(new AlloyEntry[]{}),
	STERLING_SILVER(new AlloyEntry[]{}),
	UNKNOWN(new AlloyEntry[]{});
	
	public String name;
	public boolean isAlloy;
	
	public AlloyEntry[] constituentMetals;

	private MetalType() {
		this(false, null);
	}
	
	private MetalType(AlloyEntry[] constituents) {
		this(true, constituents);
	}
	
	private MetalType(boolean isAlloy, AlloyEntry[] constituents) {
		this.name = name();
		this.isAlloy = isAlloy;
		this.constituentMetals = constituents;
	}

	@Override
	public String getName() {
		return name.toLowerCase();
	}
	
	private static class AlloyEntry {
		public MetalType metal;
		public int minAmount, maxAmount;
		
		public AlloyEntry(MetalType metal, int minValue, int maxValue) {
			this.metal = metal;
			this.minAmount = minValue;
			this.maxAmount = maxValue;
		}
	}
}
