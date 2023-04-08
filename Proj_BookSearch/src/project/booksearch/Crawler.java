package project.booksearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 컨트롤러의 역할
public class Crawler implements Controller{

	private SearchResult result;  // 검색결과
	
	// 싱글톤 디자인 
	// 인스턴스의 생성을 1개까지로 제한
	private static Crawler instance = null;
	private Crawler() {}
	public static Crawler getInstance() {
		if(instance == null) {
			instance = new Crawler();
		}
		return instance;
	}
	
	@Override
	public InfoStore crawlStore(String search, String bookStore, OnCompleteListener onCompleteListener) {

		InfoStore infoStore = null;
		
		try {
			switch(bookStore) {
			case C.YES24:
				infoStore = crawlYes24(search);
				break;
			case C.ALADDIN:
				infoStore = crawlAladdin(search);
				break;
			case C.INTERPARK:
				infoStore = crawlInterpark(search);
				break;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 크롤링 완료후 수행해야 할 코드 수행
		if(onCompleteListener != null) {
			onCompleteListener.complete(infoStore);
		}
		
		return infoStore;
	}
	

	@Override
	public void saveData(String path, SearchResult result) {
		try(
				OutputStream out = new FileOutputStream(path);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			oout.writeObject(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public SearchResult loadData(String path) {
		SearchResult result = null;
		
		try(
				InputStream in = new FileInputStream(path);
				ObjectInputStream oin = new ObjectInputStream(in);
				){
			
			result = (SearchResult)oin.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	//-------------------------------------------
	// yes24 크롤링 메소드
	private InfoStore crawlYes24(String search) throws IOException {
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName("yes24");
		
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

		infoStore.setList(list);
		
		return infoStore;
		
	} // end crawlYes24()
	
	
	// aladdin 크롤링 메소드
	private InfoStore crawlAladdin(String search) throws IOException {
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName("Aladdin");

		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); 
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		url = String.format("https://www.aladin.co.kr/search/wsearchresult.aspx?SearchTarget=Book&KeyRecentPublish=0&OutStock=0&ViewType=Detail&CustReviewCount=0&CustReviewRank=0&KeyFullWord=%s&KeyLastWord=%s&CategorySearch=&chkKeyTitle=&chkKeyAuthor=&chkKeyPublisher=&chkKeyISBN=&chkKeyTag=&chkKeyTOC=&chkKeySubject=&KeyWord=%s", 
				URLEncoder.encode(search, "cp949"),
				URLEncoder.encode(search, "cp949"),
				URLEncoder.encode(search, "cp949")
				);    
		
		//System.out.println(url);

		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		// selector 구성...
		rowElements = doc.select("#Search3_Result .ss_book_box");
		//System.out.println(rowElements.size());  // 20개 나오는지 확인

		
		for(Element element : rowElements) {
			
			// 썸네일 url
			String imgUrl = element.selectFirst("img").attr("src").trim();
			//System.out.println(imgUrl);
			
			// 책제목 & 가격
			Element a = element.selectFirst("a.bo3");
			String bookTitle = a.text().trim();
			String linkUrl = a.attr("href").trim();
			double price = Double.parseDouble(
					element.selectFirst("span.ss_p2 span").text().trim().replace(",", "")
					);
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		infoStore.setList(list);
		
		
		return infoStore;
		
	} // end crawlAladdin()

	// Interpark 크롤링 메소드
	private InfoStore crawlInterpark(String search) throws IOException {
		InfoStore infoStore = new InfoStore();
		infoStore.setStoreName("InterPark");

		ArrayList<InfoBook> list = new ArrayList<InfoBook>(); 
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;
		
		url = String.format("http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query==%s", 
				URLEncoder.encode(search, "cp949")
				);    
		
		//System.out.println(url);

		response = Jsoup.connect(url).execute();
		doc = response.parse();
		
		// selector 구성...
		rowElements = doc.select("#bookresult > form > div.list_wrap");
		//System.out.println(rowElements.size());  // 20개 나오는지 확인

		
		for(Element element : rowElements) {
			
			// 썸네일 url
			String imgUrl = element.selectFirst("img.bd").attr("src").trim();
			//System.out.println(imgUrl);
			
			// 책제목 & 가격
			Element a = element.selectFirst("div.info > p.tit a");
			String bookTitle = a.text().trim();
			String linkUrl = a.attr("href").trim();
			double price = Double.parseDouble(
					element.selectFirst("div.price > p.FnowCoupon > span.nowMoney").text().trim().split("원")[0].replace(",", "")
					);
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		infoStore.setList(list);
		
		
		return infoStore;
		
	} // end crawlInterpark()
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end class
