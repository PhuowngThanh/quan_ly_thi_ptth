package model;

public class giam_thi extends nguoi {
	String chuc_vu, ma_phong_thi;

	public giam_thi(String ma_nguoi, String ten_nguoi, int gioi_tinh, String ngay_sinh, String dia_chi, String chuc_vu,
			String ma_phong_thi) {
		super(ma_nguoi, ten_nguoi, gioi_tinh, ngay_sinh, dia_chi);
		this.chuc_vu = chuc_vu;
		this.ma_phong_thi = ma_phong_thi;
	}

	public String getChuc_vu() {
		return chuc_vu;
	}

	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}

	public String getMa_phong_thi() {
		return ma_phong_thi;
	}

	public void setMa_phong_thi(String ma_phong_thi) {
		this.ma_phong_thi = ma_phong_thi;
	}

	@Override
	public String toString() {
		return super.toString() + "giam_thi [chuc_vu=" + chuc_vu + ", ma_phong_thi=" + ma_phong_thi + "]";
	}

}
