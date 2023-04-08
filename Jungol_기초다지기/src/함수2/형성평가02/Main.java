package 함수2.형성평가02;


/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=76&sca=10c0


두 개의 실수를 입력받아 각각의 제곱근을 구하고 두 제곱근 사이에 존재하는 정수의 개수를 출력하는 프로그램을 작성하시오. 
단, 입력받는 두 실수는 양수이며 두 제곱근 사이라는 말은 두 제곱근을 포함한다.
   
  
[입력예] 
12.0 34.789

[출력예]
2
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num1 = sc.nextDouble();
		double num2 = sc.nextDouble();
		
		System.out.println(getBetween(num1, num2));
		
		sc.close();
	} // end main()
	
	public static int getBetween(double num1, double num2) {
		double d1 = Math.sqrt(num1);
		double d2 = Math.sqrt(num2);
		
		double bigger = (d1 > d2) ? d1 : d2;
		double smaller = (d1 > d2) ? d2 : d1;
		
		int n1 = (int)Math.ceil(smaller);
		int n2 = (int)Math.floor(bigger);
		
		//System.out.println(Math.sqrt(num1) + " " + Math.sqrt(num2));
		
		return (n1 <= n2)? n2 - n1 + 1 : 0;
		
	}

	
} // end class


/*
	47.41 39.96
	6.8854919940408035 6.321392251711643

*/