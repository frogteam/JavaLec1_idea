package com.lec.java.j09_02_구구단;

public class While02Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		int dan = 2;
		
		// 구구단 2단을 while문을 사용해서 출력
		int n = 1; // 초기식
		while (n <= 9) { // 조건식
			System.out.println(dan + " x " + n + " = " + (dan * n));
			n++; // 증감식
		} // end while
		
		
		// for문과 while문은 100% 전환 가능하다.
		System.out.println("for 버젼");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " x " + i + " = " + (dan * i));
		} // end for

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class While02Main









