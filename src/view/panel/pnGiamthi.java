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
import controller.pnGiamthiListener;
import controller.tableGiam_thiListener;
import dao.phong_thi_Dao;
import dao.giam_thi_Dao;

import java.awt.event.ActionListener;

import model.phong_thi;
import model.giam_thi;
import utils.resizeTableColumnWidth;
import utils.toast;

public class pnGiamthi extends JPanel {
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
	JTextField ma_giam_thiTF, ten_giam_thiTF, ngay_sinhTF, 
	dia_chiTF, chuc_vuTF;
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
	ArrayList<giam_thi> giam_thiList;
	public pnGiamthi() {
		this.setLayout(new BorderLayout());
		ActionListener acl = new pnGiamthiListener(this);
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
		pnFormTitle = new JLabel("Quản lý giám thị");
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
		pnFormInputSearchTitle.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/filter.png")));
		String filterFields[] = {"Không có", "Mã giám thị", "Tên giám thị",
				"Giới tính", "Ngày sinh", "Địa chỉ", "Chức vụ", "Mã phòng thi"};
		pnFormInputSearchCbb = new JComboBox<String>(filterFields);
		pnFormInputSearchCbb.setFont(new Font("Roboto", Font.PLAIN, 17));
		pnFormInputSearchCbb.setFocusable(false);
		pnFormInputSearchTextField = new JTextField(15);
		pnFormInputSearchTextField.setMargin(new Insets(4, 8, 4, 8));
		pnFormInputSearchBtn = new JButton(" Tìm kiếm");
		pnFormInputSearchBtn.setBackground(Color.white);
		pnFormInputSearchBtn.setFocusable(false);
		pnFormInputSearchBtn.setMargin(new Insets(4, 8, 4, 8));
		pnFormInputSearchBtn.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/search.png")));
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
		pnFITLeftLabel.add(new JLabel("Mã giám thị    "));
		pnFITLeftLabel.add(new JLabel("Tên giám thị    "));
		pnFITLeftLabel.add(new JLabel("Giới tính    "));
		pnFITLeftLabel.add(new JLabel("Ngày sinh   "));
		pnFITRightLabel.add(new JLabel("Địa chỉ    "));
		pnFITRightLabel.add(new JLabel("Chức vụ    "));
		pnFITRightLabel.add(new JLabel("Phòng thi    "));
		ma_giam_thiTF = new JTextField();
		ten_giam_thiTF = new JTextField();
		ma_giam_thiTF.setMargin(new Insets(0, 8, 0, 8));
		ten_giam_thiTF.setMargin(new Insets(0, 8, 0, 8));
		pnFITLeftTextField.add(ma_giam_thiTF);
		pnFITLeftTextField.add(ten_giam_thiTF);
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
		chuc_vuTF = new JTextField();
		dia_chiTF.setMargin(new Insets(0, 8, 0, 8));
		chuc_vuTF.setMargin(new Insets(0, 8, 0, 8));
		pnFITRightTextField.add(dia_chiTF);
		pnFITRightTextField.add(chuc_vuTF);
		ma_phong_thiCbb = new JComboBox<String>();
		ma_phong_thiCbb.setFocusable(false);
		ma_phong_thiCbb.addItem("Chọn phòng thi");
		ma_phong_thiFields = phong_thi_Dao.getInstance().readAll();
		for(phong_thi phong_thiItem : ma_phong_thiFields) {
			ma_phong_thiCbb.addItem(phong_thiItem.getMa_phong_thi());
			
		}
		pnFITRightTextField.add(ma_phong_thiCbb);
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
		pnFBCreate.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/plus.png")));
		pnFBUpdate.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/update.png")));
		pnFBDelete.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/delete.png")));
		pnFBClear.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/earse.png")));
		pnFBReset.setIcon(new ImageIcon(pnGiamthi.class.getResource("/assets/icons/refresh.png")));
		pnFormBtn.setBackground(Color.white);
		pnFormBtn.add(pnFBCreate);
		pnFormBtn.add(pnFBUpdate);
		pnFormBtn.add(pnFBDelete);
		pnFormBtn.add(pnFBClear);
		pnFormBtn.add(pnFBReset);
		//pnTable
		pnTableTitle = new JLabel("Danh sách giám thị");
		pnTableTitle.setForeground(Color.white);
		pnTableTitle.setBackground(Color.decode(variables.primaryColor));
		pnTableTitle.setFont(new Font("Roboto", Font.PLAIN, 16));
		pnTableTitle.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 8));
		dtm = new DefaultTableModel();
		String tableLabels[] = {"Mã giám thị", "Tên giám thị",
				"Giới tính", "Ngày sinh", "Địa chỉ", "Chức vụ", "Mã phòng thi"};
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
		tableGiam_thiListener tsl = new tableGiam_thiListener(this, table);
		table.addMouseListener(tsl);
		//get data from database
		giam_thiList = giam_thi_Dao.getInstance().readAll();
		renderData(dtm, giam_thiList);
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
	public void renderData(DefaultTableModel dtm, ArrayList<giam_thi> list) {
		dtm.setRowCount(0);
		int count = list.size();
		for (int i = 0; i < count; i++) {
			dtm.addRow(new String []{
				((giam_thi) list.get(i)).getMa_nguoi(),
				((giam_thi) list.get(i)).getTen_nguoi(),
				((giam_thi) list.get(i)).getGioi_tinh() == 1 ? "Nam" : "Nữ",
				((giam_thi) list.get(i)).getNgay_sinh(),
				((giam_thi) list.get(i)).getDia_chi(),
				((giam_thi) list.get(i)).getChuc_vu(),
				((giam_thi) list.get(i)).getMa_phong_thi(),
			});
		}
		resizeTableColumnWidth.rsz(table);
	}
	public void tableDataToForm(String ma_giam_thi, String ten_giam_thi, int gioi_tinh, String ngay_sinh, String dia_chi, String chuc_vu, String ma_phong_thi) {
		ma_giam_thiTF.setEnabled(false);
		pnFBCreate.setEnabled(false);
		ma_giam_thiTF.setText(ma_giam_thi);
		ten_giam_thiTF.setText(ten_giam_thi);
		if (gioi_tinh == 1) {
			maleRB.setSelected(true);
		}else {
			femaleRB.setSelected(true);
		}
		ngay_sinhTF.setText(ngay_sinh);
		dia_chiTF.setText(dia_chi);
		chuc_vuTF.setText(chuc_vu);
		if (ma_phong_thi.equals("Chưa có phòng thi")) {
			ma_phong_thiCbb.setSelectedIndex(0);
		} else {
			ma_phong_thiCbb.setSelectedItem(ma_phong_thi);
		}
	}
	public void search() {
		int searchFilter = pnFormInputSearchCbb.getSelectedIndex();
		String searchData = pnFormInputSearchTextField.getText().trim();
		if (searchData.equals("")) {
			toast.showMsg(this, "Alert", "Tìm kiếm không được để trống!", "warning");
		}else {
			ArrayList<giam_thi> searchGiam_thiList = giam_thi_Dao.getInstance().search(searchFilter, searchData);
			dtm.setRowCount(0);
			renderData(dtm, searchGiam_thiList);
		}
	}
	public void add() {
		giam_thi newGiam_thi = null;
		int gioi_tinh = 2;
		if (ma_giam_thiTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Mã giám thị không được để trống!", "warning");
		} else if (ten_giam_thiTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Tên giám thị không được để trống!", "warning");
		} else if (!maleRB.isSelected()&& !femaleRB.isSelected()) {
			toast.showMsg(this, "Alert", "Giới tính không được để trống!", "warning");
		} else if (ngay_sinhTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Ngày sinh không được để trống!", "warning");
		} else if (dia_chiTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Địa chỉ không được để trống!", "warning");
		} else if (chuc_vuTF.getText().trim().equals("")) {
			toast.showMsg(this, "Alert", "Chức vụ không được để trống!", "warning");
		} else if (ma_phong_thiCbb.getSelectedIndex()==0) {
			toast.showMsg(this, "Alert", "Mã phòng thi không được để trống!", "warning");
		} else {
			String ma_giam_thi = ma_giam_thiTF.getText().trim();
			String ten_giam_thi = ten_giam_thiTF.getText().trim();
			if (maleRB.isSelected()) {
				gioi_tinh = 1;
			} else if (femaleRB.isSelected()) {
				gioi_tinh = 0;
			}
			String ngay_sinh = ngay_sinhTF.getText().trim();
			String dia_chi = dia_chiTF.getText().trim();
			String chuc_vu = chuc_vuTF.getText().trim();
			String ma_phong_thi = ma_phong_thiCbb.getSelectedItem().toString();
			newGiam_thi = new giam_thi(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi);
		}
		if (newGiam_thi != null) {
			boolean giam_thiExist = false;
			giam_thiList = giam_thi_Dao.getInstance().readAll();
			ArrayList<String> ma_giam_thiList = giam_thi_Dao.getInstance().readAllMa_giam_thi();
			for (String ma_giam_thi : ma_giam_thiList)	{
				if(ma_giam_thi.equals(newGiam_thi.getMa_nguoi())) {
					giam_thiExist = true;
					toast.showMsg(this, "Alert", "Giám thị đã tồn tại!", "warning");
					break;
				}
			}
			if (!giam_thiExist) {
				int resultChange = giam_thi_Dao.getInstance().create(newGiam_thi);
				if (resultChange != 2) {
					toast.showMsg(this, "Alert", "Thêm giám thị thất bại!", "error");
				}else {
					ArrayList<giam_thi> newGiam_thiList = giam_thi_Dao.getInstance().readAll();
					renderData(dtm, newGiam_thiList);
				}
			}
		}
	}
	public void update () {
		giam_thi editGiam_thi = null;
		String ma_giam_thi = ma_giam_thiTF.getText();
		String ten_giam_thi = null, ma_phong_thi = null;
		int gioi_tinh = 2;
		String ngay_sinh = null, dia_chi = null, chuc_vu = null, to_hop = null;
		double diem_so1 = -1, diem_so2 = -1, diem_so3 = -1;
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			if (ten_giam_thiTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", "Tên không thể để trống", "Warning");
			} else if (!maleRB.isSelected() && !femaleRB.isSelected()) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (ngay_sinhTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (dia_chiTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Giới tính không thể để trống", "Warning");
			} else if (chuc_vuTF.getText().trim().equals("")) {
				toast.showMsg(this, "Alart", " Chức vụ không thể để trống", "Warning");
			} else if (ma_phong_thiCbb.getSelectedIndex()==0) {
				toast.showMsg(this, "Alert", "Mã phòng thi không được để trống!", "warning");
			} else {
				ten_giam_thi = ten_giam_thiTF.getText();
				if(maleRB.isSelected()) {
					gioi_tinh = 1;
				} else if (femaleRB.isSelected()) {
					gioi_tinh = 0;
				}
				ngay_sinh = ngay_sinhTF.getText().trim();
				dia_chi = dia_chiTF.getText().trim();
				chuc_vu = chuc_vuTF.getText().trim();
				ma_phong_thi = ma_phong_thiCbb.getSelectedItem().toString();
				editGiam_thi = new giam_thi(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi);
			}
			if (editGiam_thi != null) {
				boolean giam_thiNotChange = false;
				giam_thiList = giam_thi_Dao.getInstance().readAll();
				for(giam_thi giam_thi : giam_thiList) {
					System.out.println(giam_thi.getMa_phong_thi());
					System.out.println(ma_phong_thi);
					if(giam_thi.getTen_nguoi().equals(ten_giam_thi)&&
					   giam_thi.getGioi_tinh()== gioi_tinh &&
					   giam_thi.getNgay_sinh().equals(ngay_sinh)&&
					   giam_thi.getDia_chi().equals(dia_chi)&&
					   giam_thi.getChuc_vu().equals(chuc_vu)&&
					   giam_thi.getMa_phong_thi().equals(ma_phong_thi)
					   ) {
						giam_thiNotChange = true;
						toast.showMsg(this, "Alert", "Không có sự thay đổi nào đối với giám thị!", "warning");
						break;
					}
				}
				if (!giam_thiNotChange) {
					int resultChange = giam_thi_Dao.getInstance().update(editGiam_thi);
					if(resultChange != 2) {
						toast.showMsg(this, "Alert","Cập nhật giám thị lỗi", "warning");
					} else {
						ArrayList<giam_thi> newGiam_thiList = giam_thi_Dao.getInstance().readAll();
						renderData(dtm, newGiam_thiList);
					}
				}
			}
		} else {
			toast.showMsg(this, "Alert","Vui lòng chọn giám thị để cập nhật", "warning");
		}
	}
	public void delete() {
		giam_thi deleteGiam_thi = null;
		int selectedRow = table.getSelectedRow();
		if(selectedRow != -1) {
			String ma_giam_thi = table.getValueAt(selectedRow, 0).toString();
			deleteGiam_thi = new giam_thi(ma_giam_thi, "", 2, "", "", "", "");
			if(deleteGiam_thi != null) {
				boolean isConfirm = toast.showCfm(this, "Alert","Bạn có chắc chắn?");
				if(isConfirm) {
					int resultChange = giam_thi_Dao.getInstance().delete(deleteGiam_thi);
					if(resultChange != 1 ) {
						toast.showMsg(this, "Alert","Xóa giám thị bị lỗi", "warning");
					}else {
						ArrayList<giam_thi> newGiam_thiList = giam_thi_Dao.getInstance().readAll();
						renderData(dtm, newGiam_thiList);
					}
				}
			}
		} else {
			toast.showMsg(this, "Alert","Vui lòng chọn giám thị để xóa", "warning");
		}
	}
	public void clearForm() {
		ma_giam_thiTF.setEnabled(true);
		pnFBCreate.setEnabled(true);
		pnFormInputSearchCbb.setSelectedIndex(0);
		pnFormInputSearchTextField.setText("");
		ma_giam_thiTF.setText("");
		ten_giam_thiTF.setText("");
		groupGenderRadio.clearSelection();
		ngay_sinhTF.setText("");
		dia_chiTF.setText("");
		chuc_vuTF.setText("");
		ma_phong_thiCbb.setSelectedIndex(0);
		
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
		giam_thiList = giam_thi_Dao.getInstance().readAll();
		renderData(dtm, giam_thiList);
	}
	
}


