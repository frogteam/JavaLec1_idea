package 함수3.자가진단03;

import java.util.Scanner;

/*
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=226&sca=10d0

589 : 함수3 - 자가진단3 
 
100 이하의 자연수 N을 입력받아 재귀함수를 이용하여 1부터 N까지의 합을 구하는 프로그램을 작성하시오.
   
[입력]  
100

[출력]
5050
  */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(func(n));
	}

	public static int func(int n) {
		if(n == 1) return n;
		return n + func(n - 1);
	}
}
