package com.lec.java.variables04;

public class Variables04Main {

	public static void main(String[] args) {
		System.out.println("변수 04 - 실수 자료 타입");
		
		// 실수형 자료 타입: float(4바이트), double(8바이트)
		// 정수형 자료 타입의 기본형은 int
		// 실수형 자료 타입의 기본형은 double
		
		double number1 = 3.141592;
		//float number2 = 3.14;  // Type mismatch: cannot convert from double to float
		// 별도의 표기가 없는 경우 소수점이 있는 리터럴은 double로 인식
		// 3.14는 double형. 이것을 작은 자료 타입인 float에 저장할 수 없다.
		float number3 = 3.14f;
		// 숫자 뒤에 f를 붙여주면, float 리터럴이 된다. 자바는 그 숫자를 float 타입으로 인식
		
		
		// 실수 타입의 최소, 최대값
		System.out.println("float: " + Float.MIN_VALUE+ " ~ " + Float.MAX_VALUE);
		System.out.println("double: " + Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		
		System.out.println("number4 = " + number4);
		System.out.println("number5 = " + number5);
		// float과 double은 저장할 수 있는 값의 크기만이 아니라
		// 소수점 이하 정밀도(precision)에서도 차이가 있다.
		
		// 실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; // 지수표기법 (exponential notation)
		System.out.println("number6 = " + number6);
		System.out.println("number7 = " + number7);
		
		double number8 = 0.0001213;
		double number9 = 1.23e-4;
		System.out.println("number8 = " + number8);
		System.out.println("number9 = " + number9);
		
		double number10 = 0.00012;
		System.out.println("number10 = " + number10);

	} // end main()

} // end class Variables04Main








