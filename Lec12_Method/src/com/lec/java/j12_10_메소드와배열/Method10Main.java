package com.lec.java.j12_10_메소드와배열;

import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 */
public class Method10Main {

	public static final int NUM_STUDENT = 10;
	
	public static void main(String[] args) {
		System.out.println("메소드와 배열");
		// 스캐너 생성
		Scanner sc = new Scanner(System.in);
		
		// 점수를 저장할 배열 선언
		int[] score = new int[NUM_STUDENT];
		
		
		// 점수를 입력받아서 score 배열에 저장
		inputScore(sc, score);
		
		// 저장된 점수를 확인
		displayScore(score);

		// x2배 하기
		int[] newArr = doubleUp(score);
		displayScore(newArr);

		// 총점 계산
		int total = calcTotal(score);
		System.out.println("총점: " + total);
		
		// 평균 계산
		double average = (double) total / NUM_STUDENT;
		System.out.println("평균: " + average);
		
		// 점수들 중에서 최대값 출력
		int max = findMax(score);
		System.out.println("최대값: " + max);
		
		// 점수들 중에서 최소값 출력
		int min = findMin(score);
		System.out.println("최소값: " + min);



		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	// method name: inputScore
	// return: void
	// arguments: 
	//   1) Scanner sc - 입력장치
	//   2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] score) {
		System.out.println("length: " + score.length);
		
		for (int i = 0; i < score.length; i++) {
			System.out.print("점수" + (i+1) + " 입력:");
			score[i] = sc.nextInt();
			
		} // end for
		
	} // end inputScore()
	
	
	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	public static void displayScore(int[] score) {
		// for문 또는 enhanced for문
		System.out.println("점수");
		System.out.println("--------------------");
		
		for (var x : score) {
			System.out.print(x + ", ");
		} // end for
		
		System.out.println();
		System.out.println("--------------------");
		
	} // end displayScore()
	
	
	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	public static int calcTotal(int[] score) {
		int total = 0;
		for (int x : score) {
			total += x;
		} // end for
		
		return total;
		
	} // end calcTotal()
	
	
	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	public static int findMax(int[] score) {
		int max = score[0];
		for (int x : score) {
//			if (x > max) {
//				max = x;
//			} // end if
			max = (x > max) ? x : max;
			
		} // end for
		
		return max;
	} // end findMax()
	
	
	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	public static int findMin(int[] score) {
		int min = score[0];
		for (int x : score) {
			min = (x < min) ? x : min;
//			if (x < min) {
//				min = x;
//			}
		} // end for
		
		return min;
	} // end findMin


	// method name: doubleUp()
	// return: int[]  (생성된 배열)
	// arguments: int[] (입력 배열)
	//   입력된 배열의 원소들을 x2 를 한 새로운 배열 생성하여 리턴

	public static int[] doubleUp(int[] arr){
		int[] result = new int[arr.length];

		for(int i = 0; i < arr.length; i++){
			result[i] = arr[i] * 2;
		}

		return result;
	}

} // end class Method09Main












