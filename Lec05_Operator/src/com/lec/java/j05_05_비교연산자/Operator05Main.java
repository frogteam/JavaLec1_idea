package com.lec.java.j05_05_비교연산자;

/* 관계(비교) 연산자   Equality and Relational Operators
 *  비교 연산의 결과를 참(true) 또는 거짓(false)으로 리턴하는 연산자
 *   A < B: A는 B보다 작다
 *   A > B: A는 B보다 크다
 *   A >= B: A는 B보다 크거나 같다
 *   A <= B: A는 B보다 작거나 같다
 *   A == B: A와 B가 같다.
 *   A != B: A와 B는 다르다.	
 */
public class Operator05Main {

	public static void main(String[] args) {
		System.out.println("연산자 5 - 관계(비교) 연산자   Equality and Relational Operators");
		System.out.println("<, >, <=, >=, ==, !=");
		
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		boolean b = 1.2 <= 2.3; // 1.2는 2.3보다 작거나 같다. -> 참 -> true가 저장됨
		System.out.println("b = " + b);
		
		int n1 = 11;
		int n2 = 12;
		boolean b2 = n1 != n2; // n1과 n2가 다르다 -> 참 -> true가 저장됨
		System.out.println("b2 = " + b2);
		
		double average = 91.2;
		if (average >= 90) {
			// if ()가 참일 때 실행되는 부분
			System.out.println("학점: A");
		} else {
			// if ()가 거짓일 때 실행되는 부분
			System.out.println("학점: B");
		}
		
		// 주의
		// 실수 타입에서 같은지 여부는 산술적으로 계산한 값을 가지고 하면 안된다!
		double d1 = 3.2;
		double d2 = 12.3 / 4.1 + 0.2;

		// 0.1 + 1.2 =?
		
		if(d1 == d2) {
			System.out.println("같습니다");
		}else {
			System.out.println("다릅니다");  // 다릅니다!
		}
		
		// 실수 연산을 하면 오차범위란게 존재하기 때문에 주의해야 한다
		System.out.println("d1: " + d1);
		System.out.println("d2: " + d2);
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class






