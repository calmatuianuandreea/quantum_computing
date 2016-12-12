package com.ars.addercells;

import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public class FullAdderCircuit extends AdderCell {
	private Qubit carryIn;

	public FullAdderCircuit init() {
		super.initialize();
		return this;
	}

	@Override
	public void setInput(Qubit... q) throws IllegalArgumentException {
		if (q.length > 3 || q.length < 3) {
			throw new IllegalArgumentException("Exactly 3 parameters required !");
		}
		this.qubitX = q[0];
		this.qubitY = q[1];
		this.carryIn = q[2];
	}

	@Override
	protected void add() {
		Qubit stageZero = QuantumOperations.entangle(qubitX, qubitY, scratchQubit);
		stageZero = QuantumOperations.applyGate(stageZero, gateCCNot);
		Qubit stageOne = QuantumOperations.entangle(qubitX, qubitY);
		stageOne = QuantumOperations.applyGate(stageOne, gateCNot);

		Qubit bufferStageZero = QuantumOperations.entangle(new QubitOne(), new QubitOne(), new QubitOne());
		if (stageZero.equals(bufferStageZero)) {
			scratchQubit = new QubitOne();
		} else {
			scratchQubit = new QubitZero();
		}
		if (stageOne.equals(QuantumOperations.entangle(new QubitZero(), new QubitZero()))
		        || stageOne.equals(QuantumOperations.entangle(new QubitOne(), new QubitZero()))) {
			qubitY = new QubitZero();
		} else {
			qubitY = new QubitOne();
		}
		Qubit stageThree = QuantumOperations.entangle(carryIn, qubitY, scratchQubit);
		stageThree = QuantumOperations.applyGate(stageThree, gateCCNot);

		if (stageThree.equals(QuantumOperations.entangle(new QubitOne(), new QubitOne(), new QubitOne()))) {
			scratchQubit = new QubitOne();
		} else {
			scratchQubit = new QubitZero();
		}
		result.add(carryIn);
		result.add(qubitX);
		result.add(qubitY);
		result.add(scratchQubit);
	}

}
