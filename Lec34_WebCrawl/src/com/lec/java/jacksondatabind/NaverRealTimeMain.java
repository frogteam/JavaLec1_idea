package com.lec.java.jacksondatabind;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 네이버 실시간 검색어 검색
 * 20' 03 현재
 *   네이버 실검은 아래 주소로 바뀜
 *   https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0
 *   
 *   JSON 현재의 response
 */


public class NaverRealTimeMain {
	
	public static void main(String[] args) throws IOException {
		System.out.println("Naver 실시간 검색어");
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0");
		
		// 바로 URL -> JsonNode 로 읽어 들일수 있다.
		//JsonNode node = mapper.readTree(url);  // json 받는 url 로부터 
		//System.out.println(node.toPrettyString());  // 포맷 갖충 json 문자열로 출력
		
		NaverRealTime rt = mapper.readValue(url, NaverRealTime.class);
		System.out.println(rt.getData().size() + " 개");

		for(NaverRealTimeItem item : rt.getData()) {
			System.out.println(item);
		}
		
		System.out.println("\n프로그램 종료");
    } // end main()
	
 } // end class()

// getter & setter 제공해야 함
@JsonIgnoreProperties(ignoreUnknown = true)
class NaverRealTime{
	private String ts;
	private List<NaverRealTimeItem> data;

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public List<NaverRealTimeItem> getData() {
		return data;
	}

	public void setData(List<NaverRealTimeItem> data) {
		this.data = data;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class NaverRealTimeItem {
	private int rank;
	private String keyword;
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return String.format("%02d : %s", rank, keyword);
	}
}

/*
{
	ts: "2020-03-31T21:17:00+0900",
	sm: "agallgrpmamsi0en0sp0",
	rop: [
		{
			ag: "all"
		},
		{
			gr: "01"
		},
		{
		ma: "-2"
		},
		{
			si: "00"
		},
		{
		en: "00"
		},
		{
			sp: "00"
		}
	],
	data: [
		{
			rank: 1,
			keyword: "의정부성모병원",
			keyword_synonyms: [ ]
		},
		{
			rank: 2,
			keyword: "호밀밭의 파수꾼",
			keyword_synonyms: [
			"호밀밭의 파수꾼 줄거리"
			]
		},
		{
		rank: 3,
		keyword: "패시브 뜻",
		keyword_synonyms: [
		"패시브"
		]
		},
		{
		rank: 4,
		keyword: "윤석열 최측근",
		keyword_synonyms: [ ]
		},
		{
		rank: 5,
		keyword: "서울아산병원",
		keyword_synonyms: [
		"서울아산병원 코로나",
		"아산병원"
		]
		},
		{
		rank: 6,
		keyword: "비디오스타",
		keyword_synonyms: [ ]
		},
		{
		rank: 7,
		keyword: "지오스톰",
		keyword_synonyms: [ ]
		},
		{
		rank: 8,
		keyword: "빙그레",
		keyword_synonyms: [
		"해태 아이스크림"
		]
		},
		{
		rank: 9,
		keyword: "일진에게 찍혔을때2",
		keyword_synonyms: [ ]
		},
		{
		rank: 10,
		keyword: "우주전쟁",
		keyword_synonyms: [ ]
		},
		{
		rank: 11,
		keyword: "위험한 약속 인물관계도",
		keyword_synonyms: [ ]
		},
		{
		rank: 12,
		keyword: "잃어버린 세계를 찾아서",
		keyword_synonyms: [ ]
		},
		{
		rank: 13,
		keyword: "코렌스",
		keyword_synonyms: [ ]
		},
		{
		rank: 14,
		keyword: "관악구 모자 살인사건",
		keyword_synonyms: [ ]
		},
		{
		rank: 15,
		keyword: "박창훈",
		keyword_synonyms: [ ]
		},
		{
		rank: 16,
		keyword: "한지우",
		keyword_synonyms: [ ]
		},
		{
		rank: 17,
		keyword: "위험한 약속",
		keyword_synonyms: [ ]
		},
		{
		rank: 18,
		keyword: "이언주",
		keyword_synonyms: [ ]
		},
		{
		rank: 19,
		keyword: "화요일 예능",
		keyword_synonyms: [
		"화요일 드라마"
		]
		},
		{
		rank: 20,
		keyword: "스페인 공주",
		keyword_synonyms: [ ]
		}
	]
}
 */








