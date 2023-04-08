package practice.sample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


/*
	학생(Student)들 중에서 4학년인 학생들만  
	아래 와 같은 출력해보세요
	
	[ 학번 | 	이름 | 	학년 | 담당 교수님 이름 ]  
	9411 	서진수      	4 		조인형
   	9412 	서재수      	4 		양선희
   	9413 	이미경      	4 		나한열
   	9414 	김재수      	4 		심슨
   	9415 	박동호      	4 		박원범
   	
   	학번, 이름, 학년 --> student 테이블에 있다.
   	교수님 이름 --> professor 테이블에 있다
   	
   	별도의 클래스 Student 를 만든뒤에 위 결과를 
   	List<Studnent> 에 담아 출력하자.
   	
 */


public class Sample01Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	// 예) C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\listener.ora  < - 이 파일을 열어보면 호스트 정보와 포트 정보, 디폴트 서비스 정보 알수 있다
	//public static final String URL = "jdbc:oracle:thin:@frogmac:1521:XE";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// DB 사용자 계정 정보
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
		
		
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER);  // <- 동적클래스 로딩
			System.out.println("드라이버 클래스 로딩 성공");
			
			// 3. DriverManager 클래스를 사용해서 DB와 연결(connection)
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 성공");

			// 4. Statement 인스턴스 생성
			stmt = conn.createStatement();
			System.out.println("Statement 생성 성공");
			
			
			// 5. SQL 문장 작성및 실행
			System.out.println();
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			// SQL 에러 메세지는 SQLException 에서 확인가능
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				// 나중에 만들어진 인스턴스들 먼저 close한다.
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
		} // end try-catch

	} // end main()

} // end class DB01Main













