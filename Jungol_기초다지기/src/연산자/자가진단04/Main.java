package 연산자.자가진단04;

import java.util.Scanner;

/*
 

 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int c = a++ * --b;
		
		System.out.println(a + " " + b + " " + c);
		
		sc.close();
	} // end main()
} // end class
