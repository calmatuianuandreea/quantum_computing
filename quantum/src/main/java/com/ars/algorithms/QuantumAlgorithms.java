package com.ars.algorithms;



import com.ars.gates.GateProducer;
import com.ars.gates.GatesAbstractFactory;
import com.ars.qubits.Qubit;

public abstract class QuantumAlgorithms {
	protected double[][] oracle;
	protected Qubit resultQubit;
	protected GatesAbstractFactory gateFactory = GateProducer.getGateFactory();


	public QuantumAlgorithms() {

	}

	public QuantumAlgorithms(double[][] oracle) {
		this.oracle = oracle;
	}

	public void setOracle(double[][] oracle) {
		this.oracle = oracle;
	}

	public abstract void init();

	public abstract void run();

	public abstract void measure();


}
