package com.lec.java.pb07;

import java.io.Serializable;

// MVC 패턴에서 Model을 담당할 클래스 - 데이터 구조, DB 구조를 담당
public class PhonebookModel implements Serializable {
	// Serializable 인터페이스를 구현하는 이유는
	// Object 타입으로 파일 읽기/쓰기를 하기 위해서
	// (ObjectInputStream/ObjectOutputStream을 사용하기 위해서)
	/**
	 * 
	 */
	private static final long serialVersionUID = -4957538076649769357L;
	
	// 멤버 변수
	private String name;
	private String phoneNum;
	private String email;
	
	// 생성자
	public PhonebookModel() {}
	public PhonebookModel(String name, String phoneNum, String email) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	// 메소드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String displayInfo() {
		String info = name + " | " + phoneNum + " | " + email + "\n";

		return info;
	} // end displayInfo()

} // end class PhonebookModel










