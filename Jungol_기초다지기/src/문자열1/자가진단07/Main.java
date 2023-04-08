package 문자열1.자가진단07;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=236&sca=10e0
599 : 문자열1 - 자가진단7 

문자열을 입력받아 알파벳 문자만 모두 대문자로 출력하는 프로그램을 작성하시오. 
문자열의 길이는 100이하이다.

[입력예]
1988-Seoul-Olympic!!!

[출력예]
SEOULOLYMPIC

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		str = str.toUpperCase();
		
		char[] arr = str.toCharArray();
		
		for(char ch : arr) {
			if(Character.isLetter(ch)) System.out.print(ch);
		}
		sc.close();
	} // end main()

} // end class
