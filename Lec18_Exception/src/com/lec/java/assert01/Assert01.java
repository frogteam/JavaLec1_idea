package com.lec.java.assert01;


/*
 * @ Assertion 이란?
 * Java 1.4 이상부터 지원하는 디버깅 코드
 * 
 * assert() 함수 사용
 * 
 * 사용방식1 : assert [boolean 식]
 *       ex) assert(num > 0);
 * 사용방식2 : assert [boolean 식] : [표현식];
 *       ex) assert(num>0) : "that's it!";
 *       
 * boolean 식이 true 이면 프로그램을 계속 진행,
 * false 이면 AssertionError 발생
 * --------------------------------------- 
 * @ Exception 과의 차이점
 * - Exception : 실행시간(runtime)에 발생되는 예외 상황에 대해, 
 *    비정상적인 종료를 막을수 있는 처리 가능 (프로그램의 '신뢰성' 증가)
 * - Assertion : 프로그래머가 예상한 결과 측정을 위한 검증용으로 사용
 * ----------------------------------------
 * @ 컴파일
 *  javac -source 1.5 Assert01.java 
 * @ 실행시 아래 옵션 필요
 *  java -ea Assert01
 *  
 *  이클립스에서는 Run - Run Configurations..  에서
 *  좌측에서 해당 프로젝트 선택하고
 *  우측에서 [Argument] 탭 선택하고 VM arguments 에 -ea 입력 
 */
public class Assert01 {
	public static void main(String[] args) {
		
		// AssertionError 발생
		//assert args.length > 0;
		assert args.length > 0 : "시작시 매개변수가 필요합니다";
		
		System.out.println(args[0]);
	} // end main()
} // end class
