package 함수1.자가진단04;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=211&sca=10b0

574 : 함수1 - 자가진단4 

두 개의 정수를 전달받아 최대값을 구하여 리턴하는 함수를 작성하고 세 정수를 입력받아 최대값을 출력하는 프로그램을 작성하시오.

[입력예]
-10 115 33

[출력예]
115
 



 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(max(max(a, b), c));
		
		sc.close();
	} // end main()
	
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
