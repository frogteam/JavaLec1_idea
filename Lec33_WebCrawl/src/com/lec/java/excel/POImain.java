package com.lec.java.excel;

import java.io.FileOutputStream;
import java.io.IOException;

/* 엑셀 파일 라이브러리 POI
 * 2019.10월  현재 4.1.1
 * 
 * 다운로드
 * 	http://poi.apache.org/download.html   
 * 		zip 버젼 다운로드(윈도우 기준)
 * 
 * 	poi-*.jar  파일들을 라이브러리에 추가
 * 
 *  빌드패스 추가
 *  	프로젝트 properties - Build Path - Configure Build Path..
 * 
 * 
 * 
 * 
 * 		xlsx 파일		| 	xls 파일
 * ──────────────────────────────────
 * 	XSSFWorkbook	|	HSSFWorkbook
 *  XSSFSheet		|	HSSFSheet
 *  XSSFRow			|	HSSFRow
 *  XSSFCell		|	HSSFCell
 * 
 */

public class POImain {

	public static final String FILEPATH1 = "data\\test.xlsx";
	
	public static void main(String[] args) {

	} // end main()
	
	
	// 예제
	// 시트들 생성
	// 숫자타입, 문자타입, 시간/날짜 타입 저장하기
	// 엑셀 파일 쓰기 (xlsx)
	public static void writeXlsx(String filepath) throws IOException {
		
		try(
				FileOutputStream os = new FileOutputStream(FILEPATH1);
			){
			System.out.println("파일 생성");
		}
		
	} // end writeXlsx

	// https://blog.naver.com/PostView.nhn?blogId=wlgh325&logNo=221391234592&categoryNo=40&parentCategoryNo=0&viewDate=&currentPage=1&postListTopCurrentPage=1&from=postView
	
} // end class


