package 문자열1.자가진단06;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=235&sca=10e0

598 : 문자열1 - 자가진단6 

문자를 입력받아 알파벳 문자인 경우에는 그대로 출력하고 숫자인 경우는 아스키코드값을 출력하는 작업을 반복하다가 기타의 문자가 입력되면 종료하는 프로그램을 작성하시오.

* 입출력예에서 진한글씨가 출력

[입출력예]
A
A
1
49
@




 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		while(true) {
			ch = sc.next().charAt(0);
			if(isAlpha(ch)) System.out.println(ch);
			else if(isDigit(ch)) System.out.println((int)ch);
			else break;
		}
		sc.close();
	} // end main()
	
	public static boolean isAlpha(char ch) {
		if(('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) return true;
		return false;
	}
	
	public static boolean isDigit(char ch) {
		if('0' <= ch && ch <= '9') return true;
		return false;
		
	}

} // end class
