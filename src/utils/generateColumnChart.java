package utils;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import bases.variables;

public class generateColumnChart extends JPanel {
	public ChartPanel chartPanel;
	private CategoryDataset dataset;
	private static ArrayList dataChart;
	public JFreeChart chart;

	public void gnrt(String title, ArrayList dataChartInput) {
		dataChart = dataChartInput;
		dataset = createDataset();
		chart = ChartFactory.createBarChart(title, "", "", dataset, PlotOrientation.VERTICAL, true, true, false);
		chartPanel = new ChartPanel(chart);
		applyChartTheme(chart);
		CategoryPlot plot = chart.getCategoryPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		plot.setBackgroundPaint(Color.white);
		plot.setRangeGridlinePaint(Color.gray);
		plot.setOutlineVisible(false);
		renderer.setGradientPaintTransformer(null);
		renderer.setBarPainter(new StandardBarPainter());
		renderer.setSeriesPaint(0, Color.decode("#A07f9e"));
		renderer.setSeriesPaint(1, Color.decode("#7175a2"));
	}

	private static CategoryDataset createDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		int count = ((ArrayList) dataChart.get(0)).size();
		for (int i = 0; i < count; i++) {
			String phong_thi = (String) ((ArrayList) dataChart.get(0)).get(i);
			int slThi_sinh = Integer.parseInt((String) ((ArrayList) dataChart.get(1)).get(i));
			double diemtb = Double.parseDouble((String) ((ArrayList) dataChart.get(2)).get(i));
			dataset.addValue(slThi_sinh, "Thí sinh", phong_thi);
			dataset.addValue(diemtb, "Điểm trung bình", phong_thi);
		}
		return dataset;
	}

	public static void applyChartTheme(JFreeChart chart) {
		final StandardChartTheme chartTheme = (StandardChartTheme) org.jfree.chart.StandardChartTheme
				.createJFreeTheme();
		final Font extraLargeFont = new Font("Roboto", Font.PLAIN, 19);
		final Font largeFont = new Font("Roboto", Font.PLAIN, 17);
		final Font regularFont = new Font("Roboto", Font.PLAIN, 16);
		final Font smallFont = new Font("Roboto", Font.PLAIN, 15);
		chartTheme.setExtraLargeFont(extraLargeFont);
		chartTheme.setLargeFont(largeFont);
		chartTheme.setRegularFont(regularFont);
		chartTheme.setSmallFont(smallFont);
		chartTheme.apply(chart);
	}

	public static void exportToPng(int type, JFreeChart chartInput) {
		String chartSavePath = "D:\\eclipse-workspace\\quan_ly_thi_ptth\\src\\assets\\images\\chart-1.png";

		try {
			ChartUtils.saveChartAsPNG(new File(chartSavePath), chartInput, 1040, 800);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
