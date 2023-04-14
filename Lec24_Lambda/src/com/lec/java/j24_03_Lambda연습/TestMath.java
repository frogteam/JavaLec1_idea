package com.lec.java.j24_03_Lambda연습;

public class TestMath {
	private double x;
	private double y;
	
	// 멤버 메소드
	public void test(double x, double y, Operable calc) {
		double result = calc.operate(x, y);
		System.out.println("result = " + result);
		
	} // end test()
	
} // end class TestMath





