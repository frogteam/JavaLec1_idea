package 배열2.자가진단02;

import java.util.Scanner;

/*
565 : 배열2 - 자가진단2 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=202&sca=10a0

[문제]
100 미만의 양의 정수들이 주어진다. 입력받다가 0 이 입력되면 마지막에 입력된 0 을 제외하고 그 때까지 입력된 정수의 십의 자리 숫자가 각각 몇 개인지 작은 수부터 출력하는 프로그램을 작성하시오. (0개인 숫자는 출력하지 않는다.)


[입력예]
10 55 3 63 85 61 85 0


[출력예]
0 : 1개
1 : 1개
5 : 1개
6 : 2개
8 : 2개
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 주어진 문제의 촛점은 '개수' 다.
		int [] arrCount = new int[10];  // 10의 자리숫자는 총 10가지 0~9
		int num;

		while(true){
			num = sc.nextInt();
			
			if(num <= 0 || num >= 100)  // 0이하, 100이상이면 종료  
				break;
			
			arrCount[num / 10]++;   // 해당 알파벳 카운터 증가
		}
		
		// 1번 이상 입력된 알바펫의 개수 출력
		for(int i = 0; i < arrCount.length; i++){
			if(arrCount[i] > 0){
				System.out.println( i + " : " + arrCount[i]);
			}
		}
		
		sc.close();

	} // end main()
} // end class
