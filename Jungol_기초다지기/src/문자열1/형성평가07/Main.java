package 문자열1.형성평가07;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=88&sca=10e0

188 : 문자열1 - 형성평가7 

공백을 포함한 문자열을 입력받아 다음과 같이 분리하여 번호와 함께 출력하는 프로그램을 작성하시오. 
문자열의 길이는 100자 이하이다.
   
[입력예]
My name is Kimchulsoo

[출력예]
1. My
2. name
3. is
4. Kimchulsoo
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String[] words = str.split("\\s+");
		
		for(int i = 0; i < words.length; i++) {
			System.out.println((i + 1) + ". " + words[i]);
		}		
		
		sc.close();
	} // end main

} // end class
