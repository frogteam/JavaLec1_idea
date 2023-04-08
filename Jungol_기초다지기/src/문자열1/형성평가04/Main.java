package 문자열1.형성평가04;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=85&sca=10e0

185 : 문자열1 - 형성평가4 

단어와 문자 한 개를 입력받아서 단어에서 입력받은 문자와 같은 문자를 찾아서 그 위치를 출력하는 프로그램을 작성하시오.
단어에서 첫 번째 문자의 위치는 0으로 하고 찾는 문자가 여러 개일 때는 처음 나오는 위치를 출력한다.
만약 찾는 문자가 없을 때는 "No"라고 출력한다. 대소문자는 구별되며 단어는 100자 이하이다.
   
  
[입력예] 
Jungol.co.kr o

[출력예]
4
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		char ch = sc.next().charAt(0);
		
		int i;
		for(i = 0; i < word.length(); i++) {
			if(word.charAt(i) == ch) {
				System.out.println(i);
				break;
			}
		}
		if(i == word.length()) System.out.println("No");
		
		sc.close();
			
	} // end main

} // end class
