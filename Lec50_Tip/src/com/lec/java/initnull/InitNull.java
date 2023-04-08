package com.lec.java.initnull;

public class InitNull {
	// 레퍼런스 변수를 null 로 초기화 하는 것
	
	public static void main(String[] args) {
		String str1 = "";
		String str2 = null;
		
		System.out.println("str1:" + System.identityHashCode(str1));
		System.out.println("str2:" + System.identityHashCode(str2));
		
		// str2 의 기본 해시 값은 0 이다.  즉 힙 영역에 데이터가 생성되어 있지 않았다.
		// 큰 데이터를 다룰 경우, 사용하지 않을 때는 null로 초기화 하는 습관이 좋다.
		// (메모리 절약)
		
	}
}
