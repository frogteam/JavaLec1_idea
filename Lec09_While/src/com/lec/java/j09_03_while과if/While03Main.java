package com.lec.java.j09_03_while과if;

public class While03Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// 1 ~ 10까지 수 중에서 홀수만 출력 (while 사용)
		System.out.println("1 ~ 10 홀수 출력");
		int n = 1;
		while (n <= 10) {
			if (n % 2 == 1) {
				System.out.println(n);
			} // end if

			n++;
		} // end while
		
		
		System.out.println("if 사용 안하기");
		n = 1;
		while (n <= 10) {
			System.out.println(n);
			n += 2;
		} // end while

		// 도전 : 반복1 자가2
		// 도전 : 반복제어문2 - 형성평가4

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class While03Main









