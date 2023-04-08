package 선택제어문.형성평가01;

import java.util.Scanner;

/* 
120 : 선택제어문 - 형성평가1
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=20&sca=1050
문제
두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.


입력 예
50 85
출력 예
35

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		System.out.println((n1 > n2)? n1 - n2 : n2 - n1);
		
		sc.close();
	} // end main

} // end class
