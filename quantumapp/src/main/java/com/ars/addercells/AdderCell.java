package com.ars.addercells;

import java.util.ArrayList;
import java.util.List;

import com.ars.gates.EGateTypes;
import com.ars.gates.GateProducer;
import com.ars.gates.GatesAbstractFactory;
import com.ars.gates.IGate;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitZero;

public abstract class AdderCell {
	private GatesAbstractFactory	gateFactory;
	protected Qubit					qubitX;
	protected Qubit					qubitY;
	protected Qubit					scratchQubit;
	protected IGate					gateCNot;
	protected double[][]			gateCCNot	= { { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 0, 0 },
	        { 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 },
	        { 0, 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 1, 0 }, };
	List<Qubit>						result		= new ArrayList<>();

	protected void initialize() {
		gateFactory = GateProducer.getGateFactory();
		gateCNot = gateFactory.getGate(EGateTypes.E_CNotGate);
		scratchQubit = new QubitZero();
	}

	protected abstract void add();

	public abstract AdderCell init();

	public abstract void setInput(Qubit... q) throws IllegalArgumentException;

	public List<Qubit> getResult() {
		add();
		return result;
	}
}
