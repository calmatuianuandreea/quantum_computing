package com.ars.qubits;

import java.util.Arrays;

import com.ars.complexnumbers.ComplexNumber;

public class Qubit {

	protected ComplexNumber[] qubitVector;

	public Qubit(ComplexNumber no0, ComplexNumber no1) {
		qubitVector = new ComplexNumber[2];
		qubitVector[0] = no0;
		qubitVector[1] = no1;
	}

	public Qubit(ComplexNumber[] qubitVector) {
		this.qubitVector =Arrays.copyOf(qubitVector, qubitVector.length);
	}

	public ComplexNumber[] getQubit() {
		ComplexNumber[] copyOfQubitVector = qubitVector;
		return copyOfQubitVector;
	}

	@Override
	public String toString() {
		StringBuffer output=new StringBuffer();
		output.append("[ ");
		for (ComplexNumber i : qubitVector) {
			output.append(i);
			output.append(" ");
		}
		output.append("]");
		return output.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Qubit) {
			if (this.qubitVector.length != ((Qubit) o).getQubit().length) {
				return false;
			}
			for (int i = 0; i < this.qubitVector.length; i++) {
				if (this.qubitVector[i].equals(((Qubit) o).getQubit()[i])==false) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash += (this.qubitVector != null ? Arrays.hashCode(qubitVector) : 0);
		return hash;
	}
}
