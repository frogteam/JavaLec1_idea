package 반복제어문3.자가진단01;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=186&sca=1080

549 : 반복제어문3 - 자가진단1 

자연수 n을 입력받고 1부터 홀수를 차례대로 더해나가면서 
합이 n 이상이면 그 때까지 더해진 홀수의 개수와 그 합을 출력하는 프로그램을 작성하시오.
   
[입력예]
100

[출력예]
10 100
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	

		int n = sc.nextInt();
		
		int cnt = 1;
		int num = 1;
		int sum = 0;
		while(true) {
			sum += num;
			if(sum >= n) {
				break;
			}
			num += 2;
			cnt++;
		} // end while
		
		System.out.println(cnt + " " + sum);
		
		sc.close();
	}
}
