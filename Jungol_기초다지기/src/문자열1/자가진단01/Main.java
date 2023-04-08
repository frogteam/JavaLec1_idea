package 문자열1.자가진단01;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=230&sca=10e0

33부터 127 까지의 숫자를 계속 입력받아 입력받은 숫자의 
아스키코드에 해당하는 문자를 출력하다가 범위를 벗어나는 입력이 
들어오면 종료하는 프로그램을 작성하시오.


[입출력예]
ASCII code =? 66
B
ASCII code =? 122
z
ASCII code =? 0
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.print("ASCII code =? ");
			num = sc.nextInt();
			if(num < 33 || num > 127) break;
			char ch = (char)num;
			System.out.println(ch);
		}
		
		sc.close();
	} // end main()

} // end class
