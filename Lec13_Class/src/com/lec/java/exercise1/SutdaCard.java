package com.lec.java.exercise1;

public class SutdaCard {
//	private static int n;
//	private static boolean i;
	int num;
	boolean isKwang;

	SutdaCard(int n, boolean i) {
		System.out.println("매개변수 두개차리 생성자 호출");
		num = n;
		isKwang = i;
	}

	SutdaCard() {
		this(1, true);
		System.out.println("디폴트 생성자 호출");
	}
	
	String info(){
		return null;
	}
}
