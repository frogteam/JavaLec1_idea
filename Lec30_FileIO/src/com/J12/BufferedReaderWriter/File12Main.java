package com.J12.BufferedReaderWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("BufferedReader / BufferedWriter");
		
		FileWriter fw = null;
		FileReader fr = null; 

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int charRead = 0;  // 읽은 문자 (한개)
		int charsCopied = 0;  // 몇 문자 복사했는지
		long startTime, endTime, elapsedTime;  // 경과시간 체크


		try{
			System.out.println("FileReader/Writer 만 사용");
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy1.txt");
			

			charRead = 0;  // 읽은 문자 (한개)
			charsCopied = 0;
			startTime = System.currentTimeMillis(); // 현재 시간 저장
			while((charRead = fr.read()) != -1) {   // read() 한글자 읽어서 int 리턴
				fw.write(charRead);
				charsCopied++;
			} // end while
			
//			아래와 똑같은 구문입니다
//			while(true) {
//				charRead = fr.read();
//				if(charRead == -1) break;
//				fw.write(charRead);
//				charsCopied++;
//			}

			fw.flush();   // 문자 출력 시 마지막에 꼭 flush() 를 하자,  
						 // flush 를 하지 않으면 정상적으로 복사가 끝나지 않는다.  (확인해보자! ※ 확인하기 어렵다?)
			
			endTime = System.currentTimeMillis(); // 끝난 시간 저장
			elapsedTime = endTime - startTime; // 경과 시간
			
			System.out.println("읽고 쓴 문자수: " + charsCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);

			// ※ 용량 확인 해보자,
			// txt 는 영문이라,  utf-8 에서도 1글자당 1byte 저장되어
			// 용량수와 문자수가 동일하게 나온다.
			
			//-------------------------------------------------------------
			fw.close();
			fr.close();			
			//-------------------------------------------------------------
			System.out.println();
			System.out.println("BufferedReader/Writer + 버퍼 사용");
			
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy2.txt");
			br = new BufferedReader(fr); // 장착!
			bw = new BufferedWriter(fw);
			
			char [] buf = new char[1024];  // 버퍼 제공
			
			
			int charsRead = 0; // 버퍼에 읽어들인 문자의 개수
			charsCopied = 0;
			startTime = System.currentTimeMillis(); // 현재 시간 저장
			while((charsRead = br.read(buf)) != -1) {
				bw.write(buf, 0, charsRead);
				charsCopied += charsRead;
			}
			bw.flush(); // ★
			
			endTime = System.currentTimeMillis(); // 끝난 시간 저장
			elapsedTime = endTime - startTime; // 경과 시간
			
			System.out.println("읽고 쓴 문자수: " + charsCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
//				if(fr != null) fr.close();
//				if(fw != null) fw.close();
				if(br != null) br.close();
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n프로그램 종료");		
		
	} // end main()
} // end class
