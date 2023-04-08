package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1 ~ 100 수 중에서 2와 7의 공배수만 출력
		// 2와 7의 공배수: 2의 배수 && 7의 배수
		System.out.println("\n2와 7의 공배수 출력");
		// 1) 1 ~ 100 수를 모두 출력 (for문 이용)
		// 2) 조건에 맞는 경우만 출력을 하도록 수정 (if문)
		for (int count = 1; count <= 100; count++) {
			if ((count % 2 == 0) && (count % 7 == 0)) {
				System.out.println(count);
			} // end if
			
		} // end for

		
		// 1부터 n까지의 합을 계산
		int n = 1000;
		System.out.printf("\n1부터 %d까지의 합 계산\n", n);
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;  // 누적합산
		}
		System.out.println("sum = " + sum);
		
		// 1 ~ 10까지 수 중에서 짝수들의 합을 계산
		// 2 + 4 + 6 + 8 + 10 = 30
		System.out.println("\n1 ~ 10까지 수 중에서 짝수들의 합");
		sum = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i; // sum = sum + i;
			} // end if
		} // end for
		System.out.println("sum = " + sum);
		
	} // end main ()

} // end class For04Main










