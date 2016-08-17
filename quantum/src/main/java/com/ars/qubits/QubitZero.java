package com.ars.qubits;

import com.ars.complexnumbers.ComplexNumber;

public class QubitZero extends Qubit {

	public QubitZero() {
		super(new ComplexNumber(1.0, 0.0), new ComplexNumber(0.0, 0.0));
	}

}
