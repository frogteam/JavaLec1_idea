package 반복제어문3.자가진단02;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=2078&sca=1080
 
 634 : 반복제어문3 - 자가진단2 

자연수 n을 입력받아서 n줄만큼 다음과 같이 출력하는 프로그램을 작성하시오.

[입력예]
5

[출력예]
*
**
***
****
*****

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		} // end for
		
		sc.close();
	} // end main

	/*
            i
            0   ---> 1
            1   ---> 2
            2  ----> 3
            3  ----> 4
            .
            .

         */

} // end class
