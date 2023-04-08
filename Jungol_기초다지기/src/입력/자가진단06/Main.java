package 입력.자가진단06;

import java.util.Scanner;

/* 514 : 입력 - 자가진단6
키를 입력받아 출력하는 프로그램을 작성하라.
(입력할때 "height = " 문장을 먼저 출력하고 키를 입력 받아야 합니다.)

[입력예]
height = 170

[출력예]
Your height is 170cm.
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("height = ");
		int height = sc.nextInt();
		System.out.printf("Your height is %dcm.\n", height);
		sc.close();
	}

}




