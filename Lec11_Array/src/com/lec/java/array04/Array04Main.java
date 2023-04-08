package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		// int형의 길이는 5개인 배열을 score라는 이름으로 선언
		int[] score = new int[5];
		
		// 키보드로 입력을 받아서 배열 원소 5개를 초기화
		// 1) Scanner 사용
		// 2) for문 사용
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 입력: ");
			score[i] = sc.nextInt();
		} // end for ()
		
		sc.close();
		
		// 입력받은 데이터 확인
		System.out.println();
		System.out.println("입력한 점수 확인:");
		for (int i = 0; i < score.length; i++) {
			System.out.println("score[" + i + "] = " + score[i]);
		}
		
		// 총점, 평균 계산 후 출력
		System.out.println();
		int total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		double avg = (double) total / score.length;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		
		// 입력받은 점수의 최대값과 최소값을 출력
		System.out.println();
		int max = score[0];
		// 최대값을 저장할 변수를 선언, 첫번째 점수를 최대값으로 초기화. 
		for (int i = 1; i < score.length; i++) {
			if (score[i] > max) {
				// i 번째 점수와 max 값을 비교해서 더 큰 값을 max 에 덮어쓰기
				max = score[i];
			} // end if

			// 위의 if문을 삼항연산자를 사용해서 바꾼 문장
//			max = (score[i] > max) ? score[i] : max;
			
		} // end for ()
		System.out.println("최대값 = " + max);
		
		int min = score[0];
		// 최소값을 저장할 변수 min을 선언, score[0]를 일단 저장
		for (int i = 1; i < score.length; i++) {
//			if (score[i] < min) {
//				min = score[i];
//			} // end if
			
			min = (score[i] < min) ? score[i] : min;
			
		} // end for
		System.out.println("최소값 = " + min);
		
	} // end main()

} // end class Array04Main








