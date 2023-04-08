package 배열2.형성평가09;

import java.util.Scanner;

/*
168 : 배열2 - 형성평가9 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=68&sca=10a0

[문제]
행의 크기를 입력받아 파스칼 삼각형을 작성하여 마지막 행부터 첫 번째 행까지 차례로 출력하는 프로그램을 작성하시오. 
행의 크기는 최대 10이다.


[입력예]
6


[출력예]
1 5 10 10 5 1
1 4 6 4 1
1 3 3 1
1 2 1
1 1
1
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		
		int [][] arr = new int[row][row];
		
		arr[0][0] = 1;  // 가장 꼭지점은 0
		
		for(int i = 1; i < row; i++){
			for(int j = 0; j <= i; j++){
				if(j == 0 || j == i){
					arr[i][j] = arr[0][0];  // 가장 왼쪽과 오른쪽은 최상위 숫자가 그대로 내려옴
				}else{
					arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
				}				
			} // end for
		} // end for
		
		for(int i = row - 1 ; i >= 0; i--){
			for(int j = 0; j <= i; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	} // end main()
} // end class
