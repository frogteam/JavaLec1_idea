package com.lec.java.crawl01.jsoupbasic;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupBasicMain {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup Basic");
		
		Element element;  
		Elements elements;
		
		File input = new File("data/simple.html");
		// 파일에서 읽어들여서 DOM 으로 파싱
		Document doc = Jsoup.parse(input, "UTF-8");
		
		//System.out.println(doc.outerHtml());

		element = doc.selectFirst("h1");
		System.out.println(element.outerHtml());		
		System.out.println(element.text());  // text()
		
		
		// <ul> 의 <li> 들
		
		
		// attribute 들 뽑기
		
		
		// remove() 하기
		
		
		// 텍스트에서 숫자에 콤마 없애기 , 단위(원) 없애기

		System.out.println("\n프로그램 종료");
	} // end main

} // end class








