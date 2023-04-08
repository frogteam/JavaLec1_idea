package 함수2.자가진단03;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=218&sca=10c0
 
 581 : 함수2 - 자가진단3 

두 개의 정수를 입력받아 절대값이 더 큰 수를 출력하고 
두 개의 실수를 입력받아 절대값이 작은 수를 출력하는 프로그램을 작성하시오. 
실수는 소수점 이하 2자리까지 출력한다.
   
  
[입력예] 
-50 40
-12.34 5.67

[출력예]
-50
5.67
 

 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		double d1 = sc.nextDouble();
		double d2 = sc.nextDouble();
		
		result(n1, n2, d1, d2);
		
		sc.close();
	} // end main()

	public static void result(int n1, int n2, double d1, double d2) {
		if(Math.abs(n1) >= Math.abs(n2)) {
			System.out.println(n1);
		}else {
			System.out.println(n2);
		}
		
		if(Math.abs(d1) >= Math.abs(d2)) {
			System.out.printf("%.2f", d2);
		} else {
			System.out.printf("%.2f", d1);
		}
		
	}
	
}
