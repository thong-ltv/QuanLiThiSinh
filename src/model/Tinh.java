package model;
import java.util.ArrayList;
import java.util.Objects;

public class Tinh {
	private int maTinh;
	private String tenTinh;
	
	public Tinh(int maTih, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}
	
	public int getMaTinh() {
		return maTinh;
	}
	
	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	@Override
	public String toString() {
		return "Tinh [maTinh=" + maTinh + ", tenTinh=" + tenTinh + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTinh, tenTinh);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tinh other = (Tinh) obj;
		return maTinh == other.maTinh && Objects.equals(tenTinh, other.tenTinh);
	}
	
	public static ArrayList<Tinh> getDanhSachTS() {
		// TODO Auto-generated method stub
		//tao danh sach cac tinh thanh
				String[] arr_tinh = {
									"An Giang",
									"Bà Rịa – Vũng Tàu",
									"Bạc Liêu",
									"Bắc Giang",
									"Bắc Kạn",
									"Bắc Ninh",
									"Bến Tre",
									"Bình Dương",
									"Bình Định",
									"Bình Phước",
									"Bình Thuận",
									"Cà Mau",
									"Cao Bằng",
									"Cần Thơ",
									"Đà Nẵng",
									"Đắk Lắk",
									"Đắk Nông",
									"Điện Biên",
									"Đồng Nai",
									"Đồng Tháp",
									"Gia Lai",
									"Hà Giang",
									"Hà Nam",
									"Hà Nội",
									"Hà Tĩnh",
									"Hải Dương",
									"Hải Phòng",
									"Hậu Giang",
									"Hòa Bình",
									"Thành phố Hồ Chí Minh",
									"Hưng Yên",
									"Khánh Hòa",
									"Kiên Giang",
									"Kon Tum",
									"Lai Châu",
									"Lạng Sơn",
									"Lào Cai",
									"Lâm Đồng",
									"Long An",
									"Nam Định",
									"Nghệ An",
									"Ninh Bình",
									"Ninh Thuận",
									"Phú Thọ",
									"Phú Yên",
									"Quảng Bình",
									"Quảng Nam",
									"Quảng Ngãi",
									"Quảng Ninh",
									"Quảng Trị",
									"Sóc Trăng",
									"Sơn La",
									"Tây Ninh",
									"Thái Bình",
									"Thái Nguyên",
									"Thanh Hóa",
									"Thừa Thiên Huế",
									"Tiền Giang",
									"Trà Vinh",
									"Tuyên Quang",
									"Vĩnh Long",
									"Vĩnh Phúc",
									"Yên Bái"
				};
				
				//tao mang de chua cac tinh bang ArrayList
				ArrayList<Tinh> listTinh = new ArrayList<Tinh>();
				int i = 0;
				//duyet qua cac tinh roi add chúng vào listTinh
				for (String tenTinh : arr_tinh) {
					Tinh tinh = new Tinh(i, tenTinh);
					listTinh.add(tinh);
				}
				
				return listTinh;
	};
}
