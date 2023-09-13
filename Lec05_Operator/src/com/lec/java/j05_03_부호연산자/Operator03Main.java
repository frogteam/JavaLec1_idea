package com.lec.java.j05_03_부호연산자;

/* 부호연산자(+, -) sign operator
 * 	+: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
 * 	-: 부호 연산자(수의 부호(양,음)가 바뀜)
 */
public class Operator03Main {

	public static void main(String[] args) {
		System.out.println("연산자 3 - 부호연산자(+, -) sign operator");
		
		int num1 = -10;
		int num2 = +num1; // +: 부호 연산자(수의 부호(양,음)가 바뀌지 않음)
		int num3 = -num1; // -: 부호 연산자(수의 부호(양,음)가 바뀜)
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
		System.out.println("num3 = " + num3);
		
		// 띄어쓰기 중요하다! 왜인지 살펴보자
		
		int num4 = 11;
		int num5 = -22;
		int num6 = num4 + -num5; // -num5에서 - 기호는 부호연산자, 빼기 연산자가 아님
		System.out.println("num6 = " + num6);
		
		int num7 = num4 - -num5;
		// 첫번째 -: 빼기 연산자
		// 두번째 -: 부호 연산자
		System.out.println("num7 = " + num7);
		
		// 위에서 띄어쓰기 주의
		// IntelliJ : CTRL + ALT + L : reformat code

		System.out.println("\n프로그램 종료");
	} // end main

} // end class













