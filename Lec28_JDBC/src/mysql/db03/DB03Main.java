package mysql.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mysql.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query{

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement 방식");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		System.out.println(SQL_INSERT);
		System.out.println(SQL_SELECT_ALL);
		System.out.println(SQL_UPDATE_REGDATE);
		System.out.println(SQL_DELETE_BY_NO);
		
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// PreparedStatement 인스턴스 생성
			System.out.println();
			System.out.println("INSERT");
			pstmt = conn.prepareStatement(SQL_INSERT);  // <- (?, ?, ?) 세개의 ? 가 있다.
			pstmt.setInt(1, 10);   // setXXX(paramIndex, value) 로 ? 를 세팅.  첫번째 index 는 1
			//pstmt.setString(1, "aaa");
			pstmt.setString(2, "헐크"); // 두번째 ?
			pstmt.setString(3, "2000-10-10"); // 세번째 ?
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) INSERT 성공");
			
			
			pstmt.close();
			
			// UPDATE
			System.out.println();
			System.out.println("UPDATE");
			pstmt = conn.prepareStatement(SQL_UPDATE_REGDATE);
			pstmt.setString(1, "2021-08-16");
			pstmt.setInt(2, 10);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");
			
			pstmt.close();
			
			System.out.println();
			System.out.println("DELETE");
			pstmt = conn.prepareStatement(SQL_DELETE_BY_NO);
			pstmt.setInt(1, 10);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) DELETE 성공");
			
			pstmt.close();
			
			// SELECT -> executeQuery()
			System.out.println();
			System.out.println("SELECT");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String regDate = rs.getString(COL_LABEL_REGDATE);
				String result = no + "\t | " + name + "\t | " + regDate;
				System.out.println(result);
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class DB03Main







































