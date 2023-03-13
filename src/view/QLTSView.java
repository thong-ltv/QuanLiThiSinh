package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JFormattedTextField;
import javax.swing.text.DateFormatter;
import javax.swing.text.MaskFormatter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import model.DanhSachThiSinh;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.events.MouseEvent;

import controller.QLTSController;

import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class QLTSView extends JFrame {

	private JPanel contentPane;
	private DanhSachThiSinh model;
	private JTextField txtMaSinhVien;
	private JTable table;
	private JTextField textFieldMaThiSinh;
	private JTextField textFieldHoVaTen;
	private JComboBox<String> comboBoxQueQuan;
	private JComboBox<String> comboBox_QueQuan;
	private JTextField txtNgaySinh;
	private JRadioButton gioiTinh;
	private ButtonGroup btnGioiTinh;
	public JRadioButton btnRadioNu;
	public JRadioButton btnRadioNam;
	private JTextField textFieldDiemMon1;
	private JTextField textFieldDiemMon2;
	private JTextField textFieldDiemMon3;

	
	public JTextField getTxtMaSinhVien() {
		return txtMaSinhVien;
	}

	public void setTxtMaSinhVien(JTextField txtMaSinhVien) {
		this.txtMaSinhVien = txtMaSinhVien;
	}

	public JTextField getTextFieldMaThiSinh() {
		return textFieldMaThiSinh;
	}

	public void setTextFieldMaThiSinh(JTextField textFieldMaThiSinh) {
		this.textFieldMaThiSinh = textFieldMaThiSinh;
	}

	public JTextField getTextFieldHoVaTen() {
		return textFieldHoVaTen;
	}

	public void setTextFieldHoVaTen(JTextField textFieldHoVaTen) {
		this.textFieldHoVaTen = textFieldHoVaTen;
	}
	

	public JComboBox<String> getComboBoxQueQuan() {
		return comboBoxQueQuan;
	}

	public void setComboBoxQueQuan(JComboBox<String> comboBoxQueQuan) {
		this.comboBoxQueQuan = comboBoxQueQuan;
	}

	public JComboBox<String> getComboBox_QueQuan() {
		return comboBox_QueQuan;
	}

	public void setComboBox_QueQuan(JComboBox<String> comboBox_QueQuan) {
		this.comboBox_QueQuan = comboBox_QueQuan;
	}

	public JTextField getTxtNgaySinh() {
		return txtNgaySinh;
	}

	public void setTxtNgaySinh(JTextField txtNgaySinh) {
		this.txtNgaySinh = txtNgaySinh;
	}
	
	public ButtonGroup getBtnGioiTinh() {
		return btnGioiTinh;
	}

	public void setBtnGioiTinh(ButtonGroup btnGioiTinh) {
		this.btnGioiTinh = btnGioiTinh;
	}

	public JTextField getTextFieldDiemMon1() {
		return textFieldDiemMon1;
	}

	public void setTextFieldDiemMon1(JTextField textFieldDiemMon1) {
		this.textFieldDiemMon1 = textFieldDiemMon1;
	}

	public JTextField getTextFieldDiemMon2() {
		return textFieldDiemMon2;
	}

	public void setTextFieldDiemMon2(JTextField textFieldDiemMon2) {
		this.textFieldDiemMon2 = textFieldDiemMon2;
	}

	public JTextField getTextFieldDiemMon3() {
		return textFieldDiemMon3;
	}

	public void setTextFieldDiemMon3(JTextField textFieldDiemMon3) {
		this.textFieldDiemMon3 = textFieldDiemMon3;
	}
	
	public DanhSachThiSinh getModel() {
		return model;
	}

	public void setModel(DanhSachThiSinh model) {
		this.model = model;
	}
	

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLTSView frame = new QLTSView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLTSView() {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		Tinh t = new Tinh(77, "Bình Định");
		Date d = new Date(2001, 12, 16);
		Date d1 = new Date(1995, 12, 9);
		ThiSinh ts01 = new ThiSinh(02, "Nguyen Van Thong", t, d, true, 7, 8, 9);
		ThiSinh ts02 = new ThiSinh(01, "Nguyen Thị Ngọc Ý", t, d1, false, 7, 8, 9);
		ds.add(ts01);
		ds.add(ts02);
		
		this.model = new DanhSachThiSinh(new ArrayList<ThiSinh>(ds));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 593);
		this.setTitle("Phần mềm quản lý sinh viên");
		
		ActionListener action = new QLTSController(this);
//		FocusListener focus = new QLTSController(this);
		//tao doi tuong de bat su kien khi kich vao mot o trong table
		ListSelectionListener ls = new QLTSController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuClose);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQueQuan = new JLabel("Quê quán");
		lblQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQueQuan.setBounds(32, 23, 73, 45);
		contentPane.add(lblQueQuan);
		
		JLabel lblMaSinhVien = new JLabel("Mã thí sinh");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaSinhVien.setBounds(288, 23, 79, 45);
		contentPane.add(lblMaSinhVien);
		
		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setColumns(10);
		txtMaSinhVien.setBounds(377, 23, 123, 34);
		contentPane.add(txtMaSinhVien);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.addActionListener(action);
		btnTimKiem.setBackground(Color.GRAY);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setForeground(Color.BLACK);
		btnTimKiem.setBounds(510, 23, 103, 35);
		contentPane.add(btnTimKiem);
		
		comboBoxQueQuan = new JComboBox();
		comboBoxQueQuan.addItem(" ");
		ArrayList<Tinh> dsTinh = Tinh.getDanhSachTS();
		for(Tinh tinh : dsTinh) {
			comboBoxQueQuan.addItem(tinh.getTenTinh());
		}
		comboBoxQueQuan.setBounds(115, 23, 112, 35);
		contentPane.add(comboBoxQueQuan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 78, 717, 4);
		contentPane.add(separator);
		
		JLabel lblDanhSachThiSinh = new JLabel("Danh sách thí sinh");
		lblDanhSachThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDanhSachThiSinh.setBounds(10, 86, 123, 45);
		contentPane.add(lblDanhSachThiSinh);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		if(this.model.getDanhSachThiSinh().isEmpty()) {
			table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m m\u00F4n 1", "\u0110i\u1EC3m m\u00F4n 2", "\u0110i\u1EC3m m\u00F4n 3"
					}
				));
			
		}else {
			Object[][] data = new Object[this.model.getDanhSachThiSinh().size()][8];

			for (int i = 0; i < this.model.getDanhSachThiSinh().size(); i++) {
			    ThiSinh thiSinh = this.model.getDanhSachThiSinh().get(i);
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
			table.setModel(model);
			this.sapXepTangDan(model, table);
		}
		table.setBounds(32, 133, 659, 121);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 121, 727, 92);
		contentPane.add(scrollPane);
		
		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectionModel.addListSelectionListener(ls);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 240, 717, 4);
		contentPane.add(separator_1);
		
		JLabel lblThongTinThiSinh = new JLabel("Thông tin thí sinh");
		lblThongTinThiSinh.setBounds(10, 251, 117, 45);
		contentPane.add(lblThongTinThiSinh);
		lblThongTinThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMaThiSinh = new JLabel("Mã thí sinh");
		lblMaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaThiSinh.setBounds(10, 295, 70, 17);
		contentPane.add(lblMaThiSinh);
		
		textFieldMaThiSinh = new JTextField();
