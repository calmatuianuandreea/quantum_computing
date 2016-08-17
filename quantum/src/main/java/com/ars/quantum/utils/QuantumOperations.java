package com.ars.quantum.utils;

import java.util.List;

import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.IGate;
import com.ars.qubits.Qubit;
/**
 * Implementations of basic operations that can be applied on qubits.
 * 
 *
 */
public class QuantumOperations {

	/**
	 * Performs the tensor product of two qubits. Example, if q1=|0> and q2=|1> the method will return |01>.
	 * @param q1 
	 * @param q2
	 * @return qubit the tensor product of the two qubits.
	 */
	public static Qubit entangle(Qubit q1, Qubit q2) {

		return performTensorProduct(q1, q2);
	}

	/**
	 * Perform the tensor product between two or more qubits. Example, for three qubits |0>, |0> and |1>, the result will be |001>.
	 * @param qubitsList
	 * @return qubit the tensor product of the two qubits.
	 */
	public static Qubit entangle(List<Qubit> qubitsList) {
		if(qubitsList.size()<2){
			return null;
		}
		Qubit bufferQubit = qubitsList.get(0);
		for (int i = 1; i < qubitsList.size(); i++) {
			bufferQubit = performTensorProduct(bufferQubit, qubitsList.get(i));
		}
		return bufferQubit;
	}

	private static Qubit performTensorProduct(Qubit q1, Qubit q2) {
		int len1 = q1.getQubit().length;
		int len2 = q2.getQubit().length;
		ComplexNumber[] complexNumberList = new ComplexNumber[len1 * 2];
		int k = 0;
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				complexNumberList[k++] = ComplexMath.multiply(q1.getQubit()[i], q2.getQubit()[j]);
			}
		}

		return new Qubit(complexNumberList);
	}
	

	private static Qubit apply(Qubit q,double[][] gate){
		int qubitVectorLength = q.getQubit().length;
		int gateMatrixLength = gate.length;
		Qubit q0;
		ComplexNumber[] complexNumberList = new ComplexNumber[gateMatrixLength];
		ComplexNumber[] qubitArray = q.getQubit();
		double[][] unitaryMatrix = gate;

		for (int i = 0; i < gateMatrixLength; i++) {
			ComplexNumber sum = new ComplexNumber();
			for (int j = 0; j < qubitVectorLength; j++) {
				sum = ComplexMath.add(sum, ComplexMath.multiply(qubitArray[j], unitaryMatrix[i][j]));
			}
			complexNumberList[i] = sum;
		}
		q0 = new Qubit(complexNumberList);
		return q0;

	}
	
	/**
	 * Apply a specified Gate to a qubit. 
	 * @param q qubit.
	 * @param gate
	 * @return qubit
	 */
	public static Qubit applyGate(Qubit q, IGate gate) {
		return apply(q,gate.getUnitaryMatrix());
	}
	
	/**
	 * Apply a specified Gate to a qubit. 
	 * @param q qubit.
	 * @param gate
	 * @return qubit
	 */
	public static Qubit applyGate(Qubit q, double[][] gate) {
		return apply(q,gate);
	}
	
}
