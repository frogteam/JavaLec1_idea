package 배열2.형성평가08;

import java.util.Scanner;

/*
167 : 배열2 - 형성평가8 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=67&sca=10a0

[문제]
4행 2열의 배열을 입력받아 가로평균과 세로평균 그리고 전체평균을 출력하는 프로그램을 작성하시오. (소수점 이하는 버림 한다.)


[입력예]
16 27
39 100
19 88
61 20


[출력예]
21 69 53 40
33 58
46
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = 4;
		int col = 2;
		
		int [] rowSum = new int[row];  // 행(가로)의 합
		int [] colSum = new int[col];  // 열(세로)의 합
		int total = 0;
		
		int num;
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				num = sc.nextInt();
				colSum[j] += num;
				rowSum[i] += num;
				total += num;
			} // end for
		} // end for

		
		//System.out.print("가로평균 ");
		for(int i = 0; i < row; i++){
			System.out.print(rowSum[i] / col + " ");   // 행(가로) 평균은 가로 합 / 열(세로)
		}
		System.out.println();
		
		//System.out.print("세로평균 ");
		for(int i = 0; i < col; i++){
			System.out.print(colSum[i] / row + " ");   // 열(세료) 평균은 세로 합 / 행(가로)
		}
		System.out.println();
		
		//System.out.print("전체평균 ");
		System.out.println(total / (row * col));
		
		sc.close();

	} // end main()
} // end class
