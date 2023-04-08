package oracle.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.db.Query;

//공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query {

//	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
//	// JDBC 드라이버 클래스 정보
//	public static final String DRIVER =
//			"oracle.jdbc.driver.OracleDriver";
//	// DB 서버 정보
//	public static final String URL =
//			"jdbc:oracle:thin:@localhost:1521:XE";
//	// DB 사용자 계정 정보
//	public static final String USER = "scott";
//	public static final String PASSWD = "tiger";
//
//	public static final String TBL_NAME = "test_member";
//	public static final String COL_LABEL_NO = "mb_no";
//	public static final String COL_LABEL_NAME = "mb_name";
//	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";
//	
//	// PreparedStatement에서 사용될 SQL 문장
//	public static final String SQL_SELECT_ALL =
//			"SELECT * FROM " + TBL_NAME;
//	
//	public static final String SQL_INSERT =
//			"INSERT INTO " + TBL_NAME + " VALUES(?, ?, ?)";
//	
//	public static final String SQL_UPDATE_BIRTHDATE =
//			"UPDATE " + TBL_NAME 
//			+ " SET " + COL_LABEL_BIRTHDATE + " = ?"
//			+ " WHERE " + COL_LABEL_NO + " = ?";
//	
//	public static final String SQL_DELETE_BY_NO =
//			"DELETE FROM " + TBL_NAME 
//			+ " WHERE " + COL_LABEL_NO + " = ?";

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// PreparedStatement 인스턴스 생성
			// INSERT -> executeUpdate()
			System.out.println();
			System.out.println("INSERT");
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setInt(1, 10);  // 첫번째는 1 부터 시작.
			pstmt.setString(2, "헐크");
			pstmt.setString(3, "2000-10-10");
			int result = pstmt.executeUpdate();
			System.out.println(result + "개 행(row) INSERT 성공");
			
			// setString() 외에도
			// setInt, setDouble, setBoolean, setDate 등이 있다.			
			
			pstmt.close();
			
			// UPDATE -> executeUpdate()
			System.out.println();
			System.out.println("UPDATE");
			pstmt = conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			pstmt.setString(1, "2000-01-01");
			pstmt.setInt(2, 10);
			result = pstmt.executeUpdate();
			System.out.println(result + "개 행(row) UPDATE 성공");
			
			// DELETE -> executeUpdate()
			System.out.println();
			System.out.println("DELETE");
			pstmt = conn.prepareStatement(SQL_DELETE_BY_NO);
			pstmt.setInt(1, 10);
			result = pstmt.executeUpdate();
			System.out.println(result + "개 행(row) DELETE 성공");
			
			// SELECT -> executeQuery()
			System.out.println();
			System.out.println("SELECT");
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			
			// SQL 전송/실행
			rs = pstmt.executeQuery();
						
			while (rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | " + name + " | " + birthdate);
			} // end while
			
			
			// 실습:
//			int pay;
//			Scanner sc = new Scanner(System.in);
//			System.out.print("평균급여를 입력하세요:");
//			pay = sc.nextInt();
			
			// HAVING : 그룹 함수에 조건 추가
			// 학과별 평균급여를 출력하되, 평균급여가 pay 보다 많은 학과만 출력
			// PreparedStatement 사용
			
			//SELECT deptno 부서번호, AVG(nvl(pay,0)) 평균급여 
			//FROM professor 
			//GROUP BY deptno 
			//HAVING AVG(nvl(pay,0)) > ?;
			
			// TODO:
			
//			String SQL_PAYOVER = "SELECT deptno, AVG(nvl(pay,0)) avgpay " +
//					"FROM professor " +
//					"GROUP BY deptno " +  
//					" HAVING AVG(nvl(pay,0)) > ?";
//			
//			pstmt = conn.prepareStatement(SQL_PAYOVER);
//			pstmt.setInt(1, pay);
//			// SQL 전송/실행
//			rs = pstmt.executeQuery();
//			
//			
//			while (rs.next()) {
//				int deptno = rs.getInt("deptno");
//				double avgpay= rs.getDouble("avgpay");
//				System.out.println(deptno + " | " +  avgpay);
//			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// SQL 에러 메세지는 SQLException 에서 확인가능
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	} // end main()

} // end class DB03Main






















