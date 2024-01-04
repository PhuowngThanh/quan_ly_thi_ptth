package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bases.variables;
import controller.authorizationListener;
import view.panel.pnLogin;

public class authorizationView extends JPanel {
	static JPanel pnForm;
	static CardLayout cardLayout;
	public pnLogin pnLogin = new pnLogin();
	
	public authorizationView() {
	    this.setLayout(new BorderLayout());
	    
	    // Handle change form
		ActionListener acl = new authorizationListener(this);
		
		// Handle main task
		pnLogin.btnLogin.addActionListener(acl);
		
		// pnForm
		pnForm = new JPanel();
		cardLayout = new CardLayout();
		pnForm.setLayout(cardLayout);
		pnForm.add(pnLogin, "pnLogin");
		
		// Add component
		this.add(pnForm, BorderLayout.CENTER);
	}
	
	public static void showPnLogin() {
		cardLayout.show(pnForm, "pnLogin");
	}
	
}