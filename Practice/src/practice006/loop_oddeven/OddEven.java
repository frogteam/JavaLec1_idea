package practice006.loop_oddeven;

import java.util.Scanner;

/*
(loop1-b02)
 정수를 입력받다가 0 이 입력되면 그 때까지 입력받은 
 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.

	[입력]
	 9 7 10 5 33 65 0
 
	 [출력]
	 odd : 5
	 even : 1
 

 */

public class OddEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int odd = 0;
		int even = 0;
		
		for(;;) {
			int n = sc.nextInt();
			// 입력받은 n 이 0 이면 종료
			if(n == 0) {
				break;
			}
			
			if(n % 2 == 0) {
				// 짝수이면
				even++;
			}else {
				// 홀수이면
				odd++;
			}
		}
		
		System.out.println("ODD: " + odd);
		System.out.println("EVEN: " + even);
		
		sc.close();
	}

}
