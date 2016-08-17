package com.ars.gates;
/**
 * 
 * Implements the Hadamard Gate
 *
 */
public class HGate implements IGate {
	private static final double SQRT_OF_2 = Math.sqrt(2.0);
	/**
	 * Matrix corresponding to a Hadamard Gate.
	 */
	private static final double[][] GATE_MATRIX = { { 1 / SQRT_OF_2, 1 / SQRT_OF_2 },
			{ 1 / SQRT_OF_2, -1 / SQRT_OF_2 } };
	
	/**
	 * Return the 2D array corresponding to a Hadamard gate.
	 * @return double[][] the corresponding 2D array 
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}
}
