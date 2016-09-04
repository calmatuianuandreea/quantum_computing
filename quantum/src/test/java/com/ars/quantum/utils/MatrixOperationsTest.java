package com.ars.quantum.utils;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ars.complexnumbers.ComplexNumber;

public class MatrixOperationsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMatrixAddDoublesDifferentLengths() {
		double[][] a=new double[2][2];
		double[][] b=new double[3][3];
		double [][] c=MatrixOperations.add(a, b);
		assertNull(c);
	}
	
	@Test
	public void testMatrixAddComplexDifferentLengths() {
		ComplexNumber[][] a=new ComplexNumber[2][2];
		ComplexNumber[][] b=new ComplexNumber[3][3];
		ComplexNumber [][] c=MatrixOperations.add(a, b);
		assertNull(c);
	}
	
	@Test
	public void testMatrixAddDouble(){
		double[][] a={{1,1},{1,1}};
		double[][] b={{2,2},{2,2}};
		double[][] c=MatrixOperations.add(a, a);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(b[i][j], c[i][j],5e-10);
			}
		}
	}
	
	@Test
	public void testMatrixAddComplex(){
		ComplexNumber[][] a={{new ComplexNumber(1,0),new ComplexNumber(1,0)},{new ComplexNumber(1,0),new ComplexNumber(1,0)}};
		ComplexNumber[][] b={{new ComplexNumber(2,0),new ComplexNumber(2,0)},{new ComplexNumber(2,0),new ComplexNumber(2,0)}};
		ComplexNumber[][] c=MatrixOperations.add(a, a);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(b[i][j], c[i][j]);
			}
		}
	}
	
	@Test
	public void testMatrixSubtractDoublesDifferentLengths() {
		double[][] a=new double[2][2];
		double[][] b=new double[3][3];
		double [][] c=MatrixOperations.subtract(a, b);
		assertNull(c);
	}
	
	@Test
	public void testMatrixSubtractComplexDifferentLengths() {
		ComplexNumber[][] a=new ComplexNumber[2][2];
		ComplexNumber[][] b=new ComplexNumber[3][3];
		ComplexNumber [][] c=MatrixOperations.subtract(a, b);
		assertNull(c);
	}
	
	@Test
	public void testMatrixSubtractDouble(){
		double[][] a={{2,2},{2,2}};
		double[][] b={{4,4},{4,4}};
		double[][] c=MatrixOperations.subtract(b, a);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(a[i][j], c[i][j],5e-10);
			}
		}
	}
	
	@Test
	public void testMatrixSubtractComplex(){
		ComplexNumber[][] a={{new ComplexNumber(2,2),new ComplexNumber(2,2)},{new ComplexNumber(2,2),new ComplexNumber(2,2)}};
		ComplexNumber[][] b={{new ComplexNumber(4,4),new ComplexNumber(4,4)},{new ComplexNumber(4,4),new ComplexNumber(4,4)}};
		ComplexNumber[][] c=MatrixOperations.subtract(b, a);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(a[i][j], c[i][j]);
			}
		}
	}
	
	@Test
	public void testMatrixDoubleAreNotEqual(){
		double[][] a={{2,2},{2,2}};
		double[][] b={{4,4},{4,4}};
		assertEquals(false, MatrixOperations.areEqual(a, b));
	}
	
	@Test
	public void testMatrixDoubleAreEqual(){
		double[][] a={{2,2},{2,2}};
		
		assertEquals(true, MatrixOperations.areEqual(a, a));
	}
	
	@Test
	public void testMatrixDoubleDifferentSizes(){
		double[][] a=new double[2][2];
		double[][] b=new double[3][3];
		assertEquals(false, MatrixOperations.areEqual(a, b));
	}
	
	@Test
	public void testMatrixComplexAreNotEqual(){
		ComplexNumber[][] a={{new ComplexNumber(2,2),new ComplexNumber(2,2)},{new ComplexNumber(2,2),new ComplexNumber(2,2)}};
		ComplexNumber[][] b={{new ComplexNumber(4,4),new ComplexNumber(4,4)},{new ComplexNumber(4,4),new ComplexNumber(4,4)}};
		assertEquals(false, MatrixOperations.areEqual(a, b));
	}
	
	@Test
	public void testMatrixComplexAreEqual(){
		ComplexNumber[][] a={{new ComplexNumber(2,2),new ComplexNumber(2,2)},{new ComplexNumber(2,2),new ComplexNumber(2,2)}};
		
		assertEquals(true, MatrixOperations.areEqual(a, a));
	}
	
	@Test
	public void testMatrixComplexDifferentSizes(){
		ComplexNumber[][] a=new ComplexNumber[2][2];
		ComplexNumber[][] b=new ComplexNumber[3][3];
		assertEquals(false, MatrixOperations.areEqual(a, b));
	}
	
	@Test
	public void testMatrixMultiplyDoubleDifferentSizes(){
		double[][] a=new double[2][2];
		double[][] b=new double[3][3];
		assertNull(MatrixOperations.multiply(a, b));
	}
	
	@Test
	public void testMatrixMultiplyDouble(){
		double[][] a={{2,2},{2,2}};
		double[][] b={{1,1},{1,1}};
		double[][] c={{4,4},{4,4}};
		double[][] d=MatrixOperations.multiply(a, b);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(c[i][j], d[i][j],5e-10);
			}
		}
	}
	
	@Test
	public void testMatrixMultiplyComplexDifferentSizes(){
		ComplexNumber[][] a=new ComplexNumber[2][2];
		ComplexNumber[][] b=new ComplexNumber[3][3];
		assertNull(MatrixOperations.multiply(a, b));
	}
	
	@Test
	public void testMatrixMultiplyComplex(){
		ComplexNumber[][] a={{new ComplexNumber(1,0),new ComplexNumber(1,0)},{new ComplexNumber(1,0),new ComplexNumber(1,0)}};
		ComplexNumber[][] b={{new ComplexNumber(2,0),new ComplexNumber(2,0)},{new ComplexNumber(2,0),new ComplexNumber(2,0)}};
		ComplexNumber[][] c={{new ComplexNumber(4,0),new ComplexNumber(4,0)},{new ComplexNumber(4,0),new ComplexNumber(4,0)}};
		ComplexNumber[][] d=MatrixOperations.multiply(a, b);
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				assertEquals(c[i][j], d[i][j]);
			}
		}
	}
	
	@Test
	public void testTensorProduct(){
		double [][] a={{1.0,2.0},{3.0,4.0}};
		double [][] b={{0.0,5.0},{6.0,7.0}};
		double [][] expectedResult={{0.0,5.0,0.0,10.0},{6.0,7.0,12.0,14.0},{0.0,15.0,0.0,20.0},{18.0,21.0,24.0,28.0}};
		double [][] realResult=MatrixOperations.tensorProduct(a, b);
		for(int i=0;i<4;i++){
			assertArrayEquals(expectedResult[i], realResult[i], 5e-10);
		}
	}
	
	@Test
	public void testTensorProductComplex(){
		ComplexNumber [][] a={{new ComplexNumber(1.0,0.0),new ComplexNumber(2.0,0.0)},{new ComplexNumber(3.0,0.0),new ComplexNumber(4.0,0.0)}};
		ComplexNumber [][] b={{new ComplexNumber(0.0,0.0),new ComplexNumber(5.0,0.0)},{new ComplexNumber(6.0,0.0),new ComplexNumber(7.0,0.0)}};
		ComplexNumber [][] expectedResult={{new ComplexNumber(0.0,0.0),new ComplexNumber(5.0,0.0),new ComplexNumber(0.0,0.0),new ComplexNumber(10.0,0.0)},
									{new ComplexNumber(6.0,0.0),new ComplexNumber(7.0,0.0),new ComplexNumber(12.0,0.0),new ComplexNumber(14.0,0.0)},
									{new ComplexNumber(0.0,0.0),new ComplexNumber(15.0,0.0),new ComplexNumber(0.0,0.0),new ComplexNumber(20.0,0.0)},
									{new ComplexNumber(18.0,0.0),new ComplexNumber(21.0,0.0),new ComplexNumber(24.0,0.0),new ComplexNumber(28.0,0.0)}};
		ComplexNumber [][] realResult=MatrixOperations.tensorProduct(a, b);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				assertEquals(expectedResult[i][j], realResult[i][j]);
			}
		}
	}
	
	@Test
	public void testMatrixArrayMultiplication(){
		ComplexNumber [][] a={{new ComplexNumber(1.0,0.0),new ComplexNumber(2.0,0.0)},{new ComplexNumber(3.0,0.0),new ComplexNumber(4.0,0.0)}};
		ComplexNumber[] b={new ComplexNumber(5.0,0.0),new ComplexNumber(6.0,0.0)};
		ComplexNumber[] expected={new ComplexNumber(17.0,0.0),new ComplexNumber(39.0,0.0)};
		ComplexNumber[] actual=MatrixOperations.matrixArrayMultiplication(a, b);
		assertArrayEquals(expected, actual);
	}
}
