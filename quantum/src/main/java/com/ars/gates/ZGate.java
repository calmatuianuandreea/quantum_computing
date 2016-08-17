package com.ars.gates;

/**
 * 
 * Implements the Pauli-Z Gate.
 *
 */
public class ZGate implements IGate {
	/**
	 * Matrix corresponding to a Pauli-Z Gate.
	 */
	private static final double[][] GATE_MATRIX = { { 1, 0 }, { 0, -1 } };

	/**
	 * Return the 2D array corresponding to a Pauli-Z gate.
	 * @return double[][] the corresponding 2D array 
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
