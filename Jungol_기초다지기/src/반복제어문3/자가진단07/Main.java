package 반복제어문3.자가진단07;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=191&sca=1080

554 : 반복제어문3 - 자가진단7 
자연수 n을 입력받아서 n개의 줄에 n+1개의 숫자 혹은 문자로 채워서 다음과 같이 출력하는 프로그램을 작성하시오.
   
[입력예]
3

[출력예]
1 2 3 A
4 5 B C
6 D E F
 


 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int num = 1;
		char ch = 'A';
		
		for(int i = 0; i < n; i++) {
			// 숫자 3 2 1
			for(int j = 0; j < (n - i); j++) {
				System.out.print(num + " ");
				num++;
			}
			
			// 알파벳 1 2 3
			for(int j = 0; j <= n - (n - i); j++) {
				System.out.print(ch + " ");
				ch++;
			}
			System.out.println();
		}
		sc.close();
	}
}
