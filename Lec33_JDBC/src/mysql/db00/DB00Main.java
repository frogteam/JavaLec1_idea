package mysql.db00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
JDBC (Java DataBase Connectivity) 사용
  1) 프로젝트 폴더에 라이브리리 폴더를 생성 (ex: lib)
  2) MySQL 용 드라이버 다운로드
     mysql-connector-j-8.x.x.jar
     https://mvnrepository.com/artifact/mysql/mysql-connector-java
  3) 위 라이브러리를 라이브러리 폴더에 복사
  4) Project Structure 에서  Project Settings - Libraries 에 추가
  5) 라이브러리를 사용하는 사용하는 모듈 지정

 1. Database 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장 실행 (DB 서버로 전송)
 7. 실행 결과 확인
 8. 리소스 해제
*/

public class DB00Main {

	public static void main(String[] args) {
		System.out.println("JDBC 프로그래밍");

		try {
			//Class.forName("com.mysql.jdbc.Driver");  // deprecated
			Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL 8 이상
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			Connection con = null;

			// 로컬 DB 연결시
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb",
					"myuser", "1234");
//			con = DriverManager.getConnection("jdbc:mysql://localhost",
//					"root", "1234");
			
			// cafe24 연결시
//			con = DriverManager.getConnection("jdbc:mysql://bitsoul.cafe24.com:3306/bitsoul",
//					"bitsoul", "fu2ka0vi");
			
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();

			rs = st.executeQuery("SHOW DATABASES");

			if (st.execute("SHOW DATABASES")) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getNString(1);
				System.out.println(str);
			}
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class
