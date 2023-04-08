package 문자열2.자가진단03;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=241&sca=10f0
 
 604 : 문자열2 - 자가진단3 

20개 이하의 문자로 이루어진 10개의 단어와 한 개의 문자를 입력받아서 마지막으로 입력받은 문자로 끝나는 단어를 모두 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
champion
tel
pencil
olympiad
class
information
jungol
lesson
book
lion
l

[출력예
tel
pencil
jungol
 

 
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String [] words = new String[10];
		
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.nextLine();
		}
		
		char ch = sc.next().charAt(0);
		
		for (int i = 0; i < words.length; i++) {
			if( ch == words[i].charAt(words[i].length() - 1))
				System.out.println(words[i]);
		}
		
		
		sc.close();
	}

}
