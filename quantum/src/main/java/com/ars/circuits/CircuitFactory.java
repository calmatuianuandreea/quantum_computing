package com.ars.circuits;

/*
 * Implementation of a Circuit Factory
 * 
 */

public class CircuitFactory extends CircuitsAbstractFactory {

	@Override
	public ICircuit getCircuit(CircuitTypes id) {
		
		ICircuit circuit = null;
		switch (id) {
		case E_HalfAdderCell:
			circuit = new HalfAdderCell();
			break;
		}
		
		return circuit;

	}

}
