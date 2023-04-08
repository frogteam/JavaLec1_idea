package 배열2.형성평가07;

import java.util.Scanner;

/*
166 : 배열2 - 형성평가7 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=66&sca=10a0

[문제]
2행 3열 배열을 두 개 선언하여 각각의 값을 입력 받은 후 두 배열의 같은 위치끼리 곱하여 
새로운 배열에 저장한 후 출력하는 프로그램을 작성하시오.

[입력예]
first array
3 6 9
8 5 2
second array
9 8 7
6 5 4

[출력예]
27 48 63
48 25 8
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [][] arr1 = new int[2][3];
		int [][] arr2 = new int[2][3];
		int [][] arr3 = new int[2][3];
		
		System.out.println("first array");
		for(int row = 0; row < arr1.length; row++){
			for(int col = 0; col < arr1[row].length; col++){
				arr1[row][col] = sc.nextInt();
			}
		} // end for

		System.out.println("second array");
		for(int row = 0; row < arr2.length; row++){
			for(int col = 0; col < arr2[row].length; col++){
				arr2[row][col] = sc.nextInt();
			}
		} // end for

		for(int row = 0; row < arr3.length; row++){
			for(int col = 0; col < arr3[row].length; col++){
				arr3[row][col] = arr1[row][col] * arr2[row][col];
				System.out.print(arr3[row][col] + " ");
			}
			System.out.println();
		} // end for
				
		sc.close();
	} // end main()
} // end class
