package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Renderer;
import javax.swing.table.DefaultTableModel;

import bases.variables;
import controller.pnThisinhListener;
import controller.tableThi_sinhListener;
import dao.phong_thi_Dao;
import dao.thi_sinh_Dao;

import java.awt.event.ActionListener;

import model.phong_thi;
import model.thi_sinh;
import utils.resizeTableColumnWidth;
import utils.toast;

public class pnThisinh extends JPanel {
	//Init splitPane
	JSplitPane splitPane;
	Dimension minimumSize;
	//Init pnForm
	JLabel pnFormTitle;
	JPanel pnForm;
	JSplitPane formSplitPane;
	Dimension minimumSize2;
	JPanel pnFormInput, pnFormBtn;
	//Init pnFormInput
	JPanel pnFormInputSearch, pnFormInputText;
	//Init pnFormInputSearch
	JLabel pnFormInputSearchTitle;
	JComboBox<String> pnFormInputSearchCbb;
	JTextField pnFormInputSearchTextField;
	JButton pnFormInputSearchBtn;
	//Init pnFormInputText
	JPanel pnFITLeft, pnFITRight,
	pnFITLeftLabel, pnFITRightLabel,
	pnFITLeftTextField, pnFITRightTextField;
	JTextField ma_thi_sinhTF, ten_thi_sinhTF, ngay_sinhTF, 
	dia_chiTF, khu_vucTF, diem_so1TF, diem_so2TF, diem_so3TF;
	JComboBox<String> to_hopCbb;
	ArrayList<phong_thi> ma_phong_thiFields;
	JComboBox<String> ma_phong_thiCbb;
	JRadioButton maleRB, femaleRB;
	ButtonGroup groupGenderRadio;
	JPanel pnGenderRadio;
	//Init pnFormBtn
	JButton pnFBCreate, pnFBUpdate, pnFBDelete, pnFBClear, pnFBReset;
	//Init pnTable
	JLabel pnTableTitle;
	JPanel pnTable;
	DefaultTableModel dtm;
	JTable table;
	JScrollPane scrp;
	ArrayList<thi_sinh> thi_sinhList;
	public pnThisinh() {
		this.setLayout(new BorderLayout());
		ActionListener acl = new pnThisinhListener(this);
		//splitPane
		pnForm = new JPanel(new BorderLayout());
		pnForm.setBackground(Color.decode(variables.primaryColor));
		pnTable = new JPanel(new BorderLayout());
		pnTable.setBackground(Color.decode(variables.primaryColor));
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnForm, pnTable);
		splitPane.setDividerLocation(400);
		splitPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		splitPane.setEnabled(false);
		minimumSize = new Dimension(400, 0);
		pnForm.setMinimumSize(minimumSize);
		pnTable.setMinimumSize(minimumSize);
		//pnForm
		pnFormTitle = new JLabel("Quản lý thí sinh");
		pnFormTitle.setForeground(Color.white);
		pnFormTitle.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 0));
		pnFormInput = new JPanel(new BorderLayout());
		pnFormInput.setBackground(Color.decode(variables.primaryColor));
		pnFormBtn = new JPanel(new GridLayout(5, 1, 0, 22));
		pnFormBtn.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		formSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnFormInput, pnFormBtn);
		formSplitPane.setDividerLocation(900);
		formSplitPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		formSplitPane.setEnabled(false);
		minimumSize2 = new Dimension(900, 0);
		pnForm.setMinimumSize(minimumSize2);
		pnTable.setMinimumSize(minimumSize2);
		//pnFormInput
		pnFormInputSearch = new JPanel(new FlowLayout());
		pnFormInputSearch.setBackground(Color.white);
		pnFormInputSearch.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		pnFormInputText = new JPanel(new GridLayout(1, 2, 20, 0));
		pnFormInputText.setBackground(Color.white);
		pnFormInputText.setBorder(BorderFactory.createEmptyBorder(15, 15, 70, 15));
		//pnFormInputSearch
		pnFormInputSearchTitle = new JLabel("Bộ lọc ");
		pnFormInputSearchTitle.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/filter.png")));
		String filterFields[] = {"Không có", "Mã thí sinh", "Tên thí sinh",
				"Giới tính", "Ngày sinh", "Địa chỉ", "Khu vực", "Tổ hợp", "Điểm số"};
		pnFormInputSearchCbb = new JComboBox<String>(filterFields);
		pnFormInputSearchCbb.setFont(new Font("Roboto", Font.PLAIN, 17));
		pnFormInputSearchCbb.setFocusable(false);
		pnFormInputSearchTextField = new JTextField(15);
		pnFormInputSearchTextField.setMargin(new Insets(4, 8, 4, 8));
		pnFormInputSearchBtn = new JButton(" Tìm kiếm");
		pnFormInputSearchBtn.setBackground(Color.white);
		pnFormInputSearchBtn.setFocusable(false);
		pnFormInputSearchBtn.setMargin(new Insets(4, 8, 4, 8));
		pnFormInputSearchBtn.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/search.png")));
		pnFormInputSearch.add(pnFormInputSearchTitle);
		pnFormInputSearch.add(pnFormInputSearchCbb);
		pnFormInputSearch.add(pnFormInputSearchTextField);
		pnFormInputSearch.add(pnFormInputSearchBtn);
		//pnFormInputText
		pnFITLeft = new JPanel(new BorderLayout());
		pnFITRight = new JPanel(new BorderLayout());
		pnFITLeftLabel = new JPanel(new GridLayout(6, 1, 0, 10));
		pnFITRightLabel = new JPanel(new GridLayout(6, 1, 0, 10));
		pnFITLeftTextField = new JPanel(new GridLayout(6, 1, 0, 10));
		pnFITRightTextField = new JPanel(new GridLayout(6, 1, 0, 10));
		pnFITLeftLabel.add(new JLabel("Mã thí sinh    "));
		pnFITLeftLabel.add(new JLabel("Tên thí sinh    "));
		pnFITLeftLabel.add(new JLabel("Giới tính    "));
		pnFITLeftLabel.add(new JLabel("Ngày sinh   "));
		pnFITLeftLabel.add(new JLabel("Địa chỉ    "));
		pnFITLeftLabel.add(new JLabel("Khu vực    "));
		pnFITRightLabel.add(new JLabel("Phòng thi    "));
		pnFITRightLabel.add(new JLabel("Tổ hợp    "));
		pnFITRightLabel.add(new JLabel("Điểm môn 1    "));
		pnFITRightLabel.add(new JLabel("Điểm môn 2    "));
		pnFITRightLabel.add(new JLabel("Điểm môn 3    "));
		ma_thi_sinhTF = new JTextField();
		ten_thi_sinhTF = new JTextField();
		ma_thi_sinhTF.setMargin(new Insets(0, 8, 0, 8));
		ten_thi_sinhTF.setMargin(new Insets(0, 8, 0, 8));
		pnFITLeftTextField.add(ma_thi_sinhTF);
		pnFITLeftTextField.add(ten_thi_sinhTF);
		maleRB = new JRadioButton("Nam");
		femaleRB = new JRadioButton("Nữ");
		maleRB.setFocusable(false);
		femaleRB.setFocusable(false);
		groupGenderRadio = new ButtonGroup();
		groupGenderRadio.add(maleRB);
		groupGenderRadio.add(femaleRB);
		pnGenderRadio = new JPanel(new FlowLayout(ABORT));
		pnGenderRadio.add(maleRB);
		pnGenderRadio.add(femaleRB);
		pnFITLeftTextField.add(pnGenderRadio);
		ngay_sinhTF = new JTextField();
		ngay_sinhTF.setMargin(new Insets(0, 8, 0, 8));
		pnFITLeftTextField.add(ngay_sinhTF);
		dia_chiTF = new JTextField();
		khu_vucTF = new JTextField();
		dia_chiTF.setMargin(new Insets(0, 8, 0, 8));
		khu_vucTF.setMargin(new Insets(0, 8, 0, 8));
		pnFITLeftTextField.add(dia_chiTF);
		pnFITLeftTextField.add(khu_vucTF);
		ma_phong_thiCbb = new JComboBox<String>();
		ma_phong_thiCbb.setFocusable(false);
		ma_phong_thiCbb.addItem("Chọn phòng thi");
		ma_phong_thiFields = phong_thi_Dao.getInstance().readAll();
		for(phong_thi phong_thiItem : ma_phong_thiFields) {
			ma_phong_thiCbb.addItem(phong_thiItem.getMa_phong_thi());
			
		}
		to_hopCbb = new JComboBox<String>();
		to_hopCbb.setFocusable(false);
		to_hopCbb.addItem("Chọn tổ hợp");
		to_hopCbb.addItem("Tự Nhiên");
		to_hopCbb.addItem("Xã Hội");
		diem_so1TF = new JTextField();
		diem_so2TF = new JTextField();
		diem_so3TF = new JTextField();
		diem_so1TF.setMargin(new Insets(0, 8, 0, 8));
		diem_so2TF.setMargin(new Insets(0, 8, 0, 8));
		diem_so3TF.setMargin(new Insets(0, 8, 0, 8));
		pnFITRightTextField.add(ma_phong_thiCbb);
		pnFITRightTextField.add(to_hopCbb);
		pnFITRightTextField.add(diem_so1TF);
		pnFITRightTextField.add(diem_so2TF);
		pnFITRightTextField.add(diem_so3TF);
		pnFITLeft.add(pnFITLeftLabel, BorderLayout.WEST);
		pnFITLeft.add(pnFITLeftTextField, BorderLayout.CENTER);
		pnFITRight.add(pnFITRightLabel, BorderLayout.WEST);
		pnFITRight.add(pnFITRightTextField, BorderLayout.CENTER);
		pnFormInputText.add(pnFITLeft);
		pnFormInputText.add(pnFITRight);
		pnFITLeftLabel.setBackground(Color.white);
		pnFITLeftTextField.setBackground(Color.white);
		pnGenderRadio.setBackground(Color.white);
		maleRB.setBackground(Color.white);
		femaleRB.setBackground(Color.white);
		pnFITRightLabel.setBackground(Color.white);
		pnFITRightTextField.setBackground(Color.white);
		//pnFormInput
		pnFormInput.add(pnFormInputSearch,BorderLayout.NORTH);
		pnFormInput.add(pnFormInputText,BorderLayout.CENTER);
		//pnFormBtn
		pnFBCreate = new JButton(" Add");
		pnFBUpdate = new JButton(" Update");
		pnFBDelete = new JButton(" Delete");
		pnFBClear = new JButton(" Clear form");
		pnFBReset = new JButton(" Reset data");
		pnFBCreate.setBackground(Color.white);
		pnFBUpdate.setBackground(Color.white);
		pnFBDelete.setBackground(Color.white);
		pnFBClear.setBackground(Color.white);
		pnFBReset.setBackground(Color.white);
		pnFBCreate.setFocusable(false);
		pnFBUpdate.setFocusable(false);
		pnFBDelete.setFocusable(false);
		pnFBClear.setFocusable(false);
		pnFBReset.setFocusable(false);
		pnFBCreate.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/plus.png")));
		pnFBUpdate.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/update.png")));
		pnFBDelete.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/delete.png")));
		pnFBClear.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/earse.png")));
		pnFBReset.setIcon(new ImageIcon(pnThisinh.class.getResource("/assets/icons/refresh.png")));
		pnFormBtn.setBackground(Color.white);
		pnFormBtn.add(pnFBCreate);
		pnFormBtn.add(pnFBUpdate);
		pnFormBtn.add(pnFBDelete);
		pnFormBtn.add(pnFBClear);
		pnFormBtn.add(pnFBReset);
		//pnTable
		pnTableTitle = new JLabel("Danh sách thí sinh");
		pnTableTitle.setForeground(Color.white);
		pnTableTitle.setBackground(Color.decode(variables.primaryColor));
		pnTableTitle.setFont(new Font("Roboto", Font.PLAIN, 16));
		pnTableTitle.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 8));
		dtm = new DefaultTableModel();
		String tableLabels[] = {"Mã thí sinh", "Tên thí sinh",
				"Giới tính", "Ngày sinh", "Địa chỉ", "Khu vực", "Tổ hợp","Phòng thi", "Điểm số 1", "Điểm số 2", "Điểm số 3"};
		for (String tableLabelText : tableLabels) {
			dtm.addColumn(tableLabelText);
		}
		table = new JTable(dtm);
		table.setRowHeight(24);
		table.setGridColor(Color.decode(variables.lightGray));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.decode(variables.primaryColorLight));
		table.setRowHeight(29);
		scrp = new JScrollPane(table);
		tableThi_sinhListener tsl = new tableThi_sinhListener(this, table);
		table.addMouseListener(tsl);
		//get data from database
		thi_sinhList = thi_sinh_Dao.getInstance().readAll();
		renderData(dtm, thi_sinhList);
		//add pnStudentListener
		pnFormInputSearchBtn.addActionListener(acl);
		pnFBCreate.addActionListener(acl);
		pnFBUpdate.addActionListener(acl);
		pnFBDelete.addActionListener(acl);
		pnFBClear.addActionListener(acl);
		pnFBReset.addActionListener(acl);
		//add component
		pnForm.add(pnFormTitle, BorderLayout.NORTH);
		pnForm.add(formSplitPane, BorderLayout.CENTER);
		pnTable.add(pnTableTitle, BorderLayout.NORTH);
		pnTable.add(scrp, BorderLayout.CENTER);
		this.add(splitPane);
	}
	public void renderData(DefaultTableModel dtm, ArrayList<thi_sinh> list) {
		dtm.setRowCount(0);
		int count = list.size();
		for (int i = 0; i < count; i++) {
			dtm.addRow(new String []{
				((thi_sinh) list.get(i)).getMa_nguoi(),
				((thi_sinh) list.get(i)).getTen_nguoi(),
				((thi_sinh) list.get(i)).getGioi_tinh() == 1 ? "Nam" : "Nữ",
				((thi_sinh) list.get(i)).getNgay_sinh(),
				((thi_sinh) list.get(i)).getDia_chi(),
				((thi_sinh) list.get(i)).getDoi_tuong(),
				((thi_sinh) list.get(i)).getTo_hop(),
				((thi_sinh) list.get(i)).getMa_phong_thi(),
				((thi_sinh) list.get(i)).getDiem_so1()+"",
				((thi_sinh) list.get(i)).getDiem_so2()+"",
				((thi_sinh) list.get(i)).getDiem_so3()+""
			});
		}
		resizeTableColumnWidth.rsz(table);
	}
	public void tableDataToForm(String ma_thi_sinh, String ten_thi_sinh, int gioi_tinh, String ngay_sinh, String dia_chi, String khu_vuc, String to_hop, String ma_phong_thi, String diem_so1, String diem_so2, String diem_so3) {
		ma_thi_sinhTF.setEnabled(false);
		pnFBCreate.setEnabled(false);
		ma_thi_sinhTF.setText(ma_thi_sinh);
		ten_thi_sinhTF.setText(ten_thi_sinh);
		if (gioi_tinh == 1) {
			maleRB.setSelected(true);
		}else {
			femaleRB.setSelected(true);
		}
		ngay_sinhTF.setText(ngay_sinh);
		dia_chiTF.setText(dia_chi);
		khu_vucTF.setText(khu_vuc);
		ma_phong_thiCbb.setSelectedItem(ma_phong_thi);
		to_hopCbb.setSelectedItem(to_hop);
		diem_so1TF.setText(diem_so1);
		diem_so2TF.setText(diem_so2);
		diem_so3TF.setText(diem_so3);
	}
	public void search() {
		int searchFilter = pnFormInputSearchCbb.getSelectedIndex();
		String searchData = pnFormInputSearchTextField.getText().trim();
		if (searchData.equals("")) {
			toast.showMsg(this, "Alert", "Tìm kiếm không được để trống!", "warning");
		}else {
			ArrayList<thi_sinh> searchThi_sinhList = thi_sinh_Dao.getInstance().search(searchFilter, searchData);
			dtm.setRowCount(0);
			renderData(dtm, searchThi_sinhList);
		}
	}
	public void add() {
		thi_sinh newThi_sinh = null;
		int gioi_tinh = 2;
		if (ma_thi_sinhTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Mã thí sinh không được để trống!", "warning");
		} else if (ten_thi_sinhTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Tên thí sinh không được để trống!", "warning");
		} else if (!maleRB.isSelected()&& !femaleRB.isSelected()) {
			toast.showMsg(this, "Alert", "Giới tính không được để trống!", "warning");
		} else if (ngay_sinhTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Ngày sinh không được để trống!", "warning");
		} else if (dia_chiTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Địa chỉ không được để trống!", "warning");
		} else if (khu_vucTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Khu vực không được để trống!", "warning");
		} else if (ma_phong_thiCbb.getSelectedIndex()==0) {
			toast.showMsg(this, "Alert", "Mã phòng thi không được để trống!", "warning");
		} else if (to_hopCbb.getSelectedIndex()==0) {
			toast.showMsg(this, "Alert", "Tổ hợp không được để trống!", "warning");
		} else if (diem_so1TF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Điểm số 1 không được để trống!", "warning");
		} else if (diem_so2TF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Điểm số 2 không được để trống!", "warning");
		} else if (diem_so3TF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Điểm số 3 không được để trống!", "warning");
		} else {
			String ma_thi_sinh = ma_thi_sinhTF.getText().trim();
			String ten_thi_sinh = ten_thi_sinhTF.getText().trim();
			if (maleRB.isSelected()) {
				gioi_tinh = 1;
			} else if (femaleRB.isSelected()) {
				gioi_tinh = 0;
			}
			String ngay_sinh = ngay_sinhTF.getText().trim();
			String dia_chi = dia_chiTF.getText().trim();
			String khu_vuc = khu_vucTF.getText().trim();
			String to_hop = to_hopCbb.getSelectedItem().toString();
			String ma_phong_thi = ma_phong_thiCbb.getSelectedItem().toString();
			double diem_so1 = Double.parseDouble(diem_so1TF.getText().trim());
			double diem_so2 = Double.parseDouble(diem_so2TF.getText().trim());
			double diem_so3 = Double.parseDouble(diem_so3TF.getText().trim());
			newThi_sinh = new thi_sinh(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, khu_vuc, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3);
		}
		if (newThi_sinh != null) {
			boolean thi_sinhExist = false;
			thi_sinhList = thi_sinh_Dao.getInstance().readAll();
			ArrayList<String> ma_thi_sinhList = thi_sinh_Dao.getInstance().readAllMa_thi_sinh();
			for (String ma_thi_sinh : ma_thi_sinhList)	{
				if(ma_thi_sinh.equals(newThi_sinh.getMa_nguoi())) {
					thi_sinhExist = true;
					toast.showMsg(this, "Alert", "Thí sinh đã tồn tại!", "warning");
					break;
				}
			}
			if (!thi_sinhExist) {
				int resultChange = thi_sinh_Dao.getInstance().create(newThi_sinh);
				if (resultChange != 2 && resultChange != 3) {
					toast.showMsg(this, "Alert", "Thêm thí sinh thất bại!", "error");
				}else {
					ArrayList<thi_sinh> newThi_sinhList = thi_sinh_Dao.getInstance().readAll();
					renderData(dtm, newThi_sinhList);
				}
			}
		}
	}
	public void update () {
		thi_sinh editThi_sinh = null;
		String ma_thi_sinh = ma_thi_sinhTF.getText();
		String ten_thi_sinh = null, ma_phong_thi = null;
		int gioi_tinh = 2;
		String ngay_sinh = null, dia_chi = null, khu_vuc = null, to_hop = null;
		double diem_so1 = -1, diem_so2 = -1, diem_so3 = -1;
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			if (ten_thi_sinhTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", "Tên không thể để trống", "Warning");
			} else if (!maleRB.isSelected() && !femaleRB.isSelected()) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (ngay_sinhTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (dia_chiTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (khu_vucTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Khu vực không thể để trống", "Warning");
			} else if (ma_phong_thiCbb.getSelectedIndex()==0) {
				toast.showMsg(this, "Alert", "Mã phòng thi không được để trống!", "warning");
			} else if (to_hopCbb.getSelectedIndex()==0) {
				toast.showMsg(this, "Alart", " Tổ hợp không thể để trống", "Warning");
			} else if (Double.parseDouble(diem_so1TF.getText().trim())== -1 ) {
				toast.showMsg(this, "Alert", "Điểm số 1 không được để trống!", "warning");
			} else if (Double.parseDouble(diem_so2TF.getText().trim())== -1) {
				toast.showMsg(this, "Alert", "Điểm số 2 không được để trống!", "warning");
			} else if (Double.parseDouble(diem_so3TF.getText().trim())== -1) {
				toast.showMsg(this, "Alert", "Điểm số 3 không được để trống!", "warning");
			} else {
				ten_thi_sinh = ten_thi_sinhTF.getText();
				if(maleRB.isSelected()) {
					gioi_tinh = 1;
				} else if (femaleRB.isSelected()) {
					gioi_tinh = 0;
				}
				ngay_sinh = ngay_sinhTF.getText().trim();
				dia_chi = dia_chiTF.getText().trim();
				khu_vuc = khu_vucTF.getText().trim();
				to_hop = to_hopCbb.getSelectedItem().toString();
				ma_phong_thi = ma_phong_thiCbb.getSelectedItem().toString();
				diem_so1 = Double.parseDouble(diem_so1TF.getText().trim());
				diem_so2 = Double.parseDouble(diem_so2TF.getText().trim());
				diem_so3 = Double.parseDouble(diem_so3TF.getText().trim());
				editThi_sinh = new thi_sinh(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, khu_vuc, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3);
			}
			if (editThi_sinh != null) {
				boolean thi_sinhNotChange = false;
				thi_sinhList = thi_sinh_Dao.getInstance().readAll();
				for(thi_sinh thi_sinh : thi_sinhList) {
					if(thi_sinh.getTen_nguoi().equals(ten_thi_sinh)&&
					   thi_sinh.getGioi_tinh()== gioi_tinh &&
					   thi_sinh.getNgay_sinh().equals(ngay_sinh)&&
					   thi_sinh.getDia_chi().equals(dia_chi)&&
					   thi_sinh.getDoi_tuong().equals(khu_vuc)&&
					   thi_sinh.getTo_hop().equals(to_hop)&&
					   thi_sinh.getDiem_so1() == diem_so1 &&
					   thi_sinh.getDiem_so2()== diem_so2 &&
					   thi_sinh.getDiem_so3() == diem_so3 &&
					   thi_sinh.getMa_phong_thi().equals(ma_phong_thi)
					   ) {
						thi_sinhNotChange = true;
						toast.showMsg(this, "Alert", "Không có sự thay đổi nào đối với thí sinh!", "warning");
						break;
					}
				}
				if (!thi_sinhNotChange) {
					int resultChange = thi_sinh_Dao.getInstance().update(editThi_sinh);
					if(resultChange != 2) {
						toast.showMsg(this, "Alert","Cập nhật thí sinh lỗi", "warning");
					} else {
						ArrayList<thi_sinh> newThi_sinhList = thi_sinh_Dao.getInstance().readAll();
						renderData(dtm, newThi_sinhList);
					}
				}
			}
		} else {
			toast.showMsg(this, "Alert","Vui lòng chọn thí sinh để cập nhật", "warning");
		}
	}
	public void delete() {
		thi_sinh deleteThi_sinh = null;
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			String ma_thi_sinh = table.getValueAt(selectedRow, 0).toString();
			deleteThi_sinh = new thi_sinh(ma_thi_sinh, "", 2, "", "", "", "", "", -1, -1, -1);
			if(deleteThi_sinh != null) {
				boolean isConfirm = toast.showCfm(this, "Alert","Bạn có chắc chắn?");
				if(isConfirm) {
					int resultChange = thi_sinh_Dao.getInstance().delete(deleteThi_sinh);
					if(resultChange != 1 ) {
						toast.showMsg(this, "Alert","Xóa thí sinh bị lỗi", "warning");
					}else {
						ArrayList<thi_sinh> newThi_sinhList = thi_sinh_Dao.getInstance().readAll();
						renderData(dtm, newThi_sinhList);
					}
				}
			}
		} else {
			toast.showMsg(this, "Alert","Vui lòng chọn thí sinh để xóa", "warning");
		}
	}
	public void clearForm() {
		ma_thi_sinhTF.setEnabled(true);
		pnFBCreate.setEnabled(true);
		pnFormInputSearchCbb.setSelectedIndex(0);
		pnFormInputSearchTextField.setText("");
		ma_thi_sinhTF.setText("");
		ten_thi_sinhTF.setText("");
		groupGenderRadio.clearSelection();
		ngay_sinhTF.setText("");
		dia_chiTF.setText("");
		khu_vucTF.setText("");
		ma_phong_thiCbb.setSelectedIndex(0);
		to_hopCbb.setSelectedIndex(0);
		diem_so1TF.setText("");
		diem_so2TF.setText("");
		diem_so3TF.setText("");
		
	}
	public void resetData() {
		clearForm();
		dtm.setRowCount(0);
		ma_phong_thiCbb.removeAllItems();
		ma_phong_thiCbb.addItem("Chọn phòng thi");
		ma_phong_thiFields = phong_thi_Dao.getInstance().readAll();
		for(phong_thi phong_thiItem : ma_phong_thiFields) {
			ma_phong_thiCbb.addItem(phong_thiItem.getMa_phong_thi());
			
		}
		to_hopCbb.removeAllItems();
		to_hopCbb.addItem("Chọn tổ hợp");
		to_hopCbb.addItem("Tự nhiên");
		to_hopCbb.addItem("Xã hội");
		thi_sinhList = thi_sinh_Dao.getInstance().readAll();
		renderData(dtm, thi_sinhList);
	}
	
}

