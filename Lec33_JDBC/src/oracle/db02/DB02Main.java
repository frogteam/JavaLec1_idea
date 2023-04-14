package oracle.db02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";

	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_NO = "mb_no";
	public static final String COL_LABEL_NAME = "mb_name";
	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";

	public static void main(String[] args) {
		System.out.println("DB 2 - Statement");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("DB 드라이버 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// Statement 생성
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
			// SQL 문장
			// UPDATE [테이블] 
			// SET [컬럼] = [값], ... 
			// WHERE [조건]
			String sql = "UPDATE " + TBL_NAME
					+ " SET " + COL_LABEL_NAME + " = '슈퍼맨', "
					+ COL_LABEL_BIRTHDATE + " = '1966-07-17' "
					+ " WHERE " + COL_LABEL_NO + " = 10";
			System.out.println(sql); // 내가 만든 쿼리문 눈으로도 확인해보자
			
			// INSERT, UPDATE, DELETE -> executeUpdate() 사용,  int 값 리턴
			int rslt = stmt.executeUpdate(sql);
			System.out.println(rslt + "개 행(row) UPDATE 성공");
			
			sql = "DELETE FROM " + TBL_NAME
					+ " WHERE " + COL_LABEL_NO + " = 10";
//			sql = "delete from test_member where id = 'abc' ";
			System.out.println(sql);
			
			rslt = stmt.executeUpdate(sql);
			System.out.println(rslt + "개 행(row) DELETE 성공");
			
			// SELECT -> executeQuery() 사용,  ResultSet 리턴
			sql = "SELECT * FROM " + TBL_NAME;
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				
				String info = no + " | " + name + " | " + birthdate;
				System.out.println(info);
				
			} // end while
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	} // end main()

} // end class DB02Main













