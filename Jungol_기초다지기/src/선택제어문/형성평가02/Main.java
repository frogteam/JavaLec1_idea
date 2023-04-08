package 선택제어문.형성평가02;

import java.util.Scanner;

/* 121 : 선택제어문 - 형성평가2
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=21&sca=1050
문제
정수를 입력받아 0 이면 "zero" 양수이면 "plus" 음수이면 "minus" 라고 
출력하는 프로그램을 작성하시오.

입력 예
0 
출력 예
zero
*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n > 0) {
			System.out.println("plus");
		} else if(n < 0) {
			System.out.println("minus");
		} else {
			System.out.println("zero");
		}
		
		sc.close();
	} // end main

} // end class
