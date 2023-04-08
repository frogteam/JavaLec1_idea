package 입력.자가진단09;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=154&sca=1020

517 : 입력 - 자가진단9 

세 개의 실수를 입력 받아 반올림하여 소수 셋째 자리까지 출력하는 프로그램을 작성하시오.

[입력예]
1.2568
95.21438
526.851364

[출력예]
1.257
95.214
526.851
 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		
		System.out.printf("%.3f\n", a);
		System.out.printf("%.3f\n", b);
		System.out.printf("%.3f\n", c);
				
		sc.close();
	} // end main()
}  // end class








