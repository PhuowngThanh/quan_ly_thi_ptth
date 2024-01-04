package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import connection.dbConnector;
import model.giam_thi;
import model.giam_thi;

public class giam_thi_Dao implements DaoInterface<giam_thi>{
	private String sqlSelectAll = " SELECT gt.ma_giam_thi, gt.ten_giam_thi, gt.gioi_tinh, "
			+ "gt.ngay_sinh, gt.dia_chi, gt.chuc_vu, ct.ma_phong_thi FROM giam_thi gt LEFT JOIN "
			+ "coi_thi ct ON gt.ma_giam_thi = ct.ma_giam_thi";
	
	
	public static giam_thi_Dao getInstance() {
		return new giam_thi_Dao();
		
	}
	public ArrayList<giam_thi> search(int searchFilter, String searchData){
		ArrayList<giam_thi> ketqua = new ArrayList<giam_thi>();
		try {
			Connection con = dbConnector.getConnection();
			String sql;
			String sqlKeyFields[] = { "gt.ma_giam_thi", "gt.ten_giam_thi", "gt.gioi_tinh", "gt.ngay_sinh", "gt.dia_chi", "gt.chuc_vu", "ct.ma_phong_thi"};
			if (searchFilter == 0) {
				sql = sqlSelectAll 
						+" Where gt.ma_giam_thi LIKE ? OR gt.ten_giam_thi LIKE ? OR gt.gioi_tinh LIKE ? "
						+ "OR gt.ngay_sinh LIKE ? OR gt.chuc_vu LIKE ? OR ct.ma_phong_thi LIKE ? ";
			} else {
				sql = sqlSelectAll + " WHERE " + sqlKeyFields[(searchFilter - 1)] + " LIKE ? ";
			}
			PreparedStatement pst = con.prepareStatement(sql);
			if(searchFilter == 0) {
				for (int i = 1; i <= 7; i++) {
					pst.setString(i, "%" + searchData + "%");
					if (searchData.equalsIgnoreCase("Nam")) {
						pst.setString(3, "%" + '1' + "%");
					} else if (searchData.equalsIgnoreCase("Nữ")) {
						pst.setString(3, "%" + '1' + "%");						
					}
				}
			}else if (searchFilter == 3) {
				if (searchData.equalsIgnoreCase("Nam")) {
					pst.setString(3, "%" + '1' + "%");
				} else if (searchData.equalsIgnoreCase("Nữ")) {
					pst.setString(3, "%" + '1' + "%");						
				}
			}else {
				pst.setString(1, "%" + searchData + "%");				
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_giam_thi = rs.getString("ma_giam_thi");
				String ten_giam_thi = rs.getString("ten_giam_thi");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String chuc_vu = rs.getString("chuc_vu");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				ketqua.add(new giam_thi(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi));
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
	public giam_thi read(giam_thi x) {
		// TODO Auto-generated method stub
		giam_thi ketqua = null;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT * FROM giam_thi WHERE ma_giam_thi = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, x.getMa_nguoi());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_giam_thi = rs.getString("ma_giam_thi");
				String ten_giam_thi = rs.getString("ten_giam_thi");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String chuc_vu = rs.getString("chuc_vu");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				ketqua = new giam_thi(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi);
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
	public ArrayList<giam_thi> readAll() {
		// TODO Auto-generated method stub
		ArrayList<giam_thi> ketqua = new ArrayList<giam_thi>();
			try {
			Connection con = dbConnector.getConnection();
			String sql = sqlSelectAll;
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_giam_thi = rs.getString("ma_giam_thi");
				String ten_giam_thi = rs.getString("ten_giam_thi");
				int gioi_tinh = rs.getInt("gioi_tinh");
				String ngay_sinh = rs.getString("ngay_sinh");
				String dia_chi = rs.getString("dia_chi");
				String chuc_vu = rs.getString("chuc_vu");
				String ma_phong_thi = rs.getString("ma_phong_thi");
				ketqua.add(new giam_thi(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi));
			}
			System.out.println("Cau truy van cua ban la: "+sql);
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	public ArrayList<String> readAllMa_giam_thi() {
		// TODO Auto-generated method stub
		ArrayList<String> ketqua = new ArrayList<String>();
			try {
			Connection con = dbConnector.getConnection();
			String sql = "SELECT ma_giam_thi FROM giam_thi";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma_giam_thi = rs.getString("ma_giam_thi");
				ketqua.add(ma_giam_thi);
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
	public int create(giam_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "INSERT INTO giam_thi (ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu) VALUES (?, ?, ?, ?, ?, ?)";
			String sql2 = "INSERT INTO coi_thi (ma_giam_thi, ma_phong_thi) VALUES (?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getMa_nguoi());
			pst.setString(2, x.getTen_nguoi());
			pst.setInt(3, x.getGioi_tinh());
			pst.setString(4, x.getNgay_sinh());
			pst.setString(5, x.getDia_chi());
			pst.setString(6, x.getChuc_vu());
			pst2.setString(1, x.getMa_nguoi());
			pst2.setString(2, x.getMa_phong_thi());
			ketqua = pst.executeUpdate();
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
	public int update(giam_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "UPDATE giam_thi SET ten_giam_thi=?, gioi_tinh=?, ngay_sinh=?, dia_chi=?, chuc_vu=? WHERE ma_giam_thi=?";
			String sql2 = "UPDATE coi_thi SET ma_phong_thi=? WHERE ma_giam_thi=?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getTen_nguoi());
			pst.setInt(2, x.getGioi_tinh());
			pst.setString(3, x.getNgay_sinh());
			pst.setString(4, x.getDia_chi());
			pst.setString(5, x.getChuc_vu());
			pst.setString(6, x.getMa_nguoi());
			pst2.setString(1, x.getMa_phong_thi());
			pst2.setString(2, x.getMa_nguoi());
			ketqua = pst.executeUpdate();
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
	public int delete(giam_thi x) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			Connection con = dbConnector.getConnection();
			String sql = "DELETE FROM giam_thi WHERE ma_giam_thi = ?";
			String sql2 = "DELETE FROM coi_thi WHERE ma_giam_thi = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			pst.setString(1, x.getMa_nguoi());
			pst2.setString(1, x.getMa_nguoi());
			ketqua = pst.executeUpdate();
			ketqua += pst2.executeUpdate();
			System.out.println("Cau truy van cua ban la: " + sql + "\n" + ketqua + " hang duoc cap nhat");
			dbConnector.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ketqua;
	}
	

}
