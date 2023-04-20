package com.lec.java.j11_07_ragged_array;

/**
 *  ragged array (혹은 jagged array)
 *  column(열)의 개수가 일정하지 않은 배열
 *
 *  가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
 *  열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array07Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");
		// ragged array: column(열)의 개수가 일정하지 않은 배열
		
		// 가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
		// 열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
		int[][] arr = new int[3][];   // 1차원 배열 3개를 담는 2차원 배열 객체 생성
		
		// 각 열(column)에 몇 개가 들어가게 될 지를 먼저 지정(메모리 할당)
		arr[0] = new int[1];
		arr[1] = new int[2];
		arr[2] = new int[3];
		
		// 초기화
		arr[0][0] = 1;
		arr[1][0] = 2;
		arr[1][1] = 3;
		arr[2][0] = 4;
		arr[2][1] = 5;
		arr[2][2] = 6;
		
		// 확인
		for (int x = 0; x < arr.length; x++) {
			for (int y = 0; y < arr[x].length; y++) {
				System.out.print(arr[x][y] + "\t");
			} // end for(y)
			System.out.println();
			
		} // end for (x)
		
  		
		System.out.println();
		int[][] array = {
				{1, 2},
				{3, 4, 5, 6},
				{6, 7, 8}
		};
		System.out.println(array[0][1]);
		//System.out.println(array[0][2]); // exception 발생
		System.out.println(array[1][3]);
		System.out.println(array[2][2]);
		//System.out.println(array[2][3]); // exception
		
		// for문을 사용해서 ragged array 내용 확인
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
			} // end for(y): column(열)
			System.out.println();
			
		} // end for(x): row(행)

	} // end main()

} // end class Array09Main

