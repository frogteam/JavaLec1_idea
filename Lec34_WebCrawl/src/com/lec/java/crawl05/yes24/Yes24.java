package com.lec.java.crawl05.yes24;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * 이미지 크롤링
 * 
 * 참조: 
 * 1. HttpURLConnection 사용
 * http://bsceye.tistory.com/entry/%EC%9D%B4%EB%AF%B8%EC%A7%80-%ED%81%AC%EB%A1%A4%EB%A7%81-2-HttpURLConnection-%EC%9D%B4%EC%9A%A9%ED%95%98%EA%B8%B0?category=694574
 * 
 * 2. ImageIO 사용
 * http://bsceye.tistory.com/entry/%EC%9D%B4%EB%AF%B8%EC%A7%80-%ED%81%AC%EB%A1%A4%EB%A7%81-1-ImageIO-%EC%9D%B4%EC%9A%A9%ED%95%98%EA%B8%B0
 */

/*
	yes24.com 의 검색어 는 cp949 로 url 인코딩 되어 있다.  한글 1글자 = 2byte 
*/

/* 다음 사항들을 크롤링 한다
 * 	책이름 / 책 가격 / 상세페이지 링크 url / 썸네일 url

 *  books 폴더 생성후 실행 
 */


public class Yes24 {

	private static final String PATH = "books";
	
	public static void main(String[] args) throws IOException {
		
		// 검색어 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine();
		sc.close();
		
		Yes24 app = new Yes24();
		
		// 크롤링
		ArrayList<InfoBook> list = app.crawlYes24(search);
		
		// 크롤링 결과 출력 및 썸네일 이미지 다운로드
		int fileIndex = 1;
		for(InfoBook e : list) {
			// 크롤링 정보 출력
			System.out.println(e);
			
			// 썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "yes24%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());

			// 방법1: HttpURLConnection 사용
			// URL 객체 만든다
			
			HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
			//System.out.println(conn.getContentLength() + " bytes");
			
			InputStream in = conn.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			
			FileOutputStream os = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			int byteImg;
			
			byte[] buf = new byte[conn.getContentLength()];
			while((byteImg = bin.read(buf)) != -1) {
				bos.write(buf, 0, byteImg);
			}
		
			bos.close();
			os.close();
			bin.close();
			in.close();
			
			// 방법2: ImageIO 사용
			/* 
			BufferedImage imgData = ImageIO.read(imgUrl);
            File file = new File(fileName);
            ImageIO.write(imgData, "jpg", file);
			*/
			
			System.out.println(fileName + " 이 저장되었습니다");
			fileIndex++;
			
		}
		

		
	} // end main()
	
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException {
		
		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); 
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		// url 을 잘 보면 utf-8 인코딩이 아님을 알수 있다
		// yes24.com 의 검색어 는 cp949 로 url 인코딩 되어 있다.  한글 1글자 = 2byte
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C5%EB%C7%D5%B0%CB%BB%F6&query=" 
				+ URLEncoder.encode(search, "cp949");    
		
		//System.out.println(url);

		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		// selector 구성...
		// selector 만드는게 쉽지 않다. 도전해보자.
		// 크롬의 copy selector 도 활용해보자
		elements = doc.select("#schMid_wrap > div:nth-child(4)");
		// #schMid_wrap > div.goods_list_wrap.mgt30:first-child
		// #schMid_wrap > div:nth-child(4)
		//System.out.println(elements.size());  // 1이 나오는지 확인하기
		
		rowElements = elements.get(0).select("tr:nth-child(odd)");
		//System.out.println(rowElements.size());  // 20개 나오는지 확인
		
		for(Element element : rowElements) {
			
			// 썸네일 url
			String imgUrl = element.selectFirst("td.goods_img > a > img").attr("src").trim();
			//System.out.println(imgUrl);
			
			// 책제목 & 가격
			Element a = element.selectFirst("td.goods_infogrp > p.goods_name > a");
			String bookTitle = a.text().trim();
			String linkUrl = "http://www.yes24.com" + a.attr("href");
			double price = Double.parseDouble(
					element.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", "")
					);
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}

		return list;
		
	}
	
	
	
	
	
} // end class
