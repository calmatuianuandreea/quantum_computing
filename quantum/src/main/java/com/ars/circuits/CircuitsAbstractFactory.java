package com.ars.circuits;

/*
 * Implementation of a Circuit Abstrtact Factory
 */

public abstract class CircuitsAbstractFactory {
	
	public abstract ICircuit getCircuit(CircuitTypes id);

}
