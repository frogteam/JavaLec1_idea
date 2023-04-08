package 문자열1.형성평가05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=86&sca=10e0

186 : 문자열1 - 형성평가5 

두 개의 단어를 입력받아서 길이가 긴 단어의 문자 개수를 출력하는 프로그램을 작성하시오. 
단어의 길이는 100자 이하다.

[입력예]
excel powerpoint

[출력예]
10
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String word2 = sc.next();
		
		System.out.println((word1.length() > word2.length()) ? word1.length(): word2.length());
		
		
		sc.close();
	}

}
