package phonebook07.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;


// Controller부분을 담당할 클래스
public class PhonebookManager implements DbQuery, Closeable {

	
	// DB를 위한 멤버 변수 선언
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	// singleton 디자인 패턴 적용
	private static PhonebookManager instance = null;
	private PhonebookManager() {
		//TODO:
		try {
			// 2. JDBC 드라이버 클래스를 로딩.
			Class.forName(DRIVER);  // <- 동적 클래스 로딩
			System.out.println("드라이버 클래스 로딩 성공");
			// 3. DriverManager 클래스를 사용해서 DB와 연결(connection)
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB connect 성공");
			
			// 4. Statement 인스턴스 생성
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	} // private 생성자
	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	} // end getInstance()
	
	
	// 전화번호부 등록
	@Override
	public int insert(String name, String phoneNum, String email) {

		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", DbQuery.ERR_EMPTY_STRING);
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, email);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cnt;
	} // end insert()

	// 전화번호부 열람
	@Override
	public Object searchAll() {
		// List -> array
		//return pbList.toArray(new PhonebookModel[pbList.size()]);
		
		
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			LinkedList<PhonebookModel> pbList = new LinkedList<PhonebookModel>();
			
			for(int i = 0; rs.next(); i++) {
				int id = rs.getInt(COL_LABEL_ID);
				String name = rs.getString(COL_LABEL_NAME);
				String phoneNum = rs.getString(COL_LABEL_PHONENUM);
				String email = rs.getString(COL_LABEL_EMAIL);

				// java.sql.Date, java.sql.Time
				Date d = rs.getDate(COL_LABEL_REGDATE);  // getDate() 는  날짜 만 가져온다
				Time t = rs.getTime(COL_LABEL_REGDATE);  // 그래서 시간은 getTime() 으로 또 가져온다
				String regDate = null;
				if(d != null) {
					regDate = new SimpleDateFormat("yyyy년MM월dd일 HH시").format(d) + " " 
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}
				
				PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
				pb.setId(id);
				pb.setRegDate(regDate);
				pbList.add(pb);
				
				
			}
			
			return pbList.toArray(new PhonebookModel[pbList.size()]);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	} // end searchAll()

	// 전화번호부 갱신
	@Override
	public int update(int id, String name, String phoneNum, String email) {	
		
		int cnt = 0;
		
		if(!isValidId(id))
			throw new PhonebookException("update() 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);

		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", DbQuery.ERR_EMPTY_STRING);
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, email);
			pstmt.setInt(4, id);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		return cnt;
		
	} // end update()
	
	// 전화번호부 삭제
	@Override
	public int delete(int id) {

		int cnt = 0;
		
		// id 유효한지 체크
		if(!isValidId(id))
			throw new PhonebookException("delete() 아이디오류: "  + id, DbQuery.ERR_INVALID_ID);

		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, id);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return cnt;
	} // end delete()
	
	
	@Override
	public int getMaxId() {
		int maxId = 0;
		
		try {
			pstmt = conn.prepareStatement(SQL_MAX_ID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxId = rs.getInt(1);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return maxId;
	} // end getMaxId()
	
	@Override
	public boolean isValidId(int id) {
		
		boolean result = false;
		
		try {
			pstmt = conn.prepareStatement(SQL_FINDID);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getInt(1) >= 1) result = true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	} // end isValidId()
	
	
	@Override
	public void close() throws IOException {
		try {
			if(rs != null) {rs.close();}
			if(pstmt != null) {pstmt.close();}
			if(stmt != null) {stmt.close();}
			if(conn != null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end close()
	
	
	
	
} // end class PhonebookManger


class PhonebookException extends RuntimeException{
	
	private int errCode = DbQuery.ERR_GENERIC;
	
	public PhonebookException() {
		super("PhoneBook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	
	// Throwable 의 getMessage 를 오버라이딩 가능
	@Override
	public String getMessage() {
		String msg = "ERR-" + errCode + "]" + DbQuery.ERR_STR[errCode] + 
							" " + super.getMessage();
		return msg;
	}

}












