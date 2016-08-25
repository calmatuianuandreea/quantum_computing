package com.ars.qubits;

import com.ars.complexnumbers.ComplexNumber;

public class QubitMinus extends Qubit {

	public QubitMinus() {
		super(new ComplexNumber(1.0 / Math.sqrt(2), 0.0), new ComplexNumber(-1.0 / Math.sqrt(2), 0.0));
	}

}
