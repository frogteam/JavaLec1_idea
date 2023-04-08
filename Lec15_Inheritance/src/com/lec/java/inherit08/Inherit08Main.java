package com.lec.java.inherit08;

/* 클래스 접근권한 수식어:
 *  1. public class: 어디서나 상속이 가능한 클래스
 *  2. (default) class: 같은 패키지 안에서만 상속이 가능한 클래스
 *  3. final class: 상속될 수 없는 클래스
 */

public class Inherit08Main {

	public static void main(String[] args) {
		System.out.println("public/default/final class");
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

final class TestFinal {
	int test;
	
} // end class TestFinal

//class TestClass extends TestFinal { }
// TestFinal은 final로 선언되었기 때문에 
// 다른 클래스의 부모(super) 클래스가 될 수 없다. 즉, 상속될 수 없다.


















