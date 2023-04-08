package 연산자.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=156&sca=1030
519 : 연산자 - 자가진단2 
 
정수 2개를 입력받아서 첫 번째 수에는 100을 증가시켜 저장하고  
두 번째 수는 10으로 나눈 나머지를 저장한 후  두 수를 차례로 출력하는 프로그램을 작성하시오.

[입력예]
20 35

[출력예]
120 5

 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		a += 100;
		b %= 10;
		System.out.println(a + " " + b);
		sc.close();
	} // end main()
} // end class
