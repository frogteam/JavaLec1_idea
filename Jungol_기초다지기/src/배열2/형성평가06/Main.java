package 배열2.형성평가06;

import java.util.Scanner;

/*
165 : 배열2 - 형성평가6 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=65&sca=10a0

[문제]
예제를 보고 적당한 배열을 선언한 후 1행의 1열과 3열 5열을 각각 1로 초기화하고 나머지는 모두 0으로 초기화 한 후 
2행부터는 바로 위행의 왼쪽과 오른쪽의 값을 더하여 채운 후 출력하는 프로그램을 작성하시오.

[입력예]

[출력예]
1 0 1 0 1
0 2 0 2 0
2 0 4 0 2
0 6 0 6 0
6 0 12 0 6

*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [][] arr = new int[5][5];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[0][2] = 1;
		arr[0][3] = 0;
		arr[0][4] = 1;
		
		for(int row = 1; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				int upperLeft = (col > 0)? arr[row - 1][col - 1]: 0;
				int upperRight = (col < arr[row].length - 1)? arr[row - 1][col + 1]: 0;
				arr[row][col] = upperLeft + upperRight;
			}
		} // end for
		
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	} // end main()
} // end class
