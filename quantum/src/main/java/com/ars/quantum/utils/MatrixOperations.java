package com.ars.quantum.utils;

import java.util.Arrays;

import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;

/**
 * Implementations of basic operations with 2D arrays
 * 
 *
 */
public class MatrixOperations {

	/**
	 * Performs the multiplication between 2 2D arrays of double
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of double
	 */
	public static double[][] multiply(double[][] a, double[][] b) {
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		int numberOfRowsSecondMatrix = b.length;
		int numberOfCollsSecondMatrix = b[0].length;
		double sum = 0.0;
		double[][] multiply = null;
		if (numberOfColls == numberOfRowsSecondMatrix) {
			multiply = new double[numberOfRows][numberOfCollsSecondMatrix];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfCollsSecondMatrix; j++) {
					for (int k = 0; k < numberOfRowsSecondMatrix; k++) {
						sum = sum + a[i][k] * b[k][j];
					}

					multiply[i][j] = sum;
					sum = 0;
				}
			}
		}
		return multiply;
	}

	/**
	 * Performs the multiplication between 2 2D arrays of complex numbers
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of complex numbers
	 */
	public static ComplexNumber[][] multiply(ComplexNumber[][] a, ComplexNumber[][] b) {
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		int numberOfRowsSecondMatrix = b.length;
		int numberOfCollsSecondMatrix = b[0].length;
		ComplexNumber sum = new ComplexNumber();
		ComplexNumber[][] multiply = null;
		if (numberOfColls == numberOfRowsSecondMatrix) {
			multiply = new ComplexNumber[numberOfRows][numberOfCollsSecondMatrix];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfCollsSecondMatrix; j++) {
					for (int k = 0; k < numberOfRowsSecondMatrix; k++) {
						sum = ComplexMath.add(sum, ComplexMath.multiply(a[i][k], b[k][j]));

					}

					multiply[i][j] = sum;
					sum = new ComplexNumber();
				}
			}
		}
		return multiply;
	}

	/**
	 * Performs the sum between 2 2D arrays of double
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of double
	 */
	public static double[][] add(double[][] a, double[][] b) {
		double[][] result = null;
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new double[numberOfRows][a.length];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = a[i][j] + b[i][j];
				}
			}
		}

		return result;
	}

	/**
	 * Performs the sum between 2 2D arrays of complex numbers
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of complex numbers
	 */
	public static ComplexNumber[][] add(ComplexNumber[][] a, ComplexNumber[][] b) {
		ComplexNumber[][] result = null;
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new ComplexNumber[numberOfRows][numberOfColls];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = ComplexMath.add(a[i][j], b[i][j]);
				}
			}
		}

		return result;
	}

	/**
	 * Performs the subtract between 2 2D arrays of double
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of double
	 */
	public static double[][] subtract(double[][] a, double[][] b) {
		double[][] result = null;
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new double[numberOfRows][numberOfColls];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = a[i][j] - b[i][j];
				}
			}
		}

		return result;
	}

	/**
	 * Performs the subtract between 2 2D arrays of complex numbers
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of complex numbers
	 */
	public static ComplexNumber[][] subtract(ComplexNumber[][] a, ComplexNumber[][] b) {
		ComplexNumber[][] result = null;
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new ComplexNumber[numberOfRows][numberOfColls];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = ComplexMath.subtract(a[i][j], b[i][j]);
				}
			}
		}

		return result;
	}

	/**
	 * Check if 2 2D arrays of double are equal.
	 * 
	 * @param a
	 * @param b
	 * @return boolean true if the two matrices are equal, otherwise false.
	 */
	public static boolean areEqual(double[][] a, double[][] b) {
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length == b[0].length && a.length == b.length) {
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					if (a[i][j] != b[i][j]) {
						return false;
					}
				}
			}
			return true;
		}

		return false;
	}

	/**
	 * Check if 2 2D arrays of complex numbers are equal.
	 * 
	 * @param a
	 * @param b
	 * @return boolean true if the two matrices are equal, otherwise false.
	 */
	public static boolean areEqual(ComplexNumber[][] a, ComplexNumber[][] b) {
		int numberOfRows = a.length;
		int numberOfColls = a[0].length;
		if (a[0].length != b[0].length || a.length != b.length) {
			return false;
		}

		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColls; j++) {
				if (!a[i][j].equals(b[j][j])) {
					return false;
				}
			}
		}
		return true;
	}

	private static double[][] performMultiplicationWithConstant(double[][] a, double ct, int iPosition, int jPosition,
			double[][] resultMatrix) {
		int numberOfRowsMatrixA = a.length;
		int numberOfCollsMatrixA = a[0].length;
		double[][] result = resultMatrix;
		for (int i = 0; i < numberOfRowsMatrixA; i++) {
			for (int j = 0; j < numberOfCollsMatrixA; j++) {
				result[i + iPosition][j + jPosition] = ct * a[i][j];
			}
		}

		return result;
	}

	/**
	 * Performs the tensor product between 2 2D arrays of double
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of double
	 */
	public static double[][] tensorProduct(double[][] a, double[][] b) {
		int k = 0;
		int numberOfRowsMatrixA = a.length;
		int numberOfCollsMatrixA = a[0].length;
		int numberOfRowsMatrixB = b.length;
		int numberOfCollsMatrixB = b[0].length;
		int numberOfRowsResultMatrix = numberOfRowsMatrixA * numberOfRowsMatrixB;
		int numberOfCollsResultMatrix = numberOfCollsMatrixA * +numberOfCollsMatrixB;
		double[][] result = new double[numberOfRowsResultMatrix][numberOfCollsResultMatrix];
		for (int i = 0; i < numberOfRowsResultMatrix; i++) {
			Arrays.fill(result[i], 0.0);
		}
		for (int i = 0; i < numberOfRowsMatrixA; i++) {
			for (int j = 0; j < numberOfCollsMatrixA; j++) {
				result = performMultiplicationWithConstant(b, a[i][j], k, j * 2, result);
			}
			k += 2;
		}
		return result;
	}

	/**
	 * Performs the tensor product between 2 2D arrays of complex numbers
	 * 
	 * @param a
	 * @param b
	 * @return 2D array of double
	 */
	public static ComplexNumber[][] tensorProduct(ComplexNumber[][] a, ComplexNumber[][] b) {
		int k = 0;
		int numberOfRowsMatrixA = a.length;
		int numberOfCollsMatrixA = a[0].length;
		int numberOfRowsMatrixB = b.length;
		int numberOfCollsMatrixB = b[0].length;
		int numberOfRowsResultMatrix = numberOfRowsMatrixA * numberOfRowsMatrixB;
		int numberOfCollsResultMatrix = numberOfCollsMatrixA * +numberOfCollsMatrixB;
		ComplexNumber[][] result = new ComplexNumber[numberOfRowsResultMatrix][numberOfCollsResultMatrix];
		for (int i = 0; i < numberOfRowsResultMatrix; i++) {
			for (int j = 0; j < numberOfCollsResultMatrix; j++) {
				result[i][j] = new ComplexNumber(0.0, 0.0);
			}
		}
		for (int i = 0; i < numberOfRowsMatrixA; i++) {
			for (int j = 0; j < numberOfCollsMatrixA; j++) {
				result = performMultiplicationWithConstant(b, a[i][j], k, j * 2, result);
			}
			k += 2;
		}
		return result;
	}

	private static ComplexNumber[][] performMultiplicationWithConstant(ComplexNumber[][] a, ComplexNumber ct,
			int iPosition, int jPosition, ComplexNumber[][] resultMatrix) {
		int numberOfRowsMatrixA = a.length;
		int numberOfCollsMatrixA = a[0].length;
		ComplexNumber[][] result = resultMatrix;
		for (int i = 0; i < numberOfRowsMatrixA; i++) {
			for (int j = 0; j < numberOfCollsMatrixA; j++) {
				result[i + iPosition][j + jPosition] = ComplexMath.multiply(ct, a[i][j]);

			}
		}

		return result;
	}

	public static ComplexNumber[] matrixArrayMultiplication(ComplexNumber[][] q1, ComplexNumber[] q2) {
		ComplexNumber[] result = new ComplexNumber[q2.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = new ComplexNumber(0.0, 0.0);
		}
		for (int i = 0; i < q1.length; i++) {
			for (int j = 0; j < q2.length; j++) {
				result[i] = ComplexMath.add(result[i], ComplexMath.multiply(q1[i][j], q2[j]));
			}
		}
		return result;
	}

}
