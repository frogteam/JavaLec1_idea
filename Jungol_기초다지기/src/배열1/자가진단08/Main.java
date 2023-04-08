package 배열1.자가진단08;

import java.util.Scanner;

/*
562 : 배열1 - 자가진단8 
http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=199&sca=1090

[문제]
10개의 정수를 입력받아 배열에 저장한 후 짝수 번째 입력된 값의 합과 홀수 번째 입력된 값의 평균을 출력하는 프로그램을 작성하시오. 
평균은 반올림하여 소수첫째자리까지 출력한다.


[입력예]
95 100 88 65 76 89 58 93 77 99

[출력예]
짝수번째 합 : 446
홀수번째 평균 : 78.8
*/

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] array = new int[10];
		int sumEven = 0, sumOdd = 0, cntOdd = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			
			if(i % 2 == 1){
				sumEven += array[i];
			}else{
				sumOdd += array[i];
				cntOdd++;
			}
		}
		System.out.println("sum : " + sumEven);
		System.out.println("avg : " + String.format("%.1f", (double)sumOdd / cntOdd));
	}

}
