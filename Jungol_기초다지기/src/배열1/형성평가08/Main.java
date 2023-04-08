package 배열1.형성평가08;


/* 배열1 - 형성평가8
 * http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=57&sca=1090 

100 개 이하의 정수를 입력받다가 0 이 입력되면 
그 때까지 입력된 정수 중 5의 배수의 개수와 합계 평균을 출력하는 프로그램을 작성하시오.
평균은 소수점 이하 1자리까지 출력한다.
   
  
[입력예]
35 10 23 100 64 51 5 0

[출력예]
Multiples of 5 : 4
sum : 150
avg : 37.5
*/

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int [] num = new int[100];
		
		int i;
		int count = 0;
		int sum = 0;
		
		for (i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			if(num[i] == 0) break;
			
			if(num[i] % 5 == 0) {
				count++;
				sum += num[i];
			} // end if
			
		} // end for
		System.out.println("Multiples of 5 : " + count);
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f\n", sum / (double)count);
		
		sc.close();
	} // end main()
} // end class
