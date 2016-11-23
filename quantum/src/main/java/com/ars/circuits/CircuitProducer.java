package com.ars.circuits;

/*
 * Implementation of Circuit Producer
 */

public class CircuitProducer {
	
	public static CircuitsAbstractFactory getCircuitFactory(){
		return new CircuitFactory();
	}

}
