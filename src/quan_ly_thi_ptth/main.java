package quan_ly_thi_ptth;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import bases.variables;
import connection.dbConnector;
import dao.giam_thi_Dao;
import dao.phong_thi_Dao;
import dao.thi_sinh_Dao;
import model.giam_thi;
import model.phong_thi;
import model.thi_sinh;
import model.user;
import view.authorizationView;
import view.mainView;

public class main extends JFrame {
	public static int role = -2;
	public static user user = null;
	JPanel pnNorth = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();
	JPanel pnEast = new JPanel();
	public main() {
		super("Chương trình quản lý thi PTTH");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// giao diện window
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//đặt phông chữ
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		Font font14 = new Font("Roboto", Font.PLAIN, 14);
		Font font15 = new Font("Roboto", Font.PLAIN, 15);
		Font font16 = new Font("Roboto", Font.PLAIN, 16);
		defaults.put("Label.font", font16);
		defaults.put("Menu.font", font15);
		defaults.put("MenuItem.font", font15);
		defaults.put("TabbedPane.font", font16);
		defaults.put("Table.font", font14);
		defaults.put("ComboBox.font", font15);
		defaults.put("TextField.font", font15);
		defaults.put("Button.font", font16);
		defaults.put("RadioButton.font", font15);
		defaults.put("TableHeader.font", font15);
		//xử lý chính
		showLoginView();
		// đặt thuộc tính cho giao diện
		this.setIconImage(new ImageIcon(main.class.getResource("/assets/icons/icon.png")).getImage());
		this.setSize(1366,768);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	private void showLoginView() {
		// Container layout init
	    getContentPane().setLayout(new BorderLayout());
	    getContentPane().add(pnNorth, BorderLayout.NORTH);
	    getContentPane().add(pnSouth, BorderLayout.SOUTH);
	    getContentPane().add(pnWest, BorderLayout.WEST);
	    getContentPane().add(pnEast, BorderLayout.EAST);
	    pnNorth.setBackground(Color.decode(variables.primaryColorLight));
	    pnSouth.setBackground(Color.decode(variables.primaryColorLight));
	    pnWest.setBackground(Color.decode(variables.primaryColorLight));
	    pnEast.setBackground(Color.decode(variables.primaryColorLight));
	    authorizationView x = new authorizationView();
		getContentPane().add(x);
	}
	
	public void handleLoginSuccess() {
		if (role >= 0) {
			// Remove all in container
			getContentPane().removeAll();
			// Container layout reinit
		    getContentPane().setLayout(new BorderLayout());
		    getContentPane().add(pnNorth, BorderLayout.NORTH);
		    getContentPane().add(pnSouth, BorderLayout.SOUTH);
		    getContentPane().add(pnWest, BorderLayout.WEST);
		    getContentPane().add(pnEast, BorderLayout.EAST);
		    // change main border bg
		    pnNorth.setBackground(Color.decode(variables.primaryColorDark));
		    pnSouth.setBackground(Color.decode(variables.primaryColorDark));
		    pnWest.setBackground(Color.decode(variables.primaryColorDark));
		    pnEast.setBackground(Color.decode(variables.primaryColorDark));
            getContentPane().add(new mainView());
			this.setJMenuBar(mainView.menuBar);
			// Refresh frame
			revalidate();
	        repaint();
        }
	}
	public static void main(String[] args) {
		new main();
	}

}
