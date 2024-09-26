package com.lec.java.j18_07_CustomException;

import java.util.Scanner;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 */
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);
	
	
	public static int inputScore() throws ScoreException {
		int score = sc.nextInt();
		if (score < 0 || score > 100) {
			// 우리가 만든 Exception 클래스 사용
			// 우리가 만든 Exception 클래스의 인스턴스 생성
			ScoreException ex = new ScoreException();
			//ScoreException ex = new ScoreException( score + "값은 입력할수 없는 점수입니다" );
			
			
			throw ex;  // 예외 객체를 인위적으로 throw, throw 하면 메소드는 종료된다.
		}
		
		return score;
	} // end inputScore()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");
		
		System.out.println();
		try {
			System.out.println("국어 점수 입력:");
			int kor = inputScore();
			System.out.println("kor = " + kor);
			
			System.out.println("영어 점수 입력:");
			int eng = inputScore();
			System.out.println("eng = " + eng);
			
		} catch (ScoreException ex) {
			System.out.println(ex.getMessage());
			
		} finally {
			sc.close();
		} // end finally

		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main












