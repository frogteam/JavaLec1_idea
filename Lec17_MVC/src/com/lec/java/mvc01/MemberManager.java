package com.lec.java.mvc01;

import java.util.Arrays;

//Controller 객체
public class MemberManager implements DbQuery {

	public static final int MAX_DATA = 5;
	private MemberModel[] members = new MemberModel[MAX_DATA];
	private int count = 0; // 입력된 회원 데이터 개수
	
	// 일반적으로 Controller 는 singleton 으로 설계
	private static MemberManager inst = null;
	private MemberManager() {}
	public static MemberManager getInstance() {
		if (inst == null) {
			inst = new MemberManager();
		}
		return inst;
	} // end getInstance()
	
	
	@Override
	public int insert(String id, String passwd) {
		
		if(count == MAX_DATA) return QUERY_FAIL;
		
		// 배열에 회원데이터(MemberModel) 추가
		members[count] = new MemberModel(id, passwd);
		count++;
		
		return 1;
	} // end insert()

	@Override
	public Object searchAll() {
		
		// 데이터의 개수(count)만큼 배열 생성
//		MemberModel [] arr = new MemberModel[count];
		// 데이터의 개수만큼 배열 복사
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = members[i];
//		}
//		return arr;  // 배열 리턴!!  다형성에 의해 Object 로 리턴 가능!!

		
		return Arrays.copyOfRange(members, 0, count);
	} // end searchAll()

	@Override
	public int update(int index, String id, String passwd) {
		// 매개변수 유효성 체크
		if(index < 0 || count <= index) return QUERY_FAIL;
		
		members[index].setId(id);
		members[index].setPasswd(passwd);
		return 1;	
	} // end update()

} // end class MemberManager

















