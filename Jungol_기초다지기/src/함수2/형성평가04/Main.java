package 함수2.형성평가04;

/*

 */

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(powerOfTwo(n));
		
		sc.close();
	} // end main()

	public static int powerOfTwo(int n) {
		if (n == 0) return 1;		
		return  2 * powerOfTwo(n - 1);
	}

} // end class
