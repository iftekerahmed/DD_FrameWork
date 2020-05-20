package dataDriven_01;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readExcelData2 {
	@Test
	public void readData() throws Exception {
		
		File src = new File("C:\\Users\\Ifte\\elips2020\\DD_FrameWork\\TestData\\data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		//String data1 = wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
		XSSFSheet sheet1= wb.getSheetAt(0);
		//System.out.println(sheet1);
		int rownum =	sheet1.getLastRowNum();
		System.out.println(rownum+1);
		
		for (int i =0;i <rownum+1; i ++) {
			String data1= sheet1.getRow(i).getCell(0).getStringCellValue();
			System.out.println(data1);
		}
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
