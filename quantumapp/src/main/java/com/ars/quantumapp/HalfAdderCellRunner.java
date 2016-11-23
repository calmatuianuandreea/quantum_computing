package com.ars.quantumapp;

import com.ars.qubits.QubitOne;
import com.ars.qubits.QubitZero;

public class HalfAdderCellRunner implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		HalfAdderCell hac= new HalfAdderCell(new QubitOne(),new QubitZero(),new QubitZero());
		
		for (int i = 0; i<5;i++){
			hac.init();
			hac.run();
			hac.measure();
		}
		
	}

}
