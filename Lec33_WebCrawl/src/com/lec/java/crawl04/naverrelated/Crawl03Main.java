package com.lec.java.crawl04.naverrelated;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 네이버 연관 검색어
 * 
 * 네이버 검색 페이지의 맨 하단에 연관검색어 등장 (20'03.31)
 * 
 * 이슈
 * 	url-encoding
 */
public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		String url;
		Document doc; 
		Response response;
		Elements elements;
		
		String searchKeyword;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		
		String encodedResult = URLEncoder.encode(searchKeyword, "utf-8");
//		System.out.println(encodedResult);		
		
		url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=" + encodedResult;
		// Response 를 받아서 response 의 body 를 Document 객체로 받으려면
		response = Jsoup.connect(url).execute();
		System.out.println("Response code:" + response.statusCode());  // 결과 200 나옴
		
		doc = response.parse();
		
		elements = doc.select(".lst_relate ul li");		
		System.out.println("총 " + elements.size() + "개");
		
		for(Element element : elements) {
			System.out.println(element.selectFirst("a").text());
		}
	} // end main()
} // end class
