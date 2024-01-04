package view.panel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import bases.variables;
import dao.authorizationDao;
import model.user;
import quan_ly_thi_ptth.main;
import utils.regexCheck;
import utils.toast;


public class pnLogin extends JPanel {
	// boxForm init
	JPanel boxForm;
	
	// titleLogin init
	JLabel titleLogin;

	// boxUsername init
	JPanel boxEmail;
	JLabel emailLabel;
	JTextField emailTF;

	// boxPassword init
	JPanel boxPasword;
	JLabel passwordLabel;
	JPasswordField passwordTF;
	
	// boxBtn init
	JPanel boxBtn;
	public JButton btnLogin = new JButton("LOGIN");
	JPanel notHaveAccount;
	JLabel notHaveAccountLabel;

	public pnLogin() {
		this.setLayout(new BorderLayout());

		// boxForm
		boxForm = new JPanel(new GridLayout(4, 1));
		boxForm.setBorder(BorderFactory.createEmptyBorder(110, 60, 190, 60));
		boxForm.setBackground(Color.white);
		
		// titleLogin
		titleLogin = new JLabel("Login to system", SwingConstants.CENTER);
		titleLogin.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		titleLogin.setFont(new Font("Roboto", Font.BOLD, 36));
		titleLogin.setForeground(Color.decode(variables.primaryColor));
		
		// boxUsername
		boxEmail = new JPanel(new GridLayout(2, 1));
		boxEmail.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		boxEmail.setBackground(Color.white);
		emailLabel = new JLabel("Email");
		emailTF = new JTextField();
		emailTF.setFont(new Font("Roboto", Font.PLAIN, 16));
		emailTF.setMargin(new Insets(0, 8, 0, 8));
		boxEmail.add(emailLabel);
		boxEmail.add(emailTF);
		
		// boxPassword
		boxPasword = new JPanel(new GridLayout(2, 1));
		boxPasword.setBorder(BorderFactory.createEmptyBorder(-10, 0, 20, 0));
		boxPasword.setBackground(Color.white);
		passwordLabel = new JLabel("Pass");
		passwordTF = new JPasswordField();
		passwordTF.setMargin(new Insets(0, 8, 0, 8));
		boxPasword.add(passwordLabel);
		boxPasword.add(passwordTF);
		
		// boxBtn
		boxBtn = new JPanel(new GridLayout(2, 1, 0, 10));
		boxBtn.setBackground(Color.white);
		boxBtn.setPreferredSize(new Dimension(300, 30));
		btnLogin.setBackground(Color.white);
		btnLogin.setFocusable(false);
		btnLogin.setFont(new Font("Roboto", Font.BOLD, 16));
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.decode(variables.primaryColor));
		btnLogin.setOpaque(true);
		btnLogin.setBorderPainted(false);
		boxBtn.add(btnLogin);

		// Add component
		boxForm.add(titleLogin);
		boxForm.add(boxEmail);
		boxForm.add(boxPasword);
		boxForm.add(boxBtn);
		this.add(boxForm, BorderLayout.CENTER);
		JPanel xx1 = new JPanel();
		xx1.setBackground(Color.decode(variables.primaryColor));
		xx1.setPreferredSize(new Dimension(400, 100));
		JPanel xx2 = new JPanel();
		xx2.setBackground(Color.decode(variables.primaryColor));
		xx2.setPreferredSize(new Dimension(400, 100));
		this.add(xx1, BorderLayout.WEST);
		this.add(xx2, BorderLayout.EAST);
	}
	
	public void authorizationLogin() {
		user authorizationUser = null;
		String emailStr = emailTF.getText().trim();
		String passwordStr = new String(passwordTF.getPassword()).trim();
		if (emailStr.equals("")) {
			toast.showMsg(null, "Alert", "Email can't left blank!", "warning");
		} else if (passwordStr.equals("")) {
			toast.showMsg(null, "Alert", "Password can't left blank!", "warning");
		} else {
			authorizationUser = authorizationDao.getInstance().authorization(new user(emailStr, passwordStr));
			if (authorizationUser != null) {
				if (authorizationUser.getPass().equals("Wrong password!")) {
					toast.showMsg(null, "Alert", "Wrong password", "error");
				} else {
					main.user = authorizationUser;
					main.role = 6;
					main mainFrame = (main) SwingUtilities.getWindowAncestor(this);
		            mainFrame.handleLoginSuccess();
				}
			} else {
				toast.showMsg(null, "Alert", "User not found!", "warning");
			}
		}
	}
	
}