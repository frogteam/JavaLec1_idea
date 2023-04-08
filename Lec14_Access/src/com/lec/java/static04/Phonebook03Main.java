package com.lec.java.static04;

import java.util.Scanner;


public class Phonebook03Main {

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
		PhonebookModel pb = PhonebookModel.getPbInst();
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setEmail(email);
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
		System.out.println("전화번호부 v0.3");
//		boolean isContinue = true;
		
		while (true) {
			showMenu();
			int menu = sc.nextInt();
			sc.nextLine(); // 숫자 입력 후에 엔터키 입력을 무시하기 위해서
			
			switch (menu) {
			case 1:
				insertPhonebook();
				break;
				
			case 2:
//				isContinue = false;
//				break;
				System.out.println("프로그램을 종료합니다...");
				return;
				
			default:
				// 1, 2번 외에 다른 숫자 선택했을 때 처리
				System.out.println("메뉴 선택을 잘못하셨습니다.");
				System.out.println("다시 선택해 주세요~");
				
			} // end switch
			
		} // end while

	} // end main()

} // end class Phonebook02Main








