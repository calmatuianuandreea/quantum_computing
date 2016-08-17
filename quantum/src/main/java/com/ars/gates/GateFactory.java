package com.ars.gates;

public class GateFactory extends GatesAbstractFactory {

	public IGate getGate(EGateTypes id) {
		IGate gate = null;
		switch (id) {
		case E_HadamardGate:
			gate = new HGate();
			break;
		case E_XGate:
			gate = new XGate();
			break;
		case E_ZGate:
			gate = new ZGate();
			break;
		case E_CNotGate:
			gate = new CNotGate();
		}
		return gate;
	}
}
