package com.javcacore.l9.myException;

import java.util.Scanner;

public class Application {
	private static double result;

	public static void menu() {
		System.out.println("1. Addition");
		System.out.println("2. Substraction");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("==========================================");
	}

	public static void main(String[] args) throws IllegalAccessException, MyException {
		Scanner sc = new Scanner(System.in);
		double a, b;

		while (true) {
			System.out.println("Enter a");
			a = sc.nextDouble();

			System.out.println("Enter b");
			b = sc.nextDouble();

			menu();
			System.out.println("Make your choice please");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println(result = Methods.add(a, b));
				break;
			case 2:
				System.out.println(result = Methods.substract(a, b));
				break;
			case 3:
				System.out.println(result = Methods.multiply(a, b));
				break;
			case 4:
				System.out.println(result = Methods.divide(a, b));
				break;
			}
		}
	}
}
