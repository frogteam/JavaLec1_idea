package com.lec.java.crawl09.heder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 요기요
 * 
 * https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&order=rank&page=0&search=&zip_code=730011
 */

// header 추가하기 : HttpURLConnection 으로는?
// Jsoup 로는?
// jackson-databind 는 ?

// https://www.getpostman.com 
// ↑ 개발자들이 사용하는 도구입니다.
// 다운받아 설치하신뒤 실행해보세요

public class YogiyoMain {

	public static void main(String[] args) throws IOException {
		StringBuffer sb;
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&order=rank&page=0&search=&zip_code=730011"; 

		sb = readFromUrl(url);
		//System.out.println(sb);  // 확인하기
		
		System.out.println("---------------");		
		// 맛집 이름 / 평점 뽑아내기
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.readValue(sb.toString(), Yogiyo.class));
		
		
	}  // end main
	
	public static StringBuffer readFromUrl(String url_address) {
		// Java 에서 웹 연결을 위한 객체 두가지
		// URL : 웹 상의 주소, HttpURLConnection : 웹연결
		// URLConnection
		//  └─ HttpURLConnection
		URL url = null;  				// java.net.URL
		HttpURLConnection conn = null;  // java.net.HttpURLConnection;
		
		InputStream in = null;
		InputStreamReader reader = null;		// 스트림 기반의 reader
		BufferedReader br = null;    // java.io.BufferedReader;   문자(character) 기반 reader
		
		char [] buf = new char[512];	// 입출력용 문자 버퍼 준비
		StringBuffer sb = new StringBuffer();
		
		try {
			url = new URL(url_address);   // 실패하면 MalformedURLException 처리
			conn = (HttpURLConnection)url.openConnection();     // connection 객체 생성,  실패하면 IOExeption 처리
			
			if(conn != null) {
				// 실제 접속하기 전에
				conn.setConnectTimeout(2000);  // 2초 이내에 연결이 수립안되면 java.net.SocketTimeoutException  발생
												// ** response 받는 시간이 아니다
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);      // 캐시 사용안함
				
				// 아래와 같이 헤더를 추가해야 한다.
				conn.setRequestProperty("X-ApiKey", "iphoneap");
				conn.setRequestProperty("X-ApiSecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				conn.setRequestProperty("User-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
				
				
				
				System.out.println("request시작: " + url_address);
				conn.connect();          // request발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");
				
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				if(responseCode == HttpURLConnection.HTTP_OK) {  // 200
					
					in = conn.getInputStream();   // HttpURLConnection 으로부터 받기 위해 InputStream 추출
					reader = new InputStreamReader(in, "utf-8");
					br = new BufferedReader(reader);
					
					int cnt;
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt);
					}
					
				}else {
					System.out.println("response 실패");
					return null;
				}
				
			} else {
				System.out.println("conn Null");
				return null;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(br != null) br.close();// 스트림 해제
//				if(reader != null) reader.close();   // 안해도 된다
//				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}   

			if(conn != null) conn.disconnect();   // 종료전에 연결 반드시 끊기
		}

		//System.out.println(sb);
		return sb;
	} // end readFromUrl()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Yogiyo {
	private List<Restaurant> restaurants;

	public List<Restaurant> getRestaurants() {return restaurants;}
	public void setRestaurants(List<Restaurant> restaurants) {this.restaurants = restaurants;}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		for(Restaurant e : restaurants) {
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Restaurant {
	private String name;
	
	@JsonProperty("review_avg")
	private double reviewAvg;

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public double getReviewAvg() {return reviewAvg;}
	public void setReviewAvg(double reviewAvg) {this.reviewAvg = reviewAvg;}
	@Override
	public String toString() {
		return String.format("%s %.1f", name, reviewAvg);
	}
}






