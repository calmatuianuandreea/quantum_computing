package com.ars.gates;

/*
 * Implementation of Wiggle Gate
 * 
 */

public class WiggleGate implements IGate {
	
	/*
	 * Matrix corresponding to a Wiggle Gate(non-Javadoc)
	 * @see com.ars.gates.IGate#getUnitaryMatrix()
	 */
	
	private static final double[][] GATE_MATRIX = {{1/2,1/2,1/2,-1/2},
			                                       {1/2,1/2,-1/2,1/2},
			                                       {1/2,-1/2,1/2,1/2},
			                                       {-1/2,1/2,1/2,1/2}};

	/*
	 * @return 4D array corresponding to Wiggle Gate
	 * @see com.ars.gates.IGate#getUnitaryMatrix()
	 */
	@Override
	public double[][] getUnitaryMatrix() {
		double[][] copyOfGateMatrix = GATE_MATRIX;
		return copyOfGateMatrix;
	}

}
