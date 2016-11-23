package com.ars.quantumapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.ars.algorithms.MeasurementPerformer;
import com.ars.algorithms.QuantumAlgorithms;
import com.ars.circuits.CircuitTypes;
import com.ars.complexnumbers.ComplexNumber;
import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;

public class HalfAdderCell2 extends QuantumAlgorithms {
	private static final int NO_OF_QUBITS = 3;
	private BufferedWriter writer;
	private Qubit inputQubitX0; // first qubit of the adder
	private Qubit inputQubitX1; // second qubit of the adder
	private Qubit inputQubitCarry; //  input carry
	private double[][] HalfAdderCell;
	private Qubit inputQubit;
	private Qubit inputQubitCnot;

	public HalfAdderCell2(Qubit inputQubitX0, Qubit inputQubitX1, Qubit inputQubitCarry){
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
		HalfAdderCell = circuitFactory.getCircuit(CircuitTypes.E_HalfAdderCell).getUnitaryMatrix();
		inputQubit = QuantumOperations.entangle(inputQubitX0,inputQubitX1);
		inputQubit = QuantumOperations.entangle(inputQubit,inputQubitCarry);
		
		System.out.println("Input qubit "+inputQubit);
		
	}

	@Override
	public void run() {

        //Apply Half Adder Cell Circuit
		inputQubit  = QuantumOperations.applyGate(inputQubit, HalfAdderCell);
		System.out.println(HalfAdderCell);
		System.out.println("Result "+inputQubit);
		
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

}
