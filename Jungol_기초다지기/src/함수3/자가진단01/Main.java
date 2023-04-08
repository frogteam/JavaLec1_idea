package 함수3.자가진단01;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=224&sca=10d0
 
 587 : 함수3 - 자가진단1 

20 이하의 자연수 N을 입력받아 재귀함수를 이용해서 문자열 “recursive”를 N번 출력하는 프로그램을 작성하시오.

[입력예]
3

[츨력예]
recursive
recursive
recursive
 

 
 
  */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		func(n);
	}
	
	public static void func(int n) {
		if(n == 0) return;
		System.out.println("recursive");
		func(n - 1);
	}

}
