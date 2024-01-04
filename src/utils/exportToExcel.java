package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import controller.pnSlidebarListener;
import dao.giam_thi_Dao;
import dao.thi_sinh_Dao;
import model.giam_thi;
import model.thi_sinh;

public class exportToExcel {
	public static String path = "";
	static JFileChooser chooser = new JFileChooser();
	static String firstFileName = "thi-sinh";

	public static void export() {
		if (pnSlidebarListener.nodeStr.equals(" Thí sinh") || pnSlidebarListener.nodeStr.equals(" Trần Phương Thanh")
				|| pnSlidebarListener.nodeStr.equals("")) {
			firstFileName = "thi-sinh";
		} else if (pnSlidebarListener.nodeStr.equals(" Giám thị")) {
			firstFileName = "giam-thi";
		}
		File targetFile = null;
		if (targetFile != null) {
			chooser.setSelectedFile(targetFile);
		} else {
			chooser.setSelectedFile(new File(firstFileName + "-export.xls"));
		}
		int option = chooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			targetFile = chooser.getSelectedFile();
		}
		if (targetFile != null && targetFile.getAbsolutePath().endsWith(".xls")) {
			path = targetFile.toString();
		} else if (option != JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(chooser, "Chỉ chấp nhận .xls file", "Mesage", JOptionPane.WARNING_MESSAGE);
		}

		if (!path.equals("")) {
			try {
				HSSFWorkbook workbook = new HSSFWorkbook();
				if (pnSlidebarListener.nodeStr.equals(" Thí sinh")
						|| pnSlidebarListener.nodeStr.equals(" Trần Phương Thanh")
						|| pnSlidebarListener.nodeStr.equals("")) {
					HSSFSheet sheet = workbook.createSheet("Thí sinh");
					HSSFRow rowhead = sheet.createRow((short) 0);
					rowhead.createCell(0).setCellValue("Mã thí sinh");
					rowhead.createCell(1).setCellValue("Tên thí sinh");
					rowhead.createCell(2).setCellValue("Giới tính");
					rowhead.createCell(3).setCellValue("Ngày sinh");
					rowhead.createCell(4).setCellValue("Địa chỉ");
					rowhead.createCell(5).setCellValue("Khu vực");
					rowhead.createCell(6).setCellValue("Phòng thi");
					rowhead.createCell(7).setCellValue("Tổ hợp");
					rowhead.createCell(8).setCellValue("Điểm số 1");
					rowhead.createCell(9).setCellValue("Điểm số 2");
					rowhead.createCell(10).setCellValue("Điểm số 3");
					ArrayList<thi_sinh> thi_sinhList = thi_sinh_Dao.getInstance().readAll();
					int count = thi_sinhList.size();
					for (int i = 0; i < count; i++) {
						HSSFRow rowData = sheet.createRow((short) i + 1);
						rowData.createCell(0).setCellValue(thi_sinhList.get(i).getMa_nguoi());
						rowData.createCell(1).setCellValue(thi_sinhList.get(i).getTen_nguoi());
						rowData.createCell(2).setCellValue(thi_sinhList.get(i).getGioi_tinh() == 1 ? "Nam" : "Nữ");
						rowData.createCell(3).setCellValue(thi_sinhList.get(i).getNgay_sinh());
						rowData.createCell(4).setCellValue(thi_sinhList.get(i).getDia_chi());
						rowData.createCell(5).setCellValue(thi_sinhList.get(i).getDoi_tuong());
						rowData.createCell(6).setCellValue(thi_sinhList.get(i).getMa_phong_thi());
						rowData.createCell(7).setCellValue(thi_sinhList.get(i).getTo_hop());
						rowData.createCell(8).setCellValue(thi_sinhList.get(i).getDiem_so1());
						rowData.createCell(9).setCellValue(thi_sinhList.get(i).getDiem_so2());
						rowData.createCell(10).setCellValue(thi_sinhList.get(i).getDiem_so3());
					}
				} else if (pnSlidebarListener.nodeStr.equals(" Giám thị")) {
					HSSFSheet sheet = workbook.createSheet("Giám thị");
					HSSFRow rowhead = sheet.createRow((short) 0);
					rowhead.createCell(0).setCellValue("Mã giám thị");
					rowhead.createCell(1).setCellValue("Tên giám thị");
					rowhead.createCell(2).setCellValue("Giới tính");
					rowhead.createCell(3).setCellValue("Ngày sinh");
					rowhead.createCell(4).setCellValue("Địa chỉ");
					rowhead.createCell(5).setCellValue("Chức vụ");
					rowhead.createCell(6).setCellValue("Phòng thi");
					ArrayList<giam_thi> giam_thiList = giam_thi_Dao.getInstance().readAll();
					int count = giam_thiList.size();
					for (int i = 0; i < count; i++) {
						HSSFRow rowData = sheet.createRow((short) i + 1);
						rowData.createCell(0).setCellValue(giam_thiList.get(i).getMa_nguoi());
						rowData.createCell(1).setCellValue(giam_thiList.get(i).getTen_nguoi());
						rowData.createCell(2).setCellValue(giam_thiList.get(i).getGioi_tinh() == 1 ? "Nam" : "Nữ");
						rowData.createCell(3).setCellValue(giam_thiList.get(i).getNgay_sinh());
						rowData.createCell(4).setCellValue(giam_thiList.get(i).getDia_chi());
						rowData.createCell(5).setCellValue(giam_thiList.get(i).getChuc_vu());
						rowData.createCell(6).setCellValue(giam_thiList.get(i).getMa_phong_thi());
					}
				}
				FileOutputStream fileOut = new FileOutputStream(path);
				workbook.write(fileOut);
				fileOut.close();
				workbook.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
