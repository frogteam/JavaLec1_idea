package 배열2.자가진단05;

import java.util.Scanner;

/*
568 : 배열2 - 자가진단5 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=205&sca=10a0


[문제]
2행 4열의 배열 두 개를 만들어서 입력을 받고 두 배열의 곱을 구하여 출력하는 프로그램을 작성하시오.

[입력예]
first array
1 2 3 4
5 6 7 8
second array
1 4 7 8
3 6 9 8

[출력예]
1 8 21 32
15 36 63 64

*/

public class Main {

	public static void main(String[] args) {

		int[][] arr1 = new int[2][4];
		int[][] arr2 = new int[2][4];
		int[][] arr3 = new int[2][4];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("first array");
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {
				arr1[row][col] = sc.nextInt();
			}
		}

		System.out.println("second array");
		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {
				arr2[row][col] = sc.nextInt();
			}
		}

		for (int row = 0; row < arr3.length; row++) {
			for (int col = 0; col < arr3[row].length; col++) {
				arr3[row][col] = arr1[row][col] * arr2[row][col];
				System.out.print(arr3[row][col] + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	} // end main()
} // end class
