package com.lec.java.class07;

import java.util.Scanner;

public class Phonebook01Main {

	// 멤버 변수
	static Scanner sc = new Scanner(System.in);
	
	// 메소드
	// 이름: insertPhonebook
	// 기능: 스캐너로부터 이름, 전화번호, 이메일을 입력받아서
	//       폰북 객체 생성하고 화면에 출력
	// 리턴 타입: void
	// 매개 변수: none
	public static void insertPhonebook() {
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일 입력:");
		String email = sc.nextLine();
		
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.displayInfo();
		
	} // end insertPhonebook()
	
	public static void main(String[] args) {
		System.out.println("전화번호부 v0.1");

		// 클래스이름 변수이름 = new 생성자();
		PhonebookModel pb1 = new PhonebookModel();
		pb1.displayInfo();
		
		System.out.println();
		PhonebookModel pb2 = new PhonebookModel("조은이", "010-1234-5678");
		pb2.displayInfo();
		
		System.out.println();
		PhonebookModel pb3 = 
				new PhonebookModel("성쌤", "010-1111-2222", "jake@gmail.com");
		pb3.displayInfo();
		
		System.out.println();
		insertPhonebook();
		
		System.out.println("프로그램 종료");
	} // end main()
	

} // end class Phonebook01Main





