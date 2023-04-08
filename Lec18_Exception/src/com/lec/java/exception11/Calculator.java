package com.lec.java.exception11;

public class Calculator {

	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.printDivide(1, 2);
		calc.printDivide(1, 0);
	} // end main()
	
	public void printDivide(double d1, double d2){
		double result = d1 / d2;
		System.out.println(result);
	} // end printDivide()
} // end class
