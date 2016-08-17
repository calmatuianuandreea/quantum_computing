package com.ars.gates;

public class GateProducer {

	public static GatesAbstractFactory getGateFactory() {
		return new GateFactory();
	}
}
