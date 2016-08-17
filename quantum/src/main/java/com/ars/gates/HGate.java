package com.ars.gates;

public class HGate implements IGate {
	private static final double SQRT_OF_2 = Math.sqrt(2.0);
	private static final double[][] GATE_MATRIX = { { 1 / SQRT_OF_2, 1 / SQRT_OF_2 },
			{ 1 / SQRT_OF_2, -1 / SQRT_OF_2 } };

	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}
}
