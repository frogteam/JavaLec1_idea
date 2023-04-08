package practice.matrix;

import java.util.Scanner;

/*
 https://ratsgo.github.io/linear%20algebra/2017/03/14/operations/
 

행 과 열을 입력받아서 2차원 배열을 생성하여 행렬 데이터를 입력받고
이 행렬에 대한 전치 (transpose) 를 출력하세요 
 
[입력예]
2 3
2 1 3
0 1 -1

[출력예]
2 0 
1 1 
3 -1 
 
 */

public class MatTranspose {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("행, 열 의 개수를 입력하세요");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int [][] arr = new int[row][col];
		
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		
		for(int c = 0; c < col; c++) {
			for(int r = 0; r < row; r++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	} // end main()
	
} // end class
