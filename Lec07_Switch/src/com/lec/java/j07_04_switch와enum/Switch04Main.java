package com.lec.java.j07_04_switch와enum;

public class Switch04Main {

	// enum 타입 정의하는 방법:
	// enum 이름 {}
	// enum 타입 정의 메소드 안에서는 할 수 없다.
	enum Days {SUN, MON, TUE, WED, THU, FRI, SAT}
	enum Numbers {ONE, TWO, THREE}
	enum Subjects {KOREAN, MATH, ENGLISH}
	
	
	public static void main(String[] args) {
		System.out.println("enum 타입을 switch에서 사용하기");
		
		// 변수타입 변수이름 = 값;
		// int number = 123;
		Days day1 = Days.THU;
		System.out.println(day1); // THU
		Days day2 = Days.MON;
		//System.out.println(day2 - day1);  // enum 타입은 산술연산 안됨
		System.out.println(day1 == day2);  // false  ==, != 가능
		//System.out.println(day1 > day2);   // X. 크기비교 불가

		
		Numbers num1 = Numbers.ONE;
		Numbers num2 = Numbers.TWO;
		
		switch (day1) {
		case SUN: // enum 타입을 사용하는 switch 에선 enum 타입명은 생략
			System.out.println("일요일");
			break;
			
		case MON:
		case TUE:
		case WED:    // 이와 같은 것을 Fall through 라고도 한다.
			System.out.println("주 초반");
			break;
			
		case THU:
		case FRI:
			System.out.println("주 후반");
			break;
			
		case SAT:
			System.out.println("주말");
			break;
		}// end switch
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class








