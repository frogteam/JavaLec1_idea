package com.lec.java.crawl07.xmljson;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.json.JSONArray;
import org.json.JSONObject;

/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */


public class JsonXmlMain {

	public static final String REQ_SERVICE = "CardSubwayStatsNew";
	public static final String API_KEY = "4d46796d7366726f3833774a774955"; 
	
	public static void main(String[] args) {
		System.out.println("서울시 지하철호선별 역별 승하차 인원 정보");
		
		int startIndex;	// 요청시작위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호) 
		int endIndex;		// 요청종료위치 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호) 
		String date;   // 날짜 yyyymmdd 형식
		
		String url_address;
		StringBuffer sb;
		
		startIndex = 1;
		endIndex = 5;
		date = "20190101";

		System.out.println("--- XML 파싱 ----");
		url_address = buildUrlAddress("xml", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseXML(sb.toString());
		
		System.out.println();

		System.out.println("--- JSON 파싱 ----");
		url_address = buildUrlAddress("json", startIndex, endIndex, date);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	/**
	 * 
	 * @param reqType  요청파일타입 xml : xml, xml파일 : xmlf, 엑셀파일 : xls, json파일 : json
	 * @param startIndex
	 * @param endIndex
	 * @param stationName
	 * @return
	 */
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
	
	
	public static void parseXML(String xmlText) {
	    // XML 파싱
	    DocumentBuilderFactory dbFactory;
	    DocumentBuilder dBuilder;

        try {
            // DOM parser 객체 생성
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            
            // String -> InputStream 변환
            InputStream stream = new ByteArrayInputStream(xmlText.getBytes("utf-8"));  // UnsupportedEncodingException 처리
            
            // org.w3c.dom.Document : DOM 객체
            Document dom = dBuilder.parse(stream);  // SAXException, IOException

            // 사실 굳이 String 을 안거치고, 바로 아래와 같이 해도 되었다.
            //  Document doc = dBuilder.parse(conn.getInputStream());  // 곧바로 InputStream 으로부터 받아 파싱
            
            Element docElement = dom.getDocumentElement();   // dom 의 최상위 document element 
            docElement.normalize();   // 흩어진 text node 들을 정렬하는 등의 절차, XML 파싱하기전에 꼭 normalize() 부터 해주자
            
            NodeList nList = dom.getElementsByTagName("row");  // 서울시 지하철 역사 정보<row>~</row> 로 구성됨
            
            // 테스트
            System.out.println("<row> 개수 : " +  nList.getLength());
            
            System.out.println();
            for(int i = 0; i < nList.getLength(); i++) {
            	Node node = nList.item(i);   // Node 는 interface 다.  DOM 의 다양한 Node객체들은 Node를 구현(상속)받은 객체들이다
            	
            	// 당연히 element node 이겠지만, 체크해보자
            	if(node.getNodeType() != Node.ELEMENT_NODE) continue; 
            	
            	Element rowElement = (Element)node;  // node 를 Element로 형변환
            	
            	String LINE_NUM = 
            			rowElement.getElementsByTagName("LINE_NUM").item(0).getChildNodes().item(0).getNodeValue();
            	String SUB_STA_NM =
                        rowElement.getElementsByTagName("SUB_STA_NM").item(0).getChildNodes().item(0).getNodeValue();
            	String RIDE_PASGR_NUM =
                        rowElement.getElementsByTagName("RIDE_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue();
            	String ALIGHT_PASGR_NUM =
                        rowElement.getElementsByTagName("ALIGHT_PASGR_NUM").item(0).getChildNodes().item(0).getNodeValue();

            	
            	System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
            } // end for
            
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end parseXML()
	
	public static void parseJSON(String jsonText) {
		// org.json  라이브러리 다운로드
		// https://mvnrepository.com/artifact/org.json/json
		// 최신버젼 클릭후, Files 항목 클릭해서 다운로드
		
		JSONObject jObj = new JSONObject(jsonText);  // JSON 파싱 --> JSONObject 로 변환
		JSONArray row = jObj.getJSONObject("CardSubwayStatsNew").getJSONArray("row");
		
		System.out.println("row 의 개수: " + row.length());
		System.out.println();
		
		for(int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i);
			
			String LINE_NUM = station.getString("LINE_NUM");
			String SUB_STA_NM = station.getString("SUB_STA_NM");
			int RIDE_PASGR_NUM = station.getInt("RIDE_PASGR_NUM");
			int ALIGHT_PASGR_NUM = station.getInt("ALIGHT_PASGR_NUM");
		
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", LINE_NUM, SUB_STA_NM, RIDE_PASGR_NUM, ALIGHT_PASGR_NUM);
		}
		
	} // end parseJSON

} // end class
