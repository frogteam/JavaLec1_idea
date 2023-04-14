package com.lec.java.crawl03;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*  URLEncoder, URLEncoder
 * 
 * URL 은  한글, 특수기호, 공백등의 문자를 담을수 없다.
 * 따라서 위와 같은 문자를 URL에 담으려면 URL 인코딩 을 하여야 한다.
 *  
 * O : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC
 * X : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=파이썬
 * 
 * 인코딩-디코딩 온라인 테스트 사이트
 * 	http://coderstoolbox.net/string/#!encoding=xml&action=encode&charset=us_ascii
 * 
 */
public class Url02EncodeMain {

	public static void main(String[] args) {
		System.out.println("URLEncoder, URLEncoder");

		String str = "파이썬";
		
		// 한글관련 자주 사용되는 인코딩
		String charset[] = {
			"euc-kr", "ksc5601", "cp949", "ms949", // 한글 표현 -> 2byte
			"iso-8859-1", "8859_1", "ascii",   // 한글 불가
			"UTF-8",   // 한글표현 -> 3byte
			"UTF-16"   // 한글표현 -> 2byte  (이상?)
		};
		
		for (int i = 0; i < charset.length; i++) {			
			try {
				// 문자열 -> URL 인코딩
				System.out.println(String.format("%11s → %s", charset[i],
						URLEncoder.encode(str, charset[i])));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		String enc_utf8 = "%ED%8C%8C%EC%9D%B4%EC%8D%AC";
		String enc_utf16 = "%FE%FF%D3%0C%C7%74%C3%6C";
		try {
			// 인코딩된 URL -> 문자열로 디코딩 
			System.out.println(URLDecoder.decode(enc_utf8, "UTF-8"));
			System.out.println(URLDecoder.decode(enc_utf16, "UTF-16"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

/*
 * 한글 인코딩의 이해 2편: 유니코드와 Java를 이용한 한글 처리
 * https://d2.naver.com/helloworld/76650
 * UTF-8, UTF-16 차이
 * https://pickykang.tistory.com/13
 */
