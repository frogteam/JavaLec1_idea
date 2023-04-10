package com.lec.java.j14_02_access;

public class Test02 {
	
	private int privateNum;
	int defaultNum;
	protected int protectedNum;
	public int publicNum;
	
	// 생성자도 private 으로 가능하다.  어떻게 되나?
//	private Test02(){}
	
	private void privateMethod() {
		System.out.println("Test02 - private method");
	}
	
	void defaultMethod() {
		System.out.println("Test02 - default method");
	}

	protected void protectedMethod() {
		System.out.println("Test02 - protected method");
	}
	
	public void publicMethod() {
		System.out.println("Test02 - public method");
	}
} // end class Test02
