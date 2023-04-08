package 문자열2.자가진단08;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=246&sca=10f0

609 : 문자열2 - 자가진단8 

세 개의 단어를 입력받아 아스키코드(사전) 순으로 
가장 먼저 나오는 단어를 출력하는 프로그램을 작성하시오.
각 단어의 길이는 1이상 10 이하이다.

[입력예]
cat dog cow

[출력예]
cat

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] words = new String[3];
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
		}
		
		String firstWord = words[0];
		for (int i = 1; i < words.length; i++) {
			if(firstWord.compareTo(words[i]) > 0) {
				firstWord = words[i];
			}
		}
		System.out.println(firstWord);
		
		sc.close();
	}

}
