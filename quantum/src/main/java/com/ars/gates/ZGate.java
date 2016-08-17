package com.ars.gates;

public class ZGate implements IGate {
	private static final double[][] GATE_MATRIX = { { 1, 0 }, { 0, -1 } };

	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
