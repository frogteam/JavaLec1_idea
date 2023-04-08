package practice013.multiarray_mul;

import java.util.Scanner;

/* <array2-a05>
 
 2행 4열의 배열 두 개를 만들어서 '입력'을 받고 
 두 배열의 곱을 구하여 출력하는 프로그램을 작성하시오.
 
[입력]
first array 를 입력하세요
1 2 3 4
5 6 7 8
second array 를 입력하세요
1 4 7 8
3 6 9 8

[결과]
1 8 21 32
15 36 63 64

 (행렬의 곱이 아니라, 각 배열 원소별 곱입니다!)
 */
public class MultiArray {

	public static void main(String[] args) {
		
		int [][] arr1 = new int[2][4];
		int [][] arr2 = new int[2][4];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("first array 를 입력하세요");
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				arr1[i][j] = sc.nextInt();
			}
		} // end for(arr1)
		
		System.out.println("second array 를 입력하세요");
		for(int i = 0; i < arr2.length; i++) {
			for(int j = 0; j < arr2[i].length; j++) {
				arr2[i][j] = sc.nextInt();
			}
		} // end for(arr2)
		
		for(int i = 0; i < arr1.length; i++) {
			for(int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] * arr2[i][j] + " ");
			}
			System.out.println();
		} // end for(arr1)		
	} // end main()
} // end class
