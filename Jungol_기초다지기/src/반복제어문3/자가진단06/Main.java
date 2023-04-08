package 반복제어문3.자가진단06;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=190&sca=1080

553 : 반복제어문3 - 자가진단6 

자연수 n을 입력받아 다음과 같이 영문자를 출력하는 프로그램을 작성하시오.
 
[입력예]
3

[출력예]
ABC
DE
F

*/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char ch = 'A';
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < (n - i); j++) {
				System.out.print(ch);
				ch++;
			}
			System.out.println();
			
		}
		
		sc.close();
	} // end main()
} // end class
