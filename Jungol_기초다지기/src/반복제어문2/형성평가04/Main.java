package 반복제어문2.형성평가04;

/* 133 : 반복제어문2 - 형성평가4
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=33&sca=1070

문제
100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램을 작성하시오.
(평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)

입력 예]
3
99 65 30

출력 예
64.67
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int total = 0; // 누적합계
		
		int i = 0;
		while(i < n) { // n 번 입력
			total += sc.nextInt();
			i++;
		}
		
		double avg = (double)total / n;  // 평균
		System.out.printf("%.2f", avg);
		
		sc.close();
	}

}
