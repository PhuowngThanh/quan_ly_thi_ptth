package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.panel.pnThisinh;

public class pnThisinhListener implements ActionListener {
	private pnThisinh pnThisinhV;
	public pnThisinhListener(pnThisinh pnThisinhV) {
		this.pnThisinhV = pnThisinhV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case " Add":
			pnThisinhV.add();
			break;
		case " Update":
			pnThisinhV.update();
			break;
		case " Delete":
			pnThisinhV.delete();
			break;
		case " Clear form":
			pnThisinhV.clearForm();
			break;
		case " Reset data":
			pnThisinhV.resetData();
			break;
		case " Tìm kiếm":
			pnThisinhV.search();
			break;
		}
	}

}
