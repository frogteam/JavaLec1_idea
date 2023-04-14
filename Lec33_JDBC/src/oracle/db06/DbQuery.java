package oracle.db06;

public interface DbQuery {
	// Oracle DB를 사용(접속)하기 위한 정보들 
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	public static final String URL =
			"jdbc:oracle:thin:@PC1001:1521:XE";
	public static final String USER = "scott";
	public static final String PASSWD = "tiger";
	
	// test_member 테이블 정보
	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_ID = "id";
	public static final String COL_LABEL_PW = "pw";
	public static final String COL_LABEL_EMAIL = "email";
	
	// PreparedStatement를 위한 SQL 문장들
	public static final String SELECT =
			"SELECT * FROM " + TBL_NAME;
	public static final String SQL_INSERT =
			"INSERT INTO " + TBL_NAME + " VALUES (?, ?, ?)";
	public static final String SQL_UPDATE = 
			"UPDATE " + TBL_NAME
			+ " SET " + COL_LABEL_PW + " = ?, "
			+ COL_LABEL_EMAIL + " = ? "
			+ " WHERE " + COL_LABEL_ID + " = ?";
	public static final String SQL_DELETE =
			"DELETE FROM " + TBL_NAME
			+ " WHERE " + COL_LABEL_ID + " = ?";
	
	
} // end interface DbQuery










