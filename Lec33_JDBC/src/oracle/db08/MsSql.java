package oracle.db08;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class MsSql {
    /**
     * 
     * DB프로퍼티 표시
     * @param url
     * @param userId
     * @param userPw
     * @param driverNm
     */
    public void displayDbProperties(String url, String userId, String userPw,
            String driverNm) {
 
        Connection con = null;
        DatabaseMetaData dm = null;
        ResultSet rs = null;
        try {
            con = this.makeConnection(url, userId, userPw, driverNm);
            if (con != null) {
                dm = con.getMetaData();
                System.out.println("Driver Information");
                System.out.println("\tDriver Name: " + dm.getDriverName());
                System.out
                        .println("\tDriver Version: " + dm.getDriverVersion());
                System.out.println("\nDatabase Information ");
                System.out.println("\tDatabase Name: "
                        + dm.getDatabaseProductName());
                System.out.println("\tDatabase Version: "
                        + dm.getDatabaseProductVersion());
                System.out.println("Avalilable Catalogs ");
 
                rs = dm.getCatalogs();
                while (rs.next()) {
                    System.out.println("\tcatalog: " + rs.getString(1));
                }
                rs.close();
                rs = null;
 
            } else
                System.out.println("Error: No active Connection");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
                con = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
        dm = null;
    }
 
    /**
     * 커넥션을 취득해 반환 DB커넥션 취득
     * 
     * @param url
     * @param userId
     * @param userPw
     * @param driverNm
     * @return
     * @throws SQLException
     */
    public Connection makeConnection(String url, String userId, String userPw,
            String driverNm) throws SQLException {
 
        Connection conn = null;
 
        try {
            // 1. JDBC 드라이버 로드
            Class.forName(driverNm);
            // 2. DriverManager.getConnection()를 이용하여 Connection 인스턴스 생성
            conn = DriverManager.getConnection(url, userId, userPw);
 
            if (conn != null) {
                System.out.println("Connection Successful!!!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sq) {
            sq.printStackTrace();
        }
 
        return conn;
    }  // end makeConnection()
 
    public static void main(String[] args) {
        // 유저ID
        String userId = "gold7073";
        // 유저 패스워드
        String userPw = "fu2ka0vi";
 
        // 드라이버명
        String MSSQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
 
        MsSql myDbTest = new MsSql();
        myDbTest.displayDbProperties(getMsSQLJDBCUrl(), userId, userPw,
                MSSQL_DRIVER);        
    }
 
    /**
     * MS-SQL JDBC url만들기
     * @return
     */
    public static String getMsSQLJDBCUrl() {
 
        StringBuilder url = new StringBuilder();
        url.append("jdbc:sqlserver://");
        //url.append("localhost"); // 접속호스트
        url.append("gold7073.cafe24.com"); // 접속호스트
        url.append(":");
        url.append("1433"); // 포트번호 // MS SQL 은 기본적으로 1433 포트 사용
        url.append(";");
        url.append("databaseName=");
        //url.append("TEST"); // DB명
        url.append("gold7073"); // DB명
        url.append(";");
        url.append("selectMethod=");
        url.append("cursor");
        url.append(";");
 System.out.println(url.toString());
        return url.toString();
    }    
    
}