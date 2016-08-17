package com.ars.gates;

/**
 * 
 * Implement the Pauli-X Gate.
 *
 */
public class XGate implements IGate {
	/**
	 * Matrix corresponding to a Pauli-X Gate.
	 */
	private static final double[][] GATE_MATRIX = { { 0, 1 }, { 1, 0 } };

	/**
	 * Return the 2D array corresponding to a Pauli-X gate.
	 * @return double[][] the corresponding 2D array 
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
