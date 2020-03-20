package com.javacore.l9.customException;

public class WrongInputConsoleParametersException extends Exception {
	//				System.out.println("Enter a number of days");

	private String numOfDays;
	
	public String getNumOfDays() {
		return numOfDays;
	}

	public WrongInputConsoleParametersException(String numOfDays) {
		super(numOfDays);
		this.numOfDays = numOfDays;
	}

}
