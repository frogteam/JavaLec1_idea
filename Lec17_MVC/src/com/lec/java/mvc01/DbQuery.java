package com.lec.java.mvc01;

//컨트롤러 '동작'을 추상메소드로 제공
public interface DbQuery {

	// 회원 추가 동작
	// id 와 passwd 를 받아서 회원 1명 등록 하고, 성공하면 1 을 리턴
	public abstract int insert(String id, String passwd);
	
	// 회원 목록 가져오기 동작
	// 현재까지 저장된 회원들의 데이터(들)을 리턴
	// 다형성에 의해 Object 를 리턴하도록 선언하면 '어.떠.한' 타입도 리턴 가능!!
	public abstract Object searchAll();
	
	// 회원 수정 동작
	// 몇번째(index) 회원 1명의 데이터를 수정하여 id, passwd 로 변경, 수정 성공하면 1 리턴
	public abstract int update(int index, String id, String passwd);
	
	// 에러 코드값도 상수로 정의
	public static final int QUERY_FAIL = -1;
	
} // end interface DbQuery
