package 연산자.자가진단01;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=155&sca=1030
518 : 연산자 - 자가진단1 

세 개의 정수를 입력 받아서 합계와 평균을 출력하시오. (단 평균은 소수 이하를 버리고 정수부분만 출력한다.)

[입력예]
10 25 33

[출력에]
sum : 68
avg : 22
 

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int avg = 0;
		
		sum += sc.nextInt();
		sum += sc.nextInt();
		sum += sc.nextInt();
		
		avg = sum / 3;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
		
		
		sc.close();
	} // end main()
} // end class
