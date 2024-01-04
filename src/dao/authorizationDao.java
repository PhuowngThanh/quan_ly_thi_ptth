package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.dbConnector;
import model.user;

/**
 * @author zoohuy
 * 28 thg 12, 2023
 */

public class authorizationDao {
	
	// Method to call direct, don't create new authorization object
	public static authorizationDao getInstance() {
		return new authorizationDao();
	}
	
	// Method to authorize a user
	public user authorization(user us) {
		user result = null;
		try {
			// B1: Create connection to db
			Connection con = dbConnector.getConnection();
			// B2: Create sql query
			String sql = "SELECT * FROM tai_khoan WHERE email=?";
			// B3: Create PreparedStatement object
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, us.getEmail());
			ResultSet rs = pst.executeQuery();
			// B4: Handle data
			while (rs.next()) {
				String email = rs.getString("email");
				String password = rs.getString("pass");
				result = new user(email, password);
			}
			System.out.println("Your SQL Query:\n" + sql);
			// B5: Close connection
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}