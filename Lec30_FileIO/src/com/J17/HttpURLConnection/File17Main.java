package com.J17.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	URL : 웹 상의 주소, 
 * 	HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");


		String url_address = "https://www.daum.net";
		StringBuffer sb = readFromUrl1(url_address);
		System.out.println(sb.toString().substring(0, 200));

		// Stream<T> 사용
		System.out.println(readFromUrl2(url_address));

		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	
	public static StringBuffer readFromUrl1(String url_address) {
		StringBuffer sb = new StringBuffer();

		// Java 에서 웹 연결을 위한 객체 두가지
		// URL : 웹 상의 주소, HttpURLConnection : 웹연결
		// URLConnection
		//  └─ HttpURLConnection
		URL url = null;  				// java.net.URL
		HttpURLConnection conn = null;  // java.net.HttpURLConnection;
		
		InputStream in = null;
		InputStreamReader reader = null;		// 스트림 기반의 reader
		BufferedReader br = null;    // java.io.BufferedReader;   문자(character) 기반 reader + buffer
		
		char [] buf = new char[512];	// 입출력용 문자 버퍼 준비
		
		try {
			url = new URL(url_address);   // 실패하면 MalformedURLException 처리
			conn = (HttpURLConnection)url.openConnection();     // connection 객체 생성,  실패하면 IOExeption 처리
			
			if(conn != null) {
				// 실제 접속하기 전에
				conn.setConnectTimeout(2000);  // 2초 이내에 연결이 수립안되면 java.net.SocketTimeoutException  발생
												// ** response 받는 시간이 아니다
				conn.setRequestMethod("GET"); // GET 방식 요청
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);      // 캐시 사용안함
				
				System.out.println("connect시작: " + url_address);
				conn.connect();          // request발생 --> 이후 response 받을때까지 delay
				System.out.println("connect 완료");
				
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				if(responseCode == HttpURLConnection.HTTP_OK) {  // 200
					
					in = conn.getInputStream();   // HttpURLConnection 으로부터 받기 위해 InputStream 추출
					reader = new InputStreamReader(in, "utf-8");
					br = new BufferedReader(reader);
					
					// 한줄로 가능
					// br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
					
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

		return sb;
	} // end readFromUrl1()

	// Stream<T> 을 사용하면 더욱 간단하게 해결 가능!
	private static String readFromUrl2(String urlStr){
		try {
			URL url = new URL(urlStr);
			BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			return bf.lines().collect(Collectors.joining());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
} // end class
