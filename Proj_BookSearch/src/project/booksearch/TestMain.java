package project.booksearch;

import java.util.Date;

/* 테스트용 코드 입니다.
 * 
 */
public class TestMain {

	Crawler cr = null;
	
	SearchResult result = null;
	
	public static void main(String[] args) {
		TestMain app = new TestMain();
		app.init();
		app.run();
	}
	
	public void init() {
		cr = Crawler.getInstance();
	}
	
	public void run() {
		String search = "파이썬";  // 테스트용 검색어
		
		result = new SearchResult();
		result.setSearch(search);  // 검색어
		result.setDate(new Date());  // 크롤링 일시
		
		InfoStore store;
		
		store = cr.crawlStore(search, C.YES24, null);
		result.setStoreYes24(store);
		
		store = cr.crawlStore(search, C.ALADDIN, null);
		result.setStoreAladdin(store);

		store = cr.crawlStore(search, C.INTERPARK, null);
		result.setStoreInterpark(store);
		
		
		
		System.out.println(result);  //??
		
		// 크롤링 결과 -> 파일 저장해보기
		cr.saveData("data/test.data", result);
		
		result = null;  // 지워보고
		
		// 파일 --> 읽어오기
		result = cr.loadData("data/test.data");
		
		System.out.println(result);
		
	}
	
	

}







