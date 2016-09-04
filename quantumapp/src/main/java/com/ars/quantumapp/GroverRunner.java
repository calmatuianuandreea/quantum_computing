package com.ars.quantumapp;

import com.ars.algorithms.grover.GroversAlgorithm;

public class GroverRunner implements Runnable{

	@Override
	public void run() {
		GroversAlgorithm ga = new GroversAlgorithm();
		for (int i = 0; i < 1000000; i++) {
			ga.init();
			ga.run();
			ga.measure();
		}
		ga.close();
		
	}

}
