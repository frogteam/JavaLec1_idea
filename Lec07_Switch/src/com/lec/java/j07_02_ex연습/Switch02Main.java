package com.lec.java.j07_02_ex연습;

public class Switch02Main {

	public static void main(String[] args) {
		System.out.println("switch 연습");

		// 도전
		// switch ~ case 조건문을 사용해서
		// 짝수 이면 --> "짝수입니다"  출력
		// 홀수 이면 --> "홀수입니다"  출력

		int num = 99;
		
		System.out.println("if문 사용:");
		if (num % 2 == 0) {
			// 짝수
			System.out.println("짝수");
		} else {
			// 홀수
			System.out.println("홀수");
		} // end else
		
		System.out.println();
		System.out.println("switch문 사용:");
		switch (num % 2) {
		case 0: // 짝수
			System.out.println("짝수");
			break;
			
		case 1: // 홀수
			System.out.println("홀수");
			break;
			
		default:
			System.out.println("몰라요...");
		} // end switch
		

		System.out.println();
		// 100점: 컴퓨터
		// 90점: 플레이스테이션
		// 80점: 자전거
		System.out.println("if 사용 - 선물");
		int jumsu = 80;
		if (jumsu == 100) {
			System.out.println("선물: 컴퓨터");
		} else if (jumsu == 90) {
			System.out.println("선물: 플레이스테이션");
		} else if (jumsu == 80) {
			System.out.println("선물: 자전거");
		} else {
			System.out.println("선물 없어요~ 공부 더 하세요...");
		} // end else
		
		System.out.println("switch 사용 - 선물");
		switch (jumsu) {
		case 100:
			System.out.println("선물: 컴퓨터");
			break;
			
		case 90:
			System.out.println("선물: 플레이스테이션");
			break;
			
		case 80:
			System.out.println("선물: 자전거");
			break;
			
		default:
			System.out.println("선물 없어요~");
		} // end switch
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









