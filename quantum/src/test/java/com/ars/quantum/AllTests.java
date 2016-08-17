package com.ars.quantum;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ars.gates.QuantumGatesTest;
import com.ars.quantum.utils.MatrixOperationsTest;
import com.ars.quantum.utils.QuantumOperationsTest;
import com.ars.qubits.QubitTest;

@RunWith(Suite.class)
@SuiteClasses({
	QuantumGatesTest.class,
	QuantumOperationsTest.class,
	QubitTest.class,
	MatrixOperationsTest.class
})
public class AllTests {
	
}
