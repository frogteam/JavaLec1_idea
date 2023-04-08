package 반복제어문1.자가진단03;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=175&sca=1060
538 : 반복제어문1 - 자가진단3 
 
한 개의 정수를 입력받아 양수(positive integer)인지 음수(negative number)인지 출력하는 작업을 반복하다가 0이 입력되면 종료하는 프로그램을 작성하시오.

[입출력예]
number? 10
positive integer
number? -10
negative number
number? 0
 
 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		
		while(true) {
			System.out.print("number? ");
			n = sc.nextInt();
			
			if(n > 0)
				System.out.println("positive integer");
			else if(n < 0)
				System.out.println("negative number");
			else
				break;
		} // end while
		
		
		sc.close();
	}// end main

}// end class
