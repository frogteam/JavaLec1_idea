package com.J03.Buffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 java.io.InputStream
  |__ java.io.FileInputStream
 java.io.OutputStream
  |__ java.io.FileOutputStream
*/

public class File03Main {

	public static void main(String[] args) {
		System.out.println("File IO 2");
		
		// Java 7부터 도입된 try-with-resource
		// try (리소스 생성) { ... }
		// catch (exception ) { ... }
		// 리소스를 close하는 코드가 없어도 자동으로 close가 실행
		//
		// java.lang.AutoCloseable 나 
		//  └─ java.io.Closeable 을 상속받은 어떠한 객체라도 
		//  try(리소스 생성) 안에 '선언' 되어 있으면
		//  try~catch 가 끝나기 전에 close() 됨.
		
		// InputStream, OutputStream 둘다 Closeable 을 상속(implements) 한다
		
		try (
				// FileInputStream 인스턴스 생성
				InputStream in = 
						//new FileInputStream("temp/origin_text.txt");
						new FileInputStream("temp/big_text.txt");
				// FileOutputStream 인스턴스 생성
				OutputStream out =
						//new FileOutputStream("temp/copy_text.txt");
						new FileOutputStream("temp/copy_big_text.txt");
				)
		{
			byte[] buff = new byte[1024];  // 버퍼 준비
			int lengthRead = 0;  // 읽은 바이트 개수
			int byteCopied = 0;
			
			long startTime = System.currentTimeMillis();
			
			// 파일복사
			while (true) {
				// 데이터 읽기
				
				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 개수 리턴,  읽어들인게 없으면 -1 리턴.
				lengthRead = in.read(buff);
				if (lengthRead == -1) { // 더 이상 읽어 들일 것이 없으면 종료. InputStream 끝
					break; // while 문 나가기
				} // end if
				
				// 데이터 쓰기
				//out.write(buff);  // 안됨!  배열의 길이만큼 씀
				out.write(buff, 0, lengthRead);  // 직전에 읽어들인 데이터만큼 write
				byteCopied += lengthRead;
				
			} // end while
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;
			
			System.out.println("전체 복사한 바이트: " + byteCopied);
			System.out.println("경과 시간: " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
				
	} // end main()

} // end class
















