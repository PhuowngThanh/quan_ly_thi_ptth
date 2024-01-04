package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.panel.pnGiamthi;

public class pnGiamthiListener implements ActionListener {
	private pnGiamthi pnGiamthiV;

	public pnGiamthiListener(pnGiamthi pnGiamthiV) {
		this.pnGiamthiV = pnGiamthiV;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case " Add":
			pnGiamthiV.add();
			break;
		case " Update":
			pnGiamthiV.update();
			break;
		case " Delete":
			pnGiamthiV.delete();
			break;
		case " Clear form":
			pnGiamthiV.clearForm();
			break;
		case " Reset data":
			pnGiamthiV.resetData();
			break;
		case " Search":
			pnGiamthiV.search();
			break;
		}
	}

}
