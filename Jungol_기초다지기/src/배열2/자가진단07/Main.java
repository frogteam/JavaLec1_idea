package 배열2.자가진단07;

import java.util.Scanner;

/*
570 : 배열2 - 자가진단7 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=207&sca=10a0

[문제]
배열을 만들어서 아래와 같이 저장한 후 출력하는 프로그램을 작성하시오. 
규칙은 첫 번째 행은 모두 1로 초기화 하고 다음 행부터는 바로 위의 값과 바로 왼쪽의 값을 더한 것이다.

[입력예]

[출력예]
1 1 1 1 1
1 2 3 4 5
1 3 6 10 15
1 4 10 20 35
1 5 15 35 70
*/

public class Main {

	public static void main(String[] args) {
		int [][] arr = new int[5][5];
		
		for(int i = 0; i < 5; i++){
			arr[0][i] = 1;
			arr[i][0] = 1;
		}
		
		for(int row = 1; row < arr.length; row++){
			for(int col = 1; col < arr[row].length; col++){
				arr[row][col] = arr[row - 1][col] + arr[row][col - 1];  
			}
		}

		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + " ");  
			}
			System.out.println();
		}

	} // end main()
} // end class
