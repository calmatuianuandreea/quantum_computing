package com.ars.gates;
/**
 * Implements the CNOT Gate
 * 
 *
 */
public class CNotGate implements IGate {
	/**
	 * Matrix corresponding to a CNOT Gate.
	 */
	private static final double[][] GATE_MATRIX = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 } };

	/**
	 * Return the 2D array corresponding to a CNOT gate.
	 * @return double[][] the corresponding 2D array 
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}