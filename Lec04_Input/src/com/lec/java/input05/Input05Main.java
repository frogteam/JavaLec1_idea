package com.lec.java.input05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input05Main {
	public static void main(String[] args) throws IOException {
		System.out.println("표준입력:");

//		System 클래스에서 제공하는 read() 라는 함수사용
//		read() 함수는 1byte 크기만 입력스트림에서 읽어와 ASCII 코드에 해당하는 int 값을 리턴한다.
		
		//문자 a 저장
		char chr = (char)System.in.read();   // IOException
		System.out.println(chr);
		
		//숫자 + Enter 입력 시, Enter(\r\n) 값은 입력스트림 버퍼에 그대로 남아 있게 된다.
		// 그래서 문자 2개를 날려주어야 한다
		System.in.read();
		System.in.read();
		
		//문자 a 대신 97숫자 저장
		int ascii = System.in.read();
		System.out.println(ascii);

		System.in.read();
		System.in.read();
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String srt = in.readLine();
		System.out.println(srt);


		System.out.println("프로그램 종료");
	} // end main()
} // end class
