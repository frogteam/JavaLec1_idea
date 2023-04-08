package phonebook02.mvc;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// Controller부분을 담당할 클래스
public class PhonebookController implements Controller, C, Closeable {

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
	private static PhonebookController instance = null;

	private PhonebookController() {
	} // private 생성자

	public static PhonebookController getInstance() {
		if (instance == null) {
			instance = new PhonebookController();
		}
		return instance;
	} // end getInstance()

	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String memo) {

		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().length() == 0 || 
				phoneNum == null || phoneNum.trim().length() == 0)
			return result;

		// 만약 배열이 다 찼으면, MAX_DATA 만큼 추가
		if (count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length + MAX_DATA);
		}

		PhonebookModel pb = new PhonebookModel(
				getMaxUid() + 1, // 기존 최대 uid 값보다 1 증가한 값으로 (unique 한 값 보장)
				name, phoneNum, memo,
				LocalDateTime.now()  // 현재 날짜
				);
		
		pbList[count] = pb;
		count++;
		result = 1;

		return result;
	} // end insert()

	// 전화번호부 열람
	@Override
	public List<PhonebookModel> selectAll() {
		return Arrays.asList(Arrays.copyOfRange(pbList, 0, count));
	} // end List()

	// 전화번호부 갱신
	@Override
	public int update(int uid, String name, String phoneNum, String memo) {
		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (uid < 1)
			return result;
		if (name == null || name.trim().length() == 0 ||
				phoneNum == null || phoneNum.trim().length() == 0)
			return result; // 이름 필수

		int index = findIndexByUid(uid);   // uid 값을 가진 데이터의 배열 인덱스 찾기
		if(index < 0)
			return result;

		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		result = 1;

		return result;
	} // end update()

	// 전화번호부 삭제
	@Override
	public int delete(int uid) {
		int result = ERR_GENERIC; // 리턴할 결과값
		
		// 매개변수 검증
		if (uid < 1)
			return result;

		int index = findIndexByUid(uid);  // uid 값을 가진 데이터의 배열 인덱스 찾기
		if(index < 0)
			return result;

		// 우선 배열의 뒤의 것들을 앞으로 이동
		for (int i = index, j = index + 1; j < count; i++, j++) {
			pbList[i] = pbList[j];
		} // end for

		// 그리고 count 감소
		count--;
		result = 1;

		return result;
	} // end delete()

	// 특정 uid 의 전화번호부 데이터 검색
	@Override
	public PhonebookModel selectByUid(int uid) {

		int index = findIndexByUid(uid);
		if(0 <= index) return pbList[index]; // uid 값 발견하면 리턴
		return null;  // 못 찾으면 null 리턴
	} // end selectByUid()

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	// ※ 컨트롤러에서만 사용하는 메소드는 private 으로 만들자
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		int maxUid = 0;

		// uid 최대값 검색
		for (int index = 0; index < count; index++) {
			if (maxUid < pbList[index].getUid())
				maxUid = pbList[index].getUid();
		} // end for

		return maxUid;
	} // end getMaxUid()

	// 배열의 경우, 특정 uid 를 가진 데이터의 배열 index 값을 알아야 한다
	private int findIndexByUid(int uid) {

		for (int index = 0; index < count; index++) {
			if (pbList[index].getUid() == uid) {
				return index;
			}
		} // end for
		
		return -1;  // 못찾으면 -1 
	} // findIndexByUid()

} // end Controller
