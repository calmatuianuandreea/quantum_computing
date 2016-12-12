package com.ars.addercells;

import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public class HalfAdderCircuit extends AdderCell {

	public HalfAdderCircuit init() {
		super.initialize();
		return this;
	}

	@Override
	public void setInput(Qubit... q) throws IllegalArgumentException {
		if (q.length > 2 || q.length < 2) {
			throw new IllegalArgumentException("Exactly 2 parameters required !");
		}
		this.qubitX = q[0];
		this.qubitY = q[1];
	}

	protected void add() {
		Qubit carryQubit;
		Qubit sumQubit;
		carryQubit = QuantumOperations.entangle(qubitX, qubitY, scratchQubit);
		carryQubit = QuantumOperations.applyGate(carryQubit, gateCCNot);
		sumQubit = QuantumOperations.entangle(qubitX, qubitY);
		sumQubit = QuantumOperations.applyGate(sumQubit, gateCNot);
		result.add(qubitX);
		if (sumQubit.equals(QuantumOperations.entangle(new QubitZero(), new QubitZero()))
		        || sumQubit.equals(QuantumOperations.entangle(new QubitOne(), new QubitZero()))) {
			result.add(new QubitZero());
		} else {
			result.add(new QubitOne());
		}

		Qubit q0 = QuantumOperations.entangle(new QubitOne(), new QubitOne());
		q0 = QuantumOperations.entangle(q0, new QubitOne());
		if (carryQubit.equals(q0)) {
			result.add(new QubitOne());
		} else {
			result.add(new QubitZero());
		}
	}

}
