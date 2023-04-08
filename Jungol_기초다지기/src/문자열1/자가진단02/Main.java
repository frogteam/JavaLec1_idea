package 문자열1.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=231&sca=10e0
문자열을 입력받은 뒤 그 문자열을 이어서 두 번 출력하는 프로그램을 작성하시오. 
문자열의 길이는 100이하이다.

[입력예]
ASDFG

[출력예]
ASDFGASDFG
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		System.out.println(str + str);
		
		sc.close();
	} // end main()

} // end class
