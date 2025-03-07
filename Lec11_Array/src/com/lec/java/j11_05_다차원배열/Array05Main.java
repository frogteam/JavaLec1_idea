package com.lec.java.j11_05_다차원배열;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 *  1차원 배열 (one-dimensional array) 이라고 함
 *   배열 첨자를 2개사용하면 2차원 배열
 *   배열 첨자를 3개사용하면 3차원 배열
 *   ...
 *  
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다  (배열첨자 2개 사용)
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다  (배열첨자 3개 사용)
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 1차원 배열
		int[] arr1 = {1, 2};
		//int arr1[] = {1, 2};  // 위와 결과 같음.

		// arr1 <-- int[] 타입
		// arr1[0] <-- int 타입
		
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1);
		
		int[] arr2 = {3, 4};
		int[] arr3 = {5, 6};
		
		// 위와 같이 배열 첨자를 하나만 쓰는 배열을 
		// 1차원 배열 (one-dimensional array) 이라고 함
		// arr1, arr2, arr3 모두 배열원소가 int 타입인 1차원 배열이다.
		
		// 반면!
		// 배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
		// 배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
		// ...
		
		System.out.println();
		
		
		// 1차원배열 x 3개을 담고 있는 2차원 배열.
		// 1차원 배열을 원소로하는 2차원 배열 선언
		{
			int[][] array = new int[3][];    // 1차원 배열 x 3개 담는 2차원 배열로 생성

			// 각각의 1차원 배열 원소들 생성.
			array[0] = new int[]{1, 2};
			array[1] = new int[]{3, 4};
			array[2] = new int[]{5, 6};
		}

		//int[] array[] = {  // <-- 가능
		int[][] array = {
				{1, 2},	// <- array[0]
				{3, 4}, // <- array[1]
				{5, 6},  // <- array[2]
		};
		
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]); // 3 출력
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]); // 6 출력
		//System.out.println(array[2][2]); // Exception
		
		// ※ 흔히 2차원 배열을 행과 열로 표현하기도 함
		// array 는 행(row) 3개, 열(column)이 2개인 2차원 배열
		
		// 2차원 배열에서 length의 의미:
		// array.length: 2차원 배열의 원소, 즉 1차원배열의 개수 
		//  			행열의 개념에선 2차원 배열의 행(row)의 개수를 의미
		System.out.println("array.length = " + array.length);
		// array[0].length: 첫번째 행의 원소의 개수, 즉 열(column)의 개수
		System.out.println("array[0].length = " + array[0].length);
		System.out.println("array[1].length = " + array[1].length);
		
		// array 의 타입은? --> int[][]
		// array[0] 의 타입은? --> int[]
		// array[0][0] 의 타입은? --> int
		
		// 2차원 배열 확인
		for (int x = 0; x < array.length; x++) { // 첫번째 index 순환
			for (int y = 0; y < array[x].length; y++) { // 두번째 index 순환
				System.out.print(array[x][y] + "\t");
				
			} // end for (y): 열(column)
			System.out.println();
		} // end for (x): 행(row)

		
		// TODO: 
		// 2행 4열의 2차원배열 두 개를 만들어서 
		// 아래와 같이 초기화하고 출력하기
		
		// 첫번째 배열 출력
		// 1 2 3 4
		// 5 6 7 8		
		int [][] arr4 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}
		};
		for(int x = 0; x < arr4.length; x++) {
			for(int y = 0; y < arr4[x].length; y++) {
				System.out.print(arr4[x][y]  + "\t");
			}
			System.out.println();
		} // end for
		
		// 두번째 배열 출력
		// 1 4 7 8
		// 3 6 9 8
		int [][] arr5 = {
				{1, 4, 7, 8},
				{3, 6, 9, 8}
		};
		for(int x = 0; x < arr5.length; x++) {
			for(int y = 0; y < arr5[x].length; y++) {
				System.out.print(arr5[x][y]  + "\t");
			}
			System.out.println();
		} // end for
		
	} // end main()

	// 배열2자가6
} // end class Array05Main









