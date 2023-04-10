package com.lec.java.j04_03_nextLine_next;

import java.util.Scanner;

public class Input03Main {

	public static void main(String[] args) {
		System.out.println("nextLine() vs next()");
		
		Scanner sc = new Scanner(System.in);
		
		// > aaa bbb ccc   <- 입력
		System.out.print("여러 단어의 문장을 입력하세요 >");
		String in = sc.nextLine();   // 한 라인 (\n 입력까지) 전체
		System.out.println("in : " + in);     // //  aaa bbb ccc   
		
		// next()
		// 다음 단어 (token) 을 받아서 String 으로 돌려준다
		System.out.print("여러 단어의 문장을 입력하세요 >");
		// > aaa bbb ccc   <- 입력
		String in1 = sc.next();
		System.out.println("in1 : " + in1);   // aaa
		
		// 다음것(token)을 입력받으려 할때
		// 기존의 버퍼에 담겨 있는 내용들이 담긴다
		// 
		String in2 = sc.next();
		System.out.println("in2 : " + in2);
		String in3 = sc.next();
		System.out.println("in3 : " + in3);
		
		//숫자 타입도 여러개를 '한줄'에 받을수 있다.
		// > 100 3.14 300
		System.out.print("숫자 3개 (int, double, int)를 입력받으세요 >");    
		int i1 = sc.nextInt();
		double d1 = sc.nextDouble();
		int i2 = sc.nextInt();
		
		System.out.println("i1, d1, i2: " + i1 + ", " + d1 + ", " + i2);
		
		sc.close();
	} // end main()

} // end class
