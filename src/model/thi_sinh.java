package model;

public class thi_sinh extends nguoi {
	String doi_tuong, to_hop, ma_phong_thi;
	double diem_so1, diem_so2, diem_so3;

	public thi_sinh(String ma_nguoi, String ten_nguoi, int gioi_tinh, String ngay_sinh, String dia_chi,
			String doi_tuong, String to_hop, String ma_phong_thi, double diem_so1, double diem_so2, double diem_so3) {
		super(ma_nguoi, ten_nguoi, gioi_tinh, ngay_sinh, dia_chi);
		this.doi_tuong = doi_tuong;
		this.to_hop = to_hop;
		this.ma_phong_thi = ma_phong_thi;
		this.diem_so1 = diem_so1;
		this.diem_so2 = diem_so2;
		this.diem_so3 = diem_so3;
	}

	public String getMa_phong_thi() {
		return ma_phong_thi;
	}

	public void setMa_phong_thi(String ma_phong_thi) {
		this.ma_phong_thi = ma_phong_thi;
	}

	public double getDiem_so1() {
		return diem_so1;
	}

	public void setDiem_so1(double diem_so1) {
		this.diem_so1 = diem_so1;
	}

	public double getDiem_so2() {
		return diem_so2;
	}

	public void setDiem_so2(double diem_so2) {
		this.diem_so2 = diem_so2;
	}

	public double getDiem_so3() {
		return diem_so3;
	}

	public void setDiem_so3(double diem_so3) {
		this.diem_so3 = diem_so3;
	}

	public String getDoi_tuong() {
		return doi_tuong;
	}

	public void setDoi_tuong(String doi_tuong) {
		this.doi_tuong = doi_tuong;
	}

	public String getTo_hop() {
		return to_hop;
	}

	public void setTo_hop(String to_hop) {
		this.to_hop = to_hop;
	}

	@Override
	public String toString() {
		return super.toString() + "thi_sinh [doi_tuong=" + doi_tuong + ", to_hop=" + to_hop + ", diem_so1=" + diem_so1
				+ ", diem_so2=" + diem_so2 + ", diem_so3=" + diem_so3 + "]";
	}

}
