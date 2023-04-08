package 반복제어문3.자가진단05;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=189&sca=1080

552 : 반복제어문3 - 자가진단5 

자연수 n을 입력받아서 다음과 같이 출력하는 프로그램을 작성하시오.
   
[입력예]  
3

[출력예]
*****
 ***
  *

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			// 공백   0, 1, 2
			for(int j = 0; j < i ; j++) {
				System.out.print(" ");
			}
			
			// 별   5, 3, 1
			for(int j = 0; j < (n - i) * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
		} //
		
		
		sc.close();
	} // end main()

} // end class
