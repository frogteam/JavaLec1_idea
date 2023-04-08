package phonebook03.ex;

import java.util.List;

// View(PhonebookMainView)와 Controller(PhonebookController) 사이의 인터페이스
public interface Controller {
	public abstract int insert(String name, String phoneNum, String memo); // 저장한 데이터 개수 리턴
	public abstract List<PhonebookModel> selectAll();
	public abstract PhonebookModel selectByUid(int uid);
	public abstract int update(int uid, String name, String phoneNum, String memo); // 수정된 데이터 개수 리턴
	public abstract int delete(int uid);// 삭제된 데이터 개수 리턴
} // end Controller

// 동작 설계

// 이름(name), 전화번호(phoneNum), 메모(memo) 를 받아서 데이터 저장

// 데이터 전체 목록을 읽어오기

// 특정 uid 의 데이터 한개 읽어오기

// 특정 uid 의 데이터를 주어진 이름(name), 전화번호(phoneNum), 메모(memo) 로 수정하기

// 특정 uid 의 데이터 삭제하기
