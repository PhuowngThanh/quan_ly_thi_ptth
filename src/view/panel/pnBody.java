package view.panel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class pnBody extends JPanel {
	// init tab
	JTabbedPane tab;
	public static JPanel pnTabManagement = new pnTabManagement();
	JPanel pnTabAnalytic;

	public pnBody() {
		this.setLayout(new BorderLayout());

		// tab
		tab = new JTabbedPane();
		pnTabAnalytic = new pnTabAnalytic();
		tab.add(pnTabManagement, " Quản lý");
		tab.setIconAt(0, new ImageIcon(pnBody.class.getResource("/assets/icons/management.png")));
		tab.add(pnTabAnalytic, " Thống kê");
		tab.setIconAt(1, new ImageIcon(pnBody.class.getResource("/assets/icons/column-chart.png")));

		// Add component
		this.add(tab, BorderLayout.CENTER);

	}

}
