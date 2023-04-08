package 반복제어문2.자가진단05;

/*
545 : 반복제어문2 - 자가진단5 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=182&sca=1070
 
10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.
 
[입력예]
10 15 36 99 100 19 46 88 87 13

[출력예]
Multiples of 3 : 4
Multiples of 5 : 3
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int mul3 = 0;
		int mul5 = 0;

		for (int i = 1; i <= 10; i++) {
			int num = sc.nextInt();
			if(num % 3 == 0) mul3++;
			if(num % 5 == 0) mul5++;
		}

		System.out.println("Multiples of 3 : " + mul3);
		System.out.println("Multiples of 5 : " + mul5);

		sc.close();
	} // end main()

} // end class
