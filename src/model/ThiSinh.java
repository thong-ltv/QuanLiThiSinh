package model;
import java.util.Date;
import java.util.Objects;

public class ThiSinh {
	private int maThiSinh;
	private String tenThiSinh;
	private Tinh maQueQuan;
	private Date ngaySinh;
	private boolean gioiTinh;
	private float diemMon1, diemMon2, diemMon3;
	
	public ThiSinh() {
		
	}
	public ThiSinh(int maThiSinh, String tenThiSinh, Tinh maQueQuan, Date ngaySinh, boolean gioiTinh, float diemMon1,
			float diemMon2, float diemMon3) {
		this.maThiSinh = maThiSinh;
		this.tenThiSinh = tenThiSinh;
		this.maQueQuan = maQueQuan;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diemMon1 = diemMon1;
		this.diemMon2 = diemMon2;
		this.diemMon3 = diemMon3;
	}
	
	public int getMaThiSinh() {
		return maThiSinh;
	}
	public void setMaThiSinh(int maThiSinh) {
		this.maThiSinh = maThiSinh;
	}
	public String getTenThiSinh() {
		return tenThiSinh;
	}
	public void setTenThiSinh(String tenThiSinh) {
		this.tenThiSinh = tenThiSinh;
	}
	public Tinh getMaQueQuan() {
		return maQueQuan;
	}
	public void setMaQueQuan(Tinh maQueQuan) {
		this.maQueQuan = maQueQuan;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public float getDiemMon1() {
		return diemMon1;
	}
	public void setDiemMon1(float diemMon1) {
		this.diemMon1 = diemMon1;
	}
	public float getDiemMon2() {
		return diemMon2;
	}
	public void setDiemMon2(float diemMon2) {
		this.diemMon2 = diemMon2;
	}
	public float getDiemMon3() {
		return diemMon3;
	}
	public void setDiemMon3(float diemMon3) {
		this.diemMon3 = diemMon3;
	}
	@Override
	public String toString() {
		return "ThiSinh [maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", maQueQuan=" + maQueQuan
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diemMon1=" + diemMon1 + ", diemMon2="
				+ diemMon2 + ", diemMon3=" + diemMon3 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(diemMon1, diemMon2, diemMon3, gioiTinh, maQueQuan, maThiSinh, ngaySinh, tenThiSinh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThiSinh other = (ThiSinh) obj;
		return Float.floatToIntBits(diemMon1) == Float.floatToIntBits(other.diemMon1)
				&& Float.floatToIntBits(diemMon2) == Float.floatToIntBits(other.diemMon2)
				&& Float.floatToIntBits(diemMon3) == Float.floatToIntBits(other.diemMon3) && gioiTinh == other.gioiTinh
				&& Objects.equals(maQueQuan, other.maQueQuan) && maThiSinh == other.maThiSinh
				&& Objects.equals(ngaySinh, other.ngaySinh) && Objects.equals(tenThiSinh, other.tenThiSinh);
	}
	
	//dinh dang kieu tra ve date
	public String chuyenDate(Date d) {
		int date = d.getDate();
		int month = d.getMonth() + 12;
		int year = d.getYear() - 1;
		return date + "/" + month + "/" + year;
	}
	
}
