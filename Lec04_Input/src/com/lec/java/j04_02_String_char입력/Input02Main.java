package com.lec.java.j04_02_String_char입력;

import java.util.Scanner;

/*
 * 문자열 (String) 입력
 * char 입력
 */
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		
		Scanner sc = new Scanner(System.in);
		
		// line 단위 String 입력
		System.out.print("이름을 입력하세요: ");
		String name = sc.nextLine();  // ENTER 를 입력할때까지의 모든 문자들이 문자열(String)로 리턴
		// George Herbert Walker Prescott III)[
		System.out.print("별명을 입력하세요: ");
		String nick = sc.nextLine();
		
		System.out.println("이름은:" + name + "\n별명은:" + nick);
		
		// char 입력
		// nextChar() 라는 메소드는 없다.
		System.out.print("성별을 입력하세요 M/F: ");
		char gender = sc.next().charAt(0);    // next() 메소드로 토큰단위 String 읽은 뒤에  첫문자만 가져오기
		System.out.println("이름은:" + name + "\n별명은:" + nick + "\n성별:" + gender);
		
//		next() 및 nextXXX() 공백 단위(토큰 단위)로 문자열을 읽기
//		nextLine()는 Enter 단위로 문자열 읽기

		System.out.print("나이를 입력하세요: ");
		int age = sc.nextInt();
		
		System.out.print("주소를 입력하세요: ");
		sc.nextLine();    // 숫자를 입력 받은뒤에 문자열 입력시에는 반드시 nextLine()을 해줌으로 '\n' 을 consume 해야 한다
      
        String addr = sc.nextLine();  // 문자열 입력은 nextLine()

        System.out.println("나이:" + age + "\n주소:" + addr);
        
		sc.close();
	
		System.out.println("프로그램을 종료합니다");
	} // end main()
} // end class
