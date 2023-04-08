package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준입력(Standard Input): 키보드로부터 입력
 * Scanner 객체 사용
 * 
 */
public class Input01Main {

	public static void main(String[] args) {
		System.out.println("표준입력: Scanner 사용");
		
		Scanner sc = new Scanner(System.in);  // import 필요
		
		int num1, num2;
		
		System.out.print("숫자1을 입력하세요: ");
		num1 = sc.nextInt(); // 키보드로부터 정수 한개를 입력받아서 리턴
		System.out.print("숫자2를 입력하세요: ");
		num2 = sc.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		// 만약 nextInt() 에서 문자를 입력하면 InputMismatchException 예외 발생
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		
		
		sc.close();  // Scanner 객체를 사용한 뒤에는 반드시 close() 를 해주어야 한다
		// close() <-- 사용한 시스템 자원 (키보드, hw, 파일, 네트워크, 데이터베이스 등...) 을 시스템에 반납
		
		System.out.println("프로그램 종료");
		
	} // end main
} // end class
