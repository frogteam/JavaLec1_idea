package 연산자.자가진단03;

import java.util.Scanner;

/*
 http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=157&sca=1030

 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(n++);
		System.out.println(++n);
		
		sc.close();
	} // end main()
} // end class
