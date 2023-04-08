package 함수3.자가진단06;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=229&sca=10d0
 
 592 : 함수3 - 자가진단6 

9자리 이하의 자연수를 입력받아 재귀함수를 이용하여 
각 자리 숫자의 제곱의 합을 출력하는 프로그램을 작성하시오.
( main()함수에 변수 하나, 재귀함수에 매개변수 하나만을 사용할 수 있다.)   
  
 [입력예]
12345

[출력예]
55

 
 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(func(n));
		
	} // end main
	
	public static int func(int n) {
		if(n < 10) return n * n;
		int m = n % 10;  // 1의 자리
		return (m * m) + func(n / 10);
	}

} // end class
