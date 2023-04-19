package com.lec.java.j06_01_if_else;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 * 
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		System.out.println("\n===== [1] =====");
		int num = 10;
		if (num > 0) {
			// if () 조건식이 true일 때 실행하는 코드
			System.out.println("양수입니다.");
		} else {
			// if () 조건문이 false일 때 실행되는 부분
			System.out.println("음수입니다.");
		} // end else

		System.out.println("if-else 끝");

		System.out.println("\n===== [2] =====");
		int num2 = 10;
		if (num2 > 0) {
			System.out.println("양수입니다.");
		} // end if
		System.out.println("음수입니다.");

		System.out.println("\n===== [3] =====");
		int num3 = 124;
		if (num3 % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		} // end else
		
		
		System.out.println("\n===== [4: 조건식(범위)] =====");
		int score = 40;
		//if(0 <= num4 <= 100)  // <-- 자바는 이런 표현식 없슴
		if(0 <= score && score <= 100) {
			System.out.println("0 <= num4 <= 100");
		}

		// ※ 도전 : 선택-자가2, 선택-자가3
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class






