package 함수3.자가진단02;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=225&sca=10d0

588 : 함수3 - 자가진단2 

자연수 N을 입력받아 재귀함수를 이용하여 N부터 1까지 차례대로 출력하는 프로그램을 작성하시오. 
N은 50이하의 자연수이다.
   
[입력예]  
5

[출력예]
5 4 3 2 1
 
 */

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		func(n);
	}
	
	public static void func(int n) {
		if(n < 1) return;
		System.out.print(n);
		if(n - 1 >= 1) System.out.print(" ");
		func(n - 1);
	}
}
