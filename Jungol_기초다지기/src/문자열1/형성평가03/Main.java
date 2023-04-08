package 문자열1.형성평가03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=84&sca=10e0

184 : 문자열1 - 형성평가3 

100개 이하의 문자열을 입력받아서 영문자와 숫자만 출력하되 
영문자는 모두 소문자로 출력하는 프로그램을 작성하시오.
   
[입력예]  
Hancom1234@cqclass.com

[출력예]
hancom1234cqclasscom

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str.toLowerCase();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if( ('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9')) {
				System.out.print(ch);
			}
		}
		
		
		sc.close();
	} // end main

} // end class
