package 반복제어문1.형성평가02;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=26&sca=1060
126 : 반복제어문1 - 형성평가2 

0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.

[입력예]
9 7 10 5 33 65 0

[출력에]
odd : 5
even : 1
*/
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cntOdd = 0;
		int cntEven = 0;
		int i;
		
		while(true) {
			i = sc.nextInt();
			if(i == 0) break;
			if(i % 2 == 0) cntEven++;
			else cntOdd++;
		}
		
		System.out.println("odd : " + cntOdd);
		System.out.println("even : " + cntEven);
		
		sc.close();
	}// end main

}// end class
