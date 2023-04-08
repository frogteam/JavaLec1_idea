package oracle.db07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhonebookControl implements DbQuery {

	// Single 디자인 패턴
	private static PhonebookControl instance = null;
	private PhonebookControl() {
		initialize();
	}
	public static PhonebookControl getInstance() {
		if (instance == null) {
			instance = new PhonebookControl();
		}
		
		return instance;
	} // end getInstnace()
	
	private Connection conn;
	private void initialize() {
		try {
			Class.forName(DRIVER);
			System.out.println("Oracle 드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // end initialize()
	
	public ArrayList<PhonebookModel> select() {
		ArrayList<PhonebookModel> list = new ArrayList<PhonebookModel>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(COL_LABEL_NAME);
				String phone = rs.getString(COL_LABEL_PHONE);
				String email = rs.getString(COL_LABEL_EMAIL);
				
				list.add(new PhonebookModel(name, phone, email));
			} // end while()
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	} // end select()
	
	public int insert(String name, String phone, String email) {
		int rslt = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			
			rslt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rslt;
	} // end insert()
	
	public int delete(String name) {
		int rslt = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, name);
			rslt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rslt;
	} // end delete()
	
	public int update(String name, String phone, String email) {
		int rslt = 0;
		
		// 이름을 DB에서 수정할 수 없는 구조 -> 기능 개선 필요
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			pstmt.setString(3, name);
			
			rslt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return rslt;
	} // end update()
	
} // end class PhonebookControl














