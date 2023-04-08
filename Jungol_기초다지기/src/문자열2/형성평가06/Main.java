package 문자열2.형성평가06;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=94&sca=10f0

194 : 문자열2 - 형성평가6 

두 개의 문자열 A와 B 한 개의 정수 n을 입력받아서 A에 B를 연결하고, 
변경된 문자열 A에서 n개의 문자를 B에 복사한 후 A와 B를 출력하는 프로그램을 작성하시오. (1≤n,A,B≤100)
   
  
[입력예] 
banana apple 3

[출력예]
bananaapple
banle


[입력예]
been schooling 10

[출력예]
beenschooling
beenschool

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word1 = sc.next();
		String word2 = sc.next();
		int n = sc.nextInt();
		
		System.out.println(word1 + word2);
		System.out.println((word1 + word2).substring(0, n) + ((n < word2.length()) ? word2.substring(n) : ""));
		
		
		sc.close();
	} // end main

} // end class
