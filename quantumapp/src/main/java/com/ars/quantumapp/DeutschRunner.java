package com.ars.quantumapp;

import java.util.ArrayList;
import java.util.List;


import com.ars.algorithms.QuantumAlgorithms;
import com.ars.algorithms.deutsch.DeutschsAlgorithm;

public class DeutschRunner implements Runnable {
	private static final double[][]			F_1				= { { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };
	// constant
	private static final double[][]			F_2				= { { 0.0, 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0, 0.0 } };
	// balanced
	private static final double[][]			F_3				= { { 1.0, 0.0, 0.0, 0.0 }, { 0.0, 1.0, 0.0, 0.0 },
			{ 0.0, 0.0, 0.0, 1.0 }, { 0.0, 0.0, 1.0, 0.0 } };
	// balanced
	private static final double[][]			F_4				= { { 0.0, 1.0, 0.0, 0.0 }, { 1.0, 0.0, 0.0, 0.0 },
			{ 0.0, 0.0, 1.0, 0.0 }, { 0.0, 0.0, 0.0, 1.0 } };
	private static final QuantumAlgorithms	ALGORITHM		= new DeutschsAlgorithm();
	private static final List<double[][]>	FUNCTION_LIST	= new ArrayList<>();
	
	private static void testFunctions() {
		for (double[][] f : FUNCTION_LIST) {
			ALGORITHM.setOracle(f);
			ALGORITHM.init();
			ALGORITHM.run();
			ALGORITHM.measure();
			if (((DeutschsAlgorithm) ALGORITHM).isFunctionConstant()) {
				System.out.println("Function is constant");
			} else {
				System.out.println("Function is balanced");
			}
		}
	}

	@Override
	public void run() {
		FUNCTION_LIST.add(F_1);
		FUNCTION_LIST.add(F_2);
		FUNCTION_LIST.add(F_3);
		FUNCTION_LIST.add(F_4);
		testFunctions();
		
	}
}
