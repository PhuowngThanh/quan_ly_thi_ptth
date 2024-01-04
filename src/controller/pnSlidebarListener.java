package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.tree.DefaultMutableTreeNode;

import view.panel.pnSlidebar;
import view.panel.pnTabManagement;

public class pnSlidebarListener implements MouseListener {
	private pnSlidebar pnSlidebarV;
	private pnTabManagement pnTabManagementV;
	public static String nodeStr = "";

	public pnSlidebarListener(pnSlidebar pnSlidebarV, pnTabManagement pnTabManagementV) {
		this.pnSlidebarV = pnSlidebarV;
		this.pnTabManagementV = pnTabManagementV;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = pnSlidebarV.tree.getLastSelectedPathComponent();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
		nodeStr = node != null ? node.toString() : "";
		switch (nodeStr) {
		case " Thí sinh":
			pnTabManagementV.showPnThisinh();
			break;
		case " Giám thị":
			pnTabManagementV.showPnGiamthi();
			break;
		default:
			pnTabManagementV.showPnThisinh();
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
