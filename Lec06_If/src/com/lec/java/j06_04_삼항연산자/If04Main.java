package com.lec.java.j06_04_삼항연산자;

/*  삼항 연산자 (ternary operator)
 * 	 (조건식) ? 선택1 : 선택2
 * 	 (조건식)이 true 이면 선택1이 선택되고,
 *   (조건식)이 false 이면 선택2가 선택됨.
 */
public class If04Main {

	public static void main(String[] args) {
		System.out.println("if 문과 삼항 연산자");
		
		int num1 = 123;
		int num2 = 100;
		int big;
		
		/*
		if (num1 > num2) {
			big = num1;
		} else {
			big = num2;
		} // end else
		System.out.println("더 큰 수: " + big);
		*/
		
		// 삼항 연산자
		// (조건식) ? 선택1 : 선택2
		// (조건식)이 참이면 선택1이 선택되고,
		// (조건식)이 거짓이면 선택2가 선택됨.
		big = (num1 > num2) ? num1 : num2;
		System.out.println("더 큰 수: " + big);
		
		
		System.out.println();
		int num3 = 10;
		int num4 = 20;
		int diff;
//		if (num3 > num4) {
//			diff = num3 - num4;
//		} else {
//			diff = num4 - num3;
//		}
//		System.out.println("두 수의 차: " + diff);
		
		diff = (num3 > num4) ? (num3 - num4) : (num4 - num3);
		System.out.println("두 수의 차: " + diff);
		
		System.out.println();
		System.out.println((num3 > num4) ? (num3 - num4) : (num4 - num3));

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










