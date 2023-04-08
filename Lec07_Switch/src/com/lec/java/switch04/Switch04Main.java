package com.lec.java.switch04;

public class Switch04Main {

	public static void main(String[] args) {
		System.out.println("String 타입을 switch에서 사용하기");
		
		// 변수타입(String) 변수이름(language) = 값("...");
		String language = "C++";
		switch (language) {
		case "Java":
			System.out.println("Hello, Java!");
			break;
			
		case "C++":
			System.out.println("Hello, C++!");
			break;
			
		case "Swift":
			System.out.println("Hello, Swift!");
			break;
			
		default:
			System.out.println("프로그래밍 언어도 참 많지요~~");
		} // end switch

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









