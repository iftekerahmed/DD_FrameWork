package dataDriven_01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Utilitis.ExcelUtil;

public class WriteExcelData {

	@Test
	public void WriteExcel() throws Exception {
		ExcelUtil obj = new ExcelUtil("C:\\Users\\Ifte\\elips2020\\DD_FrameWork\\TestData\\data.xlsx");

		obj.writeData(0, 2, "Pass");
		obj.writeData(1, 2, "to do ");
		obj.writeData(2, 2, "in progress");
		obj.writeData(3, 2, "fail");

	}

}
