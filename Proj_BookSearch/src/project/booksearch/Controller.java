package project.booksearch;

// 필요한 동작들에 대한 설계 --> 메소드

public interface Controller {
	
	// url 크롤링 --> InfoStore 를 생성
	// 검색어(search)를 받아서 특정 서점(store) 크롤링하여 결과를 리턴(InfoStore)
	// 크롤링 끝나고 수행하는 익명클래스 작성
	public abstract InfoStore crawlStore(String search, String bookStore, OnCompleteListener onCompleteListener);
	
	// SearchResult -> FILE 저장
	public abstract void saveData(String path, SearchResult result); 
	
	// FILE --> SearchResult 읽어오기
	public abstract SearchResult loadData(String path);
}

// 크롤링이 완료되면 수행하는 리스너
interface OnCompleteListener{
	public abstract void complete(InfoStore infoStore);
}






















