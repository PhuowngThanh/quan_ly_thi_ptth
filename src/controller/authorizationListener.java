package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.authorizationView;


public class authorizationListener implements ActionListener {
	private authorizationView authorizationViewV;
	
	public authorizationListener(authorizationView authorizationViewV) {
		this.authorizationViewV = authorizationViewV;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("LOGIN")) {
			authorizationViewV.pnLogin.authorizationLogin();
		}
	}

}