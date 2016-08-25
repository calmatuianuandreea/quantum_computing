package com.ars.quantumapp;

import com.ars.algorithms.deutsch.GroversAlgorithm;

public class App {
	private static Thread runner;
	public static void main(String[] args) {
//		runner=new Thread(new DeutschRunner());
//		runner.start();
		GroversAlgorithm ga=new GroversAlgorithm();
		ga.init();
		ga.run();
		ga.measure();
	}

}
