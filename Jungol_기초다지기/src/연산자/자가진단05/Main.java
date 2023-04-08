package 연산자.자가진단05;

import java.util.Scanner;

/*
 

 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 삼항연산자 사용
		System.out.println( (a == b)? true : false );
		System.out.println( (a != b)? true : false );
		
		sc.close();
	} // end main()
} // end class
