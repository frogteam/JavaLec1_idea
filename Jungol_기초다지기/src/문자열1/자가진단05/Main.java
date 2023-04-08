package 문자열1.자가진단05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=234&sca=10e0
597 : 문자열1 - 자가진단5 

두 개의 문자열을 입력받아서 두 문자열의 길이의 합을 출력하는 프로그램을 작성하시오.
각 문자열의 길이는 20자 미만이다.

[입력예]
Korean
English

[출력예]
13
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		System.out.println(str1.length() + str2.length());
		
		
		sc.close();
	} // end main()

} // end class
