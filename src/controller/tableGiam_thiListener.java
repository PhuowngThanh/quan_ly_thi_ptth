package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import model.giam_thi;
import view.panel.pnGiamthi;
import view.panel.pnThisinh;

public class tableGiam_thiListener implements MouseListener {
	private pnGiamthi pnGiam_thiV;
	private JTable tableGiam_thiV;

	public tableGiam_thiListener(pnGiamthi pnGiam_thiV, JTable tableGiam_thiV) {
		this.pnGiam_thiV = pnGiam_thiV;
		this.tableGiam_thiV = tableGiam_thiV;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = tableGiam_thiV.getSelectedRow();
		if (selectedRow != -1) {
			String ma_giam_thi = tableGiam_thiV.getValueAt(selectedRow, 0).toString();
			String ten_giam_thi = tableGiam_thiV.getValueAt(selectedRow, 1).toString();
			int gioi_tinh = tableGiam_thiV.getValueAt(selectedRow, 2).toString() == "Nam" ? 1 : 0;
			String ngay_sinh = tableGiam_thiV.getValueAt(selectedRow, 3).toString();
			String dia_chi = tableGiam_thiV.getValueAt(selectedRow, 4).toString();
			String chuc_vu = tableGiam_thiV.getValueAt(selectedRow, 5).toString();
			String ma_phong_thi = tableGiam_thiV.getValueAt(selectedRow, 6).toString();
			pnGiam_thiV.tableDataToForm(ma_giam_thi, ten_giam_thi, gioi_tinh, ngay_sinh, dia_chi, chuc_vu, ma_phong_thi);
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
