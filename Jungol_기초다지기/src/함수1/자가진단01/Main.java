package 함수1.자가진단01;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=208&sca=10b0
 
 571 : 함수1 - 자가진단1 

문자열 "~!@#$^&*()_+|" 를 출력하는 함수를 작성하고 정수를 입력받아 입력받은 수만큼 함수를 호출하는 프로그램을 작성하시오.


*문자열을 잘 확인하세요.
   
  
[입력예]
3

[출력예]
~!@#$^&*()_+|
~!@#$^&*()_+|
~!@#$^&*()_+|
 


 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		printStr(n);
		
		sc.close();
	} // end main
	
	public static void printStr(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("~!@#$^&*()_+|");
		}
	}
	
	
} // end class
