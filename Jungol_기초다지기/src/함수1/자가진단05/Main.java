package 함수1.자가진단05;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=212&sca=10b0
 
 575 : 함수1 - 자가진단5 

10 이하의 두 정수를 받아서 첫 번째 수를 두 번째 수만큼 거듭제곱하여 나온 값을 리턴하는 함수를 작성하여 다음과 같이 출력하는 프로그램을 작성하시오.
   
[입력예]
2 10

[출력예]
1024
 
 */


public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int exp = sc.nextInt();
		
		System.out.println(power(num, exp));
		
		sc.close();
		
	} // end main()
	
	public static int power(int n, int e) {
		int result = 1;
		for(int i = 0; i < e; i++) {
			result *= n;
		}
		return result;
	} // end power()

} // end class
