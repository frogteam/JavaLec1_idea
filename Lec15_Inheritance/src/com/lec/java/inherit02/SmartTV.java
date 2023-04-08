package com.lec.java.inherit02;


// extends 키워드를 사용하여 상속

// BasicTV
//   └─ SmartTV

// 자바 에선 오로지 '하나의 부모'로부터 상속받을수 있습니다 (단일 상속)
// 다중 상속 허용하지 않음

// ※ IntelliJ: 클래스에서 CTRL + H => Hierarchy 창 뜬다.
public class SmartTV extends BasicTV {
	// sub class에서는 super class가 가지고 있는 멤버 변수들은 
	// 선언하지 않아도 사용할 수 있다.
	// super class에 없는 멤버 변수만 선언해 주면 됨
	String ip;
	
	public void displayInfo() {
		super.displayInfo();  // 부모(super) 의 displayInfo() 를 먼저 실행하고
		System.out.println("IP 주소: " + ip);
	} // end displayInfo()
	
} // end class SmartTV






