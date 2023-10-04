package com.J11.ReaderWriter;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/*
문자(character) 단위 입출력 스트림 클래스
 java.io.Reader: 프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
  └─ java.io.InputStreamReader
      └─ java.io.FileReader

 java.io.Writer: 프로그램이 '문자 단위' 데이터를 쓰는(write) 통로
  └─ java.io.OutputStreamWriter
      └─ java.io.FileWriter

 FileReader / FileWriter 객체는 '텍스트파일, 즉 문자 단위' 데이터를 읽고/쓰기 할때
 사용하는 기반 스트립 입니다.   따라서 텍스트가 아닌 오디오, 비디오, 등의 파일을 다룰수 없습니다.
 주로 String 이나 char [] 내용을 입/출력 할때 사용합니다.

 텍스트 파일 (Text File) 이란
   사람이 읽을수 있는 글자들이 저장된 파일
   암호화 되지 않은 평범한 텍스트

 이진파일 (Binary File) 이란
   사람이 직접 읽을수는 없슴.
   
   ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
*/


public class File11Main {
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		//String src = "temp/big_text.txt";
		//String dst = "temp/copy_big_text.txt";
		//String src = "temp/origin_text.txt";
		//String dst = "temp/copy_origin_text.txt";
		
		String src = "temp/FileData.txt";
		String dst = "temp/FileData.txt";
		
		try(
			FileWriter fw = new FileWriter(dst);
			FileReader fr = new FileReader(src);   // FileNotFoundException 을 catch 해주어야 함
			
			// fw = new FileWriter(dst, true);   // append 모드
			
			// 혹은 다음과 같이 생성 가능.
			// File fileIn = new File("temp/big_text.txt");   // File 은 Auto Closeable 이 아니라서 try with resource 바깥에 있어야 할듯.
			// FileReader fr = new FileReader(fileIn);
			
			// File fileOut = new File("temp/copy_big_text.txt");
			// FileWriter fw = new FileWriter(fileOut);
				
			// 일전의 byte 스트림 방식과 비교 (즉, 바이너리 파일 방식과 비교)
			// OutputStream out = new FileOutputStream("temp/FileData.bin");
			// DataOutputStream dout = new DataOutputStream(out);
		){
			String str = "안녕하세요";   // 한글 5문자
			char [] charArr = {'J','A','V','A'};  // 알파벳4문자
			
			// 주로 문자열 (String) 이나 char [] 의 내용을 출력할때 사용
			fw.write(str);  
			
			// 저장은 시스템 인코딩 상태에 따라 저장됨
			// UTF-8의 경우 '안녕하세요' 한글 글자는 3byte.  5글자는 15byte로 저장됨.
			//  영어 알파벳은 한글자당 1byte

			
			fw.write(charArr);	// char[] 배열을 출력
			fw.flush();   // Writer 로 출력 마무리 한후에는 flush() 메소드로 출력버퍼의 데이터를 완전히 출력.
			
			
			// 읽기 read
			char [] buff = new char[100];   // char[] 배열이다!! 버퍼 준비
			int charsRead = 0;  // 읽어들인 '문자'의 개수
			charsRead = fr.read(buff);  // 더이상 읽어들일 문자데이터가 없으면 -1 리턴
			for(int i = 0; i < charsRead; i++) {
				System.out.print(buff[i]);
			}
			System.out.println();
			System.out.println("읽은 문자개수: " + charsRead);
			
			
			// 스트림 방식으로도 저장해보기
			//dout.writeChars(str);   // 문자열 String 을 write 함.
			//for(char ch : charArr) {
			//	dout.writeChar(ch);
			//}

			// 실행이 끝나고 FileData.txt 파일과  FileData.bin 파일을 비교해보자.
			// 파일크기도 비교해보고,  실제 텍스트 에디터에서 열어보자
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
