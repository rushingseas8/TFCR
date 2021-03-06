package com.pffft.tfcr.data;

public class BellCurve {
	
	public double mean;
	public double stdDev;
	
	/**
	 * Holds the bell curve for a given range of values without needing to recompute them.
	 * This curve is not normalized; instead it is set so that the value at the mean is 1,
	 * rather than the area under the curve being equal to one.
	 * 
	 * @param min Two standard deviations left.
	 * @param max Two standard deviations right.
	 */
	public BellCurve(int min, int max) {
		stdDev = Math.sqrt((max - min) / 2.0);
		mean = (max + min) / 2.0;
	}
	
	/**
	 * Compute the value of the bell curve at the point x.
	 * @return
	 */
	public double getValue(double x) {
		return Math.pow(Math.E, -((x - mean) * (x - mean) / (2 * stdDev * stdDev)));
	}
}
