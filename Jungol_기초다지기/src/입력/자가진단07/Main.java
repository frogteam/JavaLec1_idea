package 입력.자가진단07;
/* 515 : 입력 - 자가진단7
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=152&sca=1020

두 개의 정수를 입력 받아 곱과 몫을 출력하시오.
(먼저 입력 받는 수가 항상 크며 입력되는 두 정수는 1이상 500이하이다.)

[입력예]
16 5

[출력예]
16 * 5 = 80
16 / 5 = 3
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//두 개의 정수를 입력 받기
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 곱과 몫을 출력하기
		// ex)
//		16 * 5 = 80
//		16 / 5 = 3
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		
		sc.close();
	}

}