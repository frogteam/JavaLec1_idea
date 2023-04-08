package 반복제어문1.형성평가04;

/*
128 : 반복제어문1 - 형성평가4 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=28&sca=1060
0 이 입력될 때까지 정수를 계속 입력받아 
3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
 
[입력예]
1 2 3 4 5 6 7 8 9 10 0

[출력예]
5
*/


import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0; // 개수
		int n;
		
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;  // 종료
			
			if(n % 3 != 0 && n % 5 != 0) {
				count++;
			}
		} // end while
		
		System.out.println(count);
		
		sc.close();
	}// end main

}// end class








