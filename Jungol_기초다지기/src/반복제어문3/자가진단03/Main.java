package 반복제어문3.자가진단03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=187&sca=1080

550 : 반복제어문3 - 자가진단3 

자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
   
[입력예]
3

[출력예]
***
**
*
*
**
***
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = n - i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = n - i; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		} // end for

		
		sc.close();
	}
}
