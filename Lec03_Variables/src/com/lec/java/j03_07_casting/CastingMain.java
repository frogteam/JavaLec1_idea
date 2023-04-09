package com.lec.java.j03_07_casting;


/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → double  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */
public class CastingMain {

	public static void main(String[] args) {
		System.out.println("형변환(Casting)");
		
//                byte b = 10;
//                int n = 100;
//                b = n;
//                
		// 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
		byte num1 = 123; // 123 int형 숫자를 자바가 자동으로 byte 타입으로 변환
//		byte num2 = 512; // 512 숫자는 byte의 표현 범위를 넘기 때문에, 자동 형변환이 불가능
		short num3 = 512; // 512 int형 숫자를 자바가 자동으로 short 타입으로 변환
//		short num4 = 40000; // 40000 수는 short 표현 범위를 넘기 때문에 자동 형변환 불가능

		short s1 = 123;
		int n1 = s1;   // int <- short
		double d1 = n1;  // double <- int
		
		char ch1 = 'A';
		//s1 = ch1;
		n1 = ch1;  // int <- char
		
		
		// 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것.
		byte num5 = (byte)513;
		System.out.println("num5 = " + num5);  // 주의! 자료손실 발생

		
		int n = 10;
//		byte num6 = n;   // int 변수 --> byte 는 implicit casting 안됨.  (비록 용량 범위 안의 수라 하더라도)
		byte num6 = (byte)n;
		
		double avg1 = (99 + 88 + 78) / 3; // 88 계산 결과가 88.0으로 암묵적 형변환
		double avg2 = (double)(99 + 88 + 78) / 3; // 계산 결과가 88.3333333...
		System.out.println("avg1 = " + avg1);
		System.out.println("avg2 = " + avg2);
		
		System.out.println((99 + 88 + 78) / 3);
		
		// 소수점 이하 몇자리까지만 표현하기
		System.out.printf("평균점수: %.1f\n", avg2);  // 소수점 이하 한자리까지만 출력
		
		System.out.println("평균점수: " + String.format("%.1f", avg2));
		
	} // end main()

} // end class CastingMain









