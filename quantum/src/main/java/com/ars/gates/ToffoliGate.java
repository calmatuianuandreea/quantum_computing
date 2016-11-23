package com.ars.gates;

/**
 * Implements Toffoli Gate
 * @author Dacian
 *
 */

public class ToffoliGate implements IGate{
	
	private static final double[][] GATE_MATRIX = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 } };

	@Override
	public double[][] getUnitaryMatrix() {
		// TODO Auto-generated method stub
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
