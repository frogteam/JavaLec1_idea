package 반복제어문2.자가진단03;

/*
543 : 반복제어문2 - 자가진단3 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=180&sca=1070

하나의 정수를 입력받아 1부터 입력받은 정수까지의 짝수를 차례대로 출력하는 프로그램을 작성하시오.
입력되는 정수는 50이하이다.
 
[입력예]
10

[출력예]
2 4 6 8 10
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		sc.close();
	} // end main()

} // end class
