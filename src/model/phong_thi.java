package model;

public class phong_thi {
	String ma_phong_thi;

	public phong_thi(String ma_phong_thi) {
		super();
		this.ma_phong_thi = ma_phong_thi;
	}

	public String getMa_phong_thi() {
		return ma_phong_thi;
	}

	public void setMa_phong_thi(String ma_phong_thi) {
		this.ma_phong_thi = ma_phong_thi;
	}

	@Override
	public String toString() {
		return "phong_thi [ma_phong_thi=" + ma_phong_thi + "]";
	}

}
