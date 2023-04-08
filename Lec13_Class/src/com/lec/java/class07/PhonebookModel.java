package com.lec.java.class07;

// 클래스: 멤버변수 (+ 생성자) + 메소드 => 데이터 타입
public class PhonebookModel {
	// 멤버 변수
	String name;
	String phoneNum;
	String email;
	
	
	// 생성자
	// 1) PhonebookModel(String name, String phoneNum, String email)
	public PhonebookModel(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	// 2) PhonebookModel(String name, String phoneNum)
	public PhonebookModel(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		//this.email = null;
	}
	// 3) 디폴트 생성자
	public PhonebookModel() {}
	
	
	// 메소드
	// 이름: displayInfo()
	// 기능: 멤버 변수들의 값을 출력
	// 리턴 타입: void
	// 매개 변수: none
	public void displayInfo() {
		System.out.println("----- 전화번호부 정보 -----");
		System.out.println("이름: " + name);
		System.out.println("전화번호: " + phoneNum);
		System.out.println("이메일: " + email);
	} // end displayInfo()

	
} // end class PhonebookModel








