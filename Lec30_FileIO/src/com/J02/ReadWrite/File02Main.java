package com.J02.ReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null; // InputStream 변수 선언
		OutputStream out = null; // OutputStream 변수 선언
		try {
			// FileInputStream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");

			// FileOutputStream 인스턴스 생성
			// 해당 파일이 없으면, 새로 생성.
			//   ..      있었으면, 지우고 새로 생성.
			out = new FileOutputStream("temp/copy_big_text.txt");
			// out = new FileOutputStream("temp/copy_big_text.txt", true);  // 두번째 매개변수에 true 하면 append 모드가 된다.
			
			// 참고로 기존의 파일에 append 하려면. 다음 생성자를 사용한다.
			// FileOutputStream(File file, boolean append)   <-- append가 true 이면 append 된다.
			
			int dataRead;
			int bytesCopied = 0;
			long startTime = System.currentTimeMillis(); // 현재 시간 저장
			
			// 파일 복사
			//  InputStream 에서 한 byte 씩 읽어 들어와서
			//  OutputStream 에 한 byte 씩 쓰기
			while (true) {
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]
				dataRead = in.read();
				if (dataRead == -1) {  // 더이상 읽을 것이 없으면 read() 는 -1 을 리턴한다.
					// 더이상 파일에서 읽을 데이터가 없는 경우
					break; // while 문 빠져나감
				} // end if
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				out.write(dataRead);
				bytesCopied++;
				
				// int read() / write(int) 매개변수가 int라 하여
				// 4byte 를 읽고 쓰는 것은 아님.
				
			} // end while
			
			long endTime = System.currentTimeMillis(); // 끝난 시간 저장
			long elapsedTime = endTime - startTime; // 경과 시간

			System.out.println("읽고 쓴 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
			// 수행후에 실제 생성된 파일의 크기를 보자 1,978,086 byte 인가?

			// IntelliJ 에서 파일 사이즈 확인하기
			//   https://intellij-support.jetbrains.com/hc/en-us/community/posts/206369919-Where-to-view-file-size-
			//   결국 탐색기/터미널 에서 확인해야함.
			// > Project Window의 '특정파일'위에서 우클릭 : "Open in" -> "Terminal"
			// >'현재 편집중인 파일' 은  Navigate - Select in... - 8 Terminal
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { 
			// 리소스 해제
			try {
				if (out != null) {
					out.close();
				} // end if
				if (in != null) {
					in.close();
				} // end if

			} catch (IOException e) {
				e.printStackTrace();

			} // end catch

		} // end finally

		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

