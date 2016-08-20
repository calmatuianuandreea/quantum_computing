package com.ars.quantumapp;

public class App {
	private static Thread runner;
	public static void main(String[] args) {
		runner=new Thread(new DeutschRunner());
		runner.start();
		

	}

}
