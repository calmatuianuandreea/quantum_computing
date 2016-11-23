package com.ars.algorithms.deutsch;

import org.apache.logging.log4j.Logger;

import com.ars.algorithms.QuantumAlgorithms;
import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;
import com.ars.gates.EGateTypes;
import com.ars.gates.IGate;
import com.ars.quantum.utils.MatrixOperations;
import com.ars.quantum.utils.QuantumOperations;
import com.ars.qubits.Qubit;
import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public class DeutschsAlgorithm extends QuantumAlgorithms {

	private IGate				gateH;
	private IGate				gateX;
	private double[][]			gateHH;
	private static final Qubit	QUBIT_0	= new QubitZero();
	private static final Qubit	QUBIT_1	= new QubitOne();

	private double[]			measurementResults;
	private Logger				log		= getLogger();

	public DeutschsAlgorithm(double[][] testedFunctionOperator) {
		super(testedFunctionOperator);

	}

	public DeutschsAlgorithm() {

	}

	@Override
	public void init() {
		log.info("Started initialization...");
		gateH = gateFactory.getGate(EGateTypes.E_HadamardGate);
		gateX = gateFactory.getGate(EGateTypes.E_XGate);
		gateHH = MatrixOperations.tensorProduct(gateH.getUnitaryMatrix(), gateH.getUnitaryMatrix());
		log.info("Finished initialization.");
	}

	@Override
	public void run() {
		/**
		 * The following operations are performed: entangle qubitZero (qubitZero
		 * |> gateX) |> gateH2 |> f |> gateH2
		 */
		log.info("Started running algorithm...");
		resultQubit = QuantumOperations.applyGate(QuantumOperations.applyGate(
				QuantumOperations.applyGate(
						QuantumOperations.entangle(QUBIT_0, QuantumOperations.applyGate(QUBIT_0, gateX)), gateHH),
				oracle), gateHH);
		log.info("Finished running algorithm.");
	}

	@Override
	public void measure() {
		log.info("Started measurement process...");
		measurementResults = new double[resultQubit.getQubit().length];
		int i = 0;
		for (ComplexNumber c : resultQubit.getQubit()) {
			measurementResults[i++] = Math.round(ComplexMath.multiply(c, ComplexMath.conjugate(c)).getReal());
		}
		log.info("Finished measurement process...");
	}

	public boolean isFunctionConstant() {
		int i = 0;
		ComplexNumber[] q01 = QuantumOperations.entangle(QUBIT_0, QUBIT_1).getQubit();
		for (ComplexNumber c : q01) {
			if (Double.compare(Math.round(ComplexMath.multiply(c, ComplexMath.conjugate(c)).getReal()),
					measurementResults[i++]) != 0) {
				return false;
			}
		}
		return true;

	}

	public boolean isFunctionBalanced() {
		int i = 0;
		ComplexNumber[] q01 = QuantumOperations.entangle(QUBIT_1, QUBIT_1).getQubit();
		for (ComplexNumber c : q01) {
			if (Double.compare(Math.round(ComplexMath.multiply(c, ComplexMath.conjugate(c)).getReal()),
					measurementResults[i++]) != 0) {
				return false;
			}
		}
		return true;
	}

}
