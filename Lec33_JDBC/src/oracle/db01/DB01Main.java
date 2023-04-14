package oracle.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. DB 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
 8. 리소스 해제
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site


public class DB01Main {

	// 1. DB 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	// 예) C:\oraclexe\app\oracle\product\11.2.0\server\network\ADMIN\listener.ora  < - 이 파일을 열어보면 호스트 정보와 포트 정보, 디폴트 서비스 정보 알수 있다
	//public static final String URL = "jdbc:oracle:thin:@frogmac:1521:XE";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	
	// MySQL8 이상
	//public static final String URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";

	// DB 사용자 계정 정보
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
		
		
	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");
		
		Connection conn = null;
		Statement stmt = null;   // java.sql.Statement
		ResultSet rs = null;
		
		// 왜 굳이 try-with-resource 로 하지 않느냐?
		// stmt 나 rs 는 수시로 assignment 가 발생되기 때문.
		// try-with-resource 는  try() 안에서만 assignment가 발생되어야 한다.
		
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
			// INSERT INTO test_member VALUES(..., ..., ...);
			String sql_insert = "INSERT INTO test_member VALUES(100, '마징가', SYSDATE)";
			System.out.println(sql_insert);
			int cnt = stmt.executeUpdate(sql_insert); // 'DML' 의 경우 executeUpdate()로 실행
														// 리턴값 은 정수(int)
			System.out.println(cnt + "개 row(행)이 INSERT됨");
			
			
			
			// 쿼리 관련 에러 발생되면 어떻게 되나
			// getMessage() 쿼리 에러 메세지 확인 가능
			// SQLException  발생
			// "INSERTINTO test_member VALUES(100, '마징가', SYSDATE)"
			// java.sql.SQLSyntaxErrorException: ORA-00900: invalid SQL statement  <-- 구문 오류
			
			// "INSERT INTO test_member(mb_no) VALUES(101)"
			// java.sql.SQLIntegrityConstraintViolationException: ORA-01400: cannot insert NULL into ("SCOTT"."TEST_MEMBER"."MB_NAME")

			
			System.out.println();
			// SELECT * FROM test_member;
			String sql_select = "SELECT * FROM test_member";
			System.out.println(sql_select);
			
			// 6. Statement 객체를 사용해서 SQL 문장을 DB 서버로 전송
			rs = stmt.executeQuery(sql_select);  // 'SELECT 및 기타쿼리' 의 경우 executeQuery() 로 실행
													// 리턴값은 ResultSet 객체
			
			// 7. ResultSet 에서 record 데이터 확인
			
			// 7-1. 컬럼 이름 으로 받기
//			System.out.println();
//			while (rs.next()) {   // next() 레코드 하나 추출하고 true 리턴. 추출할 레코드 없으면 false 리턴
//				String no = rs.getString("mb_no");    // getXXX() 에 '컬럼명 혹은 별명' 명시
//				String name = rs.getString("mb_name");
//				String birthdate = rs.getString("mb_birthdate");
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);				
//			} // end while
			// 위에서 컬럼이름 오류시 java.sql.SQLException: 부적합한 열 이름   
			
			
			// 7-2  컬럼 인덱싱으로 받기
//			System.out.println();
//			while (rs.next()) {
//				String no = rs.getString(1);    // getXXX() 에 컬럼인덱스 명시 (1 부터 시작!)
//				String name = rs.getString(2);
//				String birthdate = rs.getString(3);
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);				
//			} // end while

			
			// 7-3 null 처리 해주기
			// 기본적으로 데이터가 null 값이면 getString 일때 null 로 넘어온다
			// INSERT INTO test_member(mb_name) VALUES('김이박');   -- 몇개 실행하고, commit; 꼭 하기

//			while (rs.next()) {
//				String no = rs.getString("mb_no");    // getXXX() 에 '컬럼명 혹은 별명' 명시
//				if(no == null) no = "";
//				String name = rs.getString("mb_name");
//				if(name == null) name = "";
//				String birthdate = rs.getString("mb_birthdate");
//				if(birthdate == null) birthdate = "";
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);				
//			} // end while
			
			
			// 7-4 개별적인 타입으로 get하기
			while (rs.next()) {
				int no = rs.getInt("mb_no");    // getInt()  만약 null 이면 0 리턴
				String name = rs.getString("mb_name");
				if(name == null) name = "";
				
				// 날짜를 받아오는 것은 여러가지 방법이 있다.
				String birthdate = null; 				
				Date d = null;  // java.sql.Date
				Time t = null;  // java.sql.Time
				Timestamp timestamp = null;  // java.sql.Timestamp
				LocalDateTime localDateTime = null;  // java.time.LocalDateTime  (Java8 이상)
				

				// java.sql.Date, java.sql.Time 사용
				d = rs.getDate("mb_birthdate");  // getDate() 는  날짜 만 가져온다
				t = rs.getTime("mb_birthdate");  // 그래서 시간은 getTime() 으로 또 가져온다
				if(d != null) {
					birthdate = new SimpleDateFormat("yyyy년MM월dd일 HH시").format(d) + " " 
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}

				// 위 방식으로는 '날짜' 와 '시간'을 따로 뽑을수 밖에 없다.
				// java.sql.Timestamp 으로 받아오면
				// java.util.Date 타입에    '날짜' + '시간' 한꺼번에(한번에) 담을수 있다.
				timestamp = rs.getTimestamp("mb_birthdate");
//				java.util.Date date = null;
				if(timestamp != null) {
					d = new Date(timestamp.getTime());
					birthdate = new SimpleDateFormat("yyyy-MM-dd HH시mm분ss초").format(d);				
				}
				
				// Java8 에 추가된 java.time 의 LocalDate, LocalTime, LocalDateTime 으로 가져오기
				// Timestamp 로부터 변환할수도 있고,  getObject() 를 사용해서 직접 받아올수도 있다. 
				if(timestamp != null) {
					localDateTime = timestamp.toLocalDateTime(); 				
					birthdate = localDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
				}
				
				// 만약 '최신' JDBC 드라이버라면 아래 코드로도 작동한다.  Timestamp 를 안거치고도 가능
				// 안타깝게도 ojdbc6 로는 불가.
				//localDateTime = rs.getObject("mb_birthdate", LocalDateTime.class);
				
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);				
			} // end while
			
			
			// 7-5 컬럼명 추출 하기
//			ResultSetMetaData rsmd = rs.getMetaData();  // ResultSet 의 기타 정보 담고 있는 객체
//			int columnCount = rsmd.getColumnCount();   // ResultSet 에 있는 컬럼 개수 추출
//			System.out.println("총 " + columnCount + " 개의 컬럼이 있습니다");
//			
//			while(rs.next()) {
//				String result = "";
//				for(int i = 1; i <= columnCount; i++) {   // 1부터 시작해야 한다!
//					String colName = rsmd.getColumnName(i);
//					String colValue = rs.getString(colName);
//					result += colValue + "\t | ";
//				} // end for
//				System.out.println(result);
//			} //end while
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			// SQL 에러 메세지는 SQLException 에서 확인가능
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
		} finally {
			//  8. 리소스 해제
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













