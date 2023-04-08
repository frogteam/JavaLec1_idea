package 반복제어문2.자가진단06;

/*
546 : 반복제어문2 - 자가진단6 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=183&sca=1070
 
10 이하의 과목수 n을 입력받은 후 n개 과목의 점수를 입력받아서 평균을 구하여 출력하고 
평균이 80점이상이면 "pass", 80점 미만이면 "fail"이라고 출력하는 프로그램을 작성하시오.

평균은 반올림하여 소수 첫째자리까지 출력한다.​ 

[입력예]
4
75 80 85 90

[출력예]
avg : 82.5
pass
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		double avg = 0;
		for (int i = 1; i <= n; i++) {
			int score = sc.nextInt();
			sum = score + sum;
		}

		avg = (double) sum / n;
		if (avg >= 80) {
			System.out.printf("avg : %.1f\n", avg);
			System.out.println("pass");
		} else if (avg <= 80) {
			System.out.printf("avg : %.1f\n", avg);
			System.out.println("fail");
		}

		sc.close();
	} // end main()

} // end class
