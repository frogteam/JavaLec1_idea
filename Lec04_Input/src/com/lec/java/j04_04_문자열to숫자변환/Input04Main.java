package com.lec.java.j04_04_문자열to숫자변환;

import java.util.Scanner;

// 일반적으로 프로그램에서 숫자입력하는 것이 처음에는 '문자열(String)' 형태다
//  ex) 웹, 모바일앱..
//
// 이를 숫자 타입으로 변환해야 산술 연산등이 가능해진다
//
// Integer.parseInt(문자열)  -->  int 로 변환
// Double.parseDouble(문자열)  --> double 로 변환

// Byte.parseByte(문자열)
// Short.parseShort(문자열)
// Long.parseLong(문자열)
// Float.parseFloat(문자열)
// Boolean.parseBoolean(문자열)

// 문자열이 해당 타입으로 변환할수 없는 문자열이면 NumberFormatException 예외 발생 (에러)


public class Input04Main {

	public static void main(String[] args) {
		System.out.println("입력: 문자열 -> 숫자 변환");
		
		Scanner sc = new Scanner(System.in);
		
		// 정수 3개를 문자열로 입력 받고 합을 구하기
		System.out.print("숫자 3개 (int, int, int)를 입력받으세요 >");
		String in1 = sc.next();
//		String in2 = sc.next();
//		String in3 = sc.next();
		int i1 = Integer.parseInt(in1);   // 문자열 in1  을  int 로 변환
		
		// 다음과 같이 한줄에 가능
		int i2 = Integer.parseInt(sc.next());
		int i3 = Integer.parseInt(sc.next());  // 결국 ↔ sc.nextInt() 와 동일
		
		System.out.println("합: " + (i1 + i2 + i3));

		// 실수 3개를 문자열로 입력받고 곱을 구하기
		System.out.print("숫자 3개 (double, double, double)를 입력받으세요 >");
		double d1 = Double.parseDouble(sc.next());   // 입력받은 문자열  을  double 로 변환
		double d2 = Double.parseDouble(sc.next());
		double d3 = Double.parseDouble(sc.next()); // 결국 ↔ sc.nextDouble() 와 동일
		
		System.out.println(" 곱: " + (d1 + d2 + d3));

		
		sc.close();
		
	} // end main()

} // end class
