package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnector {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String DB_URL = "jdbc:mysql://localhost:3306/quan_ly_thi_ptth";
			String USERNAME = "root";
			String PASSWORD = "";
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ket noi that bai");
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
