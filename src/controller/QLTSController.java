package controller;

import model.ThiSinh;
import model.Tinh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.views.AbstractView;

import view.QLTSView;

public class QLTSController implements ActionListener, ListSelectionListener{
	QLTSView view;
	
	public QLTSController(QLTSView view) {
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String ac = e.getActionCommand();
		
		//bắt sự kiện nhấn vào nút thêm
		if(ac == "Thêm") {
			try {
				//khai bao cac bien trong ham
				int textFieldMaThiSinh;
				String textFieldHoTen;
				Tinh maQueQuan;
				Date ngaySinh;
				Boolean gioiTinh;
				float diemMon1;
				float diemMon2;
				float diemMon3 = 0;
				
				//kiểm tra dữ liệu đầu vào
				//lấy tất cả các dữ liệu đầu vào
				if(this.view.getTextFieldMaThiSinh().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô Mã Thí Sinh!!!");
					this.view.getTextFieldMaThiSinh().requestFocus();
					return;
				}else {
					//kiểm tra chuỗi đầu vào có chứa tất cả các kí tự số không bằng biểu thức chính quy: "\\d+"
					if(!this.view.getTextFieldMaThiSinh().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Mã thí sinh không hợp lê. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldMaThiSinh().setText("");
						this.view.getTextFieldMaThiSinh().requestFocus();
						return;
					}
					textFieldMaThiSinh = Integer.valueOf(this.view.getTextFieldMaThiSinh().getText());
					//kiểm tra xem mã thí sinh đã tồn tại chưa, nếu có thì thông báo cho người dùng nhập lại
					for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
						if(thiSinh.getMaThiSinh() == textFieldMaThiSinh) {
							JOptionPane.showMessageDialog(this.view, "Mã thí sinh đã tồn tại. Vui lòng nhập mã thí sinh khác!!!");
							this.view.getTextFieldMaThiSinh().setText("");
							this.view.getTextFieldMaThiSinh().requestFocus();
							return;
						}
					}
				}
				
				if(this.view.getTextFieldHoVaTen().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô Họ và tên!!!");
					this.view.getTextFieldHoVaTen().requestFocus();
					return;
				}else {
					textFieldHoTen = this.view.getTextFieldHoVaTen().getText();
				}
				
				if(this.view.getComboBox_QueQuan().getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng chọn tỉnh!!!");
					this.view.getComboBox_QueQuan().requestFocus();
					return;
				}else {
					int idTinh = this.view.getComboBox_QueQuan().getSelectedIndex();
//					int maTinh = 0;
//					for (Tinh tinh : Tinh.getDanhSachTS()) {
//						if (tinh.getTenTinh().equals(tenTinh)) {
//							System.out.println(tinh.getMaTinh());
//						}
//					}
//					Tinh maQueQuan = new Tinh(maTinh, tenTinh);
					maQueQuan = Tinh.getDanhSachTS().get(idTinh - 1);
				}
				
				if(this.view.getTxtNgaySinh().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô ngày sinh!!!");
					this.view.getTxtNgaySinh().requestFocus();
					return;
				}else {
					String textFieldNgaySinh = this.view.getTxtNgaySinh().getText();
					String[] subTextFieldNgaySinh = textFieldNgaySinh.split("/");
					if(!this.kiemTraNgaySinh(subTextFieldNgaySinh[0], subTextFieldNgaySinh[1], subTextFieldNgaySinh[2])) {
						JOptionPane.showMessageDialog(this.view, "Ngày sinh không hợp lê. Xin vui lòng nhập lại thông tin!!!");
						this.view.getTxtNgaySinh().setText("");
						this.view.getTxtNgaySinh().requestFocus();
						return;
					};
					ngaySinh = new Date(Integer.parseInt(subTextFieldNgaySinh[2]), Integer.parseInt(subTextFieldNgaySinh[1]),
							Integer.parseInt(subTextFieldNgaySinh[0]));
				}
				
				if(this.view.getBtnGioiTinh().getSelection() == null) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng chọn giới tính!!!");
					return;
				}else {
					gioiTinh = this.view.getBtnGioiTinh().getSelection() == this.view.btnRadioNu.getModel() ? false : true;
				}
				
				if(this.view.getTextFieldDiemMon1().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào điểm môn 1!!!");
					this.view.getTextFieldDiemMon1().requestFocus();
					return;
				}else {
					if(!this.view.getTextFieldDiemMon1().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 1 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon1().setText("");
						this.view.getTextFieldDiemMon1().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon1().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon1().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 1 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon1().setText("");
							this.view.getTextFieldDiemMon1().requestFocus();
							return;
						}
						diemMon1 = Float.parseFloat(this.view.getTextFieldDiemMon1().getText());
					}
				}
				
