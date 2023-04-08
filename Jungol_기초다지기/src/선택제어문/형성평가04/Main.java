package 선택제어문.형성평가04;

/* 123 : 선택제어문 - 형성평가4
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=23&sca=1050

문제
1번은 개, 2번은 고양이, 3번은 병아리로 정하고 번호를 입력하면 
번호에 해당하는 동물을 영어로 출력하는 프로그램을 작성하시오.
해당 번호가 없으면 "I don't know."라고 출력한다.

개-dog
고양이-cat
병아리-chick​ 


입력 예]
Number? 2
출력 예]
cat

 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Number? ");
		int n = sc.nextInt();
		switch(n) {
		case 1:
			System.out.println("dog");
			break;
		case 2:
			System.out.println("cat");
			break;
		case 3:
			System.out.println("chick");
			break;
		default:
			System.out.println("I don't know.");
		}
		sc.close();
	} // end main

} // end class
