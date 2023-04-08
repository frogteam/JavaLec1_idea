package book.file;

import java.util.List;

// View와 Controller 사이의 인터페이스
public interface Controller {
	public abstract int insert(String name, Integer price, String memo);
	public abstract List<BookModel> selectAll();
	public abstract BookModel selectByUid(int uid);
	public abstract int update(int uid, String name, Integer price, String memo); /* 4 */
	public abstract int delete(int uid);	
} // end interface DbQuery

