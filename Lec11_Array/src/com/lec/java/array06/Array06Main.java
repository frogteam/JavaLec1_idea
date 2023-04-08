package com.lec.java.array06;

/* 2차원 배열 의 length
	
 */
public class Array06Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열 & length");
		
		// 2x3 2차원 배열: 행(row)이 2개, 열(column)이 3개
		int[][] array = {
				{10, 20, 30}, // 0번째 행
				{40, 50, 60}  // 1번째 행
		};
		
		System.out.println("array.length = " + array.length);
		System.out.println("array[0].length = " + array[0].length);
		System.out.println("array[1].length = " + array[1].length);
		
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
			} // end for (y): column(열)
			System.out.println();
			
		} // end for (x): row(행)

	} // end main()

} // end class Array06Main










