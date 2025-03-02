package com.lec.java.j11_02_배열초기화;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		System.out.println("[1] =====");
		// 배열 선언 따로, 초기화 따로
		// 타입[] 이름 = new 타입[배열의 길이];
		int[] korean = new int[3]; // int 타입의 길이가 3인 배열 선언
						// 배열의 길이(length) : 배열원소의 개수   (3)
						// 배열의 크기(size) : 배열이 차지하는 용량 (12 bytes)
		
		korean[0] = 100; // 초기화
		korean[1] = 90; // 초기화
		korean[2] = 80; // 초기화
		
		for (int n = 0; n < 3; n++) {
			System.out.println("국어" + n + ": " + korean[n]);
		} // end for
		
		System.out.println();
		System.out.println("[2] =====");
		// 배열을 선언과 동시에 초기화 2
		// 타입[] 이름 = new 타입[] {a, b, c, ...};
		// 주의: new를 할 때 배열의 길이를 명시하지 않는다.
		// {}안에 배열의 원소가 몇 개인 지를 보고 배열의 길이가 결정됨
		int[] english = new int[] {30, 20, 30,};  // 끝의 콤마 허용함!
		for (int n = 0; n < 3; n++) {
			System.out.println("영어" + n + ": " + english[n]);
		}
		
		
		System.out.println();
		System.out.println("[3] =====");
		// 배열을 선언과 동시에 초기화 3
		// 타입[] 이름 = {a, b, c, ...};
		// {} 안에 있는 원소들의 개수를 보고 배열의 길이가 결정됨
		int[] math = {99, 88, 77, 66};
		for (int n = 0; n < 4; n++) {
			System.out.println("수학" + n + ": " + math[n]);
		}
		
		// TODO:
		// 국어 점수들의 총점과 평균 계산 (for문 사용)
		int total = 0;
		for (int n = 0; n < 3; n++) {
			total = total + korean[n]; // total += korean[n];
		}
		double avg = (double) total / 3;
		System.out.println("국어 총점: " + total);
		System.out.println("국어 평균: " + avg);
		
		// TODO:
		// 영어 점수들의 총점과 평균 계산
		total = 0;
		for (int n = 0; n < 3; n++) {
			total += english[n];
		}
		avg = (double) total / 3;
		System.out.println("영어 총점: " + total);
		System.out.println("영어 평균: " + avg);
		
		// 수학 점수들의 총점과 평균 계산
		total = 0;
		int n = 0; // 배열 인덱스를 위한 변수
		while (n < 4) {
			total += math[n];
			n++;
		}
		avg = (double) total / 4;
		System.out.println("수학 총점: " + total);
		System.out.println("수학 평균: " + avg);

		System.out.println();
		System.out.println("[4] =====");
		// 배열의 길이를 자동으로 알 수 있는 방법
		// 배열이름.length 
		// (예) korean.length, english.length, math.length
		int[] score = {10, 20, 30, 40, 50, 88};
		System.out.println("score 배열의 길이: " + score.length);
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수: " + score[i]);
		}
		
		total = 0;
		for (int i = 0; i < score.length; i++) {
			total += score[i];
		}
		avg = (double) total / score.length;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		
		//
		System.out.println("\n배열변수를 출력하면?");
		System.out.println(score);
		
	} // end main()

} // end class Array02Main










