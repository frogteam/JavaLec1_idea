package com.lec.java.access05;

import java.util.Scanner;

public class Access05Main {

	// 멤버 변수로 Scanner 선언, 인스턴스 생성
	static Scanner sc = new Scanner(System.in);
	
	// 메소드
	public static void insertStudentInfo() {
		System.out.println();
		System.out.println("----- 학생 정보 입력 -----");
		
		System.out.println("학번 입력:");
		int id = sc.nextInt();
		sc.nextLine(); // 숫자 입력 뒤에 엔터키 입력을 제거하기 위해서
		
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		
		System.out.println("국어 점수 입력:");
		int kor = sc.nextInt();
		
		System.out.println("영어 점수 입력:");
		int eng = sc.nextInt();
		
		System.out.println("수학 점수 입력:");
		int math = sc.nextInt();
		
		// Score 인스턴스를 생성
		Score score = new Score(kor, eng, math);
		
		// Student 인스턴스 생성
		Student stu = new Student(id, name, score);
		
//		stu.setName("aaa");
		
		// 확인
		stu.displayInfo();
		
	} // end insertStudentInfo()
	
	
	public static void showMenu() {
		System.out.println();
		System.out.println("성적처리 프로그램 메뉴");
		System.out.println("--------------------");
		System.out.println(" [1] 입력");
		System.out.println(" [2] 열람");
		System.out.println(" [3] 종료");
		System.out.println("--------------------");
		System.out.println("메뉴 선택:");
		
	} // end showMenu()
	
	
	public static void main(String[] args) {
		System.out.println("성적처리 프로그램 v0.2");
		
		boolean isContinue = true;
		do {
			showMenu();
			int menu = sc.nextInt();
			sc.nextLine(); // 숫자 입력 뒤에 엔터 입력을 무시하기 위해서

			switch (menu) {
			case 1: // 입력
				insertStudentInfo();
				isContinue = true;
				break;

			case 2: // 종료
				isContinue = false;
				System.out.println("프로그램을 종료합니다...");
				break;

			default: // 에러 처리
				System.out.println("잘못 입력했습니다.");
				System.out.println("다시 입력하세요~");
				isContinue = true;
			} // end switch
		
		} while (isContinue);

	} // end main()

} // end class Access07Main











