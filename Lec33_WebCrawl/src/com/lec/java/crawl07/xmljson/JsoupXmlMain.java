package com.lec.java.crawl07.xmljson;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/* Jsoup 를 사용한 XML 파싱
 * 
 *  Jsoup 는 기본적으로는 HTML 파싱을 하지만 
 *  xml parser 를 지정해주면 XML 파싱도 가능하다
 */

public class JsoupXmlMain {
	
	public static final String REQ_SERVICE = "CardSubwayStatsNew";
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; 


	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");
		String url = buildUrlAddress("xml", 1, 5, "20191001");
		
		// XML 파싱할때는 만드시 xml parser 를 사용한다.!
		Document doc = Jsoup.connect(url)
				.parser(Parser.xmlParser()).get();
		
		Elements elements = doc.select("row");
		for(Element element : elements) {
        	String LINE_NUM = 
        			element.selectFirst("LINE_NUM").text().trim();
        	String SUB_STA_NM =
        			element.selectFirst("SUB_STA_NM").text().trim();
        	String RIDE_PASGR_NUM =
        			element.selectFirst("RIDE_PASGR_NUM").text().trim();
        	String ALIGHT_PASGR_NUM =
        			element.selectFirst("ALIGHT_PASGR_NUM").text().trim();

        	System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
		}
		
		System.out.println("\n프로그램 종료");
	} // end main
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {
		// 만약 URL 에 한글이 들어가야 하는 경우는 반드시 URL 인코딩을 해주어야 한다
		// java.net.URLEncoder 임포트
		// java.io.UnsupportedEncodingException 임포트
		
		String url_address = "http://openapi.seoul.go.kr:8088/" + 
                API_KEY + "/" + reqType + "/" + REQ_SERVICE + "/" +
                startIndex + "/" + endIndex + "/" + date;
		
		System.out.println(url_address);
		
		return url_address;
	}
	

} // end class
