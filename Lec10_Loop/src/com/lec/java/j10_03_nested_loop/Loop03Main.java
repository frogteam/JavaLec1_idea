package com.lec.java.j10_03_nested_loop;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 2단 ~ 9단

		// 2 x 1 = 2
		// ..
		// 2 x 9 = 18
		// 3 x 1 = 3
		// ..
		// 3 x 9 = 27
		// ...
		// 9 x 1 = 9
		// ..
		// 9 x 9 = 81
		
		// 구구단 출력 : 중첩 for 사용
		for (int dan = 2; dan < 10; dan++) {

			System.out.println("구구단 " + dan + "단");
			for (int mul = 1; mul < 10; mul++) {
				System.out.println(dan + " x " + mul + " = " + (dan * mul));
			} // end for (n)
			System.out.println();

		} // end for (dan)
		
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int dan = 2;
		while (dan < 10) {
			System.out.println("구구단 " + dan + "단");
			int mul = 1;
			while (mul < 10) {
				System.out.println(dan + " x " + mul + " = " + (dan * mul));
				mul++;
			} // end while (mul)
			System.out.println();

			dan++;
		} // end while (dan)
		
		
		// 연습
		// 반복3_자가2  (별그리기)
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















