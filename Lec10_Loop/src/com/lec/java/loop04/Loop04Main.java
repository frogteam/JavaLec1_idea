package com.lec.java.loop04;

public class Loop04Main {

	public static void main(String[] args) {
		// TODO: 2단은 x2 까지.. 9단은 x9 까지..  break 사용
		System.out.println("중첩 반복문과 break 연습");
		
		int dan;
		
		System.out.println();
		System.out.println("이중 for문과 break");
		for (dan = 2; dan < 10; dan++) {
			System.out.println(dan + "단");
			for (int n = 1; n <= 10; n++) {
				System.out.println(dan + " x " + n + " = " + (dan * n));
				if (dan == n) {
					break;
				} // end if
				
			} // end for (n)
			
			System.out.println();
		} // end for (dan)
		
		
		System.out.println();
		System.out.println("이중 while문과 break");
		dan = 2;
		while (dan < 10) {
			System.out.println(dan + "단");
			int n = 1;
			while (n < 10) {
				System.out.println(dan + " x " + n + " = " + (dan * n));
				if (dan == n) {
					break;
				} // end if ()
				
				n++;
			} // end while (n)
			
			dan++;
		} // end while (dan)
		
		
		// TODO: 2단은 x2 부터, 3단은 x3 부터 출력  continue 사용
		System.out.println();
		System.out.println("이중 반복문과 continue 연습");
		System.out.println();
		System.out.println("이중 for문과 continue");
		for (dan = 2; dan < 10; dan++) {
			System.out.println(dan + "단");
			for (int n = 1; n <= 10; n++) {
				if (dan > n) {
					continue;
				} // end if
				System.out.println(dan + " x " + n + " = " + (dan * n));
			} // end for (n)
			
			System.out.println();
		} // end for (dan)
		
		
		System.out.println();
		System.out.println("이중 while문과 continue");
		dan = 2;
		while (dan < 10) {
			System.out.println(dan + "단");
			int n = 1;
			while (n < 10) {
				if (dan > n) {
					n++;			// 주의!  이걸 빼먹으면 무한루프 돈다
					continue;
				} // end if ()
				System.out.println(dan + " x " + n + " = " + (dan * n));				
				n++;
			} // end while (n)
			
			dan++;
		} // end while (dan)

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















