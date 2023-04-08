package com.lec.java.crawl07.xmljson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

/* 
■자치구단위 서울 생활인구 일별 집계표
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1

http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)

샘플url

XML 버젼
http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000

JSON 버젼
http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000


※ 한번에 1000개 까지의 데이터만 볼수 있슴

 */
public class Practice1 {
	
	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; 

	
	public static void main(String[] args) throws IOException {
		System.out.println("자치구단위 서울 생활인구 일별 집계표");
	
		String url;
		StringBuffer sb;
		
		System.out.println("--- XML 파싱 ----");
		url = buildUrlAddress("xml", 1, 5);
		
		// XML 파싱할때는 만드시 xml parser 를 사용한다.!
		Document doc = Jsoup.connect(url)
				.parser(Parser.xmlParser()).get();

		Elements elements = doc.select("row");
		
		System.out.printf("%10s %10s %10s %10s\n", "날짜", "구ID", "총생활인구수", "일최대이동인구수");		
		for(Element element : elements) {
			
        	String STDR_DE_ID = 
        			element.selectFirst("STDR_DE_ID").text().trim();
        	String SIGNGU_CODE_SE =
        			element.selectFirst("SIGNGU_CODE_SE").text().trim();
        	double TOT_LVPOP_CO = Double.parseDouble(
        			element.selectFirst("TOT_LVPOP_CO").text().trim());
        	double DAIL_MXMM_MVMN_LVPOP_CO = Double.parseDouble(
        			element.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim());
			
        	System.out.printf("%10s %10s %.2f %.2f\n", STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO, DAIL_MXMM_MVMN_LVPOP_CO);
			
		} // end for
		
		
		System.out.println("--- JSON 파싱 ----");
		url = buildUrlAddress("json", 1, 5);
		sb = readFromUrl(url);
		parseJSON(sb.toString());
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex) {
		
		String urlAddress = "http://openapi.seoul.go.kr:8088/" + 
                API_KEY + "/" + reqType + "/" + REQ_SERVICE + "/" +
                startIndex + "/" + endIndex;
		
		System.out.println(urlAddress);
		
		return urlAddress;
	}

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

	
	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드
		
		JSONObject jObj = new JSONObject(jsonText);  // JSON 파싱 --> JSONObject 로 변환
		JSONArray row = jObj.getJSONObject("SPOP_DAILYSUM_JACHI").getJSONArray("row");
		
		System.out.println("row 의 개수: " + row.length());
		System.out.println();
		
		for(int i = 0; i < row.length(); i++) {
			JSONObject jachi = row.getJSONObject(i);
			
			String STDR_DE_ID = jachi.getString("STDR_DE_ID");
			String SIGNGU_CODE_SE = jachi.getString("SIGNGU_CODE_SE");
			double TOT_LVPOP_CO = jachi.getDouble("TOT_LVPOP_CO");
			double DAIL_MXMM_MVMN_LVPOP_CO = jachi.getDouble("DAIL_MXMM_MVMN_LVPOP_CO");
		
			System.out.printf("%10s %10s %.2f %.2f\n", STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO, DAIL_MXMM_MVMN_LVPOP_CO);
		}
		
	} // end parseJSON

} // end class
