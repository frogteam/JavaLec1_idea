package com.lec.java.while01;

/*
 * while 순환문
 * 
 * [구문]
 * while(조건식) {
 *    ...
 * }
 * 
 * 조건식이 '참' (true) 인 동안 while 블럭 반복
 * 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;  // '초기화' 부분을 while 문 전에 배치
		while (count <= 10) { // '조건식'
			System.out.println(count);
			count++;  // '증감식'을 while 수행문 안에 배치
		} // end while
		System.out.println("while 끝난 후 count = " + count);
		
		System.out.println();
		// 10, 9, 8, ... , 1까지 출력
		count = 10; // 초기화
		while (count > 0) {
			System.out.println(count);
			count--;
		} // end while
		System.out.println("while 끝난 후 count = " + count);

		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class While01Main









