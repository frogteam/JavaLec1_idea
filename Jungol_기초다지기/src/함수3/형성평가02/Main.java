package 함수3.형성평가02;


/*
232 : 함수3 - 형성평가2 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=132&sca=10d0

[문제]
자연수 N을 입력받아 N이 홀수인 경우에는 1부터 N까지의 홀수를  
짝수인 경우는 2부터 N까지의 짝수를 모두 출력하는 프로그램을 재귀함수로 작성하시오.


[입력예]
15


[출력예]
1 3 5 7 9 11 13 15
*/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		if(n % 2 == 0){
			func(2, n);
		}else{
			func(1, n);
		}
		
		sc.close();
	} // end main()
	
	public static void func(int num, int n){
		if(num <= n)
			System.out.print(num + " ");
		else
			return;
		num += 2;
		func(num, n);
	}
} // end class
