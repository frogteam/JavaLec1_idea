package 연산자.자가진단08;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=162&sca=1030
 525 : 연산자 - 자가진단8 

3개의 정수를 입력 받아 첫 번째 수가 가장 크면 1 아니면 0을 출력하고 세 개의 수가 모두 같으면 1 아니면 0을 출력하는 프로그램을 작성하시오.
(JAVA는 1이면 true, 0이면 false를 출력한다.)
 
[입력예]
10 9 9

[출력예]
1 0
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// a 가 b,c 보다 크면 true
		System.out.print(a > b && a > c);
		System.out.print(" ");
		// a, b, c 가 같으면
		System.out.print(a == b && b == c);
		
		sc.close();
	} // end main()
} // end class
