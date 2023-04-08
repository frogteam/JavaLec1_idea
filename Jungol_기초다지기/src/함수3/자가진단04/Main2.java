package 함수3.자가진단04;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=227&sca=10d0

590 : 함수3 - 자가진단4 

10 이하의 자연수 N을 입력받아 주사위를 N번 던져서 나올 수 있는 모든 경우를 출력하되 
중복되는 경우에는 앞에서부터 작은 순으로 1개만 출력하는 프로그램을 작성하시오.
   
[입력예]
3

[출력예]
1 1 1
1 1 2
...
1 1 6
1 2 2
1 2 3
...
5 6 6
6 6 6

 */
//public class Main {
//
//	public static void main(String[] args) {
//		int [] dice = {1, 2, 3, 4, 5, 6}; // 주사위 눈
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int [] arr = new int[n];  // 일단 0 으로 초기화
//		sc.close();
//		func(arr, 0, 1);   // level0 : 1~6
//	}
//	
//	public static void func(int [] arr, int level, int n) {
//		// 종료조건 : level 이 배열의 length 에 다다르면
//		// 배열 내용 출력하고 종료.
//		if(level == arr.length) {
//			for(int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//		
//		// i => n ~ 6 까지 숫자를 배열이 해당  level 에 차례대로 집어넣고, 
//		// 그 다음 (레벨 + 1)로 i 값부터 돌리는 재귀호출 실행 
//		for(int i = n; i <= 6; i++) {
//			arr[level] = i;
//			func(arr, level + 1, i);
//		}
//	} // end func()
//
//}
