package 반복제어문1.자가진단04;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=176&sca=1060
539 : 반복제어문1 - 자가진단4 

정수를 계속 입력받다가 100 이상의 수가 입력이 되면 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램을 작성하시오. 
(평균은 반올림하여 소수 첫째자리까지 출력한다.)

[입력예]
1 2 3 4 5 6 7 8 9 10 100

[출력예]
155
14.1

[힌트]          
입력을 받으면 먼저 누적을 시킨 후에 조건을 확인한다.

 */
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int sum = 0, cnt = 0;
		while(true) {
			n = sc.nextInt();
			sum += n;
			cnt++;
			if(n >= 100)
				break;
		} // end while
		
		
		System.out.println(sum);
		System.out.printf("%.1f", (double)sum / cnt);
		
		sc.close();
	}// end main

}// end class
