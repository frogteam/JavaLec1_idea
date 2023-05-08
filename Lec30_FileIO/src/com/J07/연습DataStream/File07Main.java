package com.J07.연습DataStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//Program <=== DataInputStream <=== FileInputStream <=== File
//Program ===> DataOutputStream ===> FileOutputStream ===> File


public class File07Main {

	private static final String FILEPATH = "temp/ascii.bin";
	
	public static void main(String[] args) {
		System.out.println("Data Filter Stream 연습");
		try (
				OutputStream out =
						new FileOutputStream(FILEPATH);
				DataOutputStream dout = 
						new DataOutputStream(out);
				InputStream in =
						new FileInputStream(FILEPATH);
				DataInputStream din =
						new DataInputStream(in);
				)
		{
			for (int i = 0; i < 65536; i++) {   // char (2byte) 만큼.
				dout.writeChar(i);
			} // end for
			
			for (int i = 0; i < 65536; i++) {
				System.out.println(din.readChar());
			} // end for
			
			// 수행후, ascii.bin 파일의 크기를 확인해보자
			// 65536 x 2 = 131072 byte 일거다.
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class File07Main



















