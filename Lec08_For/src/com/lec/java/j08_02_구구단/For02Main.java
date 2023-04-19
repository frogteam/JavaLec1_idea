package com.lec.java.j08_02_구구단;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");
		
		System.out.println("2 x " + 1 + " = " + (2 * 1));
		System.out.println("2 x " + 2 + " = " + (2 * 2));
		System.out.println("2 x " + 3 + " = " + (2 * 3));
		
//		구구단 2단
//		2 x 1 = 2
//		2 x 2 = 4
//		2 x 3 = 6
//		2 x 4 = 8
//		2 x 5 = 10
//		2 x 6 = 12
//		2 x 7 = 14
//		2 x 8 = 16
//		2 x 9 = 18
		
		System.out.println();
		System.out.println("구구단 2단");
		for (int count = 1; count < 10; count++) {
			System.out.println("2 x " + count + " = " + (2 * count));
		} // end for
		
		System.out.println();
		System.out.println("구구단 3단");
		for (int count = 1; count < 10; count++) {
			System.out.println("3 x " + count + " = " + (3 * count));
		} // end for
		
		System.out.println();
		System.out.println("구구단 4단");
		for (int count = 1; count < 10; count++) {
			System.out.println("4 x " + count + " = " + (4 * count));
		} // end for
		
		// TODO
		// 2 x 2 = 4
		// 3 x 3 = 9
		// ..
		// 9 x 9 = 81
		for(int i = 2; i <= 9; i++) {
			System.out.println(i + " x " + i + " = " + (i * i));
		} // end for

	} // end main()

} // end class For02Main












