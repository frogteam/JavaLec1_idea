package phonebook05.list;

import java.util.List;

// VIEW : (PhonebookMainView)와 Controller(PhonebookController) 사이의 인터페이스
// 애플리케이션의 동작(business logic) 정의
public interface Controller {
	public abstract int insert(String name, String phoneNum, String memo); // 정상적으로 저장하면 int값 1 리턴. 아니면 0 리턴
	public abstract List<PhonebookModel> selectAll();
	public abstract PhonebookModel selectByUid(int uid);  // 해당 uid 의 데이터가 없으면 null
	public abstract int update(int uid, String name, String phoneNum, String memo); /* 4 */
	public abstract int delete(int uid);	
} // end Controller


//동작 설계

//이름(name), 전화번호(phonenum), 메모(memo) 를 받아서 전화번호부 데이터 생성 저장

//데이터 전체 목록을 읽어오기

//특정 uid 의 데이터 한개 읽어오기

//특정 uid 의 데이터를 주어진 이름(name), 전화번호(phoneNum), 메모(memo) 로 수정하기

//특정 uid 의 데이터 삭제하기