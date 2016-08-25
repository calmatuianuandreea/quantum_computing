package com.ars.qubits;

import com.ars.complexnumbers.ComplexNumber;

public class QubitPlus extends Qubit {

	public QubitPlus() {
		super(new ComplexNumber(1.0 / Math.sqrt(2), 0.0), new ComplexNumber(1.0 / Math.sqrt(2), 0.0));
	}

}
