package 문자열1.형성평가01;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=82&sca=10e0

182 : 문자열1 - 형성평가1 

영문자 두 개를 입력 받아서 각각의 아스키코드의 합과 차를 출력하는 프로그램을 작성하시오.

[입력예]
A a

[출력예]
162 32
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char ch1 = sc.next().charAt(0);
		char ch2 = sc.next().charAt(0);
		
		System.out.println((ch1 + ch2) + " " + ( (ch1 > ch2) ? ch1 - ch2 : ch2 - ch1 ));
		
		
		sc.close();
	} // end main

} // end class
