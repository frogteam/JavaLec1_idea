package com.lec.java.j18_08_연습CustomException;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);
	
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();
		if (age < 0) {
			// 우리가 만든 예외를 발생
			// 예외 클래스의 인스턴스를 생성
			AgeInputException ex = new AgeInputException();
			
			// exception 인스턴스를 throw
			throw ex;
		}
		
		return age;
		
	} // end inputAge()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");
		
		while (true) {
			try {
				int age = inputAge();
				System.out.println("나이: " + age);
				
				break;

			} catch (AgeInputException e) {
				System.out.println(e.getMessage());
				System.out.println("다시 입력하세요");
				sc.nextLine();
			} 
		} // end while

		sc.close();
		System.out.println("프로그램 종료...");
		
	} // end main()

} // end class Exception08Main












