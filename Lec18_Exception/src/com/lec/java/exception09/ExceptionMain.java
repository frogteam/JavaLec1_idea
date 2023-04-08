package com.lec.java.exception09;

class ExceptionA extends Exception {
	public ExceptionA() {
		super("ExceptionA 예외 발생");
	} // end constructor
} // end class

class ExceptionB extends RuntimeException {
	public ExceptionB() {
		super("ExceptionB 예외 발생");
	} // end constructor()
} // end class

public class ExceptionMain {

	public static void throwExceptionA() throws ExceptionA {}

	public static void throwExceptionB() throws ExceptionB {}

	public static void throwExceptionAB() throws ExceptionA, ExceptionB {}

	public static void throwExceptionBA() throws ExceptionB, ExceptionA {}

	public static void main(String[] args) {

		// 과연 아래 네개 중에 에러나 발생하는것과 발생하지 않는 것은 각각 무엇일까?
//		throwExceptionA(); 
//		throwExceptionB(); 
//		throwExceptionAB();
//		throwExceptionBA();
//		throwExceptionBA();

	} // end main()
} // end class
