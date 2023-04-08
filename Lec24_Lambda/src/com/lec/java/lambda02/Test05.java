package com.lec.java.lambda02;

@FunctionalInterface
interface Test05 {
	public abstract void printMax(double x, double y);
	
} // end interface Test05

class Test05Imple implements Test05 {
	@Override
	public void printMax(double x, double y) {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		if (x > y) {
			System.out.println(x + " > " + y);
		} else {
			System.out.println(x + " <= " + y);
		}
		
	} // end printMax()
	
} // end class Test05Imple











