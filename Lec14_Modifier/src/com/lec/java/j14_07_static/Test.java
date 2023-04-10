package com.lec.java.j14_07_static;

public class Test {
	// 멤버 변수
	int num; // 인스턴스 변수
	static int sNum; // 클래스 변수(static 변수)
	
	// 메소드
	// 인스턴스 메소드
	public void show() {
		System.out.println("인스턴스 num = " + num);
		System.out.println("클래스(static) sNum = " + sNum);
	}
	
	// 클래스(static) 메소드
	public static void show2() {
		// 컴파일 에러:
		// static인 곳에서 static이 아닌 변수/메소드는 사용할 수 없다.
		//System.out.println("인스턴스 num = " + num);
		
		System.out.println("클래스(static) sNum = " + sNum);
	}

} // end class Test