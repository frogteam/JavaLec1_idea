package phonebook05.map_file;

// View(PhonebookMain)와 Controller(PhonebookManager) 사이의 인터페이스
public interface DbQuery {
	public static final String VERSION = "전화번호부 v5.1";
	
	public abstract int insert(String name, String phoneNum, String email);
	public abstract Object searchAll();

	// ↓ 이제 id 값으로 update(), delete() 수행
	public abstract int update(int id, String name, String phoneNum, String email);
	public abstract int delete(int id);
	
	// 현재 id 최대값 추출
	// 없으면 0 이 리턴된다.  (id는 1부터 시작하니까..)
	//public abstract int getMaxId();
	
	// 유효한 id 여부 체크
	// 주어진 id 값이 전화번호부에 있으면 true, 없으면 false 리턴
	public abstract boolean isValidId(int id);
		
	// 에러코드 상수
	public static final int ERR_GENERIC = 0; 			// 일반에러.
	public static final int ERR_INDEXOUTOFRANGE = 1;   // 인덱스 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2;     // 입력한 문자열이 empty 인 경우
	public static final int ERR_INVALID_ID = 3;      // id 없는 경우
	
	// 에러 문자열
	public static final String[] ERR_STR = {
			"일반오류",   // 0
			"인덱스오류",  // 1
			"문자열오류",   // 2
			"아이디오류"    // 3
	};
	
} // end interface DbQuery

