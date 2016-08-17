package com.ars.quantum.utils;

import java.util.Arrays;

import com.ars.complexnumbers.ComplexMath;
import com.ars.complexnumbers.ComplexNumber;

public class MatrixOperations {
	public static double[][] multiply(double[][] a, double[][] b) {
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		int numberOfRowsSecondMatrix = b[0].length;
		int numberOfCollsSecondMatrix = b.length;
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

	public static ComplexNumber[][] multiply(ComplexNumber[][] a, ComplexNumber[][] b) {
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		int numberOfRowsSecondMatrix = b[0].length;
		int numberOfCollsSecondMatrix = b.length;
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

	public static double[][] add(double[][] a, double[][] b) {
		double[][] result = null;
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new double[a[0].length][a.length];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = a[i][j] + b[i][j];
				}
			}
		}

		return result;
	}

	public static ComplexNumber[][] add(ComplexNumber[][] a, ComplexNumber[][] b) {
		ComplexNumber[][] result = null;
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new ComplexNumber[a[0].length][a.length];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = ComplexMath.add(a[i][j], b[i][j]);
				}
			}
		}

		return result;
	}

	public static double[][] subtract(double[][] a, double[][] b) {
		double[][] result = null;
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new double[a[0].length][a.length];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = a[i][j] - b[i][j];
				}
			}
		}

		return result;
	}

	public static ComplexNumber[][] subtract(ComplexNumber[][] a, ComplexNumber[][] b) {
		ComplexNumber[][] result = null;
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
		if (a[0].length == b[0].length && a.length == b.length) {
			result = new ComplexNumber[a[0].length][a.length];
			for (int i = 0; i < numberOfRows; i++) {
				for (int j = 0; j < numberOfColls; j++) {
					result[i][j] = ComplexMath.subtract(a[i][j], b[i][j]);
				}
			}
		}

		return result;
	}

	public static boolean areEqual(double[][] a, double[][] b) {
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
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

	public static boolean areEqual(ComplexNumber[][] a, ComplexNumber[][] b) {
		int numberOfRows = a[0].length;
		int numberOfColls = a.length;
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
		int numberOfRowsMatrixA = a[0].length;
		int numberOfCollsMatrixA = a.length;
		double[][] result = resultMatrix;
		for (int i = 0; i < numberOfRowsMatrixA; i++) {
			for (int j = 0; j < numberOfCollsMatrixA; j++) {
				result[i + iPosition][j + jPosition] = ct * a[i][j];
			}
		}

		return result;
	}

	public static double[][] tensorProduct(double[][] a, double[][] b) {
		int k = 0;
		int numberOfRowsMatrixA = a[0].length;
		int numberOfCollsMatrixA = a.length;
		int numberOfRowsMatrixB = b[0].length;
		int numberOfCollsMatrixB = b.length;
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
}
