package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

import bases.treeRenderer;
import bases.variables;
import controller.pnSlidebarListener;

public class pnSlidebar extends JPanel {
	// Init tree
	public static JTree tree;
	DefaultMutableTreeNode root, nullNode1, nullNode2, nullNode3, nullNode4, tsManagement, gtManagement, ptManagement;

	// pnTabManagement
	pnTabManagement pnTabManagement;

	public pnSlidebar() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.white);
		pnTabManagement = (pnTabManagement) pnBody.pnTabManagement;
		pnSlidebarListener ml = new pnSlidebarListener(this, pnTabManagement);

		// Tree
		root = new DefaultMutableTreeNode(" Trần Phương Thanh");
		tree = new JTree(root);
		tree.setCellRenderer(new treeRenderer());
		nullNode1 = new DefaultMutableTreeNode();
		nullNode2 = new DefaultMutableTreeNode();
		tsManagement = new DefaultMutableTreeNode(" Thí sinh");
		gtManagement = new DefaultMutableTreeNode(" Giám thị");
		root.add(nullNode1);
		root.add(tsManagement);
		root.add(nullNode2);
		root.add(gtManagement);
		expandAllNodes(tree, 0, tree.getRowCount());
		tree.addMouseListener(ml);
		// add compoment
		this.add(tree, BorderLayout.CENTER);
		this.setBackground(Color.decode(variables.primaryColorDark));
		tree.setBackground(Color.decode(variables.primaryColorDark));

	}

	// method to expand all nodes of tree
	private void expandAllNodes(JTree tree, int startingIndex, int rowCount) {
		for (int i = startingIndex; i < rowCount; i++) {
			tree.expandRow(i);
		}
		if (tree.getRowCount() != rowCount) {
			expandAllNodes(tree, rowCount, tree.getRowCount());

		}
	}

}
