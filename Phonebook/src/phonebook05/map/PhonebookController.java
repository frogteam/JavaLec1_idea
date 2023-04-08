package phonebook05.map;

import java.io.Closeable;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Controller부분을 담당할 클래스
public class PhonebookController implements Controller, C, Closeable {

	// 멤버 변수
	//private List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	private Map<Integer, PhonebookModel> pbMap = new HashMap<Integer, PhonebookModel>();
	
	private static int genUid = 0;  // 새로 생성되는 데이터에 부여할 uid값, 생성될때마다 +1 씩 증가

	// singleton 디자인 패턴 적용
	// 1. 생성자 대신 public static 메소드를 제공해서
	// 인스턴스를 생성 또는 생성되어 있는 인스턴스를 리턴(반환)해 주도록 함
	// 2. 해당 클래스의 인스턴스는 오직 하나만 생성될 수 있다.
	private static PhonebookController instance = null;
	private PhonebookController() {} // private 생성자
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
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("insert() 전화번호입력 오류: ", ERR_EMPTY_STRING);

		genUid++;
		PhonebookModel pb = new PhonebookModel(
				genUid,
				name, phoneNum, memo,
				LocalDateTime.now()  // 현재 날짜
				);
		
		//pbList.add(pb);  // List<> 에 추가
		pbMap.put(genUid, pb);
		
		result = 1;

		return result;
	} // end insert()

	// 전화번호부 열람
	@Override
	public List<PhonebookModel> selectAll() {
		return new ArrayList<PhonebookModel>(pbMap.values());
	} // end selectAll()

	// 전화번호부 갱신
	@Override
	public int update(int uid, String name, String phoneNum, String memo) {
		int result = ERR_GENERIC; // 리턴할 결과값

		// 매개변수 검증
		if (uid < 1)
			throw new PhonebookException("update() uid 오류: " + uid, ERR_INVALID_UID);
		
		// 매개변수 검증 : 이름, 전화번호 필수
		if (name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if (phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("update() 전화번호입력 오류: ", ERR_EMPTY_STRING);


		PhonebookModel pb = pbMap.get(uid);
		if(pb == null)
			throw new PhonebookException("update() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);
		pb.setName(name);
		pb.setPhoneNum(phoneNum);
		pb.setMemo(memo);
		result = 1;

		return result;
	} // end update()

	// 전화번호부 삭제
	@Override
	public int delete(int uid) {
		int result = ERR_GENERIC; // 리턴할 결과값
		
		// 매개변수 검증
		if(pbMap.remove(uid) == null) {
			throw new PhonebookException("delete() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);			
		}		
		result = 1;
		
		return result;
	} // end delete()

	// 특정 uid 의 전화번호부 데이터 검색
	@Override
	public PhonebookModel selectByUid(int uid) {  // 삭제, 수정 등에 사용
		PhonebookModel pb = pbMap.get(uid);
		
		if(pb != null) return pb;  // uid 값 발견하면 model 리턴
		
		throw new PhonebookException("존재하지 않는 uid : " + uid, ERR_INVALID_UID);
	} // end selectByUid()

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

//	// ※ 컨트롤러에서만 사용하는 메소드는 private 으로 만들자
//	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
//	private int getMaxUid() {
//		if(pbList.size() == 0) return 0;  // 아무것도 없으면 0
//		
//		// List<> 로 저장되는 경우 가장 마지막 요소의 Uid값이 최대값
//		return pbList.get(pbList.size() - 1).getUid();
//	} // end getMaxUid()
//
//	// List 경우, 특정 uid 를 가진 데이터의 index 값을 알아야 한다
//	private int findIndexByUid(int uid) {
//		
//		for (int index = 0; index < pbList.size(); index++) {
//			if (pbList.get(index).getUid() == uid) {
//				return index;
//			}
//		} // end for
//		
//		return -1;  // 못찾으면 -1 
//	} // findIndexByUid()

} // end Controller 



