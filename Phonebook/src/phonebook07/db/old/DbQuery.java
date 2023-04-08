package phonebook07.db.old;

// View(PhonebookMain)와 Controller(PhonebookManager) 사이의 인터페이스

/*
 CREATE TABLE phonebook
(
	Id number NOT NULL,
	Name varchar2(40) NOT NULL,
	Phonenum varchar2(40),
	Email varchar2(80),
	RegDate date,
	PRIMARY KEY (Id)
);

-- 시퀀스 객체도 생성하자
CREATE SEQUENCE phonebook_seq;

 */

public interface DbQuery{
	public static final String VERSION = "전화번호부 v7.0";
	
	public abstract int insert(String name, String phoneNum, String email);
	public abstract Object searchAll();

	// ↓ 이제 id 값으로 update(), delete() 수행
	public abstract int update(int id, String name, String phoneNum, String email);
	public abstract int delete(int id);
	
	// 현재 id 최대값 추출
	// 없으면 0 이 리턴된다.  (id는 1부터 시작하니까..)
	public abstract int getMaxId();
	
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
	
	
	// DataBase 관련
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// DB 사용자 계정 정보
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
	
	public static final String TBL_NAME = "phonebook";
	
	public static final String COL_LABEL_ID = "id";
	public static final String COL_LABEL_NAME = "name";
	public static final String COL_LABEL_PHONENUM = "phonenum";
	public static final String COL_LABEL_EMAIL = "email";
	public static final String COL_LABEL_REGDATE = "regdate";
	public static final String SEQ_NAME = "phonebook_seq";
	
	
	// 쿼리 문자열
	// (주로) PreparedStatement에서 사용될 SQL 문장
	// ※ 각 쿼리 문자열들이 제대로 동작하는지 직접 테스트 하고 우선 검증해보세요. 꼭꼭!
	// 팁] 이클립스 : 상수 위에 살~짝 커서 올려보세요
	
	public static final String SQL_COUNT_ALL = "SELECT COUNT(*) cnt FROM " + TBL_NAME;
	
	// ex) SELECT MAX(id) maxid FROM phonebook;
	public static final String SQL_MAX_ID = 
			"SELECT MAX(" + COL_LABEL_ID + ") maxid FROM " + TBL_NAME;

	// 
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TBL_NAME 
			+ " ORDER BY " + COL_LABEL_ID + " DESC";
		
	//public static final String SQL_SEARCH_ID = "SELECT COUNT(*) cnt FROM " + TBL_NAME + " WHERE id = ?";

	// ex) INSERT INTO phonebook VALUES(phonebook_seq.nextval, '박보람', '999-8888', 'park@naver.com', SYSDATE)"
	public static final String SQL_INSERT = 
			"INSERT INTO " + TBL_NAME 
			+ " VALUES(phonebook_seq.nextval, ?, ?, ?, SYSDATE)";
	
	// ex) UPDATE phonebook SET name = '김만두', phonenum = '111-2222', email = 'kim@mandu.net' WHERE id = 1;
	public static final String SQL_UPDATE = 
			"UPDATE " + TBL_NAME + " SET " 
			+ COL_LABEL_NAME + " = ?, " 
			+ COL_LABEL_PHONENUM + " = ?, " 
			+ COL_LABEL_EMAIL + " = ? " 
			+ " WHERE " + COL_LABEL_ID + " = ?";
	
	// ex) DELETE FROM phonebook WHERE id = 1;
	public static final String SQL_DELETE = 
			"DELETE FROM " + TBL_NAME 
			+ " WHERE " + COL_LABEL_ID + " = ?";
	
	// ex) SELECT count(*) cnt FROM phonebook WHERE id = 2;
	public static final String SQL_FINDID = "SELECT count(*) cnt FROM " + TBL_NAME + " WHERE " + COL_LABEL_ID + " = ?";

	
} // end interface DbQuery

