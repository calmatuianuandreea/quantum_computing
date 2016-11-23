package com.ars.quantumapp;

import java.io.*;
import com.ars.*;
import com.ars.algorithms.MeasurementPerformer;
import com.ars.algorithms.QuantumAlgorithms;
import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.EGateTypes;
import com.ars.gates.IGate;
import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitZero;

public class HalfAdderCell extends QuantumAlgorithms{

	private static final int NO_OF_QUBITS = 3;
	private BufferedWriter writer;
	private Qubit inputQubitX0; // first qubit of the adder
	private Qubit inputQubitX1; // second qubit of the adder
	private Qubit inputQubitCarry; //  input carry
	private double[][] cnotgate;
	private Qubit inputQubit;
	private Qubit inputQubitCnot;
	
	private double[][] C2NOT={{1,0,0,0,0,0,0,0},
							  {0,1,0,0,0,0,0,0},
							  {0,0,1,0,0,0,0,0},
							  {0,0,0,1,0,0,0,0},
							  {0,0,0,0,1,0,0,0},
							  {0,0,0,0,0,1,0,0},
							  {0,0,0,0,0,0,0,1},
							  {0,0,0,0,0,0,1,0}
			};
	
	public HalfAdderCell(Qubit inputQubitX0, Qubit inputQubitX1, Qubit inputQubitCarry){
		this.inputQubitX0 = inputQubitX0;
		this.inputQubitX1 = inputQubitX1;
		this.inputQubitCarry = inputQubitCarry; 
		try{
			writer = new BufferedWriter(new FileWriter(new File("out.csv")));
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
	
		//get CNOT gate 
		cnotgate = gateFactory.getGate(EGateTypes.E_CNotGate).getUnitaryMatrix();
		// Calculate the entaglement between the 
		// 3 input qbits
		// we consider the input qubits to be |0>,|0>,|0>
		
		inputQubit = QuantumOperations.entangle(inputQubitX0,inputQubitX1);
		inputQubitCnot = inputQubit;
		inputQubit = QuantumOperations.entangle(inputQubit,inputQubitCarry);
		
		//System.out.println(inputQubit);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Apply C2NOT gate 
		inputQubit = QuantumOperations.applyGate(inputQubit, C2NOT);
		inputQubitCnot = QuantumOperations.applyGate(inputQubitCnot,cnotgate);
		System.out.println("Sum: "+inputQubitCnot);
		System.out.println("Carry :"+inputQubit);
		
	}

	@Override
	public void measure() {
		// TODO Auto-generated method stub
		MeasurementPerformer measureObject = new MeasurementPerformer();
		
		measureObject = measureObject.configure(inputQubit);
		inputQubit = measureObject.measure();
		try {

			for (ComplexNumber c : inputQubit.getQubit()) {
				writer.write(c.getReal() + ",");

			}
			writer.write("\n");
			// bw.newLine();
			// bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			writer.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	

}
