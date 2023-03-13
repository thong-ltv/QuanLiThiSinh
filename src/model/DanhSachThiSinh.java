package model;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class DanhSachThiSinh {
	private ArrayList<ThiSinh> dsThiSinh;
	
	//khoi tao constructor rong
	public DanhSachThiSinh() {
		this.dsThiSinh = new ArrayList<ThiSinh>();
	}
	
	//khoi tao constructor chua tham so
	public DanhSachThiSinh(ArrayList<ThiSinh> dsThiSinh) {
		this.dsThiSinh = dsThiSinh;
	}
	
	public void insert(ThiSinh thiSinh) {
		this.dsThiSinh.add(thiSinh);
	}
	
	public void delete(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
	}
	
	public void update(ThiSinh thiSinh) {
		this.dsThiSinh.remove(thiSinh);
		this.dsThiSinh.add(thiSinh);
	}
	
	//hàm lấy danh sách thí sinh
	public ArrayList<ThiSinh> getDanhSachThiSinh(){
		return this.dsThiSinh;
	}

	public void deleteThiSinhById(int maThiSinh) {
		ThiSinh ts = new ThiSinh();
		for (ThiSinh thiSinh : this.dsThiSinh) {
			if(thiSinh.getMaThiSinh() == maThiSinh) {
				ts = thiSinh;
			}
		}
		this.delete(ts);
	}
	
	
}
