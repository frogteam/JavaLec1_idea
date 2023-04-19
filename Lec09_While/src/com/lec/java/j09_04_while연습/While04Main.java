package com.lec.java.j09_04_while연습;

public class While04Main {

	public static void main(String[] args) {
		System.out.println("while문 연습");
		
		// 1 ~ 100 수 중에서 2와 7의 공배수만 출력 (while 사용)
		// 2와 7의 공배수: 2의 배수 && 7의 배수
		System.out.println("1 ~ 100 사이 2와 7의 공배수");
		int count = 1;
		while (count <= 100) {
			if ((count % 2 == 0) && (count % 7 == 0)) {
				System.out.println(count);
			}
			
			count++;
		} // end while
		
		int n = 1;
		while (n <= 10) { 
			System.out.print(n++ + " ");
		}
		
		System.out.println();
		System.out.println("\n1부터 10까지 합(while)");
		int sum = 0; // 합계를 저장할 변수
		n = 1;
		while (n <= 10) {
			sum = sum + n; // sum += n;
			n++;
		} // end while
		System.out.println("sum = " + sum);
		
		System.out.println("\n1 ~ 10 수 중에서 홀수만 더한 결과(while)");
		sum = 0;
		n = 1;
		while (n <= 10) {
			if (n % 2 == 1) {
				sum = sum + n; // sum += n;
			} // end if
			
			n++;
		} // end while
		System.out.println("sum = " + sum);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class While04Main









