package phonebook02.mvc_gui;

// View(PhonebookMain)와 Controller(PhonebookManager) 사이의 인터페이스
public interface DbQuery {
	public static final String VERSION = "전화번호부 v2.0";
	
	public abstract int insert(String name, String phoneNum, String email);
	public abstract Object searchAll();
	public abstract int update(int index, String name, String phoneNum, String email);
	public abstract int delete(int index);
	
	public static final int QUERY_FAIL = -1;
	
	
		
} // end interface DbQuery

