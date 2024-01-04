package model;

public class nguoi {
	String ma_nguoi, ten_nguoi;
	int gioi_tinh;
	String ngay_sinh, dia_chi;

	public nguoi(String ma_nguoi, String ten_nguoi, int gioi_tinh, String ngay_sinh, String dia_chi) {
		super();
		this.ma_nguoi = ma_nguoi;
		this.ten_nguoi = ten_nguoi;
		this.gioi_tinh = gioi_tinh;
		this.ngay_sinh = ngay_sinh;
		this.dia_chi = dia_chi;
	}

	public String getMa_nguoi() {
		return ma_nguoi;
	}

	public void setMa_nguoi(String ma_nguoi) {
		this.ma_nguoi = ma_nguoi;
	}

	public String getTen_nguoi() {
		return ten_nguoi;
	}

	public void setTen_nguoi(String ten_nguoi) {
		this.ten_nguoi = ten_nguoi;
	}

	public int getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(int gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getNgay_sinh() {
		return ngay_sinh;
	}

	public void setNgay_sinh(String ngay_sinh) {
		this.ngay_sinh = ngay_sinh;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	@Override
	public String toString() {
		return "nguoi [ma_nguoi=" + ma_nguoi + ", ten_nguoi=" + ten_nguoi + ", gioi_tinh=" + gioi_tinh + ", ngay_sinh="
				+ ngay_sinh + ", dia_chi=" + dia_chi + "]";
	}

}
