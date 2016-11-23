package com.ars.gates;

/*
 * Implement the Symmetric Phase Shift Gate
 */

public class SymmetricPhaseShift implements IGate{

	/*
	 * Matrix corresponding to a Symmetric Phase Shift Gate
	 * 
	 */
	private static final double[][] GATE_MATRIX = {{1,0,0,0},
			                                       {0,1,0,0},
			                                       {0,0,1,0},
			                                       {0,0,0,-1}}; 
	/*
	 * Return the 4D array corresponding to Symmetric Phase Shift
	 * @return double[][] the corresponding 4D array
	 * @see com.ars.gates.IGate#getUnitaryMatrix()
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
