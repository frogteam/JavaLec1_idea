package com.lec.java.dowhile01;

/*
	 do {
	 	...
	 	...
	 }while(조건식) 문인 경우에는,
	 
	 {...} 안에 있는 실행문들을 한번은 실행을 하고 나서
	 조건식을 검사하게 된다.

 */
public class DoWhile01Main {

	public static void main(String[] args) {
		System.out.println("do-while 반복문");
		
		int n = 0;
		while (n > 0) {
			System.out.println("카운트다운: "  + n);
			n--;
		} // end while ()
		
		// while 문인 경우에는, 초기 조건이 거짓이 되는 경우에
		// while 문 안에 있는 실행문이 한 번도 실행되지 않는다.
		
		System.out.println();
		System.out.println("do ~ while 문");
		// do ~ while 문인 경우에는,
		// {} 안에 있는 실행문들을 한번은 실행을 하고 나서
		// 조건식을 검사하게 된다.
		int n2 = 0; 
		do {
			System.out.println("카운트다운: " + n2);
			n2--;
		} while (n2 > 0);
		
		
		// 구구단 9단을 do ~ while을 써서 출력
		int num = 1;
		do {
			System.out.println("9 x " + num + " = " + (9 * num));
			num++;
		} while (num <= 9);
		
	} // end main()

} // end class DoWhile01Main










