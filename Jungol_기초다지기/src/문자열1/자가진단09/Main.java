package 문자열1.자가진단09;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=238&sca=10e0
601 : 문자열1 - 자가진단9 

문자열을 입력 받아서 문자수만큼 오른쪽으로 한 바퀴 회전하여 출력하는 프로그램을 작성하시오. 
문자열의 길이는 100이하이다.

[입력예]
PROGRAM

[출력예]
MPROGRA
AMPROGR
RAMPROG
GRAMPRO
OGRAMPR
ROGRAMP
PROGRAM

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(str.length() - 1 - i, str.length()) + str.substring(0, str.length() - 1 -i)); 
		}
		
		
		sc.close();
		
	} // end main()

} // end class
