package com.lec.java.file06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream

Java 의 data 를 입출력하는 용도로 사용 (ex: int, double...)
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try (
				OutputStream out =
						new FileOutputStream("temp/data.bin");
					// new FileOutputStream("temp/data.bin", true);  //  append 모드
				DataOutputStream dout =
						new DataOutputStream(out);
				InputStream in =
						new FileInputStream("temp/data.bin");
				DataInputStream din =
						new DataInputStream(in);
		){
			dout.writeBoolean(true); // 1 byte
			dout.writeInt(100); // 4 bytes
			dout.writeDouble(3.14); // 8 bytes
			dout.writeChar('A'); // 2 bytes    writeChar(int),  writeShort(int), writeLong(long) 이다.  
			
			
			// 최종 작성후에 data.bin 파일의 크기를 체크해보자   15byte 가 나올것이다.
			
			boolean b = din.readBoolean();
			System.out.println("boolean: " + b);
			
			int num1 = din.readInt();
			System.out.println("int: " + num1);
			
			double num2 = din.readDouble();
			System.out.println("double: " + num2);
			
			char ch = din.readChar();
			System.out.println("char: " + ch);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















