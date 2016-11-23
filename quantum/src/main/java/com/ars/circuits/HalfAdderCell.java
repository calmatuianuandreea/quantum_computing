package com.ars.circuits;

import com.ars.gates.*;
import com.ars.quantum.utils.MatrixOperations;
import com.ars.quantum.utils.MatrixOperations.IncorrectMatrixSizeException;
import com.ars.quantum.utils.QuantumOperations;

public class HalfAdderCell implements ICircuit {

	/*
	 * A half adder cell is formed from a C2NOT gate and a CNOT gate
	 */
	
	private double[][] cnotgate;
	
	private double[][] level2;
	
	private double[][] C2NOT={{1,0,0,0,0,0,0,0},
			  {0,1,0,0,0,0,0,0},
			  {0,0,1,0,0,0,0,0},
			  {0,0,0,1,0,0,0,0},
			  {0,0,0,0,1,0,0,0},
			  {0,0,0,0,0,1,0,0},
			  {0,0,0,0,0,0,0,1},
			  {0,0,0,0,0,0,1,0}
    };
	
	private double[][] identityMatrix = {{1,0},
			                             {0,1}};

	protected GatesAbstractFactory gateFactory = GateProducer.getGateFactory();
	
	private double[][] HalfAdderCellMatrix;
	@Override
	public double[][] getUnitaryMatrix() {
		
		cnotgate = gateFactory.getGate(EGateTypes.E_CNotGate).getUnitaryMatrix();
		level2 = MatrixOperations.tensorProduct(cnotgate,identityMatrix);
		
		try {
			HalfAdderCellMatrix = MatrixOperations.multiply(C2NOT, level2);
		} catch (IncorrectMatrixSizeException e) {
			System.out.println("For half adder cell matrix there are incorrect sizes");
			e.printStackTrace();
		}
		
		return HalfAdderCellMatrix;
	}

}
