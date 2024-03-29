package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class exportAnalyticReport {
	public static String path = "";
	static JFileChooser chooser = new JFileChooser();
	
	public static void export() {
		Document document = new Document();
		try {
			File targetFile = null;
			if(targetFile != null) {
				chooser.setSelectedFile(targetFile);
			} else {
				chooser.setSelectedFile(new File("analytic-report.pdf"));
			}
			int option = chooser.showSaveDialog(null);
			if(option == JFileChooser.APPROVE_OPTION) {
				targetFile = chooser.getSelectedFile();
			}
			if(targetFile != null && targetFile.getAbsolutePath().endsWith(".pdf")) {
				path = targetFile.toString();
			}else if(option != JFileChooser.CANCEL_OPTION) {
				JOptionPane.showMessageDialog(chooser, "Only allow .pdf file", "Message", JOptionPane.WARNING_MESSAGE);
			}
			PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
			
			BaseFont titleFont = null;
			BaseFont contentFont = null;
			String pathFont ="";
			try {
				titleFont = BaseFont.createFont(pathFont + "Roboto-Medium.ttf", BaseFont.WINANSI, true);
				contentFont = BaseFont.createFont(pathFont + "Roboto-Medium.ttf", BaseFont.WINANSI, true);
			}catch (IOException e) {
				e.printStackTrace();
			}
			Paragraph paragraph1 = new Paragraph();
			Phrase phrase1 = new Phrase(".");
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			Font font = new Font(titleFont, 17, Font.NORMAL);
			paragraph1.setFont(font);
			paragraph1.add(phrase1);
			Paragraph paragraph2 = new Paragraph();
			Phrase phrase2 = new Phrase(".");
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			paragraph1.setSpacingBefore(8);
			Font font2 = new Font(titleFont, 20, Font.BOLD);
			font2.setColor(BaseColor.BLUE);
			paragraph2.setFont(font);
			paragraph2.add(phrase2);
			Date utilDate = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.UK);
			String timestamp = dateFormat.format(utilDate.getTime());
			Paragraph paragraph3 = new Paragraph();
			Phrase phrase3 = new Phrase("Time: "+timestamp);
			paragraph3.setAlignment (Element.ALIGN_CENTER);
			paragraph3.setSpacingBefore(4);
			Font font3 = new Font(titleFont, 17, Font.NORMAL);
			font3.setColor(BaseColor.GRAY);
			paragraph3.setFont(font3);
			paragraph3.add(phrase3);
			Paragraph paragraph4 = new Paragraph();
//			double totalRefvenue = analyticDao.getTotalRevenue();
			NumberFormat nf = NumberFormat.getCurrencyInstance();
//			String TotalRevenueStr = nf.format(totalRefvenue);
//			Phrase phrase4 = new Phrase("Analytic:\n" + "- Total revenue: " + TotalRevenueStr + "VDN\n") + "- Total student: " + annalyticDao.getTotalStudent() + "\n" + "- Total revenue: " + annalyticDao.getTotalStudent() + "\n");
			paragraph4.setMultipliedLeading(Float.parseFloat("1.5"));
			paragraph4.setAlignment(Element.ALIGN_LEFT);
			paragraph4.setSpacingBefore(35);
			Font font4 = new Font(titleFont, 17, Font.NORMAL);
			paragraph4.setFont(font4);
//			paragraph4.add(phrase4);
			Paragraph paragraph5 = new Paragraph();
			
			Phrase phrase5 = new Phrase("Chart:\n");
			paragraph5.setAlignment(Element.ALIGN_LEFT);
			paragraph5.setSpacingBefore(35);
			paragraph5.setFont(font4);
			paragraph5.add(phrase5);
			
			String path = "";
			Image image1 = null;
			Image image2 = null;
			Image image3 = null;
			try {
				image1 = Image.getInstance(path + "1.png");
				image2 = Image.getInstance(path + "2.png");
				image3 = Image.getInstance(path + "3.png");
			}catch (MalformedURLException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			image1.scaleToFit(500, 400);
			image2.scaleToFit(500, 400);
			image3.scaleToFit(500, 400);
			
			document.add(paragraph1);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph4);
			document.add(paragraph5);
			document.add(image1);
			document.add(image2);
			document.add(image3);
			
			document.close();		
		}catch(DocumentException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
