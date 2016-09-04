package com.ars.algorithms.grover;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import com.ars.algorithms.QuantumAlgorithms;
import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;
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
	private static int count = 0;
	private double[][] difusionMatrix = { 
			{ 1, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, -1, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, -1, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, -1, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, -1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, -1, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, -1, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, -1 }, };
//	private double[][] oracleMatrix = { 
//			{ 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
//			{ 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 }, 
//			{ 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0 },
//			{ 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0 },
//			{ 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 },
//			{ 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0 }, 
//			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0 },
//			{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -1.0 } };
	private double[][] oracleMatrix={//Testing
			{1.0,  0.0, 0.0, 0.0,  0.0, 0.0, 0.0,  0.0},
            {0.0, -1.0, 0.0, 0.0,  0.0, 0.0, 0.0,  0.0},
            {0.0,  0.0, 1.0, 0.0,  0.0, 0.0, 0.0,  0.0},
            {0.0,  0.0, 0.0, 1.0,  0.0, 0.0, 0.0,  0.0},
            {0.0,  0.0, 0.0, 0.0, -1.0, 0.0, 0.0,  0.0},
            {0.0,  0.0, 0.0, 0.0,  0.0, 1.0, 0.0,  0.0},
            {0.0,  0.0, 0.0, 0.0,  0.0, 0.0, 1.0,  0.0},
            {0.0,  0.0, 0.0, 0.0,  0.0, 0.0, 0.0, -1.0}};
	private BufferedWriter bw;

	public GroversAlgorithm() {
		try {
			bw = new BufferedWriter(new FileWriter(new File("D:\\out.csv")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		gateH = gateFactory.getGate(EGateTypes.E_HadamardGate);
		resultQubit = QUBIT_0;
		for (int i = 0; i < NO_OF_INPUT - 1; i++) {
			resultQubit = QuantumOperations.entangle(resultQubit, QUBIT_0);
		}
		gateHn = gateH.getUnitaryMatrix();
		for (int i = 0; i < NO_OF_INPUT - 1; i++) {
			gateHn = MatrixOperations.tensorProduct(gateHn, gateH.getUnitaryMatrix());
		}
		setOracle(oracleMatrix);
	}

	@Override
	public void run() {
		int noOfIterations = (int) Math.sqrt(Math.pow(2, NO_OF_INPUT));
		resultQubit = QuantumOperations.applyGate(resultQubit, gateHn);
		for (int i = 0; i < noOfIterations + 1; i++) {
			resultQubit = QuantumOperations.applyGate(resultQubit, oracleMatrix);
			resultQubit = QuantumOperations.applyGate(resultQubit, difusionMatrix);
		}
	}

	@Override
	public void measure() {
		measureInStandardBasis();
		// System.out.println(resultQubit);
		double[] measurementResults = new double[resultQubit.getQubit().length];
		int i = 0;

		for (ComplexNumber c : resultQubit.getQubit()) {
			// double val=ComplexMath.multiply(c,
			// ComplexMath.conjugate(c)).getReal();
			measurementResults[i++] = Math.round(c.getReal());
		}
		for (double d : measurementResults) {
			try {
				bw.write(d + ",");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close() {
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
