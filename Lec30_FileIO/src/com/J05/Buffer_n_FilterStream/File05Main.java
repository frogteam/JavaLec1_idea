package com.J05.Buffer_n_FilterStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* Buffered Stream + Buffer 예제
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
*/

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴
		
		try (
				// try with resource 로 구현
				InputStream in = 
						new FileInputStream("temp/big_text.txt");
				BufferedInputStream bin =
						new BufferedInputStream(in);
				OutputStream out =
						new FileOutputStream("temp/copy_big_text.txt");
				BufferedOutputStream bout =
						new BufferedOutputStream(out);
		){
			byte[] buff = new byte[1024];
			int bytesRead = 0;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis();
			while (true) {
				bytesRead = bin.read(buff);
				if (bytesRead == -1) {
					break;
				} // end if
				
				//bout.write(buff);  // 안된다.  배열의 길이만큼 write 한다.
				bout.write(buff, 0, bytesRead);
				bytesCopied += bytesRead;
				
			} // end while
			long endTime = System.currentTimeMillis();
			
			System.out.println("전체 복사한 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + (endTime - startTime));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















