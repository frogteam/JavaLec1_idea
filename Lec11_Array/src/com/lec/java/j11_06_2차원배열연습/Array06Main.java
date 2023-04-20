package com.lec.java.j11_06_2차원배열연습;

public class Array06Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열 연습");
		
		// ※ 차라리 아래 문제를 연습하는게 더 낳을듯. 
		// 배열2-형성5
		// 배열2-자가6
		
		//int i=10;
		
		//System.out.println(i);
		
		// 3x3 2차원 배열
		int[][] array = new int[3][3];
		
		
		// for문을 사용해서 array를 초기화
//		array = {
//				{0, 1, 2},
//				{10, 11, 12},
//				{20, 21, 22}
//		};
		// array[0][0] = 0;
		// array[0][1] = 1;
		// array[1][1] = 11;
		
		// x: row(행), y: column(열)
		// array[x][y] = 10 * x + y;
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				array[x][y] = 10 * x + y;
				
			} // end for (y): 열(column)
			
		} // end for (x): 행(row)
		
		// 결과 확인
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
				
			} // end for (y)
			System.out.println(); // 줄바꿈
			
		} // end for (x)

	} // end main()

} // end class Array07Main









