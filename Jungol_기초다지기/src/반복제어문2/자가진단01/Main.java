package 반복제어문2.자가진단01;

/*
541 : 반복제어문2 - 자가진단1  
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=178&sca=1070
문자를 입력받아서 입력받은 문자를 20번 반복하여 출력하는 프로그램을 작성하시오.

[입력예]
A

[출력예]
AAAAAAAAAAAAAAAAAAAA
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		for (int i = 1; i <= 20; i++) {
			System.out.print(str);
		}
		
		sc.close();

	}// em

}// ec
