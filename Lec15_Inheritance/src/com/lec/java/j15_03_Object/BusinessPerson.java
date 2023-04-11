package com.lec.java.j15_03_Object;

public class BusinessPerson extends Person {
	// 멤버 변수
	String company;
	
	// 메소드
	public void showInfo() {
		//System.out.println("제 이름은 " + name + "입니다.");
		whoAmI();
		System.out.println("회사는 " + company + "입니다.");
	}
	
} // end class BusinessPerson







