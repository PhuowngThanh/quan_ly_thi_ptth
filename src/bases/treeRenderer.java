package bases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class treeRenderer extends DefaultTreeCellRenderer {
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selectted, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {
		String nodeLabel = ((DefaultMutableTreeNode) value).toString();
		JLabel label = new JLabel(nodeLabel);
		label.setForeground(Color.white);
		label.setFont(new Font("Roboto", Font.PLAIN, 17));
		if (nodeLabel.equals(" Trần Phương Thanh")) {
			label.setIcon(new ImageIcon(treeRenderer.class.getResource("/assets/icons/tpt.png")));
		} else if (nodeLabel.equals(" Thí sinh")) {
			label.setIcon(new ImageIcon(treeRenderer.class.getResource("/assets/icons/student.png")));
		} else if (nodeLabel.equals(" Giám thị")) {
			label.setIcon(new ImageIcon(treeRenderer.class.getResource("/assets/icons/student.png")));
		}
		return label;

	}
}
