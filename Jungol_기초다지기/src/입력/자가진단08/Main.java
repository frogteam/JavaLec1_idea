package 입력.자가진단08;


/*516 : 입력 - 자가진단8
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=153&sca=1020
실수 2개와 한 개의 문자를 입력 받아 출력하되 실수는 반올림하여 소수 둘째자리까지 출력하는 프로그램을작성하시오.
(C, C++, Java 의 경우 실수는 "double"로 선언하세요.)

[입력예]
12.2536
526.129535
A

[출력예]
12.25
526.13
A
 */

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		char ch = sc.next().charAt(0);
		
		System.out.println(String.format("%.2f", a));
		System.out.println(String.format("%.2f", b));
		System.out.println(ch);
		sc.close();
	} // end main()
} // end class
