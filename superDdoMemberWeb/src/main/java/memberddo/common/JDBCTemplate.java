package memberddo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final static String USERNAME = "MEMBERWEB";
	private final static String PASSWORD = "MEMBERWEB";
	
	//싱글톤 적용
	private static JDBCTemplate instance;
	private static Connection conn;
	
	private JDBCTemplate() {}
	
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
			if(conn == null || conn.isClosed()) {
					try {
						Class.forName(DRIVER_NAME);
						conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		return conn;
	}
}
