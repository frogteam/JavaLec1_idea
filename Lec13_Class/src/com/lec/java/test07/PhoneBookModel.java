package com.lec.java.test07;

public class PhoneBookModel {
	String name;
	String phonenumber;
	String email;

	public PhoneBookModel() {

	}// 디폴트 생성자

	public PhoneBookModel(String name, String phonenumber, String email) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
	}// 매개변수가 있는 생성자

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void displayInfo(){
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phonenumber);
		System.out.println("이메일 : " + email);
	}
}// end of class
