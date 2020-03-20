package com.javcacore.l9.myException;

public class Methods {
	private double a;
	private double b;

	public static double add(double a, double b) {
		if (a < 0 && b < 0) {
			throw new IllegalArgumentException("Addition is impossible.");
		}
		return a + b;
	}

	public static double substract(double a, double b) {
		if ((a == 0 && b != 0) || (a != 0 && b == 0)) {
			throw new ArithmeticException("Substraction is impossible");
		}
		return a - b;
	}

	public static double multiply(double a, double b) throws IllegalAccessException {
		if (a == 0 && b == 0) {
			throw new IllegalAccessException("Multiply is impossible");
		}
		return a * b;
	}

	public static double divide(double a, double b) throws MyException {
		if (a > 0 && b > 0) {
			throw new MyException("Divide is impossible");
		}
		return a / b;
	}
}
