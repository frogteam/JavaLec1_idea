package oracle.db10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MariaDB {

	// 드라이버 정보
	public static final String DRIVER = "org.mariadb.jdbc.Driver";
	// DB 서버 정보
	public static final String URL = "jdbc:mariadb://localhost:3307/mydb";
	// DB 사용자 계정 정보
	public static final String USER = "myuser";
	public static final String PASSWD = "1234";

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SHOW TABLES");

			if (stmt.execute("SHOW TABLES")) {
				rs = stmt.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //
} // 
