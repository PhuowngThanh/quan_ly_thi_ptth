package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import connection.dbConnector;
import model.thi_sinh;

public class thi_sinh_Dao implements DaoInterface<thi_sinh>{
	private String sqlSelectAll = "SELECT ts.ma_thi_sinh, ts.ten_thi_sinh, ts.gioi_tinh, "
			+ "ts.ngay_sinh, ts.dia_chi, ts.doi_tuong, thi.to_hop, thi.ma_phong_thi, thi.diem_so1, thi.diem_so2, "
			+ "thi.diem_so3 FROM thi_sinh ts LEFT JOIN thi ON ts.ma_thi_sinh = thi.ma_thi_sinh";
	
	
	public static thi_sinh_Dao getInstance() {
		return new thi_sinh_Dao();
		
	}
	public ArrayList<thi_sinh> search(int searchFilter, String searchData){
		ArrayList<thi_sinh> ketqua = new ArrayList<thi_sinh>();
		try {
			Connection con = dbConnector.getConnection();
			String sql;
			String sqlKeyFields[] = { "ts.ma_thi_sinh", "ts.ten_thi_sinh", "ts.gioi_tinh", "ts.ngay_sinh", "ts.dia_chi", "ts.doi_tuong", "thi.to_hop", "thi.ma_phong_thi", "thi.diem_so1", "thi.diem_so2", "thi.diem_so3"};
			if (searchFilter == 0) {
				sql = sqlSelectAll 
						+" Where ts.ma_thi_sinh LIKE ? OR ts.ten_thi_sinh LIKE ? OR ts.gioi_tinh LIKE ? "
						+ "OR ts.ngay_sinh LIKE ? OR ts.dia_chi LIKE ? OR ts.doi_tuong LIKE ? OR thi.to_hop LIKE ? "
						+ "OR thi.ma_phong_thi LIKE ? OR thi.diem_so1 LIKE ? OR thi.diem_so2 LIKE ? OR thi.diem_so3 LIKE ?";
			} else {
				sql = sqlSelectAll + " WHERE " + sqlKeyFields[(searchFilter - 1)] + " LIKE ? ";
			}
			PreparedStatement pst = con.prepareStatement(sql);
			if(searchFilter == 0) {
				for (int i = 1; i <= 11; i++) {
					pst.setString(i, "%" + searchData + "%");
					if (searchData.equalsIgnoreCase("Nam")) {
						pst.setString(3, "%" + '1' + "%");
					} else if (searchData.equalsIgnoreCase("Nữ")) {
						pst.setString(3, "%" + '0' + "%");						
					}
				}
			}else if (searchFilter == 3) {
				if (searchData.equalsIgnoreCase("Nam")) {
					pst.setString(1, "%" + '1' + "%");
				} else if (searchData.equalsIgnoreCase("Nữ")) {
					pst.setString(1, "%" + '0' + "%");						
				}
			}else {
				pst.setString(1, "%" + searchData + "%");				
			}
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_thi_sinh = rs.getString("ma_thi_sinh");
				String ten_thi_sinh = rs.getString("ten_thi_sinh");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String doi_tuong = rs.getString("doi_tuong");
				String to_hop = rs.getString("to_hop");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				double diem_so1 =rs.getDouble("diem_so1");
				double diem_so2 =rs.getDouble("diem_so2");
				double diem_so3 =rs.getDouble("diem_so3");
				ketqua.add(new thi_sinh(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, doi_tuong, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3));
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
	public thi_sinh read(thi_sinh x) {
		// TODO Auto-generated method stub
		thi_sinh ketqua = null;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT * FROM thi_sinh WHERE ma_thi_sinh = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_nguoi());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_thi_sinh = rs.getString("ma_thi_sinh");
				String ten_thi_sinh = rs.getString("ten_thi_sinh");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String doi_tuong = rs.getString("doi_tuong");
				String to_hop = rs.getString("to_hop");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				double diem_so1 =rs.getDouble("diem_so1");
				double diem_so2 =rs.getDouble("diem_so2");
				double diem_so3 =rs.getDouble("diem_so3");
				ketqua = new thi_sinh(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, doi_tuong, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3);
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
	public ArrayList<thi_sinh> readAll() {
		// TODO Auto-generated method stub
		ArrayList<thi_sinh> ketqua = new ArrayList<thi_sinh>();
			try {
			Connection con = dbConnector.getConnection();
			String sql = sqlSelectAll;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_thi_sinh = rs.getString("ma_thi_sinh");
				String ten_thi_sinh = rs.getString("ten_thi_sinh");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String doi_tuong = rs.getString("doi_tuong");
				String to_hop = rs.getString("to_hop");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				double diem_so1 =rs.getDouble("diem_so1");
				double diem_so2 =rs.getDouble("diem_so2");
				double diem_so3 =rs.getDouble("diem_so3");
				ketqua.add(new thi_sinh(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, doi_tuong, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3));
			}
			System.out.println("Cau truy van cua ban la: "+sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<String> readAllMa_thi_sinh() {
		// TODO Auto-generated method stub
		ArrayList<String> ketqua = new ArrayList<String>();
			try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT ma_thi_sinh FROM thi_sinh";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_thi_sinh = rs.getString("ma_thi_sinh");
				ketqua.add(ma_thi_sinh);
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
	public int create(thi_sinh x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "INSERT INTO thi_sinh (ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, doi_tuong) VALUES (?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO thi (ma_thi_sinh, ma_phong_thi, to_hop, diem_so1, diem_so2, diem_so3) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getMa_nguoi());
			pst.setString(2, x.getTen_nguoi());
			pst.setInt(3, x.getGioi_tinh());
			pst.setString(4, x.getNgay_sinh());
			pst.setString(5, x.getDia_chi());
			pst.setString(6, x.getDoi_tuong());
			ketqua = pst.executeUpdate();
			pst2.setString(1, x.getMa_nguoi());
			pst2.setString(2, x.getMa_phong_thi());
			pst2.setString(3, x.getTo_hop());
			pst2.setDouble(4, x.getDiem_so1());
			pst2.setDouble(5, x.getDiem_so2());
			pst2.setDouble(6, x.getDiem_so3());
			ketqua += pst2.executeUpdate();
			
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(thi_sinh x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "UPDATE thi_sinh SET ten_thi_sinh=?, gioi_tinh=?, ngay_sinh=?, dia_chi=?, doi_tuong=? WHERE ma_thi_sinh=?";
			String sql2 = "UPDATE thi SET ma_phong_thi=?, to_hop=?, diem_so1=?, diem_so2=?, diem_so3=? WHERE ma_thi_sinh = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getTen_nguoi());
			pst.setInt(2, x.getGioi_tinh());
			pst.setString(3, x.getNgay_sinh());
			pst.setString(4, x.getDia_chi());
			pst.setString(5, x.getDoi_tuong());
			pst.setString(6, x.getMa_nguoi());
			ketqua = pst.executeUpdate();
			pst2.setString(1, x.getMa_phong_thi());
			pst2.setString(2, x.getTo_hop());
			pst2.setDouble(3, x.getDiem_so1());
			pst2.setDouble(4, x.getDiem_so2());
			pst2.setDouble(5, x.getDiem_so3());
			pst2.setString(6, x.getMa_nguoi());
			ketqua += pst2.executeUpdate();
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(thi_sinh x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "DELETE  FROM thi_sinh WHERE ma_thi_sinh = ?";
			String sql2 = "DELETE  FROM thi WHERE ma_thi_sinh = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getMa_nguoi());
			pst2.setString(1, x.getMa_nguoi());
			ketqua = pst.executeUpdate();
			ketqua += pst2.executeUpdate();
			System.out.println("Cau truy van cua ban la: " + sql + sql2 + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	

}