//		textFieldMaThiSinh.addFocusListener(new FocusListener() {
//			@Override
//			public void focusGained(FocusEvent e) {
////				System.out.println("gained to ma thi sinh");
//				
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(e.getSource() == textFieldMaThiSinh) {
////					if((this.view.getTextFieldMaThiSinh().getText().equals("t"))) {
//						JOptionPane.showMessageDialog(null, "Bạn vui lòng nhập thông tin vào ô mã thí sinh!!!");
////					}
//				}
//				
//			}
//		});
		textFieldMaThiSinh.setColumns(10);
		textFieldMaThiSinh.setBounds(104, 295, 139, 19);
		contentPane.add(textFieldMaThiSinh);
		
		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoTen.setBounds(10, 339, 62, 17);
		contentPane.add(lblHoTen);
		
		textFieldHoVaTen = new JTextField();
		textFieldHoVaTen.setColumns(10);
		textFieldHoVaTen.setBounds(104, 339, 139, 19);
		contentPane.add(textFieldHoVaTen);
		
		JLabel labelQueQuan = new JLabel("Quê quán");
		labelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelQueQuan.setBounds(10, 383, 62, 17);
		contentPane.add(labelQueQuan);
		
		comboBox_QueQuan = new JComboBox();
		//lay danh sach tinh 
		ArrayList<Tinh> listTinh = Tinh.getDanhSachTS();
		comboBox_QueQuan.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());;
			
		}
		comboBox_QueQuan.setBounds(104, 382, 139, 21);
		contentPane.add(comboBox_QueQuan);
		
		JLabel lblNgaySinh = new JLabel("<html>Ngày sinh</br>\r\n(dd/mm/yy)<html>");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgaySinh.setBounds(10, 415, 84, 34);
		contentPane.add(lblNgaySinh);
		
