package oracle.db07;

public interface DbQuery {

	public static final String DRIVER = 
			"oracle.jdbc.driver.OracleDriver";
	public static final String URL = 
			"jdbc:oracle:thin:@frogmac:1521:XE";
	public static final String USER = "scott";
	public static final String PASSWD = "adl2ip0x";
	
	public static final String TBL_NAME = "test_pb";
	public static final String COL_LABEL_NAME = "name";
	public static final String COL_LABEL_PHONE = "phone";
	public static final String COL_LABEL_EMAIL = "email";
	
	public static final String SQL_SELECT =
			"SELECT * FROM " + TBL_NAME;
	public static final String SQL_INSERT = 
			"INSERT INTO " + TBL_NAME + " VALUES (?, ?, ?)";
	public static final String SQL_DELETE =
			"DELETE FROM " + TBL_NAME
			+ " WHERE " + COL_LABEL_NAME + " = ?";
	public static final String SQL_UPDATE = 
			"UPDATE " + TBL_NAME
			+ " SET " + COL_LABEL_PHONE + " = ?, "
			+ COL_LABEL_EMAIL + " = ? "
			+ " WHERE " + COL_LABEL_NAME + " = ?";
	
} // end interface DbQuery












