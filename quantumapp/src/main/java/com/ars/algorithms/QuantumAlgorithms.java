package com.ars.algorithms;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.GateProducer;
import com.ars.gates.GatesAbstractFactory;
import com.ars.quantum.utils.MatrixOperations;
import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public abstract class QuantumAlgorithms {
	protected double[][] oracle;
	protected Qubit resultQubit;
	protected GatesAbstractFactory gateFactory = GateProducer.getGateFactory();
	private static final Logger QUANTUM_ALGO_LOGGER = LogManager.getLogger(QuantumAlgorithms.class);

	public QuantumAlgorithms() {

	}

	public QuantumAlgorithms(double[][] oracle) {
		this.oracle = oracle;
	}

	public void setOracle(double[][] oracle) {
		this.oracle = oracle;
	}

	public abstract void init();

	public abstract void run();

	public abstract void measure();

	public Logger getLogger() {
		return QUANTUM_ALGO_LOGGER;
	}

	protected void measureInStandardBasis() {
		AMeasurement performMeasure = new StandardBasisMeasure(oracle.length);
		performMeasure.init();

		resultQubit = performMeasure.performMeasurement();
	}

	private final class StandardBasisMeasure extends AMeasurement {
		private ComplexNumber[] finalResult;

		public StandardBasisMeasure(int range) {
			super(range);
		}

		@Override
		public void init() {
			finalResult = new ComplexNumber[range];
			M0 = QuantumOperations.outerProduct(new QubitZero(), new QubitZero());
			M1 = QuantumOperations.outerProduct(new QubitOne(), new QubitOne());
			while (M0.length != resultQubit.getQubit().length) {
				M0 = MatrixOperations.tensorProduct(M0, UNITY_MATRIX);
			}
			while (M1.length != resultQubit.getQubit().length) {
				M1 = MatrixOperations.tensorProduct(M1, UNITY_MATRIX);
			}
		}

		@Override
		public Qubit performMeasurement() {
			double randomDoubleNumber = 0 + (range - 0) * new Random(System.currentTimeMillis()).nextDouble();
			//double randomDoubleNumber = new Random(System.currentTimeMillis()).nextInt(range);
			double probability = -1.0;
			ComplexNumber[][] resultMatrix = M0;
			ComplexNumber[] qubitArray = resultQubit.getQubit();
			ComplexNumber[][] transposedQubit = QuantumOperations.transpose(resultQubit);
			probability = ComplexMath.mod(MatrixOperations
					.matrixArrayMultiplication(MatrixOperations.multiply(transposedQubit, M0), qubitArray)[0]);
			randomDoubleNumber -= probability * range;
			if (randomDoubleNumber > 0) {
				probability = ComplexMath.mod(MatrixOperations
						.matrixArrayMultiplication(MatrixOperations.multiply(transposedQubit, M1), qubitArray)[0]);
				randomDoubleNumber -= probability * range;
				resultMatrix = M1;
			}

			finalResult = MatrixOperations.matrixArrayMultiplication(resultMatrix, qubitArray);
			for (int i = 0; i < finalResult.length; i++) {
				finalResult[i] = ComplexMath.divide(finalResult[i], Math.sqrt(probability));
			}

			return new Qubit(finalResult);
		}

	}

}
