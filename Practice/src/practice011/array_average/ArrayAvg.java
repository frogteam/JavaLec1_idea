package practice011.array_average;

import java.util.Scanner;

/*
 	① int형 배열 5개 (배열)로 점수를 받아서, (Scanner 사용) 
 	총점과 평균 출력해보세요
 	
 	② 위에서 입력 받은 배열값중에서
 		최대값, 최소값을 출력해보세요.
 */
public class ArrayAvg {

	public static void main(String[] args) {
		// int형의 길이는 5개인 배열을 score라는 이름으로 선언
		int[] score = new int[5];
		
		// 키보드로 입력을 받아서 배열 원소 5개를 초기화
		// 1) Scanner 사용
		// 2) for문 사용
		int total = 0; // 총점
		double avg = 0.0; // 평균
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < score.length; i++) {
			System.out.println("점수 입력: ");
			score[i] = sc.nextInt();
			total = total + score[i];
		} // end for ()
		
		avg = (double) total / score.length;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		
		sc.close();

		//---------------------------------
		// 최대값 구하기
		System.out.println();
		int max = score[0];
		// 최대값을 저장할 변수를 선언, 첫번째 점수를 최대값으로 초기화. 
		for(int i = 1; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];
				// 저장된 점수와 max값을 비교해서 더 큰 값을 다시 max에 저장
			}
			// 위의 if문을 삼항연산자를 사용해서 바꾼 문장
			// max = (score[i] > max) ? score[i] : max;
		}
		System.out.println("최댓값: " + max);
		
		//---------------------------------
		// 최솟값 구하기
		int min = score[0];
		for(int i = 1; i < score.length; i++) {
			if(score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("최솟값: " + min);
		
		
		
	} // end main()

} // end class
