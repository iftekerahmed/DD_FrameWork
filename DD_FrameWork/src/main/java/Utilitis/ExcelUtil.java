package Utilitis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	XSSFSheet sheet1;
	File src;
	XSSFWorkbook wb;

	public ExcelUtil(String excel_path) throws Exception {

		src = new File(excel_path);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		// String data1 = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
		// sheet1 = wb.getSheetAt(0);

	}

	public String getData(String sheetname, int rownum, int colnum) {

		String data1 = sheet1.getRow(rownum).getCell(colnum).getStringCellValue();
		return data1;
	}

	public String getData(String sheetname, int rownum, String colname) {

		int index = wb.getSheetIndex(sheetname);
		sheet1 = wb.getSheetAt(index);
		XSSFRow row = sheet1.getRow(0);
		int colnum = 1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colname.trim())) {
				colnum = i;
			}

		}

		String data1 = sheet1.getRow(rownum).getCell(colnum).getStringCellValue();
		return data1;
	}

	public void writeData(int rownum, int colnum, String value) throws Exception {

		sheet1.getRow(rownum).createCell(colnum).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
	}

	public void writeData(String sheetname, int rownum, String colnam, String value) throws Exception {
		int index = wb.getSheetIndex(sheetname);
		sheet1 = wb.getSheetAt(index);
		XSSFRow row = sheet1.getRow(0);
		int colnum = 1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colnam.trim()))
				colnum = i;

		}

		sheet1.getRow(rownum).createCell(colnum).setCellValue(value);

		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
	}

	public void createSheet(String sheetname) throws Exception {

		wb.createSheet(sheetname);

		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);

	}

	public int getsheetIndex(String sheetname) throws Exception {

		int sheetindex = wb.getSheetIndex(sheetname);

		return sheetindex;

	}

	public void removesheetIndex(int sheetindex) throws Exception {

		wb.removeSheetAt(sheetindex);
		FileOutputStream fout = new FileOutputStream(src);// we need to pass the remove sheet name
		wb.write(fout);
	}

	public String getData(int sheetindex, int rownum, int colnum) {
		String data1 = sheet1.getRow(rownum).getCell(colnum).getStringCellValue();
		return data1;
	}
public int rowCount (String sheetname) {
	
	int index = wb.getSheetIndex(sheetname);
	sheet1= wb.getSheetAt(index);
	int rownum = sheet1.getLastRowNum();
	return (rownum+1) ;
	
}
}
