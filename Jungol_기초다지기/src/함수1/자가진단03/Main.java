package 함수1.자가진단03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=210&sca=10b0

573 : 함수1 - 자가진단3 

100 미만의 정수만 입력된다. 정수 n을 입력받아 n x n 크기의 숫자사각형을 출력하는 프로그램을 작성하시오.
이때 정수 n을 전달받아 숫자 정사각형을 출력하는 함수를 작성하고, 입력받은 정수 n을 함수로 전달하여 출력한다.

[입력예]
4

[출력예]
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
 

 */
public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printSquare(n);
		sc.close();
	}
	
	public static void printSquare(int n) {
		int i = 1;
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < n; col++) {
				System.out.print(i + " ");
				i++;
			}
			System.out.println();
		}
	}
}
