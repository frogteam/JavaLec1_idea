package com.lec.java.class08;

import java.util.Scanner;

public class Phonebook02Main {

	// 멤버 변수
	static Scanner sc = new Scanner(System.in);
	
	
	// 메소드
	public static void insertPhonebook() {
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.println("이메일 입력:");
		String email = sc.nextLine();
		
		// PhonebookModel 인스턴스 생성
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.displayInfo();

	} // end insertPhonebook()
	
	public static void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 데이터 입력");
		System.out.println("[2] 프로그램 종료");
		System.out.println("------------------");
		System.out.println("선택:");
	} // end showMenu()
	
	
	public static void main(String[] args) {
		System.out.println("전화번호부 v0.2");
//		boolean isContinue = true;
		
		while (true) {
			showMenu();
			int menu = sc.nextInt();
			sc.nextLine(); // 숫자 입력 후에 엔터키 입력을 무시하기 위해서
			
			if(menu == 1) {				
				insertPhonebook();
			} else if (menu == 2) {
				break;
			} else {				
				// 1, 2번 외에 다른 숫자 선택했을 때 처리
				System.out.println("메뉴 선택을 잘못하셨습니다.");
				System.out.println("다시 선택해 주세요~");
			}
			
		} // end while

		System.out.println("프로그램 종료");
	} // end main()

} // end class Phonebook02Main








