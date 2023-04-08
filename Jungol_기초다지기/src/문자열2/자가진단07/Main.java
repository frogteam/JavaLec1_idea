package 문자열2.자가진단07;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=245&sca=10f0
 
608 : 문자열2 - 자가진단7 
 
100개 이하의 문자로 구성된 한 개의 문자열을 입력받아서 
그 문자열에 문자 'c'와 문자열 "ab"의 포함여부를 "Yes", "No"로 구분하여 
출력예처럼 출력하는 프로그램을 작성하시오.
   
  
[입력예] 
abdef

[출력예]
No Yes
 

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String answer1 = (str.indexOf("c") != -1) ? "Yes" : "No";
		String answer2 = (str.indexOf("ab") != -1) ? "Yes" : "No";
		
		System.out.println(answer1 + " " + answer2);
		
		sc.close();
	} // end main()

} // end class
