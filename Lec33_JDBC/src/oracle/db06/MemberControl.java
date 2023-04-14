package oracle.db06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberControl implements DbQuery {
	// Singleton 디자인 패턴
	private static MemberControl instance = null;
	private MemberControl() {
		initialize();
	}
	public static MemberControl getInstance() {
		if (instance == null) {
			instance = new MemberControl();
		}
		
		return instance;
	} // end getInstance()
	
	
	private Connection conn; // DB connection을 위한 멤버 변수
	private void initialize() {
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("DB 드라이버 로드 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB 접속 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // end initialize()
	
	
	public ArrayList<MemberModel> select() {
		ArrayList<MemberModel> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			 pstmt = conn.prepareStatement(SELECT);
			 rs = pstmt.executeQuery();
			 list = createMemberList(rs);
			 
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
	
	private ArrayList<MemberModel> createMemberList(ResultSet rs) {
		ArrayList<MemberModel> list = new ArrayList<MemberModel>();
		
		try {
			while (rs.next()) {
				String id = rs.getString(COL_LABEL_ID);
				String pw = rs.getString(COL_LABEL_PW);
				String email = rs.getString(COL_LABEL_EMAIL);
				
				list.add(new MemberModel(id, pw, email));
			} // while
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	} // end createMemberList()
	
	public int insert(String id, String pw, String email) {
		int rslt = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
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
	
	
	public int update(String id, String pw, String email) {
		int rslt = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, pw);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
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
	
	public int delete(String id) {
		int rslt = 0;
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, id);
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
	
} // end class MemberControl











