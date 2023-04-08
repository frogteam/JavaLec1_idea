package phonebook02.mvc_gui;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

// Controller부분을 담당할 클래스
public class PhonebookManager implements DbQuery {

	// 멤버 변수
	public static final int MAX_DATA = 3; // 최대 데이터 개수
	
	// 배열로 구현한다. 그러나, 배열이 계속 증가 할수 있도록 한다.
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];
	// 전화번호를 저장할 배열
	private int count = 0; // 몇 개의 데이터가 저장됐는 지
	
	// singleton 디자인 패턴 적용
	// 1. 생성자 대신 public static 메소드를 제공해서
	// 인스턴스를 생성 또는 생성되어 있는 인스턴스를 리턴(반환)해 주도록 함
	// 2. 해당 클래스의 인스턴스는 오직 하나만 생성될 수 있다.
	private static PhonebookManager instance = null;
	private PhonebookManager() {} // private 생성자
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String email) {
		
		// 만약 배열이 다 찼으면,  MAX_DATA 만큼 추가
		if(count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA);
		}
		
		pbList[count] = new PhonebookModel(name, phoneNum, email);
		count++;
		
		return 1;
	} // end insert()

	// 전화번호부 열람
	@Override
	public Object searchAll() {
		return Arrays.copyOfRange(pbList, 0, count);		
	} // end searchAll()

	// 전화번호부 갱신
	@Override
	public int update(int index, String name, String phoneNum, String email) {
		if (index < 0 || count <= index ) return QUERY_FAIL;
		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setEmail(email);
		return 1;
		
	} // end update()
	
	// 전화번호부 삭제
	@Override
	public int delete(int index) {
		
		if (index < 0 || count <= index ) return QUERY_FAIL;

		// 우선 배열의 뒤의 것들을 앞으로 이동
		for(int i = index, j = index + 1; j < count; i++,j++){
			pbList[i] = pbList[j];
		} // end for
		
		// 그리고 count 감소
		count --;
		return 1;
	} // end delete()
	
} // end class PhonebookManger













