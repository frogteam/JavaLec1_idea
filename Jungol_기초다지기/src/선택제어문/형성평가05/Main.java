package 선택제어문.형성평가05;

import java.util.Scanner;

/*  124 : 선택제어문 - 형성평가5
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=24&sca=1050

문제
1~12사이의 정수를 입력받아 평년의 경우 입력받은 월을 입력받아 평년의 경우 해당 월의 날수를 출력하는 프로그램을 작성하시오.

평년의 경우 1월부터 12월까지 일수는 각각 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31일이다.

입력 예]
2

출력 예]
28
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println(31);
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println(30);
			break;
		default:
			System.out.println(28);
			break;
		}
		sc.close();
	} // end main

} // end class
