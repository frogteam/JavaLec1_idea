package com.J04.FilterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
/* 보조스트림 (filter stream)
 Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
 Program <=== BufferedInputStream <=== FileInputStream <=== File

 Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
 Program ===> BufferedOutputStream ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FilterInputStream
       |__ java.io.BufferedInputStream

 java.io.OutputStream
  |__ java.io.FilterOutputStream
       |__ java.io.BufferedOutputStream

 참고 ) 보조스트림 (filter stream)
 보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		InputStream in = null;
		BufferedInputStream bin = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		try {
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in);  // 장착!
			
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out);
			
			// TODO:
			// File02 패키지와 동일하게  read/ write 해보세요
			// 단! in.read() 대신 bin.read() 를
			//     out.write(int) 대신 bout.write(int) 를 사용하시면 됩니다
			// finally 도 잊지 마세요
			// 경과 시간 체크도 꼭!
			
			
			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis();
			while (true) {
				dataRead = bin.read();
				if (dataRead == -1) { // Stream 끝
					break; // while 종료
				} // end if
				
				bout.write(dataRead);
				bytesCopied++;
				
			} // end while
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			System.out.println("전체 복사한 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// filter stream 을 close() 하면 장착된 Input/Output Stream 도 함께 close() 됨.
				if (bin != null) {
					bin.close();
				} // end if
				// bin을 close하면, bin을 만든 in도 함께 close됨
				
				if (bout != null) {
					bout.close();
				}
				// bout을 close하면, bout을 만든 out도 함께 close됨
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} // end finally
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














