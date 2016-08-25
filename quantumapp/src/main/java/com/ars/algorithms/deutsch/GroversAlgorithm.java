package com.ars.algorithms.deutsch;

import java.util.Optional;
import java.util.function.Function;

import com.ars.algorithms.QuantumAlgorithms;
import com.ars.gates.EGateTypes;
import com.ars.gates.IGate;
import com.ars.quantum.utils.MatrixOperations;
import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitZero;

public class GroversAlgorithm extends QuantumAlgorithms {
	private static final int NO_OF_INPUT = 3;
	private IGate gateH;
	private double[][] gateHn;
	private static final Qubit QUBIT_0 = new QubitZero();
	private Qubit qubitN;
	private Qubit resultQubit;
	private double[][] difusionMatrix = { 
			{ 1, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, -1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, -1, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, -1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, -1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, -1, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, -1, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, -1 }, };
	private double[][] oracleMatrix = { 
			{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
			{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 }, 
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 },
			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0 } };

	@Override
	public void init() {
		gateH = gateFactory.getGate(EGateTypes.E_HadamardGate);
		qubitN = QUBIT_0;
		for (int i = 0; i < NO_OF_INPUT - 1; i++) {
			qubitN = QuantumOperations.entangle(qubitN, QUBIT_0);
		}
		gateHn = gateH.getUnitaryMatrix();
		for (int i = 0; i < NO_OF_INPUT - 1; i++) {
			gateHn = MatrixOperations.tensorProduct(gateHn, gateH.getUnitaryMatrix());
		}
	}

	@Override
	public void run() {
		// for(int i=0;i<8;i++){
		// for(int j=0;j<8;j++){
		// System.out.print(oracleMatrix[i][j]+" ");
		// }
		// System.out.println("");
		// }
		int noOfIterations = (int) Math.sqrt(Math.pow(2, NO_OF_INPUT));
		System.out.println("Before hadamard " + qubitN);
		qubitN = QuantumOperations.applyGate(qubitN, gateHn);
		System.out.println("After hadamard " + qubitN);
		for (int i = 0; i < 2; i++) {
			qubitN = QuantumOperations.applyGate(qubitN, oracleMatrix);
			System.out.println("After oracle " + qubitN);
			qubitN = QuantumOperations.applyGate(qubitN, difusionMatrix);
			System.out.println("After difusion " + qubitN);
		}
	}

	@Override
	public void measure() {
		// TODO Auto-generated method stub

	}

	private Optional<Integer> foo(Integer b) {
		System.out.println(b + 20);
		return null;
	}

	private int and(int x, int y, int z) {
		return x & y & z;
	}

	// public void createOracleMatrix() {
	// int noOfRows = (int) Math.pow(2, NO_OF_INPUT);
	// oracleMatrix = new double[noOfRows][noOfRows];
	// for (int i = 0; i < noOfRows; i++)
	// Arrays.fill(oracleMatrix[i], 0);
	// int count = 0x00;
	// for (int i = 0; i < noOfRows; i++) {
	// for (int j = 0; j < noOfRows; j++) {
	// if (i == j) {
	// int value = oracle(
	// val -> and((count & (1 << 0)), (count & (1 << 1)) , (count & (1 << 2))));
	//
	// oracleMatrix[i][j] = Math.pow(-1, value);
	//
	//
	// }
	// }
	// }
	//
	// }

	private <T, R> R oracle(Function<T, R> f) {
		// |x>-> (-1)^f(x)|x>
		return f.apply(null);
	}

}
