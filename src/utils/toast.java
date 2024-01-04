package utils;

import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class toast {
	private static Runnable runnable = (Runnable) Toolkit.getDefaultToolkit()
			.getDesktopProperty("win.sound.exclamation");

	public static void showMsg(JPanel jp, String title, String content, String type) {
		if (runnable != null)
			runnable.run();
		switch (type) {
		case "success":
		case "info":
			JOptionPane.showMessageDialog(jp, content, title, JOptionPane.INFORMATION_MESSAGE);
			break;
		case "warning":
			JOptionPane.showMessageDialog(jp, content, title, JOptionPane.INFORMATION_MESSAGE);
			break;
		case "error":
			JOptionPane.showMessageDialog(jp, content, title, JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			break;
		}
	}

	public static boolean showCfm(JPanel jp, String title, String content) {
		if (runnable != null)
			runnable.run();
		int result = JOptionPane.showConfirmDialog(jp, content, title, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			return true;
		} else {
			return false;
		}
	}

}
