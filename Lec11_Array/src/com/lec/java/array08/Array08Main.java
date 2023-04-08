package com.lec.java.array08;

public class Array08Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열 연습");
		// int 타입의 10x10 2차원 배열 선언
		int[][] array = new int[10][10];
		
		// 각 원소 array[x][y]를 x*y로 초기화
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				array[x][y] = x * y;
			} // end for(y)
			
		} // end for(x)
		
		// 초기화한 결과 확인(출력)
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
			} // end for(y)
			System.out.println();
			
		} // end for(x)
		
	} // end main()

} // end class Array08Main









