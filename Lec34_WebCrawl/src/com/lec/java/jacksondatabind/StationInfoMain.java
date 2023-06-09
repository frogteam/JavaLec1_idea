package com.lec.java.jacksondatabind;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * jacksondatabind - JSON 파싱 연습
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울

 */
public class StationInfoMain {

	public static void main(String[] args) throws IOException {
		System.out.println("jaskson-databind 연습 2 ");
		
		ObjectMapper mapper = new ObjectMapper();
		Scanner sc = new Scanner(System.in);
		System.out.print("역을 입력해주세요 :");
		String choice_name = sc.nextLine();
		String name = String.format("http://swopenapi.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%s",
				URLEncoder.encode(choice_name,"utf-8"));
				
		URL url = new URL(name);
//		URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8");
		
		Station station = mapper.readValue(url, Station.class);
		
		int count =1;
		for(info e : station.getStationList()) {
			System.out.printf("%d: %5s %4s %5s\n", count, e.getStatName(), e.getSubId(), e.getSubName());
			count++;
		}
		
		System.out.println("\n 프로그램 종료");
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Station{
	public ArrayList<info>  stationList;

	public ArrayList<info> getStationList() {
		return stationList;
	}

	public Station(ArrayList<info> stationList) {
		super();
		this.stationList = stationList;
	}

	public Station() {
		super();
	}

	public void setStationList(ArrayList<info> stationList) {
		this.stationList = stationList;
	}

	
	
}
@JsonIgnoreProperties(ignoreUnknown = true)
class info{
	@JsonProperty("statnNm")
	String statName;
	@JsonProperty("subwayId")
	String subId;
	@JsonProperty("subwayNm")
	String subName;
	
	public info() {
		super();
	}
	
	public info(String statName, String subId, String subName) {
		super();
		this.statName = statName;
		this.subId = subId;
		this.subName = subName;
	}
	
	public String getStatName() {
		return statName;
	}
	public void setStatName(String statName) {
		this.statName = statName;
	}
	public String getSubId() {
		return subId;
	}
	public void setSubId(String subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	
	
}
