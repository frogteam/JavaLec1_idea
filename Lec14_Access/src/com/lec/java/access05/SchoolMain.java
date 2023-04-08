package com.lec.java.access05;

import java.util.Scanner;

public class SchoolMain {

	Scanner sc;
	Student[] stuData = new Student[5];

	public static void main(String[] args) {
		SchoolMain app = new SchoolMain();
		app.init();  // 초기화
		app.run();   // 실행
		app.exit();  // 종료
	} // end main()
	
	public void init() {
		sc = new Scanner(System.in);
	} // end init()
	
	public void run() {
		System.out.println("성적처리 프로그램 v1.0");
		
		
		while(true) {
			showMenu();
			int menu = sc.nextInt();
			sc.nextLine(); // 숫자 입력 뒤에 엔터 입력을 무시하기 위해서

			switch (menu) {
			case 1: // 입력
				insertStudentInfo();
				break;

			case 2: // 열람
				System.out.println("학생 목록 출력");
				showStudent();
				break;
				
			case 3: // 종료
				System.out.println("프로그램을 종료합니다...");
				return; // 종료

			default: // 에러 처리
				System.out.println("잘못 입력했습니다.");
				System.out.println("다시 입력하세요~");
			} // end switch
		} // end while
	} // end run()
	
	public void exit() {
		sc.close();
	} // end exit()

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

	public void insertStudentInfo() {
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

		// 배열의 끝에 삽입
		int i;
		for(i = 0; i < stuData.length; i++) {
			if(stuData[i] == null) {
				stuData[i] = stu;
				System.out.println( (i + 1) + "번째 학생 추가 성공");
				break;
			}
		} // end for
		
		if( i == stuData.length) {
			System.out.println("더 이상 학생 입력 불가");
		}
		
	} // end insertStudentInfo()
	
	public void showStudent() {
		int i;
		for(i = 0; i < stuData.length; i++) {
			Student stu = stuData[i];
			
			if(stu == null) break;  // PhonebookModel 데이터 없으면 출력중지
			
			stu.displayInfo();
		}
		
		System.out.println( i + "명의 학생부 출력");

	} // end showStudent()
	
} // end class