				if(this.view.getTextFieldDiemMon2().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô điểm môn 2!!!");
					this.view.getTextFieldDiemMon2().requestFocus();
					return;
				}else {
					if(!this.view.getTextFieldDiemMon2().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 2 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon2().setText("");
						this.view.getTextFieldDiemMon2().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon2().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon2().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 2 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon2().setText("");
							this.view.getTextFieldDiemMon2().requestFocus();
							return;
						}
						diemMon2 = Float.parseFloat(this.view.getTextFieldDiemMon2().getText());
					}
				}
				
				if(this.view.getTextFieldDiemMon3().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô điểm môn 3!!!");
					this.view.getTextFieldDiemMon3().requestFocus();
				}else {
					if(!this.view.getTextFieldDiemMon3().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 3 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon3().setText("");
						this.view.getTextFieldDiemMon3().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon3().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon3().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 3 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon3().setText("");
							this.view.getTextFieldDiemMon3().requestFocus();
							return;
						}
						diemMon3 = Float.parseFloat(this.view.getTextFieldDiemMon3().getText());
					}
				}
				
				//load người vừa mới thêm lên bảng table
				ThiSinh ts = new ThiSinh(textFieldMaThiSinh, textFieldHoTen, maQueQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
				this.view.getModel().insert(ts);
				this.xoaForm();
				Object[][] data = new Object[this.view.getModel().getDanhSachThiSinh().size()][8];

				for (int i = 0; i < this.view.getModel().getDanhSachThiSinh().size(); i++) {
				    ThiSinh thiSinh = this.view.getModel().getDanhSachThiSinh().get(i);
				    data[i][0] = thiSinh.getMaThiSinh();
				    data[i][1] = thiSinh.getTenThiSinh();
				    data[i][2] = thiSinh.getMaQueQuan().getTenTinh();
				    data[i][3] = thiSinh.chuyenDate(thiSinh.getNgaySinh());
				    data[i][4] = thiSinh.isGioiTinh() ? "Nam" : "Nữ";
				    data[i][5] = thiSinh.getDiemMon1();
				    data[i][6] = thiSinh.getDiemMon2();
				    data[i][7] = thiSinh.getDiemMon3();
				}
				DefaultTableModel model = new DefaultTableModel(
						data,
						new String[] {
							"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
						}
					);
				this.view.getTable().setModel(model);
				this.view.sapXepTangDan(model, this.view.getTable());
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
			
		}else if(ac == "Xóa") {
			try {
				if (!this.view.getTextFieldMaThiSinh().getText().equals("")) {
					int maThiSinh = Integer.valueOf(this.view.getTextFieldMaThiSinh().getText());
					Boolean tonTaiThiSinh = false;
					for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
						if (thiSinh.getMaThiSinh() == maThiSinh) {
							tonTaiThiSinh = true;
						}
					}
					if (tonTaiThiSinh) {
						int luaChon = JOptionPane.showConfirmDialog(this.view, "Bạn có thật sự muốn xóa thí sinh này?",
								"Hộp thoại xóa thí sinh", JOptionPane.YES_NO_OPTION);
						if (luaChon == JOptionPane.YES_OPTION) {
							this.view.getModel().deleteThiSinhById(maThiSinh);

							this.loadDanhSach(this.view.getModel().getDanhSachThiSinh());
						}
					} else {
						JOptionPane.showMessageDialog(this.view, "Mã thí sinh không tồn tại!");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(this.view, "Bạn chưa chọn thí sinh cần xóa!");
					this.view.getTextFieldMaThiSinh().requestFocus();
					return;
				} 
			} catch (Exception e3) {
				System.out.println(e3.getMessage());
			}
		}else if(ac == "Cập nhật") {
			try {
				//khai bao cac bien trong ham
				int textFieldMaThiSinh;
				String textFieldHoTen;
				Tinh maQueQuan;
				Date ngaySinh;
				Boolean gioiTinh;
				float diemMon1;
				float diemMon2;
				float diemMon3 = 0;
				
				//kiểm tra dữ liệu đầu vào
				//lấy tất cả các dữ liệu đầu vào
				//kiểm tra chuỗi đầu vào có chứa tất cả các kí tự số không bằng biểu thức chính quy: "\\d+"
				if(!this.view.getTextFieldMaThiSinh().getText().matches("\\d+")) {
					JOptionPane.showMessageDialog(this.view, "Mã thí sinh không hợp lê. Xin vui lòng nhập lại!!!");
					this.view.getTextFieldMaThiSinh().setText("");
					this.view.getTextFieldMaThiSinh().requestFocus();
					return;
				}
				
				if(this.view.getTextFieldMaThiSinh().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô Mã Thí Sinh!!!");
					this.view.getTextFieldMaThiSinh().requestFocus();
					return;
				}else {
					//kiểm tra xem mã thí sinh đã tồn tại chưa, nếu có thì thông báo cho người dùng nhập lại
					textFieldMaThiSinh = Integer.valueOf(this.view.getTextFieldMaThiSinh().getText());
//					for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
//						if(thiSinh.getMaThiSinh() == textFieldMaThiSinh) {
//							JOptionPane.showMessageDialog(this.view, "Mã thí sinh đã tồn tại. Vui lòng nhập mã thí sinh khác!!!");
//							this.view.getTextFieldMaThiSinh().setText("");
//							this.view.getTextFieldMaThiSinh().requestFocus();
//						}
//					}
				}
				
				if(this.view.getTextFieldHoVaTen().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô Họ và tên!!!");
					this.view.getTextFieldHoVaTen().requestFocus();
					return;
				}else {
					textFieldHoTen = this.view.getTextFieldHoVaTen().getText();
				}
				
				if(this.view.getComboBox_QueQuan().getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng chọn tỉnh!!!");
					this.view.getComboBox_QueQuan().requestFocus();
					return;
				}else {
					int idTinh = this.view.getComboBox_QueQuan().getSelectedIndex();
//					int maTinh = 0;
//					for (Tinh tinh : Tinh.getDanhSachTS()) {
//						if (tinh.getTenTinh().equals(tenTinh)) {
//							System.out.println(tinh.getMaTinh());
//						}
//					}
//					Tinh maQueQuan = new Tinh(maTinh, tenTinh);
					maQueQuan = Tinh.getDanhSachTS().get(idTinh - 1);
				}
				
				if(this.view.getTxtNgaySinh().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô ngày sinh!!!");
					this.view.getTxtNgaySinh().requestFocus();
					return;
				}else {
					String textFieldNgaySinh = this.view.getTxtNgaySinh().getText();
					String[] subTextFieldNgaySinh = textFieldNgaySinh.split("/");
					if(!this.kiemTraNgaySinh(subTextFieldNgaySinh[0], subTextFieldNgaySinh[1], subTextFieldNgaySinh[2])) {
						JOptionPane.showMessageDialog(this.view, "Ngày sinh không hợp lê. Xin vui lòng nhập lại thông tin!!!");
						this.view.getTxtNgaySinh().setText("");
						this.view.getTxtNgaySinh().requestFocus();
						return;
					};
					ngaySinh = new Date(Integer.parseInt(subTextFieldNgaySinh[2]), Integer.parseInt(subTextFieldNgaySinh[1]),
							Integer.parseInt(subTextFieldNgaySinh[0]));
				}
				
				if(this.view.getBtnGioiTinh().getSelection() == null) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng chọn giới tính!!!");
					return;
				}else {
					gioiTinh = this.view.getBtnGioiTinh().getSelection() == this.view.btnRadioNu.getModel() ? false : true;
				}
				
				if(this.view.getTextFieldDiemMon1().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào điểm môn 1!!!");
					this.view.getTextFieldDiemMon1().requestFocus();
					return;
				}else {
					if(!this.view.getTextFieldDiemMon1().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 1 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon1().setText("");
						this.view.getTextFieldDiemMon1().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon1().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon1().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 1 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon1().setText("");
							this.view.getTextFieldDiemMon1().requestFocus();
							return;
						}
						diemMon1 = Float.parseFloat(this.view.getTextFieldDiemMon1().getText());
					}
				}
				
				if(this.view.getTextFieldDiemMon2().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô điểm môn 2!!!");
					this.view.getTextFieldDiemMon2().requestFocus();
					return;
				}else {
					if(!this.view.getTextFieldDiemMon2().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 2 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon2().setText("");
						this.view.getTextFieldDiemMon2().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon2().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon2().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 2 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon2().setText("");
							this.view.getTextFieldDiemMon2().requestFocus();
							return;
						}
						diemMon2 = Float.parseFloat(this.view.getTextFieldDiemMon2().getText());
					}
				}
				
				if(this.view.getTextFieldDiemMon3().getText().equals("")) {
					JOptionPane.showMessageDialog(this.view, "Bạn vui lòng nhập thông tin vào ô điểm môn 3!!!");
					this.view.getTextFieldDiemMon3().requestFocus();
				}else {
					if(!this.view.getTextFieldDiemMon3().getText().matches("\\d+")) {
						JOptionPane.showMessageDialog(this.view, "Điểm môn 3 không hợp lệ. Xin vui lòng nhập lại!!!");
						this.view.getTextFieldDiemMon3().setText("");
						this.view.getTextFieldDiemMon3().requestFocus();
						return;
					}else {
						if(Float.parseFloat(this.view.getTextFieldDiemMon3().getText()) < 0 || Float.parseFloat(this.view.getTextFieldDiemMon3().getText()) > 10) {
							JOptionPane.showMessageDialog(this.view, "Điểm môn 3 không hợp lệ. Xin vui lòng nhập lại!!!");
							this.view.getTextFieldDiemMon3().setText("");
							this.view.getTextFieldDiemMon3().requestFocus();
							return;
						}
						diemMon3 = Float.parseFloat(this.view.getTextFieldDiemMon3().getText());
					}
				}
				
				//load người vừa mới thêm lên bảng table
				ThiSinh ts = new ThiSinh(textFieldMaThiSinh, textFieldHoTen, maQueQuan, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
				this.view.getModel().deleteThiSinhById(textFieldMaThiSinh);
				this.view.getModel().insert(ts);
				this.xoaForm();
				this.loadDanhSach(this.view.getModel().getDanhSachThiSinh());
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}else if(ac == "Xóa Form") {
//			this.xoaForm();
			
		}else if(ac == "Tìm kiếm") {
			String tenTinh = this.view.getComboBoxQueQuan().getSelectedItem().toString();
			String maThiSinh = this.view.getTxtMaSinhVien().getText();
			//kiem tra ben o tim kiem que quan co du lieu khong
			
			//tao ra mang rong de lua danh sach tim kiem duoc
			ArrayList<ThiSinh> listTimKiem = new ArrayList<>();
			if((!tenTinh.equals(" ")) && (!maThiSinh.equals(""))) {
				for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
					if(thiSinh.getMaThiSinh() == Integer.valueOf(maThiSinh) && (thiSinh.getMaQueQuan().getTenTinh() == tenTinh)) {
						listTimKiem.add(thiSinh);
					}
					if(listTimKiem.isEmpty()) {
						JOptionPane.showMessageDialog(this.view, "Không tìm thấy");
					}
					this.loadDanhSach(listTimKiem);
				}
			}else if((!tenTinh.equals(" "))) {
				for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
					if(thiSinh.getMaQueQuan().getTenTinh() == tenTinh) {
						listTimKiem.add(thiSinh);
					}
					if(listTimKiem.isEmpty()) {
						JOptionPane.showMessageDialog(this.view, "Không tìm thấy");
					}
					this.loadDanhSach(listTimKiem);
				}
			}else if((!maThiSinh.equals(""))) {
				for (ThiSinh thiSinh : this.view.getModel().getDanhSachThiSinh()) {
					if(thiSinh.getMaThiSinh() == Integer.valueOf(maThiSinh)) {
						listTimKiem.add(thiSinh);
					}
					if(listTimKiem.isEmpty()) {
						JOptionPane.showMessageDialog(this.view, "Không tìm thấy");
					}
					this.loadDanhSach(listTimKiem);
				}
			}
		}else if(ac == "Hủy Tìm") {
			this.loadDanhSach(this.view.getModel().getDanhSachThiSinh());
		}
		 
	//bắt sự kiện khi ta kích chọn 1 hàng trong bảng table
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = this.view.getTable().getSelectedRow();
		if(selectedRow != -1) {
			int textFieldMaThiSinh = Integer.valueOf(this.view.getTable().getValueAt(selectedRow, 0).toString());
			String textFieldHoTen = this.view.getTable().getValueAt(selectedRow, 1).toString();
			String tenTinh = this.view.getTable().getValueAt(selectedRow, 2).toString();
			String ngaySinh = this.view.getTable().getValueAt(selectedRow, 3).toString();
			Boolean gioiTinh = this.view.getTable().getValueAt(selectedRow, 4).toString() == "Nam" ? true : false ;
			String diemMon1 = this.view.getTable().getValueAt(selectedRow, 5).toString();
			String diemMon2 = this.view.getTable().getValueAt(selectedRow, 6).toString();
			String diemMon3 = this.view.getTable().getValueAt(selectedRow, 7).toString();
			
			this.view.getTextFieldMaThiSinh().setText(textFieldMaThiSinh +"");
			this.view.getTextFieldHoVaTen().setText(textFieldHoTen);
			this.view.getComboBox_QueQuan().setSelectedItem(tenTinh);
			this.view.getTxtNgaySinh().setText(ngaySinh);
			if(gioiTinh) {
				this.view.getBtnGioiTinh().setSelected(this.view.btnRadioNam.getModel(), true);
			}else {
				this.view.getBtnGioiTinh().setSelected(this.view.btnRadioNu.getModel(), true);
			}
			this.view.getTextFieldDiemMon1().setText(diemMon1);
			this.view.getTextFieldDiemMon2().setText(diemMon2);
			this.view.getTextFieldDiemMon3().setText(diemMon3);
		}
	}
	
	//ham load danh sach len table
	public void loadDanhSach(ArrayList<ThiSinh> model) {
		Object[][] data = new Object[model.size()][8];
		
		for (int i = 0; i < model.size(); i++) {
		    ThiSinh thiSinh = model.get(i);
		    data[i][0] = thiSinh.getMaThiSinh();
		    data[i][1] = thiSinh.getTenThiSinh();
		    data[i][2] = thiSinh.getMaQueQuan().getTenTinh();
		    data[i][3] = thiSinh.chuyenDate(thiSinh.getNgaySinh());
		    data[i][4] = thiSinh.isGioiTinh() ? "Nam" : "Nữ";
		    data[i][5] = thiSinh.getDiemMon1();
		    data[i][6] = thiSinh.getDiemMon2();
		    data[i][7] = thiSinh.getDiemMon3();
		}
		DefaultTableModel md = new DefaultTableModel(
				data,
				new String[] {
					"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
				}
			);
		this.view.getTable().setModel(md);
		this.view.sapXepTangDan(md, this.view.getTable());
	}
	
	//ham kiem tra ngay sinh
	public boolean kiemTraNgaySinh(String date, String month, String year) {
		//sau khi cắt chuỗi xong, ta tiến hành kiểm tra
		//các phần tử trong chuỗi có phải thuộc dạng kí tự số không
		if(!date.matches("\\d+") || !month.matches("\\d+") || !month.matches("\\d+")) {
			return false;
		}
		//kiểm tra xem có phải là năm nhuận không để kiểm tra tháng 2
		if(Integer.valueOf(year) < 1930 || Integer.valueOf(year) > 2023) {
			return false;
		}else {
			if(Integer.valueOf(year) % 100 == 0) {
				if(Integer.valueOf(year) % 4 == 0) {
					if(Integer.valueOf(month) == 2 && (Integer.valueOf(date) <= 29 && Integer.valueOf(date) >= 1)) {
						return true;
					}else {
						if(Integer.valueOf(month) == 1 || Integer.valueOf(month) == 3 || Integer.valueOf(month) == 5 || Integer.valueOf(month) == 7 || Integer.valueOf(month) == 8 || Integer.valueOf(month) == 10 || Integer.valueOf(month) == 12 ) {
							if(Integer.valueOf(date) <= 31 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}else {
							if(Integer.valueOf(date) <= 30 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}
					}
				}else {
					if(Integer.valueOf(month) == 2 && (Integer.valueOf(date) <= 28 && Integer.valueOf(date) >= 1)) {
						return true;
					}else {
						if(Integer.valueOf(month) == 1 || Integer.valueOf(month) == 3 || Integer.valueOf(month) == 5 || Integer.valueOf(month) == 7 || Integer.valueOf(month) == 8 || Integer.valueOf(month) == 10 || Integer.valueOf(month) == 12 ) {
							if(Integer.valueOf(date) <= 31 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}else {
							if(Integer.valueOf(date) <= 30 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}
					}
				}
			}else {
				if(Integer.valueOf(year) % 4 == 0) {
					if(Integer.valueOf(month) == 2 && (Integer.valueOf(date) <= 29 && Integer.valueOf(date) >= 1)) {
						return true;
					}else {
						if(Integer.valueOf(month) == 1 || Integer.valueOf(month) == 3 || Integer.valueOf(month) == 5 || Integer.valueOf(month) == 7 || Integer.valueOf(month) == 8 || Integer.valueOf(month) == 10 || Integer.valueOf(month) == 12 ) {
							if(Integer.valueOf(date) <= 31 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}else {
							if(Integer.valueOf(date) <= 30 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}
					}
				}else {
					if(Integer.valueOf(month) == 2) {
						if(Integer.valueOf(date) <= 28 && Integer.valueOf(date) >= 1) {
							return true;
						}else {
							return false;
						}
					}else {
						if(Integer.valueOf(month) == 1 || Integer.valueOf(month) == 3 || Integer.valueOf(month) == 5 || Integer.valueOf(month) == 7 || Integer.valueOf(month) == 8 || Integer.valueOf(month) == 10 || Integer.valueOf(month) == 12 ) {
							if(Integer.valueOf(date) <= 31 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}else {
							if(Integer.valueOf(date) <= 30 && Integer.valueOf(date) >= 1) {
								return true;
							}else {
								return false;
							}
						}
					}
				}
			}
		}
	
	}
	
	//ham xoa form
	public void xoaForm() {
		this.view.getTextFieldMaThiSinh().setText("");
		this.view.getTextFieldHoVaTen().setText("");
		this.view.getTxtNgaySinh().setText("");
		this.view.getTextFieldDiemMon1().setText("");
		this.view.getTextFieldDiemMon2().setText("");
		this.view.getTextFieldDiemMon3().setText("");
		this.view.getComboBox_QueQuan().setSelectedItem("");
		this.view.getBtnGioiTinh().clearSelection();
	}
}
