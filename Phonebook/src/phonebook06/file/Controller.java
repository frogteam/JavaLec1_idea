package phonebook06.file;

import java.util.List;

// View(PhonebookMainView)와 Controller(PhonebookController) 사이의 인터페이스
public interface Controller {
	public abstract int insert(String name, String phoneNum, String memo);
	public abstract List<PhonebookModel> selectAll();
	public abstract PhonebookModel selectByUid(int uid);
	public abstract int update(int uid, String name, String phoneNum, String memo); /* 4 */
	public abstract int delete(int uid);	
} // end interface DbQuery

