package com.lec.java.for03;

public class For03Main {

	public static void main(String[] args) {
		System.out.println("for 연습");
		
		// 1 ~ 10 수 중에서 짝수(2의 배수)만 출력
		for (int count = 1; count <= 10; count++) {
			if (count % 2 == 0) {
				// 짝수일 때만 프린트
				System.out.println(count);
			} // end if
		} // end for
		
		System.out.println("\n다른 방법");
		for (int count = 2; count <= 10; count += 2) {
			System.out.println(count);
		} // end for
		

	} // end main()

} // end class For03Main