//		// Tạo đối tượng SimpleDateFormat với định dạng "dd/MM/yyyy"
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//		// Tạo đối tượng MaskFormatter với ký tự đại diện là 'd', 'M', 'y'
//		MaskFormatter maskFormatter = null;
//		try {
//		    maskFormatter = new MaskFormatter("##/##/####");
//		    maskFormatter.setPlaceholderCharacter('_');
//		} catch (ParseException ex) {
//		    ex.printStackTrace();
//		}
//
//		// Tạo đối tượng JFormattedTextField với kiểu ngày tháng
//		JFormattedTextField dateField = new JFormattedTextField(dateFormat);
//		dateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new DateFormatter(dateFormat)));
//		dateField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(maskFormatter));
		
		txtNgaySinh = new JTextField();
//		txtNgaySinh.addFocusListener(focus);
//		txtNgaySinh.setText("dd/mm/yyyy");
//		txtNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(104, 425, 139, 19);
		contentPane.add(txtNgaySinh);
		
		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setBounds(410, 299, 70, 17);
		contentPane.add(lblGioiTinh);
		
		btnRadioNam = new JRadioButton("Nam");
		btnRadioNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRadioNam.setHorizontalAlignment(SwingConstants.CENTER);
		btnRadioNam.setBounds(486, 293, 103, 21);
		contentPane.add(btnRadioNam);
		
		btnRadioNu = new JRadioButton("Nữ");
		btnRadioNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRadioNu.setHorizontalAlignment(SwingConstants.CENTER);
		btnRadioNu.setBounds(555, 289, 103, 27);
		contentPane.add(btnRadioNu);
		
		//de chon duoc mot trong hai thoi
	    btnGioiTinh = new ButtonGroup();
		btnGioiTinh.add(btnRadioNam);
		btnGioiTinh.add(btnRadioNu);
		
		JLabel lblDiemMon1 = new JLabel("Điểm môn 1");
		lblDiemMon1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiemMon1.setBounds(410, 339, 84, 17);
		contentPane.add(lblDiemMon1);
		
		textFieldDiemMon1 = new JTextField();
//		textFieldDiemMon1.addFocusListener(focus);
		textFieldDiemMon1.setColumns(10);
		textFieldDiemMon1.setBounds(504, 339, 123, 19);
		contentPane.add(textFieldDiemMon1);
		
		JLabel lblDiemMon2 = new JLabel("Điểm môn 2\r\n");
		lblDiemMon2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiemMon2.setBounds(410, 381, 84, 17);
		contentPane.add(lblDiemMon2);
		
		textFieldDiemMon2 = new JTextField();
//		textFieldDiemMon2.addFocusListener(focus);
		textFieldDiemMon2.setColumns(10);
		textFieldDiemMon2.setBounds(504, 381, 123, 19);
		contentPane.add(textFieldDiemMon2);
		
		JLabel lblDiemMon3 = new JLabel("Điểm môn 3");
		lblDiemMon3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiemMon3.setBounds(410, 425, 96, 17);
		contentPane.add(lblDiemMon3);
		
		textFieldDiemMon3 = new JTextField();
//		textFieldDiemMon3.addFocusListener(focus);
		textFieldDiemMon3.setColumns(10);
		textFieldDiemMon3.setBounds(504, 425, 123, 19);
		contentPane.add(textFieldDiemMon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setForeground(Color.BLACK);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBackground(Color.GRAY);
		btnThem.setBounds(26, 468, 84, 35);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBackground(Color.GRAY);
		btnXoa.setBounds(205, 468, 84, 35);
		contentPane.add(btnXoa);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);
		btnCapNhat.setForeground(Color.BLACK);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBackground(Color.GRAY);
		btnCapNhat.setBounds(384, 468, 110, 35);
		contentPane.add(btnCapNhat);
		
		JButton btnHuy = new JButton("Xóa Form");
		btnHuy.addActionListener(action);
		btnHuy.setForeground(Color.BLACK);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuy.setBackground(Color.GRAY);
		btnHuy.setBounds(583, 468, 96, 35);
		contentPane.add(btnHuy);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 452, 717, 4);
		contentPane.add(separator_2);
		
		JButton btnHuyTim = new JButton("Hủy Tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setForeground(Color.BLACK);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHuyTim.setBackground(Color.GRAY);
		btnHuyTim.setBounds(634, 23, 93, 35);
		contentPane.add(btnHuyTim);
		
		this.setVisible(true);
	}
	
	//ham set thu tu tang dan theo cot stt
	public void sapXepTangDan(DefaultTableModel model, JTable table) {
		
		TableRowSorter sorter = new TableRowSorter(model);
	
//	    sorter.setComparator(1, Comparator.naturalOrder()); // Sắp xếp thứ tự tăng dần cho cột ID
	    table.setRowSorter(sorter);
	}
}
