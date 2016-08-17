package com.ars.quantum.utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.EGateTypes;
import com.ars.gates.GateProducer;
import com.ars.gates.GatesAbstractFactory;
import com.ars.gates.IGate;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public class QuantumOperationsTest {
	private IGate gate;
	private GatesAbstractFactory factory;
	@Before
	public void setUp() throws Exception {
		factory = GateProducer.getGateFactory();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntangleWithTwoQubitsAllCombinations() {
		ComplexNumber[] expectedResult = new ComplexNumber[4];
		Qubit[] q = new Qubit[2];
		q[0] = new QubitZero();
		q[1] = new QubitOne();
		Qubit[] realResults = new Qubit[4];
		// prepare results
		int k = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				realResults[k++] = QuantumOperations.entangle(q[i], q[j]);
			}
		}
		// prepare expected results
		for (int i = 0; i < 4; i++) {
			// fill expected result for each testcase
			for (int j = 0; j < 4; j++) {
				if (i == j) {
					expectedResult[j] = new ComplexNumber(1, 0);
				} else {
					expectedResult[j] = new ComplexNumber(0, 0);
				}

			}
			assertEquals(true, realResults[i].equals(new Qubit(expectedResult)));

		}
	}
	
	@Test
	public void testEntangleWithThreeQubitsAllCombinations(){
		ComplexNumber[] expectedResult = new ComplexNumber[8];
		Qubit[] q = new Qubit[2];
		q[0] = new QubitZero();
		q[1] = new QubitOne();
		Qubit[] realResults = new Qubit[8];
		// prepare results
		int k = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for(int l=0;l<2;l++){
					List<Qubit> quList=new ArrayList<>();
					quList.add(q[i]);
					quList.add(q[j]);
					quList.add(q[l]);
					realResults[k++] = QuantumOperations.entangle(quList);
					
				}
			}
		}
		// prepare expected results
		for (int i = 0; i < 8; i++) {
			// fill expected result for each testcase
			for (int j = 0; j < 8; j++) {
				if (i == j) {
					expectedResult[j] = new ComplexNumber(1, 0);
				} else {
					expectedResult[j] = new ComplexNumber(0, 0);
				}

			}
			assertEquals(true, realResults[i].equals(new Qubit(expectedResult)));

		}
	}
	
	@Test
	public void testApplyXGate(){
		Qubit expectedResultQ0=new Qubit(new ComplexNumber(0,0.0),new ComplexNumber(1,0.0));
		Qubit expectedResultQ1=new Qubit(new ComplexNumber(1,0.0),new ComplexNumber(0,0.0));			
		Qubit q0 = new QubitZero();
		Qubit q1 = new QubitOne();
		gate= factory.getGate(EGateTypes.E_XGate);
		assertEquals(true, expectedResultQ0.equals(QuantumOperations.applyGate(q0, gate)));
		assertEquals(true, expectedResultQ1.equals(QuantumOperations.applyGate(q1, gate)));
	}
	@Test
	public void testApplyXGateWithMatrixParameter(){
		Qubit expectedResultQ0=new Qubit(new ComplexNumber(0,0.0),new ComplexNumber(1,0.0));
		Qubit expectedResultQ1=new Qubit(new ComplexNumber(1,0.0),new ComplexNumber(0,0.0));			
		Qubit q0 = new QubitZero();
		Qubit q1 = new QubitOne();
		gate= factory.getGate(EGateTypes.E_XGate);
		assertEquals(true, expectedResultQ0.equals(QuantumOperations.applyGate(q0, gate.getUnitaryMatrix())));
		assertEquals(true, expectedResultQ1.equals(QuantumOperations.applyGate(q1, gate.getUnitaryMatrix())));
	}
}
