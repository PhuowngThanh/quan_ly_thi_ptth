package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import connection.dbConnector;

public class analyticDao {
	
	// Method to get total revenue of class
	public static double getTBTN() {
		double TB = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT AVG(thi.diem_so1 + thi.diem_so2 + thi.diem_so3)/COUNT(thi.to_hop) 'TB'\r\n"
					+ "FROM thi\r\n"
					+ "WHERE thi.to_hop = 'Tự Nhiên'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				TB = rs.getDouble("TB");
			}
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TB;
	}
	
	// Method to get total revenue of class
	public static double getTBXH() {
		double TB = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT AVG(thi.diem_so1 + thi.diem_so2 + thi.diem_so3)/COUNT(thi.to_hop) 'TB'\r\n"
					+ "FROM thi\r\n"
					+ "WHERE thi.to_hop = 'Xã Hội'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				TB = rs.getDouble("TB");
			}
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TB;
	}
	
	// Method to get total of student
	public static int getTotalThi_sinh() {
		int totalThi_sinh = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT COUNT(*) totalThi_sinh FROM thi_sinh";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double totalThi_sinhI = rs.getDouble("totalThi_sinh");
				totalThi_sinh += totalThi_sinhI;
			}
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalThi_sinh;
	}
	
	// Method to get total of advisor
	public static int getTotalGiam_thi() {
		int totalGiam_thi = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT COUNT(*) totalGiam_thi FROM giam_thi";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				double totalGiam_thiI = rs.getDouble("totalGiam_thi");
				totalGiam_thi += totalGiam_thiI;
			}
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalGiam_thi;
	}
	
	// Method to get student, advisor of each class
	public static ArrayList<ArrayList<String>> getTSGTMPT() {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> listMa_phong_thi = new ArrayList<String>();
		ArrayList<String> listSLThisinh = new ArrayList<String>();
		ArrayList<String> listDiemTB = new ArrayList<String>();
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT thi.ma_phong_thi, COUNT(thi.ma_phong_thi) \"SLThisinh\", AVG(thi.diem_so1 + thi.diem_so2 + thi.diem_so3)/COUNT(thi.ma_phong_thi) \"DiemTB\"\r\n"
					+ "FROM thi\r\n"
					+ "GROUP BY thi.ma_phong_thi\r\n"
					+ "ORDER BY thi.ma_phong_thi";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_phong_thi = rs.getString("ma_phong_thi");
				String SLThisinh = rs.getString("SLThisinh");
				String DiemTB = rs.getString("DiemTB");
				listMa_phong_thi.add(ma_phong_thi);
				listSLThisinh.add(SLThisinh);
				listDiemTB.add(DiemTB);
			}
			result.add(listMa_phong_thi);
			result.add(listSLThisinh);
			result.add(listDiemTB);
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// Method to get score rate of each class
	public static ArrayList<Integer> getScoreRate() {
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT\r\n"
					+ "    SUM(CASE WHEN point < 4.0 AND point <> -1.0 THEN 1 ELSE 0 END) AS 'poor',\r\n"
					+ "    SUM(CASE WHEN (point >= 4.0 AND point <= 5.4) AND point <> -1.0 THEN 1 ELSE 0 END) AS 'weak',\r\n"
					+ "    SUM(CASE WHEN (point > 5.4 AND point <= 6.9) AND point <> -1.0 THEN 1 ELSE 0 END) AS 'average',\r\n"
					+ "    SUM(CASE WHEN (point > 6.9 AND point <= 8.4) AND point <> -1.0 THEN 1 ELSE 0 END) AS 'pretty',\r\n"
					+ "    SUM(CASE WHEN point > 8.4 AND point <> -1.0 THEN 1 ELSE 0 END) AS 'good'\r\n"
					+ "FROM (\r\n"
					+ "    SELECT \r\n"
					+ "        AVG(diem_so1 + diem_so2 + diem_so3) / COUNT(ma_phong_thi) AS 'point'\r\n"
					+ "    FROM thi\r\n"
					+ "    GROUP BY ma_phong_thi\r\n"
					+ ") AS subquery";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int poor = rs.getInt("poor");
				int weak = rs.getInt("weak");
				int average = rs.getInt("average");
				int pretty = rs.getInt("pretty");
				int good = rs.getInt("good");
				result.add(poor);
				result.add(weak);
				result.add(average);
				result.add(pretty);
				result.add(good);
			}
			System.out.println("Your SQL Query:\n" + sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}