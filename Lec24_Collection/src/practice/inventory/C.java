package practice.inventory;

/*
 * 상수들 모아놓은 클래스
 */
public interface C {
	public static final String VERSION = "상품정보 관리 프로그램 v1.0";
	
	// 메뉴 상수
	public static final int MENU_QUIT = 0;
	public static final int MENU_INSERT = 1;
	public static final int MENU_LIST = 2;
	public static final int MENU_UPDATE = 3;
	public static final int MENU_DELETE = 4;
	
	// 에러코드 상수
	public static final int ERR_GENERIC = 0;	       // 일반에러.
	public static final int ERR_INDEXOUTOFRANGE = 1;   // 인덱스 범위 벗어남
	public static final int ERR_EMPTY_STRING = 2;     // 입력한 문자열이 empty 인 경우
	public static final int ERR_INVALID_ID = 3;      // id 없는 경우

	public static final int ERR_INVALID_PRICE = 4;

	// 에러 문자열
	public static final String[] ERR_STR = {
			"일반오류",   // 0
			"인덱스오류",  // 1
			"문자열오류",   // 2
			"ID오류",     // 3
			"가격오류",  // 4
	};
	
} // end interface Menu




