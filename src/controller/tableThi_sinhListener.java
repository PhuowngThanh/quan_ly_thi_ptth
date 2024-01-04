package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import model.thi_sinh;
import view.panel.pnThisinh;

public class tableThi_sinhListener implements MouseListener {
	private pnThisinh pnThi_sinhV;
	private JTable tableThi_sinhV;

	public tableThi_sinhListener(pnThisinh pnThi_sinhV, JTable tableThi_sinhV) {
		this.pnThi_sinhV = pnThi_sinhV;
		this.tableThi_sinhV = tableThi_sinhV;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = tableThi_sinhV.getSelectedRow();
		if (selectedRow != -1) {
			String ma_thi_sinh = tableThi_sinhV.getValueAt(selectedRow, 0).toString();
			String ten_thi_sinh = tableThi_sinhV.getValueAt(selectedRow, 1).toString();
			int gioi_tinh = tableThi_sinhV.getValueAt(selectedRow, 2).toString() == "Nam" ? 1 : 0;
			String ngay_sinh = tableThi_sinhV.getValueAt(selectedRow, 3).toString();
			String dia_chi = tableThi_sinhV.getValueAt(selectedRow, 4).toString();
			String doi_tuong = tableThi_sinhV.getValueAt(selectedRow, 5).toString();
			String to_hop = tableThi_sinhV.getValueAt(selectedRow, 6).toString();
			String ma_phong_thi = tableThi_sinhV.getValueAt(selectedRow, 7).toString();
			String diem_so1 = tableThi_sinhV.getValueAt(selectedRow, 8).toString();
			String diem_so2 = tableThi_sinhV.getValueAt(selectedRow, 9).toString();
			String diem_so3 = tableThi_sinhV.getValueAt(selectedRow, 10).toString();
			pnThi_sinhV.tableDataToForm(ma_thi_sinh, ten_thi_sinh, gioi_tinh, ngay_sinh, dia_chi, doi_tuong, to_hop, ma_phong_thi, diem_so1, diem_so2, diem_so3);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
