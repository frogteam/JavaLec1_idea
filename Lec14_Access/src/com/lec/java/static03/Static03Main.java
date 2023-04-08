package com.lec.java.static03;

import java.util.Calendar;

/*
 * Singleton 디자인
 * 	인스턴스가 최대 1개까지만 생성되어야 하는 디자인 패턴
 */

public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		
//		Test t1 = new Test();  // 불가
		
		// Test 클래스의 인스턴스 생성
		Test t1 = Test.getInstance();
		System.out.println("t1: num = " + t1.getNum());
		t1.setNum(123);
		System.out.println("t1: num = " + t1.getNum());
		
		System.out.println();
		Test t2 = Test.getInstance();
		t2.setNum(12345);
		System.out.println("t1: num = " + t1.getNum());
		System.out.println("t2: num = " + t2.getNum());

		// 동일한 주소
		System.out.println(t1);
		System.out.println(t2);
		
		// Singleton 을 사용하는 예
		//Calendar c = new Calendar();  생성자 제공 안됨
		Calendar calendar = Calendar.getInstance();

	} // end main()

} // end class Static03Main











