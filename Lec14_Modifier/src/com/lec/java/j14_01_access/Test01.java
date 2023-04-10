package com.lec.java.j14_01_access;

public class Test01 {
	// 접근권한 수식어: private, (default), protected, public
	// 접근권한수식어 자료형 변수이름;
	private int privateNum;
	int defaultNum;
	protected int protectedNum;
	public int publicNum;
	
	// 메소드
	void test() {
		// 클래스의 멤버변수/멤버베소드들은 같은 클래스에 있는 모든 메소드에서 
		// 직접 사용이 가능 

		privateNum = 111; // 자신이 선언된 클래스에서 직접 사용 가능
		defaultNum = 222;
		protectedNum = 333;
		publicNum = 444;
		
		privateMethod();
		defaultMethod();
		protectedMethod();
		publicMethod();
		
	} // end test()
	
	private void privateMethod() {
		System.out.println("Test01 - private method");
	}
	
	void defaultMethod() {
		System.out.println("Test01 - default method");
	}

	protected void protectedMethod() {
		System.out.println("Test01 - protected method");
	}
	
	public void publicMethod() {
		System.out.println("Test01 - public method");
	}
} // end class Test02








