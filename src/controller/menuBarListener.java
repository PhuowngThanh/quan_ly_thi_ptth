package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.exportToExcel;
import view.mainView;

public class menuBarListener implements ActionListener {
	private mainView mainV;

	public menuBarListener(mainView mainV) {
		this.mainV = mainV;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(" Export data")) {
			exportToExcel.export();
		} else if (e.getActionCommand().equals(" Exit")) {
			System.exit(0);
		}

	}

}
