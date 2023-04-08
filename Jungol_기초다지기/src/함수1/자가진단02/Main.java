package 함수1.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=209&sca=10b0

572 : 함수1 - 자가진단2 

반지름의 길이를 전달받아 넓이를 출력하는 함수를 작성하고 반지름의 길이를 입력받아 함수를 호출하여 넓이를 출력하는 프로그램을 작성하시오. 
(원주율은 3.14로 하고 반올림하여 소수 둘째자리까지 출력한다. 원의 넓이 = 반지름 * 반지름 * 원주율이다.)
   
  
[입력에] 
10

[출력예]
314.00
 

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble();
		printCircleArea(n);
		sc.close();
	}
	
	//반지름의 길이를 전달받아 넓이를 출력하는 함수
	public static void printCircleArea(double r) {
		System.out.printf("%.2f", 3.14 * r * r);
	}

}
