package view.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import bases.variables;
import controller.pnAnalyticListener;
import dao.analyticDao;
import utils.exportAnalyticReport;
import utils.generateColumnChart;
import utils.generatePieChart;

public class pnTabAnalytic extends JPanel{
	JPanel pnBtn;
	JButton exportBtn, refreshBtn;
	JPanel pnTotal, pnTBTN, pnTBXH, pnTotalThi_sinh, pnTotalGiam_thi;
	double TBTN, TBXH;
	
	JPanel pnChart;
	private static generateColumnChart chart1;
	private static generatePieChart chart2;
	ArrayList<?> dataChart1, dataChart2;
	String titleChart1 = "Số lượng thí sinh, điểm trung bình trong mỗi phòng thi";
	String titleChart2 = "Xếp loại";
	
	public pnTabAnalytic() {
		this.setLayout(new BorderLayout());
		ActionListener acl = new pnAnalyticListener(this);
		
		pnBtn = new JPanel(new FlowLayout(SwingConstants.RIGHT));
		pnBtn.setBackground(Color.white);
		exportBtn = new JButton(" Export report");
		exportBtn.setBackground(Color.white);
		exportBtn.setFocusable(false);
		exportBtn.setIcon(new ImageIcon(pnTabAnalytic.class.getResource("/assets/icons/out.png")));
		exportBtn.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
		refreshBtn = new JButton(" Refresh");
		refreshBtn.setBackground(Color.white);
		refreshBtn.setFocusable(false);
		refreshBtn.setIcon(new ImageIcon(pnTabAnalytic.class.getResource("/assets/icons/refresh.png")));
		refreshBtn.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
		pnBtn.add(exportBtn);
		pnBtn.add(refreshBtn);
		exportBtn.addActionListener(acl);
		refreshBtn.addActionListener(acl);
		
		pnTotal = new JPanel(new GridLayout(1, 4));
		pnTotal.setBackground(Color.white);
		pnTotal.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
		pnTBTN = new JPanel();
		pnTBTN.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		pnTBTN.setBackground(Color.decode(variables.primaryColorLight));
		pnTBXH = new JPanel();
		pnTBXH.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		pnTBXH.setBackground(Color.decode(variables.primaryColorLight));
		pnTotalThi_sinh = new JPanel();
		pnTotalThi_sinh.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		pnTotalThi_sinh.setBackground(Color.decode(variables.primaryColorLight));
		pnTotalGiam_thi = new JPanel();
		pnTotalGiam_thi.setBorder(BorderFactory.createLineBorder(Color.white, 10));
		pnTotalGiam_thi.setBackground(Color.decode(variables.primaryColorLight));
		pnTotal.add(pnTBTN);
		pnTotal.add(pnTBXH);
		pnTotal.add(pnTotalThi_sinh);
		pnTotal.add(pnTotalGiam_thi);
		
		pnChart = new JPanel(new GridLayout(1, 3));
		pnChart.setPreferredSize(new Dimension(0, 480));
		pnChart.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
		pnChart.setBackground(Color.white);
		chart1 = new generateColumnChart();
		chart2 = new generatePieChart();
		
		renderData();
		pnChart.add(chart1.chartPanel);
		pnChart.add(generatePieChart.chartPanel);
		
		this.add(pnBtn, BorderLayout.NORTH);	
		this.add(pnTotal, BorderLayout.CENTER);	
		this.add(pnChart, BorderLayout.SOUTH);
				
	}
	public void renderData() {
		TBTN = analyticDao.getTBTN();
		TBXH = analyticDao.getTBXH();
		pnTBTN.add(new JLabel("<html><p style= 'text-align: center; font-size:20px; margin-top: 6px'>TB Tự Nhiên<br>"+ "<b>"+TBTN+"</b></html>"));
		pnTBXH.add(new JLabel("<html><p style= 'text-align: center; font-size:20px; margin-top: 6px'>TB Xã Hội<br>"+ "<b>"+TBXH+"</b></html>"));
		pnTotalThi_sinh.add(new JLabel("<html><p style= 'text-align: center; font-size:20px; margin-top: 6px'>Tổng thí sinh<br>"+ "<b>"+analyticDao.getTotalThi_sinh()+"</b></html>"));
		pnTotalGiam_thi.add(new JLabel("<html><p style= 'text-align: center; font-size:20px; margin-top: 6px'>Tổng giám thị<br>"+ "<b>"+analyticDao.getTotalGiam_thi()+"</b></html>"));
		
		dataChart1 = analyticDao.getTSGTMPT();
		dataChart2 = analyticDao.getScoreRate();
		chart1.gnrt(titleChart1, dataChart1);
		chart2.gnrt(titleChart2, dataChart2);
	}
	public void refreshData() {
		pnTBTN.removeAll();
		pnTBXH.removeAll();
		pnTotalThi_sinh.removeAll();
		pnTotalGiam_thi.removeAll();

		pnChart.removeAll();

		pnTBTN.revalidate();
		pnTBXH.revalidate();
		pnTotalThi_sinh.revalidate();
		pnTotalGiam_thi.revalidate();
		
		pnChart.revalidate();
		pnChart.add(chart1.chartPanel);
		pnChart.add(chart2.chartPanel);
		pnChart.add(generatePieChart.chartPanel);
	}
	public static void export() {
		generateColumnChart.exportToPng(1, chart1.chart);
		generatePieChart.exportToPng(2);
		
		exportAnalyticReport.export();
	}

}
