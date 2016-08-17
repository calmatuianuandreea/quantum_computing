package com.ars.gates;

public class XGate implements IGate {
	private static final double[][] GATE_MATRIX = { { 0, 1 }, { 1, 0 } };

	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
