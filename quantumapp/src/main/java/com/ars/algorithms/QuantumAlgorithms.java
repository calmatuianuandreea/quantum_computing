package com.ars.algorithms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ars.gates.GateProducer;
import com.ars.gates.GatesAbstractFactory;

public abstract class QuantumAlgorithms {
	protected double[][]			oracle;
	protected GatesAbstractFactory	gateFactory			= GateProducer.getGateFactory();
	private static final Logger		QUANTUM_ALGO_LOGGER	= LogManager.getLogger(QuantumAlgorithms.class);

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

	public Logger getLogger() {
		return QUANTUM_ALGO_LOGGER;
	}

}
