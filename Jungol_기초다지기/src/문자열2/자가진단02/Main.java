package 문자열2.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=240&sca=10f0

603 : 문자열2 - 자가진단2 


공백을 포함한 문장을 입력 받아서 홀수 번째 단어를 차례로 출력하는 프로그램을 작성하시오.
문장의 길이는 100자 이하이다.
   
[입력예]  
I like you better than him.

[출력예]
I
you
than

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String [] words = str.split("\\s+");
		
		for (int i = 0; i < words.length; i += 2) {
			System.out.println(words[i]);
		}
		
		
		sc.close();
	} // end main()

} // end class
