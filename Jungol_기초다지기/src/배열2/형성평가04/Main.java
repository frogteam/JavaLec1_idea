package 배열2.형성평가04;

import java.util.Scanner;

/*
163 : 배열2 - 형성평가4 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=63&sca=10a0

[문제]
4행 3열의 배열을 선언하고 아래의 값으로 초기화 한 후 차례대로 출력한 후 
배열의 모든 값을 더한 결과를 출력하는 프로그램을 작성하시오.

{{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}}


[입력예]

[출력예]
3 5 9
2 11 5
8 30 10
22 5 1
111
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int [][] arr = {{3, 5, 9}, {2, 11, 5}, {8, 30, 10}, {22, 5, 1}};
		int sum = 0;
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				sum += arr[row][col];
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println(sum);
		sc.close();

	} // end main()
} // end class
