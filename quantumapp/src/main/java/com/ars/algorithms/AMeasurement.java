package com.ars.algorithms;

import com.ars.complexnumbers.ComplexNumber;
import com.ars.qubits.Qubit;

public abstract class AMeasurement {
	protected static final ComplexNumber[][] UNITY_MATRIX = {
			{ new ComplexNumber(1.0, 0.0), new ComplexNumber(0.0, 0.0) },
			{ new ComplexNumber(0.0, 0.0), new ComplexNumber(1.0, 0.0) } };
	protected ComplexNumber[][] M0 = null;
	protected ComplexNumber[][] M1 = null;

	protected int range;

	protected AMeasurement(int range) {
		this.range = range;
	}

	protected abstract void init();

	protected abstract Qubit performMeasurement();
}
