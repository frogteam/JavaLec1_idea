package com.lec.java.array14;

import java.util.Arrays;

public class Array14Main {

	public static void main(String[] args) {
		System.out.println("Reference 타입 주의할 사항");
		
		int a = 10;
		int b = 20;
		System.out.println("a:" + a + " , b:" + b);
		a = b;   // '값'의 복사다
		System.out.println("a:" + a + " , b:" + b);  // a: 20, b: 20
		a = 30;
		System.out.println("a:" + a + " , b:" + b);  // a: 30, b: 20
		
		// 배열의 경우는?
		
		int [] arrA = new int[]{10, 10, 10};
		int [] arrB = new int[]{20, 20, 20};
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));
		arrA = arrB;  // 이것도 '값' 의 복사다
		System.out.println(Arrays.toString(arrA) + " " + Arrays.toString(arrB));
		arrA[0] = 500;  // 무엇을 바꾸는 건가?
		System.out.println(Arrays.toString(arrA) + " " + Arrays.toString(arrB)); // 결과는?
		
		// arrA = arrB  하는 순간 먼저 arrA 가 referencing 하던 배열 객체의 reference 는 끊긴다.
		// reference 가 끊긴 객체는 JVM 의 Garbage Collector 에 의해 메모리에서 삭제된다.
		
		// 같은 주소!
		System.out.println(arrA);
		System.out.println(arrB);
		
	} // end main

} // end class
