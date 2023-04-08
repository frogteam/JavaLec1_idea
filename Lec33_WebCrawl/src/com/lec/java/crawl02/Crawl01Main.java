package com.lec.java.crawl02;

import java.io.IOException;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 외부 라이브러리 사용
// 1. 라이브러리 *.jar 파일 다운로드
// 2. Build Path 에서 추가
// jsoup 라이브러리
// 	: HTML 문서 파싱
// 네이버 뉴스 캐스트  크롤링 

public class Crawl01Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트 크롤링");

		String url;
		Response response;
		Document doc; // DOM

		url = "https://www.naver.com/";
		// url 로 request 하고 받은 response 리턴

		response = Jsoup.connect(url).execute();
//		request 결과코드
//		200 성공
//		404 url 존재하지 않음
//		500 서버 내부 
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러

		System.out.println(response.statusCode());

		// DOM <-- response
		doc = response.parse();
		System.out.println(doc.title()); // <title> 의 content
		System.out.println(doc.location()); // 현재 웹 문서의 url
		String outerHtml = doc.outerHtml();

		System.out.println(outerHtml.substring(0, 200) + "...");

		System.out.println();
		// Document 나 Element 객체의
		// select() , selectFirst() 로 특정 element (들) 찾아냄
		// select("CSS Selector") --> Selector 에 해당하는 모~든 Elements 을 리턴
		// selectFirst("CSS Selector") --> Selector 에 해당하는 Element 중 첫번째 하나만 리턴

		Elements news_elements = doc.select("#news_cast li.ca_item");

		System.out.println(news_elements.size() + "개");

		for (Element news_element : news_elements) {
			Element element = news_element.selectFirst("a.ca_a");
			System.out.println(element.text()); // content 의 text 추출
			//System.out.println(element.attr("href")); // 특정 attribute 값 추출
		}

		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
