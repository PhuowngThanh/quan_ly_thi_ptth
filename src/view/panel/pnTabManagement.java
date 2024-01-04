package view.panel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import bases.variables;

public class pnTabManagement extends JPanel {
	// Init card Panel
	CardLayout cardLayout;
	JPanel pnThisinh, pnGiamthi;

	public pnTabManagement() {
		cardLayout = new CardLayout();
		this.setLayout(cardLayout);

		pnThisinh = new pnThisinh();
		pnGiamthi = new pnGiamthi();

		this.add(pnThisinh, "pnThisinh");
		this.add(pnGiamthi, "pnGiamthi");
	}

	public void showPnThisinh() {
		cardLayout.show(this, "pnThisinh");
	}

	public void showPnGiamthi() {
		cardLayout.show(this, "pnGiamthi");
	}
}
