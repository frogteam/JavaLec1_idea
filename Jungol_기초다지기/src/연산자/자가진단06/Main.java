package 연산자.자가진단06;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=160&sca=1030
 523 : 연산자 - 자가진단6 

두 개의 정수를 입력받아서 다음과 같이 4가지 관계연산자의 결과를 출력하시오.
이때 입력받은 두 정수를 이용하여 출력하시오.
 (JAVA는 1이면 true, 0이면 false를 출력한다.)

[입력예]
4 5

[출력예]
4 > 5 --- 0
4 < 5 --- 1
4 >= 5 --- 0
4 <= 5 --- 1
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 두개의 정수 입력
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.println(a + " > " + b + " --- "+ (a > b));
		System.out.println(a + " < " + b + " --- "+ (a < b));
		System.out.println(a + " >= " + b + " --- "+ (a >= b));
		System.out.println(a + " <= " + b + " --- "+ (a <= b));
		
		sc.close();
	} // end main()
} // end class





