package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import connection.dbConnector;
import model.phong_thi;
import model.phong_thi;

public class phong_thi_Dao implements DaoInterface<phong_thi>{
	public static phong_thi_Dao getInstance() {
		return new phong_thi_Dao();
		
	}

	@Override
	public phong_thi read(phong_thi x) {
		// TODO Auto-generated method stub
		phong_thi ketqua = null;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT * FROM phong_thi WHERE ma_phong_thi = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_phong_thi());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_phong_thi = rs.getString("ma_phong_thi");
				ketqua = new phong_thi( ma_phong_thi);
			}
			System.out.println("Cau truy van cua ban la: "+sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<phong_thi> readAll() {
		// TODO Auto-generated method stub
		ArrayList<phong_thi> ketqua = new ArrayList<phong_thi>();
			try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT * FROM phong_thi ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_phong_thi = rs.getString("ma_phong_thi");
				
				ketqua.add(new phong_thi( ma_phong_thi));
			}
			System.out.println("Cau truy van cua ban la: "+sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int create(phong_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "INSERT INTO phong_thi (ma_phong_thi) VALUES (?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_phong_thi());
			ketqua = pst.executeUpdate();
			
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(phong_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "UPDATE phong_thi SET WHERE ma_phong_thi=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_phong_thi());
			ketqua = pst.executeUpdate();
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(phong_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "DELETE  FROM phong_thi WHERE ma_phong_thi = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_phong_thi());
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	

}
