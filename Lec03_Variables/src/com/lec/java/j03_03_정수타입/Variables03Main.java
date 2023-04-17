package com.lec.java.j03_03_정수타입;

/**
 * 자바의 기본 자료형(primitive data type)
 * 정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
 * 실수 타입: float(4바이트), double(8바이트)
 * 문자 타입: char(2바이트)
 * 논리 타입: boolean(1바이트)
 */
public class Variables03Main {

	public static void main(String[] args) {
		System.out.println("변수 03 - 변수의 타입들");

		System.out.println("[1] 정수 타입 변수들");
		// byte : 8bit , 256가지 표현 가능한 용량.  -128 ~ +127
		System.out.println("byte: " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 123;
		// byte num4 = 12345; // 컴파일 에러: byte에 저장할 수 있는 크기를 넘어섬
		
		// short: 2byte 16bit, 65536가지 표현 가능한 용량. -32768 ~ 32767
		System.out.println("short: " + Short.MIN_VALUE + " ~ "
				+ Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
		// short num7 = 32768; // 컴파일 에러: short에 저장할 수 있는 크기를 넘어섬
		// short num8 = -32769; // 컴파일 에러: short에 저장할 수 있는 크기를 넘어섬

		// int: 4byte 32bit, -2147483648 ~ 2147483647
		// long: 8byte 64bit, -9223372036854775808 ~ 9223372036854775807

		System.out.println("int: " + Integer.MIN_VALUE + " ~ "
				+ Integer.MAX_VALUE);
		System.out.println("long: " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		// int num9 = 9876543210; // 컴파일 에러: int에 저장할 수 있는 크기를 넘어섬
		// long num10 = 9876543210; // 컴파일 에러:
		
		// 리터럴(literal) : 코드에 직접 입력하는 값.
		// 리터럴도 '타입'이 있다.
		// 자바는 기본적으로
		//   정수타입리터럴을 int 타입으로 인식하려 한다.
		//   실수타입리터럴을 double 타입으로 인식하려 한다.
		
		
		long num11 = 9876543210L;
		// 9876543210 이라는 숫자가 int 타입이 아니라 long 타입임을 명시하기 위해서
		// 숫자 뒤에 영문자 L을 붙여줌
		// 자바에서 정수 타입 변수의 기본은 int임.
		// 자바는 정수 숫자(리터럴)를 별도 표기가 없으면 int라고 생각.
		long num12 = 12; // 12라는 int를 long 타입에 저장
		long num13 = 12L; // 12라는 long을 long 타입에 저장
		int num14 = 12;
		//int num15 = 12L; // 컴파일 에러: long 타입 숫자를 int에 저장하려고 했을 때
		
		
		// 값의 경계선에선?
		// overflow!  underflow! 발생
		byte num15 = Byte.MAX_VALUE;
		byte num16 = (byte)(num15 + 1);
		System.out.println("num15 = " + num15);   // 127
		System.out.println("num16 = " + num16);   // -128
		
		// 진법에 따른 정수 리터럴 표기
		int number1 = 11; // 10진수(decimal)
		int number2 = 0xB; // 16진수(hexadecimal): 0x로 시작
		int number3 = 013; // 8진수(octal): 0으로 시작
		int number4 = 0b1011; // 2진수(binary): 0b로 시작
		
		System.out.println("number1 = " + number1);
		System.out.println("number2 = " + number2);
		System.out.println("number3 = " + number3);
		System.out.println("number4 = " + number4);
		
		// String.format()  을 사용하면 원하는 포맷으로 출력 가능
		System.out.println("number1 = " + String.format("%x", number1));
		System.out.println("number1 = " + String.format("%o", number1));
		
		// Integer.toXxx(n) 함수를 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number1 = " + Integer.toHexString(number1));
		System.out.println("number1 = " + Integer.toOctalString(number1));
		System.out.println("number1 = " + Integer.toBinaryString(number1));	
		
		// 2진수를 0으로 패딩을 채워서 출력하기
		System.out.println(String.format("%8s", Integer.toBinaryString((byte)number1 & 0xFF)).replace(' ', '0'));
		
	} // end main()

} // end class Variables03Main










